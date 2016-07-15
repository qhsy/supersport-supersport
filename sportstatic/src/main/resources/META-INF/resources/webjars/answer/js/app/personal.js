require(['zepto','vue','common','jssdk','qrcode','extend'],function($,Vue,comm,wx,QRCode){
	var userCode = comm.paramFn('userCode');
	var page = 1;
	var share = {
		title:'[果冻体育]您的健康运动加油站',
		link:window.location.href,
		desc:'精彩内容与你分享',
		imgUrl:'',
	}
	var personal = new Vue({
		el: '#personal',
		data: {
			result:{},
			browser:false
		},
		created:function(){
			var self = this;
			$.ajax({
				url:'/api/answerController/personHomePage',
				type:'POST',
				contentType:'application/json',
				dataType:'json',
				data:'{"pagination": ' + page + ',"userCode": "' + userCode + '","zoo": {"key": "tesetkey","token": "' + comm.token + '"}}',
				success:function(res){
					if(res.status == 1){
						self.result = res;
						share.imgUrl = res.answerUserInfo.aboutHead;
					}else{
						comm.tost(res.error);
					}
				}
			});
		},
		methods:{
			attendFlag:function(){
				var self = this;
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
				$.ajax({
					url:'/api/userController/userAttention',
					type:'POST',
					contentType:'application/json',
					dataType:'json',
					data:'{"flag": "1","userCode": "' + self.result.answerUserInfo.userCode + '","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
					success:function(res){
						if(res.status == 1){
							self.result.answerUserInfo.attendFlag = '1';
						}else{
							comm.tost(res.error);
						}
					}
				});
			},
			unAttendFlag:function(){
				var self = this;
				$.ajax({
					url:'/api/userController/userAttention',
					type:'POST',
					contentType:'application/json',
					dataType:'json',
					data:'{"flag": "0","userCode": "' + self.result.answerUserInfo.userCode + '","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
					success:function(res){
						if(res.status == 1){
							self.result.answerUserInfo.attendFlag = '0';
						}else{
							comm.tost(res.error);
						}
					}
				});
			},
			anwser:function(event){
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
					}, 1);
					event.preventDefault()
					return ;
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
		    title: share.title,
		    link: share.link, 
		    imgUrl: share.imgUrl,
		    success: function () {},
		    cancel: function () {}
		});
		wx.onMenuShareAppMessage({
		    title: share.title,
		    desc: share.desc,
		    link: share.link,
		    imgUrl: share.imgUrl,
		    type: '',
		    dataUrl: '',
		    success: function () {},
		    cancel: function () {}
		});
		wx.onMenuShareQQ({
		    title: share.title,
		    desc: share.desc,
		    link: share.link,
		    imgUrl: share.imgUrl,
		    success: function () {},
		    cancel: function () {}
		});
		wx.onMenuShareWeibo({
		    title: share.title,
		    desc: share.desc,
		    link: share.link,
		    imgUrl: share.imgUrl,
		    success: function () {},
		    cancel: function () {}
		});
	});
})