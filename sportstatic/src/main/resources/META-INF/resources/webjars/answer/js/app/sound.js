require(['zepto','vue','common','jssdk','extend'],function($,Vue,comm,wx){
	var code = comm.paramFn('id');
	var voice = {
		localId: '',
		serverId: ''
	};
	var startTime = 0;
	var endTime = 0;
	var sound = new Vue({
		el: '#sound',
		data: {
			status:1,
			length:0,
			result:{}
		},
		created:function(){
			var self = this;
			$.ajax({
				url:'/api/answerController/answerQuestionDetail',
				type:'POST',
				contentType:'application/json',
				dataType:'json',
				data:'{"code": "' + code + '","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
				success:function(res){
					if(res.status == 1){
						self.result = res;
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
			startRecord:function(){
				var self = this;
				self.length = 0;
				startTime = new Date().getTime();
				wx.startRecord({
					cancel: function () {
						comm.tost('用户拒绝授权录音');
					}
				});
				self.status = 2;
			},
			stopRecord:function(){
				var self = this;
				endTime = new Date().getTime();
				wx.stopRecord({
			        success: function(res) {
			            voice.localId = res.localId;
			        },
			        fail: function(res) {
			            comm.tost(JSON.stringify(res));
			        }
			    });
			    wx.onVoiceRecordEnd({
				    complete: function(res) {
				        voice.localId = res.localId;
				        self.length = Math.ceil((endTime - startTime) / 1000);
				        self.status = 3;
				    }
				});
				self.length = Math.ceil((endTime - startTime) / 1000);
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
			    wx.uploadVoice({
			        localId: voice.localId,
			        success: function(res) {
			            var localId = res.serverId;
			            $.ajax({
							url:'/api/answerController/answerQuestion',
							type:'POST',
							contentType:'application/json',
							dataType:'json',
							data:'{"code": "' + self.result.show.answerCode + '","lengh": ' + self.length + ',"refuse": false,"url": "string","wechatVoiceId": "' + localId + '","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
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