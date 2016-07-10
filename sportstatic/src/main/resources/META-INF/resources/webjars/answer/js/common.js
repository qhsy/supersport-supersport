define(['zepto'],function($){
	var common = {};
	//sessionStorage.setItem('token','b261172782724d45804fa428e22780cbd1321d58ec8749a8973e3abd3efac5166cd5bf7c');
	if(!sessionStorage.getItem('token')){
		var wxCode = comm.paramFn('code');
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
	return common;
});