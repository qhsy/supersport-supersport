package com.uhutu.sportcenter.z.api.answer;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.activity.z.entity.AcActivityAnswerInfo;
import com.uhutu.dcom.activity.z.support.AnswerActivitySupport;
import com.uhutu.dcom.answer.z.common.AnswerEnum;
import com.uhutu.dcom.answer.z.entity.AwAnswerListen;
import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.component.z.common.WechatMediaEnum;
import com.uhutu.dcom.component.z.entity.WechatMediaResponse;
import com.uhutu.dcom.component.z.util.WebClientComponent;
import com.uhutu.dcom.order.enumer.ETeslaExec;
import com.uhutu.dcom.order.orderResult.TeslaXOrder;
import com.uhutu.dcom.order.orderResult.TeslaXResult;
import com.uhutu.dcom.order.service.ApiConvertTeslaService;
import com.uhutu.dcom.order.z.entity.OcOrderDetail;
import com.uhutu.dcom.order.z.entity.OcOrderInfo;
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
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 音频播放
 * 
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

			updateListen(input.getQuestionCode(), input.getListenUserCode());
			createZeroOrder(input.getListenUserCode(), input.getQuestionCode(), input.getOrderSource());
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

			/* 提前十分钟 */

			redisMediaId.expire(key, Integer.valueOf(AnswerEnum.REDIS_AUDIO.getCode()));

		}

		return mediaId;

	}

	/**
	 * 更新偷听信息
	 * 
	 * @param questionCode
	 *            问题编号
	 */
	public void updateListen(String questionCode, String listenUserCode) {

		AwQuestionInfo questionInfo = JdbcHelper.queryOne(AwQuestionInfo.class, "code", questionCode);

		if (questionInfo != null) {

			/* 偷听人不是问题提问人，算偷偷听 */
			if (!StringUtils.equals(listenUserCode, questionInfo.getQuestionUserCode())
					&& !StringUtils.equals(listenUserCode, questionInfo.getAnswerUserCode())) {

				AwAnswerListen answerListen = JdbcHelper.queryOne(AwAnswerListen.class, "userCode", listenUserCode,
						"questionCode", questionCode);

				if (answerListen == null) {

					long listen = questionInfo.getListen() + 1;

					questionInfo.setListen(listen);

					JdbcHelper.update(questionInfo, "listen", "code");

					answerListen = new AwAnswerListen();

					answerListen.setQuestionCode(questionCode);

					answerListen.setUserCode(listenUserCode);

					JdbcHelper.insert(answerListen);

				}

			}

		}

	}

	public void createZeroOrder(String buyerCode, String questionCode, String orderSource) {
		AwQuestionInfo questionInfo = JdbcHelper.queryOne(AwQuestionInfo.class, "code", questionCode);
		if (questionInfo != null && !questionInfo.getQuestionUserCode().equals(buyerCode)
				&& !questionInfo.getAnswerUserCode().equals(buyerCode)) {
			MDataMap orMap = new MDataMap();
			orMap.put("buyercode", buyerCode);
			orMap.put("sellercode", questionInfo.getQuestionUserCode());
			orMap.put("status", "dzsd4112100110030002");
			orMap.put("productcode", questionInfo.getCode());
			OcOrderInfo orderInfo = JdbcHelper.queryOne(OcOrderInfo.class, "", "",
					"buyer_code=:buyercode and seller_code=:sellercode and status=:status and code in (select code from oc_order_detail where product_code=:productcode)",
					orMap);
			AcActivityAnswerInfo activity = new AnswerActivitySupport().getActivityInfoByAnswerCode(questionCode);
			if (orderInfo == null && activity != null && BigDecimal.ZERO.compareTo(activity.getPrice()) == 0) {// 没下过订单且当前参加0元免费听活动
				TeslaXOrder teslaXOrder = new TeslaXOrder();
				OcOrderInfo info = new OcOrderInfo();
				info.setBuyerCode(buyerCode);
				info.setOrderSource(orderSource);
				info.setOrderType("dzsd4112100110010004");
				info.setPayType("dzsd4112100110040002");
				OcOrderDetail detail = new OcOrderDetail();
				detail.setNum(1);
				detail.setProductCode(questionCode);
				teslaXOrder.setOrderInfo(info);
				teslaXOrder.getDetail().add(detail);
				teslaXOrder.getStatus().setExecStep(ETeslaExec.Create);
				new ApiConvertTeslaService().ConvertOrder(teslaXOrder);
			}
		}
	}

}
