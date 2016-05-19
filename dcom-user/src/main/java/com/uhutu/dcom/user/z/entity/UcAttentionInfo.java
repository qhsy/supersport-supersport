package com.uhutu.dcom.user.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 用户关注信息
 * 
 * @author xiegj
 *
 */
@Entity
public class UcAttentionInfo extends BaseEntity {

	@ZooData(value = "关注者")
	private String attention;

	@ZooData(value = "被关注者")
	private String beAttention;

	@ZooData(value = "关注状态",comment="0:未关注 1:已关注")
	private String status;

	public String getAttention() {
		return attention;
	}

	public void setAttention(String attention) {
		this.attention = attention;
	}

	public String getBeAttention() {
		return beAttention;
	}

	public void setBeAttention(String beAttention) {
		this.beAttention = beAttention;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
