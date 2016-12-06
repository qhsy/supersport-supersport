var manage_home = {
	temp : {
		paths : [],
		lastcode : '',

		// 当前选择的一级菜单
		navnow : '',

		navid : 'nav_li_'
	},
	index : function() {

		zstatic_page.login_check();

		ReactDOM.render(React.createElement("div", {
			className : 'form-horizontal'
		}, '...'), document.getElementById(zstatic_config.id.main));

		this.page();

	},

	page : function(sPageUrl) {

		zstatic_api.api_call('zooweb/post/webpath', {

		}, manage_home.page_success

		);

	},
	page_success : function(oData) {

		manage_home.temp.paths = oData.pathInfos;
		$('#home_username').html(oData.userName);
		
		
		if (navigator.userAgent.match(/mobile/i)) {
			
			manage_home.page_menu();
		}
		
		manage_home.top_nav();

	},
	
	//页面菜单
	page_menu:function()
	{
		
      
      var aList = [];
      
      for ( var i in manage_home.temp.paths) {
    	  
    	  var oItem = manage_home.temp.paths[i];

			if (oItem["parentCode"] == '') {
				
				
				aList.push('<div class="panel panel-success">');
				aList.push('<div class="panel-heading"><h3 class="panel-title">'+oItem["nodeName"]+'</h3></div>');
				aList.push('<div class="panel-body">');
				
				
				for ( var i in manage_home.temp.paths) {
					var oSub = manage_home.temp.paths[i];
					
					if (oSub["parentCode"] == oItem["code"]) {
						
						//aList.push(oSub['nodeName']);
						
						for ( var n in manage_home.temp.paths) {
							var oChild = manage_home.temp.paths[n];
							
							if (oChild["parentCode"] == oSub["code"]) {
								//aList.push(oChild['nodeName']);
								
								
								aList.push('<a class="btn btn-default "'
										
										+' href="javascript:manage_home.page_href(\''
										+ oChild["code"] + '\')">'
										+ '<span class="w_mr_05 glyphicon '
										+ oChild["pageIcon"] + '"></span>'
										+ oChild["nodeName"] + '</a>');
								
								
								
								
								
								
							}
							
						}
						
					}
					
					
				}
				
				
				
				aList.push('</div></div>');

				
			}
    	  
      }
      
      $('#'+zstatic_config.id.header).html('');
      $('#'+zstatic_config.id.main).html(aList.join(''));
      
      
      
      
	},

	top_nav : function() {

		var aList = [];
		for ( var i in manage_home.temp.paths) {
			var oItem = manage_home.temp.paths[i];

			if (oItem["parentCode"] == '') {
				if (manage_home.temp.navnow == '') {
					manage_home.temp.navnow = oItem["code"];
				}

				aList.push('<li id="' + manage_home.temp.navid + oItem["code"]
						+ '" ><a href="javascript:manage_home.nav_select(\''
						+ oItem["code"] + '\')">' + oItem["nodeName"]
						+ '</a></li>');
			}
		}

		$('#manage_home_topnav').html(aList.join(''));

		this.nav_select(manage_home.temp.navnow);
		// $.material.init();

	},

	up_nav : function(sCode) {
		var oReturn = null;
		for ( var i in manage_home.temp.paths) {
			var oItem = manage_home.temp.paths[i];
			if (oItem["code"] == sCode) {
				oReturn = oItem;
			}
		}
		return oReturn;
	},

	nav_select : function(sNow) {

		$('#' + manage_home.temp.navid + manage_home.temp.navnow).removeClass(
				'active');
		$('#' + manage_home.temp.navid + sNow).addClass('active');
		manage_home.temp.navnow = sNow;

		zstatic_page.temp.navtext[0] = manage_home.up_nav(sNow)['nodeName'];

		manage_home.path_show();

	},

	path_show : function() {
		var aPathLi = [];

		var aHtml = [];
		for ( var i in manage_home.temp.paths) {
			var oItem = manage_home.temp.paths[i];

			// class="glyphicon glyphicon-th" aria-hidden="true"

			if (oItem["parentCode"] == manage_home.temp.navnow) {
				aHtml
						.push('<li class="active"><a class="w_mr_05" href="javascript:manage_home.path_nav()">'
								+ oItem["nodeName"]
								+ '<span class="w_ml_05 glyphicon glyphicon-chevron-down pull-right"></span></a></li>');

				for ( var n in manage_home.temp.paths) {

					var oSub = manage_home.temp.paths[n];
					if (oSub["parentCode"] == oItem["code"]) {
						aHtml
								.push('<li><a class="btn btn-default '
										+ (manage_home.temp.lastcode == oSub["code"] ? 'w_bg_white'
												: '')
										+ '" id="'
										+ manage_home.temp.navid
										+ oSub["code"]
										+ '" href="javascript:manage_home.page_href(\''
										+ oSub["code"] + '\')">'
										+ '<span class="w_mr_05 glyphicon '
										+ oSub["pageIcon"] + '"></span>'
										+ oSub["nodeName"] + '</a></li>');
					}
				}

			}

		}

		$('#manage_home_sidebar').html(
				'<ul class="nav nav-sidebar">' + aHtml.join('') + '</ul>');
		$.material.init();

	},

	path_nav : function() {

	},

	page_href : function(sCode, sLink) {

		var oItem = manage_home.up_nav(sCode);
		zstatic_page.temp.navtext[1] = oItem['nodeName'];

		$('#' + manage_home.temp.navid + manage_home.temp.lastcode)
				.removeClass('w_bg_white');
		$('#' + manage_home.temp.navid + sCode).addClass('w_bg_white');
		manage_home.temp.lastcode = sCode;
		// clear cache page array
		zstatic_page.temp.pagearray = [];
		zstatic_page.page(oItem['pageUrl']);
	}

};
