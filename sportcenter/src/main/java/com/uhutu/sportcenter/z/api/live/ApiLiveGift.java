package com.uhutu.sportcenter.z.api.live;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.dcom.content.z.entity.CnRedPackFlow;
import com.uhutu.dcom.content.z.entity.CnRedPackInfo;
import com.uhutu.dcom.content.z.entity.CnRedPackUser;
import com.uhutu.dcom.pay.z.common.OrderType;
import com.uhutu.dcom.pay.z.entity.PaPayInfo;
import com.uhutu.sportcenter.z.api.pay.ApiWechatMobilePay2;
import com.uhutu.sportcenter.z.input.ApiLiveGiftInput;
import com.uhutu.sportcenter.z.input.ApiWechatMobilePayInput;
import com.uhutu.sportcenter.z.result.ApiLiveGiftResult;
import com.uhutu.sportcenter.z.result.ApiWechatMobilePayResult;
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
	
	@Autowired
	private ApiWechatMobilePay2 apiWechatMobilePay2;

	@Override
	protected ApiLiveGiftResult process(ApiLiveGiftInput input) {
		ApiLiveGiftResult result = new ApiLiveGiftResult();
		CnRedPackInfo packInfo = JdbcHelper.queryOne(CnRedPackInfo.class, "code", input.getGiftCode());
		if (packInfo != null) {
			CnLiveVideoDetail videoDetail = JdbcHelper.queryOne(CnLiveVideoDetail.class,"status","1", "chatCode", input.getLiveCode());
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
					payInfo.setBusiType(OrderType.RED_PACK.getCode());
					JdbcHelper.insert(flow);
					JdbcHelper.insert(payInfo);
					
					/**调用支付逻辑*/
					initMobilePayInfo(flow, input, result);
					
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
	
	/**
	 * 初始化移动支付信息
	 * 
	 * @param CnRedPackFlow
	 * 		红包流水
	 * @param liveGiftInput
	 * 		输入参数
	 */
	public void initMobilePayInfo(CnRedPackFlow flow,ApiLiveGiftInput liveGiftInput,ApiLiveGiftResult liveGiftResult) {

		ApiWechatMobilePayInput mobilePayInput = new ApiWechatMobilePayInput();
		mobilePayInput.setOrderCode(flow.getCode());
		mobilePayInput.setRomoteIP(liveGiftInput.getRomoteIP());
		mobilePayInput.setServeIP(liveGiftInput.getServeIP());
		mobilePayInput.setPayMoney(flow.getMoney());
		mobilePayInput.setZoo(liveGiftInput.getZoo());
		ApiWechatMobilePayResult payResult = apiWechatMobilePay2.api(mobilePayInput);
		if (payResult.upFlagTrue()) {
			liveGiftResult.setWechatMobilePayResponse(payResult.getMobilePayInfo());
		} else {
			liveGiftResult.setStatus(payResult.getStatus());
			liveGiftResult.setError(payResult.getError());
		}

	}

}
