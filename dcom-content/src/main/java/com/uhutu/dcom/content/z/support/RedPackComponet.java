package com.uhutu.dcom.content.z.support;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.util.ApplicationSupport;
import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.dcom.content.z.entity.CnRedPackUser;
import com.uhutu.dcom.content.z.service.IRedPackInfoService;
import com.uhutu.dcom.pay.z.common.OperType;
import com.uhutu.dcom.pay.z.common.TradeType;
import com.uhutu.dcom.user.z.entity.UcTradeFlow;
import com.uhutu.dcom.user.z.support.AccountComponet;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 打赏相关操作support
 * @author 逄小帅
 *
 */
@Component
public class RedPackComponet {
	
	/*实体bean处理处理实例*/
	private volatile static RedPackComponet INSTANCE = null;
	
	@Autowired
	private IRedPackInfoService redPackInfoService;
	
	/**
	 * 获取实体bean处理实例
	 * @return RedPackComponet
	 */
	public static RedPackComponet getInstance(){
		
		if(INSTANCE == null){
			
			synchronized (RedPackComponet.class) {
				
				if(INSTANCE == null){
					
					INSTANCE = (RedPackComponet) ApplicationSupport.getBean("redPackComponet");
					
				}
				
			}
			
		}
		
		return INSTANCE;
		
	}
	
	/**
	 * 处理直播分成
	 * @param liveNO
	 */
	public void doLiveProfit(String liveNO){
		
		synchronized (RedPackComponet.class) {
			
			List<CnRedPackUser> redPackUsers = redPackInfoService.getRedPackUsers(liveNO, SystemEnum.INVALID.getCode());
			
			//获取直播信息
			CnLiveVideoDetail cnLiveVideoDetail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "busiCode",liveNO);
			
			if(cnLiveVideoDetail != null){
				
				redPackUsers.forEach(redPackUser ->{
					
					if(redPackUser != null){
						
						BigDecimal profitRate = redPackUser.getScale().divide(BigDecimal.valueOf(100)).setScale(2);
						
						BigDecimal packUserProfit = redPackUser.getMoney().multiply(profitRate).setScale(2, BigDecimal.ROUND_DOWN); 
						
						BigDecimal liveProfit = redPackUser.getMoney().subtract(packUserProfit);
						
						/*记录打赏人员流水*/
						liveProfitFlow(StringUtils.join(liveNO,"-",redPackUser.getUserCode()), packUserProfit, "");
						/*更新打赏人员收益*/
						AccountComponet.getInstance().updateProfit(redPackUser.getUserCode(), packUserProfit);
						
						/*记录主播人员流水*/
						liveProfitFlow(StringUtils.join(liveNO,"-",cnLiveVideoDetail.getUserCode()), liveProfit, "");
						/*更新主播收益*/
						AccountComponet.getInstance().updateProfit(cnLiveVideoDetail.getUserCode(), liveProfit);
						
						/*更新主播分成状态*/
						redPackUser.setStatus(SystemEnum.YES.getCode());
						
						JdbcHelper.update(redPackUser, "status", "za");
						
					}
					
				});
				
			}
			
			
		}
		
	}
	
	/**
	 * 保存红包交易流水
	 * @param outCode
	 * 		外部编号
	 * @param tradeMoney
	 * 		交易金额
	 * @param remark
	 * 		备注信息
	 */
	public void liveProfitFlow(String outCode,BigDecimal tradeMoney,String remark){
		
		UcTradeFlow ucTradeFlow = new UcTradeFlow();
		
		ucTradeFlow.setOperType(OperType.RED_PACK.name());
		
		ucTradeFlow.setOutCode(outCode);
		
		remark = StringUtils.isEmpty(remark)?OperType.RED_PACK.getRemark() : remark;
		
		ucTradeFlow.setRemark(remark);
		
		ucTradeFlow.setTradeMoney(tradeMoney);
		
		ucTradeFlow.setTradeType(TradeType.REDPACK_PROFIT.name());
		
		AccountComponet.getInstance().saveTradeFlow(ucTradeFlow);
		
	}

}
