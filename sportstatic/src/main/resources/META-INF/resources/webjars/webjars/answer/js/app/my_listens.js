require(['zepto','vue','common','jssdk','qrcode','extend'],function($,Vue,comm,wx,QRCode){
	var num = 0;
	var currPage = 0;
	var sumsPage = 0;
	var listens = new Vue({
		el:'#listens',
		data:{
			result:{},
			browser:false
		},
		created:function(){
			var self = this;
			var weix = navigator.userAgent.indexOf('MicroMessenger') > -1;
			if(!weix){
				self.browser = true;
				comm.qrcode();
				return ;
			}
			$.ajax({
				url:'/api/answerController/myListens',
				type:'POST',
				contentType:'application/json',
				dataType:'json',
				data:'{"pageNum": ' + num + ',"pagination": ' + currPage + ',"zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
				success:function(res){
					if(res.status == 1){
						self.result = res;
					}else{
						alert(res.error);
					}
				}
			})
		}
	});
})