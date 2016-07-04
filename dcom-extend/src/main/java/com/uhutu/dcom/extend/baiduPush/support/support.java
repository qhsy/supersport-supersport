package com.uhutu.dcom.extend.baiduPush.support;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.extend.baiduPush.auth.PushKeyPair;
import com.uhutu.dcom.extend.baiduPush.client.BaiduPushClient;
import com.uhutu.dcom.extend.baiduPush.constants.BaiduPushConstants;
import com.uhutu.dcom.extend.baiduPush.exception.PushClientException;
import com.uhutu.dcom.extend.baiduPush.exception.PushServerException;
import com.uhutu.dcom.extend.baiduPush.model.PushMsgToSingleDeviceRequest;
import com.uhutu.dcom.extend.baiduPush.model.PushMsgToSingleDeviceResponse;
import com.uhutu.dcom.extend.z.properties.ConfigDcomExtend;

import net.sf.json.JSONObject;

public class support {

	/**
	 * 
	 * 
	 * @param systemType系统类型
	 *            android or ios
	 * @param content
	 *            推送内容
	 * @param channelId
	 *            设备推送唯一编号
	 */
	public void push(String systemType, String content, String channelId)
			throws PushClientException, PushServerException {
		PushKeyPair pair = new PushKeyPair(ConfigDcomExtend.upConfig().getBaiduPushApiKey(),
				ConfigDcomExtend.upConfig().getBaiduPushSecretKey());
		BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
		try {
			if (StringUtils.isNotBlank(systemType) && "ios".equals(systemType)) {// ios
																					// 推送服务
				JSONObject notification = new JSONObject();
				JSONObject jsonAPS = new JSONObject();
				jsonAPS.put("alert", content);
				notification.put("aps", jsonAPS);

				PushMsgToSingleDeviceRequest request = new PushMsgToSingleDeviceRequest().addChannelId(channelId)
						.addMsgExpires(new Integer(3600)). // 设置message的有效时间
						addMessageType(1).// 1：通知,0:透传消息.默认为0 注：IOS只有通知.
						addMessage(notification.toString()).addDeployStatus(1). // IOS,eDeployStatus=>1:Developer2:Production.
						addDeviceType(4);// deviceType => 3:android, 4:ios
				PushMsgToSingleDeviceResponse response = pushClient.pushMsgToSingleDevice(request);
			} else if (StringUtils.isNotBlank(systemType) && "android".equals(systemType)) {
				JSONObject notification = new JSONObject();
				notification.put("title", "TEST");
				notification.put("description", "Hello Baidu Push");
				notification.put("notification_builder_id", 0);
				notification.put("notification_basic_style", 4);
				notification.put("open_type", 1);
				notification.put("url", "http://push.baidu.com");
				JSONObject jsonCustormCont = new JSONObject();
				jsonCustormCont.put("key", "value"); // 自定义内容，key-value
				notification.put("custom_content", jsonCustormCont);

				PushMsgToSingleDeviceRequest request = new PushMsgToSingleDeviceRequest().addChannelId(channelId)
						.addMsgExpires(new Integer(3600)). // message有效时间
						addMessageType(1).// 1：通知,0:透传消息. 默认为0 注：IOS只有通知.
						addMessage(notification.toString()).addDeviceType(3);// deviceType=>3:android,4:ios
				PushMsgToSingleDeviceResponse response = pushClient.pushMsgToSingleDevice(request);
			}
		} catch (PushClientException e) {
			/*
			 * ERROROPTTYPE 用于设置异常的处理方式 -- 抛出异常和捕获异常,'true' 表示抛出, 'false' 表示捕获。
			 */
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				e.printStackTrace();
			}
		} catch (PushServerException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				System.out.println(String.format("requestId: %d, errorCode: %d, errorMessage: %s", e.getRequestId(),
						e.getErrorCode(), e.getErrorMsg()));
			}
		}
	}
}
