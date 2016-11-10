package com.uhutu.dcom.order.make;

import java.math.BigDecimal;

import com.uhutu.dcom.order.orderResult.TeslaXOrder;
import com.uhutu.dcom.order.orderResult.TeslaXResult;
import com.uhutu.dcom.order.top.TeslaTopOrderMake;

/**
 * 校验问答活动
 * 
 * @author xiegj
 *
 */
public class TeslaThrowDownActivity extends TeslaTopOrderMake {

	public TeslaXResult doRefresh(TeslaXOrder teslaOrder) {
		TeslaXResult result = new TeslaXResult();
		if ("dzsd4112100110010005".equals(teslaOrder.getOrderInfo().getOrderType())) {
			String productCode = teslaOrder.getDetail().get(0).getProductCode();
			String productName = productCode.equals("dzsd4107100510020001") ? "个人标准组（Rx）"
					: (productCode.equals("dzsd4107100510020002") ? "个人业余组（Scale）"
							: (productCode.equals("dzsd4107100510020003") ? "团队标准组（Rx）" : ""));// dzsd4107100510020001:个人标准,dzsd4107100510020002:个人业余,dzsd4107100510020003:团体标准
			Double productPrice = productCode.equals("dzsd4107100510020001") ? 218.00
					: (productCode.equals("dzsd4107100510020002") ? 218.00
							: (productCode.equals("dzsd4107100510020003") ? 328.00 : 328.00));
			teslaOrder.getDetail().get(0).setProductName(productName);
			teslaOrder.getDetail().get(0).setProductPrice(BigDecimal.valueOf(productPrice));
			teslaOrder.getOrderInfo().setSellerCode("系统");
		}
		return result;
	}

}
