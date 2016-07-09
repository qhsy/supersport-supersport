require(['zepto','vue','common','extend'],function($,Vue,comm){
	var page = 1;
	var answer = new Vue({
		el: '#top',
		data: {
			answers: [],
	},
	ready:function(){
		var self = this;
			$.ajax({
				url:'/api/answerController/richAnswers',
				type:'POST',
				contentType:'application/json',
				dataType:'json',
				data:'{"page": ' + page + ',"zoo": {"key": "tesetkey","token": " "}}',
				success:function(res){
					if(res.status == 1){
						self.answers = res.answers;
					}else{
						alert(res.error);
					}
				}
			});
		}
	});
})