package com.uhutu.sportcenter.z.api.match;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.content.z.entity.CnMatchInfo;
import com.uhutu.sportcenter.z.api.util.MatchComponent;
import com.uhutu.sportcenter.z.entity.MatchInfo;
import com.uhutu.sportcenter.z.input.ApiShareMatchInfoInput;
import com.uhutu.sportcenter.z.result.ApiShareMatchInfoResult;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 赛事详情
 * @author 逄小帅
 *
 */
@Component
public class ApiShareMatchInfo extends RootApiBase<ApiShareMatchInfoInput, ApiShareMatchInfoResult> {

	@Override
	protected ApiShareMatchInfoResult process(ApiShareMatchInfoInput input) {
		
		ApiShareMatchInfoResult shareMatchInfoResult = new ApiShareMatchInfoResult();
		
		CnMatchInfo cnMatchInfo = JdbcHelper.queryOne(CnMatchInfo.class, "code",input.getMatchCode());
		
		if(cnMatchInfo != null){
			
			MatchInfo matchInfo = initMatchInfo(cnMatchInfo, input.getZoo().getToken(), input.getWidth(), input.getDetailWidth());
			
			shareMatchInfoResult.setMatchInfo(matchInfo);
			
		}else{
			
			shareMatchInfoResult.setError("相关赛事信息不存在");
			
			shareMatchInfoResult.setStatus(-1);
			
		}
		
		return shareMatchInfoResult;
		
	}
	
	public MatchInfo initMatchInfo(CnMatchInfo cnMatchInfo,String token,int coverWidth,int detaiWidth){
		
		MatchInfo matchInfo = new MatchInfo();
		
		BeanUtils.copyProperties(cnMatchInfo, matchInfo);
		
		String flagName = MatchComponent.getInstance().initFlagName(matchInfo.getFlag());
		
		matchInfo.setFlagName(flagName);
		
		matchInfo.setUserBasicInfo(MatchComponent.getInstance().initBasicInfo(cnMatchInfo.getUserCode()));
		
		String coverSource = ImageHelper.upImageThumbnail(cnMatchInfo.getCover(), coverWidth);
		
		matchInfo.setCover(coverSource);
		
		matchInfo.setDetails(MatchComponent.getInstance().initDetails(cnMatchInfo.getContent(), detaiWidth));
		
		return matchInfo;
		
	}

	

}
