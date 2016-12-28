package com.uhutu.sportcenter.z.api.match;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnMatchInfo;
import com.uhutu.dcom.content.z.entity.CnMatchSign;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.extend.z.entity.ReReportInfo;
import com.uhutu.sportcenter.z.entity.MatchSignInfo;
import com.uhutu.sportcenter.z.input.ApiMatchSignListInput;
import com.uhutu.sportcenter.z.result.ApiMatchSignListResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 赛事报名信息列表
 * @author 逄小帅
 *
 */
@Component
public class ApiMatchSignList extends RootApiBase<ApiMatchSignListInput, ApiMatchSignListResult> {

	@Override
	protected ApiMatchSignListResult process(ApiMatchSignListInput input) {
		
		ApiMatchSignListResult matchSignListResult = new ApiMatchSignListResult();
		
		CnMatchInfo cnMatchInfo = JdbcHelper.queryOne(CnMatchInfo.class, "code",input.getMatchCode());
		
		if(cnMatchInfo != null){
			
			matchSignListResult.setMatchCode(cnMatchInfo.getCode());
			
			matchSignListResult.setMatchName(cnMatchInfo.getName());
			
			matchSignListResult.setMatchSignInfos(initSignInfo(cnMatchInfo.getCode()));
			
		}else{
			
			matchSignListResult.setError("相关赛事信息不存在");
			
			matchSignListResult.setStatus(-1);
			
		}
		
		return matchSignListResult;
	}
	
	public List<MatchSignInfo> initSignInfo(String matchCode){
		
		MDataMap mWhereMap = new MDataMap();
		
		mWhereMap.put("matchCode", matchCode);
		
		mWhereMap.put("status", ContentEnum.MATCH_PUB.getCode());
		
		List<CnMatchSign> cnMatchSigns = JdbcHelper.queryForList(CnMatchSign.class, "", "zc desc,sort desc", "", mWhereMap);
		
		List<MatchSignInfo> matchSignInfos = new ArrayList<MatchSignInfo>();
		
		cnMatchSigns.forEach(cnMatchSign -> {
			
			MatchSignInfo matchSignInfo = new MatchSignInfo();
			
			ReReportInfo reportInfo = JdbcHelper.queryOne(ReReportInfo.class, "code",cnMatchSign.getSignCode());
			
			if(reportInfo != null){
				
				matchSignInfo.setSignCode(reportInfo.getCode());
				
				matchSignInfo.setSignPrice(reportInfo.getOrderMoney().setScale(2).toString());
				
				matchSignInfo.setTitle(reportInfo.getTitle());
				
				matchSignInfos.add(matchSignInfo);
				
			}
			
		});
		
		return matchSignInfos;
		
		
	}

}
