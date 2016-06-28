package com.uhutu.dcom.extend.baiduPush.model;

import java.util.LinkedList;
import java.util.List;

import com.uhutu.dcom.extend.baiduPush.core.annotation.JSonPath;

public class QueryTopicListResponse extends PushResponse{

	@JSonPath(path="response_params\\total_num")
	private int totalNum;
	
	@JSonPath(path="response_params\\result")
	private List<TopicResultInfo> topicResultInfos = new LinkedList<TopicResultInfo> ();
	
	// get
	public int getTotalNum () {
		return totalNum;
	}
	public List<TopicResultInfo> getTimerResultInfos () {
		return topicResultInfos;
	}
}
