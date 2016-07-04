package com.uhutu.dcom.pay.z.request;

/**
 * 微信消息内容基类
 * @author 逄小帅
 *
 */
public class WechatMsgContent {
	
	/*内容值*/
	private String value;
	
	/*内容颜色*/
	private String color = "#173177";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	

}
