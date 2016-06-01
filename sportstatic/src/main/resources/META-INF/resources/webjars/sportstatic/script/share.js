/**
	 * open APP
	 */
	function open(){
		var u = navigator.userAgent,app = navigator.appVersion;
		var browser = {
			language: (navigator.browserLanguage || navigator.language).toLowerCase(),
			window:u.indexOf('Windows') > -1,		//window
			mac:u.indexOf('Mac') > -1,		//Mac OS
			mobile:u.indexOf('Mobile') > -1 && u.indexOf('AppleWebKit') > -1,		//Mobile
			android:u.indexOf('Linux') > -1 && u.indexOf('Android') > -1,		//Android
			ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/),		
			iPad:u.indexOf('iPad') > -1 && u.indexOf('Mac') > -1,		//iPad
			iPod:u.indexOf('iPod') > -1 && u.indexOf('Mac') > -1,		//iPod
			iPhone:u.indexOf('iPhone') > -1 && u.indexOf('Mac') > 1,		//iPhone
			trident:u.indexOf('Trident') > -1,		//IE
			presto: u.indexOf('Presto') > -1,		//opera内核 
			webKit: u.indexOf('AppleWebKit') > -1,		//苹果、谷歌内核 
			gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1,		//gecko
			microMessenger:u.indexOf('MicroMessenger') > -1		//QQ weixin
		}
		if(browser.ios || browser.iPad || browser.iPhone || browser.iPod){
			if(browser.microMessenger){
				window.location.replace("");
			}else{
				openclient({
					scheme: 'xtyjgd://',
					download: 'https://itunes.apple.com/us/app/guo-dong-yun-dong-shi-ke/id1107505487?l=zh&ls=1&mt=8'
				});
			}
		} else if(browser.android){
			if(browser.microMessenger){
				window.location.replace("");
			}else{
				openclient({
					scheme: 'godosports://',
					download: ''
				});
			}
		}
	}
	function openclient(con) {
		var ua = navigator.userAgent.toLowerCase();
		var t;
		var config = con;
		var startTime = Date.now();
		var timeout = 600;
		var ifr = document.createElement('iframe');
		ifr.src = config.scheme;
		ifr.style.display = 'none';
		document.body.appendChild(ifr);
		var t = setTimeout(function() {
			var endTime = Date.now();
			if (!startTime || endTime - startTime < timeout + 200) {
				window.location = config.download;
			}
		}, timeout);
		window.onblur = function() {
			clearTimeout(t);
		}
	}