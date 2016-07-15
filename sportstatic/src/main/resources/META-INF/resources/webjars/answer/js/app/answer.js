require(['zepto','vue','common','jssdk','qrcode','extend'],function($,Vue,comm,wx,QRCode){
	var page = 1;
	var share = {
		title:'[果冻体育]您的健康运动加油站',
		link:window.location.href,
		desc:'精彩内容与你分享',
		imgUrl:'http://img-cdn.bigtiyu.com/wsc/sport/273cb/s-87-87/371dd1482017495d95a4592a6877f6cf.png',
	}
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
	wx.ready(function(){
		wx.onMenuShareTimeline({
		    title: share.title,
		    link: share.link, 
		    imgUrl: share.imgUrl,
		    success: function () {},
		    cancel: function () {}
		});
		wx.onMenuShareAppMessage({
		    title: share.title,
		    desc: share.desc,
		    link: share.link,
		    imgUrl: share.imgUrl,
		    type: '',
		    dataUrl: '',
		    success: function () {},
		    cancel: function () {}
		});
		wx.onMenuShareQQ({
		    title: share.title,
		    desc: share.desc,
		    link: share.link,
		    imgUrl: share.imgUrl,
		    success: function () {},
		    cancel: function () {}
		});
		wx.onMenuShareWeibo({
		    title: share.title,
		    desc: share.desc,
		    link: share.link,
		    imgUrl: share.imgUrl,
		    success: function () {},
		    cancel: function () {}
		});
	});
	vm.$on('iscroll',function(){
		var bStop = true;
		var self = this.result;
		$(window).on('scroll',function(){
			var iHeight = $('.wrap').height();
			var winHeight = $(window).height();
			var scrollHeight = $(window).scrollTop();
			if(iHeight ==  (winHeight + scrollHeight)){
				if(bStop){
					bStop = false;
					page++;
					$.ajax({
						url:'/api/answerController/hotQuestions',
						type:'POST',
						contentType:'application/json',
						dataType:'json',
						data:'{"page": ' + page + ',"zoo": {"key": "tesetkey","token": ""}}',
						success:function(res){
							if(res.status == 1){
								if(res.questions.length){
									$.each(res.questions,function(index, item){
										self.questions.push(item);
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