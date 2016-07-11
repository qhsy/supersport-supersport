define(['zepto'],function($){
	var common = {};
	//sessionStorage.setItem('token','f8ede4925ec74374a032d453afd7f6d5d101126d930e4f52b24bc20f1cc9f0aabb9d5953');

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
	common.token = function(){
		if(sessionStorage.getItem('token')){
			return sessionStorage.getItem('token');
		}else{
			return '';
		}
	}
	common.tost = function(mes){
		var element = $('<div class="tost"><em>' + mes + '</em></div>');
		var tost = element.appendTo('body');
		setTimeout(function(){
			tost.remove();
		}, 1500)
	}
	if(!sessionStorage.getItem('token')){
		var wxCode = common.paramFn('code');
		$.ajax({
			url:'/api/wechatController/authLogin',
			type:'POST',
			contentType:'application/json',
			dataType:'json',
			data:'{"code": "' + wxCode + '","zoo": {"key": "tesetkey","token": " "}}',
			success:function(res){
				if(res.status == 1){
					sessionStorage.setItem('code',res.userCode);
					sessionStorage.setItem('token',res.userToken);
				}else{
					alert(res.error);
				}
			}
		});
	}
	return common;
});