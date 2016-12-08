var Zstatic_Form = {

	Input: React.createClass({
		displayName: 'Zstatic_Form.Input',

		getInitialState: function() {
			return {
				value: zstatic_page.data_up_value(this.props.code, this.props.fieldId)
			};
		},

		onChange: function onChange(e) {
			this.setState({
				value: e.target.value
			});
			zstatic_page.data_in_value(this.props.code,
				this.props.fieldId, e.target.value);
		},

		render: function() {
			return React.createElement(zstatic_config.html.div, {
				className: zstatic_config.css.cell_bd
			}, React.createElement("input", {
				'type': 'text',
				className: zstatic_config.css.input,
				'id': this.props.fieldId,
				'placeholder': '请输入' + this.props.fieldLabel,
				'name': this.props.fieldId,
				onChange: this.onChange,
				value: this.state.value
			}));
		}
	}),

	Label: React.createClass({
		displayName: 'Label',
		render: function() {

			return React.createElement(zstatic_config.html.div, {
				className: zstatic_config.css.cell_hd
			}, React.createElement("label", {
				'className': zstatic_config.css.label
			}, this.props.fieldLabel));

		}
	}),

	Select: React
		.createClass({
			displayName: 'Select',
			onChange: function onChange(e) {
				// console.log(e.target.value);
				zstatic_page.data_in_value(this.props.code,
					this.props.fieldId, e.target.value);
			},
			render: function() {

				var codes = zstatic_func.string_split(this.props.scope, ',');

				var aOption = [];

				var dOption = React.createElement('option', {

					value: '',

					selected: 'selected'

				}, zstatic_config.select.text);

				aOption.push(dOption);

				for (var i in codes) {

					var values = zstatic_func.string_split(codes[i], '&');

					var oInput = React.createElement('option', {

						value: values[0]

					}, values[1]);

					aOption.push(oInput);

				}

				return React.createElement(zstatic_config.html.div, {
					className: zstatic_config.css.cell_bd
				}, React.createElement("select", {
					className: zstatic_config.css.select,
					'id': this.props.fieldId,
					'name': this.props.fieldId,
					onChange: this.onChange,
				},aOption));
			}
		}),

};