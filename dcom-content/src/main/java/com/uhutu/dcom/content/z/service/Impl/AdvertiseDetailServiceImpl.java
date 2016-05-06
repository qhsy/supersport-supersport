package com.uhutu.dcom.content.z.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.dao.ContentDaoFactory;
import com.uhutu.dcom.content.z.entity.CnAdvertiseDetail;
import com.uhutu.dcom.content.z.service.IAdvertiseDetailService;

/**
 * 广告基本信息业务逻辑实现
 * 
 * @author xiegj
 */

@Service
public class AdvertiseDetailServiceImpl implements IAdvertiseDetailService {

	@Autowired
	private ContentDaoFactory daoFacotry;

	@Override
	public List<CnAdvertiseDetail> queryByCode(String code) {
		return daoFacotry.getAdvertiseDetailDao().queryByCode(code);
	}

}
