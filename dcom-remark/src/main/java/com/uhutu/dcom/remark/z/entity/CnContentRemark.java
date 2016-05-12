package com.uhutu.dcom.remark.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 内容评论信息
 * @author 逄小帅
 *
 */
@Entity
public class CnContentRemark extends BaseEntity {
	
	@ZooData(name="评论编号")
	private String code;
	
	@ZooData(name="内容编号")
	private String contentCode;
	
	@ZooData(name="评论内容")
	private String remark;
	
	@ZooData(name="作者编号")
	private String author;
	
	@ZooData(name="父级编号")
	private String parentCode;
	
	@ZooData(name="评论状态")
	private String status;
	
	@ZooData(name="回复引用用户名称")
	private String replyName;

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReplyName() {
		return replyName;
	}

	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}
	
	

}
