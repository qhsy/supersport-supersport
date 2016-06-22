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

}
