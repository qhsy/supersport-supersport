package com.uhutu.dcom.user.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 一对一push和站内信
 * 
 * @author xiegj
 *
 */
@Entity
public class UcMsgNoticePush extends BaseEntity {

	@ApiModelProperty(name = "编号", notes = "编号")
	@ZooData(name = "编号", inc = DefineWebInc.Insert_Code + "=PUNOBH", sort = { DefineWebPage.Page_Add + "=1",
			DefineWebPage.Page_Edit + "=0" })
	private String code;

	@ZooData(value = "接收人", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw451010010005" }, require = "1")
	private String userCode;

	@ZooData(value = "站内信", element = DefineWebElement.Textarea, sort = { DefineWebPage.Page_Query + "=0" })
	private String content;

	@ZooData(value = "Android推送内容", element = DefineWebElement.Textarea, sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" })
	private String androidContent;

	@ZooData(value = "IOS推送内容", element = DefineWebElement.Textarea, sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" })
	private String iosContent;

	@ZooData(value = "站内信次数", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Add + "=0",
			DefineWebPage.Page_Edit + "=0" })
	private int num;

	@ZooData(value = "推送次数", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Add + "=0",
			DefineWebPage.Page_Edit + "=0" })
	private int pushNum;

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

	public String getAndroidContent() {
		return androidContent;
	}

	public void setAndroidContent(String androidContent) {
		this.androidContent = androidContent;
	}

	public String getIosContent() {
		return iosContent;
	}

	public void setIosContent(String iosContent) {
		this.iosContent = iosContent;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPushNum() {
		return pushNum;
	}

	public void setPushNum(int pushNum) {
		this.pushNum = pushNum;
	}
}
