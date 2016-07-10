package com.uhutu.dcom.component.z.util;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uhutu.dcom.component.z.entity.WechatMediaResponse;
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
	
	/**
	 * 获取请求链接
	 * 
	 * @param sUrl
	 * @param sPost
	 * @return
	 */
	public static String upRequest(String sUrl, String sPost) throws Exception {

		StringEntity httpEntity = null;

		try {
			
			httpEntity = new StringEntity(sPost,"UTF-8");
			
			httpEntity.setContentType("application/json");
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		return WebClientSupport.create().doRequest(sUrl, httpEntity);

	}
	

	/**
	 * 微信多多媒体上传接口
	 * @param sFileName
	 * 		文件名称
	 * @param type
	 * 		上传文件类型
	 * @param accessToken
	 * 		接口调用token
	 * @param bytes
	 * 		文件字节码
	 * @return 微信响应信息
	 */
	public static WechatMediaResponse  wechatMediaUpload(String sFileName,String type,String accessToken, byte[] bytes) {

		WechatMediaResponse fileUploadResult = new WechatMediaResponse();

		String sUrl = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token="+accessToken+"&type="+type;
				
		MultipartEntityBuilder mb = MultipartEntityBuilder.create();

		mb.addBinaryBody("media", bytes, ContentType.MULTIPART_FORM_DATA, sFileName);

		String sReturnString;
		try {
			sReturnString = new WebClientSupport().doRequest(sUrl, mb.build());

			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.setSerializationInclusion(Include.NON_NULL);

			fileUploadResult = objectMapper.readValue(sReturnString, WechatMediaResponse.class);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileUploadResult;

	}

}
