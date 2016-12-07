/**
 * API调用相关
 * 
 * 
 */

var zstatic_operate = {

	temp : {
		// 最近一次点击的元素id
		time_id : '',
		// 最近一次点击的时间戳
		time_last : 0

	},

	check_time : function(sId, sTimeSpan) {
		// 定义是否正常操作
		var bFlagEnable = true;

		if (zstatic_operate.temp.time_id == sId) {
			var sNow = new Date().getTime();
			if (sNow - zstatic_operate.temp.time_last < sTimeSpan) {
				bFlagEnable = false;
			}
		}

		if (bFlagEnable) {
			zstatic_operate.temp.time_id = sId;
			zstatic_operate.temp.time_last = new Date().getTime();
		} else {
			alert(zstatic_config.button.timequick);
		}

		return bFlagEnable;
	},
	clear_time : function() {
		zstatic_operate.temp.time_id = '';
	},

	ope_link : function(sLink) {

		zstatic_page.page(sLink);

	},

	ope_href : function(sLink) {

		window.open(sLink);

	},
	/**
	 * 删除操作按钮
	 */
	ope_pd : function(sPageUnique, sUid, sOperateCode) {

		if (confirm('确认删除么?')) {
			zstatic_api.api_call('zooweb/post/weboperate', {

				pageUnique : sPageUnique,
				operateCode : sOperateCode,
				pageUrl : zstatic_page.temp.purl,
				dataMap : {
					za : sUid
				}
			}, zstatic_operate.pd_success

			);
		}

	},
	
	/**
	 * 删除操作按钮 无confirm确认
	 */
	ope_pd_noconfirm : function(sPageUnique, sUid, sOperateCode) {
			zstatic_api.api_call('zooweb/post/weboperate', {
				pageUnique : sPageUnique,
				operateCode : sOperateCode,
				pageUrl : zstatic_page.temp.purl,
				dataMap : {
					za : sUid
				}
			}, zstatic_operate.pd_success

			);
	},
	/**
	 * 跳转到添加页
	 */
	ope_pa : function(sPath) {

		zstatic_page.page('../pa/' + sPath);
	},
	/**
	 * 跳转到查询页
	 */
	ope_pq : function(sUqCode, sPath) {
		zstatic_operate.clear_time();
		zstatic_page.temp.datacache['pg-' + sPath] = zstatic_page.temp.datacache[sUqCode];
		zstatic_page.temp.gridnavcache['pg-' + sPath] = {};
		zstatic_page.show_pgrid('pg-' + sPath);

	},
	/**
	 * 查询按钮展示
	 */
	ope_dialog_pq : function(sUqCode, sPath) {
		zstatic_operate.clear_time();
		zstatic_page.temp.datacache['pg-' + sPath] = zstatic_page.temp.datacache[sUqCode];
		zstatic_page.temp.gridnavcache['pg-' + sPath] = {};
		zstatic_page.show_pgrid('pg-' + sPath);

	},
	/**
	 * 提交操作
	 */
	operate_submit : function(sPageUnique, sOperateCode) {

		zstatic_api.api_call('zooweb/post/weboperate', {
			pageUnique : sPageUnique,
			operateCode : sOperateCode,
			pageUrl : zstatic_page.temp.purl,
			dataMap : zstatic_page.temp.datacache[sPageUnique]
		}, zstatic_operate.operate_success

		);
	},

	/**
	 * 提交成功
	 */
	operate_success : function(oData) {

		var sExec = oData.successJs;
		zstatic_operate.clear_time();
		if (sExec) {
			var sFlag = eval(sExec);
			if (!sFlag) {
				alert('ok');
			}
		} else {
			alert('ok');
		}

	},
	/**
	 * 删除成功
	 */
	pd_success : function() {

		zstatic_page.page(zstatic_page.temp.purl);
		zstatic_operate.clear_time();

	},
	operate_format : function(pOperate, oReplace) {
		var pNew = zstatic_func.clone(pOperate);

		pNew["operateLink"] = zstatic_func.format_replace(
				pOperate["operateLink"], oReplace);

		pNew["clientJs"] = zstatic_func.format_replace(pOperate["clientJs"],
				oReplace);

		return pNew;
	},
	/**
	 * 自动判断操作
	 */
	auto_operate : function(pOperate) {
		if (pOperate["operateType"] == "js") {

			return React.createElement(Zstatic_Element_Operate_Js, pOperate);
		} else if (pOperate["operateType"] == "button") {

			return React
					.createElement(Zstatic_Element_Operate_Button, pOperate);
		} else {

			return React.createElement(Zstatic_Element_Operate_Link, pOperate);
		}
	}

};
