package com.uhutu.dcom.content.z.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.dao.ContentDaoFactory;
import com.uhutu.dcom.content.z.entity.CnAdvertiseInfo;
import com.uhutu.dcom.content.z.service.IAdvertiseInfoService;

/**
 * 广告基本信息业务逻辑实现
 * 
 * @author xiegj
 */

@Service
public class AdvertiseInfoServiceImpl implements IAdvertiseInfoService {

	@Autowired
	private ContentDaoFactory daoFacotry;

	@Override
	public CnAdvertiseInfo queryByCode(String code) {
		return daoFacotry.getAdvertiseInfoDao().queryByCode(code);
	}

	@Override
	public List<CnAdvertiseInfo> queryAll() {
		return daoFacotry.getAdvertiseInfoDao().queryAll();
	}

}
