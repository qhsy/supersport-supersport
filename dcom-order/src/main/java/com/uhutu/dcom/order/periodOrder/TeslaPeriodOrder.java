package com.uhutu.dcom.order.periodOrder;

import com.uhutu.dcom.order.enumer.ETeslaExec;
import com.uhutu.dcom.order.make.TeslaAccount;
import com.uhutu.dcom.order.make.TeslaCheckAnswerActivity;
import com.uhutu.dcom.order.make.TeslaSaveOrder;
import com.uhutu.dcom.order.orderFace.ITeslaOrder;
import com.uhutu.dcom.order.orderResult.TeslaXOrder;
import com.uhutu.dcom.order.orderResult.TeslaXResult;
import com.uhutu.zoocom.root.RootClass;

public class TeslaPeriodOrder extends RootClass implements ITeslaOrder {

	// 前置校验信息
	private final ITeslaOrder teslaCheckAnswer = new TeslaCheckAnswerActivity();

	// 校验活动信息
	private final ITeslaOrder teslaCheckAnswerActivity = new TeslaCheckAnswerActivity();

	// 合计订单金额
	private final ITeslaOrder teslaAccount = new TeslaAccount();

	// 保存订单信息
	private final ITeslaOrder teslaSaveOrder = new TeslaSaveOrder();

	public TeslaXResult doRefresh(TeslaXOrder teslaOrder) {

		TeslaXResult result = new TeslaXResult();

		// 订单创建
		if (teslaOrder.getStatus().getExecStep() == ETeslaExec.Create) {

			result = orderProcss(teslaOrder, teslaCheckAnswer, teslaCheckAnswerActivity, teslaAccount, teslaSaveOrder);

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
