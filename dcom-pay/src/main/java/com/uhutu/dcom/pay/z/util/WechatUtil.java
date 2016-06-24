package com.uhutu.dcom.pay.z.util;

import java.util.Random;
import com.uhutu.dcom.pay.z.common.Constants;

/**
 * 微信工具类
 * @author 逄小帅
 *
 */
public class WechatUtil {
	
	/**
	 * 获取随机字符串
	 * @return 随机字符串
	 */
	public static String getNonceStr() {
		
		Random random = new Random();
		
		return MD5.sign(String.valueOf(random.nextInt(10000)), Constants.CHARSET_UTF8);
		
	}

	/**
	 * 获取时间戳
	 * @return
	 */
	public static String getTimeStamp() {
		
		return String.valueOf(System.currentTimeMillis() / 1000);
		
	}
}
