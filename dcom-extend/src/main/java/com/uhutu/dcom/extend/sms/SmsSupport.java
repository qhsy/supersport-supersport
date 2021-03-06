package com.uhutu.dcom.extend.sms;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;
import com.uhutu.dcom.extend.sms.z.entity.CmSendSms;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.helper.FormatHelper;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootClass;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.model.MVerifyCodeGenerate;
import com.uhutu.zooweb.support.VerifyCodeSupport;

/**
 * 短信验证相关
 * 
 */

public class SmsSupport extends RootClass {

	private String url = "";
	private String accountSid = "";
	private String authToken = "";
	private String appId = "";
	private String templateId = "";

	/**
	 * 
	 * @param url
	 *            沙盒环境（用于应用开发调试）：restAPI.init("sandboxapp.cloopen.com");*
	 *            生产环境（用户应用上线使用）：restAPI.init("app.cloopen.com"); *
	 * @param accountSid
	 *            云通信sid
	 * @param authToken
	 *            云通信token
	 * @param appId
	 *            应用编号
	 * @param templateId
	 *            短信模板编号
	 */
	public SmsSupport(String url, String accountSid, String authToken, String appId, String templateId) {
		super();
		this.url = url;
		this.accountSid = accountSid;
		this.authToken = authToken;
		this.appId = appId;
		this.templateId = templateId;
	}

	public SmsSupport() {
		super();
	}

	/**
	 * 获取验证码编号根据类型
	 * 
	 * @param smsTypeEnum
	 * @return
	 */
	public static String smsTypeByEnumer(SmsTypeEnum smsTypeEnum) {

		String sReturn = "";

		switch (smsTypeEnum) {
		case register:
			sReturn = "41070001";
			break;
		case login:
			sReturn = "41070002";
			break;
		case resetpwd:
			sReturn = "41070003";
			break;
		case forgetpwd:
			sReturn = "41070004";
			break;
		case weChatlogin:
			sReturn = "41070005";
			break;	
			
		}

		return sReturn;

	}

	/**
	 * 根据验证类型获取此类型最新的验证码(注：验证码最多验证5次)
	 * 
	 * @param eVerifyCodeTypeEnumer
	 * @param verifyCode
	 * @param sMobile
	 * @return
	 */
	public RootApiResult upLastVerifyCode(SmsTypeEnum smsTypeEnum, String sMobile, String verifyCode) {

		RootApiResult result = new RootApiResult();
		MDataMap mWhereMap = new MDataMap();
		mWhereMap.put("verify_sum", String.valueOf(SmsConst.MAX_VERIFY_CODE_SUM));
		mWhereMap.put("active_time", FormatHelper.upDateTime());
		mWhereMap.put("verify_type", smsTypeByEnumer(smsTypeEnum));
		mWhereMap.put("mobile_phone", sMobile);
		List<CmSendSms> li = JdbcHelper.queryForList(CmSendSms.class, "", "-zc",
				" verify_sum<:verify_sum and flag_verify=0 and active_time>=:active_time and verify_type=:verify_type and mobile_phone=:mobile_phone ",
				mWhereMap);
		String code = "";
		if (li != null && !li.isEmpty() && li.size() > 0) {
			code = li.get(0).getVerifyCode();
		}
		if (!code.equals(verifyCode) && li != null && li.size() > 0) {
			MDataMap updateMap = new MDataMap();
			updateMap.put("verify_sum", String.valueOf(li.get(0).getVerifySum() + 1));
			updateMap.put("zu", new Date().toString());
			updateMap.put("za", li.get(0).getZa());
			JdbcHelper.dataUpdate("cm_send_sms", updateMap, "verify_sum,zu", "za");
			result.setStatus(81090004);
			result.setError(TopHelper.upInfo(81090004));
		} else if (li != null && li.size() > 0) {
			MDataMap updateMap = new MDataMap();
			updateMap.put("flag_verify", "1");
			updateMap.put("zu", new Date().toString());
			updateMap.put("za", li.get(0).getZa());
			JdbcHelper.dataUpdate("cm_send_sms", updateMap, "flag_verify,zu", "za");
		} else if (li == null || li.isEmpty()) {
			result.setStatus(81090004);
			result.setError(TopHelper.upInfo(81090004));
		}
		return result;

	}

	/**
	 * 验证是否要发验证码
	 * 
	 * @param sMobile
	 *            手机号码
	 * @return
	 */
	public RootApiResult checkSendVerifyCode(String sMobile) {
		RootApiResult result = new RootApiResult();
		if (result.getStatus() == 1) {
			// 每个手机号每天只允许最多发送5条短信
			MDataMap pmap = new MDataMap();
			pmap.put("mobile", sMobile);
			List<CmSendSms> li = JdbcHelper.queryForList(CmSendSms.class, "", "", " mobile_phone=:mobile and zc >'"
					+ DateHelper.upDateTimeAdd(SmsConst.DAY_VERIFY_TIME_STEP) + "' and zc<'" + DateHelper.upNow() + "'",
					pmap);
			if (li != null && li.size() >= SmsConst.MAX_VERIFY_CODE_SEND_SUM) {
				result.setStatus(81090002);
				result.setError(TopHelper.upInfo(81090002));
			}
		}
		if (result.getStatus() == 1) {
			// 取出最近的一条30秒内的数据 如果有这样的数据 则返回错误 频率太高
			MDataMap pmap = new MDataMap();
			pmap.put("mobile_phone", sMobile);
			pmap.put("min_time", DateHelper.upDateTimeAdd(SmsConst.MIN_VERIFY_TIME_STEP));
			List<CmSendSms> li = JdbcHelper.queryForList(CmSendSms.class, "", "",
					"mobile_phone=:mobile_phone and zc>:min_time", pmap);
			if (li != null && li.size() > 0) {
				result.setStatus(81090003);
				result.setError(TopHelper.upInfo(81090003));
			}
		}
		return result;
	}

