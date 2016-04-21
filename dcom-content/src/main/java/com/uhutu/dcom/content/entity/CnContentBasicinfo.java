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
	private Date publish_time;
	
	@ZooData(name = "内容简介")
	private String about_desc;
	
	@ZooData(name = "内容来源")
	private String souce;
	
	@ZooData(name = "内容状态")
	private String status;
	
	@ZooData(name = "内容分类编号")
	private String category_code;
	
	@ZooData(name = "标签编码")
	private String tag_code;
	
	@ZooData(name = "内容作者")
	private String author;
	
	@ZooData(name = "内容分享范围")
	private String share_scope;
	
	@ZooData(name = "定位经纬度")
	private String location;
	
	@ZooData(name = "定位位置名称")
	private String localtion_name;
	
	@ZooData(name = "业务类型编号：运动时刻 文章")
	private String busi_type;
	
	@ZooData(name = "内容类型：感想、视频、图片")
	private String content_type;

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

	public Date getPublish_time() {
		return publish_time;
	}

	public void setPublish_time(Date publish_time) {
		this.publish_time = publish_time;
	}

	public String getAbout_desc() {
		return about_desc;
	}

	public void setAbout_desc(String about_desc) {
		this.about_desc = about_desc;
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

	public String getCategory_code() {
		return category_code;
	}

	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}

	public String getTag_code() {
		return tag_code;
	}

	public void setTag_code(String tag_code) {
		this.tag_code = tag_code;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getShare_scope() {
		return share_scope;
	}

	public void setShare_scope(String share_scope) {
		this.share_scope = share_scope;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocaltion_name() {
		return localtion_name;
	}

	public void setLocaltion_name(String localtion_name) {
		this.localtion_name = localtion_name;
	}

	public String getBusi_type() {
		return busi_type;
	}

	public void setBusi_type(String busi_type) {
		this.busi_type = busi_type;
	}

	public String getContent_type() {
		return content_type;
	}

	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}

}
