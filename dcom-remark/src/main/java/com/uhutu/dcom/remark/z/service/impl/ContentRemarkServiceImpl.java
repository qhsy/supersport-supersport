package com.uhutu.dcom.remark.z.service.impl;

import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.uhutu.dcom.component.z.page.QueryConditionUtil;
import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.config.enums.PrexEnum;
import com.uhutu.dcom.remark.z.dao.ContentRemarkDaoFactory;
import com.uhutu.dcom.remark.z.entity.CnContentRemark;
import com.uhutu.dcom.remark.z.enums.RemarkEnum;
import com.uhutu.dcom.remark.z.service.IContentRemarkService;

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

			cnContentRemark.setStatus(RemarkEnum.FLAG_ENABLE.getCode());

			String dateStr = DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS");

			cnContentRemark.setZc(new Date());

			cnContentRemark.setCode(PrexEnum.CNR.name() + dateStr);

			daoFactory.getContentRemarkDao().save(cnContentRemark);

		}
		
	}

	@Override
	public Page<CnContentRemark> queryPage(int pageNum, int limit,QueryConditions conditions) {
		
		if(pageNum >= 1){
			
			pageNum--;
			
		}
		
		PageRequest page = new PageRequest(pageNum, limit);
		
		Specification<CnContentRemark> spec = QueryConditionUtil.buildSpecification(conditions);
		
		Page<CnContentRemark> contentInfoPage = daoFactory.getContentRemarkDao().findAll(spec, page);
		
		return contentInfoPage;
	}
	
	@Override
	public CnContentRemark queryByCode(String code) {
		return daoFactory.getContentRemarkDao().queryByCode(code);
	}

	@Override
	public List<CnContentRemark> queryByContentCode(String contentCode) {
		return daoFactory.getContentRemarkDao().queryByContentCode(contentCode);
	}

	@Override
	public int queryCount(String contentCode) {
		
		return daoFactory.getContentRemarkDao().queryCount(contentCode);
		
	}

}
