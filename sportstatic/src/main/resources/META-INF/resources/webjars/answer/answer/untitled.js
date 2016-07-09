
	wx.ready(function () {
		var voice = {
			localId: '',
			serverId: ''
		};
		wx.checkJsApi({
			jsApiList: ['checkJsApi','startRecord','stopRecord','onVoiceRecordEnd','playVoice','pauseVoice','stopVoice','onVoicePlayEnd','uploadVoice','downloadVoice'],
			success: function (res) {
				console.log(JSON.stringify(res));
			}
		});

		document.querySelector('.init').onclick = function() {
			wx.startRecord({
				cancel: function () {
					alert('用户拒绝授权录音');
				}
			});
		};
		// 4.3 停止录音
		document.querySelector('.load').onclick = function() {
		    wx.stopRecord({
		        success: function(res) {
		            voice.localId = res.localId;
		        },
		        fail: function(res) {
		            alert(JSON.stringify(res));
		        }
		    });
		};
		// 4.4 监听录音自动停止
		wx.onVoiceRecordEnd({
		    complete: function(res) {
		        voice.localId = res.localId;
		        alert('录音时间已超过一分钟');
		    }
		});
		// 4.5 播放音频
		document.querySelector('.play').onclick = function() {
		    if (voice.localId == '') {
		        alert('请先使用 startRecord 接口录制一段声音');
		        return;
		    }
		    wx.playVoice({
		        localId: voice.localId
		    });
		};
		// 4.6 暂停播放音频
		document.querySelector('.stop').onclick = function() {
		    wx.pauseVoice({
		        localId: voice.localId
		    });
		};
		// 4.7 停止播放音频
		// document.querySelector('#stopVoice').onclick = function() {
		//     wx.stopVoice({
		//         localId: voice.localId
		//     });
		// };
		// 4.8 监听录音播放停止
		wx.onVoicePlayEnd({
		    complete: function(res) {
		        alert('录音（' + res.localId + '）播放结束');
		    }
		});
		// 4.8 上传语音
		// document.querySelector('#uploadVoice').onclick = function() {
		//     if (voice.localId == '') {
		//         alert('请先使用 startRecord 接口录制一段声音');
		//         return;
		//     }
		//     wx.uploadVoice({
		//         localId: voice.localId,
		//         success: function(res) {
		//             alert('上传语音成功，serverId 为' + res.serverId);
		//             voice.serverId = res.serverId;
		//         }
		//     });
		// };
		// 4.9 下载语音
		// document.querySelector('#downloadVoice').onclick = function() {
		//     if (voice.serverId == '') {
		//         alert('请先使用 uploadVoice 上传声音');
		//         return;
		//     }
		//     wx.downloadVoice({
		//         serverId: voice.serverId,
		//         success: function(res) {
		//             alert('下载语音成功，localId 为' + res.localId);
		//             voice.localId = res.localId;
		//         }
		//     });
		// };
	});