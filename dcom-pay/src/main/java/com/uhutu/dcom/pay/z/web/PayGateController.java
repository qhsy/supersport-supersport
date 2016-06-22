package com.uhutu.dcom.pay.z.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.process.impl.PayGateProcess;
import com.uhutu.dcom.pay.z.service.PayNotifyComponent;
import com.uhutu.dcom.pay.z.util.BeanComponent;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;

/**
 * 支付网关相关web controller
 * @author 逄小帅
 *
 */
@Controller
@RequestMapping("payGate")
public class PayGateController{
	
	@Autowired
	private PayGateProcess payGateProcess;
	
	/**
	 * 提供给支付网关回调
	 * @param request
	 * 		请求信息
	 * @param payType
	 * 		WECHAT_CALLBACK 微信回调
	 * 		ALIPAY_CALLBACK 支付宝回调
	 * @return 响应信息
	 */
	@RequestMapping(value = "/payGateCallBack/{notifyType}")
	public String payGateCallBack(@PathVariable("notifyType") String notifyType,HttpServletRequest request,HttpServletResponse response) {
		
		response.setContentType("text/html;charset=UTF-8");
		
		MDataMap mDataMap = BeanComponent.getInstance().convertRequest(request);
		
		notifyType = StringUtils.upperCase(notifyType);
		
		PayProcessEnum processEnum = PayProcessEnum.valueOf(notifyType);

		IPayResponse payResponse = payGateProcess.process(processEnum, null, mDataMap);
		
		String returnStr = PayNotifyComponent.prase(processEnum, payResponse);
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = null;
		
		try {
			
			out = response.getWriter();
			out.print(returnStr);
			out.close();
			
		} catch (IOException e) {
			
			TopHelper.upInfo(81110003, e.getMessage());
			
		}
		
		return null;

	}

}
