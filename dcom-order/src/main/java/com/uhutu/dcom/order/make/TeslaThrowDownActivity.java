package com.uhutu.dcom.order.make;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.util.ApplicationSupport;
import com.uhutu.dcom.component.z.util.WebClientComponent;
import com.uhutu.dcom.order.orderResult.TeslaXOrder;
import com.uhutu.dcom.order.orderResult.TeslaXResult;
import com.uhutu.dcom.order.support.CrossFitSupport;
import com.uhutu.dcom.order.top.TeslaTopOrderMake;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.process.impl.PayGateProcess;
import com.uhutu.dcom.pay.z.response.WechatAccessTokenResponse;
import com.uhutu.dcom.user.z.entity.UcSignInfo;
import com.uhutu.dcom.user.z.entity.UcSignPrice;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.WebHelper;

/**
 * 校验问答活动
 * 
 * @author xiegj
 *
 */
@Service
public class TeslaThrowDownActivity extends TeslaTopOrderMake {

	public final static String PER_PRO = "dzsd4107100510020001";// 个人标准
	public final static String PER_SPA = "dzsd4107100510020002";// 个人业余
	public final static String GRO_PRO = "dzsd4107100510020003";// 团体标准

	public TeslaXResult doRefresh(TeslaXOrder teslaOrder) {
		TeslaXResult result = new TeslaXResult();
		if ("dzsd4112100110010005".equals(teslaOrder.getOrderInfo().getOrderType())) {
			String checkResult = checkSign(teslaOrder.getOrderInfo().getBuyerCode(), teslaOrder);
			if (StringUtils.isBlank(checkResult)) {

				String type = teslaOrder.getSigns().get(0).getType();
				String productName = type.equals(PER_PRO) ? "个人标准组（Rx）"
						: (type.equals(PER_SPA) ? "个人业余组（Scale）" : (type.equals(GRO_PRO) ? "团队标准组（Rx）" : ""));// dzsd4107100510020001:个人标准,dzsd4107100510020002:个人业余,dzsd4107100510020003:团体标准
				teslaOrder.getDetail().get(0).setProductName(productName);
				teslaOrder.getDetail().get(0).setProductPrice(getPrice().get(type));
				teslaOrder.getOrderInfo().setSellerCode("系统");
			} else {
				result.setStatus(0);
				result.setError(checkResult);
			}
		}
		return result;
	}

	/**
	 * 获取每种参赛类型的价格
	 */
	private Map<String, BigDecimal> getPrice() {
		List<UcSignPrice> list = JdbcHelper.queryForList(UcSignPrice.class, "", "", "", new MDataMap());
		Map<String, BigDecimal> map = new java.util.HashMap<>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				map.put(list.get(i).getType(), list.get(i).getPrice());
			}
		}
		return map;
	}

	/**
	 * 校验规则：个人赛每人只能参与一种，每种只能参与一次
	 * 
	 * @param userCode
	 *            用户编号
	 * @param signInfo
	 *            参赛信息
	 */
	private String checkSign(String userCode, TeslaXOrder teslaOrder) {
		String result = "";
		List<String> li = new CrossFitSupport().getAlSignType();
		for (int i = 0; i < li.size(); i++) {
			if (teslaOrder.getSigns().get(0).getType().equals("dzsd4107100510020001") && "single".equals(li.get(i))) {
				result = "个人标准组（Rx）已报满，请持续关注本报名状态！~";
			} else if (teslaOrder.getSigns().get(0).getType().equals("dzsd4107100510020002")
					&& "single".equals(li.get(i))) {
				result = "个人业余组（Scale）已报满，请持续关注本报名状态！~";
			} else if (teslaOrder.getSigns().get(0).getType().equals("dzsd4107100510020003")
					&& "group".equals(li.get(i))) {
				result = "团队标准组（Rx）已报满，请持续关注本报名状态！~";
			}
		}
		if (StringUtils.isBlank(result)) {
			if (teslaOrder.getSigns() != null && teslaOrder.getSigns().size() > 0) {
				List<UcSignInfo> signs = JdbcHelper.queryForList(UcSignInfo.class, "", "",
						" status='dzsd4112100110030002' and user_code=:userCode ",
						MapHelper.initMap("userCode", teslaOrder.getOrderInfo().getBuyerCode()));
				for (int i = 0; i < signs.size(); i++) {
					if (GRO_PRO.equals(signs.get(i).getType())
							&& teslaOrder.getSigns().get(0).getType().equals(signs.get(i).getType())) {
						result = TopHelper.upInfo(81120006);
						break;
					} else if (PER_SPA.equals(signs.get(i).getType())
							&& (PER_SPA.equals(teslaOrder.getSigns().get(0).getType())
									|| PER_PRO.equals(teslaOrder.getSigns().get(0).getType()))) {
						result = TopHelper.upInfo(81120005);
						break;
					} else if (PER_PRO.equals(signs.get(i).getType())
							&& (PER_SPA.equals(teslaOrder.getSigns().get(0).getType())
									|| PER_PRO.equals(teslaOrder.getSigns().get(0).getType()))) {
						result = TopHelper.upInfo(81120004);
						break;
					}
				}
				if (StringUtils.isBlank(result)) {
					String groupCode = WebHelper.upCode("CFSDBH");
					int simpleNum = JdbcHelper.count(UcSignInfo.class,
							" type in ('dzsd4107100510020001','dzsd4107100510020002') ", new MDataMap()) + 1;
					int groupNum = JdbcHelper.count(UcSignInfo.class, " type ='dzsd4107100510020003' ", new MDataMap())
							+ 1;
					for (int j = 0; j < teslaOrder.getSigns().size(); j++) {
						UcSignInfo signInfo = teslaOrder.getSigns().get(j);
						teslaOrder.getSigns().get(j).setStatus("dzsd4112100110030001");
						teslaOrder.getSigns().get(j).setActivityName("2016 Beijing CrossFit ThrowDown");
						if (!"dzsd4112100110020001".equals(teslaOrder.getOrderInfo().getOrderSource())) {
							WechatAccessTokenResponse tokenResponse = (WechatAccessTokenResponse) ((PayGateProcess) ApplicationSupport
									.getBean("payGateProcess")).process(PayProcessEnum.WECHAT_TOKEN, null,
											new MDataMap());
							teslaOrder.getSigns().get(j).setPhoto(WebClientComponent.wechatMediaDownLoad("crossfit",
									tokenResponse.getAccess_token(), signInfo.getPhoto()).getFileUrl());
						}
						if (PER_PRO.equals(signInfo.getType()) || PER_SPA.equals(signInfo.getType())) {
							teslaOrder.getSigns().get(j).setCode(new DecimalFormat("0000").format(simpleNum));
						} else {
							teslaOrder.getSigns().get(j).setCode(new DecimalFormat("000000").format(groupNum + j));
							teslaOrder.getSigns().get(j).setGroupCode(groupCode);
						}
						teslaOrder.getDetail().get(0).setProductCode(signInfo.getCode());
					}
				}
			} else {
				result = TopHelper.upInfo(81120003);
			}
		}
		return result;
	}

}
