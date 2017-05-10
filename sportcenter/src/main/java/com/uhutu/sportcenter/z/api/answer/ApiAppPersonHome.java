package com.uhutu.sportcenter.z.api.answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.activity.z.entity.AcActivityAnswerInfo;
import com.uhutu.dcom.activity.z.support.AnswerActivitySupport;
import com.uhutu.dcom.answer.z.common.AnswerEnum;
import com.uhutu.dcom.answer.z.common.Constants;
import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.answer.z.service.AnswerServiceFactory;
import com.uhutu.dcom.answer.z.support.QuestionSupport;
import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.user.z.entity.UcAttentionInfo;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.entity.UserBasicInfo;
import com.uhutu.dcom.user.z.enums.UserEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.api.util.ContentComponent;
import com.uhutu.sportcenter.z.entity.AnswerUserInfo;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.entity.QuestionInfo;
import com.uhutu.sportcenter.z.entity.UserInfo;
import com.uhutu.sportcenter.z.input.ApiAppPersonHomeInput;
import com.uhutu.sportcenter.z.result.ApiAppPersonHomeResult;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;
import com.uhutu.zooweb.user.UserCallFactory;

/**
 * 个人主页 for app
 * @author 逄小帅
 *
 */
@Component
public class ApiAppPersonHome extends RootApiBase<ApiAppPersonHomeInput, ApiAppPersonHomeResult> {
	
	@Autowired
	private AnswerServiceFactory answerServiceFactory;
	
	@Autowired
	private UserInfoSupport userInfoSupport;
	
	@Autowired
	private UserServiceFactory userServiceFactory;
	
	@Autowired
	private ContentServiceFactory contentServiceFactory;
	
	private String token;

	@Override
	protected ApiAppPersonHomeResult process(ApiAppPersonHomeInput input) {
		
		token = input.getZoo().getToken();
		
		ApiAppPersonHomeResult result = new ApiAppPersonHomeResult();
		
		String attendUserCode = "";
		
		AwAnswerExpert answerExpert = answerServiceFactory.getAwAnswerExpertService().getByUserCode(input.getUserCode());
		
		if(answerExpert == null){
			
			answerExpert = new AwAnswerExpert();
			
			answerExpert.setUserCode(input.getUserCode());
			
			answerExpert.setStatus(SystemEnum.NO.getCode());
			
		}
		
		if (result.upFlagTrue()) {

			int count = answerServiceFactory.getQuestionInfoService().queryAnswerCount(input.getUserCode(),
					Constants.STATUS_ANSWERED);

			int momentNum = JdbcHelper.count(CnContentBasicinfo.class, "",
					MapHelper.initMap("busiType", ContentEnum.sportmoment.getCode(), "status",
							ContentEnum.normal.getCode(), "shareScope", SystemEnum.YES.getCode(),"author",input.getUserCode()));

			AnswerUserInfo answerUserInfo = new AnswerUserInfo();

			BeanUtils.copyProperties(answerExpert, answerUserInfo);

			UserBasicInfo userBasicInfo = userInfoSupport.getUserBasicInfo(input.getUserCode());

			answerUserInfo.setAboutHead(userBasicInfo.getUcUserinfoExt().getAboutHead());

			answerUserInfo.setNickName(userBasicInfo.getUcUserinfoExt().getNickName());

			answerUserInfo.setAnswerCount(count);

			answerUserInfo.setType(userBasicInfo.getUcUserinfo().getType());
			
			answerUserInfo.setMomentNum(momentNum);

			UcAttentionInfo attendInfo = null;

			if (StringUtils.isNotEmpty(input.getZoo().getToken())) {

				attendUserCode = new UserCallFactory().upUserCodeByAuthToken(input.getZoo().getToken(),
						DefineUser.Login_System_Default);

				attendInfo = userServiceFactory.getAttentionInfoService().queryByBothCode(attendUserCode,
						input.getUserCode(), UserEnum.ATTEND.getCode());

			}

			if (attendInfo != null) {

				answerUserInfo.setAttendFlag(attendInfo.getStatus());

			} else {

				answerUserInfo.setAttendFlag(UserEnum.UN_ATTEND.getCode());

			}
			
			PageInfo questionPageInfo = new PageInfo(count, input.getPagination(), 20);
			
			result.getUserQuestionTabInfo().setNextflag(questionPageInfo.hasNext());
			
			PageInfo contentPageInfo = new PageInfo(momentNum, input.getPagination(), 20);
			
			result.getUserContentTabInfo().setNextflag(contentPageInfo.hasNext());
			
			if(StringUtils.isNotBlank(input.getType())){
				
				switch (input.getType()) {
				case "contentTab":
					result.getUserContentTabInfo().setContentInfos(convertMoment(input.getUserCode(), input.getPagination()));
					break;
				case "questionTab":
					result.getUserQuestionTabInfo().setQuestionInfos(convertQuestionInfo(input.getPagination(), input.getUserCode(), attendUserCode));
					break;

				default:
					result.getUserContentTabInfo().setContentInfos(convertMoment(input.getUserCode(), input.getPagination()));
					result.getUserQuestionTabInfo().setQuestionInfos(convertQuestionInfo(input.getPagination(), input.getUserCode(), attendUserCode));
					break;
				}
				
			}else{
				
				result.getUserContentTabInfo().setContentInfos(convertMoment(input.getUserCode(), input.getPagination()));
				
				result.getUserQuestionTabInfo().setQuestionInfos(convertQuestionInfo(input.getPagination(), input.getUserCode(), attendUserCode));
				
			}

			if (StringUtils.equals(input.getUserCode(), attendUserCode)) {

				result.setOwnFlag(true);

			}

			result.setAnswerUserInfo(answerUserInfo);
			
			result.setUserInfo(initUserInfo(input.getUserCode()));
			
			String contentCode = liveDetail(input.getUserCode());
			
			result.setLiveing(StringUtils.isNotEmpty(contentCode)?true:false);
			
			result.setLiveCode(contentCode);

		}
		
		return result;
	}
	
