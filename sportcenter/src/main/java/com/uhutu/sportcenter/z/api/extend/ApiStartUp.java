package com.uhutu.sportcenter.z.api.extend;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.extend.sensitive.z.entity.CnStartUp;
import com.uhutu.sportcenter.z.input.ApiStartUpInput;
import com.uhutu.sportcenter.z.result.ApiStartUpResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 专题数据展示
 * 
 * @author xiegj
 */
@Service
public class ApiStartUp extends RootApiBase<ApiStartUpInput, ApiStartUpResult> {

	protected ApiStartUpResult process(ApiStartUpInput input) {
		ApiStartUpResult result = new ApiStartUpResult();
		CnStartUp startUp = JdbcHelper.queryOne(CnStartUp.class, "", "", " endTime>=NOW() and startTime<=NOW() ", new MDataMap());
		if(startUp!=null){
			result.setStartUp(startUp);
		}
		return result;
	}

}
