package com.uhutu.dcom.content.z.page.vo;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 内容基本信息数据模型
 * 
 * @author xiegj
 *
 */
public class CnContentBasicinfoForAdd extends BaseEntity {

	@ZooData(name = "内容编号", inc = "insert_code=CNB", sort = { "pa=0", "pe=0" })
	private String code;

	@ZooData(name = "内容标题",require = "1", sort = { "pq=0" })
	private String title;

	@ZooData(name = "内容封面", element = "upload", require = "1", sort = { "pq=0", "pg=0" })
	private String cover;

	// @ZooData(name = "发布时间")
	// private Date publishTime;

	@ZooData(name = "内容简介", element = "textarea",require = "1", sort = { "pq=0", "pg=0" })
	private String aboutDesc;

	@ZooData(name = "内容详情", element = "editor",require = "1", sort = { "pq=0", "pg=0" })
	private String contentDetail;

	@ZooData(name = "内容来源",require = "1", sort = { "pq=0", "pg=0" })
	private String souce;

	@ZooData(name = "发布状态", element = "select", inc = { "system_define=dzsd469910011001" })
	private String status;

	@ZooData(name = "大分类", element = "select", inc = { "source_code=dzsi41071005", "source_value='222222'" }, sort = {
			"pq=0" })
	private String categoryCode;

	@ZooData(name = "标签", element = "select", inc = { "source_code=dzsi41071004", "source_value='222222'" }, sort = {
			"pq=0", "pg=0" })
	private String tagCode;

	@ZooData(name = "内容作者",require = "1", sort = { "pq=0" })
	private String author;

	@ZooData(name = "内容是否公开", element = "select", inc = { "system_define=dzsd469910011001" })
	private String shareScope;

	@ZooData(name = "定位经纬度", sort = { "pq=0", "pg=0" })
	private String location;

	@ZooData(name = "定位位置名称",require = "1", sort = { "pq=0", "pg=0" })
	private String localtionName;

	@ZooData(name = "业务类型", element = "select", inc = { "system_define=dzsd469910011002" })
	private String busiType;

	@ZooData(name = "内容类型", element = "select", inc = { "system_define=dzsd469910011003" })
	private String contentType;

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

	public String getContentDetail() {
		return contentDetail;
	}

	public void setContentDetail(String contentDetail) {
		this.contentDetail = contentDetail;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
