package com.uhutu.dcom.order.make;

import java.util.List;

import com.uhutu.dcom.order.orderResult.TeslaXOrder;
import com.uhutu.dcom.order.orderResult.TeslaXResult;
import com.uhutu.dcom.order.top.TeslaTopOrderMake;
import com.uhutu.dcom.order.z.entity.OcOrderInfo;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 校验订单
 * 
 * @author xiegj
 *
 */
public class TeslaCheckAnswer extends TeslaTopOrderMake {

	public TeslaXResult doRefresh(TeslaXOrder teslaOrder) {
		TeslaXResult result = new TeslaXResult();

		// 校验此买家是否买过此商品
		List<OcOrderInfo> orderInfos = JdbcHelper.queryForList(OcOrderInfo.class, "", "",
				"buyerCode=:'" + teslaOrder.getOrderInfo().getBuyerCode() + "' and status='dzsd4112100110030002'",
				new MDataMap());
		if (orderInfos.size() > 0) {
			result.setError(TopHelper.upInfo(81120001));
			result.setStatus(81120001);
		}
		return result;
	}

}
