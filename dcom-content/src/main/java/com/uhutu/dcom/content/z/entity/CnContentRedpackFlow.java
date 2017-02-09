package com.uhutu.dcom.content.z.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 内容打赏流水
 * @author 逄小帅
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "code"}))
public class CnContentRedpackFlow extends BaseEntity {
	
	@ZooData(value = "打赏流水号")
	@Column(length = 50)
	private String code;

	@ZooData(value = "接受打赏者")
	@Column(length = 50)
	private String reciveUserCode;

	@ZooData(value = "内容编号")
	@Column(length = 50)
	private String contentCode;

	@ZooData(value = "打赏金额")
	private BigDecimal money;

	@ZooData(value = "打赏者")
	@Column(length = 50)
	private String sendUserCode;
	
	@ZooData(value = "交易状态")
	@Column(length = 50)
	private String status;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getReciveUserCode() {
		return reciveUserCode;
	}

	public void setReciveUserCode(String reciveUserCode) {
		this.reciveUserCode = reciveUserCode;
	}

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getSendUserCode() {
		return sendUserCode;
	}

	public void setSendUserCode(String sendUserCode) {
		this.sendUserCode = sendUserCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
