package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;
import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 内容信息数据模型
 * 
 * @author xiegj
 *
 */
@Entity
public class CnContentDetail extends BaseEntity {

	@ZooData(name = "编号")
	private String code;

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
