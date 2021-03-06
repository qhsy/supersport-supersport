package com.uhutu.sportcenter.z.api.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.user.z.entity.UcAttentionInfo;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.entity.UcUserinfoSocial;
import com.uhutu.dcom.user.z.enums.UserEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.entity.UserInfo;
import com.uhutu.sportcenter.z.input.ApiUserInfoInput;
import com.uhutu.sportcenter.z.result.ApiUserInfoResult;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoocom.z.bean.TopUserFactory;
import com.uhutu.zooweb.user.UserCallFactory;

/**
 * 用户信息展示
 * 
 * @author pang_jhui
 *
 */
@Service
public class ApiUserInfo extends RootApiBase<ApiUserInfoInput, ApiUserInfoResult> {

	@Autowired
	private UserServiceFactory userServiceFactory;

	@Autowired
	private ContentServiceFactory serviceFactory;

	public ApiUserInfoResult process(ApiUserInfoInput inputParam) {
	
		String userCode = "";
		
		if(UserEnum.OPER_OWN.getCode().equals(inputParam.getOperFlag())){
			
			userCode = TopUserFactory.upUserCallFactory()
					.upUserCodeByAuthToken(inputParam.getZoo().getToken(), DefineUser.Login_System_Default);
			
		}
		
		if(UserEnum.OPER_OTHER.getCode().equals(inputParam.getOperFlag())){
			
			userCode = inputParam.getUserCode();
			
		}		

		ApiUserInfoResult userInfoResult = new ApiUserInfoResult();

		UserInfo apiUserInfo = new UserInfo();

		UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(userCode);
		
		UcUserinfo ucUserinfo = userServiceFactory.getUserInfoService().queryByCode(userCode);

		if (inputParam.getPagination() <= 1) {		

			if (ucUserinfoExt == null) {

				userInfoResult.setStatus(0);

				userInfoResult.setError("用户信息不存在");

				return userInfoResult;

			} else {

				BeanUtils.copyProperties(ucUserinfoExt, apiUserInfo);
				
				if(apiUserInfo != null && StringUtils.isNotEmpty(apiUserInfo.getAboutTag())){
					
					List<String> codes = Arrays.asList(StringUtils.split(apiUserInfo.getAboutTag(), ","));
					
					if(!codes.isEmpty()){
						
						List<String> sportCategories = serviceFactory.getSportCategoryService().queryListByCodeIn(codes);
						
						apiUserInfo.setAboutTagName(convertCatoryNames(sportCategories));
						
					}
					
				}

			}

		}

		QueryConditions queryConditions = new QueryConditions();

		queryConditions.setConditionEqual("busiType", ContentEnum.sportmoment.getCode());
		
		queryConditions.setConditionEqual("status", "dzsd4699100110010001");

		queryConditions.setConditionEqual("author", userCode);

		Page<CnContentBasicinfo> page = serviceFactory.getContentBasicinfoService()
				.queryPage(inputParam.getPagination(), 10, queryConditions);

		List<CnContentBasicinfo> contentBasicInfos = page.getContent();

		List<ContentBasicinfoForApi> sports = new ArrayList<ContentBasicinfoForApi>();

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
			
			String title = sportingMoment.getTitle();
			
			title = StringUtils.isEmpty(title) ? "" : EmojiUtil.emojiRecovery(title);
			
			sportingMoment.setTitle(title);

			sports.add(sportingMoment);

		}

		userInfoResult.setMoments(sports);

		if (page.hasNext()) {

			userInfoResult.setNextPageFlag(true);

		} else {

			userInfoResult.setNextPageFlag(false);

		}

		Long tempVal = new Long(page.getTotalElements());

		initFansNum(apiUserInfo);
		
		/*初始化用户操作标识*/
		String socialFlag = initSocialFlag(userCode);
		
		apiUserInfo.setSocialFlag(socialFlag);
		
		if(ucUserinfo != null){
			
			apiUserInfo.setType(ucUserinfo.getType());
			
		}

		userInfoResult.setUserInfo(apiUserInfo);
		
		if(StringUtils.isNotBlank(inputParam.getZoo().getToken()) && StringUtils.isNotBlank(inputParam.getUserCode())){
			
			UserCallFactory userCallFactory = new UserCallFactory();
			
			String currUserCode = userCallFactory.upUserCodeByAuthToken(inputParam.getZoo().getToken(), DefineUser.Login_System_Default);
			
			UcAttentionInfo info = userServiceFactory.getAttentionInfoService()
					.queryByBothCode(currUserCode, inputParam.getUserCode(),UserEnum.ATTEND.getCode());
			
			if(info != null){
				
				userInfoResult.setFlag(info.getStatus());
				
			}
			
		}
		return userInfoResult;
	}
	
	/**
	 * 初始化粉丝和关注数量
	 * @param userInfo
	 */
	public void initFansNum(UserInfo userInfo){
		
		int fansNum = userServiceFactory.getAttentionInfoService().queryFansCount(userInfo.getUserCode(), UserEnum.ATTEND.getCode());
		
		int attendNum = userServiceFactory.getAttentionInfoService().queryAttendCount(userInfo.getUserCode(), UserEnum.ATTEND.getCode());
		
		int favorNum = serviceFactory.getSupportPraiseService().favored(ContentEnum.FAVOR_TYPE_LIKE.getCode(), userInfo.getUserCode());
		
		userInfo.setFansNum(fansNum);
		
		userInfo.setAttendNum(attendNum);
		
		userInfo.setFavorNum(favorNum);
		
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
	 * 初始化操作标识
	 * @param userCode
	 * 		用户编号
	 * @return 操作标识
	 */
	public String initSocialFlag(String userCode){
		
		String social = ""; 
		
		UcUserinfoSocial ucUserinfoSocial = userServiceFactory.getUserInfoSocialService().queryByUserCode(userCode);
		
		if(ucUserinfoSocial != null){
			
			social = ucUserinfoSocial.getAccountType();
			
		}else{
			
			social = UserEnum.OPER_CUSTOM.getCode();
			
		}
		
		return social;
		
	}
	
	

}
