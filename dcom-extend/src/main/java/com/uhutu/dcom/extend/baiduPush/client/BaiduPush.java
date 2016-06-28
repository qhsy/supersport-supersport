package com.uhutu.dcom.extend.baiduPush.client;

import com.uhutu.dcom.extend.baiduPush.exception.PushClientException;
import com.uhutu.dcom.extend.baiduPush.exception.PushServerException;
import com.uhutu.dcom.extend.baiduPush.model.AddDevicesToTagRequest;
import com.uhutu.dcom.extend.baiduPush.model.AddDevicesToTagResponse;
import com.uhutu.dcom.extend.baiduPush.model.CreateTagRequest;
import com.uhutu.dcom.extend.baiduPush.model.CreateTagResponse;
import com.uhutu.dcom.extend.baiduPush.model.DeleteDevicesFromTagRequest;
import com.uhutu.dcom.extend.baiduPush.model.DeleteDevicesFromTagResponse;
import com.uhutu.dcom.extend.baiduPush.model.DeleteTagRequest;
import com.uhutu.dcom.extend.baiduPush.model.DeleteTagResponse;
import com.uhutu.dcom.extend.baiduPush.model.PushBatchUniMsgRequest;
import com.uhutu.dcom.extend.baiduPush.model.PushBatchUniMsgResponse;
import com.uhutu.dcom.extend.baiduPush.model.PushMsgToAllRequest;
import com.uhutu.dcom.extend.baiduPush.model.PushMsgToAllResponse;
import com.uhutu.dcom.extend.baiduPush.model.PushMsgToSingleDeviceRequest;
import com.uhutu.dcom.extend.baiduPush.model.PushMsgToSingleDeviceResponse;
import com.uhutu.dcom.extend.baiduPush.model.PushMsgToSmartTagRequest;
import com.uhutu.dcom.extend.baiduPush.model.PushMsgToSmartTagResponse;
import com.uhutu.dcom.extend.baiduPush.model.PushMsgToTagRequest;
import com.uhutu.dcom.extend.baiduPush.model.PushMsgToTagResponse;
import com.uhutu.dcom.extend.baiduPush.model.QueryDeviceNumInTagRequest;
import com.uhutu.dcom.extend.baiduPush.model.QueryDeviceNumInTagResponse;
import com.uhutu.dcom.extend.baiduPush.model.QueryMsgStatusRequest;
import com.uhutu.dcom.extend.baiduPush.model.QueryMsgStatusResponse;
import com.uhutu.dcom.extend.baiduPush.model.QueryStatisticDeviceRequest;
import com.uhutu.dcom.extend.baiduPush.model.QueryStatisticDeviceResponse;
import com.uhutu.dcom.extend.baiduPush.model.QueryStatisticMsgRequest;
import com.uhutu.dcom.extend.baiduPush.model.QueryStatisticMsgResponse;
import com.uhutu.dcom.extend.baiduPush.model.QueryStatisticTopicRequest;
import com.uhutu.dcom.extend.baiduPush.model.QueryStatisticTopicResponse;
import com.uhutu.dcom.extend.baiduPush.model.QueryTagsRequest;
import com.uhutu.dcom.extend.baiduPush.model.QueryTagsResponse;
import com.uhutu.dcom.extend.baiduPush.model.QueryTimerListRequest;
import com.uhutu.dcom.extend.baiduPush.model.QueryTimerListResponse;
import com.uhutu.dcom.extend.baiduPush.model.QueryTimerRecordsRequest;
import com.uhutu.dcom.extend.baiduPush.model.QueryTimerRecordsResponse;
import com.uhutu.dcom.extend.baiduPush.model.QueryTopicListRequest;
import com.uhutu.dcom.extend.baiduPush.model.QueryTopicListResponse;
import com.uhutu.dcom.extend.baiduPush.model.QueryTopicRecordsRequest;
import com.uhutu.dcom.extend.baiduPush.model.QueryTopicRecordsResponse;

public interface BaiduPush {

	public PushMsgToSingleDeviceResponse pushMsgToSingleDevice (
			PushMsgToSingleDeviceRequest request) throws PushClientException,
		    PushServerException;
	
	public PushMsgToAllResponse pushMsgToAll (
			PushMsgToAllRequest request) throws PushClientException,
		    PushServerException;
	
	public PushMsgToTagResponse pushMsgToTag (
			PushMsgToTagRequest request) throws PushClientException, 
	PushServerException;
	
	public PushMsgToSmartTagResponse pushMsgToSmartTag (
			PushMsgToSmartTagRequest request) throws PushClientException, 
	PushServerException;
	
	public PushBatchUniMsgResponse pushBatchUniMsg (
			PushBatchUniMsgRequest request) throws PushClientException, 
	PushServerException;
	
	public QueryMsgStatusResponse queryMsgStatus (
			QueryMsgStatusRequest request) throws PushClientException, 
	PushServerException;
	
	public QueryTimerRecordsResponse queryTimerRecords (
			QueryTimerRecordsRequest request) throws PushClientException, 
	PushServerException;
	
	public QueryTopicRecordsResponse queryTopicRecords (
			QueryTopicRecordsRequest request) throws PushClientException, 
	PushServerException;
	
	public QueryTimerListResponse queryTimerList (
			QueryTimerListRequest request) throws PushClientException, 
	PushServerException;
	
	public QueryTopicListResponse queryTopicList (
			QueryTopicListRequest request) throws PushClientException, 
	PushServerException;
	
	public QueryTagsResponse queryTags (
			QueryTagsRequest request) throws PushClientException, 
	PushServerException;
	
	public CreateTagResponse createTag (
			CreateTagRequest request) throws PushClientException, 
	PushServerException;
	
	public DeleteTagResponse deleteTag (
			DeleteTagRequest request) throws PushClientException, 
	PushServerException;
	
	public AddDevicesToTagResponse addDevicesToTag (
			AddDevicesToTagRequest request) throws PushClientException, 
	PushServerException;
	
	public DeleteDevicesFromTagResponse deleteDevicesFromTag (
			DeleteDevicesFromTagRequest request) throws PushClientException, 
	PushServerException;
	
	public QueryDeviceNumInTagResponse queryDeviceNumInTag (
			QueryDeviceNumInTagRequest request) throws PushClientException, 
	PushServerException;
	
	public QueryStatisticMsgResponse queryStatisticMsg (
			QueryStatisticMsgRequest request) throws PushClientException, 
	PushServerException;
	
	public QueryStatisticTopicResponse queryStatisticTopic (
			QueryStatisticTopicRequest request) throws PushClientException, 
	PushServerException;
	
	public QueryStatisticDeviceResponse queryStatisticDevice (
			QueryStatisticDeviceRequest request) throws 
	PushClientException, PushServerException;
	
}
