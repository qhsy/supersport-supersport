package com.uhutu.sportcenter.z.api.match;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.content.z.entity.CnMatchInfo;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.sportcenter.z.api.util.MatchComponent;
import com.uhutu.sportcenter.z.entity.MatchInfo;
import com.uhutu.sportcenter.z.input.ApiMatchInfoListInput;
import com.uhutu.sportcenter.z.result.ApiMacthInfoListResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 赛事列表信息接口
 * @author 逄小帅
 *
 */
@Component
public class ApiMatchInfoList extends RootApiBase<ApiMatchInfoListInput, ApiMacthInfoListResult> {

	@Override
	protected ApiMacthInfoListResult process(ApiMatchInfoListInput input) {
		
		ApiMacthInfoListResult macthInfoListResult = new ApiMacthInfoListResult();
		
		MDataMap mWhereMap = new MDataMap();
		
		mWhereMap.put("status", ContentEnum.MATCH_PUB.getCode());
		
		int total = JdbcHelper.count(CnMatchInfo.class, "", mWhereMap);
		
		PageInfo pageInfo = new PageInfo(total, input.getPagination(), 10);
		
		macthInfoListResult.setNextPageFlag(pageInfo.hasNext());
		
		int iStart = (pageInfo.getPagination() - 1) * pageInfo.getPageNum();
		
		List<CnMatchInfo> matchInfos = JdbcHelper.queryForList(CnMatchInfo.class, "", "zc desc,sort desc", "", mWhereMap, iStart, pageInfo.getPageNum());
		
		matchInfos.forEach(cnMatchInfo -> {
			
			MatchInfo matchInfo = new MatchInfo();
			
			BeanUtils.copyProperties(cnMatchInfo, matchInfo);
			
			String flagName = MatchComponent.getInstance().initFlagName(matchInfo.getFlag());
			
			matchInfo.setFlagName(flagName);
			
			matchInfo.setUserBasicInfo(MatchComponent.getInstance().initBasicInfo(cnMatchInfo.getUserCode()));
			
			String coverSource = ImageHelper.upImageThumbnail(cnMatchInfo.getCover(), input.getWidth());
			
			matchInfo.setCover(coverSource);
			
			macthInfoListResult.getMatchInfos().add(matchInfo);
			
		});
		
		return macthInfoListResult;
	}
	
	
	
	

}
