package com.uhutu.dcom.user.z.tecent.entity;

import com.uhutu.dcom.user.z.tecent.entity.face.MsgContentInterface;

/***
 * 文本消息
 * 
 * @author Administrator
 *
 */
public class TIMTextElem implements MsgContentInterface {
	private String Text = "";

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

}
