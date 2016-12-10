function wxConfigFun(config){
	var weix = navigator.userAgent.indexOf('MicroMessenger') > -1;
	var con = {
		'url':config && config.url || '/api/wechatController/configInfo',
		'imgUrl':config && config.imgUrl || '',
		'title':config && config.title || '',
		'link':config && config.link || '',
		'desc':config && config.desc || '',
		'type':config && config.type || '',
		'share':config && config.share || false,
		'dataUrl':config && config.dataUrl || '',
		'success':config && config.success || function(){},
		'cancel':config && config.cancel || function(){}
	}
	if(!weix) return ;
	reqwest({
		url: con.url,
		method: 'post',
		data: '{"url": "' + window.location.href + '","zoo": {"key": "tesetkey", "token": ""}}',
		type: 'json',
		contentType: 'application/json',
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
	wx.ready(function(){
		if(con.share){
			wx.hideOptionMenu();
		}
		//分享到朋友圈
		wx.onMenuShareTimeline({
		    title: con.title,
		    link: con.link, 
		    imgUrl: con.imgUrl,
		    success: function () {
		    	con.success();
		    },
		    cancel: function () {
		    	con.cancel();
		    }
		});
		//分享给朋友
		wx.onMenuShareAppMessage({
		    title: con.title,
		    desc: con.desc,
		    link: con.link,
		    imgUrl: con.imgUrl,
		    type: con.type,
		    dataUrl: con.dataUrl,
		    success: function () {
		    	con.success();
		    },
		    cancel: function () {
		    	con.cancel();
		    }
		});
		//分享到QQ
		wx.onMenuShareQQ({
		    title: con.title,
		    desc: con.desc,
		    link: con.link,
		    imgUrl: con.imgUrl,
		    success: function () {
		    	con.success();
		    },
		    cancel: function () {
		    	con.cancel();
		    }
		});
		//分享到腾讯微博
		wx.onMenuShareWeibo({
		    title: con.title,
		    desc: con.desc,
		    link: con.link,
		    imgUrl: con.imgUrl,
		    success: function () {
		    	con.cancel();
		    },
		    cancel: function () {
		    	con.cancel();
		    }
		});
		//分享到QQ空间
		wx.onMenuShareQZone({
		    title: con.title,
		    desc: con.desc,
		    link: con.link,
		    imgUrl: con.imgUrl,
		    success: function () {
		    	con.cancel();
		    },
		    cancel: function () {
		    	con.cancel();
		    }
		});
	});
}