package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 直播信息vo
 * @author 逄小帅
 *
 */
public class LiveDetailInfo{
	
	@ApiModelProperty(value = "用户基本信息")
	private UserBasicInfo userBasicInfo = new UserBasicInfo();
	
	@ApiModelProperty(value = "房间号")
	private String code;
	
	@ApiModelProperty(value = "聊天室编号")
	private String chatCode;

	@ApiModelProperty(value = "直播封面")
	private String cover;

	@ApiModelProperty(value = "标题")
	private String title;

	@ApiModelProperty(value = "状态")
	private String status;

	@ApiModelProperty(value = "经度")
	private String longitude;
	
	@ApiModelProperty(value = "维度")
	private String latitude;
	
	@ApiModelProperty(value = "定位位置名称")
	private String addressName;

	@ApiModelProperty(value = "点赞数")
	private long praise;

	@ApiModelProperty(value = "观看人次")
	private long watch;
	
	@ApiModelProperty(value = "时长")
	private int length;
	
	@ApiModelProperty(value = "标签名称")
	private String tagName;

	public UserBasicInfo getUserBasicInfo() {
		return userBasicInfo;
	}

	public void setUserBasicInfo(UserBasicInfo userBasicInfo) {
		this.userBasicInfo = userBasicInfo;
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

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	
	

}
