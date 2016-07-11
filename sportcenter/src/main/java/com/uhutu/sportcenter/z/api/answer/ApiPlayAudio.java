package com.uhutu.sportcenter.z.api.answer;

import java.io.ByteArrayOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.common.AnswerEnum;
import com.uhutu.dcom.component.z.common.WechatMediaEnum;
import com.uhutu.dcom.component.z.entity.WechatMediaResponse;
import com.uhutu.dcom.component.z.util.WebClientComponent;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.process.impl.PayGateProcess;
import com.uhutu.dcom.pay.z.response.WechatAccessTokenResponse;
import com.uhutu.sportcenter.z.input.ApiPlayAudioInput;
import com.uhutu.sportcenter.z.result.ApiPlayAudioResult;
import com.uhutu.zoocom.face.IKvCall;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoocom.support.WebClientSupport;
import com.uhutu.zoocom.z.helper.KvHelper;

/**
 * 音频播放
 * @author 逄小帅
 *
 */
@Component
public class ApiPlayAudio extends RootApiBase<ApiPlayAudioInput, ApiPlayAudioResult> {
	
	@Autowired
	private PayGateProcess payGateProcess;

	@Override
	protected ApiPlayAudioResult process(ApiPlayAudioInput input) {
		
		ApiPlayAudioResult result = new ApiPlayAudioResult();
		
		try {
			
			String mediaId = getMediaId(input.getQuestionCode(), input.getAudioUrl());
			
			result.setMediaId(mediaId);
			
		} catch (Exception e) {
			
			result.setStatus(0);
			
			result.setError(e.getMessage());
			
		}
		
		return result;
	}
	
	public String getMediaId(String questionCode, String url) throws Exception {

		String key = AnswerEnum.REDIS_AUDIO.getText() + questionCode;

		IKvCall redisMediaId = KvHelper.upFactory(key);

		String mediaId = "";

		if (redisMediaId.exists(key) && redisMediaId.ttl(key) > 0) {

			mediaId = redisMediaId.get(key);

		} else {

			mediaId = "";

		}

		if (StringUtils.isEmpty(mediaId)) {

			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			HttpEntity httpEntity = WebClientSupport.create().upEntity(url);

			byte[] bytes = new byte[1024];

			int count = 0;

			while ((count = httpEntity.getContent().read(bytes)) != -1) {

				bos.write(bytes, 0, count);

			}

			WechatAccessTokenResponse accessTokenResponse = (WechatAccessTokenResponse) payGateProcess
					.process(PayProcessEnum.WECHAT_TOKEN, null, new MDataMap());

			String sFileName = TopHelper.upUuid() + ".amr";

			WechatMediaResponse wechatMediaResponse = WebClientComponent.wechatMediaUpload(sFileName,
					WechatMediaEnum.voice.name(), accessTokenResponse.getAccess_token(), bos.toByteArray());
			
			mediaId = wechatMediaResponse.getMedia_id();
			
			redisMediaId.set(key, mediaId);
			
			/*提前十分钟*/
			
			redisMediaId.expire(key, Integer.valueOf(AnswerEnum.REDIS_AUDIO.getCode()));

		}

		return mediaId;

	}

}