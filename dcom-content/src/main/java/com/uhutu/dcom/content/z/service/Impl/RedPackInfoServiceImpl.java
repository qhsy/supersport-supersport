package com.uhutu.dcom.content.z.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.entity.CnRedPackUser;
import com.uhutu.dcom.content.z.service.IRedPackInfoService;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
/**
 * 红包信息财务信息
 * @author 逄小帅
 *
 */
@Service
public class RedPackInfoServiceImpl implements IRedPackInfoService {

	@Override
	public List<CnRedPackUser> getRedPackUsers(String liveNO, String status) {
		
		MDataMap mWhereMap = new MDataMap();
		
		mWhereMap.put("busiCode", liveNO);
		
		mWhereMap.put("status", status);
		
		List<CnRedPackUser> redPackUsers = JdbcHelper.queryForList(CnRedPackUser.class, "", "", "", mWhereMap);
		
		return redPackUsers;
	}

}
