package com.uhutu.sportcenter.z.api.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.pay.z.common.OperType;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.common.TradeType;
import com.uhutu.dcom.pay.z.entity.PaCoinFlow;
import com.uhutu.dcom.pay.z.process.impl.PayGateProcess;
import com.uhutu.dcom.pay.z.request.GoldCoinPayRequest;
import com.uhutu.dcom.pay.z.response.GoldCoinPayResponse;
import com.uhutu.sportcenter.z.input.ApiCoinChargeInput;
import com.uhutu.sportcenter.z.result.ApiCoinChargeResult;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 金币充值
 * @author 逄小帅
 *
 */
@Component
public class ApiCoinCharge extends RootApiToken<ApiCoinChargeInput, ApiCoinChargeResult> {
	
	@Autowired
	private PayGateProcess payGateProcess;

	@Override
	protected ApiCoinChargeResult process(ApiCoinChargeInput input) {

		ApiCoinChargeResult coinChargeResult = new ApiCoinChargeResult();

		int count = JdbcHelper.count(PaCoinFlow.class, "", MapHelper.initMap("outCode", input.getFlowNO(), "tradeType",
				TradeType.GOLDEN_COIN.name(), "operType", OperType.COIN_CHARGE.name()));

		if (count <= 0) {

			GoldCoinPayRequest coinPayRequest = new GoldCoinPayRequest();

			coinPayRequest.setCoinNum(input.getCoinNum());

			coinPayRequest.setOperType(OperType.COIN_CHARGE);

			coinPayRequest.setTradeType(TradeType.GOLDEN_COIN);

			coinPayRequest.setOutCode(input.getFlowNO());

			coinPayRequest.setUserCode(upUserCode());
			
			long money = input.getCoinNum()/100;
			
			coinPayRequest.setRemark(TopHelper.upInfo(81110012, money));

			GoldCoinPayResponse coinPayResponse = (GoldCoinPayResponse) payGateProcess.process(PayProcessEnum.GOLD_COIN,
					coinPayRequest, new MDataMap());

			if (coinPayResponse.upFlagTrue()) {

				coinChargeResult.setCoinNum(coinPayResponse.getBalance());

			} else {

				coinChargeResult.setStatus(coinPayResponse.getStatus());

				coinChargeResult.setError(coinPayResponse.getError());

			}

		} else {
			
			coinChargeResult.setStatus(0);
			
			coinChargeResult.setError("已充值成功，无需重复充值");

		}

		return coinChargeResult;
	}

}
