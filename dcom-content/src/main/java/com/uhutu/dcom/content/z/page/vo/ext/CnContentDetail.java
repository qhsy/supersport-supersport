package com.uhutu.dcom.content.z.page.vo.ext;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebSort;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 内容信息数据模型
 * 
 * @author xiegj
 *
 */
public class CnContentDetail extends BaseEntity {

	@ZooData(name = "内容标题", sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Add + "=" + DefineWebSort.Sort_Process,
			DefineWebPage.Page_Edit + "=" + DefineWebSort.Sort_Process }, inc = DefineWebInc.Url_Param + "=code")
	private String code;

	@ZooData(name = "视频地址", require = "1", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	private String videoUrl;

	@ZooData(name = "视频封面", require = "1", element = DefineWebElement.Upload, sort = {
			DefineWebPage.Page_Query + "=0" })
	private String videoCover;

	@ZooData(name = "视频简述", element = DefineWebElement.Textarea)
	private String description;

	@ZooData(name = "内容信息", element = DefineWebElement.Editor, sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" })
	private String content;

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
