package com.uhutu.sportcenter.z.api.live;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.component.z.util.WebClientComponent;
import com.uhutu.dcom.pay.z.entity.PaInclogInfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.properties.SettingsDcomUser;
import com.uhutu.dcom.user.z.support.TecentSigSupport;
import com.uhutu.sportcenter.z.entity.TecentUserInfo;
import com.uhutu.sportcenter.z.input.ApiSyncLiveUserInfoInput;
import com.uhutu.sportcenter.z.result.ApiSyncLiveUserInfoResult;
import com.uhutu.zoocom.helper.GsonHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;

import io.swagger.annotations.ApiModel;

@Component
@ApiModel
public class ApiSyncLiveUserInfo extends RootApiBase<ApiSyncLiveUserInfoInput, ApiSyncLiveUserInfoResult> {
	
	@Autowired
	private SettingsDcomUser settingsDcomUser;

	@Override
	protected ApiSyncLiveUserInfoResult process(ApiSyncLiveUserInfoInput input) {
		
		ApiSyncLiveUserInfoResult result = new ApiSyncLiveUserInfoResult();
		
		if(StringUtils.isNotEmpty(input.getUserCodes())){
			
			String[] sValues = StringUtils.split(input.getUserCodes(), ",");
			
			List<UcUserinfoExt> userInfoExts = JdbcHelper.queryForIn(UcUserinfoExt.class, "user_code", sValues);
			
			syncLiveUserInfo(userInfoExts, result);
			
		}else{
			
			List<UcUserinfoExt> userInfoExts = JdbcHelper.queryForList(UcUserinfoExt.class, "userCode,nickName,aboutHead", "zc ASC", " exists (select 1 from uc_userinfo where mj_flag = 'dzsd4699100110010002' and code = user_code)", new MDataMap());
		
			syncLiveUserInfo(userInfoExts, result);
		
		}
		
		return result;
		
	}
	
	public void syncLiveUserInfo(List<UcUserinfoExt> userInfoExts,ApiSyncLiveUserInfoResult result){
		
		if(userInfoExts != null){
			
			TecentSigSupport tecentSigSupport = new TecentSigSupport();
			
			userInfoExts.forEach(userInfoExt ->{
				
				if(userInfoExt != null){
					
					String userSig = tecentSigSupport.upSigCodeByUserCode("godoadmin");
					
					String url = "https://console.tim.qq.com/v4/im_open_login_svc/account_import?usersig="+userSig+"&identifier="+settingsDcomUser.getTlsTecentAdmin()+"&sdkappid="+settingsDcomUser.getTlsSkdAppid()+"&random=99999999&contenttype=json";
					
					TecentUserInfo tecentUserInfo = new TecentUserInfo();
					
					tecentUserInfo.setFaceUrl(userInfoExt.getAboutHead());
					
					tecentUserInfo.setIdentifier(userInfoExt.getUserCode());
					
					String nickName = userInfoExt.getNickName();
					
					if(StringUtils.isNotEmpty(nickName)){
						
						nickName = EmojiUtil.emojiRecovery(nickName);
						
					}
					
					tecentUserInfo.setNick(nickName);

					String jsonStr = GsonHelper.toJson(tecentUserInfo);
					
					PaInclogInfo paInclogInfo = new PaInclogInfo();
					
					try {
						
						String returnStr =  WebClientComponent.upRequest(url, jsonStr);
						
						result.setError(returnStr);
						
						paInclogInfo.setResponseData(returnStr);
						
						paInclogInfo.setRequestData(jsonStr);
						
						
					} catch (Exception e) {
						
						String error = result.getError()+ userInfoExt.getUserCode()+":" + e.getMessage() +" ";
						
						result.setError(error);
						
						paInclogInfo.setResponseData(error);
						
					}
					
					
					
					paInclogInfo.setBusiCode(userInfoExt.getUserCode());
					
					paInclogInfo.setIncType("SYNC_LIVE_USER");
					
					paInclogInfo.setZc(new Date());
					
					JdbcHelper.insert(paInclogInfo);
					
					
				}
				
			});
			
		}
		
	}

}
