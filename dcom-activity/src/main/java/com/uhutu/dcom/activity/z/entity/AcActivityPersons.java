package com.uhutu.dcom.activity.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 活动参与人信息
 * 
 * @author xiegj
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "activityCode", "playerMobile" }), indexes = {
		@Index(columnList = "activityCode") })
public class AcActivityPersons extends BaseEntity {

	@ZooData(name = "订单编号")
	@Column(length = 50)
	private String orderCode;

	@ZooData(name = "活动编号")
	@Column(length = 50)
	private String activityCode;

	@ZooData(name = "活动参与人")
	@Column(length = 30)
	private String player;

	@ZooData(name = "参与人手机号")
	@Column(length = 255)
	private String playerMobile;

	@ZooData(name = "参与人头像")
	@Column(length = 300)
	private String headUrl;

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getPlayerMobile() {
		return playerMobile;
	}

	public void setPlayerMobile(String playerMobile) {
		this.playerMobile = playerMobile;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

}
