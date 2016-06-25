package com.uhutu.sportcenter.z.api.user;

import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.enums.UserEnum;
import com.uhutu.dcom.user.z.properties.ConfigDcomUser;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.dcom.user.z.support.TecentSigSupport;
import com.uhutu.dcom.user.z.tecent.base.TecentJoinBase;
import com.uhutu.dcom.user.z.tecent.entity.MsgBody;
import com.uhutu.dcom.user.z.tecent.entity.MsgInfo;
import com.uhutu.dcom.user.z.tecent.entity.TIMTextElem;
import com.uhutu.dcom.user.z.tecent.enumer.MsgTypeEnum;
import com.uhutu.dcom.user.z.tecent.result.TecentResult;
import com.uhutu.sportcenter.z.input.ApiForLoginInput;
import com.uhutu.sportcenter.z.result.ApiForLoginResult;
import com.uhutu.zoocom.define.DefineUser;
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
public class ApiForLogin extends RootApiBase<ApiForLoginInput, ApiForLoginResult> {

	@Autowired
	private UserServiceFactory userServiceFactory;

	public ApiForLoginResult process(ApiForLoginInput inputParam) {

		ApiForLoginResult result = new ApiForLoginResult();

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
			MsgInfo msgInfo = new MsgInfo();
			msgInfo.setTo_Account(result.getUserCode());
			MsgBody msgBody = new MsgBody();
			msgBody.setMsgType(MsgTypeEnum.TIMTextElem.name());
			TIMTextElem textElem = new TIMTextElem();
			textElem.setText("您家水表已被查,您的登录手机号为：" + ucUserinfo.getLoginName());
			msgBody.setMsgContent(textElem);
			msgInfo.getMsgBody()[0] = msgBody;
			TecentJoinBase base = new TecentJoinBase();
			TecentResult tecentResult = base.postTecent(ConfigDcomUser.upConfig().getLoginSdkSendmsg(), msgInfo);
			System.out.println(tecentResult.getActionStatus());
		}
		return result;

	}
}
