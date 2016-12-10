/*
 * 
 * form中的input
 */
var entry_Form_Input = React.createClass({
	displayName : 'entry_Form_Input',

	render : function() {
		
		return React.createElement(entry_config.html.div, {
			className : entry_config.css.cell
		}, React.createElement(entry_Form.Label, this.props), React
				.createElement(entry_Form.Input, this.props));
	}
});

var entry_Form_Select = React.createClass({
	displayName : 'entry_Form_Select',

	render : function() {
		
		return React.createElement(entry_config.html.div, {
			className : entry_config.css.cell_select
		}, React.createElement(entry_Form.Label, this.props), React
				.createElement(entry_Form.Select, this.props));
	}
});

var entry_Element_Operate_Button = React.createClass({

	displayName : 'entry_Element_Operate_Button',

	onClick : function onClick(e) {

		if (entry_operate.check_time(this.props.fs.code, 5000)) {

			$("#loadingToast").css('display','block');
			
			entry_operate.operate_submit(this.props.fs.code)

		}
		

	},
	render : function() {
		return React.createElement('button', {
			className : entry_config.css.btn_primary,
			type : 'button',
			id : this.props.fs.code,
			onClick : this.onClick,
		}, "提交");

	}
});

// 标准FORM的输出
var entry_Elelemt_Form = React.createClass({
	displayName : 'entry_Elelemt_Form',

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
				sElement = "entry_Form_Input";
			}

			if (entry_config.element[sElement] != undefined) {
				sElement = entry_config.element[sElement];
			}

			aFormField.push(React.createElement(eval(sElement), pField));

		}

		return React.createElement(entry_config.html.div, {
			className : entry_config.css.cell_form
		}, aFormField);

	}
});