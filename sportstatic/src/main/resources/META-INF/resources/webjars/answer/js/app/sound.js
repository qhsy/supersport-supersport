require(['zepto','vue','common','jssdk','extend'],function($,Vue,comm,wx){
	var code = comm.paramFn('id');
	var sound = new Vue({
		el: '#sound',
		data: {
			status:1,
			length:0,
			voiceLocalId:'',
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
				wx.startRecord({
					cancel: function () {
						alert('用户拒绝授权录音');
					}
				});
				self.status = 2;
			},
			stopRecord:function(){
				var self = this;
				wx.stopRecord({
			        success: function(res) {
			        	console.log(res)
			            self.voiceLocalId = res.localId;
			        },
			        fail: function(res) {
			            alert(JSON.stringify(res));
			        }
			    });
			    wx.onVoiceRecordEnd({
				    complete: function(res) {
				        self.voiceLocalId = res.localId;
				        self.status = 3;
				    }
				});
			    self.status = 3;
			},
			playRecord:function(){
				var self = this;
				if (self.voiceLocalId == '') {
			        alert('请先录制声音');
			        return;
			    }
			    wx.playVoice({
			        localId: self.voiceLocalId
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
			        localId: self.voiceLocalId
			    });
			    wx.onVoicePlayEnd({
				    complete: function(res) {
				        alert('录音播放结束');
				    }
				});
				self.status = 3;
			},
			uploadVoice:function(){
				var self = this;
				if (self.voiceLocalId == '') {
			        alert('请先录制声音');
			        return;
			    }
			    wx.uploadVoice({
			        localId: self.voiceLocalId,
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
									alert(res.error);
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
							alert(res.error);
						}
					}
				});
			}
		}
	});
})