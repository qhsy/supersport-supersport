package com.uhutu.dcom.remark.z.service.impl;

import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uhutu.dcom.remark.z.dao.ContentRemarkDaoFactory;
import com.uhutu.dcom.remark.z.entity.CnSupportComplain;
import com.uhutu.dcom.remark.z.service.ISupportComplainService;

/**
 * 投诉举报
 * @author 逄小帅
 *
 */
@Service
public class SupportComplainServiceImpl implements ISupportComplainService {
	
	@Autowired
	private ContentRemarkDaoFactory daoFactory;

	@Override
	public void save(CnSupportComplain cnSupportComplain) {
		
		if(StringUtils.isNoneBlank(cnSupportComplain.getZa()) && daoFactory.getSupportComplainDao().exists(cnSupportComplain.getZa())){
			
			cnSupportComplain.setZu(new Date());
			
		}else{
			
			cnSupportComplain.setZc(new Date());
			
		}
		
		daoFactory.getSupportComplainDao().save(cnSupportComplain);

	}

}
