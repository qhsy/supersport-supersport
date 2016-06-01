package com.uhutu.dcom.user.z.service.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.page.QueryConditionUtil;
import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.dao.UserDaoFacotry;
import com.uhutu.dcom.user.z.entity.UcMsgRemark;
import com.uhutu.dcom.user.z.service.IMsgRemarkService;

/**
 * 消息评论service实现
 * @author 逄小帅
 *
 */
@Service
public class MsgRemarkServiceImpl implements IMsgRemarkService {
	
	@Autowired
	private UserDaoFacotry userDaoFacotry;

	@Override
	public void save(UcMsgRemark ucMsgRemark) {
		
		if (StringUtils.isNoneBlank(ucMsgRemark.getZa()) && userDaoFacotry.getUserInfoDao().exists(ucMsgRemark.getZa())) {

			ucMsgRemark.setZu(new Date());

			userDaoFacotry.getMsgRemarkDao().save(ucMsgRemark);

		} else {

			ucMsgRemark.setZc(new Date());

			userDaoFacotry.getMsgRemarkDao().save(ucMsgRemark);

		}

	}

	@Override
	public int queryCount(String userCode, String status) {
		
		return userDaoFacotry.getMsgRemarkDao().queryCount(userCode, status);
	}

	@Override
	public Page<UcMsgRemark> queryPageByUserCode(int pageNum, int limit, QueryConditions conditions) {
		
		if(pageNum >= 1){
			
			pageNum--;
			
		}
		
		Sort sort = new Sort(Direction.DESC,"msgTime");
		
		PageRequest page = new PageRequest(pageNum, limit,sort);
		
		Specification<UcMsgRemark> spec = QueryConditionUtil.buildSpecification(conditions);
		
		Page<UcMsgRemark> msgRemarkPage = userDaoFacotry.getMsgRemarkDao().findAll(spec, page);
		
		return msgRemarkPage;
		
	}

	@Override
	@Transactional
	public int updateReadStatus(String userCode, String updateStatus, String whereStatus) {
		
		return userDaoFacotry.getMsgRemarkDao().updateReadStatus(userCode, updateStatus, whereStatus);
		
	}

}
