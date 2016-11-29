package com.uhutu.dcom.content.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 直播副表
 * 
 * @author xiegj
 *
 */
@Entity
public class CnLiveVideoDetail extends BaseEntity {

	@ZooData(name = "房间编号")
	private String code;

	@ZooData(name = "聊天室编号")
	private String chatCode;

	@ZooData(name = "用户编号")
	private String userCode;

	@ZooData(name = "直播封面")
	private String cover;

	@ZooData(name = "标题")
	private String title;

	@ZooData(name = "状态  1:正在直播,0:结束 ")
	private String status;

	@ZooData(name = "经度")
	private String longitude;

	@ZooData(name = "维度")
	private String latitude;

	@ZooData(name = "定位位置名称")
	private String addressName;

	@ZooData(name = "点赞数")
	private long praise;

	@ZooData(name = "观看人次")
	private long watch;

	@ZooData(name = "时长")
	private int length;

	@ZooData(name = "创建时间")
	private String createTime;

	@ZooData(name = "结束时间")
	private String endTime;
	
	@ZooData(name = "标签编码")
	@Column(columnDefinition = "longtext")
	private String tagCode;
	
	@ZooData(name = "直播流标识")
	private long streamId;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getChatCode() {
		return chatCode;
	}

	public void setChatCode(String chatCode) {
		this.chatCode = chatCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public long getPraise() {
		return praise;
	}

	public void setPraise(long praise) {
		this.praise = praise;
	}

	public long getWatch() {
		return watch;
	}

	public void setWatch(long watch) {
		this.watch = watch;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTagCode() {
		return tagCode;
	}

	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}

	public long getStreamId() {
		return streamId;
	}

	public void setStreamId(long streamId) {
		this.streamId = streamId;
	}

}
