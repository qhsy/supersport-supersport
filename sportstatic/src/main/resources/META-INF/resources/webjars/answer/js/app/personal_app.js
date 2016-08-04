require(['zepto','vue','common','jssdk','qrcode','extend'],function($,Vue,comm,wx,QRCode){
	var userCode = comm.paramFn('userCode');
	var share = {
		title:'[果冻体育]您的健康运动加油站',
		link:'https://open.weixin.qq.com/connect/oauth2/authorize?appid=' + comm.appId + '&redirect_uri=' + comm.getUrl() + '&response_type=code&scope=snsapi_userinfo&state=512457895#wechat_redirect',
		desc:'精彩内容与你分享',
		imgUrl:'',
	}
	Vue.component('sports',{
		template:'#sports',
		props:{
			item: null
		}
	});
	Vue.component('answer',{
		template:'#answer',
		props:{
			item: null,
			head: null
		}
	})
	var personal = new Vue({
		el: '#personal',
		data: {
			result:{},
			browser:false,
			viewTab:['contentTab','questionTab'],
			currView:'contentTab',
			contentPage:1,
			questionPage:1
		},
		created:function(){
			this.getData();
		},
		watch:{
			'currView':'getData'
		},
		methods:{
			getData:function(){
				var self = this;
				$.ajax({
					url:'/api/answerController/appPersonHome',
					type:'POST',
					contentType:'application/json',
					dataType:'json',
					data:'{"pagination": ' + self.contentPage + ',"type": "' + self.currView + '","userCode": "' + userCode + '","zoo": {"key": "tesetkey","token": " "}}',
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
			tabEvent:function(index){
				this.currView = this.viewTab[index];
			},
			attendFlag:function(){
				var self = this;
				var weix = navigator.userAgent.indexOf('MicroMessenger') > -1;
				if(!weix){
					self.browser = true;
					comm.qrcode();
					return ;
				}
			},
			anwser:function(event){
				var self = this;
				var weix = navigator.userAgent.indexOf('MicroMessenger') > -1;
				if(!weix){
					self.browser = true;
					comm.qrcode();
					event.preventDefault()
					return ;
				}
			},
			open:function(){
				open();
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