package com.uhutu.dcom.user.z.tecent.entity;

import com.uhutu.dcom.user.z.tecent.entity.face.MsgContentInterface;

/**
 * 表情信息
 * 
 * @author Administrator
 *
 */
public class TIMFaceElem implements MsgContentInterface {
	/**
	 * 表情索引，用户自定义
	 */
	private long Index = 0;

	/**
	 * 额外数据
	 */
	private String Data = "";

	public long getIndex() {
		return Index;
	}

	public void setIndex(long index) {
		Index = index;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

}
