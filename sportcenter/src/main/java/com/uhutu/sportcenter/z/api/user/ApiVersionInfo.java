package com.uhutu.sportcenter.z.api.user;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.entity.SpAppVersion;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiVersionInfoInput;
import com.uhutu.sportcenter.z.result.ApiVersionInfoResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 手机版本更新提示接口
 * 
 * @author xiegj @version1.0
 */
@Service
public class ApiVersionInfo extends RootApiBase<ApiVersionInfoInput, ApiVersionInfoResult> {
	
	@Autowired
	private UserServiceFactory serviceFactory;

	protected ApiVersionInfoResult process(ApiVersionInfoInput inputParam) {
		
		ApiVersionInfoResult result = new ApiVersionInfoResult();
		
		SpAppVersion appVersion = serviceFactory.getAppVersionService().queryOrderByZcDesc(inputParam.getSystemType());
		
		if(appVersion != null){
			
			if(inputParam.getVersionNo().compareTo(appVersion.getVersionNo()) < 0){
				
				BeanUtils.copyProperties(appVersion, result);
				
			}
			
		}

		return result;
	}

}