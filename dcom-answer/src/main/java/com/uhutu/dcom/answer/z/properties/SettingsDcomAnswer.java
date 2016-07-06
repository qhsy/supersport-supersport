package com.uhutu.dcom.answer.z.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class SettingsDcomAnswer {
	@Value("${dcom-answer.video_show}")
	private String answerVideoShow;

	public String getAnswerVideoShow() {
		return answerVideoShow;
	}

}
