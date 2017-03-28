package com.uhutu.sportcenter.z.input;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.RedPackUserForApi;
import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 开始直播输入参数
 * 
 * @author 逄小帅
 *
 */
public class ApiBeginLiveInput extends RootApiInput {

	@ApiModelProperty(value = "群组Id")
	private String groupId;

	@ApiModelProperty(value = "直播封面")
	private String cover;

	@ApiModelProperty(value = "直播标题")
	private String title;

	@ApiModelProperty(value = "直播地址")
	private String addressName;

	@ApiModelProperty(value = "经度")
	private String longitude;

	@ApiModelProperty(value = "维度")
	private String latitude;

	@ApiModelProperty(value = "标签编码")
	private String tagCode;
	
	@ApiModelProperty(value = "横屏标识 dzsd4699100110010001:是 dzsd4699100110010002:否")
	private String landScapeFlag;
	
	@ApiModelProperty(value="直播流地址")
	private String streamUrl;
	
	@ApiModelProperty(value="web直播地址")
	private String webStreamUrl;

	@ApiModelProperty(value = "接受打赏人")
	private List<RedPackUserForApi> users = new ArrayList<RedPackUserForApi>();
	
	public List<RedPackUserForApi> getUsers() {
		return users;
	}

	public void setUsers(List<RedPackUserForApi> users) {
		this.users = users;
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

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
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

	public String getTagCode() {
		return tagCode;
	}

	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getLandScapeFlag() {
		return landScapeFlag;
	}

	public void setLandScapeFlag(String landScapeFlag) {
		this.landScapeFlag = landScapeFlag;
	}

	public String getStreamUrl() {
		return streamUrl;
	}

	public void setStreamUrl(String streamUrl) {
		this.streamUrl = streamUrl;
	}

	public String getWebStreamUrl() {
		return webStreamUrl;
	}

	public void setWebStreamUrl(String webStreamUrl) {
		this.webStreamUrl = webStreamUrl;
	}

}
