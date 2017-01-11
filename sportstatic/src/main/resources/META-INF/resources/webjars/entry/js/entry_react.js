var entry_Form = {

	Input: React.createClass({
		displayName: 'entry_Form.Input',

		getInitialState: function() {
			return {
				value: entry_page.data_up_value(this.props.code, this.props.fieldId)
			};
		},

		onChange: function onChange(e) {
			this.setState({
				value: e.target.value
			});
			entry_page.data_in_value(this.props.code,
				this.props.fieldId, e.target.value);
		},

		render: function() {
			return React.createElement(entry_config.html.div, {
				className: entry_config.css.cell_bd
			}, React.createElement("input", {
				'type': 'text',
				className: entry_config.css.input,
				'id': this.props.fieldId,
				'placeholder': '请输入' + this.props.fieldLabel,
				'name': this.props.fieldId,
				onChange: this.onChange,
				value: this.state.value
			}));
		}
	}),
	
	Number: React.createClass({
		displayName: 'entry_Form.Number',

		getInitialState: function() {
			return {
				value: entry_page.data_up_value(this.props.code, this.props.fieldId)
			};
		},

		onChange: function onChange(e) {
			this.setState({
				value: e.target.value
			});
			entry_page.data_in_value(this.props.code,
				this.props.fieldId, e.target.value);
		},

		render: function() {
			return React.createElement(entry_config.html.div, {
				className: entry_config.css.cell_bd
			}, React.createElement("input", {
				'type': 'number',
				className: entry_config.css.input,
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

			return React.createElement(entry_config.html.div, {
				className: entry_config.css.cell_hd
			}, React.createElement("label", {
				'className': entry_config.css.label
			}, this.props.fieldLabel));

		}
	}),

	Select: React
		.createClass({
			displayName: 'Select',
			onChange: function onChange(e) {
				// console.log(e.target.value);
				entry_page.data_in_value(this.props.code,
					this.props.fieldId, e.target.value);
			},
			render: function() {

				var codes = entry_func.string_split(this.props.scope, ',');

				var aOption = [];

				var dOption = React.createElement('option', {

					value: '',

					selected: 'selected'

				}, entry_config.select.text);

				aOption.push(dOption);

				for (var i in codes) {

					var values = entry_func.string_split(codes[i], '&');

					var oInput = React.createElement('option', {

						value: values[0]

					}, values[1]);

					aOption.push(oInput);

				}

				return React.createElement(entry_config.html.div, {
					className: entry_config.css.cell_bd
				}, React.createElement("select", {
					className: entry_config.css.select,
					'id': this.props.fieldId,
					'name': this.props.fieldId,
					onChange: this.onChange,
				}, aOption));
			}
		}),

	Textarea: React.createClass({
		displayName: 'entry_Form.Textarea',

		getInitialState: function() {

			return {

				value: entry_page.data_up_value(this.props.code,
					this.props.fieldId)
			};
		},

		onChange: function onChange(e) {
			this.setState({
				value: e.target.value
			});
			entry_page.data_in_value(this.props.code,
				this.props.fieldId, e.target.value);
		},

		render: function() {

			return React.createElement(entry_config.html.div, {
				className: entry_config.css.cell_bd
			}, React.createElement("textarea", {

				className: entry_config.css.textarea,
				'id': this.props.fieldId,
				'name': this.props.fieldId,
				'rows': '3',
				'placeholder' : '请输入' + this.props.fieldLabel,
				onChange: this.onChange,
				value: this.state.value

			}));
		}
	}),

};