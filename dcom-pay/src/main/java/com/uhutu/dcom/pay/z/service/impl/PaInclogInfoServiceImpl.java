package com.uhutu.dcom.pay.z.service.impl;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.pay.z.entity.PaInclogInfo;
import com.uhutu.dcom.pay.z.service.IPaInclogInfoService;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 接口调用日志信息
 * @author 逄小帅
 *
 */
@Service
public class PaInclogInfoServiceImpl implements IPaInclogInfoService {

	@Override
	public int save(PaInclogInfo paInclogInfo) {
		
		return JdbcHelper.insert(paInclogInfo);
		
	}

}
