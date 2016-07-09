require(['zepto','vue','common','extend'],function($,Vue,comm){
	var page = 1;
	var vm = new Vue({
		el: '#new-questions',
		data: {
			questions: [],
	},
	created:function(){
		var self = this;
			$.ajax({
				url:'/api/answerController/newQuestions',
				type:'POST',
				contentType:'application/json',
				dataType:'json',
				data:'{"page": ' + page + ',"zoo": {"key": "tesetkey","token": " "}}',
				success:function(res){
					if(res.status == 1){
						self.questions = res.questions;
					}else{
						alert(res.error);
					}
				}
			});
		}
	});
})