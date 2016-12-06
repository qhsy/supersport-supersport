package com.uhutu.sportcenter.z.api.remark;

import org.springframework.stereotype.Component;

import com.uhutu.dcom.remark.z.entity.CnContentRemark;
import com.uhutu.sportcenter.z.input.ApiOperRemarkInput;
import com.uhutu.sportcenter.z.result.ApiOperRemarkResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 评论相关操作
 * @author 逄小帅
 *
 */
@Component
public class ApiOperRemark extends RootApiToken<ApiOperRemarkInput, ApiOperRemarkResult> {

	@Override
	protected ApiOperRemarkResult process(ApiOperRemarkInput input) {
		
		switch (input.getOperFlag()) {
		case "DEL":
			delRemark(input.getRemarkCode());
			break;

		default:
			break;
		}
		
		return null;
	}
	
	public void delRemark(String remarkCode){
		
		MDataMap mWhereMap = new MDataMap();
		
		mWhereMap.put("code", remarkCode);
		
		CnContentRemark cnContentRemark = JdbcHelper.queryOne(CnContentRemark.class, "", "", "", mWhereMap);
		
		if(cnContentRemark != null){
			
			cnContentRemark.setStatus("del");
			
			JdbcHelper.update(cnContentRemark, "status", "za");
			
		}
		
	}

}
