package com.uhutu.sportcenter.z.api.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.order.enumer.ETeslaExec;
import com.uhutu.dcom.order.orderResult.TeslaXOrder;
import com.uhutu.dcom.order.orderResult.TeslaXResult;
import com.uhutu.dcom.order.service.ApiConvertTeslaService;
import com.uhutu.dcom.order.z.entity.OcOrderDetail;
import com.uhutu.dcom.order.z.entity.OcOrderInfo;
import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiForAnswerOrderInput;
import com.uhutu.sportcenter.z.input.ApiWechatH5PayInput;
import com.uhutu.sportcenter.z.input.ApiWechatMobilePayInput;
import com.uhutu.sportcenter.z.result.ApiForAnswerOrderResult;
import com.uhutu.sportcenter.z.result.ApiWechatH5PayResult;
import com.uhutu.sportcenter.z.result.ApiWechatMobilePayResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 问答订单更新
 * 
 * @author xiegj
 */
@Service
public class ApiForAnswerOrder extends RootApiToken<ApiForAnswerOrderInput, ApiForAnswerOrderResult> {
	@Autowired
	private ApiFactory apiFactory;
	protected ApiForAnswerOrderResult process(ApiForAnswerOrderInput input) {
		ApiForAnswerOrderResult result = new ApiForAnswerOrderResult();
		TeslaXOrder teslaXOrder = new TeslaXOrder();
		OcOrderInfo info = new OcOrderInfo();
		info.setAppVersion(input.getAppVersion());
		info.setBuyerCode(upUserCode());
		info.setOrderSource(input.getOrderSource());
		info.setOrderType(input.getOrderType());
		info.setPayType(input.getPayType());
		OcOrderDetail detail = new OcOrderDetail();
		detail.setNum(1);
		detail.setProductCode(input.getAnswerCode());
		teslaXOrder.setOrderInfo(info);
		teslaXOrder.getDetail().add(detail);
		teslaXOrder.getStatus().setExecStep(ETeslaExec.Create);
		TeslaXResult reTeslaXResult = new ApiConvertTeslaService().ConvertOrder(teslaXOrder);
		if (!reTeslaXResult.upFlagTrue()) {
			result.setStatus(reTeslaXResult.getStatus());
			result.setError(reTeslaXResult.getError());
		} else {
			
			initPayResponse(teslaXOrder, result, input);
			
		}
		return result;
	}
	
	
	/**
	 * 初始化支付信息
	 * @param teslaXOrder
	 * @param result
	 * @param input
	 */
	public void initPayResponse(TeslaXOrder teslaXOrder,ApiForAnswerOrderResult result,ApiForAnswerOrderInput input){
		
		switch (teslaXOrder.getOrderInfo().getOrderSource()) {
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
	public void initMobilePayInfo(TeslaXOrder teslaXOrder,ApiForAnswerOrderResult result,ApiForAnswerOrderInput input){
		
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
	public void initH5PayInfo(TeslaXOrder teslaXOrder,ApiForAnswerOrderResult result,ApiForAnswerOrderInput input){
		
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
