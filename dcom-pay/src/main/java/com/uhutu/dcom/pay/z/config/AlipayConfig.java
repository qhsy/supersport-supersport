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
	
	/*商户私钥*/
	@Value("${alipay_private_key}")
	private String privateKey;
	
	/*支付宝公钥*/
	@Value("${alipay_public_key}")
	private String publickey;
	
	/*接口名称*/
	@Value("${alipay_service}")
	private String service;
	
	/*商户编号*/
	@Value("${alipay_partner_id}")
	private String partnerId;
	
	/*参数编码*/
	@Value("${alipay_input_charset}")
	private String inputCharset;
	
	/*签名类型*/
	@Value("${alipay_sign_type}")
	private String signType;
	
	/*支付宝通知路径*/
	@Value("${alipay_notify_url}")
	private String notifyUrl;
	
	/*支付类型*/
	@Value("${alipay_payment_type}")
	private String paymentType;

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

	public String getPaymentType() {
		return paymentType;
	}
	
	
	
}
