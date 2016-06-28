package com.uhutu.dcom.extend.baiduPush.client;

import java.util.concurrent.Future;

import com.uhutu.dcom.extend.baiduPush.exception.PushClientException;
import com.uhutu.dcom.extend.baiduPush.exception.PushServerException;
import com.uhutu.dcom.extend.baiduPush.model.PushMsgToSingleDeviceRequest;
import com.uhutu.dcom.extend.baiduPush.model.PushMsgToSingleDeviceResponse;

public interface BaiduPushAsync {

	Future<PushMsgToSingleDeviceResponse> pushMsgToSingleDeviceAsync(
			PushMsgToSingleDeviceRequest request)
			throws PushClientException, PushServerException;

}
