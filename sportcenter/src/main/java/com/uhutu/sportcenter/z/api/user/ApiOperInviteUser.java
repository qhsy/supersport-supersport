package com.uhutu.sportcenter.z.api.user;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.input.ApiOperInviteUserInput;
import com.uhutu.sportcenter.z.result.ApiOperInviteUserResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 邀请用户相关操作
 * @author 逄小帅
 *
 */
@Component
public class ApiOperInviteUser extends RootApiToken<ApiOperInviteUserInput, ApiOperInviteUserResult> {
	
	@Autowired
	private UserInfoSupport userInfoSupport;

	@Override
	protected ApiOperInviteUserResult process(ApiOperInviteUserInput input) {
		
		ApiOperInviteUserResult inviteUserResult = new ApiOperInviteUserResult();
		
		String nickName = "";
		
		if(StringUtils.isNotEmpty(input.getNickName())){
			
			nickName = EmojiUtil.emojiFilter(input.getNickName());
			
		}else{
			
			inviteUserResult.setStatus(-1);
			
			inviteUserResult.setError("昵称不能为空");
			
		}
		
		if(inviteUserResult.upFlagTrue()){
			
			UcUserinfoExt userinfoExt = JdbcHelper.queryOne(UcUserinfoExt.class, "nickName",nickName);
			
			if(userinfoExt != null && !StringUtils.equals(userinfoExt.getUserCode(), upUserCode())){
				
				inviteUserResult.inError(81100001);
				
			}else{
				
				UcUserinfoExt ucUserinfoExt = JdbcHelper.queryOne(UcUserinfoExt.class, "userCode",upUserCode());
				
				if(ucUserinfoExt != null){
					
					String headUrl = input.getHeadUrl();
					
					if(!StringUtils.equals(headUrl, ucUserinfoExt.getAboutHead()) && !StringUtils.contains(headUrl, "gm")){
						
						headUrl = ImageHelper.upImageThumbnail(headUrl, 180);
						
					}
					
					ucUserinfoExt.setAboutHead(headUrl);
					
					ucUserinfoExt.setNickName(nickName);
					
					String returnStr = userInfoSupport.regUser(null, ucUserinfoExt, null);
					
					if(StringUtils.isNotEmpty(returnStr)){
						
						inviteUserResult.inError(81100021, returnStr);
						
					}
					
				}else{
					
					inviteUserResult.inError(81100003);
					
				}
				
			}
			
		}
		
		return inviteUserResult;
	}

}
