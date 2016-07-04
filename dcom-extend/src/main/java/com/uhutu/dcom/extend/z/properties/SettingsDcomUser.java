package com.uhutu.dcom.extend.z.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class SettingsDcomUser {
	@Value("${dcom-extend.baidu_push_api_key}")
	private String baiduPushApiKey;

	@Value("${dcom-extend.baidu_push_secret_key}")
	private String baiduPushSecretKey;

	public String getBaiduPushApiKey() {
		return baiduPushApiKey;
	}

	public String getBaiduPushSecretKey() {
		return baiduPushSecretKey;
	}
	
}
