require(['zepto','vue','common','jssdk','qrcode','extend'],function($,Vue,comm,wx,QRCode){
	var code = comm.paramFn('id');
	var localId;
	var status;
	var vm = new Vue({
		el: '#details',
		data: {
			result:{},
			browser:false
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
		},
		methods:{
			audioPlay:function(){
				var self = this;
				var id = self.result.detail.code;
				var weix = navigator.userAgent.indexOf('MicroMessenger') > -1;
				if(!weix){
					self.browser = true;
					setTimeout(function(){
						new QRCode('qrcode', {
							text: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxec842da73ebe11a4&redirect_uri=' + window.location.href + '&response_type=code&scope=snsapi_userinfo&state=512457895#wechat_redirect',
							typeNumber:4,
							width:192,
							height:192
						});
					}, 1)
					return ;
				}

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
						data:'{"audioUrl": "' + self.result.detail.videoUrl + '","listenUserCode": "' + comm.code() + '","questionCode": "' + id + '","zoo": {"key": "tesetkey","token": ""}}',
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
			},
			closeQrcode:function(){
				var self = this;
				self.browser = false;
			}
		}
	});
	wx.ready(function(){
		var imgUrl = $('.photo').find('img').attr('src');
		var link = window.location.href;
		wx.onMenuShareTimeline({
		    title: '<昵称>回答了“<问题描述>”',
		    link: link, 
		    imgUrl: imgUrl,
		    success: function () { 
		        
		    },
		    cancel: function () { 
		        
		    }
		});
		wx.onMenuShareAppMessage({
		    title: '<昵称>回答了“<问题描述>”', // 分享标题
		    desc: '值<问题金额>，花1元就能偷偷听|推动所有对运动感兴趣的人成为运动达人', // 分享描述
		    link: link, // 分享链接
		    imgUrl: imgUrl, // 分享图标
		    type: '', // 分享类型,music、video或link，不填默认为link
		    dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
		    success: function () { 
		        // 用户确认分享后执行的回调函数
		    },
		    cancel: function () { 
		        // 用户取消分享后执行的回调函数
		    }
		});
		wx.onMenuShareQQ({
		    title: '<昵称>回答了“<问题描述>', // 分享标题
		    desc: '值<问题金额>，花1元就能偷偷听|推动所有对运动感兴趣的人成为运动达人', // 分享描述
		    link: link, // 分享链接
		    imgUrl: imgUrl, // 分享图标
		    success: function () { 
		       // 用户确认分享后执行的回调函数
		    },
		    cancel: function () { 
		       // 用户取消分享后执行的回调函数
		    }
		});
		wx.onMenuShareWeibo({
		    title: title, // 分享标题
		    desc: '<昵称>回答了“<问题描述>”。值<问题金额>，花1元就能偷偷听|推动所有对运动感兴趣的人成为运动达人', // 分享描述
		    link: link, // 分享链接
		    imgUrl: imgUrl, // 分享图标
		    success: function () { 
		       
		    },
		    cancel: function () { 
		        // 用户取消分享后执行的回调函数
		    }
		});
	});
	
})