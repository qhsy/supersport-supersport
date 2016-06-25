package com.uhutu.dcom.user.z.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class SettingsDcomUser {
	@Value("${dcom-user.tls_private_key}")
	private String tlsPrivateKey;

	@Value("${dcom-user.tls_tecent_admin}")
	private String tlsTecentAdmin;

	@Value("${dcom-user.tls_skd_appid}")
	private String tlsSkdAppid;

	@Value("${dcom-user.tls_expire_time}")
	private String tlsExpireTime;

	@Value("${dcom-user.login_sdk_appid_key}")
	private String loginSdkAppidKey;

	@Value("${dcom-user.login_sdk_appid_value}")
	private String loginSdkAppidValue;

	@Value("${dcom-user.login_sdk_admin_key}")
	private String loginSdkAdminKey;

	@Value("${dcom-user.login_sdk_admin_value}")
	private String loginSdkAdminValue;

	@Value("${dcom-user.login_sdk_url}")
	private String loginSdkUrl;

	@Value("${dcom-user.login_sdk_account_import}")
	private String loginSdkAccountImport;

	@Value("${dcom-user.login_sdk_sendmsg}")
	private String loginSdkSendmsg;

	public String getTlsPrivateKey() {
		return tlsPrivateKey;
	}

	public String getTlsTecentAdmin() {
		return tlsTecentAdmin;
	}

	public String getTlsSkdAppid() {
		return tlsSkdAppid;
	}

	public String getTlsExpireTime() {
		return tlsExpireTime;
	}

	public String getLoginSdkAppidKey() {
		return loginSdkAppidKey;
	}

	public String getLoginSdkAppidValue() {
		return loginSdkAppidValue;
	}

	public String getLoginSdkAdminKey() {
		return loginSdkAdminKey;
	}

	public String getLoginSdkAdminValue() {
		return loginSdkAdminValue;
	}

	public String getLoginSdkUrl() {
		return loginSdkUrl;
	}

	public String getLoginSdkAccountImport() {
		return loginSdkAccountImport;
	}

	public String getLoginSdkSendmsg() {
		return loginSdkSendmsg;
	}

}
