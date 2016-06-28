package com.uhutu.dcom.extend.baiduPush.client;

import java.util.Map;

import com.uhutu.dcom.extend.baiduPush.auth.PushKeyPair;
import com.uhutu.dcom.extend.baiduPush.auth.signature.PushSignatureDigest;
import com.uhutu.dcom.extend.baiduPush.constants.BaiduPushConstants;
import com.uhutu.dcom.extend.baiduPush.core.callback.YunLogHttpCallBack;
import com.uhutu.dcom.extend.baiduPush.core.exception.YunHttpClientException;
import com.uhutu.dcom.extend.baiduPush.core.httpclient.YunHttpClient;
import com.uhutu.dcom.extend.baiduPush.core.log.YunLogHandler;
import com.uhutu.dcom.extend.baiduPush.core.model.HttpRestResponse;
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
import com.uhutu.dcom.extend.baiduPush.model.PushRequest;
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
import com.uhutu.dcom.extend.baiduPush.transform.PushRestRequestChecker;
import com.uhutu.dcom.extend.baiduPush.transform.PushRestRequestMapper;
import com.uhutu.dcom.extend.baiduPush.transform.PushRestResponseJsonUnmapper;

public class BaiduPushClient implements BaiduPush {

	private String apiKey = null;

	private String secretKey = null;

	private String host = null;

	private YunLogHttpCallBack logHttpCallback = new YunLogHttpCallBack();

	private PushRestResponseJsonUnmapper responseJsonUnmapper = new PushRestResponseJsonUnmapper();

	public BaiduPushClient(PushKeyPair pair) {
		this(pair, BaiduPushConstants.CHANNEL_REST_URL);
	}

	public BaiduPushClient(PushKeyPair pair, String host) {
		this.apiKey = pair.getApiKey();
		this.secretKey = pair.getSecretKey();
		this.host = host;
	}

    @Override
	public PushMsgToSingleDeviceResponse pushMsgToSingleDevice (
			PushMsgToSingleDeviceRequest request) 
	        throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSPUSH, 
				"single_device", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(),
				resp.getJsonResponse(), new PushMsgToSingleDeviceResponse());
	}

    @Override
	public PushMsgToAllResponse pushMsgToAll (
			PushMsgToAllRequest request) 
	        throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSPUSH, 
				"all", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(),
				resp.getJsonResponse(), new PushMsgToAllResponse());
	}
    
    @Override
    public PushMsgToTagResponse pushMsgToTag (PushMsgToTagRequest request) 
    		throws PushClientException, PushServerException {
    	HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSPUSH,
    			"tags", request);
    	return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(),
    			resp.getJsonResponse(), new PushMsgToTagResponse());
    }
    
    @Override
    public PushMsgToSmartTagResponse pushMsgToSmartTag (PushMsgToSmartTagRequest request) 
    		throws PushClientException, PushServerException {
    	HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSPUSH,
    			"tags", request);
    	return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(),
    			resp.getJsonResponse(), new PushMsgToSmartTagResponse());
    }
    
	@Override
	public PushBatchUniMsgResponse pushBatchUniMsg (PushBatchUniMsgRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSPUSH,
				"batch_device", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new PushBatchUniMsgResponse());
	}
	
	@Override
	public QueryMsgStatusResponse queryMsgStatus (QueryMsgStatusRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSREPORT,
				"query_msg_status", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new QueryMsgStatusResponse());
	}
	
	@Override
	public QueryTimerRecordsResponse queryTimerRecords (QueryTimerRecordsRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSREPORT,
				"query_timer_records", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new QueryTimerRecordsResponse());
	}
	
	@Override
	public QueryTopicRecordsResponse queryTopicRecords (QueryTopicRecordsRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSREPORT,
				"query_topic_records", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new QueryTopicRecordsResponse());
	}
	
	@Override
	public QueryTimerListResponse queryTimerList (QueryTimerListRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSTIMER,
				"query_list", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new QueryTimerListResponse());
	}
	
	@Override
	public QueryTopicListResponse queryTopicList (QueryTopicListRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSTOPIC,
				"query_list", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new QueryTopicListResponse());
	}
	
	@Override
	public QueryTagsResponse queryTags (QueryTagsRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSAPP,
				"query_tags", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new QueryTagsResponse());
	}
	
	@Override
	public CreateTagResponse createTag (CreateTagRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSAPP,
				"create_tag", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new CreateTagResponse());
	}
	
	@Override
	public DeleteTagResponse deleteTag (DeleteTagRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSAPP,
				"del_tag", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new DeleteTagResponse());
	}
	
	@Override
	public AddDevicesToTagResponse addDevicesToTag (AddDevicesToTagRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSTAG,
				"add_devices", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new AddDevicesToTagResponse());
	}
	
	@Override
	public DeleteDevicesFromTagResponse deleteDevicesFromTag (DeleteDevicesFromTagRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSTAG,
				"del_devices", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new DeleteDevicesFromTagResponse());
	}
	
	@Override
	public QueryDeviceNumInTagResponse queryDeviceNumInTag (QueryDeviceNumInTagRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSTAG,
				"device_num", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new QueryDeviceNumInTagResponse());
	}
	

	@Override
	public QueryStatisticMsgResponse queryStatisticMsg (
			QueryStatisticMsgRequest request) throws PushClientException,
			PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSREPORT,
				"statistic_msg", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new QueryStatisticMsgResponse());
	}

	@Override
	public QueryStatisticTopicResponse queryStatisticTopic (
			QueryStatisticTopicRequest request) throws PushClientException,
			PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSREPORT,
				"statistic_topic", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new QueryStatisticTopicResponse());
	}

	@Override
	public QueryStatisticDeviceResponse queryStatisticDevice (
			QueryStatisticDeviceRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSREPORT,
				"statistic_device", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new QueryStatisticDeviceResponse());
	}

	public void setChannelLogHandler(YunLogHandler logHandler) {
		logHttpCallback.setHandler(logHandler);
	}

	// -----------------------------------------------------------

	private HttpRestResponse process(String classType, String method, PushRequest request)
			throws PushClientException, PushServerException {

		PushRestRequestChecker checker = new PushRestRequestChecker();
		checker.validate(request);

		PushRestRequestMapper mapper = new PushRestRequestMapper();
		Map<String, String> params = mapper.marshall(request);
		params.put("apikey", apiKey);

		String surl = obtainIntegrityUrl(classType, method);

		PushSignatureDigest digest = new PushSignatureDigest();
		String sign = digest.digest(BaiduPushConstants.HTTPMETHOD, surl, secretKey, params);
		params.put("sign", sign);
		
		YunHttpClient client = new YunHttpClient();
		client.addHttpCallback(logHttpCallback);
		
		try {
			return client.doExecutePostRequestResponse(surl, params);
		} catch(YunHttpClientException e) {
			throw new PushClientException(e.getMessage());
		}
	}

	private String obtainIntegrityUrl(String classType, String method) {
		String resurl = host;
		if (host.startsWith("http://") || host.startsWith("https://")) {
		} else {
			resurl = "http://" + host;
		}
		if (resurl.endsWith("/")) {
			resurl = resurl + "rest/3.0/";
		} else {
			resurl = resurl + "/rest/3.0/";
		}
		resurl = resurl + classType + "/" + method;
		return resurl;
	}

}
