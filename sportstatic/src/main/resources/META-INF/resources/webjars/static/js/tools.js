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
	}
}