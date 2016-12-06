package com.uhutu.dcom.content.z.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class SettingsDcomContent {
	@Value("${dcom-content.live_app_id}")
	private String liveAppId;

	public String getLiveAppId() {
		return liveAppId;
	}

}
