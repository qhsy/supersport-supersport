package com.uhutu.dcom.pay.z.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.pay.z.common.Constants;
import com.uhutu.zoocom.model.MDataMap;

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
	
	/**
	 * 参数字符连接
	 * @param paramMap
	 * 		参数集合
	 * @param spilt1
	 * 		分割符1
	 * @param split2
	 * 		分割符2
	 * @return 链接后的字符串
	 */
	public static String conact(MDataMap paramMap,String spilt1,String split2){
		
		Enumeration<String> keys = paramMap.keys();
		
		List<String> paramList = new ArrayList<String>();
		
		while (keys.hasMoreElements()) {
			
			String key = keys.nextElement();
			
			String value = paramMap.get(key);
			
			paramList.add(key+spilt1+value);
			
		}
		
		return StringUtils.join(paramList, split2);
		
	}
	
}
