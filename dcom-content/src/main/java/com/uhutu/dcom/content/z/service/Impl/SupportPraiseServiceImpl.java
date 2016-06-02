package com.uhutu.dcom.content.z.service.Impl;

import java.util.Date;
import java.util.List;

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
import com.uhutu.dcom.content.z.dao.ContentDaoFactory;
import com.uhutu.dcom.content.z.entity.CnSupportPraise;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ISupportPraiseService;

/**
 * 点赞业务逻辑实现
 * 
 * @author xiegj
 */

@Service

public class SupportPraiseServiceImpl implements ISupportPraiseService {

	@Autowired
	private ContentDaoFactory daoFacotry;

	
	public List<CnSupportPraise> querybyUserCodeAndType(String type, String userCode) {
		return daoFacotry.getSupportPraiseDao().querybyUserCodeAndType(type, userCode);
	}

	
	public List<CnSupportPraise> querybyUserCode(String userCode) {
		return daoFacotry.getSupportPraiseDao().querybyUserCode(userCode);
	}

	
	public List<CnSupportPraise> querybyContentCode(String contentCode) {
		return daoFacotry.getSupportPraiseDao().querybyContentCode(contentCode);
	}

	
	public List<CnSupportPraise> querybyContentCodeAndtype(String type, String contentCode) {
		return daoFacotry.getSupportPraiseDao().querybyContentCodeAndType(type, contentCode);
	}

	
	public void save(CnSupportPraise praise) {
		
		if (StringUtils.isNoneBlank(praise.getZa()) && daoFacotry.getSupportPraiseDao().exists(praise.getZa())) {

			praise.setZu(new Date());

			daoFacotry.getSupportPraiseDao().save(praise);

		} else {

			praise.setZc(new Date());

			daoFacotry.getSupportPraiseDao().save(praise);

		}
		
	}
	
	public List<CnSupportPraise> querybyContentCodeAndUserCodeAndType(String type, String userCode,
			String contentCode) {
		List<CnSupportPraise> list = daoFacotry.getSupportPraiseDao()
				.querybyContentCodeAndUserCodeAndType(type, userCode, contentCode);
		return list;
	}


	public void cancelbyCCAndUCAndType(String type, String userCode, String contentCode) {
		daoFacotry.getSupportPraiseDao().cancelbyCCAndUCAndType(type, userCode, contentCode);
	}


	@Override
	public int queryCountByCode(String contentCode,String status) {
		
		return daoFacotry.getSupportPraiseDao().queryCountByCode(contentCode, status);
		
	}


	@Override
	public int favored(String type, String userCode, String contentCode) {
		
		return daoFacotry.getSupportPraiseDao().favored(type, userCode, contentCode);
		
	}


	@Override
	public CnSupportPraise query(String contentCode, String userCode, String type) {
		
		return daoFacotry.getSupportPraiseDao().query(contentCode, userCode, type);
		
	}


	@Override
	public int favored(String type, String userCode) {
		
		return daoFacotry.getSupportPraiseDao().favored(type, userCode,ContentEnum.FAVOR_STATUS_YES.getCode());
		
	}


	@Override
	public Page<CnSupportPraise> queryPageByCondition(int pageNum, int limit, QueryConditions conditions) {		

		if(pageNum >= 1){
			
			pageNum--;
			
		}
		
		Sort sort = new Sort(Direction.DESC,"zc");
		
		PageRequest page = new PageRequest(pageNum, limit,sort);
		
		Specification<CnSupportPraise> spec = QueryConditionUtil.buildSpecification(conditions);
		
		Page<CnSupportPraise> supportPraisePage = daoFacotry.getSupportPraiseDao().findAll(spec, page);
		
		return supportPraisePage;
		
	}

}