	/**
	 * 初始问题信息
	 * @param awQuestionInfos
	 * 		问答信息集合
	 * @return
	 */
	public List<QuestionInfo> convertQuestionInfo(int pagination,String userCode,String listenUserCode){
		
		int iStart = (pagination - 1) * 20;

		List<AwQuestionInfo> awQuestionInfos = answerServiceFactory.getQuestionInfoService().queryAnswerList(
				userCode, AnswerEnum.SCOPE_PUBLIC.getCode(), Constants.STATUS_ANSWERED, iStart, 20);
		
		List<QuestionInfo> questionInfos = new ArrayList<QuestionInfo>();
		
		awQuestionInfos.forEach(awQuestionInfo -> {
			
			QuestionInfo questionInfo = new QuestionInfo();
			
			BeanUtils.copyProperties(awQuestionInfo, questionInfo);
			
			questionInfo.setUserCode(awQuestionInfo.getQuestionUserCode());
			
			UserBasicInfo userBasicInfo = userInfoSupport.getUserBasicInfo(questionInfo.getUserCode());
			
			questionInfo.setAboutHead(userBasicInfo.getUcUserinfoExt().getAboutHead());
			
			questionInfo.setNickName(userBasicInfo.getUcUserinfoExt().getNickName());
			
			questionInfo.setType(userBasicInfo.getUcUserinfo().getType());
			
			questionInfo.setPraiseNum(awQuestionInfo.getLove());
			
			questionInfo.setSoundContent(QuestionSupport.soundContent(awQuestionInfo.getCode()));
			
			if(StringUtils.isNotEmpty(listenUserCode)){
				
				questionInfo.setListenFlag(new QuestionSupport().checkUserLitenTheQuestion(listenUserCode, awQuestionInfo.getCode()));
				
			}
			
			AcActivityAnswerInfo activityAnswerInfo = new AnswerActivitySupport().getActivityInfoByAnswerCode(awQuestionInfo.getCode());
			
			if(activityAnswerInfo != null){
				
				questionInfo.setActivityFlag(true);
				
			}
			
			questionInfos.add(questionInfo);
			
		});
		
		return questionInfos;
		
		
	}
	
