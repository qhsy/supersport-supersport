package com.uhutu.sportcenter.z.api.user;

import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.common.Constants;
import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.dcom.answer.z.entity.AwAnswerListen;
import com.uhutu.dcom.answer.z.entity.AwSettleAccount;
import com.uhutu.dcom.answer.z.service.AnswerServiceFactory;
import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.enums.UserEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.entity.AnswerUserInfo;
import com.uhutu.sportcenter.z.entity.UserInfo;
import com.uhutu.sportcenter.z.input.ApiUserInfoAllInput;
import com.uhutu.sportcenter.z.result.ApiUserInfoAllResult;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 所有用户信息
 * @author 逄小帅
 *
 */
@Component
public class ApiUserInfoAll extends RootApiToken<ApiUserInfoAllInput, ApiUserInfoAllResult> {
	
	@Autowired
	private AnswerServiceFactory answerServiceFactory;

	@Autowired
	private UserInfoSupport userInfoSupport;
	
	@Autowired
	private ContentServiceFactory contentServiceFactory;
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiUserInfoAllResult process(ApiUserInfoAllInput input) {

		ApiUserInfoAllResult result = new ApiUserInfoAllResult();

		AwAnswerExpert expert = answerServiceFactory.getAwAnswerExpertService().getByUserCode(upUserCode());

		AnswerUserInfo answerUserInfo = new AnswerUserInfo();

		if(expert != null){
			
			BeanUtils.copyProperties(expert, answerUserInfo);
			
		}else{
			
			answerUserInfo.setStatus(SystemEnum.NO.getCode());
			
		}

		UcUserinfoExt userInfoExt = userInfoSupport.getUserInfoExt(upUserCode());
		
		UserInfo apiUserInfo = new UserInfo();
		
		UcUserinfo ucUserinfo = userInfoSupport.getUserInfo(upUserCode());

		if (userInfoExt != null) {

			answerUserInfo.setNickName(userInfoExt.getNickName());

			answerUserInfo.setAboutHead(userInfoExt.getAboutHead());
			
			BeanUtils.copyProperties(userInfoExt, apiUserInfo);
			
			if(apiUserInfo != null && StringUtils.isNotEmpty(apiUserInfo.getAboutTag())){
				
				List<String> codes = Arrays.asList(StringUtils.split(apiUserInfo.getAboutTag(), ","));
				
				if(!codes.isEmpty()){
					
					List<String> sportCategories = contentServiceFactory.getSportCategoryService().queryListByCodeIn(codes);
					
					apiUserInfo.setAboutTagName(convertCatoryNames(sportCategories));
					
				}
				
			}

		} else {

			result.inError(88880005);

		}
		
		apiUserInfo.setType(ucUserinfo.getType());
		
		int momentNum = JdbcHelper.count(CnContentBasicinfo.class, "",
				MapHelper.initMap("busiType", ContentEnum.sportmoment.getCode(), "status",
						ContentEnum.normal.getCode(),"author",upUserCode()));

		apiUserInfo.setSportsNum(momentNum);
		
		AwSettleAccount settleAccount = answerServiceFactory.getSettleAccountService().queryByUserCode(upUserCode());
		
		if(settleAccount != null && StringUtils.equals(settleAccount.getStatus(), SystemEnum.YES.getCode())){
			
			answerUserInfo.setSettleFlag(true);
			
			answerUserInfo.setSettleAccountName(settleAccount.getAccountName());
			
		}
		
		int count = answerServiceFactory.getQuestionInfoService().queryAnswerCount(upUserCode(), Constants.STATUS_ANSWERED);
		
		answerUserInfo.setAnswerCount(count);
		
		int listenCount = JdbcHelper.count(AwAnswerListen.class, "questionCode in (select code from aw_question_info where answer_user_code='"+upUserCode()+"')", new MDataMap());
		
		initFansNum(apiUserInfo);
		
		answerUserInfo.setFansNum(listenCount);
		
		result.setUserInfo(apiUserInfo);

		result.setAnswerUserInfo(answerUserInfo);

		return result;

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

}
