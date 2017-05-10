package com.uhutu.dcom.answer.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 问答信息分类
 * @author 逄小帅
 *
 */
//@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "code" }))
public class AwAnswerType extends BaseEntity {
	
	@ZooData(name="分类编号")
	@Column(length=50)
	private String code;
	
	@ZooData(name="分类图标url")
	@Column(length=255)
	private String iconUrl;
	
	@ZooData(name="分类名称")
	@Column(length=100)
	private String name;
	
	@ZooData(name="分类描述")
	@Column(length=255)
	private String desc;
	
	@ZooData(name="广告语")
	@Column(length=255)
	private String advPhrase;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAdvPhrase() {
		return advPhrase;
	}

	public void setAdvPhrase(String advPhrase) {
		this.advPhrase = advPhrase;
	}

}
