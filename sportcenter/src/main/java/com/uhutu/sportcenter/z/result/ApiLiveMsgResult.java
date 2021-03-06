package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiLiveMsgResult extends RootApiResult {
	@ApiModelProperty(value = "直播时间差", notes = "直播时间差")
	private long seconds;

	@ApiModelProperty(value = "最大人数", notes = "最大人数")
	private long watch;

	@ApiModelProperty(value = "点赞数", notes = "点赞数")
	private long praise;

	@ApiModelProperty(name = "观看数参数")
	private long watchConstant;

	@ApiModelProperty(name = "点赞数参数")
	private long praiseConstant;

	@ApiModelProperty(name = "每次直播的唯一业务编号")
	private String busiCode;

	public String getBusiCode() {
		return busiCode;
	}

	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}

	public long getWatchConstant() {
		return watchConstant;
	}

	public void setWatchConstant(long watchConstant) {
		this.watchConstant = watchConstant;
	}

	public long getPraiseConstant() {
		return praiseConstant;
	}

	public void setPraiseConstant(long praiseConstant) {
		this.praiseConstant = praiseConstant;
	}

	public long getPraise() {
		return praise;
	}

	public void setPraise(long praise) {
		this.praise = praise;
	}

	public long getSeconds() {
		return seconds;
	}

	public void setSeconds(long seconds) {
		this.seconds = seconds;
	}

	public long getWatch() {
		return watch;
	}

	public void setWatch(long watch) {
		this.watch = watch;
	}

}
