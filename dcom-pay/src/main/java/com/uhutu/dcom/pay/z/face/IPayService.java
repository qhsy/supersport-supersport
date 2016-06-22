package com.uhutu.dcom.pay.z.face;

import com.uhutu.zoocom.model.MDataMap;

/**
 * 业务实现接口
 * @author pang_jhui
 *
 */
public interface IPayService {

	/**
	 * 支付业务解析
	 * @param request
	 * 		业务请求	
	 * @param paramMap
	 * 		参数集合
	 * @return 响应信息
	 */
	public IPayResponse doProcess(IPayRequest request,MDataMap paramMap);
	
}
