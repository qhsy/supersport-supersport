/*
 * 
 * form中的input
 */
var Zstatic_Form_Input = React.createClass({
	displayName : 'Zstatic_Form_Input',

	render : function() {
		return React.createElement(zstatic_config.html.div, {
			className : zstatic_config.css.group
		}, React.createElement(Zstatic_Form.Label, this.props), React
				.createElement(Zstatic_Form.Input, this.props));
	}
});

var Zstatic_Form_Hidden = React.createClass({
	displayName : 'Zstatic_Form_Hidden',

	render : function() {
		var sVal = zstatic_page.data_up_value(this.props.pageUnique,
				this.props.fieldData);
		return React.createElement("input", {
			'type' : 'hidden',

			'id' : this.props.fieldId,
			'name' : this.props.fieldId,

			value : sVal
		});
	}
});

var Zstatic_Form_Upload = React.createClass({
	displayName : 'Zstatic_Form_Upload',

	render : function() {
		return React.createElement(zstatic_config.html.div, {
			className : zstatic_config.css.group
		}, React.createElement(Zstatic_Form.Label, this.props), React
				.createElement(Zstatic_Form.Upload, this.props));
	}
});

var Zstatic_Form_Show = React.createClass({
	displayName : 'Zstatic_Form_Show',

	render : function() {
		var sVal = zstatic_page.data_up_value(this.props.pageUnique,
				this.props.fieldData);

		return React.createElement(zstatic_config.html.div, {
			className : zstatic_config.css.group
		}, React.createElement(Zstatic_Form.Label, this.props), React
				.createElement(zstatic_config.html.div, {
					className : zstatic_config.css.box
							+ ' zs_page_form_show_html'
				}, sVal));
	}
});

var Zstatic_Form_Textarea = React.createClass({
	displayName : 'Zstatic_Form_Textarea',

	render : function() {
		return React.createElement(zstatic_config.html.div, {
			className : zstatic_config.css.group
		}, React.createElement(Zstatic_Form.Label, this.props), React
				.createElement(Zstatic_Form.Textarea, this.props));
	}
});

var Zstatic_Form_Model = React.createClass({
	displayName : 'Zstatic_Form_Model',

	render : function() {
		return React.createElement(zstatic_config.html.div, {
			className : zstatic_config.css.group
		}, React.createElement(Zstatic_Form.Label, this.props), React
				.createElement(Zstatic_Form.Model, this.props));
	}
});

var Zstatic_Form_Ckeditor = React.createClass({
	displayName : 'Zstatic_Form_Ckeditor',

	render : function() {
		return React.createElement(zstatic_config.html.div, {
			className : zstatic_config.css.group
		}, React.createElement(Zstatic_Form.Label, this.props), React
				.createElement(Zstatic_Form.Editor, this.props));
	}
});

var Zstatic_Form_Checkbox = React.createClass({
	displayName : 'Zstatic_Form_Checkbox',
	render : function() {
		return React.createElement(zstatic_config.html.div, {
			className : zstatic_config.css.group
		}, React.createElement(Zstatic_Form.Label, this.props), React
				.createElement(Zstatic_Form.Checkbox, this.props));
	}
});

var Zstatic_Form_Date = React.createClass({
	displayName : 'Zstatic_Form_Date',
	render : function() {
		return React.createElement(zstatic_config.html.div, {
			className : zstatic_config.css.group
		}, React.createElement(Zstatic_Form.Label, this.props), React
				.createElement(Zstatic_Form.Date, this.props));
	}
});

var Zstatic_Form_Datehms = React.createClass({
	displayName : 'Zstatic_Form_Datehms',
	render : function() {
		return React.createElement(zstatic_config.html.div, {
			className : zstatic_config.css.group
		}, React.createElement(Zstatic_Form.Label, this.props), React
				.createElement(Zstatic_Form.Datehms, this.props));
	}
});

