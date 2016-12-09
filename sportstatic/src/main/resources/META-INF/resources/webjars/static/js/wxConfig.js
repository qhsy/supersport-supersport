function wxConfigFun(config){
	var isWeix = navigator.userAgent.indexOf('MicroMessenger') > -1;
	var con = {
		'url':config && config.url || '/api/wechatController/configInfo'
	}
	if(isWeix){
		$.ajax({
			url: con.url,
			type:'POST',
			data: '{"url": "' + window.location.href + '","zoo": {"key": "tesetkey", "token": ""}}',
			dataType: 'json',
			contentType:'application/json',
			success: function(res) {
				if(res.status == 1){
					wx.config({    
						debug: false,
						appId: res.appId,
						timestamp: res.timestamp,
						nonceStr: res.nonceStr,
						signature: res.signature,
						jsApiList: [
							'checkJsApi',
							'onMenuShareTimeline',
							'onMenuShareAppMessage',
							'onMenuShareQQ',
							'onMenuShareWeibo',
							'onMenuShareQZone',
							'hideMenuItems',
							'showMenuItems',
							'hideAllNonBaseMenuItem',
							'showAllNonBaseMenuItem',
							'translateVoice',
							'startRecord',
							'stopRecord',
							'onVoiceRecordEnd',
							'playVoice',
							'onVoicePlayEnd',
							'pauseVoice',
							'stopVoice',
							'uploadVoice',
							'downloadVoice',
							'chooseImage',
							'previewImage',
							'uploadImage',
							'downloadImage',
							'getNetworkType',
							'openLocation',
							'getLocation',
							'hideOptionMenu',
							'showOptionMenu',
							'closeWindow',
							'scanQRCode',
							'chooseWXPay',
							'openProductSpecificView',
							'addCard',
							'chooseCard',
							'openCard'
							]
					});

				}
			}
		});
	}
	
}