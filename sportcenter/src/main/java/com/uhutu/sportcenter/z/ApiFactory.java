package com.uhutu.sportcenter.z;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

}
