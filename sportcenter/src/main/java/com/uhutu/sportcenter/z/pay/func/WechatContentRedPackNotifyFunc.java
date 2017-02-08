package com.uhutu.sportcenter.z.pay.func;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.content.z.entity.CnRedPackFlow;
import com.uhutu.dcom.content.z.entity.CnRedPackUser;
import com.uhutu.dcom.pay.z.entity.PaPayInfo;
import com.uhutu.dcom.pay.z.request.WechatNotifyRequest;
import com.uhutu.dcom.pay.z.service.IWechatNotifyFunc;
import com.uhutu.dcom.user.z.entity.UcAttentionInfo;
import com.uhutu.dcom.user.z.entity.UcMsgAttention;
import com.uhutu.dcom.user.z.enums.MsgEnum;
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
		
		synchronized (WechatContentRedPackNotifyFunc.class) {
			
			MResult mResult = new MResult();
			
			CnRedPackFlow redPackFlow = getRedPackFlow(notifyRequest.getOut_trade_no());
			
			/*未支付*/
			if(redPackFlow != null){
				
				if(StringUtils.equals(redPackFlow.getStatus(), SystemEnum.INVALID.getCode())){
					
					if(StringUtils.equals(redPackFlow.getStatus(), SystemEnum.INVALID.getCode())){
						
						CnRedPackUser redPackUser = getRedPackUserInfo(redPackFlow.getBusiCode(), redPackFlow.getReciveUserCode());
						
						if (redPackUser != null) {

							/* 更新打赏金额 */
							BigDecimal payedMoney = new BigDecimal(notifyRequest.getTotal_fee()).divide(new BigDecimal(100))
									.setScale(2);

							updateRedPackUser(redPackUser, payedMoney, mResult);

							if(mResult.upFlagTrue()){
								
								updatePayInfo(notifyRequest.getTransaction_id(), notifyRequest.getOut_trade_no(), mResult);
								
							}
							
							if(mResult.upFlagTrue()){
								
								updateRedPackFlow(redPackFlow, mResult);
								
							}
							


						}else{
							
							mResult.inError(81110016);
							
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
	public CnRedPackFlow getRedPackFlow(String flowCode){
		
		return JdbcHelper.queryOne(CnRedPackFlow.class, "code",flowCode);
		
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
	 * @param mResult
	 * 		处理结果
	 */
	public void updateRedPackUser(CnRedPackUser redPackUser,BigDecimal payedMoney,MResult mResult){
		
		BigDecimal packMoney = redPackUser.getMoney().add(payedMoney).setScale(2);
		
		redPackUser.setMoney(packMoney);
		
		int result = JdbcHelper.update(redPackUser, "money", "za");
		
		if(result < 1){
			
			mResult.inError(81110018);
			
		}
		
	}
	
	/**
	 * 更新红包流水信息
	 * @param redPackFlow
	 * 		红包流水信息
	 * @param mResult
	 */
	public void updateRedPackFlow(CnRedPackFlow redPackFlow, MResult mResult){
		
		redPackFlow.setStatus(SystemEnum.NORMAL.getCode());
		
		/*关注受打赏人员*/
		attend(redPackFlow.getSendUserCode(), redPackFlow.getReciveUserCode());
		
		int result = JdbcHelper.update(redPackFlow, "status", "za");
		
		if(result < 1){
			
			mResult.inError(81110019);
			
		}
		
	}
	
	/**
	 * 根据领导们要求 打赏成功后关注人员信息
	 */
	public void attend(String sendUserCode, String reciveUserCode){
		
		UcAttentionInfo attentionInfo = JdbcHelper.queryOne(UcAttentionInfo.class, "attention",sendUserCode,"beAttention",reciveUserCode);
		
		if(attentionInfo == null){
			
			attentionInfo = new UcAttentionInfo();
			
			attentionInfo.setAttention(sendUserCode);
			
			attentionInfo.setBeAttention(reciveUserCode);
			
			attentionInfo.setStatus(SystemEnum.NORMAL.getCode());
			
			JdbcHelper.insert(attentionInfo);
			
		}else{
			
			attentionInfo.setStatus(SystemEnum.NORMAL.getCode());
			
			JdbcHelper.update(attentionInfo, "status", "attention,beAttention");
			
		}
		
		/*关注用户*/
		if(StringUtils.equals(attentionInfo.getStatus(), SystemEnum.NORMAL.getCode())){
			
			saveMsgAttend(attentionInfo);
			
		}
		
		
	}
	
	/**
	 * 保存关注信息
	 * @param attentionInfo
	 */
	public void saveMsgAttend(UcAttentionInfo attentionInfo){
		
		UcMsgAttention msgAttention = new UcMsgAttention();
		
		msgAttention.setAttnUserCode(attentionInfo.getBeAttention());
		
		msgAttention.setFansUserCode(attentionInfo.getAttention());
		
		msgAttention.setMsgTime(new Date());
		
		msgAttention.setMsgTitle("关注了您");
		
		msgAttention.setStatus(MsgEnum.FLAG_UNREAD.getCode());
		
		JdbcHelper.insert(msgAttention);
		
	}

}
