var Zstatic_Form = {

	Input: React.createClass({
		displayName: 'Zstatic_Form.Input',

		getInitialState: function() {
			return {
				value: zstatic_page.data_up_value(this.props.pageUnique,
					this.props.fieldData)
			};
		},

		onChange: function onChange(e) {
			this.setState({
				value: e.target.value
			});
			zstatic_page.data_in_value(this.props.pageUnique,
				this.props.fieldData, e.target.value);
		},

		render: function() {
			return React.createElement(zstatic_config.html.div, {
				className: zstatic_config.css.cell - bd
			}, React.createElement("input", {
				'type': 'text',
				className: zstatic_config.css.input,
				'id': this.props.fieldId,
				'name': this.props.fieldId,
				onChange: this.onChange,
				// placeholder : this.props.fieldRemark,
				value: this.state.value
			}), zstatic_page.help_text(this.props.fieldRemark));
		}
	}),
	Date: React.createClass({
		displayName: 'Zstatic_Form.Date',

		getInitialState: function() {
			return {
				value: zstatic_page.data_up_value(this.props.pageUnique,
					this.props.fieldData)
			};
		},
		onClick: function() {

			var oProps = this.props;

			WdatePicker({
				el: oProps.fieldId,
				vel: this.props.fieldId,
				dateFmt: "yyyy-MM-dd",
				onpicking: function(dp) {

					zstatic_page.data_in_value(oProps.pageUnique,
						oProps.fieldData, dp.cal.getNewDateStr());
				}
			});
		},
		onChange: function onChange(e) {
			this.setState({
				value: e.target.value
			});

			zstatic_page.data_in_value(this.props.pageUnique,
				this.props.fieldData, e.target.value);
		},
		render: function() {
			return React.createElement(zstatic_config.html.div, {
				className: zstatic_config.css.box
			}, React.createElement("input", {
				'type': 'text',
				className: zstatic_config.css.field,
				'id': this.props.fieldId,
				'name': this.props.fieldId,
				onClick: this.onClick,
				onChange: this.onChange,
				value: this.state.value
			}));
		}
	}),

	Datehms: React.createClass({
		displayName: 'Zstatic_Form.Datehms',

		getInitialState: function() {
			return {
				value: zstatic_page.data_up_value(this.props.pageUnique,
					this.props.fieldData)
			};
		},
		onClick: function() {

			var oProps = this.props;

			WdatePicker({
				el: oProps.fieldId,
				vel: this.props.fieldId,
				dateFmt: "yyyy-MM-dd HH:mm:ss",
				onpicking: function(dp) {

					zstatic_page.data_in_value(oProps.pageUnique,
						oProps.fieldData, dp.cal.getNewDateStr());
				}
			});
		},
		onChange: function onChange(e) {
			this.setState({
				value: e.target.value
			});

			zstatic_page.data_in_value(this.props.pageUnique,
				this.props.fieldData, e.target.value);
		},
		render: function() {
			return React.createElement(zstatic_config.html.div, {
				className: zstatic_config.css.box
			}, React.createElement("input", {
				'type': 'text',
				className: zstatic_config.css.field,
				'id': this.props.fieldId,
				'name': this.props.fieldId,
				onClick: this.onClick,
				onChange: this.onChange,
				value: this.state.value
			}));
		}
	}),

	Model: React.createClass({
		displayName: 'Model',
		getInitialState: function() {
			return {
				value: zstatic_page.data_up_value(this.props.pageUnique,
					this.props.fieldData)
			};
		},

		componentDidMount: function() {

			zstatic_dialog.dialog_text(this.props.pageUnique,
				this.props.fieldId, this.props.clientExtend,
				this.state.value);

		},
		render: function() {
			return React.createElement(zstatic_config.html.div, {
					className: zstatic_config.css.box
				}, React.createElement("input", {
					'type': 'hidden',
					// className : zstatic_config.field_class,
					'id': this.props.fieldId,
					'name': this.props.fieldId,
					onChange: this.onChange,
					value: this.state.value
				}), React.createElement(Zstatic_Form.ModelButton, this.props),
				React.createElement("div", {
					'id': this.props.fieldId + '_show'
				}));
		}
	}),

	ModelButton: React.createClass({
		displayName: 'UploadButton',

		componentDidMount: function() {

		},
		onClick: function() {

			var oExtMap = zstatic_func.map_from_url(this.props.clientExtend);

			zstatic_dialog.dialog_page(oExtMap["page"], this.props);

		},

		render: function() {
			return React.createElement("button", {
				'type': 'button',
				className: 'btn btn-raised btn-success',
				'id': this.props.fieldId + zstatic_config.model.button,

				onClick: this.onClick
			}, zstatic_config.model.text);

		}
	}),

	Upload: React.createClass({
		displayName: 'Zstatic_Form.Upload',

		getInitialState: function() {
			return {
				value: zstatic_page.data_up_value(this.props.pageUnique,
					this.props.fieldData)
			};
		},

		onChange: function onChange(e) {
			this.setState({
				value: e.target.value
			});
			zstatic_page.data_in_value(this.props.pageUnique,
				this.props.fieldData, e.target.value);
		},

		render: function() {
			return React.createElement(zstatic_config.html.div, {
				className: zstatic_config.css.box
			}, React.createElement("input", {
				'type': 'hidden',
				// className : zstatic_config.field_class,
				'id': this.props.fieldId,
				'name': this.props.fieldId,
				onChange: this.onChange,
				value: this.state.value
			}), React.createElement(Zstatic_Form.UploadButton, this.props));
		}
	}),

	UploadButton: React.createClass({
		displayName: 'UploadButton',

		componentDidMount: function() {

			var sId = this.props.fieldId;

			var sUq = this.props.pageUnique;
			var sFd = this.props.fieldData;

			var sClientExtend = this.props.clientExtend;
			// console.log(sClientExtend);

			zstatic_upload.init_upload(sId, sUq, sFd, sClientExtend);

		},
		render: function() {
			return React.createElement('div', null, React.createElement('div', {
				// className : 'btn btn-raised btn-primary',
				'id': this.props.fieldId + zstatic_config.upload.button

			}, zstatic_config.upload.text), React.createElement('div', {
				// className : 'btn btn-raised btn-primary',
				'id': this.props.fieldId + zstatic_config.upload.list

			}), zstatic_page.help_text(this.props.fieldRemark));

		}
	}),

	Textarea: React.createClass({
		displayName: 'Zstatic_Form.Textarea',

		getInitialState: function() {

			return {

				value: zstatic_page.data_up_value(this.props.pageUnique,
					this.props.fieldData)
			};
		},

		onChange: function onChange(e) {
			this.setState({
				value: e.target.value
			});
			zstatic_page.data_in_value(this.props.pageUnique,
				this.props.fieldData, e.target.value);
		},

		render: function() {

			return React.createElement(zstatic_config.html.div, {
				className: zstatic_config.css.box
			}, React.createElement("textarea", {

				className: zstatic_config.css.field,
				'id': this.props.fieldId,
				'name': this.props.fieldId,
				onChange: this.onChange,
				value: this.state.value

			}));
		}
	}),
	Editor: React.createClass({
		displayName: 'Zstatic_Form.Editor',

		getInitialState: function() {

			return {

				value: zstatic_page.data_up_value(this.props.pageUnique,
					this.props.fieldData)
			};
		},

		componentDidMount: function() {
			var editor = CKEDITOR.replace(this.props.fieldId, {
				filebrowserImageUploadUrl: zstatic_config.define.uploadckfile
			});

			var sUq = this.props.pageUnique;
			var sFd = this.props.fieldData;
			editor.on('change', function(event) {
				zstatic_page.data_in_value(sUq, sFd, this.getData());
			})

		},

		onChange: function onChange(e) {
			this.setState({
				value: e.target.value
			});
			zstatic_page.data_in_value(this.props.pageUnique,
				this.props.fieldData, e.target.value);
		},

		render: function() {

			return React.createElement(zstatic_config.html.div, {
				className: zstatic_config.css.box
			}, React.createElement("textarea", {

				// className : zstatic_config.field_class,
				'id': this.props.fieldId,
				'name': this.props.fieldId,
				onChange: this.onChange,
				value: this.state.value

			}));
		}
	}),

	Input_Item: React.createClass({
		displayName: 'CheckBox_Item',

		getInitialState: function() {

			var sData = zstatic_page.data_up_value(this.props.field.pageUnique,
				this.props.field.fieldData);

			var bFlagCheck = false;

			if (sData) {
				var aArray = sData.split(',');
				for (var i in aArray) {
					if (aArray[i] == this.props.value) {
						bFlagCheck = true;
					}
				}
			}

			return {

				checked: bFlagCheck
			};
		},
		onChange: function onChange(e) {
			// console.log(this.state.checked);

			var bFlagCheck = !this.state.checked;
			this.setState({
				checked: bFlagCheck
			});
			// this.refs.complete.checked

			// var bFlagCheck = this.refs.complete.checked;

			// console.log(bFlagCheck);

			var sData = zstatic_page.data_up_value(this.props.field.pageUnique,
				this.props.field.fieldData);

			var aArray = sData.split(',');
			var aValues = [];
			for (var i in aArray) {
				if (aArray[i] == this.props.value) {

					if (bFlagCheck) {
						aValues.push(aArray[i]);
						bFlagCheck = false;
					}

				} else if (aArray[i] != '') {
					aValues.push(aArray[i]);
				}
			}

			if (bFlagCheck) {

				var oExt = zstatic_func
					.map_from_url(this.props.field.clientExtend);
				var iMaxSize = 9999;
				if (oExt && oExt.max != undefined) {
					iMaxSize = parseInt(oExt.max);
				}
				if (aValues.length >= iMaxSize) {
					aValues.pop();
				}

				aValues.push(this.props.value);
			}

			var sResult = '';
			if (aValues.length > 0) {
				sResult = aValues.join(',');
			}

			// 如果是单选 直接赋值
			if (this.props.type == "radio") {

				sResult = this.props.value;
			}

			zstatic_page.data_in_value(this.props.field.pageUnique,
				this.props.field.fieldData, sResult);

			if (this.props.ext_show == "dialog") {
				// $('#' + this.props.field.fieldId +
				// '_show').html(sResult);

				zstatic_dialog.dialog_text(this.props.field.pageUnique,
					this.props.field.fieldId,
					this.props.field.clientExtend, sResult);
			}

		},
		render: function() {

			var oInput = React.createElement("input", {
				'type': this.props.type,
				'id': this.props.id,
				'name': this.props.name,
				'defaultChecked': this.state.checked,
				onChange: this.onChange,
				'value': this.props.value
			});

			var oSpan = React.createElement('span', {
				className: 'zs_page_input_item_text'
			}, this.props.ext_show == "dialog" ? '' : this.props.text);

			return React.createElement(zstatic_config.html.label, null, oInput,
				oSpan);
		}
	}),

	Checkbox: React.createClass({
		displayName: 'Checkbox',
		render: function() {

			var aCheckBox = [];

			var oMap = zstatic_func.map_from_url(this.props.fieldSource);

			for (var p in oMap) {
				var oInput = React.createElement(Zstatic_Form.Input_Item, {
					'type': 'checkbox',
					'id': this.props.fieldId,
					'name': this.props.fieldId,
					'value': p,
					'text': oMap[p],
					'field': this.props
				});

				aCheckBox.push(oInput);
			}

			var oBox = React.createElement(zstatic_config.html.div, {
				className: 'checkbox'
			}, aCheckBox);

			return React.createElement(zstatic_config.html.div, {
				className: zstatic_config.css.box
			}, oBox);
		}
	}),

	Dialog_Checkbox: React.createClass({
		displayName: 'DialogCheckbox',
		render: function() {

			var sType = 'checkbox';

			var oExt = zstatic_func.map_from_url(this.props.clientExtend);

			if (oExt && oExt.max == 1) {
				sType = 'radio';
			}

			var oInput = React.createElement(Zstatic_Form.Input_Item, {
				'type': sType,
				'id': this.props.fieldId,
				'name': this.props.fieldId,
				'value': this.props.fieldValue,
				'text': this.props.fieldText,
				'ext_show': 'dialog',
				'field': this.props
			});

			var oBox = React.createElement(zstatic_config.html.div, {
				className: sType
			}, oInput);

			return React.createElement(zstatic_config.html.div, {
				className: zstatic_config.css.box
			}, oBox);
		}
	}),

	Select: React
		.createClass({
			displayName: 'Select',
			onChange: function onChange(e) {
				// console.log(e.target.value);
				zstatic_page.data_in_value(this.props.pageUnique,
					this.props.fieldData, e.target.value);
			},
			render: function() {

				var aOption = [];

				var oMap = zstatic_func
					.map_from_url(this.props.fieldSource);

				var sData = zstatic_page.data_up_value(
					this.props.pageUnique, this.props.fieldData);

				var bSetValue = false;
				if (sData) {
					bSetValue = true;
				}

				if (this.props.pageUnique
					.indexOf(zstatic_config.select.query) > -1) {
					var oInput = React.createElement('option', {
						value: '',
						selected: (sData == '' ? 'selected' : '')
					}, zstatic_config.select.text);

					aOption.push(oInput);
					bSetValue = true;
				}

				for (var p in oMap) {
					var oInput = React.createElement('option', {
						value: p,
						selected: (sData == p ? 'selected' : '')
					}, oMap[p]);

					aOption.push(oInput);

					if (!bSetValue) {
						zstatic_page.data_in_value(this.props.pageUnique,
							this.props.fieldData, p);
						bSetValue = true;
					}
				}

				return React
					.createElement(zstatic_config.html.div, {
							className: zstatic_config.css.box + ' dropdownjs'
						}, React.createElement("select", {

							className: zstatic_config.css.field,
							'id': this.props.fieldId,
							onChange: this.onChange,
							'name': this.props.fieldId
						}, aOption), zstatic_page
						.help_text(this.props.fieldRemark));
			}
		}),
	Tree: React
		.createClass({
			displayName: 'Tree',
			componentDidMount: function() {

				var sId = this.props.fieldId;

				var sUq = this.props.pageUnique;
				var sFd = this.props.fieldData;

				var options = {
					hideSidePanel: true,
					onChange: function(oList) {

						var aVal = [];
						for (var p in oList) {
							var oItem = oList[p];
							aVal.push(oItem.value);
						}

						zstatic_page
							.data_in_value(sUq, sFd, aVal.join(','));

					}
				};
				$("select#" + sId).treeMultiselect(options);
				zstatic_page.page_material();

			},

			render: function() {

				var aOption = [];

				var oMap = zstatic_func
					.map_from_url(this.props.fieldSource);

				var sData = zstatic_page.data_up_value(
					this.props.pageUnique, this.props.fieldData);

				var aArray = sData.split(',');

				var aList = [zstatic_config.tree.text];

				var aKeys = [];
				for (var p in oMap) {
					aKeys.push(p);
				}

				for (var i = 0, j = aKeys.length; i < j; i++) {

					var sVal = aKeys[i];
					var sText = oMap[sVal];

					if (i < j - 1 && aKeys[i + 1].length > sVal.length) {

						if (i > 0 && aKeys[i - 1].length > sVal.length) {

							// 默认进行树组件的编号格式为44进制 如果有不一样的需要调整这里
							var iDeep = parseInt((aKeys[i - 1].length - sVal.length) / 4);

							aList.splice(aList.length - iDeep, iDeep);

						}

						aList.push(sText);

					} else {

						var sSelect = (',' + sData + ',').indexOf(',' + sVal + ',') > -1 ? 'selected' : '';

						var oInput = React.createElement('option', {
							value: sVal,
							'data-section': aList.join('/'),
							selected: sSelect
						}, sText);

						aOption.push(oInput);
					}

				}

				return React.createElement(zstatic_config.html.div, {
					className: zstatic_config.css.box
				}, React.createElement("select", {
					multiple: "multiple",
					className: zstatic_config.css.field,
					'id': this.props.fieldId,

					'name': this.props.fieldId
				}, aOption));
			}
		}),

	Button: React.createClass({
		displayName: 'Input',
		render: function() {
			return React.createElement(zstatic_config.html.div, {
				className: zstatic_config.css.box
			}, React.createElement("input", {
				'type': 'text',
				className: zstatic_config.css.field,
				'id': this.props.fieldId,
				'name': this.props.fieldId
			}));
		}
	})

	Label: React.createClass({
		displayName: 'Label',
		render: function() {

			return React.createElement(zstatic_config.html.div, {
				className: zstatic_config.css.cell - hd
			}, React.createElement("label", {
				'className': sClassName
			}, this.props.fieldLabel));

		}
	})

};