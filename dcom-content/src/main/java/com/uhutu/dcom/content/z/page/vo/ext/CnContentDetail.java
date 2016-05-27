package com.uhutu.dcom.content.z.page.vo.ext;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 内容信息数据模型
 * 
 * @author xiegj
 *
 */
public class CnContentDetail extends BaseEntity {

	@ZooData(name = "内容标题", sort = { DefineWebPage.Page_Edit + "=0" }, element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw410710010008" })
	private String code;

	@ZooData(name = "内容信息", element = DefineWebElement.Editor, sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" })
	private String content;

	@ZooData(name = "内容简述", element = DefineWebElement.Textarea, sort = { DefineWebPage.Page_Query + "=0" })
	private String description;

	@ZooData(name = "视频地址", require = "1", sort = { DefineWebPage.Page_Query + "=0" })
	private String videoUrl;

	@ZooData(name = "视频封面", require = "1", element = DefineWebElement.Upload, sort = {
			DefineWebPage.Page_Query + "=0" })
	private String videoCover;

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
