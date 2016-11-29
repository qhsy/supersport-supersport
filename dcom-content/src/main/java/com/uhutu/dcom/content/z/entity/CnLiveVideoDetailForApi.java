package com.uhutu.dcom.content.z.entity;

import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 直播副表
 * 
 * @author xiegj
 *
 */
public class CnLiveVideoDetailForApi extends BaseEntity {

	@ApiModelProperty(name = "房间编号", notes = "房间编号")
	private String code;

	@ApiModelProperty(name = "聊天室编号", notes = "聊天室编号")
	private String chatCode;

	@ApiModelProperty(name = "用户编号", notes = "用户编号")
	private String userCode;

	@ApiModelProperty(name = "用户昵称", notes = "用户昵称")
	private String nickName;

	@ApiModelProperty(name = "头像图片链接", notes = "头像图片链接", example = "http://www.ichsy.com")
	private String aboutHead;

	@ApiModelProperty(name = "直播封面", notes = "直播封面")
	private String cover;

	@ApiModelProperty(name = "标题", notes = "标题")
	private String title;

	@ApiModelProperty(name = "状态  1:正在直播,0:结束 ", notes = "状态  1:正在直播,0:结束 ")
	private String status;

	@ApiModelProperty(name = "经度", notes = "经度")
	private String longitude;

	@ApiModelProperty(name = "维度", notes = "维度")
	private String latitude;

	@ApiModelProperty(name = "定位位置名称", notes = "定位位置名称")
	private String addressName;

	@ApiModelProperty(name = "点赞数", notes = "点赞数")
	private long praise;

	@ApiModelProperty(name = "观看人次", notes = "观看人次")
	private long watch;

	@ApiModelProperty(name = "时长", notes = "时长")
	private int length;

	@ApiModelProperty(name = "创建时间", notes = "创建时间")
	private String createTime;

	@ApiModelProperty(name = "结束时间", notes = "结束时间")
	private String endTime;

	@ApiModelProperty(name = "标签编码", notes = "标签编码")
	private String tagCode;

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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAboutHead() {
		return aboutHead;
	}

	public void setAboutHead(String aboutHead) {
		this.aboutHead = aboutHead;
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

}
