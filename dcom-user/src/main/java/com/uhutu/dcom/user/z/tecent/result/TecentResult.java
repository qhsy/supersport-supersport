package com.uhutu.dcom.user.z.tecent.result;

/**
 * 腾讯云返回结果对象
 * 
 * @author Administrator
 *
 */
public class TecentResult {

	private String ActionStatus = "";

	private String ErrorInfo = "";

	private int ErrorCode = 0;

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

	public int getErrorCode() {
		return ErrorCode;
	}

	public void setErrorCode(int errorCode) {
		ErrorCode = errorCode;
	}

}
