package com.uhutu.sportcenter.z.api.buttock;

/**
 * 翘丽圈类型
 * @author 逄小帅
 *
 */
public enum ButtockType {
	
	power("实力派"),
	
	lap("翘丽圈");
	
	private String text;
	
	private ButtockType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

}
