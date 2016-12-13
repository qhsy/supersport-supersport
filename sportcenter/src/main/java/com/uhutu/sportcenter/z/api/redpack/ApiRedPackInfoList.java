package com.uhutu.sportcenter.z.api.redpack;

import java.util.List;

import org.springframework.stereotype.Component;

import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.content.z.entity.CnRedPackInfo;
import com.uhutu.dcom.content.z.entity.CnRedPackUser;
import com.uhutu.sportcenter.z.input.ApiRedPackInfoListInput;
import com.uhutu.sportcenter.z.result.ApiRedPackInfoListResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 红包信息列表
 * @author 逄小帅
 *
 */
@Component
public class ApiRedPackInfoList extends RootApiToken<ApiRedPackInfoListInput, ApiRedPackInfoListResult>{

	@Override
	protected ApiRedPackInfoListResult process(ApiRedPackInfoListInput input) {
		
		ApiRedPackInfoListResult redPackInfoListResult = new ApiRedPackInfoListResult();
		
		initRedPackInfos(redPackInfoListResult);
		
		initRedPackUsers(redPackInfoListResult,input.getLiveCode());
		
		return redPackInfoListResult;
	}
	
	public void initRedPackInfos(ApiRedPackInfoListResult redPackInfoListResult){
		
		MDataMap mWhereMap = new MDataMap();
		
		mWhereMap.put("status", SystemEnum.YES.getCode());
		
		List<CnRedPackInfo> redPackInfos = JdbcHelper.queryForList(CnRedPackInfo.class, "", "-sort", "", mWhereMap);
		
		redPackInfoListResult.setRedPackInfos(redPackInfos);
		
	}
	
	public void initRedPackUsers(ApiRedPackInfoListResult redPackInfoListResult,String liveCode){
		
		MDataMap mWhereMap = new MDataMap();
		
		mWhereMap.put("busiCode", liveCode);
		
		mWhereMap.put("userCode", upUserCode());
		
		List<CnRedPackUser> redPackUsers = JdbcHelper.queryForList(CnRedPackUser.class, "", "-sort", "", mWhereMap);
		
		redPackInfoListResult.setRedPackUsers(redPackUsers);
		
		
	}

}
