package com.uhutu.sportcenter.z.entity;

/**
 * 腾讯云导入用户信息
 * @author 逄小帅
 *
 */
public class TecentUserInfo {
	
	private String Identifier;
	
	private String Nick;
	
	private String FaceUrl;

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
