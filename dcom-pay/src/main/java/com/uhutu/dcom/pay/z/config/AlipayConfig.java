package com.uhutu.dcom.pay.z.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.pay.z.face.IPayConfig;

/**
 * 支付宝配置信息
 * @author pang_jhui
 *
 */
@Component
public class AlipayConfig implements IPayConfig{
	
	@Value("${alipay_private_key}")
	private String privateKey;
	
	@Value("${alipay_public_key}")
	private String publickey;
	
	@Value("${alipay_service}")
	private String service;
	
	@Value("${alipay_service}")
	private String partnerId;
	
	@Value("${alipay_input_charset}")
	private String inputCharset;
	
	@Value("${alipay_sign_type}")
	private String signType;
	
	@Value("${alipay_notify_url}")
	private String notifyUrl;

	/**
	 * 获取商户加密私钥
	 * @return 私钥
	 */
	public String getPrivateKey() {
		return privateKey;
	}

	/**
	 * 获取支付宝公钥
	 * @return 公钥
	 */
	public String getPublickey() {
		return publickey;
	}

	/**
	 * 获取接口名称
	 * @return
	 */
	public String getService() {
		return service;
	}

	/**
	 * 获取合作者身份标识
	 * @return
	 */
	public String getPartnerId() {
		return partnerId;
	}

	/**
	 * 获取参数编码
	 * @return
	 */
	public String getInputCharset() {
		return inputCharset;
	}

	/**
	 * 获取签名类型
	 * @return
	 */
	public String getSignType() {
		return signType;
	}

	/**
	 * 获取服务器通知路径
	 * @return
	 */
	public String getNotifyUrl() {
		return notifyUrl;
	}
	
	
	
}
