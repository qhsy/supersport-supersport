package com.uhutu.sportcenter.z.api.answer;

import java.io.ByteArrayOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.process.impl.PayGateProcess;
import com.uhutu.dcom.pay.z.response.WechatAccessTokenResponse;
import com.uhutu.sportcenter.z.input.ApiSaveWechatVoiceInput;
import com.uhutu.sportcenter.z.result.ApiSaveWechatVoiceResult;
import com.uhutu.zoocom.file.FileUploadResult;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoocom.support.WebClientSupport;
import com.uhutu.zooweb.support.WebUploadSupport;

/**
 * 获取微信语音信息
 * 
 * @author xiegj
 *
 */
@Component
public class ApiSaveWechatVoice extends RootApiToken<ApiSaveWechatVoiceInput, ApiSaveWechatVoiceResult> {

	@Autowired
	private PayGateProcess payGateProcess;

	@Override
	protected ApiSaveWechatVoiceResult process(ApiSaveWechatVoiceInput input) {
		FileUploadResult webUploadResult = new FileUploadResult();
		ApiSaveWechatVoiceResult result = new ApiSaveWechatVoiceResult();
		WechatAccessTokenResponse tokenResponse = (WechatAccessTokenResponse) payGateProcess
				.process(PayProcessEnum.WECHAT_TOKEN, null, new MDataMap());
		String name = TopHelper.upUuid();
		if (StringUtils.isBlank(tokenResponse.getAccess_token())) {
		}
		try {
			HttpEntity resEntity = WebClientSupport.create()
					.upEntity("http://file.api.weixin.qq.com/cgi-bin/media/get?access_token="
							+ tokenResponse.getAccess_token()
							+ "&media_id=70Wm0FGPQATdkjITCS5icSbD0qhx5gQg72ft_-Y4hKo3hPA2HuFIkx2ZFwgL2L9q");
			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			byte[] bytes = new byte[1024];

			int count = 0;

			while ((count = resEntity.getContent().read(bytes)) != -1) {

				bos.write(bytes, 0, count);

			}

			webUploadResult = new WebUploadSupport().remoteUpload("wenda", name, bytes);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

}
