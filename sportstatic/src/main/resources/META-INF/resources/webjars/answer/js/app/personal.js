require(['zepto','vue','common','extend'],function($,Vue,comm){
	var userCode = comm.paramFn('code');
	var token = sessionStorage.getItem('token');
	var page = 1;
	var personal = new Vue({
		el: '#personal',
		data: {
			res:{}
		},
		ready:function(){
			var self = this;
				$.ajax({
					url:'/api/answerController/personHomePage',
					type:'POST',
					contentType:'application/json',
					dataType:'json',
					data:'{"pagination": ' + page + ',"userCode": "' + userCode + '","zoo": {"key": "tesetkey","token": "' + token + '"}}',
					success:function(res){
						if(res.status == 1){
							self.res = res;
						}else{
							alert(res.error);
						}
					}
				});
			}
		});
})