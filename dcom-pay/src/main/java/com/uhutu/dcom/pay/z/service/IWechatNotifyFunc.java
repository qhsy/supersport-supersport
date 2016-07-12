package com.uhutu.dcom.pay.z.service;

import com.uhutu.dcom.pay.z.face.IPayFunc;
import com.uhutu.dcom.pay.z.request.WechatNotifyRequest;
import com.uhutu.zoocom.model.MResult;

/**
 * 微信支付通知业务处理
 * @author 逄小帅
 *
 */
public interface IWechatNotifyFunc extends IPayFunc {
	
	/**
	 * 微信支付通知业务处理
	 * @param notifyRequest
	 * 		通知请求对象
	 * @return 处理结果
	 */
	public MResult doAfter(WechatNotifyRequest notifyRequest);

}
