package com.uhutu.dcom.user.z.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.dao.UserDaoFacotry;
import com.uhutu.dcom.user.z.entity.UcAttentionInfo;
import com.uhutu.dcom.user.z.service.IAttentionInfoService;

@Service
public class AttentionInfoServiceImpl implements IAttentionInfoService {

	@Autowired
	private UserDaoFacotry userDaoFacotry;

	@Override
	public void save(UcAttentionInfo attentionInfo) {
		userDaoFacotry.getAttentionInfoDao().save(attentionInfo);

	}

	@Override
	public List<UcAttentionInfo> queryByAttention(String attention) {
		return userDaoFacotry.getAttentionInfoDao().queryByAttention(attention);
	}

	@Override
	public List<UcAttentionInfo> queryByBeAttention(String beAttention) {
		return userDaoFacotry.getAttentionInfoDao().queryByBeAttention(beAttention);
	}

	@Override
	public UcAttentionInfo queryByBothCode(String attention, String beAttention) {
		return userDaoFacotry.getAttentionInfoDao().queryByBothCode(attention, beAttention);
	}

}
