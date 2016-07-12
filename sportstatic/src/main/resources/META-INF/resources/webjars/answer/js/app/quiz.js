require(['zepto','vue','common','jssdk','extend'],function($,Vue,comm,wx){
	var userCode = comm.paramFn('code');
	var token = sessionStorage.getItem('token');
	var quiz = new Vue({
		el:'#question',
		data:{
			content:'',
			overt:true,
			num:0,
			result:{}
		},
		created:function(){
			var self = this;
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
				if(self.content.length > 60){
					comm.tost('输入的内容超过限制！')
					return false;
				}
				$.ajax({
					url:'/api/answerController/saveQuestion',
					type:'POST',
					contentType:'application/json',
					dataType:'json',
					async:false,
					data:'{"answerUserCode": "' + userCode + '","content": "' + self.content + '","orderSource": "dzsd4112100110020002","romoteIP": "","scope": "' + self.overt + '","serveIP": "","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
					success:function(res){
						if(res.status == 1){
							wx.chooseWXPay({
							    timestamp: res.wechatH5PayInfo.timeStamp,
							    nonceStr: res.wechatH5PayInfo.nonceStr, // 支付签名随机串，不长于 32 位
							    package: 'prepay_id=' + res.wechatH5PayInfo.prepay_id, // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
							    signType: res.wechatH5PayInfo.signType, // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
							    paySign: res.wechatH5PayInfo.paySign, // 支付签名
							    success: function (data) {
							       console.log(data);
							    }
							});
						}
					}
				});
				





				// $.ajax({
				// 	url:'/api/answerController/saveQuestion',
				// 	type:'POST',
				// 	contentType:'application/json',
				// 	dataType:'json',
				// 	data:'{"answerUserCode": "' + userCode + '","content": "' + self.content + '","scope": "' + self.overt + '","zoo": {"key": "tesetkey","token": "' + token + '"}}',
				// 	success:function(res){
				// 		console.log(self.content)
				// 		if(res.status == 1){
				// 			window.location.href = 'details.html?id=' + res.code;
				// 		}else{
				// 			comm.tost(res.error);
				// 		}
				// 	}
				// });
			}
		}
	});
})