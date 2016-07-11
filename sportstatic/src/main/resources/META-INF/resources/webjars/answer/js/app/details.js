require(['zepto','vue','common','jssdk','extend'],function($,Vue,comm,wx){
	var code = comm.paramFn('id');
	var localId;
	var getBrandWCPayRequest = null;
	var details = new Vue({
		el: '#details',
		data: {
			result:null
		},
		created:function(){
			var self = this;
			$.ajax({
				url:'/api/answerController/questionDetail',
				type:'POST',
				contentType:'application/json',
				dataType:'json',
				data:'{"code": "' + code + '","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
				success:function(res){
					if(res.status == 1){
						self.result = res;
					}else{
						alert(res.error);
					}
				}
			});
			$.ajax({
				url:'/api/wechatController/configInfo',
				type:'POST',
				contentType:'application/json',
				dataType:'json',
				data:'{"url": "' + window.location.href + '","zoo": {"key": "tesetkey", "token": "' + comm.token() + '"}}',
				success:function(res){
					if(res.status == 1){
						return wx.config({    
							debug: false,
							appId: res.appId,
							timestamp: res.timestamp,
							nonceStr: res.nonceStr,
							signature: res.signature,
							jsApiList: ['checkJsApi','startRecord','stopRecord','onVoiceRecordEnd','playVoice','pauseVoice','stopVoice','onVoicePlayEnd','uploadVoice','downloadVoice']
						});
					}
				}
			});
		},
		methods:{
			audioPlay:function(){
				var self = this;
				$.ajax({
					url:'/api/answerController/playAudio',
					type:'POST',
					contentType:'application/json',
					dataType:'json',
					async:false,
					data:'{"audioUrl": "' + self.result.detail.videoUrl + '","questionCode": "' + code + '","zoo": {"key": "tesetkey","token": ""}}',
					success:function(res){
						if(res.status == 1){
							wx.downloadVoice({
								serverId: res.mediaId, // 需要下载的音频的服务器端ID，由uploadVoice接口获得
								success: function (res) {
									localId = res.localId; // 返回音频的本地ID
								}
							});
						}
					}
				});
				wx.playVoice({
			        localId: localId
			    });
			    wx.onVoicePlayEnd({
				    complete: function(res) {
				        console.log('播放结束');
				    }
				});
				// if(self.result.detail.listenFlag){
				// 	audioPlay();
				// }else{
				// 	if (typeof WeixinJSBridge == "undefined"){
				// 		if( document.addEventListener ){
				// 			document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
				// 		} else if (document.attachEvent){
				// 			document.attachEvent('WeixinJSBridgeReady', onBridgeReady); 
				// 			document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
				// 		}
				// 	} else {
				// 		onBridgeReady();
				// 	}
				// }
				// function onBridgeReady(){
				// 	$.ajax({
				// 		url:'/api/payController/wechatH5Pay',
				// 		type:'POST',
				// 		contentType:'application/json',
				// 		dataType:'json',
				// 		async:false,
				// 		data:'{"questionCode": "' + code + '","romoteIP": "string","serveIP": "string","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
				// 		success:function(res){
				// 			if(res.status == 1){
				// 				getBrandWCPayRequest = res.wechatH5PayInfo;
				// 			}
				// 		}
				// 	});
				// 	WeixinJSBridge.invoke('getBrandWCPayRequest',getBrandWCPayRequest,function(res){
				// 		if(res.err_msg == "get_brand_wcpay_request：ok" ) {
				// 			self.result.detail.listenFlag = true;
				// 			self.result.detail.videoShow = '';
				// 			audioPlay();
				// 		}     
				// 	}); 
				// }
				// function play(){
				// 	$.ajax({
				// 		url:'/api/answerController/playAudio',
				// 		type:'POST',
				// 		contentType:'application/json',
				// 		dataType:'json',
				// 		async:false,
				// 		data:'{"audioUrl": "' + self.result.videoUrl + '","questionCode": "' + code + '","zoo": {"key": "tesetkey","token": ""}}',
				// 		success:function(res){
				// 			if(res.status == 1){
				// 				wx.downloadVoice({
				// 					serverId: res.mediaId, // 需要下载的音频的服务器端ID，由uploadVoice接口获得
				// 					success: function (res) {
				// 						localId = res.localId; // 返回音频的本地ID
				// 					}
				// 				});
				// 			}
				// 		}
				// 	});
				// 	wx.playVoice({
				//         localId: localId
				//     });
				//     wx.onVoicePlayEnd({
				// 	    complete: function(res) {
				// 	        console.log('播放结束');
				// 	    }
				// 	});
				// }

			},
			assistFn:function(){
				var self = this;
				$.ajax({
					url:'/api/answerController/questionPraise',
					type:'POST',
					contentType:'application/json',
					dataType:'json',
					async:false,
					data:'{"code": "' + code + '","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
					success:function(res){
						if(res.status == 1){
							result.detail.loveFlag = false;
						}else{
							alert(res.error)
						}
					}
				});
			}	
		}
	});
})