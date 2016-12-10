package com.uhutu.dcom.content.z.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class SettingsDcomContent {
	@Value("${dcom-content.live_app_id}")
	private String liveAppId;
	
	@Value("${dcom-content.live_app_watch_constant}")
	private String liveAppWatchConstant;
	
	@Value("${dcom-content.live_app_praise_constant}")
	private String liveAppPraiseConstant;

	public String getLiveAppId() {
		return liveAppId;
	}

	public String getLiveAppWatchConstant() {
		return liveAppWatchConstant;
	}

	public String getLiveAppPraiseConstant() {
		return liveAppPraiseConstant;
	}

}
