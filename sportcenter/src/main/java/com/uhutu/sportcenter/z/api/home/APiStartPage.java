package com.uhutu.sportcenter.z.api.home;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.entity.UcClientInfo;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.APiStartPageInput;
import com.uhutu.sportcenter.z.result.APiStartPageResult;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoocom.z.bean.TopUserFactory;

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
		String userCode = "";
		if (StringUtils.isNotBlank(inputParam.getZoo().getToken())) {
			userCode = TopUserFactory.upUserCallFactory().upUserCodeByAuthToken(inputParam.getZoo().getToken(),
					DefineUser.Login_System_Default);
		}
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
		clientInfo.setUser_code(userCode);
		clientInfo.setChannelId(inputParam.getChannelId());
		userServiceFactory.getClientInfoService().save(clientInfo);
		return result;
	}

}
