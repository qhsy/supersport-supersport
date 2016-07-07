package com.uhutu.dcom.pay.z.service.impl;

import org.springframework.stereotype.Service;
import com.uhutu.dcom.pay.z.entity.PaPayInfo;
import com.uhutu.dcom.pay.z.service.IPaPayInfoService;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 支付信息业务实现
 * @author 逄小帅
 *
 */
@Service
public class PaPayInfoServiceImpl implements IPaPayInfoService {

	@Override
	public int save(PaPayInfo paPayInfo) {
		
		int result = 0;
		
		if(paPayInfo != null){
			
			int count = JdbcHelper.count(paPayInfo.getClass(), "", MapHelper.initMap("orderCode",paPayInfo.getOrderCode()));
			
			if(count > 0){
				
				result = JdbcHelper.update(paPayInfo, "outCode,payType", "orderCode");
				
			}else{
				
				result = JdbcHelper.insert(paPayInfo);
				
			}
			
		}
		
		return result;
		
	}

	@Override
	public PaPayInfo queryByOrderCode(String orderCode) {
		
		return JdbcHelper.queryOne(PaPayInfo.class, "orderCode",orderCode);
		
	}
	
	
	
}
