package com.uhutu.sportcenter.z.api.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.component.z.util.WebClientComponent;
import com.uhutu.dcom.pay.z.entity.PaInclogInfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.properties.SettingsDcomUser;
import com.uhutu.dcom.user.z.support.TecentSigSupport;
import com.uhutu.sportcenter.z.entity.TecentUserInfo;
import com.uhutu.sportcenter.z.input.ApiForTecentSigInput;
import com.uhutu.sportcenter.z.result.ApiForTecentSigResult;
import com.uhutu.zoocom.helper.GsonHelper;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/***
 * 获取腾讯独立登录模式sig信息
 * 
 * @author xiegj
 */
@Service
public class ApiForTecentSig extends RootApiToken<ApiForTecentSigInput, ApiForTecentSigResult> {
	
	@Autowired
	private SettingsDcomUser settingsDcomUser;


	public ApiForTecentSigResult process(ApiForTecentSigInput inputParam) {
		
		ApiForTecentSigResult result = new ApiForTecentSigResult();
		
		syncLiveUserInfo(upUserCode(), result);
		
		if(result.upFlagTrue()){
			
			result.setSig(new TecentSigSupport().upSigCodeByUserCode(upUserCode()));
			
		}		
		
		return result;

	}
	
	public void syncLiveUserInfo(String userCode, ApiForTecentSigResult result) {

		TecentSigSupport tecentSigSupport = new TecentSigSupport();
		
		UcUserinfoExt userInfoExt = JdbcHelper.queryOne(UcUserinfoExt.class, "userCode",userCode);

		if (userInfoExt != null) {

			String userSig = tecentSigSupport.upSigCodeByUserCode("godoadmin");

			String url = "https://console.tim.qq.com/v4/im_open_login_svc/account_import?usersig=" + userSig + "&identifier="
					+ settingsDcomUser.getTlsTecentAdmin() + "&sdkappid=" + settingsDcomUser.getTlsSkdAppid()
					+ "&random=99999999&contenttype=json";

			TecentUserInfo tecentUserInfo = new TecentUserInfo();
			
			tecentUserInfo.setFaceUrl(userInfoExt.getAboutHead());
			
			tecentUserInfo.setIdentifier(userInfoExt.getUserCode());
			
			tecentUserInfo.setNick(userInfoExt.getNickName());

			String jsonStr = GsonHelper.toJson(tecentUserInfo);

			PaInclogInfo paInclogInfo = new PaInclogInfo();

			try {

				String returnStr = WebClientComponent.upRequest(url, jsonStr);

				result.setError(returnStr);

				paInclogInfo.setResponseData(returnStr);
				
				String temp = EmojiUtil.emojiFilter(jsonStr);
				
				paInclogInfo.setRequestData(temp);

			} catch (Exception e) {

				String error = result.getError() + userInfoExt.getUserCode() + ":" + e.getMessage() + " ";

				result.setError(error);
				
				result.setStatus(0);

				paInclogInfo.setResponseData(error);

			}

			paInclogInfo.setBusiCode(userInfoExt.getUserCode());

			paInclogInfo.setIncType("SYNC_LIVE_USER");

			paInclogInfo.setZc(new Date());

			JdbcHelper.insert(paInclogInfo);

		}

	}
	
	
	
}
