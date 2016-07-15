require(['zepto','vue','common','jssdk','qrcode','extend'],function($,Vue,comm,wx,QRCode){
	var code = comm.paramFn('id');
	var voice = {
		localId: '',
		serverId: ''
	};
	var timer = null;
	var sound = new Vue({
		el: '#sound',
		data: {
			status:1,
			length:0,
			result:{},
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
				url:'/api/answerController/answerQuestionDetail',
				type:'POST',
				contentType:'application/json',
				dataType:'json',
				data:'{"code": "' + code + '","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
				success:function(res){
					if(res.status == 1){
						self.result = res;
					} else if(res.status == 88880009){
						window.location.href = 'details.html?id=' + res.show.answerCode;
					} else if(res.status == 88880010){
						window.location.href = 'answer.html';
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
							jsApiList: ['checkJsApi','startRecord','stopRecord','onVoiceRecordEnd','playVoice','pauseVoice','stopVoice','onVoicePlayEnd','uploadVoice','downloadVoice']
						});
					}
				}
			});
		},
		methods:{
			countdown:function(){
				var time = 0;
				var self = this;
					this.length = 0;

				timer = setInterval(function(){
					if(time >= 59){
						time = 59;
						self.length = time;
						self.stopRecord();
						clearInterval(timer);
					}else{
						time++;
						self.length = time;
					}
				},1000)
			},
			startRecord:function(){
				var self = this;
				self.countdown();
				if(voice.localId){
					self.stopVoice();
				}
				wx.startRecord({
					cancel: function () {
						comm.tost('用户拒绝授权录音');
					}
				});
				self.status = 2;
			},
			stopRecord:function(){
				var self = this;
				clearInterval(timer);
				wx.stopRecord({
			        success: function(res) {
			            voice.localId = res.localId;
			        },
			        fail: function(res) {
			            comm.tost(JSON.stringify(res));
			        }
			    });
			    self.status = 3;
			},
			playRecord:function(){
				var self = this;
				if (voice.localId == '') {
			        comm.tost('请先录制声音');
			        return;
			    }
			    wx.playVoice({
			        localId: voice.localId
			    });
			    wx.onVoicePlayEnd({
				    complete: function(res) {
				        self.status = 3;
				    }
				});
			    self.status = 4;
			},
			stopVoice:function(){
				var self = this;
			 	wx.stopVoice({
			        localId: voice.localId
			    });
				self.status = 3;
			},
			uploadVoice:function(){
				var self = this;
				if (voice.localId == '') {
			        comm.tost('请先录制声音');
			        return;
			    }
			    wx.stopVoice({
			        localId: voice.localId
			    });
			    wx.uploadVoice({
			        localId: voice.localId,
			        success: function(res) {
			            var localId = res.serverId;
			            $.ajax({
							url:'/api/answerController/answerQuestion',
							type:'POST',
							contentType:'application/json',
							dataType:'json',
							data:'{"code": "' + self.result.show.answerCode + '","lengh": ' + self.length + ',"requestUrl": "","refuse": false,"url": "string","wechatVoiceId": "' + localId + '","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
							success:function(res){
								if(res.status == 1){
									window.location.href = 'details.html?id=' + self.result.show.answerCode;
								}else{
									comm.tost(res.error);
								}
							}
						});
			        }
				});
			},
			refuse:function(){
				var self = this;
				$.ajax({
					url:'/api/answerController/answerQuestion',
					type:'POST',
					contentType:'application/json',
					dataType:'json',
					data:'{"code": "' + self.result.show.answerCode + '","lengh":"","refuse": true,"url": "string","wechatVoiceId": "","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
					success:function(res){
						if(res.status == 1){
							window.location.href = 'details.html?id=' + self.result.show.answerCode;
						}else{
							comm.tost(res.error);
						}
					}
				});
			}
		}
	});
})