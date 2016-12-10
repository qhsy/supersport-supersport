/**
 * API调用相关
 * 
 * 
 */

var entry_operate = {

	temp : {
		// 最近一次点击的元素id
		time_id : '',
		// 最近一次点击的时间戳
		time_last : 0

	},

	check_time : function(sId, sTimeSpan) {
		// 定义是否正常操作
		var bFlagEnable = true;

		if (entry_operate.temp.time_id == sId) {
			var sNow = new Date().getTime();
			if (sNow - entry_operate.temp.time_last < sTimeSpan) {
				bFlagEnable = false;
			}
		}

		if (bFlagEnable) {
			entry_operate.temp.time_id = sId;
			entry_operate.temp.time_last = new Date().getTime();
		} else {
			alert(entry_config.button.timequick);
		}

		return bFlagEnable;
	},
	clear_time : function() {
		entry_operate.temp.time_id = '';
	},

	/**
	 * 提交操作
	 */
	operate_submit : function(code) {

		var oSource = '';

		if(entry.dataCache.source == 'app'){

			oSource = 'dzsd4112100110020001';

		}

		if(entry.dataCache.source == 'wechat'){

			oSource = 'dzsd4112100110020002';

		}

		entry_api.api_call('orderController/saveReport', {
			map : entry_page.temp.datacache[code],
			reportCode : code,
			orderSource : oSource
		}, entry_operate.operate_success

		);
		
	},

	/**
	 * 提交成功
	 */
	operate_success : function(oData) {

		$("#loadingToast").css('display','none');
		$("#topTip").css('display','none');

		if(eval(oData.status) == 1){

			if(entry.dataCache.source == 'app'){

				callBackOrder(oData.orderCode);

				$("#toast").css('display','block');

			}

			if(entry.dataCache.source == 'wechat'){

				window.location.href = '/webjars/pay/success.html?id='+oData.orderCode+'&entryToken='+entry_api.c.api_token;

			}



		}else {

			$("#topTip").css('display','block');
			$('#topTip').html(oData.error);

		}

	},
	

};
