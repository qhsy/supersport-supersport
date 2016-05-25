package com.uhutu.dcom.component.z.util;

import java.io.ByteArrayOutputStream;
import org.apache.http.HttpEntity;

import com.uhutu.zoocom.file.FileUploadResult;
import com.uhutu.zoocom.support.WebClientSupport;
import com.uhutu.zooweb.support.WebUploadSupport;

/**
 * 文件工具类
 * @author 逄小帅
 *
 */
public class FileUtil {
	
	/**
	 * 阿里云转本地文件服务器
	 * @param fileName
	 * 		自定义文件名称（须加扩展名）
	 * @param url
	 * 		阿里云图像url
	 * @throws Exception
	 */
	public String aliyunConvert(String fileName,String url) throws Exception{
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		HttpEntity httpEntity = WebClientSupport.create().upEntity(url);

		byte[] bytes = new byte[1024];

		int count = 0;

		while ((count = httpEntity.getContent().read(bytes)) != -1) {

			bos.write(bytes, 0, count);

		}
		
		WebUploadSupport support = new WebUploadSupport();
		
		FileUploadResult result = support.remoteUpload("zoofile", fileName, bos.toByteArray());
		
		return result.getFileUrl();
		
	}

}
