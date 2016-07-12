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
				var code = self.result.detail.answerUserCode;
				if(self.result.detail.listenFlag){
					play();
				}else{
					$.ajax({
						url:'/api/orderController/answerOrder',
						type:'POST',
						contentType:'application/json',
						dataType:'json',
						async:false,
						data:'{"answerCode": "' + code + '","appVersion": "","orderSource": "dzsd4112100110020002","orderType": "dzsd4112100110010004","payType": "dzsd4112100110040002","romoteIP": "","serveIP": "","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
						success:function(res){
							if(res.status == 1){
								wx.chooseWXPay({
								    timestamp: res.wechatH5PayResponse.timeStamp,
								    nonceStr: res.wechatH5PayResponse.nonceStr,
								    package: 'prepay_id=' + res.wechatH5PayResponse.prepay_id,
								    signType: res.wechatH5PayResponse.signType,
								    paySign: res.wechatH5PayResponse.paySign,
								    success: function (data) {
								    	self.result.detail.listenFlag = true;
								    	self.result.detail.videoShow = '';
								    	play();
								    }
								});
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
						data:'{"audioUrl": "' + self.result.detail.videoUrl + '","questionCode": "' + code + '","zoo": {"key": "tesetkey","token": ""}}',
						success:function(res){
							if(res.status == 1){
								wx.downloadVoice({
									serverId: res.mediaId,
									success: function (res) {
										localId = res.localId; 
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
	});
})