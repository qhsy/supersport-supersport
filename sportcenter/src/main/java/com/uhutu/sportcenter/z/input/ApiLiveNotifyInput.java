package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 直播消息通知参数
 * @author 逄小帅
 *
 */
public class ApiLiveNotifyInput extends RootApiInput {
	
	@ApiModelProperty(value="有效时间")
	private String t;
	
	@ApiModelProperty(value="安全签名")
	private String sign;
	
	@ApiModelProperty(value="时间类型",notes="目前可能值为： 0 断流、1推流、100 新录制文件、200 新截图文件")
	private int event_type;
	
	@ApiModelProperty(value="直播码",notes="标示事件源于哪一条直播流")
	private int stream_id;
	
	@ApiModelProperty(value="同stream_id")
	private int channel_id;

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public int getEvent_type() {
		return event_type;
	}

	public void setEvent_type(int event_type) {
		this.event_type = event_type;
	}

	public int getStream_id() {
		return stream_id;
	}

	public void setStream_id(int stream_id) {
		this.stream_id = stream_id;
	}

	public int getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(int channel_id) {
		this.channel_id = channel_id;
	}

}