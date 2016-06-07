package com.uhutu.dcom.user.z.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.dao.UserDaoFacotry;
import com.uhutu.dcom.user.z.entity.UcDonateDevice;
import com.uhutu.dcom.user.z.service.IUserDonateDeviceService;

/**
 * 用户捐赠设备
 * @author 逄小帅
 *
 */
@Service
public class UserDonateDeviceServiceImpl implements IUserDonateDeviceService {
	
	@Autowired
	private UserDaoFacotry userDaoFactory;

	@Override
	public UcDonateDevice queryByDeviceId(String deviceId) {
		
		return userDaoFactory.getUserDonateDeviceDao().queryByDeviceId(deviceId);
		
	}

	@Override
	public void save(UcDonateDevice donateDevice) {
		
		if(StringUtils.isNotEmpty(donateDevice.getZa())
				&& userDaoFactory.getUserDonateDeviceDao().exists(donateDevice.getZa())){
			
			donateDevice.setZu(new Date());
			
		}else{
			
			donateDevice.setZc(new Date());
			
		}
		
		userDaoFactory.getUserDonateDeviceDao().save(donateDevice);
		
	}

}
