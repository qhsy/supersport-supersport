package com.uhutu.dcom.pay.z.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.pay.z.common.Constants;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.config.PayConfigFactory;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.process.impl.PayGateProcess;
import com.uhutu.dcom.pay.z.response.WechatMsgResponse;
import com.uhutu.zoocom.model.MDataMap;

/**
 * 微信消息组件
 * @author 逄小帅
 *
 */
@Component
public class WechatMsgComponent {
	
	@Autowired
	private PayGateProcess payGateProcess;
	
	@Autowired
	private PayConfigFactory configFactory;
	
	/**
	 * 微信消息发送
	 * @param openId
	 * 		微信平台用户编号
	 * @param processEnum
	 * 		消息类型
	 * @param payRequest
	 * 		消息模版信息
	 * @return 消息响应信息
	 */
	public WechatMsgResponse sendMsg(String openId,String param,PayProcessEnum processEnum,IPayRequest payRequest) {

		MDataMap mDataMap = new MDataMap();

		mDataMap.put(Constants.KEY_OPENID, openId);

		mDataMap.put(Constants.KEY_TEMPLETID, getTempletId(processEnum));
		
		mDataMap.put(Constants.KEY_REDIRECTURL,getRedirectUrl(processEnum, param));

		return (WechatMsgResponse) payGateProcess.process(PayProcessEnum.WECHAT_MSG, payRequest,
				mDataMap);

	}
	
	/**
	 * 根据模板类型获取消息模板标识
	 * @param processEnum
	 * 		消息类型
	 * @return 模板标识
	 */
	public String getTempletId(PayProcessEnum processEnum){
		
		String templetId = "";
		
		switch (processEnum) {
		case WECHAT_MSG_ANSWER:
			templetId = configFactory.getWechatMsgConfig().getAnswerId();
			break;
		case WECHAT_MSG_REFUND:
			templetId = configFactory.getWechatMsgConfig().getRefundId();
			break;
		case WECHAT_MSG_ASK:
			templetId = configFactory.getWechatMsgConfig().getAskId();
			break;

		default:
			break;
		}
		
		return templetId;
		
	}
	
	/**
	 * 获取跳转路径
	 * @param processEnum
	 * 		消息类型
	 * @param param
	 * 		跳转路径参数值
	 * @return 路径信息
	 */
	public String getRedirectUrl(PayProcessEnum processEnum,String param){
		
		return "";
		
	}

}
