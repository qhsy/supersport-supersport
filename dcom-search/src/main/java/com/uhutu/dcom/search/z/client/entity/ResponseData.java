package com.uhutu.dcom.search.z.client.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 响应信息
 * @author 逄小帅
 *
 */
public class ResponseData {
	
	/*执行结果*/
	private String status;
	
	/*查询记录id*/
	private String request_id;

	/*实际返回结果*/
	private ResponseResult result;
	
	/*错误信息*/
	private List<ResponseError> errors = new ArrayList<ResponseError>();

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRequest_id() {
		return request_id;
	}

	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}

	public ResponseResult getResult() {
		return result;
	}

	public void setResult(ResponseResult result) {
		this.result = result;
	}

	public List<ResponseError> getErrors() {
		return errors;
	}

	public void setErrors(List<ResponseError> errors) {
		this.errors = errors;
	}

}
