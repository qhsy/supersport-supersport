package com.uhutu.dcom.pay.z.response;

import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.zoocom.model.MResult;

/**
 * 微信用户信息响应
 * @author 逄小帅
 *
 */
public class WechatUserInfoResponse extends MResult implements IPayResponse {
	
	/*用户唯一标识*/
	private String openid;
	
	/*用户昵称*/
	private String nickname;
	
	/*用户头像*/
	private String headimgurl;
	
	/*用户的性别*/
	private String sex;
	
	/*用户个人资料填写的省份*/
	private String province;
	
	/*普通用户个人资料填写的城市*/
	private String city;
	
	/*个人用户信息标识*/
	private String unionid;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

}
