package com.uhutu.dcom.order.make;

import java.math.BigDecimal;

import com.uhutu.dcom.activity.z.entity.AcActivityAnswerInfo;
import com.uhutu.dcom.activity.z.support.AnswerActivitySupport;
import com.uhutu.dcom.order.orderResult.TeslaXOrder;
import com.uhutu.dcom.order.orderResult.TeslaXResult;
import com.uhutu.dcom.order.top.TeslaTopOrderMake;
import com.uhutu.dcom.order.z.entity.OcOrderActivity;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 校验问答活动
 * 
 * @author xiegj
 *
 */
public class TeslaCheckAnswerActivity extends TeslaTopOrderMake {

	public TeslaXResult doRefresh(TeslaXOrder teslaOrder) {
		TeslaXResult result = new TeslaXResult();
		if ("dzsd4112100110010003".equals(teslaOrder.getOrderInfo().getOrderType())
				|| "dzsd4112100110010004".equals(teslaOrder.getOrderInfo().getOrderType())) {
			MDataMap questionInfo = JdbcHelper.dataOne("aw_question_info", "code",
					teslaOrder.getDetail().get(0).getProductCode());
			if (questionInfo == null) {
				result.setStatus(81120002);
				result.setError(TopHelper.upInfo(81120002));
			} else {
				teslaOrder.getDetail().get(0).setProductName(questionInfo.get("content"));
				if ("dzsd4112100110010003".equals(teslaOrder.getOrderInfo().getOrderType())) {// 问达类型
					teslaOrder.getDetail().get(0)
							.setProductPrice(BigDecimal.valueOf(Double.valueOf(questionInfo.get("money"))));
					teslaOrder.getOrderInfo().setSellerCode(questionInfo.get("answer_user_code"));
				} else if ("dzsd4112100110010004".equals(teslaOrder.getOrderInfo().getOrderType())) {// 偷听类型
					teslaOrder.getDetail().get(0)
							.setProductPrice(BigDecimal.valueOf(Double.valueOf(questionInfo.get("sell_money"))));
					teslaOrder.getOrderInfo().setSellerCode(questionInfo.get("question_user_code"));
				}

				AcActivityAnswerInfo activityInfo = new AnswerActivitySupport()
						.getActivityInfoByAnswerCode(teslaOrder.getDetail().get(0).getProductCode());
				if (activityInfo != null) {
					teslaOrder.getDetail().get(0).setProductPrice(activityInfo.getPrice());
					OcOrderActivity activity = new OcOrderActivity();
					activity.setActivityCode(activityInfo.getCode());
					activity.setProductActivityPrice(activityInfo.getPrice());
					activity.setProductCode(questionInfo.get("code"));
					activity.setProductPrice(BigDecimal.valueOf(Double.valueOf(questionInfo.get("sell_money"))));
					teslaOrder.getActivitys().add(activity);
				}
			}
		}
		return result;
	}

}
