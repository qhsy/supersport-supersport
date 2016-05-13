package com.uhutu.sportcenter.z.api.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.entity.UcClientInfo;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.APiStartPageInput;
import com.uhutu.sportcenter.z.result.APiStartPageResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * app启动接口
 * 
 * @author xiegj
 * 
 */
@Service
public class APiStartPage extends RootApiBase<APiStartPageInput, APiStartPageResult> {

	@Autowired
	private UserServiceFactory userServiceFactory;

	public APiStartPageResult process(APiStartPageInput inputParam) {
		APiStartPageResult result = new APiStartPageResult();

		UcClientInfo clientInfo = new UcClientInfo();
		clientInfo.setApp_vision(inputParam.getApp_vision());
		clientInfo.setFromCode(inputParam.getFrom());
		clientInfo.setIdfa(inputParam.getIdfa());
		clientInfo.setMac(inputParam.getMac());
		clientInfo.setModel(inputParam.getModel());
		clientInfo.setNet_type(inputParam.getNet_type());
		clientInfo.setOp(inputParam.getOp());
		clientInfo.setOs(inputParam.getOs());
		clientInfo.setOs_info(inputParam.getOs_info());
		clientInfo.setProduct(inputParam.getProduct());
		clientInfo.setScreen(inputParam.getScreen());
		clientInfo.setUniqid(inputParam.getUniqid());
		clientInfo.setUser_code("");
		userServiceFactory.getClientInfoService().save(clientInfo);
		return result;
	}

}
