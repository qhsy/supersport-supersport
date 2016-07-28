define(['zepto','jssdk','qrcode'],function($,wx,QRCode){
	var common = {};
	//sessionStorage.setItem('token','f8ede4925ec74374a032d453afd7f6d5d101126d930e4f52b24bc20f1cc9f0aabb9d5953');
	common.appId = 'wxec842da73ebe11a4'; //wxec842da73ebe11a4

	common.paramFn = function (arg){
		var url = window.location.search;
		if(typeof url != 'string' || url == '') return;
		var newUrl = url.substr(1);
		var urlArr = newUrl.split('&');
		for(var i=0; i<urlArr.length; i++){
			var arr = urlArr[i].split('=');
			for(j=0; j<arr.length; j++){
				if(arg == arr[0]){
					return arr[1]
				}
			}
		}
	}
	common.qrcode = function(){
		setTimeout(function(){
			new QRCode('qrcode', {
				text: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=' + common.appId + '&redirect_uri=' + common.getUrl() + '&response_type=code&scope=snsapi_userinfo&state=512457895#wechat_redirect',
				width:192,
				height:192
			});
		}, 1);
	}
	common.token = function(){
		if(sessionStorage.getItem('token')){
			return sessionStorage.getItem('token');
		}else{
			return '';
		}
	}
	common.code = function(){
		if(sessionStorage.getItem('code')){
			return sessionStorage.getItem('code');
		}else{
			return '';
		}
	}
	common.getUrl = function(){
		var href = window.location.href;
		var newurl = '';
		var length = href.indexOf('code');
		length >= 0?newUrl = href.substr(0,length-1):newUrl = href;
		return newUrl;
	}
	common.tost = function(mes){
		var element = $('<div class="tost"><em>' + mes + '</em></div>');
		var tost = element.appendTo('body');
		setTimeout(function(){
			tost.remove();
		}, 1500)
	}
	common.getItem = function(attr){
		if(sessionStorage.getItem(attr)){
			return sessionStorage.getItem(attr);
		}else{
			return '';
		}
	}
	/**
	 * @desc: share
	 * @date: 2016.07.18
	 * @author: wangxh
	 */
	common.share = {
		title:'[果冻体育]您的健康运动加油站',
		link:'https://open.weixin.qq.com/connect/oauth2/authorize?appid=' + common.appId + '&redirect_uri=' + common.getUrl() + '&response_type=code&scope=snsapi_userinfo&state=512457895#wechat_redirect',
		desc:'精彩内容与你分享',
		imgUrl:'http://img-cdn.bigtiyu.com/wsc/sport/273cb/s-87-87/371dd1482017495d95a4592a6877f6cf.png',
	}
	/**
	 * @desc: token
	 * @date: 2016.07.15
	 * @author: wangxh
	 */
	var isWeix = navigator.userAgent.indexOf('MicroMessenger') > -1;
	if(isWeix && !common.getItem('code')){
		var wxCode = common.paramFn('code');
		$.ajax({
			url:'/api/wechatController/authLogin2',
			type:'POST',
			contentType:'application/json',
			dataType:'json',
			async:false,
			data:'{"code": "' + wxCode + '","zoo": {"key": "tesetkey","token": " "}}',
			success:function(res){
				if(res.status == 1){
					sessionStorage.setItem('code',res.userCode);
					sessionStorage.setItem('token',res.userToken);
				}else{
					common.token(res.error);
				}
			}
		});
	}
	
	/**
	 * @desc: appid
	 * @date: 2016.07.15
	 * @author: wangxh
	 */
	if(isWeix){
		$.ajax({
			url:'/api/wechatController/configInfo',
			type:'POST',
			contentType:'application/json',
			dataType:'json',
			data:'{"url": "' + window.location.href + '","zoo": {"key": "tesetkey", "token": "' + common.token() + '"}}',
			success:function(res){
				if(res.status == 1){
					return wx.config({    
						debug: false,
						appId: res.appId,
						timestamp: res.timestamp,
						nonceStr: res.nonceStr,
						signature: res.signature,
						jsApiList: ['checkJsApi','startRecord','stopRecord','onVoiceRecordEnd','playVoice','pauseVoice','stopVoice','onVoicePlayEnd','uploadVoice','downloadVoice','onMenuShareTimeline','onMenuShareAppMessage','onMenuShareQQ','onMenuShareWeibo','onMenuShareQZone']
					});
				}
			}
		});

		wx.ready(function(){
			wx.onMenuShareTimeline({
			    title: common.share.title,
			    link: common.share.link, 
			    imgUrl: common.share.imgUrl,
			    success: function () {},
			    cancel: function () {}
			});
			wx.onMenuShareAppMessage({
			    title: common.share.title,
			    desc: common.share.desc,
			    link: common.share.link,
			    imgUrl: common.share.imgUrl,
			    type: '',
			    dataUrl: '',
			    success: function () {},
			    cancel: function () {}
			});
			wx.onMenuShareQQ({
			    title: common.share.title,
			    desc: common.share.desc,
			    link: common.share.link,
			    imgUrl: common.share.imgUrl,
			    success: function () {},
			    cancel: function () {}
			});
			wx.onMenuShareWeibo({
			    title: common.share.title,
			    desc: common.share.desc,
			    link: common.share.link,
			    imgUrl: common.share.imgUrl,
			    success: function () {},
			    cancel: function () {}
			});
		});
	}
	
	return common;
});