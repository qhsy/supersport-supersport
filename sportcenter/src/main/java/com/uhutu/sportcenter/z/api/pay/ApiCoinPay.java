package com.uhutu.sportcenter.z.api.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.order.z.entity.OcOrderInfo;
import com.uhutu.dcom.pay.z.common.OperType;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.common.TradeType;
import com.uhutu.dcom.pay.z.process.impl.PayGateProcess;
import com.uhutu.dcom.pay.z.request.GoldCoinPayRequest;
import com.uhutu.dcom.pay.z.request.WechatNotifyRequest;
import com.uhutu.dcom.pay.z.response.GoldCoinPayResponse;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.sportcenter.z.input.ApiCoinPayInput;
import com.uhutu.sportcenter.z.pay.func.WechatH5PayNotifyFunc;
import com.uhutu.sportcenter.z.result.ApiCoinPayResult;
import com.uhutu.zoocom.helper.FormatHelper;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.model.MResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 金币支付
 * @author 逄小帅
 *
 */
@Component
public class ApiCoinPay extends RootApiToken<ApiCoinPayInput, ApiCoinPayResult> {
	
	@Autowired
	private PayGateProcess payGateProcess; 

	@Override
	protected ApiCoinPayResult process(ApiCoinPayInput input) {

		ApiCoinPayResult coinPayResult = new ApiCoinPayResult();

		GoldCoinPayRequest coinPayRequest = new GoldCoinPayRequest();
		
		coinPayRequest.setCoinNum(0 - input.getCoinNum());
		
		coinPayRequest.setOperType(OperType.PAY_LISTEN);
		
		coinPayRequest.setOutCode(input.getOrderCode());
		
		coinPayRequest.setTradeType(TradeType.GOLDEN_COIN);
		
		coinPayRequest.setUserCode(upUserCode());
		
		OcOrderInfo ocOrderInfo = JdbcHelper.queryOne(OcOrderInfo.class, "code",input.getOrderCode());
		
		if(ocOrderInfo != null){
			
			UcUserinfoExt ucUserinfoExt = JdbcHelper.queryOne(UcUserinfoExt.class, "userCode",ocOrderInfo.getSellerCode());
			
			if(ucUserinfoExt != null){
				
				String remark = TopHelper.upInfo(81110013, ucUserinfoExt.getNickName());
				
				coinPayRequest.setRemark(remark);
				
			}
			
		}

		GoldCoinPayResponse coinPayResponse = (GoldCoinPayResponse) payGateProcess.process(PayProcessEnum.GOLD_COIN,
				coinPayRequest, new MDataMap());
		
		if(coinPayResponse.upFlagTrue()){
			
			WechatH5PayNotifyFunc notifyFunc = new WechatH5PayNotifyFunc();
			
			WechatNotifyRequest notifyRequest = new WechatNotifyRequest();
			
			notifyRequest.setOut_trade_no(input.getOrderCode());
			
			Long totalFee = input.getCoinNum();
			
			notifyRequest.setTotal_fee(totalFee.intValue());
			
			notifyRequest.setProcessType(PayProcessEnum.GOLD_COIN);
			
			notifyRequest.setTransaction_id(coinPayResponse.getFlowNO());
			
			notifyRequest.setTime_end(FormatHelper.upDateTime("yyyyMMddHHmmss"));
			
			MResult notifyResponse = notifyFunc.doAfter(notifyRequest);
			
			if(!notifyResponse.upFlagTrue()){
				
				coinPayResult.setStatus(notifyResponse.getStatus());
				
				coinPayResult.setError(notifyResponse.getError());
				
			}
			
			
		}else{
			
			coinPayResult.setStatus(coinPayResponse.getStatus());
			
			coinPayResult.setError(coinPayResponse.getError());
			
		}

		return coinPayResult;
	}

}
