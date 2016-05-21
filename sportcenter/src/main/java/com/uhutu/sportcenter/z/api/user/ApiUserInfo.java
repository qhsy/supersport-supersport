package com.uhutu.sportcenter.z.api.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentBasicinfoServiceFactory;
import com.uhutu.dcom.user.z.entity.UcAttentionInfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.enums.MsgEnum;
import com.uhutu.dcom.user.z.enums.UserEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.entity.UserInfo;
import com.uhutu.sportcenter.z.input.ApiUserInfoInput;
import com.uhutu.sportcenter.z.result.ApiUserInfoResult;
import com.uhutu.zoocom.root.RootApiBase;

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
	private ContentBasicinfoServiceFactory serviceFactory;

	public ApiUserInfoResult process(ApiUserInfoInput inputParam) {
		
		String userCode = "";
		
		if(UserEnum.OPER_OWN.getCode().equals(inputParam.getOperFlag())){
			
			userCode = inputParam.getZoo().getToken().trim();
			
		}
		
		if(UserEnum.OPER_OTHER.getCode().equals(inputParam.getOperFlag())){
			
			userCode = inputParam.getUserCode();
			
		}		

		ApiUserInfoResult userInfoResult = new ApiUserInfoResult();

		UserInfo apiUserInfo = new UserInfo();

		UcUserinfoExt ucUserinfoExt = new UcUserinfoExt();

		if (inputParam.getPagination() <= 1) {

			ucUserinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(userCode);

			if (ucUserinfoExt == null) {

				userInfoResult.setStatus(0);

				userInfoResult.setError("用户信息不存在");

				return userInfoResult;

			} else {

				BeanUtils.copyProperties(ucUserinfoExt, apiUserInfo);

			}

		}

		QueryConditions queryConditions = new QueryConditions();

		queryConditions.setConditionEqual("busiType", ContentEnum.sportmoment.getCode());

		queryConditions.setConditionEqual("author", userCode);

		Page<CnContentBasicinfo> page = serviceFactory.getContentBasicinfoService()
				.queryPage(inputParam.getPagination(), 10, queryConditions);

		List<CnContentBasicinfo> contentBasicInfos = page.getContent();

		List<ContentBasicinfoForApi> sports = new ArrayList<ContentBasicinfoForApi>();

		for (CnContentBasicinfo contentBasicInfo : contentBasicInfos) {

			ContentBasicinfoForApi sportingMoment = new ContentBasicinfoForApi();

			BeanUtils.copyProperties(contentBasicInfo, sportingMoment);

			sportingMoment.setAboutHead(ucUserinfoExt.getAboutHead());

			sportingMoment.setNickName(ucUserinfoExt.getNickName());

			sports.add(sportingMoment);

		}

		userInfoResult.setMoments(sports);

		if (page.hasNext()) {

			userInfoResult.setNextPageFlag(true);

		} else {

			userInfoResult.setNextPageFlag(false);

		}

		Long tempVal = new Long(page.getTotalElements());

		apiUserInfo.setSportsNum(tempVal.intValue());
		
		initFansNum(apiUserInfo);

		userInfoResult.setUserInfo(apiUserInfo);
		
		if(!inputParam.getZoo().getToken().trim().equals(inputParam.getUserCode())){
			UcAttentionInfo info = userServiceFactory.getAttentionInfoService()
					.queryByBothCode(inputParam.getZoo().getToken().trim(), inputParam.getUserCode());
			
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
		
		int fansNum = userServiceFactory.getAttentionInfoService().queryFansCount(userInfo.getUserCode(), MsgEnum.ATTEND.getCode());
		
		int attendNum = userServiceFactory.getAttentionInfoService().queryAttendCount(userInfo.getUserCode(), MsgEnum.ATTEND.getCode());
		
		userInfo.setFansNum(fansNum);
		
		userInfo.setAttendNum(attendNum);
		
	}

}
