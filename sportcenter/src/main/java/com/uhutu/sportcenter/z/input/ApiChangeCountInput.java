package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 改变直播数量
 * @author 逄小帅
 *
 */
public class ApiChangeCountInput extends RootApiInput {
	
	@ApiModelProperty(value="主播用户编号")
	private String userCode;
	
	@ApiModelProperty(value="1:修改点赞数量")
	private int type;
	
	@ApiModelProperty(value="0:增加 1:减少")
	private int optype;
	
	@ApiModelProperty(value="0:直播 1:点播")
	private int flag;
	
	@ApiModelProperty(value="点播的情况下使用，用于区分是哪个视频")
	private String fileId;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getOptype() {
		return optype;
	}

	public void setOptype(int optype) {
		this.optype = optype;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

}
