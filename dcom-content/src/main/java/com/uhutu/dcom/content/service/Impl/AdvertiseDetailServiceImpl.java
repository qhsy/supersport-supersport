package com.uhutu.dcom.content.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhutu.dcom.content.dao.ContentDaoFactory;
import com.uhutu.dcom.content.entity.CnAdvertiseDetail;
import com.uhutu.dcom.content.service.IAdvertiseDetailService;

/**
 * 广告基本信息业务逻辑实现
 * 
 * @author xiegj
 */

@Service
@Transactional(readOnly = true)
public class AdvertiseDetailServiceImpl implements IAdvertiseDetailService {

	@Autowired
	private ContentDaoFactory daoFacotry;

	@Override
	public List<CnAdvertiseDetail> queryByCode(String code) {
		return daoFacotry.getAdvertiseDetailDao().queryByCode(code);
	}

}
