package com.uhutu.dcom.user.z.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.uhutu.dcom.component.z.page.QueryConditionUtil;
import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.dao.UserDaoFacotry;
import com.uhutu.dcom.user.z.entity.UcMsgAttention;
import com.uhutu.dcom.user.z.service.IMsgAttentionService;

/**
 * 关注消息通知service实现
 * @author 逄小帅
 *
 */
@Service
public class MsgAttentionServiceImpl implements IMsgAttentionService {
	
	@Autowired
	private UserDaoFacotry userDaoFacotry;

	@Override
	public void save(UcMsgAttention ucMsgAttention) {
		
		if (StringUtils.isNoneBlank(ucMsgAttention.getZa()) && userDaoFacotry.getUserInfoDao().exists(ucMsgAttention.getZa())) {

			ucMsgAttention.setZu(new Date());

			userDaoFacotry.getMsgAttentionDao().save(ucMsgAttention);

		} else {

			ucMsgAttention.setZc(new Date());

			userDaoFacotry.getMsgAttentionDao().save(ucMsgAttention);

		}

	}

	@Override
	public int queryCount(String userCode, String status) {
		
		return userDaoFacotry.getMsgAttentionDao().queryByCode(userCode, status);
		
	}

	@Override
	public Page<UcMsgAttention> queryPageByUserCode(int pageNum, int limit, QueryConditions conditions) {
		
		if(pageNum >= 1){
			
			pageNum--;
			
		}
		
		PageRequest page = new PageRequest(pageNum, limit);
		
		Specification<UcMsgAttention> spec = QueryConditionUtil.buildSpecification(conditions);
		
		Page<UcMsgAttention> msgAttendPage = userDaoFacotry.getMsgAttentionDao().findAll(spec, page);
		
		return msgAttendPage;
	}

}
