package com.uhutu.dcom.extend.sms.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 短信验证码信息
 * @author 逄小帅
 *
 */
@Entity
public class CmSendSms extends BaseEntity {
	
	@ZooData(name="验证类型")
	private String verifyType;
	
	@ZooData(name="手机号码")
	private String mobilePhone;
	
	@ZooData(name="验证码")
	private String verifyCode;
	
	@ZooData(name="是否以验证")
	@Column(columnDefinition="int default 0")
	private int flagVerify;
	
	@ZooData(name="有效时间")
	private String activeTime;
	
	@ZooData(name="验证次数")
	@Column(columnDefinition="int default 0")
	private int verifySum;
	
	@ZooData(name="是否已经发送")
	@Column(columnDefinition="int default 0")
	private int flagSend;
	
	@ZooData(name="发送日志")
	private String sendMessage;

	public String getVerifyType() {
		return verifyType;
	}

	public void setVerifyType(String verifyType) {
		this.verifyType = verifyType;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(String activeTime) {
		this.activeTime = activeTime;
	}

	public String getSendMessage() {
		return sendMessage;
	}

	public void setSendMessage(String sendMessage) {
		this.sendMessage = sendMessage;
	}

	public int getFlagVerify() {
		return flagVerify;
	}

	public void setFlagVerify(int flagVerify) {
		this.flagVerify = flagVerify;
	}

	public int getVerifySum() {
		return verifySum;
	}

	public void setVerifySum(int verifySum) {
		this.verifySum = verifySum;
	}

	public int getFlagSend() {
		return flagSend;
	}

	public void setFlagSend(int flagSend) {
		this.flagSend = flagSend;
	}
}
