require(['zepto','vue','common','jssdk','qrcode','extend'],function($,Vue,comm,wx,QRCode){
	var page = 1;
	var follow = new Vue({
		el: '#follow',
		data: {
			result: {},
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
				url:'/api/answerController/attendList',
				type:'POST',
				contentType:'application/json',
				dataType:'json',
				data:'{"pagination": ' + page + ',"userCode": "' + comm.code('code') + '","zoo": {"key": "tesetkey","token": "' + comm.token() + '"}}',
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
})