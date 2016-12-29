package com.uhutu.sportcenter.z.api.user;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.sportcenter.z.input.ApiVerifyNickNameInput;
import com.uhutu.sportcenter.z.result.ApiVerifyNickNameResult;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoocom.z.bean.TopUserFactory;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 昵称校验
 * 
 * @author 逄小帅
 *
 */
@Component
public class ApiVerifyNickName extends RootApiBase<ApiVerifyNickNameInput, ApiVerifyNickNameResult> {

	@Override
	protected ApiVerifyNickNameResult process(ApiVerifyNickNameInput input) {

		ApiVerifyNickNameResult result = new ApiVerifyNickNameResult();
		String userCode = TopUserFactory.upUserCallFactory().upUserCodeByAuthToken(input.getZoo().getToken(),
				DefineUser.Login_System_Default);
		UcUserinfoExt ucUserinfoExt = JdbcHelper.queryOne(UcUserinfoExt.class, "", "",
				"nick_name=:nickName and user_code!=:userCode ",
				MapHelper.initMap("nickName",
						StringUtils.isEmpty(input.getNickName()) ? "" : EmojiUtil.emojiRecovery(input.getNickName()),
						"userCode", userCode));

		if (ucUserinfoExt != null) {
			result.inError(81100001);
		}

		return result;
	}

}
