package com.uhutu.dcom.extend.z.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties(SettingsDcomExtend.class)
@PropertySource(value = "classpath:application-dcom-extend.properties")
public class ConfigDcomExtend {

	private static SettingsDcomExtend setting;

	@Autowired
	private void setConfig(SettingsDcomExtend dcomUserettings) {
		setting = dcomUserettings;
	}

	public static SettingsDcomExtend upConfig() {
		return setting;
	}

}
