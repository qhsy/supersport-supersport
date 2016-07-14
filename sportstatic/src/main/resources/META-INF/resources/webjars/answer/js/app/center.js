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
						comm.tost(res.error);
					}
				}
			})
		},
		methods:{
			submit:function(){
				var self = this;
				if(self.result.answerUserInfo.title.length == 0){
					comm.tost('请设置您的头衔！')
					return ;
				}
				if(self.result.answerUserInfo.ability.length == 0){
					comm.tost('请设置您的简介！')
					return ;
				}
				if(self.result.answerUserInfo.charge == ''){
					comm.tost('请设置支付金额！')
					return ;
				}
				if( self.result.answerUserInfo.title.length > 18 && self.result.answerUserInfo.ability.length > 100 && self.result.answerUserInfo.charge.length == 0){
					comm.tost('请填写正确的内容！！')
					return ;
				}
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
							comm.tost(res.error);
						}
					}
				})
			},
			lengthFn:function(mes, num){
				if(mes.length > num){
					comm.tost('请输入的内容超过限制字符数！')
				}
			},
			isCharge:function(){
				var self = this;
				//var reg = /^[0-9]*[1-9][0-9]*$/g
				var reg = /^(([1-9][0-9]*)|(([0]\.[0-9][1-9]{1,2}|[0]\.[1-9]{1,2}|[1-9][0-9]*\.\d{1,2})))$/;
				if(!reg.test($.trim(self.result.answerUserInfo.charge))){
					comm.tost('请输入正确的金额！')
				}
			}
		}
	});
})