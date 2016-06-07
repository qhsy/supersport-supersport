package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.UserAlbum;
import com.uhutu.sportcenter.z.entity.UserDonateInfo;
import com.uhutu.sportcenter.z.entity.UserInfoExpert;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 达人用户详情
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiUserExpertDetailResult extends RootApiResult {
	
	@ApiModelProperty(value="达人用户信息")
	private UserInfoExpert userInfoExpert;
	
	@ApiModelProperty(value="达人相册")
	private List<UserAlbum> userAlbum = new ArrayList<UserAlbum>();
	
	@ApiModelProperty(value="支持者排名信息")
	private List<UserDonateInfo> userDonateInfos = new ArrayList<UserDonateInfo>();
	
	@ApiModelProperty(value="已支持的能量")
	private long supportPower;

	public UserInfoExpert getUserInfoExpert() {
		return userInfoExpert;
	}

	public void setUserInfoExpert(UserInfoExpert userInfoExpert) {
		this.userInfoExpert = userInfoExpert;
	}

	public List<UserAlbum> getUserAlbum() {
		return userAlbum;
	}

	public void setUserAlbum(List<UserAlbum> userAlbum) {
		this.userAlbum = userAlbum;
	}

	public List<UserDonateInfo> getUserDonateInfos() {
		return userDonateInfos;
	}

	public void setUserDonateInfos(List<UserDonateInfo> userDonateInfos) {
		this.userDonateInfos = userDonateInfos;
	}

	public long getSupportPower() {
		return supportPower;
	}

	public void setSupportPower(long supportPower) {
		this.supportPower = supportPower;
	}
	
	

}
