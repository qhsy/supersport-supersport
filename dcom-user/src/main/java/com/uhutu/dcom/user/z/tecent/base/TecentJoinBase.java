package com.uhutu.dcom.user.z.tecent.base;

import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

import com.uhutu.dcom.user.z.properties.ConfigDcomUser;
import com.uhutu.dcom.user.z.properties.SettingsDcomUser;
import com.uhutu.dcom.user.z.support.TecentSigSupport;
import com.uhutu.dcom.user.z.tecent.entity.face.TecnetBaseEntityInterface;
import com.uhutu.dcom.user.z.tecent.helper.JsonHelper;
import com.uhutu.dcom.user.z.tecent.result.TecentResult;
import com.uhutu.zoocom.define.DefineZooCom;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootClass;
import com.uhutu.zoocom.support.WebClientSupport;

/***
 * 腾讯云接入base类
 * 
 * @author Administrator
 *
 */
public class TecentJoinBase extends RootClass {

	private MDataMap getHeader() {
		MDataMap headerDataMap = new MDataMap();
		headerDataMap.put("Content-Type", "text/plain;charset=UTF-8");
		return headerDataMap;
	}

	public TecentResult postTecent(String apiurl, TecnetBaseEntityInterface entity) {
		TecentResult st = new TecentResult();
		WebClientSupport clientSupport = new WebClientSupport();
		SettingsDcomUser settingsDcomUser = ConfigDcomUser.upConfig();
		MDataMap cs = new MDataMap();
		cs.put("contenttype", "json");
		cs.put(settingsDcomUser.getLoginSdkAppidKey(), settingsDcomUser.getLoginSdkAppidValue());
		cs.put(settingsDcomUser.getLoginSdkAdminKey(), settingsDcomUser.getLoginSdkAdminValue());
		cs.put("apn", "1");
		cs.put("usersig", new TecentSigSupport().upSigCodeByUserCode(cs.get("identifier")));
		String url = settingsDcomUser.getLoginSdkUrl() + apiurl + "?" + MapHelper.toUrl(cs);
		HttpEntity httpEntity = new StringEntity(new JsonHelper<TecnetBaseEntityInterface>().GsonToJson(entity),
				DefineZooCom.CONST_BASE_ENCODING);
		try {
			String result = clientSupport.doRequest(url, httpEntity, getHeader());
			st = new JsonHelper<TecentResult>().GsonFromJson(result, st);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}
}
