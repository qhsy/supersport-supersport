package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 图集信息
 * @author pang_jhui
 *
 */
@Entity
public class CnContentPhotos extends BaseEntity {
	
	@ZooData(name = "内容编号")
	private String contentCode;
	
	@ZooData(name = "图片路径",element = "upload" ,sort={"pq=0"})
	private String picture;
	
	@ZooData(name = "内容信息",element = "textarea",sort={"pq=0"})
	private String content;

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
