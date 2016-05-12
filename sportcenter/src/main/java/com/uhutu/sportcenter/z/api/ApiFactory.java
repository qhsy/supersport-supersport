package com.uhutu.sportcenter.z.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.api.category.ApiForSports;
import com.uhutu.sportcenter.z.api.content.ApiComplainInfo;
import com.uhutu.sportcenter.z.api.content.ApiContentDetailInfo;
import com.uhutu.sportcenter.z.api.content.ApiContentPhotosDetailInfo;
import com.uhutu.sportcenter.z.api.content.ApiContentRecommInfo;
import com.uhutu.sportcenter.z.api.content.ApiPublishContentPhotos;
import com.uhutu.sportcenter.z.api.content.ApiPublishSportingMoment;
import com.uhutu.sportcenter.z.api.content.ApiSportingMoments;
import com.uhutu.sportcenter.z.api.content.ApiSupportPraise;
import com.uhutu.sportcenter.z.api.extend.ApiSendSms;
import com.uhutu.sportcenter.z.api.home.APiStartPage;
import com.uhutu.sportcenter.z.api.home.ApiHomePage;
import com.uhutu.sportcenter.z.api.label.ApiForLabels;
import com.uhutu.sportcenter.z.api.remark.ApiPublishRemark;
import com.uhutu.sportcenter.z.api.remark.ApiRemarkCount;
import com.uhutu.sportcenter.z.api.remark.ApiRemarkList;
import com.uhutu.sportcenter.z.api.user.ApiForLogin;
import com.uhutu.sportcenter.z.api.user.ApiLoginOut;
import com.uhutu.sportcenter.z.api.user.ApiSetUserFavor;
import com.uhutu.sportcenter.z.api.user.ApiSocialLogin;
import com.uhutu.sportcenter.z.api.user.ApiUserInfo;
import com.uhutu.sportcenter.z.api.user.ApiUserRegister;
import com.uhutu.sportcenter.z.api.user.ApiUserResetPwd;
import com.uhutu.sportcenter.z.api.user.ApiVersionInfo;

/**
 * api工厂
 * 
 * @author pang_jhui
 *
 */
@Component
public class ApiFactory {

	@Autowired
	private ApiContentDetailInfo contentDetailInfo;

	@Autowired
	private ApiContentPhotosDetailInfo contentPhotosDetailInfo;

	@Autowired
	private ApiVersionInfo apiVersionInfo;

	@Autowired
	private ApiUserRegister apiUserRegister;

	@Autowired
	private ApiUserInfo apiUserInfo;

	@Autowired
	private ApiSupportPraise apiSupportPraise;

	@Autowired
	private APiStartPage apiStartPage;

	@Autowired
	private ApiSportingMoments apiSportingMoments;

	@Autowired
	private ApiSocialLogin apiSocialLogin;

	@Autowired
	private ApiSendSms apiSendSms;

	@Autowired
	private ApiPublishSportingMoment apiPublishSportingMoment;

	@Autowired
	private ApiLoginOut apiLoginOut;

	@Autowired
	private ApiHomePage apiHomePage;

	@Autowired
	private ApiForLogin apiForLogin;

	@Autowired
	private ApiForLabels apiForLabels;

	@Autowired
	private ApiUserResetPwd apiUserResetPwd;

	@Autowired
	private ApiForSports apiForSports;

	@Autowired
	private ApiSetUserFavor apiSetUserFavor;
	
	@Autowired
	private ApiComplainInfo apiComplainInfo;
	
	@Autowired
	private ApiPublishContentPhotos apiPublishContentPhotos;
	
	@Autowired
	private ApiContentRecommInfo apiContentRecommInfo;
	
	@Autowired
	private ApiPublishRemark apiPublishRemark;
	
	@Autowired
	private ApiRemarkList apiRemarkList;
	
	@Autowired
	private ApiRemarkCount apiRemarkCount;

	public ApiContentDetailInfo getContentDetailInfo() {
		return contentDetailInfo;
	}

	public ApiContentPhotosDetailInfo getContentPhotosDetailInfo() {
		return contentPhotosDetailInfo;
	}

	public ApiVersionInfo getApiVersionInfo() {
		return apiVersionInfo;
	}

	public ApiUserRegister getApiUserRegister() {
		return apiUserRegister;
	}

	public ApiUserInfo getApiUserInfo() {
		return apiUserInfo;
	}

	public ApiSupportPraise getApiSupportPraise() {
		return apiSupportPraise;
	}

	public APiStartPage getApiStartPage() {
		return apiStartPage;
	}

	public ApiSportingMoments getApiSportingMoments() {
		return apiSportingMoments;
	}

	public ApiSocialLogin getApiSocialLogin() {
		return apiSocialLogin;
	}

	public ApiSendSms getApiSendSms() {
		return apiSendSms;
	}

	public ApiPublishSportingMoment getApiPublishSportingMoment() {
		return apiPublishSportingMoment;
	}

	public ApiLoginOut getApiLoginOut() {
		return apiLoginOut;
	}

	public ApiHomePage getApiHomePage() {
		return apiHomePage;
	}

	public ApiForLogin getApiForLogin() {
		return apiForLogin;
	}

	public ApiForLabels getApiForLabels() {
		return apiForLabels;
	}

	public ApiUserResetPwd getApiUserResetPwd() {
		return apiUserResetPwd;
	}

	public ApiForSports getApiForSports() {
		return apiForSports;
	}

	public ApiSetUserFavor getApiSetUserFavor() {
		return apiSetUserFavor;
	}

	public ApiPublishContentPhotos getApiPublishContentPhotos() {
		return apiPublishContentPhotos;
	}

	public ApiComplainInfo getApiComplainInfo() {
		return apiComplainInfo;
	}

	public ApiContentRecommInfo getApiContentRecommInfo() {
		return apiContentRecommInfo;
	}

	public ApiPublishRemark getApiPublishRemark() {
		return apiPublishRemark;
	}

	public ApiRemarkList getApiRemarkList() {
		return apiRemarkList;
	}

	public ApiRemarkCount getApiRemarkCount() {
		return apiRemarkCount;
	}

}