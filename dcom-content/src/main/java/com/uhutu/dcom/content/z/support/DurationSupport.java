package com.uhutu.dcom.content.z.support;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.InputFormatException;
import it.sauronsoftware.jave.MultimediaInfo;

public class DurationSupport {
	public long getDuration(String filePath) {
		MultimediaInfo m = null;
		File source = null;
		if (StringUtils.isNotBlank(filePath)) {
			try {
				source = getFile(filePath);
				Encoder encoder = new Encoder();
				m = encoder.getInfo(source);
			} catch (InputFormatException e) {
				e.printStackTrace();
			} catch (EncoderException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (source != null) {
					source.delete();
				}
			}
		}
		return m == null ? 0 : (m.getDuration() / 1000);
	}

	private byte[] readInstream(InputStream inputStream) throws Exception {
		ByteArrayOutputStream byteArrayOutPutStream = new ByteArrayOutputStream();// 创建ByteArrayOutputStream类
		byte[] buffer = new byte[1024];// 声明缓存区
		int length = -1;// 定义读取的默认长度
		while ((length = inputStream.read(buffer)) != -1) {
			byteArrayOutPutStream.write(buffer, 0, length);// 把缓存区中的输入到内存中
		}
		;
		byteArrayOutPutStream.close();// 关闭输入流
		inputStream.close();// 关闭输入流

		return byteArrayOutPutStream.toByteArray();// 返回这个输入流的字节数组
	}

	private File getFile(String urlPath) throws Exception {
		File file = null;
		URL url = new URL(urlPath);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setConnectTimeout(6 * 1000);
		if (connection.getResponseCode() == 200) {
			InputStream inputStream = connection.getInputStream();
			byte[] data = readInstream(inputStream);
			file = new File("linshiwenjian");
			FileOutputStream outputStream = new FileOutputStream(file);
			outputStream.write(data);
			outputStream.close();
		}
		return file;
	}
}
