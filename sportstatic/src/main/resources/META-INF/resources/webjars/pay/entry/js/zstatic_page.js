var zstatic_page = {

	temp : {

		// 本地缓存的页面结构
		pall : {},

		// 当前页面的链接
		purl : '',
		// 页面链接数组
		pagearray : [],
		// 本地数据缓存
		datacache : {},
		// 查询条件缓存
		querycache : {},
		// 分页缓存
		gridnavcache : {},
		navtext : [ '', '', '' ]
	},

	data_up_value : function(sPageUnique, sFieldId) {

		var sReturn = zstatic_page.temp.datacache[sPageUnique][sFieldId];

		return sReturn != undefined ? sReturn : '';

	},

	data_in_value : function(sPageUnique, sFieldId, sValue) {

		zstatic_page.temp.datacache[sPageUnique][sFieldId] = sValue;
	},

	page : function(sPageUrl) {
		zstatic_page.temp.purl = sPageUrl;

		zstatic_page.temp.pagearray.push(sPageUrl);

		zstatic_api.api_call('zooweb/post/webpage', {
			pageUrl : sPageUrl
		}, zstatic_page.page_success

		);

	},

	// 返回上一操作页
	page_back : function() {

		if (zstatic_page.temp.pagearray.length > 1) {
			var sPageUrl = zstatic_page.temp.pagearray[zstatic_page.temp.pagearray.length - 2];
			zstatic_page.temp.pagearray.pop();
			zstatic_page.page(sPageUrl);
			return true;

		}

	},

	page_complate : function() {
		$.material.init();
	},

	page_material : function(sId) {
		$.material.init();
	},

	page_clean : function() {
		zstatic_page.temp.datacache = {};
		zstatic_page.temp.querycache = {};
		zstatic_page.temp.gridnavcache = {};
		$('#' + zstatic_config.id.main).html('');

	},

	// 自动创建并返回页面的元素
	page_id : function(oModel) {

		var sId = oModel.struct.pageUnique;

		$('#' + zstatic_config.id.main).append('<div id="' + sId + '"></div>');
		return document.getElementById(sId);
	},

	// 获取页面的实体描述
	page_model : function(sUqCode) {
		return zstatic_page.temp.pall[sUqCode];
	},

	// 获取模型的扩展属性定义 如果没有或者不存在时返回空字符串
	up_model_ext : function(oModel, sName) {

		var sReturn = '';

		if (oModel[zstatic_config.ext.client]) {
			sReturn = oModel[zstatic_config.ext.client][sName];
		}

		return sReturn;

	},

	page_header : function(sText) {
		ReactDOM.render(React.createElement('h1', {
			className : 'page-header'
		}, sText), document.getElementById(zstatic_config.id.header));

		var aLi = [];
		aLi.push(React.createElement('li', null, zstatic_page.temp.navtext[0]));
		aLi.push(React.createElement('li', null, zstatic_page.temp.navtext[1]));
		aLi.push(React.createElement('li', {
			className : 'active'
		}, sText));
		ReactDOM.render(React.createElement('ul', {
			className : 'breadcrumb'
		}, aLi), document.getElementById(zstatic_config.id.header));

	},

	page_success : function(oData) {

		zstatic_page.page_clean();

		zstatic_page.page_header(oData.pageModel[0].struct.pageName);

		for ( var i in oData.pageModel) {

			var oPageModel = oData.pageModel[i];

			var sUqCode = oPageModel.struct.pageUnique;

			zstatic_page.temp.pall[sUqCode] = oPageModel;

			if (oPageModel.struct.pageFunc != "") {

				if (oPageModel.struct.pageFunc == "pa") {
					zstatic_page.show_padd(sUqCode);
				} else if (oPageModel.struct.pageFunc == "pg") {
					zstatic_page.show_pgrid(sUqCode);
				} else if (oPageModel.struct.pageFunc == "pe") {
					zstatic_page.show_pedit(sUqCode);
				} else if (oPageModel.struct.pageFunc == "pq") {
					zstatic_page.show_pquery(sUqCode);
				} else if (oPageModel.struct.pageFunc == "pb") {
					zstatic_page.show_pbook(sUqCode);
				} else {

					// 直接执行对应的页面脚本
					eval(oPageModel.struct.pageFunc + '("' + sUqCode + '");');
				}

			}

		}

	},
	show_pgrid : function(sUqCode) {
		zstatic_api.api_call('zooweb/post/webdata', {

			pageUnique : sUqCode,
			pageQuery : zstatic_page.temp.datacache[sUqCode],
			pageUrl : zstatic_page.temp.purl,
			gridNav : zstatic_page.temp.gridnavcache[sUqCode]
		}, zstatic_page.grid_success

		);
	},

	grid_nav : function(sUqCode, sIndex) {

		zstatic_page.temp.gridnavcache[sUqCode].pageIndex = sIndex;
		zstatic_page.show_pgrid(sUqCode);
	},

	grid_success : function(oData) {
		var sUqCode = oData.pageUnique;

		var oPageModel = zstatic_page.page_model(sUqCode);

		var oPrep = {
			uq_code : sUqCode,
			data : oData

		};

		var sShowType = zstatic_page.up_model_ext(oPageModel, 'show');
		if (sShowType == '') {
			ReactDOM.render(React.createElement(Zstatic_Elelemt_Grid, oPrep),
					zstatic_page.page_id(oPageModel));

			zstatic_page.page_complate();
		} else if (sShowType == 'dialog') {
			// $(zstatic_dialog.page_id(oPageModel)).html('');
			ReactDOM.render(React.createElement(Zstatic_Elelemt_Grid, oPrep),
					zstatic_dialog.page_id(oPageModel));
		}
		//$('table').bootstrapTable();
	},

	show_pquery : function(sUqCode) {
		var oPageModel = zstatic_page.page_model(sUqCode);
		zstatic_page.temp.datacache[sUqCode] = {};
		ReactDOM.render(React.createElement(Zstatic_Elelemt_Form, oPageModel),
				zstatic_page.page_id(oPageModel));
	},

	show_padd : function(sUqCode) {

		var oPageModel = zstatic_page.page_model(sUqCode);
		zstatic_page.temp.datacache[sUqCode] = {};
		ReactDOM.render(React.createElement(Zstatic_Elelemt_Form, oPageModel),
				zstatic_page.page_id(oPageModel));

		zstatic_page.page_complate();
	},
	show_pedit : function(sUqCode) {

		zstatic_api.api_call('zooweb/post/webdata', {

			pageUnique : sUqCode,
			pageUrl : zstatic_page.temp.purl,
			pageQuery : {
				za : zstatic_func.url_query(zstatic_page.temp.purl, 'u_za')
			}
		}, zstatic_page.edit_success

		);
	},
	edit_success : function(oData) {
		var sUqCode = oData.pageUnique;

		var oPageModel = zstatic_page.page_model(sUqCode);

		zstatic_page.temp.datacache[sUqCode] = oData.dataMaps[0];
		ReactDOM.render(React.createElement(Zstatic_Elelemt_Form, oPageModel),
				zstatic_page.page_id(oPageModel));

		zstatic_page.page_complate();
	},

	show_pbook : function(sUqCode) {

		var sZa = zstatic_func.url_query(zstatic_page.temp.purl, 'u_za');
		var oPageQuery = {};
		if (sZa != null)
			oPageQuery = {
				za : sZa
			}

		zstatic_api.api_call('zooweb/post/webdata', {

			pageUnique : sUqCode,
			pageUrl : zstatic_page.temp.purl,
			pageQuery :oPageQuery
		}, zstatic_page.book_success

		);
	},
	book_success : function(oData) {
		var sUqCode = oData.pageUnique;

		var oPageModel = zstatic_page.page_model(sUqCode);

		zstatic_page.temp.datacache[sUqCode] = oData.dataMaps[0];
		ReactDOM.render(React.createElement(Zstatic_Elelemt_Book, oPageModel),
				zstatic_page.page_id(oPageModel));

		zstatic_page.page_complate();
	},

	link_login : function() {

		top.location.href = 'login';
	},
	link_home : function() {

		top.location.href = 'home';
	},

	logout_call : function() {
		zstatic_func.cookie(zstatic_config.cookie.login, '', {
			expires : -1
		});
		zstatic_page.link_login();
	},

	login_check : function() {
		var sToken = zstatic_func.cookie(zstatic_config.cookie.login);
		if (!sToken) {
			zstatic_page.logout_call();
		}

		zstatic_api.c.api_token = sToken;
		// 注册进如果用户授权不对时的执行脚本
		zstatic_api.c.login_exec = "zstatic_page.logout_call();";

	},
	login_success : function(oData) {
		zstatic_func.cookie(zstatic_config.cookie.login, oData.token);
		zstatic_page.link_home();
	},
	// 帮助字段的展示
	help_text : function(sText) {
		var oReturn = null;
		if (sText != undefined && sText != "" && sText.length > 0) {
			oReturn = React.createElement("p", {
				className : zstatic_config.css.help
			}, sText);
		}
		return oReturn;
	}

};
