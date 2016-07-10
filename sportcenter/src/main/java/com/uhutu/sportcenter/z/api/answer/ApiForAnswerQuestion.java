package com.uhutu.sportcenter.z.api.answer;

import java.io.ByteArrayOutputStream;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.answer.z.service.AnswerServiceFactory;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.process.impl.PayGateProcess;
import com.uhutu.dcom.pay.z.request.WechatMsgAnswerRequest;
import com.uhutu.dcom.pay.z.response.WechatAccessTokenResponse;
import com.uhutu.dcom.pay.z.response.WechatMsgResponse;
import com.uhutu.dcom.pay.z.util.WechatMsgComponent;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.entity.UcUserinfoSocial;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.input.ApiForAnswerQuestionInput;
import com.uhutu.sportcenter.z.result.ApiForAnswerQuestionResult;
import com.uhutu.zoocom.file.FileUploadResult;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoocom.support.WebClientSupport;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.support.WebUploadSupport;

/**
 * 回答问达信息
 *
 */
@Component
public class ApiForAnswerQuestion extends RootApiToken<ApiForAnswerQuestionInput, ApiForAnswerQuestionResult> {

	@Autowired
	private UserInfoSupport userInfoSupport;

	@Autowired
	private WechatMsgComponent wechatMsgCompoent;

	@Autowired
	private AnswerServiceFactory answerServiceFactory;

	@Autowired
	private PayGateProcess payGateProcess;

	@Override
	protected ApiForAnswerQuestionResult process(ApiForAnswerQuestionInput input) {

		ApiForAnswerQuestionResult result = new ApiForAnswerQuestionResult();
		AwQuestionInfo qtInfo = answerServiceFactory.getQuestionInfoService().queryByCode(input.getCode());
		if (StringUtils.isNoneBlank(input.getWechatVoiceId())) {
			input.setUrl(getWechatVoiceUrl(input.getWechatVoiceId()));
		}
		if (qtInfo != null) {
			qtInfo.setAnswerTime(DateHelper.upNow());
			qtInfo.setCode(input.getCode());
			if (input.isRefuse()) {
				qtInfo.setStatus("dzsd4888100110010003");
			} else {
				qtInfo.setStatus("dzsd4888100110010002");
				qtInfo.setLengh(input.getLengh());
				qtInfo.setUrl(input.getUrl());
				WechatMsgResponse wechatMsgResponse = sendWechatMsg(qtInfo);
				if (!wechatMsgResponse.upFlag()) {
					result.setStatus(0);
					result.setError(wechatMsgResponse.getErrmsg());
				}
			}
			if (result.upFlagTrue()) {
				JdbcHelper.update(qtInfo, "status,length,url", "code");
			}
		} else {
			result.inError(88880022);
		}
		return result;
	}

	/**
	 * 发送微信消息
	 * 
	 * @param questionInfo
	 *            问题信息
	 * @return 信息响应
	 */
	public WechatMsgResponse sendWechatMsg(AwQuestionInfo questionInfo) {

		WechatMsgAnswerRequest answerRequest = new WechatMsgAnswerRequest();

		UcUserinfoExt ucUserinfoExt = userInfoSupport.getUserInfoExt(upUserCode());

		UcUserinfoSocial ucUserinfoSocial = userInfoSupport.getUserInfoSocial(questionInfo.getQuestionUserCode());

		answerRequest.getFirst().setValue(TopHelper.upInfo(88880019, ucUserinfoExt.getNickName()));

		answerRequest.getKeyword1().setValue(ucUserinfoExt.getNickName());

		answerRequest.getKeyword2().setValue(questionInfo.getAnswerTime());

		answerRequest.getKeyword3().setValue(TopHelper.upInfo(88880020, questionInfo.getLengh()));

		answerRequest.getRemark().setValue(TopHelper.upInfo(88880021));

		return wechatMsgCompoent.sendMsg(ucUserinfoSocial.getAccountId(), "", PayProcessEnum.WECHAT_MSG_ASK,
				answerRequest);

	}

	private String getWechatVoiceUrl(String wechatVoiceId) {
		String voiceUrl = "";
		FileUploadResult webUploadResult = new FileUploadResult();
		WechatAccessTokenResponse tokenResponse = (WechatAccessTokenResponse) payGateProcess
				.process(PayProcessEnum.WECHAT_TOKEN, null, new MDataMap());
		String name = TopHelper.upUuid() + ".mp3";
		try {
			HttpEntity resEntity = WebClientSupport.create()
					.upEntity("http://file.api.weixin.qq.com/cgi-bin/media/get?access_token="
							+ tokenResponse.getAccess_token() + "&media_id=" + wechatVoiceId);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] bytes = new byte[1024];
			int count = 0;
			while ((count = resEntity.getContent().read(bytes)) != -1) {
				bos.write(bytes, 0, count);
			}
			webUploadResult = new WebUploadSupport().remoteUpload("wenda", name, bos.toByteArray());
			if (webUploadResult.upFlagTrue()) {
				voiceUrl = webUploadResult.getFileUrl();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return voiceUrl;
	}

}
