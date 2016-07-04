package com.uhutu.dcom.pay.z.service.impl;

import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.service.IWechatMsgService;
import com.uhutu.zoocom.helper.GsonHelper;
import com.uhutu.zoocom.model.MDataMap;

/**
 * 微信消息通知业务实现
 * @author 逄小帅
 *
 */
public class WechatMsgServiceImpl implements IWechatMsgService {

	@Override
	public IPayResponse doProcess(IPayRequest request, MDataMap paramMap) {
		
		String data = GsonHelper.toJson(request);
		
		return null;
	}

}
