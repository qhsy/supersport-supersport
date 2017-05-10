package com.uhutu.dcom.content.z.page.vo;

import java.util.Date;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 内容基本信息数据模型
 * 
 * @author xiegj
 *
 */
public class CnContentBasicinfo extends BaseEntity {

	@ZooData(name = "编号", inc = DefineWebInc.Insert_Code + "=CNBH", sort = { DefineWebPage.Page_Add + "=1",
			DefineWebPage.Page_Edit + "=0" })
	private String code;

	@ZooData(name = "标题", require = "1", verify = { DefineWebVerify.Max_Length + "=60" })
	private String title;

	@ZooData(name = "副标题", require = "1", verify = { DefineWebVerify.Max_Length + "=255" })
	private String ptitle;

	@ZooData(name = "封面", element = DefineWebElement.Upload, sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" })
	private String cover;

	@ZooData(name = "发布状态", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd469910011001" })
	private String status;

	@ZooData(name = "发布时间", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Edit + "=0",
			DefineWebPage.Page_Add + "=0" })
	private Date publishTime;

	@ZooData(name = "内容类型", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd410710011003" })
	private String contentType;

	@ZooData(name = "视频地址", require = "1", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	private String videoUrl;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

}
