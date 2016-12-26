package com.uhutu.dcom.content.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 赛事报名信息
 * @author 逄小帅
 *
 */
@Entity
@Table(indexes = { @Index(columnList = "matchCode") })
public class CnMatchSign extends BaseEntity {
	
	@ZooData(name = "赛事编号")
	@Column(length=50)
	private String matchCode;
	
	@ZooData(name = "报名项目")
	@Column(length=50)
	private String signCode;
	
	@ZooData(name = "开始时间")
	@Column(length=30)
	private String startTime;
	
	@ZooData(name = "结束时间")
	@Column(length=30)
	private String endTime;
	
	@ZooData(name = "报名链接")
	private String signUrl;
	
	@ZooData(name = "位置")
	private int sort;
	
	@ZooData(name = "状态")
	@Column(length=50)
	private String status;

	public String getMatchCode() {
		return matchCode;
	}

	public void setMatchCode(String matchCode) {
		this.matchCode = matchCode;
	}

	public String getSignCode() {
		return signCode;
	}

	public void setSignCode(String signCode) {
		this.signCode = signCode;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getSignUrl() {
		return signUrl;
	}

	public void setSignUrl(String signUrl) {
		this.signUrl = signUrl;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
