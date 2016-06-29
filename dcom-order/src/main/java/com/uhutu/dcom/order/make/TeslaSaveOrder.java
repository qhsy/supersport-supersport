package com.uhutu.dcom.order.make;

import com.uhutu.dcom.order.orderResult.TeslaXOrder;
import com.uhutu.dcom.order.orderResult.TeslaXResult;
import com.uhutu.dcom.order.top.TeslaTopOrderMake;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 保存订单
 * 
 * @author xiegj
 *
 */
public class TeslaSaveOrder extends TeslaTopOrderMake {

	public TeslaXResult doRefresh(TeslaXOrder teslaOrder) {
		TeslaXResult result = new TeslaXResult();
		JdbcHelper.insert(teslaOrder.getOrderInfo());
		for (int i = 0; i < teslaOrder.getDetail().size(); i++) {
			JdbcHelper.insert(teslaOrder.getDetail().get(i));
		}
		for (int i = 0; i < teslaOrder.getActivitys().size(); i++) {
			JdbcHelper.insert(teslaOrder.getActivitys().get(i));
		}
		return result;
	}

}
