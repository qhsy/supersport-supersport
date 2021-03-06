package com.uhutu.dcom.user.z.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.dao.UserDaoFacotry;
import com.uhutu.dcom.user.z.entity.UcAttendReg;
import com.uhutu.dcom.user.z.entity.UcAttentionInfo;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.enums.UserEnum;
import com.uhutu.dcom.user.z.service.IUserInfoService;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.user.UserCallFactory;
import com.uhutu.zooweb.user.UserReginsterInput;
import com.uhutu.zooweb.user.UserReginsterResult;

/**
 * 用户业务处理实现
 * 
 * @author pang_jhui
 *
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {

	@Autowired
	private UserDaoFacotry userDaoFacotry;

	@Override
	public void save(UcUserinfo ucUserinfo) {

		if (StringUtils.isNoneBlank(ucUserinfo.getZa()) && userDaoFacotry.getUserInfoDao().exists(ucUserinfo.getZa())) {

			ucUserinfo.setZu(new Date());

			userDaoFacotry.getUserInfoDao().save(ucUserinfo);

		} else {

			ucUserinfo.setZc(new Date());

			userDaoFacotry.getUserInfoDao().save(ucUserinfo);

		}

	}

	@Override
	public UcUserinfo query(String id) {

		return userDaoFacotry.getUserInfoDao().findOne(id);

	}

	@Override
	public UcUserinfo queryByCode(String code) {

		return userDaoFacotry.getUserInfoDao().queryByCode(code);

	}

	@Override
	public UcUserinfo queryByLoginName(String loginName,String flag) {

		return userDaoFacotry.getUserInfoDao().queryByLoginName(loginName,flag);

	}
	
	@Override
	public UserReginsterResult regAuthUser(String loginName, String loginPass){
		
		UserReginsterInput input = new UserReginsterInput();
		
		input.setLoginName(loginName);
		
		input.setLoginPass(loginPass);
		
		input.setLoginSystem(DefineUser.Login_System_Default);
		
		UserCallFactory userCallFactory = new UserCallFactory();
		
		return userCallFactory.userReginster(input);
		
	}

	@Override
	public void attendOffice(String userCode) {

		MDataMap paramMap = new MDataMap();

		paramMap.put("status", UserEnum.ATTEND.getCode());

		List<UcAttendReg> attendRegs = JdbcHelper.queryForList(UcAttendReg.class, "", "", "", paramMap);

		attendRegs.forEach(attendReg -> {

			UcAttentionInfo attentionInfo = new UcAttentionInfo();
			attentionInfo.setAttention(userCode);
			attentionInfo.setBeAttention(attendReg.getUserCode());
			attentionInfo.setStatus(UserEnum.ATTEND.getCode());
			attentionInfo.setZc(new Date());

			JdbcHelper.insert(attentionInfo);

		});

	}

}
