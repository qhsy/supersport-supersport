require(['zepto','vue','common','extend'],function($,Vue,comm){
	var code = comm.paramFn('id');
	var details = new Vue({
		el: '#details',
		data: {
			result:null
		},
		created:function(){
			var self = this;
			$.ajax({
				url:'/api/answerController/questionDetail',
				type:'POST',
				contentType:'application/json',
				dataType:'json',
				data:'{"code": "' + code + '","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
				success:function(res){
					if(res.status == 1){
						self.result = res;
					}else{
						alert(res.error);
					}
				}
			});
		},
		methods:{
			assistFn:function(){

			},
			payFn:function(){

			},
			audio:function(){

			}
		}

	});
})