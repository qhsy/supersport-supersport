package com.uhutu.sportcenter.z.api.live;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.pay.z.util.MD5;
import com.uhutu.dcom.user.z.properties.SettingsDcomUser;
import com.uhutu.sportcenter.z.input.ApiLiveNotifyInput;
import com.uhutu.sportcenter.z.result.ApiLiveNotifyResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 直播消息通知
 * @author 逄小帅
 *
 */
@Component
public class ApiLiveNotify extends RootApiBase<ApiLiveNotifyInput, ApiLiveNotifyResult> {
	
	@Autowired
	private SettingsDcomUser settingsDcomUser;

	@Override
	protected ApiLiveNotifyResult process(ApiLiveNotifyInput input) {
		
		ApiLiveNotifyResult result = new ApiLiveNotifyResult();
		
		if(checkSign(input.getT(), input.getSign())){
			
			synchronized (ApiLiveNotify.class) {
				
				switch (input.getEvent_type()) {
				case 0:
					updateLiveStatus(input.getStream_id());
					break;
				case 1:
					
					break;
				case 100:
		
					break;
				case 200:
		
					break;

				default:
					break;
				}
				
			}
			
		}
		
		return result;
	}
	
	public void updateLiveStatus(String streamId){
		
		MDataMap mWhereMap = new MDataMap();
		
		mWhereMap.put("streamId", streamId);
		
		CnLiveVideoDetail videoDetail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "", "", "", mWhereMap);
		
		if(videoDetail != null){
			
			videoDetail.setStatus(ContentEnum.LIVEEND.getCode());
			
			JdbcHelper.update(videoDetail, "status", "za");
			
		}
		
	}
	
	public boolean checkSign(String timestamp,String sign){
		
		boolean flag = false;
		
		String checkSign = MD5.sign(settingsDcomUser.getLiveKey()+timestamp, "UTF-8");
		
		if(StringUtils.equals(sign, checkSign)){
			
			flag = true;
			
		}
		
		return flag;
		
	}

}
