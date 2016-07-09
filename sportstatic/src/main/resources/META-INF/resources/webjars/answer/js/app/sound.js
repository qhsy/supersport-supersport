require(['zepto','vue','common','jssdk','extend'],function($,Vue,comm,wx){
	var sound = new Vue({
		el: '#sound',
		data: {
			status:1,
			length:0,
			voiceLocalId:''
		},
		created:function(){
		var self = this;
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
			            self.voiceLocalId = res.localId;
			        },
			        fail: function(res) {
			            alert(JSON.stringify(res));
			        }
			    });
			    self.status = 3;
			},
			playRecord:function(){
				var self = this;
				if (self.voiceLocalId == '') {
			        alert('请先使用 startRecord 接口录制一段声音');
			        return;
			    }
			    wx.playVoice({
			        localId: self.voiceLocalId
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
				        alert('录音（' + res.localId + '）播放结束');
				    }
				});
			},
			uploadVoice:function(){
				var self = this;
				if (self.voiceLocalId == '') {
			        alert('请先使用 startRecord 接口录制一段声音');
			        return;
			    }
			    wx.uploadVoice({
			        localId: self.voiceLocalId,
			        success: function(res) {
			            alert('上传语音成功，serverId 为' + res.serverId);
			            voice.serverId = res.serverId;
			        }
				});
			}
		}
	});
})