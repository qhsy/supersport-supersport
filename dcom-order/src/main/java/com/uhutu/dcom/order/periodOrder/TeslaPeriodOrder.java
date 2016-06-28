package com.uhutu.dcom.order.periodOrder;

import com.uhutu.dcom.order.enumer.ETeslaExec;
import com.uhutu.dcom.order.make.TeslaCheckActivity;
import com.uhutu.dcom.order.orderFace.ITeslaOrder;
import com.uhutu.dcom.order.orderResult.TeslaXOrder;
import com.uhutu.dcom.order.orderResult.TeslaXResult;
import com.uhutu.zoocom.root.RootClass;

public class TeslaPeriodOrder extends RootClass implements ITeslaOrder {

	// 校验登录信息
	private final ITeslaOrder teslaCheckActivity = new TeslaCheckActivity();

	public TeslaXResult doRefresh(TeslaXOrder teslaOrder) {

		TeslaXResult result = new TeslaXResult();

		// 订单确认
		if (teslaOrder.getStatus().getExecStep() == ETeslaExec.Confirm) {

			result = orderProcss(teslaOrder, teslaCheckActivity);

		}
		// 订单创建
		else if (teslaOrder.getStatus().getExecStep() == ETeslaExec.Create) {

			result = orderProcss(teslaOrder, teslaCheckActivity);

		}

		return result;
	}

	/**
	 * 订单处理方法
	 * 
	 * @param teslaOrder
	 * @param iOrders
	 * @return
	 */
	private TeslaXResult orderProcss(TeslaXOrder teslaOrder, ITeslaOrder... iOrders) {

		TeslaXResult result = new TeslaXResult();

		for (ITeslaOrder iTeslaOrder : iOrders) {
			TeslaXResult teslaXResult = iTeslaOrder.doRefresh(teslaOrder);
			if (teslaXResult.upFlagTrue()) {

			} else {
				result = teslaXResult;
				break;
			}

		}

		return result;
	}

}
