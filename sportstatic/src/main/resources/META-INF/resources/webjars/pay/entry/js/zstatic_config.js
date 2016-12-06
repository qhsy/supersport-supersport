var zstatic_config = {
	cookie : {
		login : 'zstatic_login'
	},
	css : {
		label : 'col-md-2 control-label',
		field : 'form-control',
		box : 'col-md-10',
		group : 'form-group',
		help : 'zs_page_help',
		require : 'zs_page_require'
	},

	define : {

		// 上传文件路径
		uploadurl : '/webupload/zooupload',
		uploadckfile : '/webckfile/zoockfile'

	},
	html : {
		div : 'div',
		label : 'label',
		form : 'form'
	},
	id : {
		main : 'zoo_content',
		header : 'zoo_header',
		dialog : 'zoo_dialog'
	},
	// 快捷对应行
	element : {
		'input' : 'Zstatic_Form_Input',
		'checkbox' : 'Zstatic_Form_Checkbox',
		'date' : 'Zstatic_Form_Date',
		'show' : 'Zstatic_Form_Show',
		'datehms' : 'Zstatic_Form_Datehms',
		'textarea' : 'Zstatic_Form_Textarea',
		'editor' : 'Zstatic_Form_Ckeditor',
		'upload' : 'Zstatic_Form_Upload',
		'select' : 'Zstatic_Form_Select',
		'hidden' : 'Zstatic_Form_Hidden',
		'tree' : 'Zstatic_Form_Tree',
		'model' : 'Zstatic_Form_Model'

	},
	// 扩展相关定义
	ext : {
		// 客户端扩展对象
		client : 'client_ext'
	},

	button : {
		loading : '正在处理……',
		timequick : '操作太过频繁，请放慢脚步，享受生活。'
	},

	model : {
		button : '_dialog',
		text : '选择',
		box : '_box',
		body : '_body'
	},

	select : {
		query : 'pq-',
		text : '请选择'
	},
	tree : {
		text : '全部'
	},
	upload : {
		button : '_upload',
		list : '_list',
		text : '选择'
	}

};