package com.uhutu.dcom.order.service;

import com.uhutu.dcom.order.orderResult.TeslaXOrder;
import com.uhutu.dcom.order.orderResult.TeslaXResult;
import com.uhutu.dcom.order.periodOrder.TeslaPeriodOrder;
import com.uhutu.zoocom.root.RootClass;

/**
 * 转换输入类
 * 
 * @author srnpr
 *
 */
public class ApiConvertTeslaService extends RootClass {

	public TeslaXResult ConvertOrder(TeslaXOrder teslaXOrder) {

		TeslaXResult reTeslaXResult = new TeslaXResult();

		reTeslaXResult = new TeslaPeriodOrder().doRefresh(teslaXOrder);

		return reTeslaXResult;

	}

}
