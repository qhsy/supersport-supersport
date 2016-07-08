package com.uhutu.dcom.pay.z.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 微信消息推送
 * @author 逄小帅
 *
 */
@Component
public class WechatMsgConfig {
	
	/*消息发送url*/
	@Value("${wechat_msg_send_url}")
	private String sendUrl;
	
	/*收到回复通知模版id*/
	@Value("${wechat_msg_templet_answer}")
	private String answerId;
	
	/*用户提问通知模版id*/
	@Value("${wechat_msg_templet_ask}")
	private String askId;
	
	/*退款通知模版id*/
	@Value("${wechat_msg_templet_refund}")
	private String refundId;

	/**
	 * 获取消息发送路径
	 * @return
	 */
	public String getSendUrl() {
		return sendUrl;
	}

	/**
	 * 获取收到回复通知模板id
	 * @return
	 */
	public String getAnswerId() {
		return answerId;
	}

	/**
	 * 获取用户提问通知模板id
	 * @return
	 */
	public String getAskId() {
		return askId;
	}

	/**
	 * 获取退款通知模板id
	 * @return
	 */
	public String getRefundId() {
		return refundId;
	}
	
	

}
