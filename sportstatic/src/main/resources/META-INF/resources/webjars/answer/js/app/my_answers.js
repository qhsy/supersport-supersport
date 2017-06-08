require(['zepto','vue','common','jssdk','qrcode','extend'],function($,Vue,comm,wx,QRCode){
	var page = 1;
	var num = 20;
	var answer = new Vue({
		el: '#my-answers',
		data: {
			status:['','dzsd4888100110010001'],
			currStatus:'',
			currClass:0,
			result:{},
			browser:false
		},
		watch: {
			currStatus: 'getData'
		},
		created:function(){
			var self = this;
			var weix = navigator.userAgent.indexOf('MicroMessenger') > -1;
				if(!weix){
					self.browser = true;
					comm.qrcode();
					return ;
				}
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