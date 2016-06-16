package com.uhutu.dcom.pay.z.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties
@PropertySource("classpath:application-pay.properties")
public class PayConfigInit {
	
}
