package com.uhutu.dcom.user.z.tecent.entity;

import com.uhutu.dcom.user.z.tecent.entity.face.TecnetBaseEntityInterface;

/***
 * 
 * 腾讯云账户导入实体
 * 
 * @author xiegj
 *
 */
public class AccountImport implements TecnetBaseEntityInterface {
	/**
	 * 本系统账户唯一标识
	 */
	private String Identifier = "";

	/**
	 * 本系统内昵称
	 */
	private String Nick = "";

	/**
	 * 头像链接
	 */
	private String FaceUrl = "";

	public String getIdentifier() {
		return Identifier;
	}

	public void setIdentifier(String identifier) {
		Identifier = identifier;
	}

	public String getNick() {
		return Nick;
	}

	public void setNick(String nick) {
		Nick = nick;
	}

	public String getFaceUrl() {
		return FaceUrl;
	}

	public void setFaceUrl(String faceUrl) {
		FaceUrl = faceUrl;
	}

}
