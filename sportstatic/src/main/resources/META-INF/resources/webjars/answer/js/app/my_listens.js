require(['zepto','vue','common','extend'],function($,Vue,comm){
	var num = 0;
	var currPage = 0;
	var sumsPage = 0;
	var listens = new Vue({
		el:'#listens',
		data:{
			result:{}
		},
		created:function(){
			var self = this;
			$.ajax({
				url:'/api/answerController/myListens',
				type:'POST',
				contentType:'application/json',
				dataType:'json',
				data:'{"pageNum": ' + num + ',"pagination": ' + currPage + ',"zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
				success:function(res){
					if(res.status == 1){
						self.result = res;
					}else{
						alert(res.error);
					}
				}
			})
		}
	});
})