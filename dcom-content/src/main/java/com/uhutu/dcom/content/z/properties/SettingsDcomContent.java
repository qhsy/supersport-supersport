package com.uhutu.dcom.content.z.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class SettingsDcomContent {
	@Value("${dcom-content.live_app_id}")
	private String liveAppId;
	
	@Value("${dcom-content.live_biz_id}")
	private String livebizId;
	
	@Value("${dcom-content.live_check_key}")
	private String liveCheckKey;
	
	@Value("${dcom-content.live_api_key}")
	private String liveApiKey;
	
	@Value("${dcom-content.live_expiration_time}")
	private String liveExpirationTime;
	
	@Value("${dcom-content.live_app_watch_constant}")
	private String liveAppWatchConstant;
	
	@Value("${dcom-content.live_app_praise_constant}")
	private String liveAppPraiseConstant;

	@Value("${dcom-content.nearby_distance}")
	private String nearbyDistance;
	
	
	public String getNearbyDistance() {
		return nearbyDistance;
	}

	public String getLiveAppId() {
		return liveAppId;
	}

	public String getLiveExpirationTime() {
		return liveExpirationTime;
	}

	public String getLiveAppWatchConstant() {
		return liveAppWatchConstant;
	}

	public String getLiveAppPraiseConstant() {
		return liveAppPraiseConstant;
	}

	public String getLivebizId() {
		return livebizId;
	}

	public String getLiveCheckKey() {
		return liveCheckKey;
	}

	public String getLiveApiKey() {
		return liveApiKey;
	}

}
