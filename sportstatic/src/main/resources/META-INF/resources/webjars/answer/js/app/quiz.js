require(['zepto','vue','common','extend'],function($,Vue,comm){
	var userCode = comm.paramFn('code');
	var token = sessionStorage.getItem('token');
	var quiz = new Vue({
		el:'#question',
		data:{
			content:'',
			overt:true,
			num:0,
			result:{}
		},
		created:function(){
			var self = this;
			$.ajax({
				url:'/api/answerController/askQuestion',
				type:'POST',
				contentType:'application/json',
				dataType:'json',
				data:'{"code": "' + userCode + '","zoo": {"key": "tesetkey","token": "' + token + '"}}',
				success:function(res){
					if(res.status == 1){
						self.result = res.show;
					}else{
						alert(res.error);
					}
				}
			})
		},
		methods:{
			overtFn:function(){
				this.overt = !this.overt;
			},
			change:function(){
				var self = this;
				self.num = self.content.length;
				
			},
			submitFn:function(){
				var self = this;
				if(self.content.length > 60) return false;
				$.ajax({
					url:'/api/answerController/saveQuestion',
					type:'POST',
					contentType:'application/json',
					dataType:'json',
					data:'{"answerUserCode": "' + userCode + '","content": "' + self.content + '","scope": "' + self.overt + '","zoo": {"key": "tesetkey","token": "' + token + '"}}',
					success:function(res){
						console.log(self.content)
						if(res.status == 1){
							window.location.href = 'details.html?id=' + res.code;
						}else{
							alert(res.error);
						}
					}
				});
			}
		}
	});
})