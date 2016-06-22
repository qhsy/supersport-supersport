package com.uhutu.dcom.user.z.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties(SettingsDcomUser.class)
@PropertySource(value = "classpath:application-dcom-user.properties")
public class ConfigDcomUser {

	private static SettingsDcomUser setting;

	@Autowired
	private void setConfig(SettingsDcomUser dcomUserettings) {
		setting = dcomUserettings;
	}

	public static SettingsDcomUser upConfig() {
		return setting;
	}

}
