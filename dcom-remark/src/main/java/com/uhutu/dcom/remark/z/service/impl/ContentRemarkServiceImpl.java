package com.uhutu.dcom.remark.z.service.impl;

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
import com.uhutu.dcom.config.enums.PrexEnum;
import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.remark.z.dao.ContentRemarkDaoFactory;
import com.uhutu.dcom.remark.z.entity.CnContentRemark;
import com.uhutu.dcom.remark.z.service.IContentRemarkService;
import com.uhutu.zooweb.helper.WebHelper;

/**
 * 内容评论业务实现
 * @author 逄小帅
 *
 */
@Service
public class ContentRemarkServiceImpl implements IContentRemarkService {
	
	@Autowired
	private ContentRemarkDaoFactory daoFactory;

	@Override
	public void save(CnContentRemark cnContentRemark) {
		
		if (StringUtils.isNoneBlank(cnContentRemark.getZa()) && daoFactory.getContentRemarkDao().exists(cnContentRemark.getZa())) {

			cnContentRemark.setZu(new Date());

			daoFactory.getContentRemarkDao().save(cnContentRemark);

		} else {

			cnContentRemark.setZc(new Date());

			cnContentRemark.setCode(WebHelper.upCode(PrexEnum.CNR.name()));

			daoFactory.getContentRemarkDao().save(cnContentRemark);

		}
		
	}

	@Override
	public Page<CnContentRemark> queryPage(int pageNum, int limit,QueryConditions conditions) {
		
		if(pageNum >= 1){
			
			pageNum--;
			
		}
		
		Sort sort = new Sort(Direction.DESC,"zc");
		
		PageRequest page = new PageRequest(pageNum, limit,sort);
		
		Specification<CnContentRemark> spec = QueryConditionUtil.buildSpecification(conditions);
		
		Page<CnContentRemark> contentInfoPage = daoFactory.getContentRemarkDao().findAll(spec, page);
		
		return contentInfoPage;
	}
	
	@Override
	public CnContentRemark queryByCode(String code) {
		return daoFactory.getContentRemarkDao().queryByCode(code,SystemEnum.YES.getCode());
	}

	@Override
	public List<CnContentRemark> queryByContentCode(String contentCode) {
		return daoFactory.getContentRemarkDao().queryByContentCode(contentCode);
	}

	@Override
	public int queryCount(String contentCode, String status) {
		
		return daoFactory.getContentRemarkDao().queryCount(contentCode, status);
		
	}

}
