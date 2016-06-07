package com.uhutu.sportcenter.z.api.donate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.user.z.entity.UcDonateFlow;
import com.uhutu.dcom.user.z.entity.UcDonateInfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoDonate;
import com.uhutu.dcom.user.z.entity.UcUserinfoExpert;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
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
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiUpdateUserPowerResult process(ApiUpdateUserPowerInput input) {
		
		ApiUpdateUserPowerResult result = new ApiUpdateUserPowerResult();
		
		if(input.getDonatePower() < 0){
			
			result.inError(81100008);
			
		}
		
		if(result.upFlagTrue()){
			
			/*更新捐赠者用户信息*/
			long donatePower = updateUserDonate(upUserCode(), input.getDonatePower(), result);
			
			/*更新达人用户信息*/
			updateUserExpert(input.getUserCode(), donatePower, result);
			
			/*更新用户捐赠信息*/
			updateDonateInfo(upUserCode(), input.getUserCode(), donatePower, result);
			
			/*更新捐赠流水*/
			saveDonateFlow(upUserCode(), input.getUserCode(), donatePower, result);
			
		}
		
		return result;
	}
	
	/**
	 * 更新达人能量值
	 * @param userCode
	 * 		用户编号
	 * @param donatePower
	 * 		捐赠能量值
	 * @param result
	 * 		处理结果
	 */
	public void updateUserExpert(String userCode,long donatePower,ApiUpdateUserPowerResult result){
		
		if(result.upFlagTrue()){
			
			UcUserinfoExpert expert = userServiceFactory.getUserInfoExpertService().queryByCode(userCode);
			
			if(expert != null){
				
				long power = expert.getPower() + donatePower;
				
				expert.setPower(power);
				
				userServiceFactory.getUserInfoExpertService().save(expert);
				
			}else{
				
				result.inError(81100008);
				
			}
			
		}
		
	}
	
	/**
	 * 更新捐赠用户信息，扣除可用捐赠能量
	 * @param userCode
	 * 		用户编号
	 * @param donatePower
	 * 		捐赠能量
	 * @param result
	 * 		处理结果
	 * @return 实际需要累加的能量值
	 * 
	 */
	public long updateUserDonate(String userCode,long donatePower,ApiUpdateUserPowerResult result){
		
		/*实际需要累加的能量值*/
		long actualPlusPower = 0;
		
		if(result.upFlagTrue()){
			
			UcUserinfoDonate userInfoDonate = userServiceFactory.getUserInfoDonateService().queryByUserCode(userCode);
			
			if(userInfoDonate != null){
				
				long freePower = 0;
				
				/*若是可用能量值不足，直接用可用能量值累加*/
				if(userInfoDonate.getFreePower() < donatePower){
					
					actualPlusPower = userInfoDonate.getFreePower();
					
				}else{
					
					actualPlusPower = donatePower;
					
					freePower = userInfoDonate.getFreePower() - donatePower;
					
				}
				
				userInfoDonate.setFreePower(freePower);
				
				userServiceFactory.getUserInfoDonateService().save(userInfoDonate);
				
			}else{
				
				result.inError(81100010);
				
			}
			
			
		}
		
		return actualPlusPower;
		
	}
	
	/**
	 * 更新捐赠信息
	 * @param supportCode
	 * 		支持者用户编号
	 * @param beSupoortCode
	 * 		被支持者用户编号
	 * @param donatePower
	 * 		捐赠能量值
	 * @param result
	 */
	public void updateDonateInfo(String supportCode,String beSupportCode,long donatePower,ApiUpdateUserPowerResult result){
		
		if(result.upFlagTrue()){
			
			UcDonateInfo donateInfo = userServiceFactory.getUserDonateInfoService().queryByCode(supportCode, beSupportCode);
			
			if(donateInfo != null){
				
				long totalPower = donateInfo.getTotalPower() + donatePower;
				
				donateInfo.setTotalPower(totalPower);
				
			}else{
				
				donateInfo = new UcDonateInfo();
				
				donateInfo.setBeSupportCode(beSupportCode);
				
				donateInfo.setSupportCode(supportCode);
				
				donateInfo.setTotalPower(donatePower);
				
				
			}
			
			userServiceFactory.getUserDonateInfoService().save(donateInfo);
			
		}
		
	}
	
	/**
	 * 保存捐赠流水信息
	 * @param supportCode
	 * 		捐赠者用户编号
	 * @param beSupportCode
	 * 		被捐赠者用户编号
	 * @param donatePower
	 * 		捐赠能量值
	 * @param result
	 * 		处理结果
	 */
	public void saveDonateFlow(String supportCode,String beSupportCode,long donatePower,ApiUpdateUserPowerResult result){
		
		if(result.upFlagTrue()){
			
			UcDonateFlow donateFlow = new UcDonateFlow();
			
			donateFlow.setBeSupportCode(beSupportCode);
			
			donateFlow.setSupportCode(supportCode);
			
			donateFlow.setTotalPower(donatePower);
			
			Date createDate = new Date();
			
			donateFlow.setZc(createDate);
			
			donateFlow.setZc(createDate);
			
			userServiceFactory.getUserDonateFlowService().save(donateFlow);
			
		}
		
	}

}
