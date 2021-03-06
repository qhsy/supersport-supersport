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
public class ApiStartLiveInput extends RootApiInput {

	@ApiModelProperty(value = "直播房间号")
	private String code;

	@ApiModelProperty(value = "直播聊天室")
	private String chatCode;

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

	@ApiModelProperty(value = "接受打赏人")
	private List<RedPackUserForApi> users = new ArrayList<RedPackUserForApi>();
	
	public List<RedPackUserForApi> getUsers() {
		return users;
	}

	public void setUsers(List<RedPackUserForApi> users) {
		this.users = users;
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

}
