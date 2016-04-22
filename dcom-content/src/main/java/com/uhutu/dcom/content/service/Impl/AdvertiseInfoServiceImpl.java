package com.uhutu.dcom.content.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhutu.dcom.content.dao.AdvertiseInfoDaoFacotry;
import com.uhutu.dcom.content.entity.CnAdvertiseInfo;
import com.uhutu.dcom.content.service.IAdvertiseInfoService;

/**
 * 广告基本信息业务逻辑实现
 * 
 * @author xiegj
 */

@Service
@Transactional(readOnly = true)
public class AdvertiseInfoServiceImpl implements IAdvertiseInfoService {

	@Autowired
	private AdvertiseInfoDaoFacotry contentCategoryDaoFacotry;

	@Override
	public CnAdvertiseInfo queryByCode(String code) {
		return contentCategoryDaoFacotry.getAdvertiseInfoDao().queryByCode(code);
	}

	@Override
	public List<CnAdvertiseInfo> queryAll() {
		return contentCategoryDaoFacotry.getAdvertiseInfoDao().queryAll();
	}

}
