package com.uhutu.sportcenter.z.api.live;

import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.dcom.content.z.entity.CnRedPackFlow;
import com.uhutu.dcom.content.z.entity.CnRedPackInfo;
import com.uhutu.dcom.content.z.entity.CnRedPackUser;
import com.uhutu.dcom.pay.z.entity.PaPayInfo;
import com.uhutu.sportcenter.z.input.ApiLiveGiftInput;
import com.uhutu.sportcenter.z.result.ApiLiveGiftResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.WebHelper;

import io.swagger.annotations.ApiModel;

/**
 * 打赏接口
 * 
 * @author xiegj
 *
 */
@ApiModel
@Component
public class ApiLiveGift extends RootApiToken<ApiLiveGiftInput, ApiLiveGiftResult> {

	@Override
	protected ApiLiveGiftResult process(ApiLiveGiftInput input) {
		ApiLiveGiftResult result = new ApiLiveGiftResult();
		CnRedPackInfo packInfo = JdbcHelper.queryOne(CnRedPackInfo.class, "code", input.getGiftCode());
		if (packInfo != null) {
			CnLiveVideoDetail videoDetail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "code", input.getLiveCode());
			if (videoDetail != null) {
				CnRedPackUser packUser = JdbcHelper.queryOne(CnRedPackUser.class, "busi_code",
						videoDetail.getBusiCode(), "user_code", input.getReciveUserCode());
				if (packUser != null) {
					CnRedPackFlow flow = new CnRedPackFlow();
					flow.setCode(WebHelper.upCode("DSDDBH"));
					flow.setBusiCode(videoDetail.getBusiCode());
					flow.setMoney(packInfo.getMoney());
					flow.setReciveUserCode(input.getReciveUserCode());
					flow.setSendUserCode(upUserCode());
					flow.setRedPackCode(packInfo.getCode());
					flow.setStatus("0");
					PaPayInfo payInfo = new PaPayInfo();
					payInfo.setBusiCode(flow.getCode());
					payInfo.setMoney(packInfo.getMoney());
					payInfo.setPaySource(input.getOrderSource());
					payInfo.setPayType(input.getPayType());
					JdbcHelper.insert(flow);
					JdbcHelper.insert(payInfo);
					/**调用支付逻辑*/
				} else {
					result.setStatus(0);
					result.setError("没有找到接受打赏人");
				}
			} else {
				result.setStatus(0);
				result.setError("直播已结束");
			}
		} else {
			result.setStatus(0);
			result.setError("没有此种礼物");
		}

		return result;
	}

}
