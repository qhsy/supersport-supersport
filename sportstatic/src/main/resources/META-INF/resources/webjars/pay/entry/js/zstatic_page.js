var zstatic_page = {

	temp : {

		// 本地缓存的页面结构
		pall : {},

		// 当前活动编码
		code : '',
		// 活动编码数组
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

	page : function(code) {
		zstatic_page.temp.code = code;

		zstatic_page.temp.pagearray.push(code);

		zstatic_api.api_call('orderController/reportFields', {
			code : code
		}, zstatic_page.page_success

		);

	},

	page_clean : function() {
		zstatic_page.temp.datacache = {};
		zstatic_page.temp.querycache = {};
		zstatic_page.temp.gridnavcache = {};
	},


	// 获取页面的实体描述
	page_model : function(sUqCode) {
		return zstatic_page.temp.pall[sUqCode];
	},

	page_header : function(sText) {
		ReactDOM.render(React.createElement('h1', {
			className : zstatic_config.css.cell_hd
		}, sText), document.getElementById(zstatic_config.id.hd));

	},

	page_success : function(oData) {

		zstatic_page.page_clean();

		zstatic_page.page_header(oData.fs.title);

		var sUqCode = oData.fs.code;

		zstatic_page.temp.pall[sUqCode] = oData.fields;

		zstatic_page.page_body(sUqCode);
			
		zstatic_page.page_btn(oData);
		

	},

	page_body : function(sUqCode) {

		var oPageModel = zstatic_page.page_model(sUqCode);
		zstatic_page.temp.datacache[sUqCode] = {};
		ReactDOM.render(React.createElement(Zstatic_Elelemt_Form, oPageModel),
			document.getElementById(zstatic_config.id.bd));
	},

	page_btn : function(sUqCode){

		Zstatic_Element_Operate_Button
		ReactDOM.render(React.createElement(Zstatic_Element_Operate_Button, sUqCode),
			document.getElementById(zstatic_config.id.btnArae));

	}

};
