package com.uhutu.dcom.user.z.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.uhutu.dcom.user.z.entity.UcDonateDevice;

/**
 * 用户捐赠设备dao
 * @author 逄小帅
 *
 */
public interface IUserDonateDeviceDao extends JpaRepository<UcDonateDevice, String> {
	
	@Query("select t from UcDonateDevice t where deviceId=:deviceId")
	public UcDonateDevice queryByDeviceId(@Param("deviceId") String deviceId);

}
