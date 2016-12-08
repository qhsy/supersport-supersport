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

	/**
	 * 提交操作
	 */
	operate_submit : function(code) {

		zstatic_api.api_call('orderController/saveReport', {
			map : zstatic_page.temp.datacache[code],
			reportCode : code
		}, zstatic_operate.operate_success

		);
		
	},

	/**
	 * 提交成功
	 */
	operate_success : function(oData) {

		$("#loadingToast").css('display','none');
		$("#topTip").css('display','none');

		if(eval(oData.status)){

			$("#toast").css('display','block');

		}else {

			$("#topTip").css('display','block');
			$('#topTip').html(oData.error);

		}

	},
	

};
