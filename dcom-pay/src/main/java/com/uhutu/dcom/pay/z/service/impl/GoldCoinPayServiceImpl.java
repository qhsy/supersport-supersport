package com.uhutu.dcom.pay.z.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uhutu.dcom.config.enums.PrexEnum;
import com.uhutu.dcom.pay.z.common.OperType;
import com.uhutu.dcom.pay.z.entity.PaCoinFlow;
import com.uhutu.dcom.pay.z.entity.PaCoinInfo;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.request.GoldCoinPayRequest;
import com.uhutu.dcom.pay.z.response.GoldCoinPayResponse;
import com.uhutu.dcom.pay.z.service.IGoldCoinPayService;
import com.uhutu.dcom.pay.z.service.IPaCoinInfoService;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.WebHelper;

/**
 * 金币支付业务实现
 * @author 逄小帅
 *
 */
@Service
public class GoldCoinPayServiceImpl implements IGoldCoinPayService {
	
	private volatile long coinNum = 0;
	
	@Autowired
	private IPaCoinInfoService paCoinInfoService;

	@Override
	public IPayResponse doProcess(IPayRequest request, MDataMap paramMap) {	
		
		GoldCoinPayResponse coinPayResponse = new GoldCoinPayResponse();
		
		GoldCoinPayRequest coinPayRequest = (GoldCoinPayRequest) request;
		
		synchronized (GoldCoinPayServiceImpl.class) {
			
			switch (coinPayRequest.getOperType()) {
			case COIN_CHARGE:
				doChage(coinPayResponse, coinPayRequest);
				break;

			default:
				doOperInfo(coinPayResponse, coinPayRequest);
				break;
			}
			
		}
		
		coinPayResponse.setOrderCode(coinPayRequest.getOutCode());
		
		return coinPayResponse;
	}
	
	public String saveTradeFlow(GoldCoinPayRequest request){
		
		PaCoinFlow coinFlow = new PaCoinFlow();
		
		coinFlow.setCode(WebHelper.upCode(PrexEnum.GCOF.name()));
		
		coinFlow.setOperType(request.getOperType().name());
		
		coinFlow.setOutCode(request.getOutCode());
		
		coinFlow.setRemark(request.getOperType().getRemark());
		
		coinFlow.setTradeType(request.getTradeType().name());
		
		coinFlow.setTradeNum(request.getCoinNum());
		
		coinFlow.setUserCode(request.getUserCode());
		
		coinFlow.setZc(new Date());
		
		JdbcHelper.insert(coinFlow);
		
		return coinFlow.getCode();
		
	}
	
	public void doOperInfo(GoldCoinPayResponse coinPayResponse, GoldCoinPayRequest coinPayRequest){
		
		PaCoinInfo coinInfo = paCoinInfoService.queryByUserCode(coinPayRequest.getUserCode());
		
		if(coinInfo != null){
			
			if(coinPayRequest.getOperType().equals(OperType.COIN_QUERY)){
				
				coinPayResponse.setBalance(coinInfo.getBalance());
				
				long tempNum = coinInfo.getBalance() + coinPayRequest.getCoinNum();
				
				if(tempNum < 0){
					
					coinPayResponse.setOperFlag(false);
					
				}
				
			}else{
				
				coinNum = coinInfo.getBalance() + coinPayRequest.getCoinNum();
				
				if(coinNum >= 0 ){
					
					coinInfo.setBalance(coinNum);
					
					paCoinInfoService.save(coinInfo);
					
					String flowNO = saveTradeFlow(coinPayRequest);
					
					coinPayResponse.setBalance(coinNum);
					
					coinPayResponse.setFlowNO(flowNO);
					
				}else{
					
					coinPayResponse.setBalance(coinInfo.getBalance());
					
					coinPayResponse.setOperFlag(false);
					
					coinPayResponse.inError(81110011);
					
				}
				
			}
			
		}else{
			
			coinPayResponse.setOperFlag(false);
			
			coinPayResponse.inError(81110011);
			
		}
		
	}
	
	/**
	 * 充值
	 * @param userCode
	 * 		用户编号
	 * @param chargeNum
	 * 		充值金额
	 */
	public void doChage(GoldCoinPayResponse coinPayResponse, GoldCoinPayRequest coinPayRequest){
		
		PaCoinInfo coinInfo = paCoinInfoService.queryByUserCode(coinPayRequest.getUserCode());
		
		if(coinInfo != null){
			
			coinNum = coinInfo.getBalance() + coinPayRequest.getCoinNum();
			
			coinInfo.setBalance(coinNum);
			
			paCoinInfoService.save(coinInfo);
			
		}else{
			
			coinInfo = new PaCoinInfo();
			
			coinInfo.setUserCode(coinPayRequest.getUserCode());
			
			coinInfo.setBalance(coinPayRequest.getCoinNum());
			
			paCoinInfoService.save(coinInfo);
			
		}
		
		String flowNO = saveTradeFlow(coinPayRequest);
		
		coinPayResponse.setFlowNO(flowNO);
		
		coinPayResponse.setBalance(coinNum);
		
	}

}
