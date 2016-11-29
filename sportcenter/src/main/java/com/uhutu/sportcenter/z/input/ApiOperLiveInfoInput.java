package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 操作直播信息输入
 * @author 逄小帅
 *
 */
public class ApiOperLiveInfoInput extends RootApiInput {
	
	@ApiModelProperty(value="房间号")
	private String roomId;
	
	@ApiModelProperty(value="直播标识")
	private String streamId;

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getStreamId() {
		return streamId;
	}

	public void setStreamId(String streamId) {
		this.streamId = streamId;
	}

}