var Zstatic_Form_Select = React.createClass({
	displayName : 'Zstatic_Form_Select',
	render : function() {
		return React.createElement(zstatic_config.html.div, {
			className : zstatic_config.css.group
		}, React.createElement(Zstatic_Form.Label, this.props), React
				.createElement(Zstatic_Form.Select, this.props));
	}
});

var Zstatic_Form_Tree = React.createClass({
	displayName : 'Zstatic_Form_Tree',
	render : function() {
		return React.createElement(zstatic_config.html.div, {
			className : zstatic_config.css.group
		}, React.createElement(Zstatic_Form.Label, this.props), React
				.createElement(Zstatic_Form.Tree, this.props));
	}
});

var Zstatic_Element_Operate_Button = React.createClass({
	displayName : 'Zstatic_Element_Operate_Button',

	onClick : function onClick(e) {

		// zstatic_page.operate_submit(this.props.pageUnique);
		// var $btn = $( '#' + this.props.pageUnique + '-'
		// +this.props.operateCode).button('loading');
		if (zstatic_operate.check_time(this.props.pageUnique + '-'
				+ this.props.operateCode, 5000)) {
			eval(this.props.operateLink);

		}
		// $btn.button('reset');

	},
	render : function() {
		return React.createElement('button', {
			className : 'btn btn-raised btn-primary',
			type : 'button',
			id : this.props.pageUnique + '-' + this.props.operateCode,
			// 'data-loading-text' : zstatic_config.button.loading,
			onClick : this.onClick,
		}, this.props.operateName);

	}
});

var Zstatic_Element_Operate_Link = React.createClass({
	displayName : 'Zstatic_Element_Operate_Link',

	onClick : function onClick(e) {

		zstatic_page.page(this.props.operateLink);

	},
	render : function() {
		return React.createElement('a', {
			className : 'btn btn-primary',

			onClick : this.onClick,
		}, this.props.operateName);

	}
});

var Zstatic_Element_Operate_Js = React.createClass({
	displayName : 'Zstatic_Element_Operate_Js',

	onClick : function onClick(e) {

		eval(this.props.operateLink);

	},
	render : function() {
		return React.createElement('a', {
			className : 'btn btn-primary',

			onClick : this.onClick,
		}, this.props.operateName);

	}
});

var Zstatic_Element_Operate = React.createClass({
	displayName : 'Zstatic_Element_Operate',
	render : function() {

		var oPageModel = this.props;

		var aOperate = [];
		for ( var i in oPageModel.operates) {

			var pOperate = oPageModel.operates[i];

			pOperate = zstatic_operate.operate_format(pOperate, {

				struct : oPageModel.struct,
				operate : pOperate
			});

			aOperate.push(zstatic_operate.auto_operate(pOperate));

		}

		return React.createElement(zstatic_config.html.div, {
			className : 'col-md-10 col-md-offset-2'
		}, aOperate);
	}
});

// 标准FORM的输出
var Zstatic_Elelemt_Form = React.createClass({
	displayName : 'Zstatic_Elelemt_Form',

	getInitialState : function getInitialState() {
		return {
			data : []
		};
	},

	render : function() {

		var oPageModel = this.props;

		var aFormField = [];
		for ( var i in oPageModel.fields) {

			var pField = oPageModel.fields[i];

			var sElement = pField.fieldElement;
			if (sElement == "") {
				sElement = "Zstatic_Form_Input";
			}

			if (zstatic_config.element[sElement] != undefined) {
				sElement = zstatic_config.element[sElement];
			}

			aFormField.push(React.createElement(eval(sElement), pField));

		}

		aFormField.push(React
				.createElement(Zstatic_Element_Operate, this.props));

		var oForm = React.createElement("form", {
			className : 'form-horizontal'
		}, aFormField);

		return React.createElement(zstatic_config.html.div, null, oForm);

	}
});

