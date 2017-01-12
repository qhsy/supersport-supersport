package com.uhutu.dcom.search.z.entity;

/**
 * 响应错误信息
 * @author 逄小帅
 *
 */
public class ResponseError {
	
	private String code;
	
	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
