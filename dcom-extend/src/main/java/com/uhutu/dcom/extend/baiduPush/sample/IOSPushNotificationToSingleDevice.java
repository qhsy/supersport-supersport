package com.uhutu.dcom.extend.baiduPush.sample;

import com.uhutu.dcom.extend.baiduPush.auth.PushKeyPair;
import com.uhutu.dcom.extend.baiduPush.client.BaiduPushClient;
import com.uhutu.dcom.extend.baiduPush.constants.BaiduPushConstants;
import com.uhutu.dcom.extend.baiduPush.core.log.YunLogEvent;
import com.uhutu.dcom.extend.baiduPush.core.log.YunLogHandler;
import com.uhutu.dcom.extend.baiduPush.exception.PushClientException;
import com.uhutu.dcom.extend.baiduPush.exception.PushServerException;
import com.uhutu.dcom.extend.baiduPush.model.PushMsgToSingleDeviceRequest;
import com.uhutu.dcom.extend.baiduPush.model.PushMsgToSingleDeviceResponse;

import net.sf.json.JSONObject;

public class IOSPushNotificationToSingleDevice {
	public static void main(String[] args) throws PushClientException, PushServerException {
		// 1. get apiKey and secretKey from developer console
		String apiKey = "ORG6KhOtVUSFI5pVOfDEr4AZETeOKkZI";
		String secretKey = "bh3N6zUCQNaA8CAYwCpGxuFVqfcpV1hq";
		PushKeyPair pair = new PushKeyPair(apiKey, secretKey);

		// 2. build a BaidupushClient object to access released interfaces
		BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);

		// 3. register a YunLogHandler to get detail interacting information
		// in this request.
		pushClient.setChannelLogHandler(new YunLogHandler() {
			@Override
			public void onHandle(YunLogEvent event) {
				System.out.println(event.getMessage());
			}
		});

		try {
			// 4. specify request arguments
			// make IOS Notification
			JSONObject notification = new JSONObject();
			JSONObject jsonAPS = new JSONObject();
			jsonAPS.put("alert", "Hello Baidu Push");
			notification.put("type", "1");
			notification.put("aps", jsonAPS);

			PushMsgToSingleDeviceRequest request = new PushMsgToSingleDeviceRequest()
					.addChannelId("4821573614764451774").addMsgExpires(new Integer(3600)). // 设置message的有效时间
					addMessageType(1).// 1：通知,0:透传消息.默认为0 注：IOS只有通知.
					addMessage(notification.toString()).addDeployStatus(1). // IOS,
																			// DeployStatus
																			// =>
																			// 1:
																			// Developer
																			// 2:
																			// Production.
					addDeviceType(4);// deviceType => 3:android, 4:ios
			// 5. http request
			PushMsgToSingleDeviceResponse response = pushClient.pushMsgToSingleDevice(request);
			// Http请求结果解析打印
			System.out.println("msgId: " + response.getMsgId() + ",sendTime: " + response.getSendTime());
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
