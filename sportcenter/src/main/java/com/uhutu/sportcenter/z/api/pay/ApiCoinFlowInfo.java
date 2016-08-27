package com.uhutu.sportcenter.z.api.pay;

import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.pay.z.entity.PaCoinFlow;
import com.uhutu.dcom.pay.z.service.PayServiceFactory;
import com.uhutu.sportcenter.z.entity.PaCoinFlowInfo;
import com.uhutu.sportcenter.z.input.ApiCoinFlowInfoInput;
import com.uhutu.sportcenter.z.result.ApiCoinFlowInfoResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 金币流水信息
 * @author 逄小帅
 *
 */
@Component
public class ApiCoinFlowInfo extends RootApiToken<ApiCoinFlowInfoInput, ApiCoinFlowInfoResult> {
	
	@Autowired
	private PayServiceFactory payServiceFactory;

	@Override
	protected ApiCoinFlowInfoResult process(ApiCoinFlowInfoInput input) {
		
		int number = 10;
		
		ApiCoinFlowInfoResult result = new ApiCoinFlowInfoResult();
		
		int count = payServiceFactory.getPaCoinInfoService().queryCoinFlowCount(upUserCode());
		
		PageInfo pageInfo = new PageInfo(count, input.getPagination(), number);
		
		result.setNextPageFlag(pageInfo.hasNext());
		
		int start = (input.getPagination() -1)*number;
		
		List<PaCoinFlow> coinFlows = payServiceFactory.getPaCoinInfoService().queryCoinFlows(upUserCode(), start, number);
		
		if(coinFlows != null){
			
			coinFlows.forEach( coinFlow -> {
				
				PaCoinFlowInfo coinFlowInfo = new PaCoinFlowInfo();
				
				BeanUtils.copyProperties(coinFlow, coinFlowInfo);
				
				if(coinFlow.getZc() != null){
					
					coinFlowInfo.setTimeStr(DateFormatUtils.format(coinFlow.getZc(), "yyyy-MM-dd HH:mm:ss"));
					
				}
				
				result.getCoinFlowInfos().add(coinFlowInfo);
				
			});
			
		}
		
		return result;
	}

}
