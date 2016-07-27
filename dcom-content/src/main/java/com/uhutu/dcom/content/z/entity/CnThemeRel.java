package com.uhutu.dcom.content.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 专题内容关联信息
 * 
 * @author xiegj
 *
 */
@Entity
public class CnThemeRel extends BaseEntity {

	@ZooData(name = "专题栏目", require = "1")
	@Column(length = 50)
	private String code;

	@ZooData(name = "文章信息", require = "1")
	@Column(length = 50)
	private String contentCode;

	@ZooData(name = "排序", require = "1")
	private int sort;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
