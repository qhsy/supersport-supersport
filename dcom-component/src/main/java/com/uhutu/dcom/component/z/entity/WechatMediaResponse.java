package com.uhutu.dcom.component.z.entity;

/**
 * 微信多媒体响应信息
 * @author 逄小帅
 *
 */
public class WechatMediaResponse {
	
	/*错误代码*/
	private String errcode = "";
	
	/*错误信息*/
	private String errmsg = "";
	
	/*媒体文件类型*/
	private String type = "";
	
	/*媒体文件唯一标识*/
	private String media_id = "";
	
	/*上传时间戳*/
	private String created_at = "";

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

}
