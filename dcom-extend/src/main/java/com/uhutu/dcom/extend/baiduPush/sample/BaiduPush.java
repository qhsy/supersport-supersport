package com.uhutu.dcom.extend.baiduPush.sample;

import com.uhutu.dcom.extend.baiduPush.exception.PushClientException;
import com.uhutu.dcom.extend.baiduPush.exception.PushServerException;

public class BaiduPush {
	
	private IOSPushNotificationToSingleDevice iosPush = new IOSPushNotificationToSingleDevice();
	
	private AndroidPushMsgToSingleDevice androidPush = new AndroidPushMsgToSingleDevice();
	
	public void push(PushEnum pushEnum, String title,String content,String channelId) throws PushServerException, PushClientException{
		
		switch (pushEnum) {
		case ios:
			iosPush.push(channelId, content);
			break;
		case android:
			androidPush.push(title, content, channelId);
			break;
		default:
			iosPush.push(channelId, content);
			androidPush.push(title, content, channelId);
			break;
		}
		
	}

}
