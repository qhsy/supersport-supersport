/**
 * API调用相关
 * 
 * 
 */

var zstatic_func = {

	format_replace : function(sInput, oReplace) {

		var re = new RegExp("\\[\\[(\\w*:\\w*)\\]\\]", "gi");
		var sReturn = sInput;
		if (sInput == undefined || sInput == null) {
			return sReturn;
		}

		var aExec = sReturn.match(re);

		if (aExec != null) {
			for (var i = 0; i < aExec.length; i++) {

				var sMathText = aExec[i];

				var aSplit = sMathText.replace('[[', '').replace(']]', '')
						.split(':');

				var sKeyName = aSplit[0];
				var sValueName = aSplit[1];

				if (oReplace[sKeyName] != undefined
						&& oReplace[sKeyName][sValueName] != undefined) {

					var reg = new RegExp("(\\[\\[)" + aSplit[0] + ":"
							+ aSplit[1] + "(\\]\\])", "g");

					sReturn = sReturn.replace(reg,
							oReplace[sKeyName][sValueName]);
				}

			}
		}
		// console.log(sReturn);

		return sReturn;

	},

	exist : function(sEle) {
		return document.getElementById(sEle) ? true : false;
	},

	clone : function(oldObject) {
		return jQuery.extend(true, {}, oldObject);
	},

	array_change : function(aArray, iOne, iTwo) {
		if (iOne < 0 || iTwo < 0 || iOne > aArray.length - 1
				|| iTwo > aArray.length - 1) {
			return aArray;
		}

		var sTemp = aArray[iOne];
		aArray[iOne] = aArray[iTwo];
		aArray[iTwo] = sTemp;
		return aArray;
	},

	map_from_url : function(sUrl) {

		var aItem = sUrl.split('&');
		var oReturn = {};
		for ( var i in aItem) {

			var aDetail = aItem[i].split('=');

			oReturn[aDetail[0]] = aDetail[1];
		}

		return oReturn;

	},

	string_split : function(sStr, sSplit) {
		var aReturn = [];

		if (sStr.length > 0) {
			aReturn = sStr.split(sSplit);
		}

		return aReturn;
	},

	url_query : function(sUrl, name) {

		var reg = new RegExp('(^|&|\\?)' + name + '=([^&]*)(&|$)', 'i');
		var r = sUrl.match(reg);

		if (r != null) {
			return unescape(r[2]);
		}
		return null;
	},

	json_parse : function(sStr) {
		return JSON.parse(sStr);
	},

	json_stringify : function(oObj) {
		return JSON.stringify(oObj);
	},

	js_exec : function(sJs) {
		var oReturn = {};

		if (sJs != undefined && sJs != null && sJs != '') {

			var zsttic_func_js_exec;
			eval('zsttic_func_js_exec=' + sJs);
			oReturn = zsttic_func_js_exec();

		}

		return oReturn;
	},

	check_https : function() {
		return 'https:' == document.location.protocol ? true : false;
	},

	// 获取图片缩略图
	up_image : function(sSource, iSize, iType) {
		var sSplit = sSource.split("/");

		// 定义是否启用https
		var bFlagHttps = zstatic_func.check_https();
		if (bFlagHttps) {
			if (sSource.indexOf('https://') > -1) {
				bFlagHttps = false;
			}
		}

		for (var i = 0, j = sSplit.length; i < j; i++) {

			if (sSplit[i].indexOf(".") > 0) {
				sSplit[i] = sSplit[i] + "/gm";
				break;
			}
		}

		if (!iType) {
			// 定义如果没有传type，则自动给一个默认的，服务器删除缓存文件时依据此编号删除 该参数仅用于标记
			iType = '2606';
		}

		var aFix = sSource.split(".");

		var sFix = aFix[aFix.length - 1];
		// sFix = 'webp';
		var sReturn = sSplit.join("/") + '_g_t' + iType + '_w' + iSize
				+ '_h9999.' + sFix;

		// 如果是https请求 则替换由服务器中转
		if (bFlagHttps) {
			var reg = new RegExp("http://.*?/", "gmi");
			sReturn = sReturn.replace(reg, '/');
			//alert(sReturn);
		}

		return sReturn;
	},
	// Cookie
	cookie : function(key, value, options) {

		if (value !== undefined) {
			if (!options) {
				options = {};
			}

			// options.path = "/";

			// if (!options.expires) options.expires = 0;

		}

		return $.cookie(key, value, options);
	}

};
