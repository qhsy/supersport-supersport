var entry_page = {

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

		var sReturn = entry_page.temp.datacache[sPageUnique][sFieldId];

		return sReturn != undefined ? sReturn : '';

	},

	data_in_value : function(sPageUnique, sFieldId, sValue) {

		entry_page.temp.datacache[sPageUnique][sFieldId] = sValue;
	},

	page : function(code) {
		entry_page.temp.code = code;

		entry_page.temp.pagearray.push(code);

		entry_api.api_call('orderController/reportFields', {
			code : code
		}, entry_page.page_success

		);

	},

	page_clean : function() {
		entry_page.temp.datacache = {};
		entry_page.temp.querycache = {};
		entry_page.temp.gridnavcache = {};
	},


	// 获取页面的实体描述
	page_model : function(sUqCode) {
		return entry_page.temp.pall[sUqCode];
	},

	page_header : function(sText) {
		ReactDOM.render(React.createElement('h1', {
			className : entry_config.css.cell_hd
		}, sText), document.getElementById(entry_config.id.hd));

	},

	page_success : function(oData) {

		entry_page.page_clean();

		entry_page.page_header(oData.fs.title);

		var sUqCode = oData.fs.code;

		entry_page.temp.pall[sUqCode] = oData.fields;

		entry_page.page_body(sUqCode);
			
		entry_page.page_btn(oData);
		

	},

	page_body : function(sUqCode) {

		var oPageModel = entry_page.page_model(sUqCode);
		entry_page.temp.datacache[sUqCode] = {};
		ReactDOM.render(React.createElement(entry_Elelemt_Form, oPageModel),
			document.getElementById(entry_config.id.bd));
	},

	page_btn : function(sUqCode){

		entry_Element_Operate_Button
		ReactDOM.render(React.createElement(entry_Element_Operate_Button, sUqCode),
			document.getElementById(entry_config.id.btnArae));

	}

};
