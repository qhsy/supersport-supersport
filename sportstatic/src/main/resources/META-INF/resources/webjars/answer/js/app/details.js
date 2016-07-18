require(['zepto','vue','common','jssdk','qrcode','extend'],function($,Vue,comm,wx,QRCode){
	var code = comm.paramFn('id');
	var localId;
	var status;
	var share = {
		title:'',
		link:'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxec842da73ebe11a4&redirect_uri=' + comm.getUrl() + '&response_type=code&scope=snsapi_userinfo&state=512457895#wechat_redirect',
		desc:'',
		imgUrl:'',
		nickName:'',
		money:''
	}
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
						share = {
							title:res.detail.content,
							link:window.location.href,
							nickName:res.detail.answerUserNickName,
							imgUrl:res.detail.answerUserHeadUrl,
							money:res.detail.money
						}
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
							text: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxec842da73ebe11a4&redirect_uri=' + comm.getUrl() + '&response_type=code&scope=snsapi_userinfo&state=512457895#wechat_redirect',
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
		wx.onMenuShareTimeline({
		    title: share.nickName + '回答了“' + share.title + '”',
		    link: share.link, 
		    imgUrl: share.imgUrl,
		    success: function () {},
		    cancel: function () {}
		});
		wx.onMenuShareAppMessage({
		    title: share.nickName + '回答了“' + share.title + '”',
		    desc: '值' + share.money + '，花1元就能偷偷听|推动所有对运动感兴趣的人成为运动达人',
		    link: share.link,
		    imgUrl: share.imgUrl,
		    type: '',
		    dataUrl: '',
		    success: function () {},
		    cancel: function () {}
		});
		wx.onMenuShareQQ({
		    title: share.nickName + '回答了“' + share.title + '”',
		    desc: '值' + share.money + '，花1元就能偷偷听|推动所有对运动感兴趣的人成为运动达人',
		    link: share.link,
		    imgUrl: share.imgUrl,
		    success: function () {},
		    cancel: function () {}
		});
		wx.onMenuShareWeibo({
		    title: share.nickName + '回答了“' + share.title + '”',
		    desc: '值' + share.money + '，花1元就能偷偷听|推动所有对运动感兴趣的人成为运动达人',
		    link: share.link,
		    imgUrl: share.imgUrl,
		    success: function () {},
		    cancel: function () {}
		});
	});
	
})