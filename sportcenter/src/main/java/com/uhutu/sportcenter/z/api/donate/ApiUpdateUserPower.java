package com.uhutu.sportcenter.z.api.donate;

import org.springframework.stereotype.Component;
import com.uhutu.sportcenter.z.input.ApiUpdateUserPowerInput;
import com.uhutu.sportcenter.z.result.ApiUpdateUserPowerResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 更新用户能量值
 * @author pang_jhui
 *
 */
@Component
public class ApiUpdateUserPower extends RootApiToken<ApiUpdateUserPowerInput, ApiUpdateUserPowerResult> {

	@Override
	protected ApiUpdateUserPowerResult process(ApiUpdateUserPowerInput input) {
		
		return null;
	}
	
	/**
	 * 更新达人能量值
	 * @param userCode
	 * 		用户编号
	 * @param donatePower
	 * 		捐赠能量值
	 */
	public void updateUserExpert(String userCode,long donatePower){
		
		
		
	}
	
	/**
	 * 更新捐赠用户信息，扣除可用捐赠能量
	 * @param userCode
	 * 		用户编号
	 * @param donatePower
	 * 		捐赠能量
	 */
	public void updateUserDonate(String userCode,long donatePower){
		
		
		
	}
	
	/**
	 * 更新捐赠信息
	 * @param supportCode
	 * 		支持者用户编号
	 * @param beSupoortCode
	 * 		被支持者用户编号
	 * @param donatePower
	 * 		捐赠能量值
	 */
	public void updateDonateInfo(String supportCode,String beSupoortCode,long donatePower){
		
		
		
	}
	
	/**
	 * 保存捐赠流水信息
	 * @param supportCode
	 * 		捐赠者用户编号
	 * @param beSupportCode
	 * 		被捐赠者用户编号
	 * @param donatePower
	 * 		捐赠能量值
	 */
	public void saveDonateFlow(String supportCode,String beSupportCode,long donatePower){
		
		
		
	}

}
