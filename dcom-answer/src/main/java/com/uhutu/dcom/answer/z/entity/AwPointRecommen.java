package com.uhutu.dcom.answer.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 问达推荐信息
 * 
 * @author xiegj
 *
 */
@Entity
public class AwPointRecommen extends BaseEntity {

	@ZooData(name = "类型", element = DefineWebElement.Select, inc = { DefineWebInc.System_Define + "=dzsd488810011003" })
	@Column(length = 50)
	private String type;

	@ZooData(name = "问达", require = "1", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw488810010001" })
	@Column(length = 50)
	private String answerCode;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAnswerCode() {
		return answerCode;
	}

	public void setAnswerCode(String answerCode) {
		this.answerCode = answerCode;
	}

}
