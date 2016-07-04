package com.uhutu.dcom.pay.z.request;

import com.uhutu.dcom.pay.z.face.IPayRequest;

/**
 * 微信消息请求
 * @author 逄小帅
 *
 */
public class WechatMsgRequest implements IPayRequest {
	
	/*目标用户openid*/
	private String touser;
	
	/*消息模版id*/
	private String template_id;
	
	/*顶层颜色*/
	private String topcolor = "#FF0000";
	
	/*请求的数据*/
	private String data;

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getTopcolor() {
		return topcolor;
	}

	public void setTopcolor(String topcolor) {
		this.topcolor = topcolor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
