/**
 * queryUrl
 * @return [json]
 * @author [wangxh]
 */
function queryUrl(name){
	var url = location.search;
	var request = '';
	if (url.indexOf("?") != -1) {
		var str = url.substr(1);
		var result = str.split("&");
		for (var i = 0; i < result.length; i++) {
			var arr = result[i].split("=");
			if(arr[0] == name){
				request = unescape(arr[1]);
			}
		}
	}
	return request;
}

/**
 * @callbackFunc
 * @param  [string] code
 * @return [Function]
 * @author [wangxh]
 */
function callbackFunc(code){
	var userAgent = navigator.userAgent;
	if(userAgent.indexOf('Android') != -1){
		javascript:android.callbackFunc(code);
	} else {
		window.webkit.messageHandlers.callbackFunc.postMessage(code);
	}
}

/**
 * @callbackLabel
 * @param  [string] code 
 * @param  [string] name
 * @return [Function]
 * @author [wangxh]
 */
function callbackLabel(code,name){
	var userAgent = navigator.userAgent;
	if(userAgent.indexOf('Android') != -1){
		javascript:android.callbackLabel(code,name);
	} else {
		window.webkit.messageHandlers.callbackLabel.postMessage([code,name]);
	}
}

/**
 * @callbackShare
 * @param  [string] id 
 * @return [Function]
 * @author [wangxh]
 */
function callbackShare(id){
	var userAgent = navigator.userAgent;
	if(userAgent.indexOf('Android') != -1){
		javascript:android.callbackShare(id);
	} else {
		window.webkit.messageHandlers.callbackShare.postMessage(id);
	}
}

/**
 * @callbackSportTime
 * @param  [string] code|type	
 * @return [Function]
 * @author [wangxh]
 */
function callbackSportTime(code,type){
	var userAgent = navigator.userAgent;
	if(userAgent.indexOf('Android') != -1){
		javascript:android.callbackSportTime(code,type);
	} else {
		window.webkit.messageHandlers.callbackSportTime.postMessage([code,type]);
	}
	
}

/**
 * @callWebTitle
 * @param  [string]	val
 * @return [Function]
 * @author [wangxh]
 */
function callWebTitle(val){
	var userAgent = navigator.userAgent;
	if(userAgent.indexOf('Android') != -1){
		javascript:android.callWebTitle(val);
	} else {
		window.webkit.messageHandlers.callWebTitle.postMessage(val);
	}
	
}

/**
 * @callFineshPage
 * @param  
 * @return [Function]
 * @author [wangxh]
 */
function callFineshPage(){
	var userAgent = navigator.userAgent;
	if(userAgent.indexOf('Android') != -1){
		javascript:android.callFineshPage();
	} else {
		window.webkit.messageHandlers.callFineshPage.postMessage();
	}
	
}

/**
 * @callbackPublish
 * @param  type 1、图片	2、图集	3、文章	4、视频；code name
 * @return [Function]
 * @author [wangxh]
 */
function callbackPublish(type, code, name){
	var userAgent = navigator.userAgent;
	if(userAgent.indexOf('Android') != -1){
		javascript:android.callbackPublish(type,code,name);
	} else {
		window.webkit.messageHandlers.callbackPublish.postMessage([type,code,name]);
	}
}


/**
 * @微信分享
 * @param  config
 * @return [Function]
 * @author [wangxh]
 */
function shareWeiXin(config){
	var isWeix = navigator.userAgent.indexOf('MicroMessenger') > -1;
	var con = {
		'url':config && config.url || '',
		'imgUrl':config && config.imgUrl || '',
		'title':config && config.title || '',
		'link':config && config.link || '',
		'desc':config && config.desc || '',
		'type':config && config.type || '',
		'dataUrl':config && config.dataUrl || '',
		'success':config && config.success || function(){},
		'cancel':config && config.cancel || function(){}
	}
	if(isWeix){
		$.ajax({
			url: con.url,
			type: 'post',
			data: '{"url": "' + window.location.href + '","zoo": {"key": "tesetkey", "token": ""}}',
			dataType: 'json',
			contentType: 'application/json',
			success: function(res) {
				console.log(res)
				if(res.status == 1){
					wx.config({    
						debug: false,
						appId: res.appId,
						timestamp: res.timestamp,
						nonceStr: res.nonceStr,
						signature: res.signature,
						jsApiList: ['checkJsApi','onMenuShareTimeline','onMenuShareAppMessage','onMenuShareQQ','onMenuShareWeibo','onMenuShareQZone']
					});
					wx.ready(function(){
						//分享到朋友圈
						wx.onMenuShareTimeline({
						    title: con.title,
						    link: con.link, 
						    imgUrl: con.imgUrl,
						    success: function () {
						    	con.success();
						    },
						    cancel: function () {
						    	con.cancel();
						    }
						});
						//分享给朋友
						wx.onMenuShareAppMessage({
						    title: con.title,
						    desc: con.desc,
						    link: con.link,
						    imgUrl: con.imgUrl,
						    type: con.type,
						    dataUrl: con.dataUrl,
						    success: function () {
						    	con.success();
						    },
						    cancel: function () {
						    	con.cancel();
						    }
						});
						//分享到QQ
						wx.onMenuShareQQ({
						    title: con.title,
						    desc: con.desc,
						    link: con.link,
						    imgUrl: con.imgUrl,
						    success: function () {
						    	con.success();
						    },
						    cancel: function () {
						    	con.cancel();
						    }
						});
						//分享到腾讯微博
						wx.onMenuShareWeibo({
						    title: con.title,
						    desc: con.desc,
						    link: con.link,
						    imgUrl: con.imgUrl,
						    success: function () {
						    	con.cancel();
						    },
						    cancel: function () {
						    	con.cancel();
						    }
						});
						//分享到QQ空间
						wx.onMenuShareQZone({
						    title: con.title,
						    desc: con.desc,
						    link: con.link,
						    imgUrl: con.imgUrl,
						    success: function () {
						    	con.cancel();
						    },
						    cancel: function () {
						    	con.cancel();
						    }
						});
					});
				}
			}
		});
	}
	
}
