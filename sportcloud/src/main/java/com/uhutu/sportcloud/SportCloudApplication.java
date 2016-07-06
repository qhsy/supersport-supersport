package com.uhutu.sportcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.uhutu.dcom.answer.z.properties.SettingsDcomAnswer;
import com.uhutu.dcom.extend.z.properties.SettingsDcomExtend;
import com.uhutu.dcom.user.z.properties.SettingsDcomUser;
import com.uhutu.zoocom.root.RootSimpleApplication;

@SpringBootApplication
@EnableConfigurationProperties({ SettingsDcomUser.class, SettingsDcomExtend.class,SettingsDcomAnswer.class })
public class SportCloudApplication extends RootSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportCloudApplication.class, args);
	}
}
