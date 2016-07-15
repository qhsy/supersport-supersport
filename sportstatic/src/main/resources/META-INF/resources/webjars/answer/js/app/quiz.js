require(['zepto','vue','common','jssdk','qrcode','extend'],function($,Vue,comm,wx,QRCode){
	var userCode = comm.paramFn('code');
	var token = sessionStorage.getItem('token');
	var quiz = new Vue({
		el:'#question',
		data:{
			content:'',
			overt:true,
			num:0,
			result:{},
			isSubmit:true,
			browser:false
		},
		created:function(){
			var self = this;
			var weix = navigator.userAgent.indexOf('MicroMessenger') > -1;
			if(!weix){
				self.browser = true;
				setTimeout(function(){
					new QRCode('qrcode', {
						text: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxec842da73ebe11a4&redirect_uri=' + window.location.href + '&response_type=code&scope=snsapi_userinfo&state=512457895#wechat_redirect',
						width:192,
						height:192
					});
				}, 1)
				return ;
			}
			$.ajax({
				url:'/api/answerController/askQuestion',
				type:'POST',
				contentType:'application/json',
				dataType:'json',
				data:'{"code": "' + userCode + '","zoo": {"key": "tesetkey","token": "' + token + '"}}',
				success:function(res){
					if(res.status == 1){
						self.result = res.show;
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
				async:false,
				data:'{"url": "' + window.location.href + '","zoo": {"key": "tesetkey", "token": "' + comm.token() + '"}}',
				success:function(res){
					if(res.status == 1){
						wx.config({    
							debug: false,
							appId: res.appId,
							timestamp: res.timestamp,
							nonceStr: res.nonceStr,
							signature: res.signature,
							jsApiList: ['checkJsApi','startRecord','stopRecord','onVoiceRecordEnd','playVoice','pauseVoice','stopVoice','onVoicePlayEnd','uploadVoice','downloadVoice','chooseWXPay']
						});
					}
				}
			});
		},
		methods:{
			overtFn:function(){
				this.overt = !this.overt;
			},
			change:function(){
				var self = this;
				self.num = self.content.length;
				
			},
			submitFn:function(){
				var self = this;
				if(self.content.length == 0){
					comm.tost('请输入提问内容！')
					return false;
				}
				if(self.content.length > 60){
					comm.tost('输入的内容超过限制！')
					return false;
				}
				if(self.isSubmit){
					self.isSubmit = false;
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
						url:'/api/answerController/saveQuestion',
						type:'POST',
						contentType:'application/json',
						dataType:'json',
						async:false,
						data:'{"answerUserCode": "' + userCode + '","content": "' + self.content + '","orderSource": "dzsd4112100110020002","romoteIP": "","scope": "' + self.overt + '","serveIP": "","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
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
								}, function(result) {
									if (result.err_msg == "get_brand_wcpay_request:ok") {
										$.ajax({
											url:'/api/answerController/sendAskWxMsg',
											type:'POST',
											contentType:'application/json',
											dataType:'json',
											async:false,
											data:'{"questionCode": "' + that.code + '","requestUrl": "","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
											success:function(succ){
												if(succ.status == 1){
													window.location.href = 'details.html?id=' + that.code;
												}
											}
										});
									}else{
										comm.tost('支付失败，请重新支付！');
										self.isSubmit = true;
									}
								})
							}else{
								comm.tost(res.error);
								self.isSubmit = true;
							}
						}
					});
				}
			}
		}
	});
})