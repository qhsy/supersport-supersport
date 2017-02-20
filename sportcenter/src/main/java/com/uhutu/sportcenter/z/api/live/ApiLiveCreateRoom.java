package com.uhutu.sportcenter.z.api.live;

import java.text.DecimalFormat;

import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnLiveVideoInfo;
import com.uhutu.dcom.content.z.support.LiveSupport;
import com.uhutu.sportcenter.z.input.ApiLiveCreateRoomInput;
import com.uhutu.sportcenter.z.result.ApiLiveCreateRoomResult;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 创建房间
 * 
 * @author xiegj
 *
 */
@Component
public class ApiLiveCreateRoom extends RootApiToken<ApiLiveCreateRoomInput, ApiLiveCreateRoomResult> {

	@Override
	protected ApiLiveCreateRoomResult process(ApiLiveCreateRoomInput input) {

		ApiLiveCreateRoomResult result = new ApiLiveCreateRoomResult();
		CnLiveVideoInfo info = JdbcHelper.queryOne(CnLiveVideoInfo.class, "user_code", upUserCode());
		if (info != null) {
			result.setCode(info.getCode());
		} else {
			int simpleNum = JdbcHelper.count(CnLiveVideoInfo.class, "", new MDataMap()) + 1;
			CnLiveVideoInfo videoInfo = new CnLiveVideoInfo();
			videoInfo.setCode(new DecimalFormat("10000000").format(simpleNum));
			videoInfo.setChatCode(videoInfo.getCode());
			videoInfo.setStatus("1");
			videoInfo.setCreateTime(DateHelper.upNow());
			videoInfo.setUserCode(upUserCode());
			JdbcHelper.insert(videoInfo);
			result.setCode(videoInfo.getCode());
		}
		
		String pushUrl = getLivePushUrl(result.getCode());
	
		result.setPushUrl(pushUrl);
		
		return result;

	}
	

	
	public String getLivePushUrl(String roomId){
		
		String bzid = "5294";
		
		String key = "0e5cdd97c4ae7a3f0c7497de7728ee78";
		
		String streamId = bzid+"_"+roomId;
		
		String txTime = LiveSupport.getInstance().getTxTime(2);
		
		String txScreat = LiveSupport.getInstance().getTxSecret(key, streamId, txTime);
		
		return TopHelper.upInfo(810710031, bzid,streamId,bzid,txScreat,txTime);
		
	}

}
