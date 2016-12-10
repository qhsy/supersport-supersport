package com.uhutu.sportcenter.z.pay.func;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.uhutu.dcom.extend.z.entity.ReReportJson;
import com.uhutu.dcom.order.enumer.OrderEnum;
import com.uhutu.dcom.order.z.entity.OcOrderDetail;
import com.uhutu.dcom.order.z.entity.OcOrderInfo;
import com.uhutu.dcom.order.z.entity.OcOrderPay;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.request.WechatNotifyRequest;
import com.uhutu.dcom.pay.z.service.IWechatNotifyFunc;
import com.uhutu.zoocom.model.MResult;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 微信H5支付回调通知业务处理
 * 更新问题状态
 * 更新偷听记录
 * 更新订单信息
 * 更新订单支付信息
 * @author 逄小帅
 *
 */
public class WechatEntryPayNotifyFunc implements IWechatNotifyFunc {

	@Override
	public MResult doAfter(WechatNotifyRequest notifyRequest) {
		
		synchronized (WechatEntryPayNotifyFunc.class) {
			
			MResult mResult = new MResult();
			
			OcOrderDetail orderDetail = getOrderDetail(notifyRequest.getOut_trade_no());
			
			if(orderDetail != null){
				
				OcOrderInfo ocOrderInfo = getOrderInfo(notifyRequest.getOut_trade_no());
				
				if(ocOrderInfo != null){
					
					/*若订单是未付款，则更新相关业务*/
					if(StringUtils.equals(ocOrderInfo.getStatus(), OrderEnum.STATUS_UNPAYED.getCode())){
						
						/*更新订单信息*/
						ocOrderInfo.setStatus(OrderEnum.STATUS_PAYED.getCode());
						
						BigDecimal payedMoney = new BigDecimal(notifyRequest.getTotal_fee()).divide(new BigDecimal(100)).setScale(2);
						
						ocOrderInfo.setPayedMoney(payedMoney);
						
						updateOrderInfo(ocOrderInfo,mResult);
						
						/*更新订单支付信息*/
						if(mResult.upFlagTrue()){
							
							updateOrderPayInfo(ocOrderInfo.getOrderType(), notifyRequest, notifyRequest.getProcessType(), mResult);
							
						}
						
						/*更新 entry 报名 相关信息*/
						if (mResult.upFlagTrue()) {

							ReReportJson reportJsonInfo = JdbcHelper.queryOne(ReReportJson.class, "signCode",orderDetail.getProductCode());
							
							reportJsonInfo.setStatus("1");
							
							JdbcHelper.update(reportJsonInfo, "status", "za");

						}
					}
					
				}else{
					
					mResult.inError(81110006);
					
				}
				
				
			}else{
				
				mResult.inError(81110006);
				
			}
			
			return mResult;
			
		
			
		}
		
	}
	
	/**
	 * 根据订单编号查询问题编号
	 * @param orderCode
	 * @return 订单详情
	 */
	public OcOrderDetail getOrderDetail(String orderCode){
		
		return JdbcHelper.queryOne(OcOrderDetail.class, "code",orderCode);
		
	}
	
	/**
	 * 获取订单信息
	 * @param orderCode
	 * 		订单编号
	 * @return 订单信息
	 */
	public OcOrderInfo getOrderInfo(String orderCode){
		
		return JdbcHelper.queryOne(OcOrderInfo.class, "code",orderCode);
		
	}
	
	/**
	 * 更新订单信息
	 * @param orderCode
	 */
	public void updateOrderInfo(OcOrderInfo ocOrderInfo,MResult mResult){
		
		ocOrderInfo.setZu(new Date());
		
		int updateFlag = JdbcHelper.update(ocOrderInfo, "status,payedMoney,zu", "code");
		
		if(updateFlag < 1){
			
			mResult.inError(81110007);
			
		}
		
	}
	
	/**
	 * 更新订单支付信息
	 * @param orderType
	 * 		订单类型
	 * @param notifyRequest
	 * 		通知请求信息
	 * @param processEnum
	 * 		枚举解析
	 * @param mResult
	 * 		处理结果
	 */
	public void updateOrderPayInfo(String orderType,WechatNotifyRequest notifyRequest, PayProcessEnum processEnum,MResult mResult){
		
		OcOrderPay ocOrderPay = JdbcHelper.queryOne(OcOrderPay.class, "code",notifyRequest.getOut_trade_no());
		
		int updateFlag = 0;
		
		if(ocOrderPay == null){
			
			ocOrderPay = new OcOrderPay();
			
			ocOrderPay.setCode(notifyRequest.getOut_trade_no());
			
			ocOrderPay.setOrderType(orderType);
			
			ocOrderPay.setPayedMoney(new BigDecimal(notifyRequest.getTotal_fee()).divide(new BigDecimal(100)).setScale(2));
			
			Date date;
			try {
				date = DateUtils.parseDate(notifyRequest.getTime_end(), "yyyyMMddHHmmss");
			} catch (ParseException e) {
				
				date = new Date();
				
			}
			
			ocOrderPay.setPayTime(DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss"));
			
			ocOrderPay.setPayType(processEnum.name());
			
			ocOrderPay.setTradeNo(notifyRequest.getTransaction_id());
			
			updateFlag = JdbcHelper.insert(ocOrderPay);
			
		}else{
			
			ocOrderPay.setTradeNo(notifyRequest.getTransaction_id());
			
			ocOrderPay.setPayType(processEnum.name());
			
			ocOrderPay.setZu(new Date());
			
			updateFlag = JdbcHelper.update(ocOrderPay, "tradeNo,payType,zu", "code");
			
		}
		
		if(updateFlag < 1){
			
			mResult.inError(81110008);
			
		}
		
		
	}

}
