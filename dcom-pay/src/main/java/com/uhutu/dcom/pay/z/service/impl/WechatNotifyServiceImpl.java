package com.uhutu.dcom.pay.z.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.common.WechatUnifyResultCodeEnum;
import com.uhutu.dcom.pay.z.config.PayConfigFactory;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.request.WechatNotifyRequest;
import com.uhutu.dcom.pay.z.response.WechatNotifyResponse;
import com.uhutu.dcom.pay.z.response.WechatUnifyResponse;
import com.uhutu.dcom.pay.z.service.IWechatNotifyFunc;
import com.uhutu.dcom.pay.z.service.IWechatNotifyService;
import com.uhutu.dcom.pay.z.util.BeanComponent;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.model.MResult;

/**
 * 支付网关回调业务实现
 * @author 逄小帅
 *
 */
@Service
public class WechatNotifyServiceImpl implements IWechatNotifyService {
	
	@Autowired
	private PayConfigFactory configFactory;

	@Override
	public IPayResponse doProcess(IPayRequest request,MDataMap paramMap) {
		
		WechatNotifyRequest notifyRequest = (WechatNotifyRequest) request;
		
		WechatNotifyResponse notifyResponse = new WechatNotifyResponse();
		
		try {
			
			notifyRequest.setAppid(configFactory.getWechatConfig().getServiceAppId());
			
			notifyRequest.setMch_id(configFactory.getWechatConfig().getServiceMchId());
			
			MDataMap requestMap = BeanComponent.getInstance().objectToMap(notifyRequest, WechatUnifyResponse.class, true);
			
			requestMap.remove("sign");
			
			requestMap.remove(WechatUnifyResultCodeEnum.processType.name());
			
			String requestSign = configFactory.getWechatConfig().getSign(requestMap, notifyRequest.getProcessType());
			
			if(StringUtils.equals(requestSign, notifyRequest.getSign())){
				
				IWechatNotifyFunc notifyFunc = initNotifyFunc(notifyRequest.getProcessType());
				
				MResult mResult = notifyFunc.doAfter(notifyRequest);
				
				if(mResult.upFlagTrue()){
					
					notifyResponse.setReturn_code(WechatUnifyResultCodeEnum.SUCCESS.name());
					
					notifyResponse.setReturn_msg(WechatUnifyResultCodeEnum.OK.name());
					
				}else{
					
					notifyResponse.setReturn_code(WechatUnifyResultCodeEnum.FAIL.name());
					
					notifyResponse.setReturn_msg(mResult.getError());
					
				}
				
				
			}else{
				
				notifyResponse.setReturn_code(WechatUnifyResultCodeEnum.FAIL.name());
				
				notifyResponse.setReturn_msg(TopHelper.upInfo(81110005));
				
				
			}
			
		} catch (Exception e) {
			
			notifyResponse.setReturn_code(WechatUnifyResultCodeEnum.FAIL.name());
			
			notifyResponse.setReturn_msg(e.getMessage());
			
		}
		
		return notifyResponse;
		
	}
	
	/**
	 * 初始化支付回调业务func
	 * @param processEnum
	 * 		解析枚举
	 * @return 微信通知func
	 * @throws  
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public IWechatNotifyFunc initNotifyFunc(PayProcessEnum processEnum) throws Exception{
		
		String className = "";
		
		switch (processEnum) {
		case WECHAT_NOTIFY:
			className = "com.uhutu.sportcenter.z.pay.func.WechatH5PayNotifyFunc";
			break;
		case WECHATH5_NOTIFY:
			className = "com.uhutu.sportcenter.z.pay.func.WechatH5PayNotifyFunc";
			break;

		default:
			break;
		}
		
		return (IWechatNotifyFunc)Class.forName(className).newInstance();
		
	}

}
