package com.uhutu.dcom.pay.z.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 支付宝配置信息
 * @author pang_jhui
 *
 */
@Component
public class AlipayConfig{
	
	@Value("${alipay_public_key}")
	private String privateKey;

	public String getPrivateKey() {
		return privateKey;
	}
	
	
	
}
