/*
 * 
 * form中的input
 */
var Zstatic_Form_Input = React.createClass({
	displayName : 'Zstatic_Form_Input',

	render : function() {
		
		return React.createElement(zstatic_config.html.div, {
			className : zstatic_config.css.cell
		}, React.createElement(Zstatic_Form.Label, this.props), React
				.createElement(Zstatic_Form.Input, this.props));
	}
});

var Zstatic_Form_Select = React.createClass({
	displayName : 'Zstatic_Form_Select',

	render : function() {
		
		return React.createElement(zstatic_config.html.div, {
			className : zstatic_config.css.cell_select
		}, React.createElement(Zstatic_Form.Label, this.props), React
				.createElement(Zstatic_Form.Select, this.props));
	}
});

var Zstatic_Element_Operate_Button = React.createClass({

	displayName : 'Zstatic_Element_Operate_Button',

	onClick : function onClick(e) {

		if (zstatic_operate.check_time(this.props.fs.code, 5000)) {

			$("#loadingToast").css('display','block');
			
			zstatic_operate.operate_submit(this.props.fs.code)

		}
		

	},
	render : function() {
		return React.createElement('button', {
			className : zstatic_config.css.btn_primary,
			type : 'button',
			id : this.props.fs.code,
			onClick : this.onClick,
		}, "确认报名");

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
		for ( var i in oPageModel) {

			var pField = oPageModel[i];

			var sElement = pField.fieldType;
			if (sElement == "") {
				sElement = "Zstatic_Form_Input";
			}

			if (zstatic_config.element[sElement] != undefined) {
				sElement = zstatic_config.element[sElement];
			}

			aFormField.push(React.createElement(eval(sElement), pField));

		}

		return React.createElement(zstatic_config.html.div, {
			className : zstatic_config.css.cell_form
		}, aFormField);

	}
});