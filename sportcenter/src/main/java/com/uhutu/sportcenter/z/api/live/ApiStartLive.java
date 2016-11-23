package com.uhutu.sportcenter.z.api.live;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.sportcenter.z.input.ApiStartLiveInput;
import com.uhutu.sportcenter.z.result.ApiStartLiveResult;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

import io.swagger.annotations.ApiModel;

/**
 * 开始直播
 * @author 逄小帅
 *
 */
@ApiModel
@Component
public class ApiStartLive extends RootApiToken<ApiStartLiveInput, ApiStartLiveResult> {

	@Override
	protected ApiStartLiveResult process(ApiStartLiveInput input) {
		
		ApiStartLiveResult startLiveResult = new ApiStartLiveResult();
		
		MDataMap mWhereMap = new MDataMap();
		
		mWhereMap.put("code", input.getCode());
		
		mWhereMap.put("chatCode", input.getChatCode());
		
		mWhereMap.put("status", ContentEnum.LIVEING.getCode());
		
		int count = JdbcHelper.count(CnLiveVideoDetail.class, "", mWhereMap);
		
		if(count > 0){
			
			startLiveResult.inError(-1, "此房间正在直播中");
			
		}else{
			
			CnLiveVideoDetail liveVideoDetail = new CnLiveVideoDetail();
			
			BeanUtils.copyProperties(input, liveVideoDetail);
			
			liveVideoDetail.setUserCode(upUserCode());
			
			liveVideoDetail.setStatus(ContentEnum.LIVEING.getCode());
			
			liveVideoDetail.setCreateTime(DateHelper.upDate(new Date()));
			
			JdbcHelper.insert(liveVideoDetail);
			
		}
		
		return startLiveResult;
	}

}
