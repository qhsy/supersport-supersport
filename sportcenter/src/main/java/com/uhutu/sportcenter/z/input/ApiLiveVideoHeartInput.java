package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 创建房间
 * 
 * @author xiegj
 *
 */
@ApiModel
public class ApiLiveVideoHeartInput extends RootApiInput {

	@ApiModelProperty(value = "直播流地址")
	private String streamUrl;

	@ApiModelProperty(value = "channelId")
	private String channelId;

	@ApiModelProperty(value = "时长")
	private int length;

	@ApiModelProperty(value = "点赞数")
	private long praise;

	@ApiModelProperty(value = "观看人次")
	private long watch;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public long getPraise() {
		return praise;
	}

	public void setPraise(long praise) {
		this.praise = praise;
	}

	public long getWatch() {
		return watch;
	}

	public void setWatch(long watch) {
		this.watch = watch;
	}

	public String getStreamUrl() {
		return streamUrl;
	}

	public void setStreamUrl(String streamUrl) {
		this.streamUrl = streamUrl;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

}
