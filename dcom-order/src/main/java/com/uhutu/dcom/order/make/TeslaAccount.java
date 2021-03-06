package com.uhutu.dcom.order.make;

import java.math.BigDecimal;

/**
 * 订单金额计算
 * 
 */
import com.uhutu.dcom.order.orderResult.TeslaXOrder;
import com.uhutu.dcom.order.orderResult.TeslaXResult;
import com.uhutu.dcom.order.top.TeslaTopOrderMake;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.WebHelper;

public class TeslaAccount extends TeslaTopOrderMake {

	@Override
	public TeslaXResult doRefresh(TeslaXOrder teslaOrder) {
		TeslaXResult result = new TeslaXResult();
		teslaOrder.getOrderInfo().setCode(WebHelper.upCode("OTBH"));
		for (int i = 0; i < teslaOrder.getActivitys().size(); i++) {
			teslaOrder.getActivitys().get(i).setCode(teslaOrder.getOrderInfo().getCode());
		}
		for (int i = 0; i < teslaOrder.getDetail().size(); i++) {
			teslaOrder.getDetail().get(i).setCode(teslaOrder.getOrderInfo().getCode());
			teslaOrder.getOrderInfo().setStatus("dzsd4112100110030001");// 待付款状态
			teslaOrder.getOrderInfo().setOrderMoney(teslaOrder.getOrderInfo().getOrderMoney() == null ? BigDecimal.ZERO
					: teslaOrder.getOrderInfo().getOrderMoney());
			teslaOrder.getOrderInfo().setOrderMoney(teslaOrder.getOrderInfo().getOrderMoney().add(teslaOrder.getDetail()
					.get(i).getProductPrice().multiply(BigDecimal.valueOf(teslaOrder.getDetail().get(i).getNum()))));
			if (teslaOrder.getOrderInfo().getOrderMoney().compareTo(BigDecimal.ZERO) == 0) {
				teslaOrder.getOrderInfo().setStatus("dzsd4112100110030002");// 0元订单直接付款完成状态
			}
			teslaOrder.getOrderInfo().setPayedMoney(BigDecimal.ZERO);
		}
		if ("dzsd4112100110010005".equals(teslaOrder.getOrderInfo().getOrderType())) {
			for (int i = 0; i < teslaOrder.getSigns().size(); i++) {
				JdbcHelper.insert(teslaOrder.getSigns().get(i));
			}
		}
		return result;
	}

}
