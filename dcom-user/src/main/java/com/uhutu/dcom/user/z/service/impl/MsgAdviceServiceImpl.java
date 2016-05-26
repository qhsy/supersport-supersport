package com.uhutu.dcom.user.z.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.dao.UserDaoFacotry;
import com.uhutu.dcom.user.z.entity.UcMsgAdvice;
import com.uhutu.dcom.user.z.service.IMsgAdviceService;

/**
 * 意见反馈
 * @author 逄小帅
 *
 */

@Service
public class MsgAdviceServiceImpl implements IMsgAdviceService {
	
	@Autowired
	private UserDaoFacotry daoFactory;

	@Override
	public void save(UcMsgAdvice ucMsgAdvice) {
		
		if(StringUtils.isNoneBlank(ucMsgAdvice.getZa()) &&
				daoFactory.getMsgAdviceDao().exists(ucMsgAdvice.getZa())){
			
			ucMsgAdvice.setZu(new Date());
			
		}else{
			
			ucMsgAdvice.setZc(new Date());
			
		}
		
		daoFactory.getMsgAdviceDao().save(ucMsgAdvice);

	}

}
