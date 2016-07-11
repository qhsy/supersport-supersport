require(['zepto','vue','common','extend'],function($,Vue,comm){
	var userCode = comm.paramFn('code');
	var token = sessionStorage.getItem('token');
	var page = 1;
	var personal = new Vue({
		el: '#personal',
		data: {
			result:{}
		},
		created:function(){
			var self = this;
				$.ajax({
					url:'/api/answerController/personHomePage',
					type:'POST',
					contentType:'application/json',
					dataType:'json',
					data:'{"pagination": ' + page + ',"userCode": "' + userCode + '","zoo": {"key": "tesetkey","token": "' + token + '"}}',
					success:function(res){
						if(res.status == 1){
							self.result = res;
						}else{
							comm.tost(res.error);
						}
					}
				});
			},
			methods:{
				attendFlag:function(){
					var self = this;
					$.ajax({
						url:'/api/userController/userAttention',
						type:'POST',
						contentType:'application/json',
						dataType:'json',
						data:'{"flag": "0","userCode": "' + self.result.answerUserInfo.userCode + '","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
						success:function(res){
							if(res.status == 1){
								self.result.answerUserInfo.attendFlag = '1';
							}else{
								comm.tost(res.error);
							}
						}
					});
				}
			}
		});
})