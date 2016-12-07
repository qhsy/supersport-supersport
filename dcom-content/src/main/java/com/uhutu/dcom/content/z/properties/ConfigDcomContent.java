package com.uhutu.dcom.content.z.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties(SettingsDcomContent.class)
@PropertySource(value = "classpath:application-dcom-content.properties")
public class ConfigDcomContent {

	private static SettingsDcomContent setting;

	@Autowired
	private void setConfig(SettingsDcomContent dcomContentSettings) {
		setting = dcomContentSettings;
	}

	public static SettingsDcomContent upConfig() {
		return setting;
	}

}
