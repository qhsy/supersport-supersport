package com.uhutu.sportcenter.z.api.answer;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.order.enumer.ETeslaExec;
import com.uhutu.dcom.order.orderResult.TeslaXOrder;
import com.uhutu.dcom.order.orderResult.TeslaXResult;
import com.uhutu.dcom.order.service.ApiConvertTeslaService;
import com.uhutu.dcom.order.z.entity.OcOrderDetail;
import com.uhutu.dcom.order.z.entity.OcOrderInfo;
import com.uhutu.sportcenter.z.input.ApiForAnswerOrderInput;
import com.uhutu.sportcenter.z.result.ApiForAnswerOrderResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 问答订单更新
 * 
 * @author xiegj
 */
@Service
public class ApiForAnswerOrder extends RootApiToken<ApiForAnswerOrderInput, ApiForAnswerOrderResult> {

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
			result.setOrderMoney(teslaXOrder.getOrderInfo().getOrderMoney());
		}
		return result;
	}
}
