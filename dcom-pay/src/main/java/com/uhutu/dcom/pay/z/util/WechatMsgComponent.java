package com.uhutu.dcom.pay.z.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.uhutu.dcom.pay.z.common.Constants;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.config.WechatMsgConfig;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.process.impl.PayGateProcess;
import com.uhutu.dcom.pay.z.response.WechatMsgResponse;
import com.uhutu.zoocom.model.MDataMap;

/**
 * 微信消息组件
 * @author 逄小帅
 *
 */
public class WechatMsgComponent {
	
	/*实体bean处理处理实例*/
	private volatile static WechatMsgComponent INSTANCE = null;
	
	@Autowired
	private PayGateProcess payGateProcess;
	
	@Autowired
	private WechatMsgConfig wechatMsgConfig;
	
	/**
	 * 获取实体bean处理实例
	 * @return WechatMsgComponent
	 */
	public static WechatMsgComponent getInstance(){
		
		if(INSTANCE == null){
			
			synchronized (WechatMsgComponent.class) {
				
				if(INSTANCE == null){
					
					INSTANCE = new WechatMsgComponent();
					
				}
				
			}
			
		}
		
		return INSTANCE;
		
	}
	
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
	public WechatMsgResponse sendMsg(String openId,PayProcessEnum processEnum,IPayRequest payRequest) {

		MDataMap mDataMap = new MDataMap();

		mDataMap.put(Constants.KEY_OPENID, openId);

		mDataMap.put(Constants.KEY_TEMPLETID, getTempletId(processEnum));

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
			templetId = wechatMsgConfig.getAnswerId();
			break;
		case WECHAT_MSG_REFUND:
			templetId = wechatMsgConfig.getRefundId();
			break;
		case WECHAT_MSG_ASK:
			templetId = wechatMsgConfig.getAskId();
			break;

		default:
			break;
		}
		
		return templetId;
		
	}

}
