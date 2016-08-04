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
import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiForAskQuestionInput;
import com.uhutu.sportcenter.z.input.ApiWechatH5PayInput;
import com.uhutu.sportcenter.z.input.ApiWechatMobilePayInput;
import com.uhutu.sportcenter.z.result.ApiForAskQuestionResult;
import com.uhutu.sportcenter.z.result.ApiWechatH5PayResult;
import com.uhutu.sportcenter.z.result.ApiWechatMobilePayResult;
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
					initPayResponse(teslaXOrder,result, input);
				}
			} else {
				result.inError(88880007);
			}
		}
		return result;
	}
	
	/**
	 * 初始化支付信息
	 * @param teslaXOrder
	 * @param result
	 * @param input
	 */
	public void initPayResponse(TeslaXOrder teslaXOrder,ApiForAskQuestionResult result,ApiForAskQuestionInput input){
		
		switch (input.getOrderSource()) {
		case "dzsd4112100110020001"://app订单
			initMobilePayInfo(teslaXOrder, result, input);
			break;
		
		case "dzsd4112100110020002"://h5订单
			initH5PayInfo(teslaXOrder, result, input);
			break;

		default:
			break;
		}		
		
	}
	
	/**
	 * 初始化移动支付信息
	 * @param teslaXOrder
	 * @param result
	 * @param input
	 */
	public void initMobilePayInfo(TeslaXOrder teslaXOrder,ApiForAskQuestionResult result,ApiForAskQuestionInput input){
		
		ApiWechatMobilePayInput mobilePayInput = new ApiWechatMobilePayInput();
		mobilePayInput.setOrderCode(teslaXOrder.getOrderInfo().getCode());
		mobilePayInput.setRomoteIP(input.getRomoteIP());
		mobilePayInput.setServeIP(input.getServeIP());
		mobilePayInput.setPayMoney(teslaXOrder.getOrderInfo().getOrderMoney());
		mobilePayInput.setZoo(input.getZoo());
		ApiWechatMobilePayResult payResult = apiFactory.getApiWechatMobilePay().api(mobilePayInput);
		if(payResult.upFlagTrue()){
			result.setWechatMobilePayResponse(payResult.getMobilePayInfo());
		}else {
			result.setStatus(payResult.getStatus());
			result.setError(payResult.getError());
		}
		
	}
	
	/**
	 * h5支付信息
	 * @param teslaXOrder
	 * @param result
	 * @param input
	 */
	public void initH5PayInfo(TeslaXOrder teslaXOrder,ApiForAskQuestionResult result,ApiForAskQuestionInput input){
		
		ApiWechatH5PayInput ai = new ApiWechatH5PayInput();
		ai.setOrderCode(teslaXOrder.getOrderInfo().getCode());
		ai.setRomoteIP(input.getRomoteIP());
		ai.setServeIP(input.getServeIP());
		ai.setPayMoney(teslaXOrder.getOrderInfo().getOrderMoney());
		ai.setZoo(input.getZoo());
		ApiWechatH5PayResult payResult = apiFactory.getApiWechatH5Pay().api(ai);
		if(payResult.upFlagTrue()){
			result.setWechatH5PayResponse(payResult.getWechatH5PayInfo());
		}else {
			result.setStatus(payResult.getStatus());
			result.setError(payResult.getError());
		}
		
		
	}

	

}
