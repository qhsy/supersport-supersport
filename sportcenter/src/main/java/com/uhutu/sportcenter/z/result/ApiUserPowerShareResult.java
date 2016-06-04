package com.uhutu.sportcenter.z.result;

import com.uhutu.dcom.extend.sms.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户能量分享结果
 * @author pang_jhui
 *
 */
public class ApiUserPowerShareResult extends RootApiResult {
	
	@ApiModelProperty(value="分享标题")
	private String shareTitle;
	
	@ApiModelProperty(value="分享描述")
	private String shareDesc;
	
	@ApiModelProperty(value="分享图标")
	private String shareIcon;
	
	@ApiModelProperty(value="分享访问路径")
	private String shareUrl;

	public String getShareTitle() {
		return shareTitle;
	}

	public void setShareTitle(String shareTitle) {
		this.shareTitle = shareTitle;
	}

	public String getShareDesc() {
		return shareDesc;
	}

	public void setShareDesc(String shareDesc) {
		this.shareDesc = shareDesc;
	}

	public String getShareIcon() {
		return shareIcon;
	}

	public void setShareIcon(String shareIcon) {
		this.shareIcon = shareIcon;
	}

	public String getShareUrl() {
		return shareUrl;
	}

	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}

}
