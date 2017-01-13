package com.uhutu.sportcenter.z.api.match;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnMatchInfo;
import com.uhutu.dcom.content.z.entity.CnMatchLink;
import com.uhutu.dcom.content.z.entity.CnMatchSign;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.sportcenter.z.api.util.MatchComponent;
import com.uhutu.sportcenter.z.entity.MatchInfo;
import com.uhutu.sportcenter.z.input.ApiShareMatchInfoInput;
import com.uhutu.sportcenter.z.result.ApiShareMatchInfoResult;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
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
			
			initMatchSign(input.getMatchCode(), shareMatchInfoResult);
			
			String buttonName = buttonName(input.getMatchCode(), shareMatchInfoResult.getSignUrl());
			
			shareMatchInfoResult.setButtonName(buttonName);
			
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
	
	public void initMatchSign(String matchCode,ApiShareMatchInfoResult result){
		
		MDataMap mWhereMap = new MDataMap();
		
		mWhereMap.put("matchCode", matchCode);
		
		mWhereMap.put("status", ContentEnum.MATCH_PUB.getCode());
		
		List<CnMatchSign> matchSigns = JdbcHelper.queryForList(CnMatchSign.class, "", "zc desc,sort desc", "", mWhereMap);
		
		if(matchSigns.size() == 0){
			
			result.setSignUrl("");
			
		}
		
		if(matchSigns.size() == 1){
			
			CnMatchSign cnMatchSign = matchSigns.get(0);
			
			if(cnMatchSign != null){
				
				String url = TopHelper.upInfo(810710028, cnMatchSign.getSignCode());
				
				result.setRedirectFlag(true);
				
				result.setSignUrl(url);
				
			}
			
			
		}
		
		if(matchSigns.size() > 1){
			
			String url = TopHelper.upInfo(810710027, matchCode);
			
			result.setRedirectFlag(false);
			
			result.setSignUrl(url);
			
		}		
		
	}
	
	public String buttonName(String matchCode, String signUrl){
		
		String buttonName = "";
		
		if(StringUtils.isNotEmpty(signUrl)){
			
			buttonName = "我要报名";
			
		}else{
			
			CnMatchLink matchLink = JdbcHelper.queryOne(CnMatchLink.class, "matchCode",matchCode,"status",ContentEnum.MATCH_PUB.getCode());
			
			if(matchLink != null){
				
				buttonName = matchLink.getTitle();
				
			}
			
			
		}
		
		return buttonName;
		
	}

	

}
