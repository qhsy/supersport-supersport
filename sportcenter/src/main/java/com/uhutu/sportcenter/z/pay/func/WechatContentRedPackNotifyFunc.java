package com.uhutu.sportcenter.z.pay.func;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.content.z.entity.CnContentRedpackFlow;
import com.uhutu.dcom.content.z.entity.CnRedPackUser;
import com.uhutu.dcom.content.z.support.RedPackComponet;
import com.uhutu.dcom.pay.z.entity.PaPayInfo;
import com.uhutu.dcom.pay.z.request.WechatNotifyRequest;
import com.uhutu.dcom.pay.z.service.IWechatNotifyFunc;
import com.uhutu.zoocom.model.MResult;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 微信红包支付
 * 更新红包流水支付状态
 * 更新红包接收人金额信息
 * 更新支付信息交易流水号
 * @author 逄小帅
 *
 */
public class WechatContentRedPackNotifyFunc implements IWechatNotifyFunc {

	@Override
	public MResult doAfter(WechatNotifyRequest notifyRequest) {
		
		synchronized (WechatRedPackNotifyFunc.class) {
			
			MResult mResult = new MResult();
			
			CnContentRedpackFlow redPackFlow = getRedPackFlow(notifyRequest.getOut_trade_no());
			
			/*未支付*/
			if(redPackFlow != null){
				
				if(StringUtils.equals(redPackFlow.getStatus(), SystemEnum.INVALID.getCode())){
					
					if(StringUtils.equals(redPackFlow.getStatus(), SystemEnum.INVALID.getCode())){
						

							/* 更新打赏金额 */
							BigDecimal payedMoney = new BigDecimal(notifyRequest.getTotal_fee()).divide(new BigDecimal(100))
									.setScale(2);

							if(mResult.upFlagTrue()){
								
								updatePayInfo(notifyRequest.getTransaction_id(), notifyRequest.getOut_trade_no(), mResult);
								
							}
							/*更新状态*/
							if(mResult.upFlagTrue()){
								
								updateRedPackFlow(redPackFlow, mResult);
								
							}
							/*更新接受打赏人员金额*/
							if(mResult.upFlagTrue()){
								
								updateRedPackUser(redPackFlow.getSendUserCode(),redPackFlow.getContentCode(), payedMoney);
								
							}
						
					}
					
				}else{
					
					mResult.inError(81110020);
					
				}
				
			}else{
				
				mResult.inError(81110015);
				
			}
			
			return mResult;
			
		
			
		}
		
	}
	
	/**
	 * 根据打赏流水编号查询打赏信息
	 * @param flowCode
	 * @return 打赏信息
	 */
	public CnContentRedpackFlow getRedPackFlow(String flowCode){
		
		return JdbcHelper.queryOne(CnContentRedpackFlow.class, "code",flowCode);
		
	}
	
	/**
	 * 获取订单信息
	 * @param orderCode
	 * 		订单编号
	 * @return 订单信息
	 */
	public CnRedPackUser getRedPackUserInfo(String busiCode,String userCode){
		
		return JdbcHelper.queryOne(CnRedPackUser.class, "busiCode",busiCode,"userCode",userCode);
		
	}
	

	/**
	 * 更新支付信息
	 * @param tradeNo
	 * 		交易流水号
	 * @param busiCode
	 * 		业务编号
	 * @param mResult
	 * 		处理结果
	 */
	public void updatePayInfo(String tradeNo,String busiCode,MResult mResult){
		
		/* 更新支付信息*/
		PaPayInfo paPayInfo = JdbcHelper.queryOne(PaPayInfo.class, "busiCode", busiCode);
		
		if(paPayInfo != null){
			
			paPayInfo.setTradeNo(tradeNo);
			
			JdbcHelper.update(paPayInfo, "tradeNo", "za");
			
		}else{
			
			mResult.inError(81110017);
			
		}
		
	}
	
	/**
	 * 更新打赏人员金额
	 * @param redPackUser
	 * 		更新打赏人员信息
	 * @param payedMoney
	 * 		支付金额
	 * 		
	 */
	public void updateRedPackUser(String sendUserCode,String contentCode,BigDecimal payedMoney){
		
		RedPackComponet.getInstance().doContentProfit(sendUserCode, contentCode, payedMoney);
		
	}
	
	/**
	 * 更新红包流水信息
	 * @param redPackFlow
	 * 		红包流水信息
	 * @param mResult
	 */
	public void updateRedPackFlow(CnContentRedpackFlow redPackFlow, MResult mResult){
		
		redPackFlow.setStatus(SystemEnum.NORMAL.getCode());
		
		int result = JdbcHelper.update(redPackFlow, "status", "za");
		
		if(result < 1){
			
			mResult.inError(81110019);
			
		}
		
	}
	
	
	
}
