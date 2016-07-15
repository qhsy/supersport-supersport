require(['zepto','vue','common','jssdk','qrcode','extend'],function($,Vue,comm,wx,QRCode){
	var page = 1;
	var share = {
		title:'[果冻体育]您的健康运动加油站',
		link:window.location.href,
		desc:'精彩内容与你分享',
		imgUrl:'http://img-cdn.bigtiyu.com/wsc/sport/273cb/s-87-87/371dd1482017495d95a4592a6877f6cf.png',
	}
	var follow = new Vue({
		el: '#follow',
		data: {
			result: {},
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
				url:'/api/answerController/attendList',
				type:'POST',
				contentType:'application/json',
				dataType:'json',
				data:'{"pagination": ' + page + ',"userCode": "' + comm.code('code') + '","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
				success:function(res){
					if(res.status == 1){
						self.result = res;
					}else{
						comm.tost(res.error);
					}
				}
			});
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