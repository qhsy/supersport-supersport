package com.uhutu.dcom.answer.z.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties(SettingsDcomAnswer.class)
@PropertySource(value = "classpath:application-dcom-answer.properties")
public class ConfigDcomAnswer {

	private static SettingsDcomAnswer setting;

	@Autowired
	private void setConfig(SettingsDcomAnswer dcomUserettings) {
		setting = dcomUserettings;
	}

	public static SettingsDcomAnswer upConfig() {
		return setting;
	}

}
