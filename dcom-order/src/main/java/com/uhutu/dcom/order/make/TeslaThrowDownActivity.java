package com.uhutu.dcom.order.make;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.order.orderResult.TeslaXOrder;
import com.uhutu.dcom.order.orderResult.TeslaXResult;
import com.uhutu.dcom.order.top.TeslaTopOrderMake;
import com.uhutu.dcom.user.z.entity.UcSignInfo;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 校验问答活动
 * 
 * @author xiegj
 *
 */
public class TeslaThrowDownActivity extends TeslaTopOrderMake {

	public final static String PER_PRO = "dzsd4107100510020001";// 个人标准
	public final static String PER_SPA = "dzsd4107100510020002";// 个人业余
	public final static String GRO_PRO = "dzsd4107100510020003";// 团体标准

	public TeslaXResult doRefresh(TeslaXOrder teslaOrder) {
		TeslaXResult result = new TeslaXResult();
		if ("dzsd4112100110010005".equals(teslaOrder.getOrderInfo().getOrderType())) {
			String checkResult = checkSign(teslaOrder.getOrderInfo().getBuyerCode(), teslaOrder.getSign(), teslaOrder);
			if (StringUtils.isBlank(checkResult)) {

				String productCode = teslaOrder.getDetail().get(0).getProductCode();
				String productName = productCode.equals(PER_PRO) ? "个人标准组（Rx）"
						: (productCode.equals(PER_SPA) ? "个人业余组（Scale）"
								: (productCode.equals(GRO_PRO) ? "团队标准组（Rx）" : ""));// dzsd4107100510020001:个人标准,dzsd4107100510020002:个人业余,dzsd4107100510020003:团体标准
				Double productPrice = productCode.equals(PER_PRO) ? 218.00
						: (productCode.equals(PER_SPA) ? 218.00 : (productCode.equals(GRO_PRO) ? 328.00 : 328.00));
				teslaOrder.getDetail().get(0).setProductName(productName);
				teslaOrder.getDetail().get(0).setProductPrice(BigDecimal.valueOf(productPrice));
				teslaOrder.getOrderInfo().setSellerCode("系统");
			} else {
				result.setStatus(0);
				result.setError(checkResult);
			}
		}
		return result;
	}

	/**
	 * 校验规则：个人赛每人只能参与一种，每种只能参与一次
	 * 
	 * @param userCode
	 *            用户编号
	 * @param signInfo
	 *            参赛信息
	 */
	private String checkSign(String userCode, UcSignInfo signInfo, TeslaXOrder teslaOrder) {
		String result = "";
		if (signInfo != null) {
			List<UcSignInfo> signs = JdbcHelper.queryForList(UcSignInfo.class, "", "",
					" status='dzsd4112100110030002' ", new MDataMap());
			int num = JdbcHelper.count(UcSignInfo.class, "", new MDataMap()) + 1;
			for (int i = 0; i < signs.size(); i++) {
				if (GRO_PRO.equals(signs.get(i).getType()) && signInfo.equals(signs.get(i).getType())) {
					result = TopHelper.upInfo(81120006);
					break;
				} else if (PER_SPA.equals(signs.get(i).getType())
						&& (PER_SPA.equals(signs.get(i).getType()) || PER_PRO.equals(signs.get(i).getType()))) {
					result = TopHelper.upInfo(81120005);
					break;
				} else if (PER_PRO.equals(signs.get(i).getType())
						&& (PER_SPA.equals(signs.get(i).getType()) || PER_PRO.equals(signs.get(i).getType()))) {
					result = TopHelper.upInfo(81120004);
					break;
				}
			}
			if (StringUtils.isBlank(result)) {
				signInfo.setStatus("dzsd4112100110030001");
				signInfo.setCode(new DecimalFormat("0000").format(num));
				signInfo.setActivityName("2016 Beijing CrossFit ThrowDown");
				signInfo.setName(signInfo.getType().equals(PER_PRO) ? "个人标准组（Rx）"
						: (signInfo.getType().equals(PER_SPA) ? "个人业余组（Scale）"
								: (signInfo.getType().equals(GRO_PRO) ? "团队标准组（Rx）" : "")));
				JdbcHelper.insert(signInfo);
			}
		} else {
			result = TopHelper.upInfo(81120003);
		}
		return result;
	}

}
