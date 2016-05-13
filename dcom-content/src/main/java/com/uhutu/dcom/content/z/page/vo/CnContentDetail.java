package com.uhutu.dcom.content.z.page.vo;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 内容信息数据模型
 * 
 * @author xiegj
 *
 */
public class CnContentDetail extends BaseEntity {

	@ZooData(name = "内容编号", sort = { "pa=0", "pe=0" })
	private String code;

	@ZooData(name = "内容信息json串", element = "editor", sort = { "pq=0", "pg=0" })
	private String content;

	@ZooData(name = "内容简述", element = "textarea")
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
