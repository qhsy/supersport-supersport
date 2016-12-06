/*!
 * jQuery Cookie Plugin v1.4.1
 * https://github.com/carhartl/jquery-cookie
 *
 * Copyright 2013 Klaus Hartl
 * Released under the MIT license
 */
(function (factory) {
	if (typeof define === 'function' && define.amd) {
		// AMD
		define(['jquery'], factory);
	} else if (typeof exports === 'object') {
		// CommonJS
		factory(require('jquery'));
	} else {
		// Browser globals
		factory(jQuery);
	}
}(function ($) {

	var pluses = /\+/g;

	function encode(s) {
		return config.raw ? s : encodeURIComponent(s);
	}

	function decode(s) {
		return config.raw ? s : decodeURIComponent(s);
	}

	function stringifyCookieValue(value) {
		return encode(config.json ? JSON.stringify(value) : String(value));
	}

	function parseCookieValue(s) {
		if (s.indexOf('"') === 0) {
			// This is a quoted cookie as according to RFC2068, unescape...
			s = s.slice(1, -1).replace(/\\"/g, '"').replace(/\\\\/g, '\\');
		}

		try {
			// Replace server-side written pluses with spaces.
			// If we can't decode the cookie, ignore it, it's unusable.
			// If we can't parse the cookie, ignore it, it's unusable.
			s = decodeURIComponent(s.replace(pluses, ' '));
			return config.json ? JSON.parse(s) : s;
		} catch(e) {}
	}

	function read(s, converter) {
		var value = config.raw ? s : parseCookieValue(s);
		return $.isFunction(converter) ? converter(value) : value;
	}

	var config = $.cookie = function (key, value, options) {

		// Write

		if (value !== undefined && !$.isFunction(value)) {
			options = $.extend({}, config.defaults, options);

			if (typeof options.expires === 'number') {
				var days = options.expires, t = options.expires = new Date();
				t.setTime(+t + days * 864e+5);
			}

			return (document.cookie = [
				encode(key), '=', stringifyCookieValue(value),
				options.expires ? '; expires=' + options.expires.toUTCString() : '', // use expires attribute, max-age is not supported by IE
				options.path    ? '; path=' + options.path : '',
				options.domain  ? '; domain=' + options.domain : '',
				options.secure  ? '; secure' : ''
			].join(''));
		}

		// Read

		var result = key ? undefined : {};

		// To prevent the for loop in the first place assign an empty array
		// in case there are no cookies at all. Also prevents odd result when
		// calling $.cookie().
		var cookies = document.cookie ? document.cookie.split('; ') : [];

		for (var i = 0, l = cookies.length; i < l; i++) {
			var parts = cookies[i].split('=');
			var name = decode(parts.shift());
			var cookie = parts.join('=');

			if (key && key === name) {
				// If second argument (value) is a function it's a converter...
				result = read(cookie, value);
				break;
			}

			// Prevent storing a cookie that we couldn't decode.
			if (!key && (cookie = read(cookie)) !== undefined) {
				result[name] = cookie;
			}
		}

		return result;
	};

	config.defaults = {};

	$.removeCookie = function (key, options) {
		if ($.cookie(key) === undefined) {
			return false;
		}

		// Must not alter options, thus extending a fresh object...
		$.cookie(key, '', $.extend({}, options, { expires: -1 }));
		return !$.cookie(key);
	};

}));






























/* jQuery Tree Multiselect v1.17.0 | (c) Patrick Tsai et al. | MIT Licensed */
!function(a){"use strict";function b(b){var c={allowBatchSelection:!0,collapsible:!0,enableSelectAll:!1,selectAllText:"Select All",unselectAllText:"Unselect All",freeze:!1,hideSidePanel:!1,onChange:null,onlyBatchSelection:!1,sectionDelimiter:"/",showSectionOnSelected:!0,sortable:!1,startCollapsed:!1};return a.extend({},c,b)}function c(b,c,e){function f(b,c){for(var d=g,e=0;e<b.length;++e){var f=b[e];if(d[f]||(d[f]=[]),d=d[f],e==b.length-1){d.push(c);break}f=b[e+1];for(var h=null,i=0;i<d.length;++i){var j=d[i];if(j.constructor!=s&&a.isPlainObject(j)&&j[f]&&"undefined"!=typeof j[f]){h=j;break}}if(h)d=h;else{var k=d.push({});d=d[k-1]}}}var g={};b.find("> option").each(function(){var b=a(this),c=b.attr("data-section").split(e.sectionDelimiter),d=b.val(),g=b.text(),h=b.attr("data-description"),i=b.attr("data-index"),j=new s(d,g,h,i);f(c,j)}),d(c,g)}function d(b,c){function e(b,c){var d=document.createElement("div");d.className="section";var e=document.createElement("div");return e.className="title",e.innerHTML=c,a(d).append(e),b.append(d),d}function f(b,c){var d=c.text,e=c.value,f=c.description,g=c.index,h=document.createElement("div");return h.className="item",a(h).text(d||e).attr({"data-value":e,"data-description":f,"data-index":g}),b.append(h),h}if(c.constructor==s)f(b,c);else if(a.isArray(c))for(var g=0;g<c.length;++g)d(b,c[g]);else for(var h in c)if(c.hasOwnProperty(h)){var i=a(e(b,h));d(i,c[h])}}function e(b){var c=a("<span class='description'>?</span>"),d=b.find("div.item[data-description!=''][data-description]");c.prependTo(d),a("div.item > span.description").unbind().mouseenter(function(){var b=a(this).parent(),c=b.attr("data-description"),d=document.createElement("div");d.className="temp-description-popup",d.innerHTML=c,d.style.position="absolute",b.append(d)}).mouseleave(function(){var b=a(this).parent();b.find("div.temp-description-popup").remove()})}function f(b,c){var d=a("<input />",{type:"checkbox"});c.freeze&&d.attr("disabled","disabled");var e=null;e=c.onlyBatchSelection?b.find("div.title"):c.allowBatchSelection?b.find("div.title, div.item"):b.find("div.item"),d.prependTo(e),b.find("input[type=checkbox]").click(function(a){a.stopPropagation()})}function g(b,c){var d=b.val();if(d){var e=c.find("div.item").filter(function(){var b=a(this);return-1!==d.indexOf(b.attr("data-value"))});e.find("> input[type=checkbox]").prop("checked",!0)}}function h(b){var c=b.find("div.title > input[type=checkbox]");c.change(function(){var b=a(this),c=b.closest("div.section"),d=c.find("input[type=checkbox]"),e=b.is(":checked");d.prop("checked",e)})}function i(b){var c=b.find("input[type=checkbox]");c.change(function(){var c=a(this);if(!c.is(":checked")){var d=c.parentsUntil(b,"div.section");d.find("> div.title > input[type=checkbox]").prop("checked",!1)}})}function j(b){function c(){var c=b.find("div.section");c.each(function(){var b=a(this),c=b.find("div.item"),d=c.filter(function(){var b=a(this).find("> input[type=checkbox]");return!b.is(":checked")});if(0===d.length){var e=a(this).find("> div.title > input[type=checkbox]");e.prop("checked",!0)}})}p(b,c)}function k(b){function c(){var c=b.find("div.section");c.each(function(){var b=a(this),c=b.find("div.item"),d=c.filter(function(){var b=a(this);return b.find("> input[type=checkbox]").prop("checked")}).length,e=b.find("> div.title > input[type=checkbox]"),f=0!==d&&d!==c.length;e.prop("indeterminate",f)})}p(b,c)}function l(b,c){var d="-",e="+",f=b.find("div.title"),g=document.createElement("span");g.className="collapse-section",c.startCollapsed?(a(g).text(e),f.siblings().toggle()):a(g).text(d),f.prepend(g),a("span.collapse-section").unbind().click(function(b){b.stopPropagation();var c=a(this),f=c.text();c.text(f==d?e:d);var g=c.parent();g.siblings().toggle()}),f.click(function(){a(this).find("> span.collapse-section").trigger("click")})}function m(b,c){var d=a("<span class='select-all'></span>");d.text(c.selectAllText);var e=a("<span class='unselect-all'></span>");e.text(c.unselectAllText);var f=a("<div class='select-all-container'></div>");f.prepend(e),f.prepend(d),b.prepend(f);var g=b.find("div.item").find("> input[type=checkbox]");d.unbind().click(function(a){g.prop("checked",!0).change()}),e.unbind().click(function(a){g.prop("checked",!1).change()})}function n(b,c,d,e){function f(b){var d=b.text,f=b.value,g=b.sectionName,h=document.createElement("div");if(h.className="item",h.innerHTML=d,e.showSectionOnSelected){var i=a("<span class='section-name'></span>");i.text(g),a(h).append(i)}e.freeze||a(h).prepend("<span class='remove-selected'>×</span>"),a(h).attr("data-value",f).appendTo(c)}function g(d){var e=[];c.find("div.item").each(function(){e.push(a(this).attr("data-value"))});var g=d.filter(function(a){return-1==e.indexOf(a.value)});return g.forEach(function(a){f(a)}),o(b,c),g}function h(d){var e=[];d.forEach(function(a){e.push(a.value)});var f=[];c.find("div.item").each(function(b,c){var d=a(c),g=d.attr("data-value");-1==e.indexOf(g)&&(f.push(g),d.remove())});var g=[],h=b.find("div.item");return h.each(function(){var b=a(this);-1!==f.indexOf(b.attr("data-value"))&&g.push(j(b))}),g}function i(){var b=[];c.find("div.item").each(function(){b.push(a(this).attr("data-value"))}),d.val(b).change(),d.html(d.find("option").sort(function(c,d){var e=b.indexOf(a(c).attr("value")),f=b.indexOf(a(d).attr("value"));return e>f?1:f>e?-1:0}))}function j(c){var d=q(c),f=c.attr("data-value"),g=c.attr("data-index");c.attr("data-index",void 0);var h=a.map(c.parentsUntil(b,"div.section").get().reverse(),function(b){return q(a(b).find("> div.title"))}).join(e.sectionDelimiter);return{text:d,value:f,initialIndex:g,sectionName:h}}function k(){var d=b.find("div.item").has("> input[type=checkbox]:checked"),f=[];d.each(function(){var b=a(this);f.push(j(b))}),f.sort(function(a,b){var c=parseInt(a.initialIndex),d=parseInt(b.initialIndex);return c>d?1:d>c?-1:0});var k=g(f),m=h(f);i(),l?l=!1:e.onChange&&e.onChange(f,k,m),e.sortable&&!e.freeze&&c.sortable({update:function(a,b){i()}})}var l=!0;p(b,k)}function o(b,c){c.find("span.remove-selected").unbind().click(function(){var c=a(this).parent().attr("data-value"),d=b.find("div.item[data-value='"+c+"']"),e=d.find("> input[type=checkbox]");e.prop("checked",!1),e.change()})}function p(a,b){var c=a.find("input[type=checkbox]");c.change(function(){b()}),b()}function q(b){return a(b).clone().children().remove().end().text()}a.fn.treeMultiselect=function(d){var p=b(d);return this.each(function(){var b=a(this);b.attr("multiple","").css("display","none");var d=new r;d.build(b,p.hideSidePanel);var q=a(d.selections);c(b,q,p),e(q,p),f(q,p),g(b,q,p),p.allowBatchSelection&&(h(q,p),i(q,p),j(q,p),k(q,p)),p.collapsible&&l(q,p),p.enableSelectAll&&m(q,p);var s=a(d.selected);n(q,s,b,p),o(q,s,p)}),this};var r=function(){};r.prototype.build=function(b,c){var d=document.createElement("div");d.className="tree-multiselect",a(b).after(d);var e=document.createElement("div");e.className="selections",c&&(e.className+=" no-border"),a(d).append(e);var f=document.createElement("div");f.className="selected",c||a(d).append(f),this.tree=d,this.selections=e,this.selected=f};var s=function(a,b,c,d){this.value=a,this.text=b,this.description=c,this.index=d}}(jQuery);








