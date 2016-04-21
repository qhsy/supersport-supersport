package com.uhutu.dcom.content.entity;

import java.util.Date;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 分类数据模型
 * 
 * @author xiegj
 *
 */
@Entity
public class CnContentBasicinfo extends BaseEntity {

	@ZooData(name = "内容编号")
	private String code;

	@ZooData(name = "内容封面")
	private String cover;
	
	@ZooData(name = "内容标题")
	private String title;
	
	@ZooData(name = "发布时间")
	private Date publishTime;
	
	@ZooData(name = "内容简介")
	private String aboutDesc;
	
	@ZooData(name = "内容来源")
	private String souce;
	
	@ZooData(name = "内容状态")
	private String status;
	
	@ZooData(name = "内容分类编号")
	private String categoryCode;
	
	@ZooData(name = "标签编码")
	private String tagCode;
	
	@ZooData(name = "内容作者")
	private String author;
	
	@ZooData(name = "内容分享范围")
	private String shareScope;
	
	@ZooData(name = "定位经纬度")
	private String location;
	
	@ZooData(name = "定位位置名称")
	private String localtionName;
	
	@ZooData(name = "业务类型编号：运动时刻 文章")
	private String busiType;
	
	@ZooData(name = "内容类型：感想、视频、图片")
	private String contentType;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getAboutDesc() {
		return aboutDesc;
	}

	public void setAboutDesc(String aboutDesc) {
		this.aboutDesc = aboutDesc;
	}

	public String getSouce() {
		return souce;
	}

	public void setSouce(String souce) {
		this.souce = souce;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getTagCode() {
		return tagCode;
	}

	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getShareScope() {
		return shareScope;
	}

	public void setShareScope(String shareScope) {
		this.shareScope = shareScope;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocaltionName() {
		return localtionName;
	}

	public void setLocaltionName(String localtionName) {
		this.localtionName = localtionName;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
