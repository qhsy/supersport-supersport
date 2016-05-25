package com.uhutu.dcom.component.z.util;

import java.util.Random;

/**
 * 简单随机数生成
 * @author 逄小帅
 *
 */
public class RandomUtil {
	
	private final static String NUM_CHAR = "0123456789";
	
	/**
	 * 生成指定长度的随机数
	 * @param digit
	 * 		长度
	 * @return 随机数
	 */
	public static String randomNumber(int digit){
		
		long seed = System.currentTimeMillis();
		
		StringBuffer buffer = new StringBuffer();
		
		Random random = new Random(seed);
		
		for(int i = 0;i < digit; i++){
			
			int index = random.nextInt(10);
			
			buffer.append(NUM_CHAR.charAt(index));
			
		}
		
		return buffer.toString();
		
	}

}
