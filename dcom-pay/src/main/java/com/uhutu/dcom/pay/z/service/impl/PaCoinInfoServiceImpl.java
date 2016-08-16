package com.uhutu.dcom.pay.z.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.pay.z.entity.PaCoinFlow;
import com.uhutu.dcom.pay.z.entity.PaCoinInfo;
import com.uhutu.dcom.pay.z.service.IPaCoinInfoService;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 金币信息业务实现
 * @author 逄小帅
 *
 */
@Service
public class PaCoinInfoServiceImpl implements IPaCoinInfoService {

	@Override
	public PaCoinInfo queryByUserCode(String userCode) {
		
		return JdbcHelper.queryOne(PaCoinInfo.class, "userCode",userCode);
		
	}

	@Override
	public void save(PaCoinInfo paCoinInfo) {
		
		int count = JdbcHelper.count(PaCoinInfo.class, "", MapHelper.initMap("userCode",paCoinInfo.getUserCode()));
		
		if(count > 0){
			
			paCoinInfo.setZu(new Date());
			
			JdbcHelper.update(paCoinInfo, "zu,balance", "userCode");
			
		}else{
			
			paCoinInfo.setZc(new Date());
			
			JdbcHelper.insert(paCoinInfo);
			
		}
		
	}

	@Override
	public List<PaCoinFlow> queryCoinFlows(String userCode, int start, int number) {
		
		List<PaCoinFlow> coinFlows = JdbcHelper.queryForList(PaCoinFlow.class, "", "", "", MapHelper.initMap("userCode",userCode), start, number);
		
		return coinFlows;
	}

	@Override
	public int queryCoinFlowCount(String userCode) {
		
		return JdbcHelper.count(PaCoinFlow.class, "", MapHelper.initMap("userCode",userCode));
	}

}
