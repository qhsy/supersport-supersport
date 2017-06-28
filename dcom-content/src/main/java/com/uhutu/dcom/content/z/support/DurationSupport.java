package com.uhutu.dcom.content.z.support;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.support.compent.AliYunResponseInfo;
import com.uhutu.zoocom.helper.GsonHelper;
import com.uhutu.zoocom.support.WebClientSupport;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.z.properties.ConfigZooWeb;

public class DurationSupport {

	private static final String AccessKeyId = ConfigZooWeb.upConfig().getUploadOssAccessKeyId();;
	private static final String AccessKeySecret = ConfigZooWeb.upConfig().getUploadOssAccessKeySecret();;
	private final static String ALGORITHM = "HmacSHA1";
	private static final String ISO8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	private static final String ENCODING = "UTF-8";
	private static final String requestURL = "http://mts.cn-hangzhou.aliyuncs.com?";

	/**
	 * 
	 * @param filePath
	 * @return
	 */
	public long getDuration(String za, String videoUrl) {
		long duration = 0;
		if (StringUtils.isNotBlank(videoUrl)) {
			String response = doRequest(videoUrl);
			AliYunResponseInfo responseInfo = new AliYunResponseInfo();
			responseInfo = GsonHelper.fromJson(response, responseInfo);
			if (responseInfo != null && responseInfo.getMediaList() != null
					&& responseInfo.getMediaList().getMedia() != null
					&& !responseInfo.getMediaList().getMedia().isEmpty()) {
				duration = Math.round(Double.valueOf(responseInfo.getMediaList().getMedia().get(0).getDuration()));
				updateBasicInfo(za, duration);
			}
		}
		return duration;
	}

	private void updateBasicInfo(String za, long duration) {
		CnContentBasicinfo basicinfo = new CnContentBasicinfo();
		basicinfo.setZa(za);
		basicinfo.setDuration(duration);
		JdbcHelper.update(basicinfo, "duration", "za");
	}

	private String doRequest(String fileUrl) {
		String result = null;
		final String HTTP_METHOD = "GET";
		Map<String, String> parameters = new HashMap<String, String>();
		// 加入请求参数
		parameters.put("Action", "QueryMediaListByURL");
		parameters.put("Version", "2014-06-18");
		parameters.put("AccessKeyId", AccessKeyId);
		parameters.put("TimeStamp", formatIso8601Date(new Date()));
		parameters.put("SignatureMethod", "HMAC-SHA1");
		parameters.put("SignatureVersion", "1.0");
		parameters.put("SignatureNonce", UUID.randomUUID().toString());
		parameters.put("Format", "json");
		parameters.put("FileURLs", fileUrl);
		parameters.put("IncludePlayList", "true");
		// 对参数进行排序
		String[] sortedKeys = parameters.keySet().toArray(new String[] {});
		Arrays.sort(sortedKeys);
		final String SEPARATOR = "&";
		// 生成stringToSign字符串
		StringBuilder stringToSign = new StringBuilder();
		stringToSign.append(HTTP_METHOD).append(SEPARATOR);
		stringToSign.append(percentEncode("/")).append(SEPARATOR);
		StringBuilder canonicalizedQueryString = new StringBuilder();
		for (String key : sortedKeys) {
			// 这里注意对key和value进行编码
			canonicalizedQueryString.append("&").append(percentEncode(key)).append("=")
					.append(percentEncode(parameters.get(key)));
		}
		// 这里注意对canonicalizedQueryString进行编码
		stringToSign.append(percentEncode(canonicalizedQueryString.toString().substring(1)));

		// 以下是一段计算签名的示例代码
		String key = AccessKeySecret + "&";
		byte[] signData = null;
		try {
			Mac mac = Mac.getInstance(ALGORITHM);
			mac.init(new SecretKeySpec(key.getBytes(ENCODING), ALGORITHM));
			signData = mac.doFinal(stringToSign.toString().getBytes(ENCODING));

			String signature = new String(Base64.encodeBase64(signData));

			StringBuilder requestUrl = new StringBuilder(requestURL);
			requestUrl.append(URLEncoder.encode("Signature", ENCODING)).append("=").append(signature);
			for (Map.Entry<String, String> e : parameters.entrySet()) {
				requestUrl.append("&").append(percentEncode(e.getKey())).append("=")
						.append(percentEncode(e.getValue()));
			}
			result = WebClientSupport.create().doGet(requestUrl.toString());
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private static String formatIso8601Date(Date date) {
		SimpleDateFormat df = new SimpleDateFormat(ISO8601_DATE_FORMAT);
		df.setTimeZone(new SimpleTimeZone(0, "GMT"));
		return df.format(date);
	}

	private static String percentEncode(String value) {
		String result = null;
		try {
			result = value != null
					? URLEncoder.encode(value, ENCODING).replace("+", "%20").replace("*", "%2A").replace("%7E", "~")
					: null;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

}
