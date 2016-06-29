package com.uhutu.dcom.order.make;

import com.uhutu.dcom.activity.z.entity.AcActivityAnswerInfo;
import com.uhutu.dcom.activity.z.support.AnswerActivitySupport;
import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.order.orderResult.TeslaXOrder;
import com.uhutu.dcom.order.orderResult.TeslaXResult;
import com.uhutu.dcom.order.top.TeslaTopOrderMake;
import com.uhutu.dcom.order.z.entity.OcOrderActivity;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 校验活动
 * 
 * @author xiegj
 *
 */
public class TeslaCheckAnswerActivity extends TeslaTopOrderMake {

	public TeslaXResult doRefresh(TeslaXOrder teslaOrder) {
		TeslaXResult result = new TeslaXResult();
		AwQuestionInfo questionInfo = JdbcHelper.queryOne(AwQuestionInfo.class, "code",
				teslaOrder.getDetail().get(0).getProductCode());
		if (questionInfo == null) {
			result.setStatus(81120002);
			result.setError(TopHelper.upInfo(81120002));
		} else {
			teslaOrder.getDetail().get(0).setProductName(questionInfo.getContent());
			if ("dzsd4112100110010003".equals(teslaOrder.getOrderInfo().getOrderType())) {
				teslaOrder.getDetail().get(0).setProductPrice(questionInfo.getMoney());
			} else if ("dzsd4112100110010004".equals(teslaOrder.getOrderInfo().getOrderType())) {
				teslaOrder.getDetail().get(0).setProductPrice(questionInfo.getSellMoney());
			}
			teslaOrder.getOrderInfo().setSellerCode(questionInfo.getQuestionUserCode());
			AcActivityAnswerInfo activityInfo = new AnswerActivitySupport()
					.getActivityInfoByAnswerCode(teslaOrder.getDetail().get(0).getCode());
			if (activityInfo != null) {
				teslaOrder.getDetail().get(0).setProductPrice(activityInfo.getPrice());
				OcOrderActivity activity = new OcOrderActivity();
				activity.setActivityCode(activityInfo.getCode());
				activity.setProductActivityPrice(activityInfo.getPrice());
				activity.setProductCode(questionInfo.getCode());
				activity.setProductPrice(questionInfo.getSellMoney());
				teslaOrder.getActivitys().add(activity);
			}
		}
		return result;
	}

}
