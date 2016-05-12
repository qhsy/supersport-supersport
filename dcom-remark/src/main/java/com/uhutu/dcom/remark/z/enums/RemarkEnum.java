package com.uhutu.dcom.remark.z.enums;

/**
 * 评论枚举类型
 * @author 逄小帅
 *
 */
public enum RemarkEnum {
	
	/**评论状态：有效*/
	FLAG_ENABLE("评论有效","01"),
	
	/**评论状态：无效*/
	FLAG_DISENABLE("评论无效","02");
	
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
