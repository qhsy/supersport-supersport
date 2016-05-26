package com.uhutu.dcom.remark.z.enums;

/**
 * 评论枚举类型
 * @author 逄小帅
 *
 */
public enum RemarkEnum {
	
	/**评论状态：有效*/
	FLAG_ENABLE("评论有效","dzsd4699100110010001"),
	
	/**评论状态：无效*/
	FLAG_DISENABLE("评论无效","dzsd4699100110010002"),
	
	/**喜欢类型：么么哒*/
	PRAISE_FAVOR("么么哒","01"),
	
	/**喜欢类型：嘘嘘*/
	PRAISE_BOO("嘘嘘","02"),
	
	/**图片类型：点亮*/
	ICON_LIGHT("点亮","1"),
	
	/**图片类型：点暗*/
	ICON_DARK("点暗","0");
	
	private String code = "";
	
	private String name = "";
	
	private RemarkEnum(String name, String code){
		
		setCode(code);
		
		setName(name);
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
