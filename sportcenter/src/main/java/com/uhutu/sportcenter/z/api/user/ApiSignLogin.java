package com.uhutu.sportcenter.z.api.user;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.enums.UserEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.dcom.user.z.support.TecentSigSupport;
import com.uhutu.sportcenter.z.input.ApiSignLoginInput;
import com.uhutu.sportcenter.z.result.ApiSignLoginResult;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.helper.SecrurityHelper;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zooweb.user.UserCallFactory;
import com.uhutu.zooweb.user.UserLoginInput;
import com.uhutu.zooweb.user.UserLoginResult;

/***
 * 登录
 * 
 * @author xiegj *
 */
@Service
public class ApiSignLogin extends RootApiBase<ApiSignLoginInput, ApiSignLoginResult> {

	@Autowired
	private UserServiceFactory userServiceFactory;

	public ApiSignLoginResult process(ApiSignLoginInput inputParam) {

		ApiSignLoginResult result = new ApiSignLoginResult();
		
		if(StringUtils.isBlank(inputParam.getNoneStr())){
			
			result.inError(81100013);
			
			return result;
			
		}
		
		if(StringUtils.isBlank(inputParam.getSign())){
			
			result.inError(81100014);
			
			return result;
			
		}
		
		String signKey = inputParam.getNoneStr() + TopHelper.upInfo(81100016);
		
		String sign = SecrurityHelper.MD5(signKey);
		
		if (StringUtils.equals(sign, inputParam.getSign())) {

			UcUserinfo ucUserinfo = userServiceFactory.getUserInfoService().queryByLoginName(inputParam.getLoginName(),
					UserEnum.FLAG_ENABLE.getCode());

			if (ucUserinfo != null) {

				ucUserinfo.setLastTime(new Date());

				userServiceFactory.getUserInfoService().save(ucUserinfo);

				UserCallFactory userCallFactory = new UserCallFactory();

				UserLoginInput loginInput = new UserLoginInput();

				loginInput.setLoginName(inputParam.getLoginName());

				loginInput.setLoginPass(inputParam.getLoginPass());

				loginInput.setLoginSystem(DefineUser.Login_System_Default);

				UserLoginResult loginResult = userCallFactory.userLogin(loginInput);

				if (loginResult.upFlagTrue()) {

					result.setUserToken(loginResult.getToken());

					result.setUserCode(ucUserinfo.getCode());

				} else {

					result.setError(loginResult.getError());

					result.setStatus(loginResult.getStatus());

				}

			} else {

				result.inError(81100003);

			}
			if (StringUtils.isNotBlank(result.getUserCode())) {

				result.setSig(new TecentSigSupport().upSigCodeByUserCode(result.getUserCode()));

			}

		}else{
			
			result.inError(81100015);
			
		}
		
		return result;

	}
}
