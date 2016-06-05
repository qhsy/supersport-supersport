package com.uhutu.sportcenter;

import com.uhutu.zoocom.helper.SecrurityHelper;

public class Test {

	public static void main(String[] args) {
		
		String salt = SecrurityHelper.MD5("38D7A2F32F7B8B2571F9C3E37C933BB9"+"38D7A2F32F7B8B2571F9C3E37C933BB9");	
		
		System.out.println(salt);
		
		
	}

}
