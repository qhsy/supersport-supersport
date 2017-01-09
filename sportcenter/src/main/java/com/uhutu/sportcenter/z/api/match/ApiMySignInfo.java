package com.uhutu.sportcenter.z.api.match;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnMatchInfo;
import com.uhutu.dcom.content.z.entity.CnMatchSign;
import com.uhutu.dcom.extend.z.entity.ReReportField;
import com.uhutu.dcom.extend.z.entity.ReReportInfo;
import com.uhutu.dcom.extend.z.entity.ReReportJson;
import com.uhutu.sportcenter.z.entity.MySignFieldInfo;
import com.uhutu.sportcenter.z.entity.MySignInfo;
import com.uhutu.sportcenter.z.input.ApiMySignInfoInput;
import com.uhutu.sportcenter.z.result.ApiMySignInfoResult;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.helper.GsonHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 我的报名信息
 * @author 逄小帅
 *
 */
@Component
public class ApiMySignInfo extends RootApiToken<ApiMySignInfoInput, ApiMySignInfoResult> {

	@Override
	protected ApiMySignInfoResult process(ApiMySignInfoInput input) {
		
		ApiMySignInfoResult signInfoResult = new ApiMySignInfoResult();
		
		ReReportJson reportJson = JdbcHelper.queryOne(ReReportJson.class, "signCode",input.getCode(),"userCode",upUserCode());
		
		if(reportJson != null){
			
			MySignInfo mySignInfo = new MySignInfo();
			
			mySignInfo.setCode(reportJson.getSignCode());
			
			mySignInfo.setSignCode(reportJson.getCode());
			
			initMatchInfo(mySignInfo, 0);
			
			initReportInfo(mySignInfo);
			
			signInfoResult.setMySignInfo(mySignInfo);
			
			signInfoResult.setSignFieldInfos(initFieldInfos(reportJson.getJson(), mySignInfo.getSignCode()));
			
			
		}else{
			
			signInfoResult.setStatus(-1);
			
			signInfoResult.setError("报名信息不存在");
			
		}
		
		return signInfoResult;
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
			
			if(reReportInfo.getEndTime() != null){
				
				mySignInfo.setEndTime(DateHelper.upDate(reReportInfo.getEndTime(), "yyyy-MM-dd HH:mm"));
				
			}
			
			if(reReportInfo.getStartTime() != null){
				
				mySignInfo.setStartTime(DateHelper.upDate(reReportInfo.getStartTime(), "yyyy-MM-dd HH:mm"));
				
			}
			
			if(reReportInfo.getOrderMoney() != null){
				
				mySignInfo.setMoney(reReportInfo.getOrderMoney().setScale(2).toString());
				
			}
			
			mySignInfo.setTitle(reReportInfo.getTitle());
			
			
		}
		
	}
	
	public List<MySignFieldInfo> initFieldInfos(String jsonStr,String signCode){
		
		List<MySignFieldInfo> signFieldInfos = new ArrayList<MySignFieldInfo>();
		
		if(StringUtils.isNotBlank(jsonStr)){
			
			MDataMap mDataMap = new MDataMap();
			
			mDataMap = GsonHelper.fromJson(jsonStr, mDataMap);
			
			if(mDataMap != null && !mDataMap.isEmpty()){
				
				MDataMap whereMap = new MDataMap();
				
				List<ReReportField> reportFields = JdbcHelper.queryForList(ReReportField.class, "", "show_sort desc", "field_type != 'RETYBH0006' and code = '"+signCode+"'", whereMap);
				
				for (ReReportField reportField : reportFields) {
					
					if(reportField != null){
						
						MySignFieldInfo signFieldInfo = new MySignFieldInfo();
						
						signFieldInfo.setName(reportField.getFieldId());
						
						signFieldInfo.setText(reportField.getFieldLabel());
						
						String val = mDataMap.get(reportField.getFieldId());
						
						signFieldInfo.setValue(val);
						
						signFieldInfos.add(signFieldInfo);
						
					}
					
				}
				
			}
			
			
		}
		
		return signFieldInfos;
		
	}

}
