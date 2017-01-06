package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 输入参数信息
 * @author 逄小帅
 *
 */
public class ApiAttendFlagInput extends RootApiInput {
	
	@ApiModelProperty(value="被关注的用户编号")
	private String beAttend;
	
	@ApiModelProperty(value="直播房间号")
	private String roomId;
	
	@ApiModelProperty(value="操作标识")
	private String operFlag;

	public String getBeAttend() {
		return beAttend;
	}

	public void setBeAttend(String beAttend) {
		this.beAttend = beAttend;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getOperFlag() {
		return operFlag;
	}

	public void setOperFlag(String operFlag) {
		this.operFlag = operFlag;
	}

}