	public List<ContentBasicinfoForApi> convertMoment(String userCode,int pagination){
		
		QueryConditions queryConditions = new QueryConditions();

		queryConditions.setConditionEqual("busiType", ContentEnum.sportmoment.getCode());
		
		queryConditions.setConditionEqual("status", "dzsd4699100110010001");

		queryConditions.setConditionEqual("author", userCode);
		
		queryConditions.setConditionEqual("shareScope", "dzsd4699100110010001");
		queryConditions.setConditionNotEqual("contentType", "dzsd4107100110030007");
		Page<CnContentBasicinfo> page = contentServiceFactory.getContentBasicinfoService()
				.queryPage(pagination, 10, queryConditions);

		List<CnContentBasicinfo> contentBasicInfos = page.getContent();

		List<ContentBasicinfoForApi> sports = new ArrayList<ContentBasicinfoForApi>();
		
		UcUserinfo ucUserinfo = userServiceFactory.getUserInfoService().queryByCode(userCode);
		
		UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(userCode);

		for (CnContentBasicinfo contentBasicInfo : contentBasicInfos) {

			ContentBasicinfoForApi sportingMoment = new ContentBasicinfoForApi();

			BeanUtils.copyProperties(contentBasicInfo, sportingMoment);

//			if(ucUserinfoExt != null){
//				
//				sportingMoment.getUserBasicInfo().setAboutHead(ucUserinfoExt.getAboutHead());
//				
//				sportingMoment.getUserBasicInfo().setNickName(ucUserinfoExt.getNickName());
//				
//			}
//			
//			if(ucUserinfo != null){
//				
//				sportingMoment.getUserBasicInfo().setType(ucUserinfo.getType());
//				
//				sportingMoment.getUserBasicInfo().setUserCode(userCode);
//				
//			}
			
			sportingMoment.setFavorFlag(ContentComponent.lightFavor(sportingMoment.getCode(), token));
			
//			sportingMoment.setReadNum(ContentComponent.readNum(sportingMoment.getCode()));
			
			sportingMoment.setRemarkNum(ContentComponent.remarkNum(sportingMoment.getCode()));
			
//			sportingMoment.setPraiseNum(ContentComponent.praiseNum(sportingMoment.getCode()));
			
			String title = sportingMoment.getTitle();
			
			title = StringUtils.isEmpty(title) ? "" : EmojiUtil.emojiRecovery(title);
			
			sportingMoment.setTitle(title);

			sports.add(sportingMoment);

		}
		
		return sports;
		
	}
	
	public UserInfo initUserInfo(String userCode) {

		UcUserinfoExt userInfoExt = userInfoSupport.getUserInfoExt(userCode);

		UserInfo apiUserInfo = new UserInfo();

		UcUserinfo ucUserinfo = userInfoSupport.getUserInfo(userCode);

		if (userInfoExt != null) {

			BeanUtils.copyProperties(userInfoExt, apiUserInfo);
			
			String sourceUrl = "";
			
			if(StringUtils.isNotEmpty(userInfoExt.getAboutHead())){
				
				sourceUrl = ImageHelper.upSourceUrl(userInfoExt.getAboutHead());
				
			}
			
			apiUserInfo.setSourceHeadUrl(sourceUrl);

			if (apiUserInfo != null && StringUtils.isNotEmpty(apiUserInfo.getAboutTag())) {

				List<String> codes = Arrays.asList(StringUtils.split(apiUserInfo.getAboutTag(), ","));

				if (!codes.isEmpty()) {

					List<String> sportCategories = contentServiceFactory.getSportCategoryService()
							.queryListByCodeIn(codes);

					apiUserInfo.setAboutTagName(convertCatoryNames(sportCategories));

				}

			}

		} 

		apiUserInfo.setType(ucUserinfo.getType());
		
		initFansNum(apiUserInfo);
		
		return apiUserInfo;

	}	
	
	/**
	 * 转换分类名称
	 * @param sportCategories
	 * 		根据分类集合获取分类名称
	 * @return 分类名称
	 */
	public String convertCatoryNames(List<String> sportCategories){
		
		return StringUtils.join(sportCategories,",");
		
	}
	
	/**
	 * 初始化粉丝和关注数量
	 * @param userInfo
	 */
	public void initFansNum(UserInfo userInfo){
		
		int fansNum = userServiceFactory.getAttentionInfoService().queryFansCount(userInfo.getUserCode(), UserEnum.ATTEND.getCode());
		
		int attendNum = userServiceFactory.getAttentionInfoService().queryAttendCount(userInfo.getUserCode(), UserEnum.ATTEND.getCode());
		
		int favorNum = contentServiceFactory.getSupportPraiseService().favored(ContentEnum.FAVOR_TYPE_LIKE.getCode(), userInfo.getUserCode());
		
		userInfo.setFansNum(fansNum);
		
		userInfo.setAttendNum(attendNum);
		
		userInfo.setFavorNum(favorNum);
		
	}
	
	public String liveDetail(String userCode){
		
		String contentCode  = "";
		
		MDataMap mWhereMap = new MDataMap();
		
		mWhereMap.put("userCode", userCode);
		
		mWhereMap.put("status", ContentEnum.LIVEING.getCode());
		
		CnLiveVideoDetail detail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "", "-zc", "", mWhereMap);
		
		if(detail != null){
			
			contentCode = detail.getContentCode();
			
		}
		
		
		return contentCode;
		
		
	}

}
