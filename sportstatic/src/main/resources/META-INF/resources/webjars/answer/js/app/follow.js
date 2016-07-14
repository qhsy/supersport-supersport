require(['zepto','vue','common','extend'],function($,Vue,comm){
	var page = 1;
	var follow = new Vue({
		el: '#follow',
		data: {
			result: {}
	},
	ready:function(){
		var self = this;
			$.ajax({
				url:'/api/userController/attendList',
				type:'POST',
				contentType:'application/json',
				dataType:'json',
				data:'{"pagination": ' + page + ',"userCode": "' + sessionStorage.getItem('code') + '","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
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
})