// 标准FORM的输出
var Zstatic_Elelemt_Book = React.createClass({
	displayName : 'Zstatic_Elelemt_Book',

	getInitialState : function getInitialState() {
		return {
			data : []
		};
	},

	render : function() {

		var oPageModel = this.props;

		var aFormField = [];
		for ( var i in oPageModel.fields) {

			var pField = oPageModel.fields[i];

			var sElement = pField.fieldElement;
			if (sElement == "") {
				sElement = "Zstatic_Form_Show";
			}

			if (zstatic_config.element[sElement] != undefined) {
				// sElement =zstatic_config.element[sElement];
				sElement = "Zstatic_Form_Show";
			}

			if (pField.fieldElement != "hidden") {
				aFormField.push(React.createElement(eval(sElement), pField));
			}

		}

		aFormField.push(React
				.createElement(Zstatic_Element_Operate, this.props));

		var oForm = React.createElement("form", {
			className : 'form-horizontal'
		}, aFormField);

		return React.createElement(zstatic_config.html.div, null, oForm);

	}
});

// 列表展示内容
var Zstatic_Elelemt_Grid = React
		.createClass({
			displayName : 'Zstatic_Elelemt_Grid',
			componentDidMount : function() {
				// zstatic_page.page_complate();

				zstatic_page.page_material(this.props.uq_code);
			},
			render : function() {

				var oPrep = this.props;

				var oPageModel = zstatic_page.page_model(oPrep.uq_code);

				var sShowType = zstatic_page.up_model_ext(oPageModel, 'show');

				var oData = oPrep.data;

				var aThead = [];

				if (sShowType == "dialog") {
					aThead.push(React.createElement('th', null, '选择'));
				}

				for ( var i in oPageModel.fields) {

					var pField = oPageModel.fields[i];

					aThead.push(React.createElement('th', null,
							pField.fieldLabel));

				}

				if (oPageModel.operates.length > 0) {
					aThead.push(React.createElement('th', null, '操作'));
				}

				var aTr = [];
				for ( var n in oData.dataMaps) {

					var aTd = [];
					var oMap = oData.dataMaps[n];

					if (sShowType == "dialog") {

						var oSet = {
							fieldId : zstatic_page.up_model_ext(oPageModel,
									'fieldId'),
							pageUnique : zstatic_page.up_model_ext(oPageModel,
									'pageUnique'),
							fieldData : zstatic_page.up_model_ext(oPageModel,
									'fieldData'),
							clientExtend : zstatic_page.up_model_ext(
									oPageModel, 'clientExtend'),
							fieldValue : oMap[oPageModel.fields[0].fieldData],
							fieldText : oMap[oPageModel.fields[1].fieldData]
						};

						aTd.push(React.createElement('td', null, React
								.createElement(Zstatic_Form.Dialog_Checkbox,
										oSet,
										oMap[oPageModel.fields[0].fieldData])));
					}

					for ( var i in oPageModel.fields) {

						var pField = oPageModel.fields[i];

						aTd.push(React.createElement('td', null,
								oMap[pField.fieldData]));

					}

					var aOperate = [];
					for ( var i in oPageModel.operates) {

						var pOperate = oPageModel.operates[i];

						pOperate = zstatic_operate.operate_format(pOperate, {
							data : oMap,
							struct : oPageModel.struct,
							operate : pOperate
						});

						// 标记是否按钮隐藏
						var bFlagOperateShow = true;

						if (pOperate.clientJs != null) {
							var oOperateReturn = zstatic_func
									.js_exec(pOperate.clientJs);

							// 如果有脚本标记 并且返回的对象中flag_hidden标记为true 则将该按钮隐藏掉
							if (oOperateReturn
									&& oOperateReturn.flag_hidden == true) {
								bFlagOperateShow = false;
							}

							// console.log(oOperateReturn);
						}

						// console.log(sReturn);

						/*
						 * if (pOperate["operateType"] == "js") {
						 * 
						 * aOperate.push(React.createElement(
						 * Zstatic_Element_Operate_Js, pOperate)); } else {
						 * 
						 * aOperate.push(React.createElement(
						 * Zstatic_Element_Operate_Link, pOperate)); }
						 */
						if (bFlagOperateShow) {
							aOperate.push(zstatic_operate
									.auto_operate(pOperate));
						}

					}

					if (aOperate.length > 0) {
						aTd.push(React.createElement('td', null, aOperate));
					}

					aTr.push(React.createElement('tr', null, aTd));

				}

				var aTbody = [];

				var oThead = React.createElement('thead', null, React
						.createElement('tr', null, aThead));

				var oTbody = React.createElement('tbody', null, aTr);

				var oTable = React.createElement('table', {
					className : 'table table-bordered',
					'data-toggle':'table'
				}, oThead, oTbody);

				var aPagingLi = [];
				var oPagingData = oData.gridNav;
				zstatic_page.temp.gridnavcache[oPrep.uq_code] = oPagingData;
				var iMaxSize = Math.ceil(oPagingData.pageCount
						/ oPagingData.pageSize);

				var oPagingDisable = {
					className : 'disabled'
				};

				var oGridNav = {
					showtext : '',
					showtype : '',
					navindex : 0,
					currentindex : oPagingData.pageIndex,
					pageUnique : oPrep.uq_code

				};

				aPagingLi.push(React.createElement(Zstatic_Element_Grid_Nav, $
						.extend(oGridNav, {
							showtext : '<',
							showtype : 'Previous',
							navindex : 1
						})));

				var aNumber = [];

				for (var i = oPagingData.pageIndex - 2; i < oPagingData.pageIndex; i++) {

					if (i > 0) {
						aNumber.push(i);
					}
				}

				aNumber.push(oPagingData.pageIndex);

				if (oPagingData.pageIndex < iMaxSize) {

					aNumber.push(oPagingData.pageIndex + 1);

				}

				if (oPagingData.pageIndex == 1 && iMaxSize > 2) {
					aNumber.push(oPagingData.pageIndex + 2);
				}

				for ( var i in aNumber) {

					aPagingLi.push(React.createElement(
							Zstatic_Element_Grid_Nav, $.extend(oGridNav, {
								showtext : aNumber[i],
								showtype : '',
								navindex : aNumber[i]
							})));
					/*
					 * aPagingLi .push(React .createElement( 'li', { className :
					 * (aNumber[i] == oPagingData.pageIndex ? 'active' : '') },
					 * React.createElement('a', { }, aNumber[i])));
					 */
				}

				aPagingLi.push(React.createElement(Zstatic_Element_Grid_Nav, $
						.extend(oGridNav, {
							showtext : '>',
							showtype : 'Next',
							navindex : iMaxSize
						})));

				// <li class="disabled"><a href="#" aria-label="Previous"><span
				// aria-hidden="true">&laquo;</span></a></li>

				// 开始进行分页逻辑
				var oPagingUl = React.createElement('ul', {
					className : 'pagination'
				}, aPagingLi);
				var oPagingNav = React.createElement('nav', null, oPagingUl);

				return React.createElement(zstatic_config.html.div, {className:'table-responsive w_w_100'},
						oTable, oPagingNav);
			}
		});

var Zstatic_Element_Grid_Nav = React
		.createClass({
			displayName : 'Zstatic_Element_Grid_Nav',

			onClick : function onClick(e) {

				// zstatic_page.page(this.props.operateLink);

				zstatic_page.grid_nav(this.props.pageUnique,
						this.props.navindex);
			},
			render : function() {

				var nav_a = null;
				if (this.props.showtype != '') {
					nav_a = React.createElement('a', {
						'aria-label' : this.props.showtype
					}, React.createElement('span', {
						'aria-hidden' : 'true'
					}, this.props.showtext));
				} else {
					nav_a = React.createElement('a', {

					}, this.props.navindex);
				}

				return React
						.createElement(
								'li',
								{
									// className : 'btn btn-primary',
									className : ((this.props.showtype == '' && this.props.navindex == this.props.currentindex) ? "active"
											: ""),
									onClick : this.onClick
								}, nav_a);

			}
		});
