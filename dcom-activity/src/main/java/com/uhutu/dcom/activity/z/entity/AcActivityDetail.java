package com.uhutu.dcom.activity.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 活动详细信息数据模型
 * 
 * @author xiegj
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "code" }), indexes = { @Index(columnList = "code") })
public class AcActivityDetail extends BaseEntity {

	@ZooData(name = "活动编号")
	@Column(length = 50)
	private String code;

	@ZooData(name = "活动封面", element = DefineWebElement.Upload, require = "1", sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" })
	private String cover;

	@ZooData(name = "活动名称")
	@Column(length = 100)
	private String name;

	@ZooData(name = "活动发起人")
	@Column(length = 50)
	private String author;

	@ZooData(name = "活动详情")
	@Column(columnDefinition = "longtext")
	private String content;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
