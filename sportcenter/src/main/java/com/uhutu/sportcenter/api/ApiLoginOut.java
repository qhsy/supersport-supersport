package com.uhutu.sportcenter.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uhutu.dcom.user.entity.UcUserinfo;
import com.uhutu.dcom.user.enums.UserEnum;
import com.uhutu.dcom.user.service.UserServiceFactory;
import com.uhutu.sportcenter.api.input.ApiLoginOutInput;
import com.uhutu.sportcenter.api.result.ApiLoginOutResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 用户信息退出
 * @author pang_jhui
 *
 */
@Service
public class ApiLoginOut extends RootApiBase< ApiLoginOutInput,ApiLoginOutResult> {

	@Autowired
	private UserServiceFactory userServiceFactory;
	
	public ApiLoginOutResult process(ApiLoginOutInput inputParam ) {
		
		ApiLoginOutResult result = new ApiLoginOutResult();

		UcUserinfo ucUserinfo = userServiceFactory.getUserInfoService().queryByLoginName(inputParam.getLoginName());

		ucUserinfo.setFlag(UserEnum.FLAG_LOGINOUT.getCode());
		
		userServiceFactory.getUserInfoService().save(ucUserinfo);
		
		return result;
		
	}

}
