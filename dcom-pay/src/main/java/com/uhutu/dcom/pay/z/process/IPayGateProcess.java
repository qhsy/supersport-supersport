package com.uhutu.dcom.pay.z.process;

import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.face.IPayProcess;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.face.IPayService;
import com.uhutu.zoocom.model.MDataMap;

/**
 * 支付宝解析
 * @author 逄小帅
 *
 */
public interface IPayGateProcess extends IPayProcess {
	
	/**
	 * 根据请求信息组装响应信息
	 * @param request
	 * 		请求信息
	 * @param processEnum
	 * 		解析枚举
	 * @param paramMap
	 * 		参数集合
	 * @return 响应信息
	 */
	public IPayResponse process(PayProcessEnum processEnum,IPayRequest request,MDataMap paramMap);
	
	/**
	 * 获取业务实现类
	 * @param processEnum
	 * 		解析枚举
	 * @return 支付业务实现
	 */
	public IPayService upPayService(PayProcessEnum processEnum);

}
