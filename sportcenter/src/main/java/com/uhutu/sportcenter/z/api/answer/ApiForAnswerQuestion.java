package com.uhutu.sportcenter.z.api.answer;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.common.AnswerEnum;
import com.uhutu.dcom.answer.z.entity.AwAnswerRefundJob;
import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.answer.z.service.AnswerServiceFactory;
import com.uhutu.dcom.answer.z.support.AnswerMsgSupport;
import com.uhutu.dcom.config.enums.SocialEnum;
import com.uhutu.dcom.order.z.entity.OcOrderInfo;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.process.impl.PayGateProcess;
import com.uhutu.dcom.pay.z.response.WechatAccessTokenResponse;
import com.uhutu.dcom.pay.z.response.WechatMsgResponse;
import com.uhutu.dcom.user.z.entity.UcUserinfoSocial;
import com.uhutu.sportcenter.z.input.ApiForAnswerQuestionInput;
import com.uhutu.sportcenter.z.result.ApiForAnswerQuestionResult;
import com.uhutu.zoocom.face.IKvCall;
import com.uhutu.zoocom.file.FileUploadResult;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoocom.support.WebClientSupport;
import com.uhutu.zoocom.z.helper.KvHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.WebHelper;
import com.uhutu.zooweb.support.WebUploadSupport;

/**
 * 回答问达信息
 *
 */
@Component
public class ApiForAnswerQuestion extends RootApiToken<ApiForAnswerQuestionInput, ApiForAnswerQuestionResult> {

	@Autowired
	private AnswerServiceFactory answerServiceFactory;
	
	@Autowired
	private AnswerMsgSupport answerMsgSupport;

	@Autowired
	private PayGateProcess payGateProcess;

	@Override
	protected ApiForAnswerQuestionResult process(ApiForAnswerQuestionInput input) {

		ApiForAnswerQuestionResult result = new ApiForAnswerQuestionResult();
		AwQuestionInfo qtInfo = answerServiceFactory.getQuestionInfoService().queryByCode(input.getCode());
		if (StringUtils.isNotBlank(input.getWechatVoiceId())) {

			String key = AnswerEnum.REDIS_AUDIO.getText() + input.getCode();

			IKvCall redisMediaId = KvHelper.upFactory(key);

			if (!redisMediaId.exists(key)) {

				redisMediaId.set(key, input.getWechatVoiceId());

				redisMediaId.expire(key, Integer.valueOf(AnswerEnum.REDIS_AUDIO.getCode()));

			}

			input.setUrl(getWechatVoiceUrl(input.getWechatVoiceId()));
		}
		if (qtInfo != null) {
			qtInfo.setAnswerTime(DateHelper.upNow());
			qtInfo.setCode(input.getCode());
			if (input.isRefuse()) {
				qtInfo.setStatus("dzsd4888100110010003");
				sentToRefund(qtInfo);
				answerMsgSupport.sendRefuseMsg(qtInfo, upUserCode(), input.getRequestUrl());
			} else {
				qtInfo.setStatus("dzsd4888100110010002");
				qtInfo.setLengh(input.getLengh());
				qtInfo.setUrl(input.getUrl());
				WechatMsgResponse wechatMsgResponse = answerMsgSupport.sendAnswerMsg(qtInfo, upUserCode(), input.getRequestUrl());
				if (wechatMsgResponse != null && !wechatMsgResponse.upFlag()) {
					result.setStatus(0);
					result.setError(wechatMsgResponse.getErrmsg());
				}
			}
			if (result.upFlagTrue()) {
				JdbcHelper.update(qtInfo, "answerTime,status,lengh,url", "code");
			}
		} else {
			result.inError(88880022);
		}
		return result;
	}


	private String getWechatVoiceUrl(String wechatVoiceId) {
		String voiceUrl = "";
		FileUploadResult webUploadResult = new FileUploadResult();
		WechatAccessTokenResponse tokenResponse = (WechatAccessTokenResponse) payGateProcess
				.process(PayProcessEnum.WECHAT_TOKEN, null, new MDataMap());
		String name = TopHelper.upUuid() + ".amr";
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

	// 拒绝回答后生成退款任务
	private void sentToRefund(AwQuestionInfo qtInfo) {
		MDataMap wh = new MDataMap();
		wh.put("product_code", qtInfo.getCode());
		wh.put("seller_code", qtInfo.getAnswerUserCode());
		wh.put("buyer_code", qtInfo.getQuestionUserCode());
		OcOrderInfo orderInfo = JdbcHelper.queryOne(OcOrderInfo.class, "", "",
				"code in (select code from oc_order_detail where product_code=:product_code) "
						+ "and order_type='dzsd4112100110010003' and seller_code=:seller_code and buyer_code=:buyer_code",
				wh);
		if (JdbcHelper.queryOne(AwAnswerRefundJob.class, "order_code",
				orderInfo != null && StringUtils.isNotBlank(orderInfo.getCode()) ? orderInfo.getCode()
						: qtInfo.getCode()) == null) {
			AwAnswerRefundJob job = new AwAnswerRefundJob();
			job.setOrderCode(orderInfo != null && StringUtils.isNotBlank(orderInfo.getCode()) ? orderInfo.getCode()
					: qtInfo.getCode());
			job.setQuestionCode(qtInfo.getCode());
			job.setType("dzsd4888100110040002");// 拒绝回答
			job.setCode(WebHelper.upCode("TK"));
			job.setCreateTime(DateHelper.upNow());
			job.setAmount(qtInfo.getMoney());
			job.setAlAmount(BigDecimal.ZERO);
			job.setRemark("达人拒绝回答，退款处理");
			job.setStatus("0");
			job.setUnAmount(BigDecimal.ZERO);
			job.setUserCode(qtInfo.getQuestionUserCode());
			UcUserinfoSocial us = JdbcHelper.queryOne(UcUserinfoSocial.class, "user_code", qtInfo.getQuestionUserCode(),
					"account_type", SocialEnum.wechat.name());
			if (us != null && StringUtils.isNotBlank(us.getAccountId())) {
				job.setWechatOpenId(us.getAccountId());
				JdbcHelper.insert(job);
			} else {
				// 没有微信登录的发邮件通知运营处理
			}
		}
	}
	
	

}
