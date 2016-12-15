package com.uhutu.dcom.user.z.page.func;

import java.math.BigDecimal;

import com.uhutu.dcom.user.z.entity.UcTradeFlow;
import com.uhutu.dcom.user.z.support.AccountComponet;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

/**
 * 账户提现
 * @author 逄小帅
 *
 */
public class UcAccountCashFunc extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		
		WebOperateResult operResult = new WebOperateResult();
		
		String tradeMoney = input.getDataMap().get("trade_money");
		
		String remark = input.getDataMap().get("remark");
		
		String outCode = input.getDataMap().get("out_code");
		
		BigDecimal tradeMoneyO = new BigDecimal(tradeMoney);
		
		boolean flag = AccountComponet.getInstance().cash(outCode, tradeMoneyO);
		
		if(flag){
			
			UcTradeFlow tradeFlow = new UcTradeFlow();
			
			tradeFlow.setOperType("RED_PACK");
			
			tradeFlow.setOutCode(outCode);
			
			tradeFlow.setRemark(remark);
			
			tradeFlow.setTradeMoney(BigDecimal.ZERO.subtract(tradeMoneyO).setScale(2));
			
			tradeFlow.setTradeType("REDPACK_CASH");
			
			AccountComponet.getInstance().saveTradeFlow(tradeFlow);
			
		}else{
			
			operResult.setStatus(-1);
			
			operResult.setError("请检查余额是否充足，或者联系产品姐姐");
			
		}
		
		return operResult;
	}

}