	/**
	 * 发送指定长度验证码 最长10位
	 * 
	 * @param enumer
	 * @param sMobile
	 * @param sMangeCode
	 * @param iLength
	 * @return
	 */
	public RootApiResult sendVerifyCode(String smsType, String sMobile, int iLength, int minutes) {
		RootApiResult result = new RootApiResult();
		result = this.checkSendVerifyCode(sMobile);
		if (result.getStatus() == 1) {
			MVerifyCodeGenerate mVerifyCodeGenerate = new VerifyCodeSupport().upVerifyCode(sMobile, iLength);
			String re = this.sendSms(sMobile, mVerifyCodeGenerate.getVerifyCode(), minutes);
			MDataMap insert = new MDataMap();
			insert.put("verify_type", smsType);
			insert.put("mobile_phone", sMobile);
			insert.put("verify_code", mVerifyCodeGenerate.getVerifyCode());
			insert.put("active_time", DateHelper.upDateTimeAdd(String.valueOf(minutes * 60) + "s"));
			insert.put("flag_send", "1");
			insert.put("send_message", re);
			JdbcHelper.dataInsert("cm_send_sms", insert);
			
			result.setVerifyNumber(mVerifyCodeGenerate.getVerifyNumber());
			
			if(!re.equals("ok")){
				
				result.setError("验证码超出同号码天发送上限");
				result.setStatus(0);
			}
			
		}
		return result;
	}

	/**
	 * 
	 * 验证码异步调用云通信进行发送
	 * 
	 * @param verifyCode
	 * @return
	 */
	private String sendSms(String mobile, String verifyCode, int minutes) {
		String re = "ok";
		// 初始化SDK
		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();

		// ******************************注释*********************************************
		// *初始化服务器地址和端口 *
		// *沙盒环境（用于应用开发调试）：restAPI.init("sandboxapp.cloopen.com", "8883");*
		// *生产环境（用户应用上线使用）：restAPI.init("app.cloopen.com", "8883"); *
		// *******************************************************************************
		restAPI.init(getUrl(), "8883");
		// restAPI.init("app.cloopen.com", "8883");

		// ******************************注释*********************************************
		// *初始化主帐号和主帐号令牌,对应官网开发者主账号下的ACCOUNT SID和AUTH TOKEN *
		// *ACOUNT SID和AUTH TOKEN在登陆官网后，在“应用-管理控制台”中查看开发者主账号获取*
		// *参数顺序：第一个参数是ACOUNT SID，第二个参数是AUTH TOKEN。 *
		// *******************************************************************************
		restAPI.setAccount(getAccountSid(), getAuthToken());

		// ******************************注释*********************************************
		// *初始化应用ID *
		// *测试开发可使用“测试Demo”的APP ID，正式上线需要使用自己创建的应用的App ID *
		// *应用ID的获取：登陆官网，在“应用-应用列表”，点击应用名称，看应用详情获取APP ID*
		// *******************************************************************************
		restAPI.setAppId(getAppId());

		// ******************************注释****************************************************************
		// *调用发送模板短信的接口发送短信 *
		// *参数顺序说明： *
		// *第一个参数:是要发送的手机号码，可以用逗号分隔，一次最多支持100个手机号 *
		// *第二个参数:是模板ID，在平台上创建的短信模板的ID值；测试的时候可以使用系统的默认模板，id为1。 *
		// *系统默认模板的内容为“【云通讯】您使用的是云通讯短信模板，您的验证码是{1}，请于{2}分钟内正确输入”*
		// *第三个参数是要替换的内容数组。 *
		// **************************************************************************************************

		// **************************************举例说明***********************************************************************
		// *假设您用测试Demo的APP ID，则需使用默认模板ID 1，发送手机号是13800000000，传入参数为6532和5，则调用方式为
		// *
		// *result = restAPI.sendTemplateSMS("13800000000","1" ,new
		// String[]{"6532","5"}); *
		// *则13800000000手机号收到的短信内容是：【云通讯】您使用的是云通讯短信模板，您的验证码是6532，请于5分钟内正确输入 *
		// *********************************************************************************************************************
		HashMap<String, Object> result = restAPI.sendTemplateSMS(mobile, getTemplateId(),
				new String[] { verifyCode, String.valueOf(minutes) });
		if (!"000000".equals(result.get("statusCode"))) {
			// 异常返回输出错误码和错误信息
			re = "错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg");
			bLog(81090001, re);
		}
		return re;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAccountSid() {
		return accountSid;
	}

	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

}
