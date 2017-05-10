package com.uhutu.sportcenter.z.api.content;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.config.enums.PrexEnum;
import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentRedpackFlow;
import com.uhutu.dcom.content.z.entity.CnRedPackInfo;
import com.uhutu.dcom.pay.z.common.OrderType;
import com.uhutu.dcom.pay.z.entity.PaPayInfo;
import com.uhutu.sportcenter.z.api.pay.ApiWechatMobilePay2;
import com.uhutu.sportcenter.z.input.ApiContentRedPackInput;
import com.uhutu.sportcenter.z.input.ApiWechatMobilePayInput;
import com.uhutu.sportcenter.z.result.ApiContentRedPackResult;
import com.uhutu.sportcenter.z.result.ApiWechatMobilePayResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.WebHelper;

import io.swagger.annotations.ApiModel;

/**
 * 内容红包
 * 
 * @author 逄小帅
 *
 */
@ApiModel
@Component
public class ApiContentRedPack extends RootApiToken<ApiContentRedPackInput, ApiContentRedPackResult> {
	
	@Autowired
	private ApiWechatMobilePay2 apiWechatMobilePay2;

	@Override
	protected ApiContentRedPackResult process(ApiContentRedPackInput input) {
		ApiContentRedPackResult result = new ApiContentRedPackResult();
		CnRedPackInfo packInfo = JdbcHelper.queryOne(CnRedPackInfo.class, "code", input.getRedPackCode());
		if (packInfo != null) {
			
			CnContentBasicinfo contentBasicInfo = JdbcHelper.queryOne(CnContentBasicinfo.class, "code",input.getContentCode(),"status",SystemEnum.YES.getCode());
			
//				if (contentBasicInfo != null) {
//					
//					if(StringUtils.equals(contentBasicInfo.getRedPackFlag(), SystemEnum.YES.getCode())){
//						
//						CnContentRedpackFlow redPackFlow = new CnContentRedpackFlow();
//						redPackFlow.setCode(WebHelper.upCode(PrexEnum.CNRF.name()));
//						redPackFlow.setContentCode(contentBasicInfo.getCode());
//						redPackFlow.setMoney(packInfo.getMoney());
//						redPackFlow.setReciveUserCode(contentBasicInfo.getAuthor());
//						redPackFlow.setSendUserCode(upUserCode());
//						redPackFlow.setStatus("0");
//						PaPayInfo payInfo = new PaPayInfo();
//						payInfo.setBusiCode(redPackFlow.getCode());
//						payInfo.setMoney(packInfo.getMoney());
//						payInfo.setPaySource(input.getOrderSource());
//						payInfo.setPayType(input.getPayType());
//						payInfo.setBusiType(OrderType.CONTENT_RED_PACK.getCode());
//						JdbcHelper.insert(redPackFlow);
//						JdbcHelper.insert(payInfo);
//						
//						/**调用支付逻辑*/
//						initMobilePayInfo(redPackFlow, input, result);
//						
//					
//						
//					}else{
//						
//						result.setStatus(0);
//						result.setError("未开启打赏");
//						
//					}
//					
//				} else {
//					result.setStatus(0);
//					result.setError("接受打赏内容不存在");
//				}
			
		} else {
			result.setStatus(0);
			result.setError("红包信息不存在");
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
	public void initMobilePayInfo(CnContentRedpackFlow flow,ApiContentRedPackInput input,ApiContentRedPackResult result) {

		ApiWechatMobilePayInput mobilePayInput = new ApiWechatMobilePayInput();
		mobilePayInput.setOrderCode(flow.getCode());
		mobilePayInput.setRomoteIP(input.getRomoteIP());
		mobilePayInput.setServeIP(input.getServeIP());
		mobilePayInput.setPayMoney(flow.getMoney());
		mobilePayInput.setZoo(input.getZoo());
		ApiWechatMobilePayResult payResult = apiWechatMobilePay2.api(mobilePayInput);
		if (payResult.upFlagTrue()) {
			result.setWechatMobilePayResponse(payResult.getMobilePayInfo());
		} else {
			result.setStatus(payResult.getStatus());
			result.setError(payResult.getError());
		}

	}

}
