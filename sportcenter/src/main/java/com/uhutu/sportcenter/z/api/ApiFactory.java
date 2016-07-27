package com.uhutu.sportcenter.z.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.api.answer.ApiAnswerAttendList;
import com.uhutu.sportcenter.z.api.answer.ApiAnswerInfoList;
import com.uhutu.sportcenter.z.api.answer.ApiAnswerListenList;
import com.uhutu.sportcenter.z.api.answer.ApiAnswerQuestionDetail;
import com.uhutu.sportcenter.z.api.answer.ApiAnswerUserInfo;
import com.uhutu.sportcenter.z.api.answer.ApiAppPersonHome;
import com.uhutu.sportcenter.z.api.answer.ApiAppUpdateAnswerUser;
import com.uhutu.sportcenter.z.api.answer.ApiAskQuestion;
import com.uhutu.sportcenter.z.api.answer.ApiAskWechatMsg;
import com.uhutu.sportcenter.z.api.answer.ApiForAnswerOrder;
import com.uhutu.sportcenter.z.api.answer.ApiForAnswerQuestion;
import com.uhutu.sportcenter.z.api.answer.ApiForAskQuestion;
import com.uhutu.sportcenter.z.api.answer.ApiHotQuestions;
import com.uhutu.sportcenter.z.api.answer.ApiNewQuestions;
import com.uhutu.sportcenter.z.api.answer.ApiOpenAskQuestion;
import com.uhutu.sportcenter.z.api.answer.ApiPersonHome;
import com.uhutu.sportcenter.z.api.answer.ApiPlayAudio;
import com.uhutu.sportcenter.z.api.answer.ApiQuestionDetail;
import com.uhutu.sportcenter.z.api.answer.ApiQuestionInfoList;
import com.uhutu.sportcenter.z.api.answer.ApiQuestionPraise;
import com.uhutu.sportcenter.z.api.answer.ApiRichAnswers;
import com.uhutu.sportcenter.z.api.answer.ApiSaveWechatVoice;
import com.uhutu.sportcenter.z.api.answer.ApiUpdateAnswerUser;
import com.uhutu.sportcenter.z.api.buttock.ApiButtockInfo;
import com.uhutu.sportcenter.z.api.buttock.ApiButtockLapList;
import com.uhutu.sportcenter.z.api.buttock.ApiButtockNotes;
import com.uhutu.sportcenter.z.api.buttock.ApiButtockPowerList;
import com.uhutu.sportcenter.z.api.category.ApiForSports;
import com.uhutu.sportcenter.z.api.content.ApiComplainInfo;
import com.uhutu.sportcenter.z.api.content.ApiContentDetailInfo;
import com.uhutu.sportcenter.z.api.content.ApiContentPhotosDetailInfo;
import com.uhutu.sportcenter.z.api.content.ApiContentRecommInfo;
import com.uhutu.sportcenter.z.api.content.ApiOperContent;
import com.uhutu.sportcenter.z.api.content.ApiPublishContentPhotos;
import com.uhutu.sportcenter.z.api.content.ApiPublishSportingMoment;
import com.uhutu.sportcenter.z.api.content.ApiShareContent;
import com.uhutu.sportcenter.z.api.content.ApiSportingMoments;
import com.uhutu.sportcenter.z.api.content.ApiSupportPraise;
import com.uhutu.sportcenter.z.api.content.ApiThemePage;
import com.uhutu.sportcenter.z.api.donate.ApiUpdateUserPower;
import com.uhutu.sportcenter.z.api.donate.ApiUserExpertDetail;
import com.uhutu.sportcenter.z.api.donate.ApiUserExpertList;
import com.uhutu.sportcenter.z.api.donate.ApiUserPowerInit;
import com.uhutu.sportcenter.z.api.donate.ApiUserPowerShare;
import com.uhutu.sportcenter.z.api.donate.ApiUserShareInfo;
import com.uhutu.sportcenter.z.api.extend.ApiSendSms;
import com.uhutu.sportcenter.z.api.home.APiStartPage;
import com.uhutu.sportcenter.z.api.home.ApiHomePage;
import com.uhutu.sportcenter.z.api.label.ApiForLabels;
import com.uhutu.sportcenter.z.api.pay.ApiWechatConfigInfo;
import com.uhutu.sportcenter.z.api.pay.ApiWechatH5Pay;
import com.uhutu.sportcenter.z.api.pay.ApiWechatMobilePay;
import com.uhutu.sportcenter.z.api.remark.ApiPublishRemark;
import com.uhutu.sportcenter.z.api.remark.ApiRemarkCount;
import com.uhutu.sportcenter.z.api.remark.ApiRemarkList;
import com.uhutu.sportcenter.z.api.user.ApiAttendList;
import com.uhutu.sportcenter.z.api.user.ApiFansList;
import com.uhutu.sportcenter.z.api.user.ApiFavorContentList;
import com.uhutu.sportcenter.z.api.user.ApiForAttention;
import com.uhutu.sportcenter.z.api.user.ApiForLogin;
import com.uhutu.sportcenter.z.api.user.ApiForTecentSig;
import com.uhutu.sportcenter.z.api.user.ApiLoginOut;
import com.uhutu.sportcenter.z.api.user.ApiMsgAdvice;
import com.uhutu.sportcenter.z.api.user.ApiMsgAttendList;
import com.uhutu.sportcenter.z.api.user.ApiMsgNoticeList;
import com.uhutu.sportcenter.z.api.user.ApiMsgNumList;
import com.uhutu.sportcenter.z.api.user.ApiMsgPraiseList;
import com.uhutu.sportcenter.z.api.user.ApiMsgRemarkList;
import com.uhutu.sportcenter.z.api.user.ApiRecommendExpert;
import com.uhutu.sportcenter.z.api.user.ApiSetUserFavor;
import com.uhutu.sportcenter.z.api.user.ApiSocialLogin;
import com.uhutu.sportcenter.z.api.user.ApiUpdateMsgStatus;
import com.uhutu.sportcenter.z.api.user.ApiUpdateUserInfo;
import com.uhutu.sportcenter.z.api.user.ApiUserInfo;
import com.uhutu.sportcenter.z.api.user.ApiUserInfoAll;
import com.uhutu.sportcenter.z.api.user.ApiUserRegister;
import com.uhutu.sportcenter.z.api.user.ApiUserResetPwd;
import com.uhutu.sportcenter.z.api.user.ApiVerifyNickName;
import com.uhutu.sportcenter.z.api.user.ApiVersionInfo;
import com.uhutu.sportcenter.z.api.user.ApiWechatUserLogin;

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
	private ApiForAnswerOrder apiForAnswerOrder;

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

	@Autowired
	private ApiMsgNumList apiMsgNumList;

	@Autowired
	private ApiUpdateMsgStatus apiUpdateMsgStatus;

	@Autowired
	private ApiMsgRemarkList apiMsgRemarkList;

	@Autowired
	private ApiMsgPraiseList apiMsgPraiseList;

	@Autowired
	private ApiForAttention apiForAttention;

	@Autowired
	private ApiMsgAttendList apiMsgAttendList;

	@Autowired
	private ApiMsgNoticeList apiMsgNoticeList;

	@Autowired
	private ApiUpdateUserInfo apiUpdateUserInfo;

	@Autowired
	private ApiMsgAdvice apiMsgAdvice;

	@Autowired
	private ApiShareContent apiShareContent;

	@Autowired
	private ApiAttendList apiAttendList;

	@Autowired
	private ApiFansList apiFansList;

	@Autowired
	private ApiFavorContentList apiFavorContentList;

	@Autowired
	private ApiVerifyNickName apiVerifyNickName;

	@Autowired
	private ApiOperContent apiOperContent;

	@Autowired
	private ApiUserPowerInit apiUserPowerInit;

	@Autowired
	private ApiUserExpertList apiUserExpertList;

	@Autowired
	private ApiUserPowerShare apiUserPowerShare;

	@Autowired
	private ApiUserExpertDetail apiUserExpertDetail;

	@Autowired
	private ApiUpdateUserPower apiUpdateUserPower;

	@Autowired
	private ApiUserShareInfo apiUserShareInfo;

	@Autowired
	private ApiForTecentSig apiForTecentSig;

	@Autowired
	private ApiWechatConfigInfo apiWechatConfigInfo;

	@Autowired
	private ApiAnswerUserInfo apiAnswerUserInfo;

	@Autowired
	private ApiUpdateAnswerUser apiUpdateAnswerUser;

	@Autowired
	private ApiRecommendExpert apiRecommendExpert;

	@Autowired
	private ApiForAskQuestion apiForAskQuestion;

	@Autowired
	private ApiForAnswerQuestion apiForAnswerQuestion;

	@Autowired
	private ApiRichAnswers apiRichAnswers;

	@Autowired
	private ApiHotQuestions apiHotQuestions;

	@Autowired
	private ApiNewQuestions apiNewQuestions;

	@Autowired
	private ApiQuestionDetail apiQuestionDetail;

	@Autowired
	private ApiQuestionInfoList apiQuestionInfoList;

	@Autowired
	private ApiAnswerInfoList apiAnswerInfoList;

	@Autowired
	private ApiSaveWechatVoice apiSaveWechatVoice;

	@Autowired
	private ApiAnswerListenList apiAnswerListenList;

	@Autowired
	private ApiWechatUserLogin apiWechatUserLogin;

	@Autowired
	private ApiAskQuestion apiAskQuestion;

	@Autowired
	private ApiOpenAskQuestion apiOpenAskQuestion;

	@Autowired
	private ApiPersonHome apiPersonHome;

	@Autowired
	private ApiAnswerQuestionDetail answerQuestionDetail;

	@Autowired
	private ApiQuestionPraise apiQuestionPraise;

	@Autowired
	private ApiPlayAudio apiPlayAudio;

	@Autowired
	private ApiWechatH5Pay apiWechatH5Pay;

	@Autowired
	private ApiAskWechatMsg apiAskWechatMsg;

	@Autowired
	private ApiAnswerAttendList apiAnswerAttendList;

	@Autowired
	private ApiButtockPowerList apiButtockPowerList;

	@Autowired
	private ApiButtockLapList apiButtockLapList;

	@Autowired
	private ApiButtockNotes apiButtockNotes;

	@Autowired
	private ApiButtockInfo apiButtockInfo;

	@Autowired
	private ApiAppPersonHome apiAppPersonHome;

	@Autowired
	private ApiUserInfoAll apiUserInfoAll;

	@Autowired
	private ApiWechatMobilePay apiWechatMobilePay;

	@Autowired
	ApiThemePage apiThemePage;
	
	@Autowired
	private ApiAppUpdateAnswerUser apiAppUpdateAnswerUser;

	public ApiThemePage getApiThemePage() {
		return apiThemePage;
	}

	public ApiButtockNotes getApiButtockNotes() {
		return apiButtockNotes;
	}

	public ApiQuestionPraise getApiQuestionPraise() {
		return apiQuestionPraise;
	}

	public ApiAnswerQuestionDetail getAnswerQuestionDetail() {
		return answerQuestionDetail;
	}

	public ApiOpenAskQuestion getApiOpenAskQuestion() {
		return apiOpenAskQuestion;
	}

	public ApiAskQuestion getApiAskQuestion() {
		return apiAskQuestion;
	}

	public ApiSaveWechatVoice getApiSaveWechatVoice() {
		return apiSaveWechatVoice;
	}

	public ApiQuestionDetail getApiQuestionDetail() {
		return apiQuestionDetail;
	}

	public ApiRichAnswers getApiRichAnswers() {
		return apiRichAnswers;
	}

	public ApiHotQuestions getApiHotQuestions() {
		return apiHotQuestions;
	}

	public ApiNewQuestions getApiNewQuestions() {
		return apiNewQuestions;
	}

	public ApiForAnswerQuestion getApiForAnswerQuestion() {
		return apiForAnswerQuestion;
	}

	public ApiForAskQuestion getApiForAskQuestion() {
		return apiForAskQuestion;
	}

	public ApiRecommendExpert getApiRecommendExpert() {
		return apiRecommendExpert;
	}

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

	public ApiForAnswerOrder getApiForAnswerOrder() {
		return apiForAnswerOrder;
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

	public ApiWechatMobilePay getApiWechatMobilePay() {
		return apiWechatMobilePay;
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

	public ApiForAttention getApiForAttention() {
		return apiForAttention;
	}

	public ApiMsgNumList getApiMsgNumList() {
		return apiMsgNumList;
	}

	public ApiUpdateMsgStatus getApiUpdateMsgStatus() {
		return apiUpdateMsgStatus;
	}

	public void setApiUpdateMsgStatus(ApiUpdateMsgStatus apiUpdateMsgStatus) {
		this.apiUpdateMsgStatus = apiUpdateMsgStatus;
	}

	public ApiMsgRemarkList getApiMsgRemarkList() {
		return apiMsgRemarkList;
	}

	public void setApiMsgRemarkList(ApiMsgRemarkList apiMsgRemarkList) {
		this.apiMsgRemarkList = apiMsgRemarkList;
	}

	public ApiMsgPraiseList getApiMsgPraiseList() {
		return apiMsgPraiseList;
	}

	public ApiMsgAttendList getApiMsgAttendList() {
		return apiMsgAttendList;
	}

	public ApiMsgNoticeList getApiMsgNoticeList() {
		return apiMsgNoticeList;
	}

	public ApiUpdateUserInfo getApiUpdateUserInfo() {
		return apiUpdateUserInfo;
	}

	public ApiMsgAdvice getApiMsgAdvice() {
		return apiMsgAdvice;
	}

	public ApiShareContent getApiShareContent() {
		return apiShareContent;
	}

	public ApiAttendList getApiAttendList() {
		return apiAttendList;
	}

	public ApiFansList getApiFansList() {
		return apiFansList;
	}

	public ApiFavorContentList getApiFavorContentList() {
		return apiFavorContentList;
	}

	public ApiVerifyNickName getApiVerifyNickName() {
		return apiVerifyNickName;
	}

	public ApiOperContent getApiOperContent() {
		return apiOperContent;
	}

	public ApiUserPowerInit getApiUserPowerInit() {
		return apiUserPowerInit;
	}

	public ApiUserExpertList getApiUserExpertList() {
		return apiUserExpertList;
	}

	public ApiUserPowerShare getApiUserPowerShare() {
		return apiUserPowerShare;
	}

	public ApiUserExpertDetail getApiUserExpertDetail() {
		return apiUserExpertDetail;
	}

	public void setApiUserExpertDetail(ApiUserExpertDetail apiUserExpertDetail) {
		this.apiUserExpertDetail = apiUserExpertDetail;
	}

	public ApiUpdateUserPower getApiUpdateUserPower() {
		return apiUpdateUserPower;
	}

	public ApiUserShareInfo getApiUserShareInfo() {
		return apiUserShareInfo;
	}

	public ApiForTecentSig getApiForTecentSig() {
		return apiForTecentSig;
	}

	public ApiWechatConfigInfo getApiWechatConfigInfo() {
		return apiWechatConfigInfo;
	}

	public ApiAnswerUserInfo getApiAnswerUserInfo() {
		return apiAnswerUserInfo;
	}

	public ApiUpdateAnswerUser getApiUpdateAnswerUser() {
		return apiUpdateAnswerUser;
	}

	public ApiQuestionInfoList getApiQuestionInfoList() {
		return apiQuestionInfoList;
	}

	public ApiAnswerInfoList getApiAnswerInfoList() {
		return apiAnswerInfoList;
	}

	public ApiAnswerListenList getApiAnswerListenList() {
		return apiAnswerListenList;
	}

	public ApiWechatUserLogin getApiWechatUserLogin() {
		return apiWechatUserLogin;
	}

	public ApiPersonHome getApiPersonHome() {
		return apiPersonHome;
	}

	public ApiPlayAudio getApiPlayAudio() {
		return apiPlayAudio;
	}

	public ApiWechatH5Pay getApiWechatH5Pay() {
		return apiWechatH5Pay;
	}

	public ApiAskWechatMsg getApiAskWechatMsg() {
		return apiAskWechatMsg;
	}

	public ApiAnswerAttendList getApiAnswerAttendList() {
		return apiAnswerAttendList;
	}

	public ApiButtockPowerList getApiButtockPowerList() {
		return apiButtockPowerList;
	}

	public ApiButtockLapList getApiButtockLapList() {
		return apiButtockLapList;
	}

	public ApiButtockInfo getApiButtockInfo() {
		return apiButtockInfo;
	}

	public ApiAppPersonHome getApiAppPersonHome() {
		return apiAppPersonHome;
	}

	public void setApiAppPersonHome(ApiAppPersonHome apiAppPersonHome) {
		this.apiAppPersonHome = apiAppPersonHome;
	}

	public ApiUserInfoAll getApiUserInfoAll() {
		return apiUserInfoAll;
	}

	public ApiAppUpdateAnswerUser getApiAppUpdateAnswerUser() {
		return apiAppUpdateAnswerUser;
	}

	public void setApiAppUpdateAnswerUser(ApiAppUpdateAnswerUser apiAppUpdateAnswerUser) {
		this.apiAppUpdateAnswerUser = apiAppUpdateAnswerUser;
	}

}
