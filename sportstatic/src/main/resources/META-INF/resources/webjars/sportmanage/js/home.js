var manage_home = {
	temp : {
		paths : [],
		lastcode : ''
	},
	index : function() {

		ReactDOM.render(React.createElement("div", {
			className : 'form-horizontal'
		}, 'abc'), document.getElementById(zstatic_config.id_main));

		this.page();

	},

	page : function(sPageUrl) {

		zstatic_api.api_call('zooweb/post/webpath', {

		}, manage_home.page_success

		);

	},
	page_success : function(oData) {

		manage_home.temp.paths = oData.pathInfos;
		manage_home.path_show();

	},

	path_show : function() {
		var aPathLi = [];
		for ( var i in manage_home.temp.paths) {
			var oItem = manage_home.temp.paths[i];

			// class="glyphicon glyphicon-th" aria-hidden="true"

			var sLiClass = '';
			var sAClass = '';
			var aHref;
			if (oItem["code"].length <= 16) {

				sLiClass = "active";

				var aSpan = React
						.createElement(
								"span",
								{
									className : 'w_ml_05 glyphicon glyphicon-chevron-down pull-right'
								});

				aHref = React.createElement("a", {
					className : 'w_mr_05',
					href : 'javascript:manage_home.path_nav()'
				}, oItem["nodeName"], aSpan);

			} else {
				sAClass = 'btn btn-default';

				var aSpan = React.createElement("span", {
					className : 'w_mr_05 glyphicon ' + oItem["pageIcon"]
				});

				aHref = React.createElement("a", {
					className : sAClass,
					href : 'javascript:manage_home.page_href("' + oItem["code"]
							+ '","' + oItem["pageUrl"] + '")',
					'id' : oItem["code"]
				}, aSpan, oItem["nodeName"]);
			}

			var aLi = React.createElement("li", {
				className : sLiClass
			}, aHref);

			aPathLi.push(aLi);

		}

		ReactDOM.render(React.createElement("ul", {
			className : "nav nav-sidebar"
		}, aPathLi), document.getElementById('manage_home_sidebar'));

		$.material.init();

	},

	page_href : function(sCode, sLink) {

		$('#' + manage_home.temp.lastcode).removeClass('w_bg_white');
		$('#' + sCode).addClass('w_bg_white');
		manage_home.temp.lastcode = sCode;
		zstatic_page.page(sLink);
	}

};
