package com.uhutu.dcom.content.z.support.compent;

import java.util.ArrayList;
import java.util.List;

public class TecentChatRoomResponse {

	private String ActionStatus;
	private String ErrorCode;
	private String GroupId;
	private String ErrorInfo;
	List<TecentChatRoomAddMemberresponse> MemberList = new ArrayList<TecentChatRoomAddMemberresponse>();

	public String getActionStatus() {
		return ActionStatus;
	}

	public void setActionStatus(String actionStatus) {
		ActionStatus = actionStatus;
	}

	public String getErrorInfo() {
		return ErrorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		ErrorInfo = errorInfo;
	}

	public String getErrorCode() {
		return ErrorCode;
	}

	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}

	public String getGroupId() {
		return GroupId;
	}

	public void setGroupId(String groupId) {
		GroupId = groupId;
	}

	public List<TecentChatRoomAddMemberresponse> getMemberList() {
		return MemberList;
	}

	public void setMemberList(List<TecentChatRoomAddMemberresponse> memberList) {
		MemberList = memberList;
	}

}
