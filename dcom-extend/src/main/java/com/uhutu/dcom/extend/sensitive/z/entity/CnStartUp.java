package com.uhutu.dcom.extend.sensitive.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 启动页接口
 * 
 * @author xiegj
 *
 */
@Entity
public class CnStartUp extends BaseEntity {

	@ApiModelProperty(name = "启动图编号", notes = "启动图编号")
	@ZooData(name = "启动图编号", inc = DefineWebInc.Insert_Code + "=QDTBH", sort = { DefineWebPage.Page_Add + "=1",
			DefineWebPage.Page_Edit + "=0" })
	private String code;

	@ApiModelProperty(name = "启动图", notes = "启动图")
	@ZooData(name = "启动图", element = DefineWebElement.Upload, require = "1", sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" })
	private String cover;

	@ApiModelProperty(name = "开始时间", notes = "开始时间")
	@ZooData(name = "开始时间", element = DefineWebElement.Datehms, require = "1", sort = {
			DefineWebPage.Page_Query + "=0" })
	private String startTime;

	@ApiModelProperty(name = "结束时间", notes = "结束时间")
	@ZooData(name = "结束时间", element = DefineWebElement.Datehms, require = "1", sort = {
			DefineWebPage.Page_Query + "=0" })
	private String endTime;

	@ApiModelProperty(name = "跳转链接", notes = "跳转链接")
	@ZooData(name = "跳转链接", sort = { DefineWebPage.Page_Query + "=0" })
	private String jumpUrl;

	@ApiModelProperty(name = "停留时间(秒)", notes = "停留时间(秒)")
	@ZooData(name = "停留时间(秒)", require = "1", verify = { DefineWebVerify.Base_Number })
	private int stayTime;

	@ApiModelProperty(name = "倒计时是否显示", notes = "倒计时是否显示")
	@ZooData(name = "倒计时是否显示", element = DefineWebElement.Select, inc = { DefineWebInc.System_Define + "=10" })
	private String showStatus;

	@ZooData(name = "备注", element = DefineWebElement.Textarea, sort = { DefineWebPage.Page_Query + "=0" })
	private String remark;

	@ZooData(name = "随机数", element = DefineWebElement.Input, sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Add + "=0", DefineWebPage.Page_Edit + "=1", DefineWebPage.Page_Grid + "=0" })
	private String randomNum;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getJumpUrl() {
		return jumpUrl;
	}

	public void setJumpUrl(String jumpUrl) {
		this.jumpUrl = jumpUrl;
	}

	public int getStayTime() {
		return stayTime;
	}

	public void setStayTime(int stayTime) {
		this.stayTime = stayTime;
	}

	public String getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(String showStatus) {
		this.showStatus = showStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRandomNum() {
		return randomNum;
	}

	public void setRandomNum(String randomNum) {
		this.randomNum = randomNum;
	}

}
