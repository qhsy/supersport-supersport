package com.uhutu.sportcenter.z.api.donate;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.user.z.entity.UcDonateDevice;
import com.uhutu.dcom.user.z.entity.UcUserinfoDonate;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiUserPowerInitInput;
import com.uhutu.sportcenter.z.result.ApiUserPowerInitResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 用户能量初始化
 * @author 逄小帅
 *
 */
@Component
public class ApiUserPowerInit extends RootApiToken<ApiUserPowerInitInput, ApiUserPowerInitResult> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiUserPowerInitResult process(ApiUserPowerInitInput input) {

		ApiUserPowerInitResult powerInitResult = new ApiUserPowerInitResult();

		UcUserinfoDonate userInfoDonate = userServiceFactory.getUserInfoDonateService().queryByUserCode(upUserCode());
		
		UcDonateDevice ucDonateDevice = userServiceFactory.getUserDonateDeviceService().queryByDeviceId(input.getDeviceId());
		
		if(ucDonateDevice != null){
			
			if(DateUtils.isSameDay(new Date(), ucDonateDevice.getExpire())){
				
				if(!StringUtils.equals(upUserCode(), ucDonateDevice.getUserCode())){
					
					powerInitResult.inError(81100011);
					
				}
				
			}else{
				
				ucDonateDevice.setUserCode(upUserCode());
				
				userServiceFactory.getUserDonateDeviceService().save(ucDonateDevice);
				
			}
			
		}else{
			
			ucDonateDevice = new UcDonateDevice();
			
			ucDonateDevice.setDeviceId(input.getDeviceId());
			
			ucDonateDevice.setExpire(new Date());
			
			ucDonateDevice.setUserCode(upUserCode());
			
			userServiceFactory.getUserDonateDeviceService().save(ucDonateDevice);
			
		}
		

		/*初始热力值不能为负数*/
		if(input.getCurrPower() < 0){
			
			powerInitResult.inError(81100006);
			
		}
		
		if(powerInitResult.upFlagTrue()){
			
			if(userInfoDonate != null){
				
				/*热力值当天有效*/
				if(DateUtils.isSameDay(new Date(), userInfoDonate.getExpire())){
					
					long diff = input.getCurrPower() - userInfoDonate.getCurrPower();
					
					/*当天热力值差不能为负数*/
					if(diff >= 0){
						
						long freePower = userInfoDonate.getFreePower() + diff;
						
						userInfoDonate.setFreePower(freePower);
						
						userInfoDonate.setCurrPower(input.getCurrPower());
						
					}else{
						
						powerInitResult.inError(81100007);
						
					}
					
				}else{
					
					userInfoDonate.setExpire(new Date());
					
					userInfoDonate.setCurrPower(input.getCurrPower());
					
					userInfoDonate.setFreePower(input.getCurrPower());
					
				}
				
			}else{
				
				userInfoDonate = new UcUserinfoDonate();
				
				userInfoDonate.setUserCode(upUserCode());
				
				userInfoDonate.setCurrPower(input.getCurrPower());
				
				userInfoDonate.setDeviceId(input.getDeviceId());
				
				userInfoDonate.setExpire(new Date());
				
				userInfoDonate.setFreePower(input.getCurrPower());
				
			}
			
			if(powerInitResult.upFlagTrue()){
				
				if(userInfoDonate.getFreePower() > 99999){
					
					userInfoDonate.setFreePower(99999);
					
				}
				
				userServiceFactory.getUserInfoDonateService().save(userInfoDonate);
				
			}
			
		}
		
		return powerInitResult;
	}
	
	

}
