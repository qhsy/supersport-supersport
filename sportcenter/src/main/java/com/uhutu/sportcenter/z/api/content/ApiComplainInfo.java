package com.uhutu.sportcenter.z.api.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.config.enums.PrexEnum;
import com.uhutu.dcom.remark.z.entity.CnSupportComplain;
import com.uhutu.dcom.remark.z.service.ContentRemarkServiceFactory;
import com.uhutu.sportcenter.z.input.ApiComplainInfoInput;
import com.uhutu.sportcenter.z.result.ApiComplainInfoResult;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zooweb.helper.WebHelper;

/**
 * 投诉接口业务处理
 * @author 逄小帅
 *
 */
@Component
public class ApiComplainInfo extends RootApiBase<ApiComplainInfoInput, ApiComplainInfoResult> {
	
	@Autowired
	private ContentRemarkServiceFactory serviceFacotry;

	@Override
	protected ApiComplainInfoResult process(ApiComplainInfoInput input) {
		
		ApiComplainInfoResult result = new ApiComplainInfoResult();
		
		CnSupportComplain supportComplain = new CnSupportComplain();
		
		supportComplain.setCode(WebHelper.upCode(PrexEnum.CCP.name()));
		
		supportComplain.setContentCode(input.getContentCode());
		
		supportComplain.setReasonCode(input.getReasonCode());
		
		supportComplain.setRemark(input.getRemark());
		
		supportComplain.setType(input.getType());
		
		serviceFacotry.getSupportComplainService().save(supportComplain);
		
		return result;
		
	}

}
