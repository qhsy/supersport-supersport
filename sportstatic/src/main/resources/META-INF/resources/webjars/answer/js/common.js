(function(window) {
	var common = {};
	sessionStorage.setItem('token','88f0df20a5f24935aa288e1ddc36a6f2eb127e53084e48ea907f8ca521c658d9899e41f4');
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
	// 全局变量
	window.common = common;
  
})(window);