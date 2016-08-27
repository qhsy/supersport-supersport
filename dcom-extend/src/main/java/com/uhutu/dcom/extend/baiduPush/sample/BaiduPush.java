package com.uhutu.dcom.extend.baiduPush.sample;

import com.uhutu.dcom.extend.baiduPush.exception.PushClientException;
import com.uhutu.dcom.extend.baiduPush.exception.PushServerException;

public class BaiduPush {

	private IOSPushNotificationToSingleDevice iosPush = new IOSPushNotificationToSingleDevice();

	private AndroidPushMsgToSingleDevice androidPush = new AndroidPushMsgToSingleDevice();

	/**
	 * 
	 * @param pushEnum
	 * @param title
	 *            推送标题
	 * @param content
	 *            推送内容
	 * @param channelId
	 *            设备id
	 * @param jumpType
	 *            推送跳转类型  0个人中心 1运动时刻详情页 2首页 3问达详情页
	 * @param jumpJson
	 *            推送跳转内容
	 * @throws PushServerException
	 * @throws PushClientException
	 */
	public void push(PushEnum pushEnum, String title, String content, String channelId, String jumpType,
			String jumpContent) throws PushServerException, PushClientException {

		switch (pushEnum) {
		case ios:
			iosPush.push(channelId, content, jumpType, jumpContent);
			break;
		case android:
			androidPush.push(title, content, channelId, jumpType, jumpContent);
			break;
		default:
			iosPush.push(channelId, content, jumpType, jumpContent);
			androidPush.push(title, content, channelId, jumpType, jumpContent);
			break;
		}

	}

}
