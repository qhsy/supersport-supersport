package com.uhutu.dcom.user.z.service.impl;

import java.util.List;

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

	@Override
	public int queryFansCount(String userCode, String status) {
		
		return userDaoFacotry.getAttentionInfoDao().queryFansCount(userCode, status);
	}

	@Override
	public int queryAttendCount(String userCode, String status) {
		
		return userDaoFacotry.getAttentionInfoDao().queryAttendCount(userCode, status);
	}

	@Override
	public Page<UcAttentionInfo> queryPageByCondition(int pageNum, int limit, QueryConditions conditions) {		

		if(pageNum >= 1){
			
			pageNum--;
			
		}
		
		Sort sort = new Sort(Direction.DESC,"zc");
		
		PageRequest page = new PageRequest(pageNum, limit,sort);
		
		Specification<UcAttentionInfo> spec = QueryConditionUtil.buildSpecification(conditions);
		
		Page<UcAttentionInfo> contentInfoPage = userDaoFacotry.getAttentionInfoDao().findAll(spec, page);
		
		return contentInfoPage;
		
	}

}
