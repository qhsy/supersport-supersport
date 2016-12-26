package com.uhutu.dcom.content.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 赛事直播信息
 * @author 逄小帅
 *
 */
@Entity
@Table(indexes = { @Index(columnList = "matchCode") })
public class CnMatchLive extends BaseEntity {
	
	@ZooData(name = "赛事编号")
	@Column(length=50)
	private String matchCode;
	
	@ZooData(name = "直播时间")
	@Column(length=30)
	private String startTime;
	
	@ZooData(name = "直播内容")
	private String content;
	
	@ZooData(name = "直播状态")
	@Column(length=50)
	private String status;
	
	@ZooData(name = "关联直播")
	@Column(length=50)
	private String liveCode;

	public String getMatchCode() {
		return matchCode;
	}

	public void setMatchCode(String matchCode) {
		this.matchCode = matchCode;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLiveCode() {
		return liveCode;
	}

	public void setLiveCode(String liveCode) {
		this.liveCode = liveCode;
	}
	

}
