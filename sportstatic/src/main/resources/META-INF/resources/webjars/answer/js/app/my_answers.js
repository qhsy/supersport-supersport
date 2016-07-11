require(['zepto','vue','common','extend'],function($,Vue,comm){
	var page = 1;
	var num = 20;
	var answer = new Vue({
		el: '#my-answers',
		data: {
			status:['','dzsd4888100110010001'],
			currStatus:'',
			currClass:0,
			result:{}
		},
		watch: {
			currStatus: 'getData'
		},
		created:function(){
			var self = this;
				self.getData();
		},
		methods:{
			getData:function(){
				var self = this;
				$.ajax({
					url:'/api/answerController/myAnswers',
					type:'POST',
					contentType:'application/json',
					dataType:'json',
					data:'{"pageNum": ' + num + ',"pagination": ' + page + ',"status": "' + self.currStatus + '","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
					success:function(res){
						if(res.status == 1){
							self.result = res;
						}else{
							comm.tost(res.error);
						}
					}
				});
			},
			tab:function(index){
				var self = this;
					self.currStatus = self.status[index];
					self.currClass = index;
			}
		}
	});
})