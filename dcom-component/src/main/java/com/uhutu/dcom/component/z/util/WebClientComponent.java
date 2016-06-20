package com.uhutu.dcom.component.z.util;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.support.WebClientSupport;

/**
 * http请求解析
 * @author 逄小帅
 *
 */
public class WebClientComponent {
	
	/**
	 * xml请求
	 * @param url
	 * 		请求路径
	 * @param xmlStr
	 * 		xml字符串
	 * @return 响应信息
	 * @throws Exception
	 */
	public static String doXmpRequest(String url, String xmlStr) throws Exception {

		MDataMap headerDataMap = new MDataMap();

		headerDataMap.put("Pragma:", "no-cache");

		headerDataMap.put("Cache-Control", "no-cache");

		headerDataMap.put("Content-Type", ContentType.TEXT_XML.getMimeType());
		
		HttpEntity httpEntity = new StringEntity(xmlStr);
		
		return WebClientSupport.create().poolRequest(url, httpEntity, headerDataMap);

	}

}
