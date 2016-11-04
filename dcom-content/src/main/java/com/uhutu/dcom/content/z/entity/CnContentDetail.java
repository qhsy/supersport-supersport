package com.uhutu.dcom.content.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 内容信息数据模型
 * 
 * @author xiegj
 *
 */
@Entity
public class CnContentDetail extends BaseEntity {

	@ZooData(name = "分类编号")
	private String code;

	@ZooData(name = "内容信息json串")
	@Column(columnDefinition = "longtext")
	private String content;

	@ZooData(name = "内容简述")
	private String description;

	@ZooData(name = "商品标题", verify = { DefineWebVerify.Max_Length + "=20" }, sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Edit + "=0", DefineWebPage.Page_Add + "=0" })
	@Column(length = 100)
	private String title;

	@ZooData(name = "视频地址")
	private String videoUrl;

	@ZooData(name = "视频封面")
	private String videoCover;

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

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getVideoCover() {
		return videoCover;
	}

	public void setVideoCover(String videoCover) {
		this.videoCover = videoCover;
	}

}
