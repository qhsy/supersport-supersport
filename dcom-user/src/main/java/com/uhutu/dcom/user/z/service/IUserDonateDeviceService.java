package com.uhutu.dcom.user.z.service;

import com.uhutu.dcom.user.z.entity.UcDonateDevice;

/**
 * 用户捐赠设备业务实现
 * @author 逄小帅
 *
 */
public interface IUserDonateDeviceService {
	
	/**
	 * 查询设备信息
	 * @param deviceId
	 * 		设备
	 * @return 用户设备编号
	 */
	public UcDonateDevice queryByDeviceId(String deviceId);
	
	/**
	 * 保存设备信息
	 * @param donateDevice
	 */
	public void save(UcDonateDevice donateDevice);

}
