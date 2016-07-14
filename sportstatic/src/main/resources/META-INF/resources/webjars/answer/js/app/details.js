require(['zepto','vue','common','jssdk','extend'],function($,Vue,comm,wx){
	var code = comm.paramFn('id');
	var localId;
	var getBrandWCPayRequest = null;
	var status;
	var vm = new Vue({
		el: '#details',
		data: {
			result:{}
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
						comm.tost(res.error);
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
				var id = self.result.detail.code;
				if(self.result.detail.listenFlag){
					play();
				}else{
					if (typeof WeixinJSBridge == "undefined") {
						if (document.addEventListener) {
							document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
						} else if (document.attachEvent) {
							document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
							document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
						}
					} else {
						onBridgeReady();
					}
				}
				function onBridgeReady() {
					$.ajax({
						url:'/api/orderController/answerOrder',
						type:'POST',
						contentType:'application/json',
						dataType:'json',
						async:false,
						data:'{"answerCode": "' + id + '","appVersion": "","orderSource": "dzsd4112100110020002","orderType": "dzsd4112100110010004","payType": "dzsd4112100110040002","romoteIP": "","serveIP": "","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
						success:function(res){
							if(res.status == 1){
								var that = res;
								WeixinJSBridge.invoke('getBrandWCPayRequest', {
									"appId":res.wechatH5PayResponse.appId,
									"timeStamp":res.wechatH5PayResponse.timeStamp,
									"nonceStr":res.wechatH5PayResponse.nonceStr,
									"package":"prepay_id=" + res.wechatH5PayResponse.prepay_id,
									"signType":res.wechatH5PayResponse.signType,
									"paySign":res.wechatH5PayResponse.paySign
								}, function(res) {
									if (res.err_msg == "get_brand_wcpay_request:ok") {
										self.result.detail.listenFlag = true;
								    	self.result.detail.videoShow = '点击播放';
								    	play();
									}else{

									}
								})
							}
						}
					});
				}
				function play(){
					$.ajax({
						url:'/api/answerController/playAudio',
						type:'POST',
						contentType:'application/json',
						dataType:'json',
						async:false,
						data:'{"audioUrl": "' + self.result.detail.videoUrl + '","questionCode": "' + id + '","zoo": {"key": "tesetkey","token": ""}}',
						success:function(data){
							var thisData = data;
							if(thisData.status == 1){
								wx.downloadVoice({
									serverId: thisData.mediaId,
									success: function (res) {
										var localId = res.localId; 
										wx.playVoice({
									        localId: localId
									    });
									    wx.onVoicePlayEnd({
										    complete: function(res) {
										    	
										    }
										});
									}
								});
							}
						}
					});
				}

			},
			assistFn:function(){
				var self = this;
				if(!self.result.detail.loveFlag){
					$.ajax({
						url:'/api/answerController/questionPraise',
						type:'POST',
						contentType:'application/json',
						dataType:'json',
						async:false,
						data:'{"code": "' + code + '","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
						success:function(res){
							if(res.status == 1){
								self.result.detail.loveFlag = true;
							}else{
								comm.tost(res.error)
							}
						}
					});
				}
				
			}	
		}
	});
})