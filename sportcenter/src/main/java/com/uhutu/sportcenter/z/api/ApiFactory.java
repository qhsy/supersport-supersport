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
import com.uhutu.sportcenter.z.api.answer.ApiBindSettleAccount;
import com.uhutu.sportcenter.z.api.answer.ApiForAnswerOrder;
import com.uhutu.sportcenter.z.api.answer.ApiForAnswerQuestion;
import com.uhutu.sportcenter.z.api.answer.ApiForAskQuestion;
import com.uhutu.sportcenter.z.api.answer.ApiForWatchCard;
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
import com.uhutu.sportcenter.z.api.answer.ApiUpdateUserTitle;
import com.uhutu.sportcenter.z.api.buttock.ApiButtockInfo;
import com.uhutu.sportcenter.z.api.buttock.ApiButtockLapList;
import com.uhutu.sportcenter.z.api.buttock.ApiButtockNotes;
import com.uhutu.sportcenter.z.api.buttock.ApiButtockPowerList;
import com.uhutu.sportcenter.z.api.buttock.ApiRefreshCrossfit;
import com.uhutu.sportcenter.z.api.category.ApiForSports;
import com.uhutu.sportcenter.z.api.content.ApiComplainInfo;
import com.uhutu.sportcenter.z.api.content.ApiContentDetailInfo;
import com.uhutu.sportcenter.z.api.content.ApiContentDetailProducts;
import com.uhutu.sportcenter.z.api.content.ApiContentPhotosDetailInfo;
import com.uhutu.sportcenter.z.api.content.ApiContentReadCount;
import com.uhutu.sportcenter.z.api.content.ApiContentRecommInfo;
import com.uhutu.sportcenter.z.api.content.ApiContentRedPack;
import com.uhutu.sportcenter.z.api.content.ApiContentRedPackUser;
import com.uhutu.sportcenter.z.api.content.ApiContentType;
import com.uhutu.sportcenter.z.api.content.ApiContentWorth;
import com.uhutu.sportcenter.z.api.content.ApiOperContent;
import com.uhutu.sportcenter.z.api.content.ApiOwnSportMoment;
import com.uhutu.sportcenter.z.api.content.ApiPicPasterList;
import com.uhutu.sportcenter.z.api.content.ApiPublishContentPhotos;
import com.uhutu.sportcenter.z.api.content.ApiPublishSportingMoment;
import com.uhutu.sportcenter.z.api.content.ApiShareContent;
import com.uhutu.sportcenter.z.api.content.ApiShareInfo;
import com.uhutu.sportcenter.z.api.content.ApiSportChickenSoup;
import com.uhutu.sportcenter.z.api.content.ApiSportingMoments;
import com.uhutu.sportcenter.z.api.content.ApiSportingMomentsSecond;
import com.uhutu.sportcenter.z.api.content.ApiSupportPraise;
import com.uhutu.sportcenter.z.api.content.ApiThemePage;
import com.uhutu.sportcenter.z.api.content.ApiTummyMoments;
import com.uhutu.sportcenter.z.api.donate.ApiUpdateUserPower;
import com.uhutu.sportcenter.z.api.donate.ApiUserExpertDetail;
import com.uhutu.sportcenter.z.api.donate.ApiUserExpertList;
import com.uhutu.sportcenter.z.api.donate.ApiUserPowerInit;
import com.uhutu.sportcenter.z.api.donate.ApiUserPowerShare;
import com.uhutu.sportcenter.z.api.donate.ApiUserShareInfo;
import com.uhutu.sportcenter.z.api.extend.ApiCheckSingType;
import com.uhutu.sportcenter.z.api.extend.ApiIosRenovate;
import com.uhutu.sportcenter.z.api.extend.ApiReportCheck;
import com.uhutu.sportcenter.z.api.extend.ApiReportFields;
import com.uhutu.sportcenter.z.api.extend.ApiReportSave;
import com.uhutu.sportcenter.z.api.extend.ApiReportShow;
import com.uhutu.sportcenter.z.api.extend.ApiSendSms;
import com.uhutu.sportcenter.z.api.extend.ApiSignPhoto;
import com.uhutu.sportcenter.z.api.extend.ApiStartUp;
import com.uhutu.sportcenter.z.api.home.APiStartPage;
import com.uhutu.sportcenter.z.api.home.ApiExpertChat;
import com.uhutu.sportcenter.z.api.home.ApiHomePage;
import com.uhutu.sportcenter.z.api.home.ApiHomePageSecond;
import com.uhutu.sportcenter.z.api.home.ApiHomePageThird;
import com.uhutu.sportcenter.z.api.home.ApiHotTopic;
import com.uhutu.sportcenter.z.api.home.ApiWonderfulVideo;
import com.uhutu.sportcenter.z.api.label.ApiForCreateLabel;
import com.uhutu.sportcenter.z.api.label.ApiForLabels;
import com.uhutu.sportcenter.z.api.label.ApiForSearchLabels;
import com.uhutu.sportcenter.z.api.label.ApiLabelRelList;
import com.uhutu.sportcenter.z.api.label.ApiRecommLabelList;
import com.uhutu.sportcenter.z.api.live.ApiFinishLiveVideo;
import com.uhutu.sportcenter.z.api.live.ApiLiveCreateRoom;
import com.uhutu.sportcenter.z.api.live.ApiLiveGift;
import com.uhutu.sportcenter.z.api.live.ApiLiveInfo;
import com.uhutu.sportcenter.z.api.live.ApiLiveInfoList;
import com.uhutu.sportcenter.z.api.live.ApiLiveMsg;
import com.uhutu.sportcenter.z.api.live.ApiLiveNotify;
import com.uhutu.sportcenter.z.api.live.ApiLiveVideoHeart;
import com.uhutu.sportcenter.z.api.live.ApiOperLiveInfo;
import com.uhutu.sportcenter.z.api.live.ApiStartLive;
import com.uhutu.sportcenter.z.api.live.ApiSyncLiveUserInfo;
import com.uhutu.sportcenter.z.api.match.ApiMatchInfo;
import com.uhutu.sportcenter.z.api.match.ApiMatchInfoList;
import com.uhutu.sportcenter.z.api.match.ApiMatchSignList;
import com.uhutu.sportcenter.z.api.match.ApiMySignInfo;
import com.uhutu.sportcenter.z.api.match.ApiMySignList;
import com.uhutu.sportcenter.z.api.match.ApiShareMatchInfo;
import com.uhutu.sportcenter.z.api.pay.ApiCoinAccInfo;
import com.uhutu.sportcenter.z.api.pay.ApiCoinCharge;
import com.uhutu.sportcenter.z.api.pay.ApiCoinFlowInfo;
import com.uhutu.sportcenter.z.api.pay.ApiCoinPay;
import com.uhutu.sportcenter.z.api.pay.ApiWechatConfigInfo;
import com.uhutu.sportcenter.z.api.pay.ApiWechatH5Pay;
import com.uhutu.sportcenter.z.api.pay.ApiWechatMobilePay;
import com.uhutu.sportcenter.z.api.redpack.ApiPackUserSearch;
import com.uhutu.sportcenter.z.api.redpack.ApiRedPackInfoList;
import com.uhutu.sportcenter.z.api.remark.ApiOperRemark;
import com.uhutu.sportcenter.z.api.remark.ApiPublishRemark;
import com.uhutu.sportcenter.z.api.remark.ApiRemarkCount;
import com.uhutu.sportcenter.z.api.remark.ApiRemarkList;
import com.uhutu.sportcenter.z.api.search.ApiSearchMatch;
import com.uhutu.sportcenter.z.api.search.ApiSearchUser;
import com.uhutu.sportcenter.z.api.search.ApiSearchVideo;
import com.uhutu.sportcenter.z.api.user.ApiAnswerMsgList;
import com.uhutu.sportcenter.z.api.user.ApiAttendFlag;
import com.uhutu.sportcenter.z.api.user.ApiAttendList;
import com.uhutu.sportcenter.z.api.user.ApiFansList;
import com.uhutu.sportcenter.z.api.user.ApiFavorContentList;
import com.uhutu.sportcenter.z.api.user.ApiForAttention;
import com.uhutu.sportcenter.z.api.user.ApiForLogin;
import com.uhutu.sportcenter.z.api.user.ApiForTecentSig;
import com.uhutu.sportcenter.z.api.user.ApiInviteUserInfo;
import com.uhutu.sportcenter.z.api.user.ApiLoginOut;
import com.uhutu.sportcenter.z.api.user.ApiMsgAdvice;
import com.uhutu.sportcenter.z.api.user.ApiMsgAttendList;
import com.uhutu.sportcenter.z.api.user.ApiMsgFocus;
import com.uhutu.sportcenter.z.api.user.ApiMsgNoticeList;
import com.uhutu.sportcenter.z.api.user.ApiMsgNumList;
import com.uhutu.sportcenter.z.api.user.ApiMsgPraiseList;
import com.uhutu.sportcenter.z.api.user.ApiMsgRemarkList;
import com.uhutu.sportcenter.z.api.user.ApiOperInviteUser;
import com.uhutu.sportcenter.z.api.user.ApiRecentMsgList;
import com.uhutu.sportcenter.z.api.user.ApiRecommendExpert;
import com.uhutu.sportcenter.z.api.user.ApiSetUserFavor;
import com.uhutu.sportcenter.z.api.user.ApiSignLogin;
import com.uhutu.sportcenter.z.api.user.ApiSocialLogin;
import com.uhutu.sportcenter.z.api.user.ApiSocialLogin2;
import com.uhutu.sportcenter.z.api.user.ApiUpdateMsgStatus;
import com.uhutu.sportcenter.z.api.user.ApiUpdateUserInfo;
import com.uhutu.sportcenter.z.api.user.ApiUserDataExpert;
import com.uhutu.sportcenter.z.api.user.ApiUserInfo;
import com.uhutu.sportcenter.z.api.user.ApiUserInfoAll;
import com.uhutu.sportcenter.z.api.user.ApiUserRegSign;
import com.uhutu.sportcenter.z.api.user.ApiUserRegister;
import com.uhutu.sportcenter.z.api.user.ApiUserResetPwd;
import com.uhutu.sportcenter.z.api.user.ApiVerifyNickName;
import com.uhutu.sportcenter.z.api.user.ApiVersionInfo;
import com.uhutu.sportcenter.z.api.user.ApiWalletInfo;
import com.uhutu.sportcenter.z.api.user.ApiWechatUserLogin;
import com.uhutu.sportcenter.z.api.user.ApiWechatUserLogin2;
import com.uhutu.sportcenter.z.api.user.ApiWechatUserLogin3;

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

	@Autowired
	private ApiUpdateUserTitle apiUpdateUserTitle;

	@Autowired
	private ApiBindSettleAccount apiBindSettleAccount;

	@Autowired
	private ApiOwnSportMoment apiOwnSportMoment;

	@Autowired
	private ApiSocialLogin2 apiSocialLogin2;

	@Autowired
	private ApiWechatUserLogin2 apiWechatUserLogin2;

	@Autowired
	private ApiAnswerMsgList apiAnswerMsgList;

	@Autowired
	private ApiRecentMsgList apiRecentMsgList;

	@Autowired
	private ApiShareInfo apiShareInfo;

	@Autowired
	private ApiCoinCharge apiCoinCharge;

	@Autowired
	private ApiCoinAccInfo apiCoinAccInfo;

	@Autowired
	private ApiCoinPay apiCoinPay;

	@Autowired
	private ApiMsgFocus apiMsgFocus;

	@Autowired
	private ApiContentReadCount apiContentReadCount;

	@Autowired
	private ApiCoinFlowInfo apiCoinFlowInfo;

	@Autowired
	private ApiSportChickenSoup apiSportChickenSoup;

	@Autowired
	private ApiLabelRelList apiLabelRelList;

	@Autowired
	private ApiWechatUserLogin3 apiWechatUserLogin3;

	@Autowired
	private ApiUserRegSign apiUserRegSign;

	@Autowired
	private ApiSignLogin apiSignLogin;

	@Autowired
	private ApiForCreateLabel apiForCreateLabel;

	@Autowired
	private ApiForSearchLabels apiForSearchLabels;

	@Autowired
	private ApiRecommLabelList apiRecommLabelList;

	@Autowired
	private ApiHotTopic apiHotTopic;

	@Autowired
	private ApiWonderfulVideo apiWonderfulVideo;

	@Autowired
	private ApiExpertChat apiExpertChat;

	@Autowired
	private ApiHomePageSecond apiHomePageSecond;

	@Autowired
	private ApiPicPasterList apiPicPasterList;

	@Autowired
	private ApiContentDetailProducts apiContentDetailProducts;

	@Autowired
	private ApiUserDataExpert apiUserDataExpert;

	@Autowired
	private ApiStartUp apiStartUp;

	@Autowired
	private ApiIosRenovate apiIosRenovate;

	@Autowired
	private ApiCheckSingType apiCheckSingType;

	@Autowired
	private ApiSignPhoto apiSignPhoto;

	@Autowired
	private ApiRefreshCrossfit apiRefreshCrossfit;

	@Autowired
	private ApiForWatchCard apiForWatchCard;

	@Autowired
	private ApiContentType apiContentType;

	@Autowired
	private ApiContentWorth apiContentWorth;

	@Autowired
	private ApiLiveCreateRoom apiLiveCreateRoom;

	@Autowired
	private ApiLiveInfoList apiLiveInfoList;

	@Autowired
	private ApiFinishLiveVideo apiFinishLiveVideo;

	@Autowired
	private ApiLiveVideoHeart apiLiveVideoHeart;

	@Autowired
	private ApiStartLive apiStartLive;

	@Autowired
	private ApiLiveNotify apiLiveNotify;

	@Autowired
	private ApiSyncLiveUserInfo apiSyncLiveUserInfo;

	@Autowired
	private ApiOperLiveInfo apiOperLiveInfo;

	@Autowired
	private ApiOperRemark apiOperRemark;

	@Autowired
	private ApiLiveInfo apiLiveInfo;

	@Autowired
	private ApiReportFields apiReportFields;

	@Autowired
	private ApiReportSave apiReportSave;

	@Autowired
	private ApiReportShow apiReportShow;

	@Autowired
	private ApiLiveMsg apiLiveMsg;

	@Autowired
	private ApiReportCheck apiReportCheck;

	@Autowired
	private ApiRedPackInfoList apiRedPackInfoList;

	@Autowired
	private ApiSportingMomentsSecond apiSportingMomentsSecond;

	@Autowired
	private ApiTummyMoments apiTummyMoments;

	@Autowired
	private ApiWalletInfo apiWalletInfo;

	@Autowired
	private ApiLiveGift apiLiveGift;

	@Autowired
	private ApiPackUserSearch apiPackUserSearch;

	@Autowired
	private ApiMatchInfoList apiMatchInfoList;

	@Autowired
	private ApiMatchInfo apiMatchInfo;
	
	@Autowired
	private ApiMatchSignList apiMatchSignList;
	
	@Autowired
	private ApiShareMatchInfo apiShareMatchInfo;

	@Autowired
	private ApiHomePageThird apiHomePageThird;
	
	@Autowired
	private ApiMySignList apiMySignList;
	
	@Autowired
	private ApiMySignInfo apiMySignInfo;
	
	@Autowired
	private ApiAttendFlag apiAttendFlag;
	
	@Autowired
	private ApiSearchMatch apiSearchMatch;
	
	@Autowired
	private ApiSearchUser apiSearchUser;
	
	@Autowired
	private ApiSearchVideo apiSearchVideo;
	
	@Autowired
	private ApiOperInviteUser apiOperInviteUser;
	
	@Autowired
	private ApiInviteUserInfo apiInviteUserInfo;
	
	@Autowired
	private ApiContentRedPack apiContentRedPack;
	
	@Autowired
	private ApiContentRedPackUser apiContentRedPackUser;

	public ApiHomePageThird getApiHomePageThird() {
		return apiHomePageThird;
	}

	public ApiLiveGift getApiLiveGift() {
		return apiLiveGift;
	}

	public ApiTummyMoments getApiTummyMoments() {
		return apiTummyMoments;
	}

	public ApiSportingMomentsSecond getApiSportingMomentsSecond() {
		return apiSportingMomentsSecond;
	}

	public ApiReportCheck getApiReportCheck() {
		return apiReportCheck;
	}

	public ApiLiveMsg getApiLiveMsg() {
		return apiLiveMsg;
	}

	public ApiReportShow getApiReportShow() {
		return apiReportShow;
	}

	public ApiReportSave getApiReportSave() {
		return apiReportSave;
	}

	public ApiReportFields getApiReportFields() {
		return apiReportFields;
	}

	public ApiLiveInfo getApiLiveInfo() {
		return apiLiveInfo;
	}

	public ApiLiveVideoHeart getApiLiveVideoHeart() {
		return apiLiveVideoHeart;
	}

	public ApiFinishLiveVideo getApiFinishLiveVideo() {
		return apiFinishLiveVideo;
	}

	public ApiLiveCreateRoom getApiLiveCreateRoom() {
		return apiLiveCreateRoom;
	}

	public ApiContentWorth getApiContentWorth() {
		return apiContentWorth;
	}

	public ApiContentType getApiContentType() {
		return apiContentType;
	}

	public ApiForWatchCard getApiForWatchCard() {
		return apiForWatchCard;
	}

	public ApiSignPhoto getApiSignPhoto() {
		return apiSignPhoto;
	}

	public ApiCheckSingType getApiCheckSingType() {
		return apiCheckSingType;
	}

	public ApiIosRenovate getApiIosRenovate() {
		return apiIosRenovate;
	}

	public ApiHomePageSecond getApiHomePageSecond() {
		return apiHomePageSecond;
	}

	public ApiRecommLabelList getApiRecommLabelList() {
		return apiRecommLabelList;
	}

	public ApiForSearchLabels getApiForSearchLabels() {
		return apiForSearchLabels;
	}

	public ApiForCreateLabel getApiForCreateLabel() {
		return apiForCreateLabel;
	}

	public ApiSportChickenSoup getApiSportChickenSoup() {
		return apiSportChickenSoup;
	}

	public ApiCoinFlowInfo getApiCoinFlowInfo() {
		return apiCoinFlowInfo;
	}

	public ApiContentReadCount getApiContentReadCount() {
		return apiContentReadCount;
	}

	public ApiShareInfo getApiShareInfo() {
		return apiShareInfo;
	}

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

	public ApiMsgRemarkList getApiMsgRemarkList() {
		return apiMsgRemarkList;
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

	public ApiUserInfoAll getApiUserInfoAll() {
		return apiUserInfoAll;
	}

	public ApiAppUpdateAnswerUser getApiAppUpdateAnswerUser() {
		return apiAppUpdateAnswerUser;
	}

	public ApiUpdateUserTitle getApiUpdateUserTitle() {
		return apiUpdateUserTitle;
	}

	public ApiBindSettleAccount getApiBindSettleAccount() {
		return apiBindSettleAccount;
	}

	public ApiOwnSportMoment getApiOwnSportMoment() {
		return apiOwnSportMoment;
	}

	public ApiSocialLogin2 getApiSocialLogin2() {
		return apiSocialLogin2;
	}

	public ApiWechatUserLogin2 getApiWechatUserLogin2() {
		return apiWechatUserLogin2;
	}

	public ApiAnswerMsgList getApiAnswerMsgList() {
		return apiAnswerMsgList;
	}

	public ApiRecentMsgList getApiRecentMsgList() {
		return apiRecentMsgList;
	}

	public ApiCoinCharge getApiCoinCharge() {
		return apiCoinCharge;
	}

	public ApiCoinAccInfo getApiCoinAccInfo() {
		return apiCoinAccInfo;
	}

	public ApiCoinPay getApiCoinPay() {
		return apiCoinPay;
	}

	public ApiMsgFocus getApiMsgFocus() {
		return apiMsgFocus;
	}

	public ApiLabelRelList getApiLabelRelList() {
		return apiLabelRelList;
	}

	public ApiWechatUserLogin3 getApiWechatUserLogin3() {
		return apiWechatUserLogin3;
	}

	public ApiUserRegSign getApiUserRegSign() {
		return apiUserRegSign;
	}

	public ApiSignLogin getApiSignLogin() {
		return apiSignLogin;
	}

	public ApiHotTopic getApiHotTopic() {
		return apiHotTopic;
	}

	public ApiWonderfulVideo getApiWonderfulVideo() {
		return apiWonderfulVideo;
	}

	public ApiExpertChat getApiExpertChat() {
		return apiExpertChat;
	}

	public ApiPicPasterList getApiPicPasterList() {
		return apiPicPasterList;
	}

	public ApiContentDetailProducts getApiContentDetailProducts() {
		return apiContentDetailProducts;
	}

	public ApiUserDataExpert getApiUserDataExpert() {
		return apiUserDataExpert;
	}

	public ApiStartUp getApiStartUp() {
		return apiStartUp;
	}

	public ApiRefreshCrossfit getApiRefreshCrossfit() {
		return apiRefreshCrossfit;
	}

	public ApiLiveInfoList getApiLiveInfoList() {
		return apiLiveInfoList;
	}

	public ApiStartLive getApiStartLive() {
		return apiStartLive;
	}

	public ApiSyncLiveUserInfo getApiSyncLiveUserInfo() {
		return apiSyncLiveUserInfo;
	}

	public ApiLiveNotify getApiLiveNotify() {
		return apiLiveNotify;
	}

	public ApiOperLiveInfo getApiOperLiveInfo() {
		return apiOperLiveInfo;
	}

	public ApiOperRemark getApiOperRemark() {
		return apiOperRemark;
	}

	public ApiRedPackInfoList getApiRedPackInfoList() {
		return apiRedPackInfoList;
	}

	public ApiWalletInfo getApiWalletInfo() {
		return apiWalletInfo;
	}

	public ApiPackUserSearch getApiPackUserSearch() {
		return apiPackUserSearch;
	}

	public ApiMatchInfoList getApiMatchInfoList() {
		return apiMatchInfoList;
	}

	public ApiMatchInfo getApiMatchInfo() {
		return apiMatchInfo;
	}

	public ApiMatchSignList getApiMatchSignList() {
		return apiMatchSignList;
	}

	public ApiShareMatchInfo getApiShareMatchInfo() {
		return apiShareMatchInfo;
	}

	public ApiMySignList getApiMySignList() {
		return apiMySignList;
	}

	public ApiMySignInfo getApiMySignInfo() {
		return apiMySignInfo;
	}

	public ApiAttendFlag getApiAttendFlag() {
		return apiAttendFlag;
	}

	public ApiSearchMatch getApiSearchMatch() {
		return apiSearchMatch;
	}

	public ApiSearchUser getApiSearchUser() {
		return apiSearchUser;
	}

	public ApiSearchVideo getApiSearchVideo() {
		return apiSearchVideo;
	}

	public ApiOperInviteUser getApiOperInviteUser() {
		return apiOperInviteUser;
	}

	public ApiInviteUserInfo getApiInviteUserInfo() {
		return apiInviteUserInfo;
	}

	public ApiContentRedPack getApiContentRedPack() {
		return apiContentRedPack;
	}

	public ApiContentRedPackUser getApiContentRedPackUser() {
		return apiContentRedPackUser;
	}

}
