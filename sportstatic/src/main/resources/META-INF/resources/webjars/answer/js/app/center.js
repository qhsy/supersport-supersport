require(['zepto','vue','common','extend'],function($,Vue,comm){
	var center = new Vue({
		el:'#center',
		data:{
			result:{}
		},
		created:function(){
			var self = this;
			$.ajax({
				url:'/api/answerController/answerUserInfo',
				type:'POST',
				contentType:'application/json',
				dataType:'json',
				data:'{"zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
				success:function(res){
					if(res.status == 1){
						self.result = res;
					}else{
						alert(res.error);
					}
				}
			})
		},
		methods:{
			open:function(){
				$.ajax({
					url:'/api/answerController/openAskQuestion',
					type:'POST',
					contentType:'application/json',
					dataType:'json',
					data:'{"zoo":{"key":"tesetkey","token": "' + comm.token() + '"}}',
					success:function(res){
						if(res.status == 1){
							window.location.href = 'center_edit.html'

						}else{
							alert(res.error);
						}
					}
				})
			},
			submit:function(){
				var self = this;
				$.ajax({
					url:'/api/answerController/updateUserInfo',
					type:'POST',
					contentType:'application/json',
					dataType:'json',
					data:'{"ability": "' + self.result.answerUserInfo.ability + '","charge": ' + self.result.answerUserInfo.charge + ',"title": "' + self.result.answerUserInfo.title + '","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
					success:function(res){
						if(res.status == 1){
							window.location.href = 'center.html'
						}else{
							alert(res.error);
						}
					}
				})
			}
		}
	});
})