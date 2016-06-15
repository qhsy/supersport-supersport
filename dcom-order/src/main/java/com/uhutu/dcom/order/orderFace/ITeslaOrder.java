package com.uhutu.dcom.order.orderFace;

import com.uhutu.dcom.order.orderResult.TeslaXOrder;
import com.uhutu.dcom.order.orderResult.TeslaXResult;

/**
 * 订单统一处理接口
 * 
 * @author srnpr	
 *
 */
public interface ITeslaOrder {

	public TeslaXResult doRefresh(TeslaXOrder teslaOrder);

}
