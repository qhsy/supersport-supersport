package com.uhutu.sportcenter.z.api.user;

import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.sportcenter.z.entity.UserBasicInfo;
import com.uhutu.sportcenter.z.input.ApiInviteUserInfoInput;
import com.uhutu.sportcenter.z.result.ApiInviteUserInfoResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 邀请用户信息
 * @author 逄小帅
 *
 */
@Component
public class ApiInviteUserInfo extends RootApiToken<ApiInviteUserInfoInput, ApiInviteUserInfoResult> {

	@Override
	protected ApiInviteUserInfoResult process(ApiInviteUserInfoInput input) {
		
		ApiInviteUserInfoResult inviteUserResult = new ApiInviteUserInfoResult();
		
		UcUserinfoExt ucUserinfoExt = JdbcHelper.queryOne(UcUserinfoExt.class, "userCode",upUserCode());
		
		if(ucUserinfoExt != null){
			
			UserBasicInfo userBasicInfo = new UserBasicInfo();
			
			userBasicInfo.setAboutHead(ucUserinfoExt.getAboutHead());
			
			String nickName = EmojiUtil.emojiRecovery(ucUserinfoExt.getNickName());
			
			userBasicInfo.setNickName(nickName);
			
			userBasicInfo.setUserCode(ucUserinfoExt.getUserCode());
			
			inviteUserResult.setUserBasicInfo(userBasicInfo);
			
		}else{
			
			inviteUserResult.inError(81100003);
			
		}
		
		return inviteUserResult;
	}

}
