package com.uhutu.sportcenter.z.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.entity.UserBasicInfo;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.face.RootUserToken;
import com.uhutu.sportcenter.z.input.ApiSetUserFavoerInput;
import com.uhutu.sportcenter.z.result.ApiSetUserFavorResult;

/**
 * 设置用户喜欢运动
 * 
 * @author pang_jhui
 *
 */
@Service
public class ApiSetUserFavor extends RootUserToken<ApiSetUserFavoerInput, ApiSetUserFavorResult> {

	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiSetUserFavorResult process(ApiSetUserFavoerInput input) {

		ApiSetUserFavorResult favorResult = new ApiSetUserFavorResult();

		UserBasicInfo userBasicInfo = getUserBasicInfo(input.getZoo().getToken());

		if (userBasicInfo.getUcUserinfoExt() == null) {

			favorResult.setStatus(0);

			favorResult.setError("用户信息不存在");

			return favorResult;

		} else {

			userBasicInfo.getUcUserinfoExt().setAboutTag(input.getCatagoryCodes());

			userServiceFactory.getUserInfoExtService().save(userBasicInfo.getUcUserinfoExt());

		}

		return favorResult;
	}

}
