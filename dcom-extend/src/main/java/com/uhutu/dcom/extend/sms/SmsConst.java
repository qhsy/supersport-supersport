package com.uhutu.dcom.extend.sms;

public class SmsConst {

	/**
	 * 验证码最多输入错误次数
	 */
	public final static int MAX_VERIFY_CODE_SUM = 5;

	/**
	 * 验证码每天最多发送次数
	 */
	public final static int MAX_VERIFY_CODE_SEND_SUM = 5;

	/**
	 * 验证码最短发送时间间隔
	 */
	public final static String MIN_VERIFY_TIME_STEP = "-60s";

	/**
	 * 验证码每天时间间隔
	 */
	public final static String DAY_VERIFY_TIME_STEP = "-24h";

}
