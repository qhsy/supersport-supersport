package com.uhutu.dcom.pay.z.service;

import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.face.IPayService;
import com.uhutu.dcom.pay.z.request.WechatBizContentRequest;
import com.uhutu.dcom.pay.z.request.WechatOrderRequest;
/**
 * 微信订单业务实现
 * @author 逄小帅
 *
 */
public interface IWechatOrderService extends IPayService  {
	
	/**
	 * 初始化统一下单请求信息
	 * @param bizContentRequest
	 * 		业务内容请求信息
	 * @return 微信订单请求对象
	 */
	public WechatOrderRequest initOrderRequest(WechatBizContentRequest bizContentRequest,PayProcessEnum processEnum);
	
	/**
	 * 初始化微信订单body字段
	 * @param orderType
	 * 		订单类型
	 * @return body
	 */
	public String initBody(String orderType);

}
