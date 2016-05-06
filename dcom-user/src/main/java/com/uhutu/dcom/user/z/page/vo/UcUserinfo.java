package com.uhutu.dcom.user.z.page.vo;

import java.util.Date;
import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 用户信息
 * 
 * @author pang_jhui
 *
 */
public class UcUserinfo extends BaseEntity {

	@ZooData(name = "用户编号")
	private String code;

	@ZooData(name = "用户类型")
	private String type;

	@ZooData(name = "登录名称")
	private String loginName;

	@ZooData(name = "登录密码")
	private String loginPwd;

	@ZooData(name = "是否可用")
	private String flag;

	@ZooData(name = "最近登录时间")
	private Date lastTime;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

}
