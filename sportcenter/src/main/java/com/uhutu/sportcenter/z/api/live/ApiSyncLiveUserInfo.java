package com.uhutu.sportcenter.z.api.live;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.util.WebClientComponent;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.properties.SettingsDcomUser;
import com.uhutu.sportcenter.z.entity.SyncLiveProfileItem;
import com.uhutu.sportcenter.z.entity.SyncLiveUserBody;
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
			
			List<UcUserinfoExt> userInfoExts = JdbcHelper.queryForList(UcUserinfoExt.class, "userCode,nickName,aboutHead", "", " exists (select 1 from uc_userinfo where mj_flag = 'dzsd4699100110010002' and code = user_code)", new MDataMap());
		
			syncLiveUserInfo(userInfoExts, result);
		
		}
		
		return result;
		
	}
	
	public void syncLiveUserInfo(List<UcUserinfoExt> userInfoExts,ApiSyncLiveUserInfoResult result){
		
		if(userInfoExts != null){
			
			userInfoExts.forEach(userInfoExt ->{
				
				if(userInfoExt != null){
					
					String url = "https://console.tim.qq.com/v4/profile/portrait_set?usersig="+settingsDcomUser.getTlsPrivateKey()+"&identifier="+settingsDcomUser.getTlsTecentAdmin()+"&sdkappid="+settingsDcomUser.getTlsSkdAppid()+"&random=99999999&contenttype=json";
					
					SyncLiveProfileItem nickNameItem = new SyncLiveProfileItem();
					
					nickNameItem.setTag("Tag_Profile_IM_Nick");
					
					nickNameItem.setValue(userInfoExt.getNickName());
					
					SyncLiveProfileItem headItem = new SyncLiveProfileItem();
					
					headItem.setTag("Tag_Profile_IM_Image");
					
					headItem.setValue(userInfoExt.getAboutHead());
					
					SyncLiveUserBody liveUserBody = new SyncLiveUserBody();
					
					liveUserBody.setFrom_Account(userInfoExt.getUserCode());
					
					liveUserBody.getProfileItem().add(nickNameItem);
					
					liveUserBody.getProfileItem().add(headItem);
					
					String jsonStr = GsonHelper.toJson(liveUserBody);
					
					try {
						
						String returnStr =  WebClientComponent.upRequest(url, jsonStr);
						
						result.setError(returnStr);
						
						
					} catch (Exception e) {
						
						String error = result.getError()+ userInfoExt.getUserCode()+":" + e.getMessage() +" ";
						
						result.setError(error);
						
					}
					
				}
				
			});
			
		}
		
	}

}