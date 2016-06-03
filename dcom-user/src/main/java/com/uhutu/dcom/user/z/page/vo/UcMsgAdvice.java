package com.uhutu.dcom.user.z.page.vo;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 意见反馈
 * 
 * @author 逄小帅
 *
 */
public class UcMsgAdvice extends BaseEntity {

	@ZooData(value = "编号")
	private String code;

	@ZooData(value = "用户昵称",name="用户编号",element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw451010010001" })
	private String userCode;

	@ZooData(value = "反馈内容")
	private String content;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
