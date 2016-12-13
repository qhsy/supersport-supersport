package com.uhutu.dcom.content.z.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 打赏人员列表
 * @author 逄小帅
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "userCode","busiCode" }))
public class CnRedPackOption extends BaseEntity {
	
	@ZooData(value = "用户编号")
	private String userCode;
	
	@ZooData(value = "业务编号")
	private String busiCode;
	
	@ZooData(value = "分成比例")
	private BigDecimal scale;
	
	@ZooData(value = "排序")
	private int sort;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public BigDecimal getScale() {
		return scale;
	}

	public void setScale(BigDecimal scale) {
		this.scale = scale;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getBusiCode() {
		return busiCode;
	}

	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}
	

}
