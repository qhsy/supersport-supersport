require(['zepto','vue','common','extend'],function($,Vue,comm){
	var page = 1;
	var answer = new Vue({
		el: '#answer',
		data: {
			questions:[],
			isCurr: 1
	},
	created:function(){
		var self = this;
			$.ajax({
				url:'/api/answerController/hotQuestions',
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