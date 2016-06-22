package com.uhutu.dcom.user.z.support;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.user.z.entity.UcSigInfo;
import com.uhutu.dcom.user.z.properties.ConfigDcomUser;
import com.uhutu.dcom.user.z.properties.SettingsDcomUser;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;

public class TecentSigSupport {

	/**
	 * 插入授权表并返回授权编码
	 * 
	 * @param sLoginCode
	 * @param sUserCode
	 * @return
	 */
	private String insertSigCode(String sUserCode) {
		String sig = null;
		try {
			SettingsDcomUser settingsDcomUser = ConfigDcomUser.upConfig();
			sig = tls_sigature.GenTLSSignatureEx(Integer.valueOf(settingsDcomUser.getTlsSkdAppid()), sUserCode,
					settingsDcomUser.getTlsPrivateKey(),
					Integer.valueOf(settingsDcomUser.getTlsExpireTime()) * 3600 * 24).urlSig;
			UcSigInfo ucSigInfo = new UcSigInfo();
			ucSigInfo.setSig(sig);
			ucSigInfo.setUserCode(sUserCode);
			ucSigInfo.setExpireTime(DateHelper.upDateTimeAdd(settingsDcomUser.getTlsExpireTime() + "d"));
			JdbcHelper.insert(ucSigInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sig;
	}

	/**
	 * 更新授权表并返回授权编码
	 * 
	 * @param sLoginCode
	 * @param sUserCode
	 * @return
	 */
	private String updateSigCode(UcSigInfo info) {
		String sig = null;
		try {
			SettingsDcomUser settingsDcomUser = ConfigDcomUser.upConfig();
			sig = tls_sigature.GenTLSSignatureEx(Integer.valueOf(settingsDcomUser.getTlsSkdAppid()),
					settingsDcomUser.getTlsTecentAdmin(), settingsDcomUser.getTlsPrivateKey(),
					Integer.valueOf(settingsDcomUser.getTlsExpireTime()) * 3600 * 24).urlSig;
			info.setSig(sig);
			info.setExpireTime(DateHelper.upDateTimeAdd(settingsDcomUser.getTlsExpireTime() + "d"));
			JdbcHelper.update(info, "sig,expireTime", "za");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sig;
	}

	/**
	 * 获取用户编号 根据授权编码
	 * 
	 * @param sAuthToken
	 * @return
	 */
	public String upSigCodeByUserCode(String userCode) {

		String sig = "";

		// 判断是否校验通过
		if (StringUtils.isNotBlank(userCode)) {

			UcSigInfo ucSigInfo = JdbcHelper.queryOne(UcSigInfo.class, "userCode", userCode);
			// 判断是否存在
			if (ucSigInfo != null) {
				// 判断是否过期
				if (DateHelper.parseDate(ucSigInfo.getExpireTime()).after(new Date())) {
					sig = ucSigInfo.getSig();
				} else {
					sig = this.updateSigCode(ucSigInfo);
				}
			} else {
				sig = this.insertSigCode(userCode);
			}
		}

		return sig;

	}

}
