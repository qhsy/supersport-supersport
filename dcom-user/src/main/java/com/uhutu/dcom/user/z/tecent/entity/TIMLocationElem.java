package com.uhutu.dcom.user.z.tecent.entity;

import com.uhutu.dcom.user.z.tecent.entity.face.MsgContentInterface;

/**
 * 地理位置消息
 * 
 * @author Administrator
 *
 */
public class TIMLocationElem implements MsgContentInterface {

	/**
	 * 地理位置描述信息
	 */
	private String Desc = "";

	/**
	 * 纬度
	 */
	private double Latitude = 0.00;

	/**
	 * 经度
	 */
	private double Longitude = 0.00;

	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}

	public double getLatitude() {
		return Latitude;
	}

	public void setLatitude(double latitude) {
		Latitude = latitude;
	}

	public double getLongitude() {
		return Longitude;
	}

	public void setLongitude(double longitude) {
		Longitude = longitude;
	}

}
