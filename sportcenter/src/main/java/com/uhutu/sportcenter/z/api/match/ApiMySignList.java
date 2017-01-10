package com.uhutu.sportcenter.z.api.match;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.content.z.entity.CnMatchInfo;
import com.uhutu.dcom.content.z.entity.CnMatchSign;
import com.uhutu.dcom.extend.z.entity.ReReportInfo;
import com.uhutu.dcom.extend.z.entity.ReReportJson;
import com.uhutu.sportcenter.z.entity.MySignInfo;
import com.uhutu.sportcenter.z.input.ApiMySignListInput;
import com.uhutu.sportcenter.z.result.ApiMySignListResult;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 我的报名信息列表
 * @author 逄小帅
 *
 */
@Component
public class ApiMySignList extends RootApiToken<ApiMySignListInput, ApiMySignListResult> {

	@Override
	protected ApiMySignListResult process(ApiMySignListInput input) {

		ApiMySignListResult result = new ApiMySignListResult();

		String sqlWhere = "exists (select 1 from cn_match_sign where sign_code = code) and status= '1' and user_code='"+upUserCode()+"'";

		int total = JdbcHelper.count(ReReportJson.class, sqlWhere, new MDataMap());

		PageInfo pageInfo = new PageInfo(total, input.getPagination(), 10);

		int iStart = (pageInfo.getPagination() - 1) * pageInfo.getPageNum();

		List<ReReportJson> reportJsons = JdbcHelper.queryForList(ReReportJson.class, "", "-zc", sqlWhere,
				new MDataMap(), iStart, pageInfo.getPageNum());
		
		reportJsons.forEach(reportJson -> {
			
			MySignInfo mySignInfo = new MySignInfo();
			
			mySignInfo.setCode(reportJson.getSignCode());
			
			mySignInfo.setSignCode(reportJson.getCode());
			
			initMatchInfo(mySignInfo, input.getWidth());
			
			initReportInfo(mySignInfo);
			
			mySignInfo.setStatus("报名成功");
			
			result.getMySignInfos().add(mySignInfo);
			
		});

		return result;
	}
	
	/**
	 * 根据报名编号获取赛事信息
	 * @param matchCode
	 * 		赛事编号
	 * @return 赛事信息
	 */
	public void initMatchInfo(MySignInfo mySignInfo,int width){
		
		CnMatchSign cnMatchSign = JdbcHelper.queryOne(CnMatchSign.class, "signCode",mySignInfo.getSignCode());
		
		CnMatchInfo cnMatchInfo = null;
		
		if(cnMatchSign != null){
			
			
			cnMatchInfo = JdbcHelper.queryOne(CnMatchInfo.class, "code",cnMatchSign.getMatchCode());
			
		}
		
		if(cnMatchInfo != null){
			
			String cover = cnMatchInfo.getCover();
			
			if(StringUtils.isNotEmpty(cover)){
				
				cover = ImageHelper.upImageThumbnail(cover, width);
				
			}
			
			mySignInfo.setCover(cover);
			
			if(StringUtils.isNotEmpty(cnMatchInfo.getEndTime())){
				
				Date endDate = DateHelper.parseDate(cnMatchInfo.getEndTime());
				
				mySignInfo.setEndTime(DateHelper.upDate(endDate, "yyyy-MM-dd HH:mm"));
				
			}
			
			if(StringUtils.isNotEmpty(cnMatchInfo.getStartTime())){
				
				Date startDate = DateHelper.parseDate(cnMatchInfo.getStartTime());
				
				mySignInfo.setStartTime(DateHelper.upDate(startDate, "yyyy-MM-dd HH:mm"));
				
			}
			
			mySignInfo.setLocation(cnMatchInfo.getPlace());
			
			
		}
		
	}
	
	/**
	 * 根据报名编号初始报名信息
	 * @param signCode
	 * 		报名编号
	 * @return 报名信息
	 */
	public void initReportInfo(MySignInfo mySignInfo){
		
		ReReportInfo reReportInfo = JdbcHelper.queryOne(ReReportInfo.class, "code",mySignInfo.getSignCode());
		
		if(reReportInfo != null){
			
			
			if(reReportInfo.getOrderMoney() != null){
				
				mySignInfo.setMoney(reReportInfo.getOrderMoney().setScale(2).toString());
				
			}
			
			mySignInfo.setTitle(reReportInfo.getTitle());
			
			
		}
		
	}
	

}
