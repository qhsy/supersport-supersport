package com.uhutu.sportcenter.z.api.user;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.enums.MsgEnum;
import com.uhutu.dcom.user.z.enums.UserEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.api.util.PointSupport;
import com.uhutu.sportcenter.z.entity.UserInfo;
import com.uhutu.sportcenter.z.input.ApiUserInfoAllInput;
import com.uhutu.sportcenter.z.result.ApiUserInfoAllResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 所有用户信息
 * 
 * @author 逄小帅
 *
 */
@Component
public class ApiUserInfoAll extends RootApiToken<ApiUserInfoAllInput, ApiUserInfoAllResult> {

	@Autowired
	private UserInfoSupport userInfoSupport;

	@Autowired
	private ContentServiceFactory contentServiceFactory;

	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiUserInfoAllResult process(ApiUserInfoAllInput input) {

		ApiUserInfoAllResult result = new ApiUserInfoAllResult();

		UcUserinfoExt userInfoExt = userInfoSupport.getUserInfoExt(upUserCode());

		UserInfo apiUserInfo = new UserInfo();

		UcUserinfo ucUserinfo = userInfoSupport.getUserInfo(upUserCode());

		if (userInfoExt != null) {

			String sourceUrl = "";

			if (StringUtils.isNotEmpty(userInfoExt.getAboutHead())) {

				sourceUrl = ImageHelper.upSourceUrl(userInfoExt.getAboutHead());

			}

			BeanUtils.copyProperties(userInfoExt, apiUserInfo);

			apiUserInfo.setSourceHeadUrl(sourceUrl);
			apiUserInfo.setTitle(PointSupport.getLevelTitle(apiUserInfo.getUserCode()));
			if (apiUserInfo != null && StringUtils.isNotEmpty(apiUserInfo.getAboutTag())) {

				List<String> codes = Arrays.asList(StringUtils.split(apiUserInfo.getAboutTag(), ","));

				if (!codes.isEmpty()) {

					List<String> sportCategories = contentServiceFactory.getSportCategoryService()
							.queryListByCodeIn(codes);

					apiUserInfo.setAboutTagName(convertCatoryNames(sportCategories));

				}

			}

		} else {

			result.inError(88880005);

		}
		apiUserInfo.setType(ucUserinfo.getType());
		initFansNum(apiUserInfo);

		result.setUserInfo(apiUserInfo);

		return result;

	}

	/**
	 * 转换分类名称
	 * 
	 * @param sportCategories
	 *            根据分类集合获取分类名称
	 * @return 分类名称
	 */
	public String convertCatoryNames(List<String> sportCategories) {

		return StringUtils.join(sportCategories, ",");

	}

	/**
	 * 初始化粉丝和关注数量
	 * 
	 * @param userInfo
	 */
	public void initFansNum(UserInfo userInfo) {

		int fansNum = userServiceFactory.getAttentionInfoService().queryFansCount(userInfo.getUserCode(),
				UserEnum.ATTEND.getCode());

		int attendNum = userServiceFactory.getAttentionInfoService().queryAttendCount(userInfo.getUserCode(),
				UserEnum.ATTEND.getCode());

		int favorNum = contentServiceFactory.getSupportPraiseService().favored(ContentEnum.FAVOR_TYPE_LIKE.getCode(),
				userInfo.getUserCode());
		int msgNum = userServiceFactory.getMsgNoticeUserService().queryCount(userInfo.getUserCode(),
				MsgEnum.FLAG_UNREAD.getCode());

		userInfo.setMsgNum(msgNum);

		userInfo.setFansNum(fansNum);

		userInfo.setAttendNum(attendNum);

		userInfo.setFavorNum(favorNum);

	}

}
