package com.uhutu.dcom.order.make;

/**
 * 订单金额计算
 * 
 */
import com.uhutu.dcom.order.orderResult.TeslaXOrder;
import com.uhutu.dcom.order.orderResult.TeslaXResult;
import com.uhutu.dcom.order.top.TeslaTopOrderMake;
import com.uhutu.zooweb.helper.WebHelper;

public class TeslaAccount extends TeslaTopOrderMake {

	@Override
	public TeslaXResult doRefresh(TeslaXOrder teslaOrder) {
		TeslaXResult result = new TeslaXResult();
		teslaOrder.getOrderInfo().setCode(WebHelper.upCode("OCBH"));
		for (int i = 0; i < teslaOrder.getActivitys().size(); i++) {
			teslaOrder.getActivitys().get(i).setCode(teslaOrder.getOrderInfo().getCode());
		}
		for (int i = 0; i < teslaOrder.getDetail().size(); i++) {
			teslaOrder.getDetail().get(i).setCode(teslaOrder.getOrderInfo().getCode());
			teslaOrder.getOrderInfo().setStatus("dzsd4112100110030001");// 待付款状态
			teslaOrder.getOrderInfo().setOrderMoney(teslaOrder.getOrderInfo().getOrderMoney()
					+ teslaOrder.getDetail().get(i).getProductPrice() * teslaOrder.getDetail().get(i).getNum());
		}
		return result;
	}

}
