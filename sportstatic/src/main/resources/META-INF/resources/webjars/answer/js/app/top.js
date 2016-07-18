require(['zepto','vue','common','jssdk','qrcode','extend'],function($,Vue,comm,wx,QRCode){
	var page = 1;
	var vm = new Vue({
		el: '#top',
		data: {
			answers: []
	},
	created:function(){
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
						comm.tost(res.error);
					}
				}
			});
		}
	});
	vm.$on('iscroll',function(){
		var bStop = true;
		var self = this;
		$(window).on('scroll',function(){
			var iHeight = $('.wrap').height();
			var winHeight = $(window).height();
			var scrollHeight = $(window).scrollTop();
			if(iHeight ==  (winHeight + scrollHeight)){
				if(bStop){
					bStop = false;
					page++;
					$.ajax({
						url:'/api/answerController/richAnswers',
						type:'POST',
						contentType:'application/json',
						dataType:'json',
						data:'{"page": ' + page + ',"zoo": {"key": "tesetkey","token": " "}}',
						success:function(res){
							if(res.status == 1){
								if(res.answers.length){
									$.each(res.answers,function(index, item){
										self.answers.push(item);
									});
									bStop = true;
								}
							}else{
								comm.tost(res.error);
							}
						}
					});
				}
			}
			
		});
	})
	vm.$emit('iscroll');
})