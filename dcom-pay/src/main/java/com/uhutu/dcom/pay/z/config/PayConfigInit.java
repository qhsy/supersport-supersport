package com.uhutu.dcom.pay.z.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 支付属性文件初始化
 * @author 逄小帅
 *
 */
@Configuration
@EnableConfigurationProperties
@PropertySource("classpath:application-pay.properties")
public class PayConfigInit {
	
}
