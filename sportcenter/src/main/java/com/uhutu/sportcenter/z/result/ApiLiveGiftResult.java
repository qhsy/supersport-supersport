package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiLiveGiftResult extends RootApiResult {
	@ApiModelProperty(value = "直播时间差", notes = "直播时间差")
	private long seconds;

	@ApiModelProperty(value = "最大人数", notes = "最大人数")
	private long watch;

	@ApiModelProperty(value = "点赞数", notes = "点赞数")
	private long praise;

	@ZooData(name = "观看数参数")
	private long watchConstant;

	@ZooData(name = "点赞数参数")
	private long praiseConstant;

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
