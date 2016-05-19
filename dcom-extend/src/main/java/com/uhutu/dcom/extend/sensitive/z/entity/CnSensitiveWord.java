package com.uhutu.dcom.extend.sensitive.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 关键字校验
 * 
 * @author xiegj
 *
 */
@Entity
public class CnSensitiveWord extends BaseEntity {

	@ZooData(name = "关键字")
	private String sensitiveWord;

	public String getSensitiveWord() {
		return sensitiveWord;
	}

	public void setSensitiveWord(String sensitiveWord) {
		this.sensitiveWord = sensitiveWord;
	}
}
