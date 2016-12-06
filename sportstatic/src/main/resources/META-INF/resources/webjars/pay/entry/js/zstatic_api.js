/**
 * API调用相关
 * 
 * 
 */

var zstatic_api = {

	c : {

		api_key : 'testkey',
		api_url : '/api/',
		api_token : '',
		// 没有登录时的处理操作
		login_exec : ''
	},

	/*
	 * APi调用类
	 */
	api_call : function(sTarget, oData, fCallBack) {

		// 判断如果传入了oData则自动拼接 否则无所只传入key认证
		var defaults = oData;

		defaults.zoo = {
			'key' : zstatic_api.c.api_key,
			'token' : zstatic_api.c.api_token
		};

		// oData = $.extend({}, defaults, oData || {});

		zstatic_api.f.ajaxjson(zstatic_api.c.api_url + sTarget, defaults,
				function(data) {

					if (data.status == "1") {

						fCallBack(data);

					} else if (data.status == "801") {
						eval(zstatic_api.c.login_exec);
					} else {

						zstatic_api.f.message(data.error);

					}

				});

	},
	f : {
		tojson : function(oObj) {
			return JSON.stringify(oObj);
		},
		ajaxjson : function(sTarget, data, fCallBack) {

			var options = {

				dataType : "json",
				url : sTarget,
				type : "POST",
				contentType : "application/json",
				data : zstatic_api.f.tojson(data),
				success : fCallBack,
				error : function(msg) {

					console.log(msg);
					zstatic_api.f.message('error');
				}
			};

			$.ajax(options);

		},
		message : function(sMessage) {
			alert(sMessage);
		}
	}

};
