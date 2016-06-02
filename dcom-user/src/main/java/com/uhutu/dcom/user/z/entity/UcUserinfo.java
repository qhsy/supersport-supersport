package com.uhutu.dcom.user.z.entity;

import java.util.Date;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 用户信息
 * 
 * @author pang_jhui
 *
 */
@Entity
public class UcUserinfo extends BaseEntity {

	@ZooData(name = "用户编号", sort = { DefineWebPage.Page_Add + "=0" })
	private String code;

	@ZooData(name = "用户类型", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd410710031001" }, sort = { DefineWebPage.Page_Query + "=0",
					DefineWebPage.Page_Edit + "=0", DefineWebPage.Page_Add + "=0" })
	private String type;

	@ZooData(name = "登录账号", require = "1", verify = DefineWebVerify.Base_Phone)
	private String loginName;

	@ZooData(name = "登录密码", require = "1", verify = DefineWebVerify.Base_Password, sort = {
			DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	private String loginPwd;

	@ZooData(name = "状态", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd410710041001" }, sort = { DefineWebPage.Page_Add + "=0" })
	private String flag;

	@ZooData(name = "最近登录时间", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0",
			DefineWebPage.Page_Add + "=0" })
	private Date lastTime;

	@ZooData(name = "登录编号", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0",
			DefineWebPage.Page_Add + "=0" })
	private String loginCode;

	/**
	 * 获取用户编号
	 * 
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置用户编号
	 * 
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获取登录名称
	 * 
	 * @return
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * 设置登录名称
	 * 
	 * @param loginName
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * 设置登录密码
	 * 
	 * @return
	 */
	public String getLoginPwd() {
		return loginPwd;
	}

	/**
	 * 设置登录密码
	 * 
	 * @param loginPwd
	 */
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	/**
	 * 获取是否可用
	 * 
	 * @return
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * 设置是否可用
	 * 
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	/**
	 * 获取用户类型
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置用户类型
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String getLoginCode() {
		return loginCode;
	}

	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}

}
