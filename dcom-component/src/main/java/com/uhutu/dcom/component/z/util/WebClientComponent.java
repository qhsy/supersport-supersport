package com.uhutu.dcom.component.z.util;

import java.io.ByteArrayOutputStream;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uhutu.dcom.component.z.entity.WechatMediaResponse;
import com.uhutu.zoocom.file.FileUploadResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.support.WebClientSupport;
import com.uhutu.zooweb.support.WebUploadSupport;

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
	
	/**
	 * 下载微信上传的多媒体文件，并上传到远程服务器
	 * @param sUploadType
	 * 		上传类型
	 * @param accessToken
	 * 		微信接口token
	 * @param mediaId
	 * 		jssdk上传后的媒体标识
	 * @return 上传结果
	 */
	public static FileUploadResult wechatMediaDownLoad(String sUploadType, String accessToken, String mediaId) {

		FileUploadResult webUploadResult = new FileUploadResult();

		try {

			HttpResponse response = doResponse("http://file.api.weixin.qq.com/cgi-bin/media/get?access_token="
					+ accessToken + "&media_id=" + mediaId);
			
			String fileName = getFileName(response);

			HttpEntity resEntity = response.getEntity();

			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			byte[] bytes = new byte[1024];

			int count = 0;

			while ((count = resEntity.getContent().read(bytes)) != -1) {
				bos.write(bytes, 0, count);
			}

			webUploadResult = new WebUploadSupport().remoteUpload(sUploadType, fileName, bytes);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return webUploadResult;

	}
	
	/**
	 * 获取响应信息
	 * @param sUrl
	 * 		请求路径
	 * @return
	 * 		返回响应信息
	 * @throws Exception
	 */
	public static HttpResponse doResponse(String sUrl) throws Exception {

		HttpClientBuilder hClientBuilder = HttpClientBuilder.create();

		CloseableHttpClient httpclient = hClientBuilder.build();

		HttpGet httpGet = new HttpGet(sUrl);

		httpGet.setHeader("Connection", "close");

		HttpResponse response = null;

		try {

			response = httpclient.execute(httpGet);

		} catch (Exception e) {
			httpGet.reset();
			httpclient = null;
			e.printStackTrace();
			throw e;

		} finally {

			httpclient = null;

		}

		return response;

	}
	
	/**
	 * 获取response header中Content-Disposition中的filename值
	 * 
	 * @param response
	 * 		响应信息
	 * @return 文件名称
	 */
	public static String getFileName(HttpResponse response) {
		
		Header contentHeader = response.getFirstHeader("Content-Disposition");
		
		String filename = null;
		
		if (contentHeader != null) {
			
			HeaderElement[] values = contentHeader.getElements();
			
			if (values.length == 1) {
				
				NameValuePair param = values[0].getParameterByName("filename");
				
				if (param != null) {

					filename = param.getValue();

				}
			}
		}
		return filename;
	}

}
