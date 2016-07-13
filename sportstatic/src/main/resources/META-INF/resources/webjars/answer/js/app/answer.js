require(['zepto','vue','common','extend'],function($,Vue,comm){
	var page = 1;
	var vm = new Vue({
		el: '#answer',
		data: {
			result:{},
			isCurr: 1
	},
	created:function(){
		var self = this;
		$.ajax({
			url:'/api/answerController/hotQuestions',
			type:'POST',
			contentType:'application/json',
			dataType:'json',
			data:'{"page": ' + page + ',"zoo": {"key": "tesetkey","token": ""}}',
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
	// vm.$on('iscroll',function(){
	// 	var bStop = true;
	// 	var self = this.result;
	// 	$(window).on('scroll',function(){
	// 		var iHeight = $('.wrap').height();
	// 		var winHeight = $(window).height();
	// 		var scrollHeight = $(window).scrollTop();
	// 		if(iHeight ==  (winHeight + scrollHeight)){
	// 			if(bStop){
	// 				bStop = false;
	// 				page++;
	// 				$.ajax({
	// 					url:'/api/answerController/hotQuestions',
	// 					type:'POST',
	// 					contentType:'application/json',
	// 					dataType:'json',
	// 					data:'{"page": ' + page + ',"zoo": {"key": "tesetkey","token": ""}}',
	// 					success:function(res){
	// 						if(res.status == 1){
	// 							if(res.questions.length){
	// 								$.each(res.questions,function(index, item){
	// 									self.questions.push(item);
	// 								});
	// 								bStop = true;
	// 							}
	// 						}else{
	// 							comm.tost(res.error);
	// 						}
	// 					}
	// 				});
	// 			}
	// 		}
			
	// 	});
	// })
	// vm.$emit('iscroll');
})