package com.uhutu.sportcenter.z.api.answer;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.common.AnswerEnum;
import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.order.enumer.ETeslaExec;
import com.uhutu.dcom.order.orderResult.TeslaXOrder;
import com.uhutu.dcom.order.orderResult.TeslaXResult;
import com.uhutu.dcom.order.service.ApiConvertTeslaService;
import com.uhutu.dcom.order.z.entity.OcOrderDetail;
import com.uhutu.dcom.order.z.entity.OcOrderInfo;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.request.WechatMsgAskRequest;
import com.uhutu.dcom.pay.z.response.WechatMsgResponse;
import com.uhutu.dcom.pay.z.util.WechatMsgComponent;
import com.uhutu.dcom.user.z.entity.UcUserinfoSocial;
import com.uhutu.dcom.user.z.entity.UserBasicInfo;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiForAskQuestionInput;
import com.uhutu.sportcenter.z.input.ApiWechatH5PayInput;
import com.uhutu.sportcenter.z.result.ApiForAskQuestionResult;
import com.uhutu.sportcenter.z.result.ApiWechatH5PayResult;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.WebHelper;

/**
 * 提问信息
 *
 */
@Component
public class ApiForAskQuestion extends RootApiToken<ApiForAskQuestionInput, ApiForAskQuestionResult> {
	@Autowired
	private UserInfoSupport userInfoSupport;
	@Autowired
	private WechatMsgComponent wechatMsgCompoent;
	@Autowired
	private ApiFactory apiFactory;

	@Override
	protected ApiForAskQuestionResult process(ApiForAskQuestionInput input) {

		ApiForAskQuestionResult result = new ApiForAskQuestionResult();
		AwQuestionInfo qtInfo = new AwQuestionInfo();
		if (upUserCode().equals(input.getAnswerUserCode())) {
			result.setStatus(88880023);
			result.setError(TopHelper.upInfo(88880023));
		}
		if (result.upFlagTrue()) {
			AwAnswerExpert answerExpert = JdbcHelper.queryOne(AwAnswerExpert.class, "userCode",
					input.getAnswerUserCode());
			if (answerExpert != null && "dzsd4699100110010001".equals(answerExpert.getStatus())) {
				qtInfo.setAnswerUserCode(input.getAnswerUserCode());
				qtInfo.setContent(input.getContent());
				if (StringUtils.isNotEmpty(input.getScope())) {
					boolean scope = Boolean.valueOf(input.getScope());
					qtInfo.setScope(scope ? AnswerEnum.SCOPE_PUBLIC.getCode() : AnswerEnum.SCOPE_PRIVATE.getCode());
				} else {
					qtInfo.setScope(AnswerEnum.SCOPE_PUBLIC.getCode());
				}
				qtInfo.setStatus("dzsd4888100110010006");
				qtInfo.setSellMoney(BigDecimal.valueOf(1));
				qtInfo.setQuestionUserCode(upUserCode());
				qtInfo.setQuestionTime(DateHelper.upNow());
				qtInfo.setMoney(answerExpert.getCharge());
				qtInfo.setCode(WebHelper.upCode("WDBH"));
				JdbcHelper.insert(qtInfo);
				result.setCode(qtInfo.getCode());
				WechatMsgResponse wechatMsgResponse = sendWechatMsg(qtInfo);
				if (!wechatMsgResponse.upFlag()) {
					result.setStatus(0);
					result.setError(wechatMsgResponse.getErrmsg());
				}
				// 订单
				TeslaXOrder teslaXOrder = new TeslaXOrder();
				OcOrderInfo info = new OcOrderInfo();
				info.setBuyerCode(upUserCode());
				info.setOrderSource(input.getOrderSource());
				info.setOrderType("dzsd4112100110010003");
				info.setPayType("dzsd4112100110040002");
				OcOrderDetail detail = new OcOrderDetail();
				detail.setNum(1);
				detail.setProductCode(qtInfo.getCode());
				teslaXOrder.setOrderInfo(info);
				teslaXOrder.getDetail().add(detail);
				teslaXOrder.getStatus().setExecStep(ETeslaExec.Create);
				TeslaXResult reTeslaXResult = new ApiConvertTeslaService().ConvertOrder(teslaXOrder);
				if (!reTeslaXResult.upFlagTrue()) {
					result.setStatus(reTeslaXResult.getStatus());
					result.setError(reTeslaXResult.getError());
				} else {
					ApiWechatH5PayInput ai = new ApiWechatH5PayInput();
					ai.setQuestionCode(teslaXOrder.getOrderInfo().getCode());
					ai.setRomoteIP(input.getRomoteIP());
					ai.setServeIP(input.getServeIP());
					ai.setZoo(input.getZoo());
					ApiWechatH5PayResult payResult = apiFactory.getApiWechatH5Pay().api(ai);
					if(payResult.upFlagTrue()){
						result.setWechatH5PayResponse(payResult.getWechatH5PayInfo());
					}else {
						result.setStatus(payResult.getStatus());
						result.setError(payResult.getError());
					}
				}
			} else {
				result.inError(88880007);
			}
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

		WechatMsgAskRequest askRequest = new WechatMsgAskRequest();

		UserBasicInfo userBasicInfo = userInfoSupport.getUserBasicInfo(questionInfo.getQuestionUserCode());

		UcUserinfoSocial answerSocial = userInfoSupport.getUserInfoSocial(questionInfo.getAnswerUserCode());

		askRequest.getFirst().setValue(TopHelper.upInfo(88880015, userBasicInfo.getUcUserinfoExt().getNickName()));

		askRequest.getKeyword1().setValue(questionInfo.getContent());

		askRequest.getKeyword2().setValue(AnswerEnum.praseText(questionInfo.getScope()));

		askRequest.getKeyword3().setValue(questionInfo.getQuestionTime());

		askRequest.getRemark().setValue(TopHelper.upInfo(88880016, questionInfo.getMoney().setScale(2).toString()));

		return wechatMsgCompoent.sendMsg(answerSocial.getAccountId(), "", PayProcessEnum.WECHAT_MSG_ASK, askRequest);

	}

}
