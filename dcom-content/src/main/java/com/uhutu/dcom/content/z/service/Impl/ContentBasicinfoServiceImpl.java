package com.uhutu.dcom.content.z.service.Impl;

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
import com.uhutu.dcom.content.z.dao.ContentDaoFactory;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.service.IContentBasicinfoService;
import com.uhutu.zooweb.helper.WebHelper;

/**
 * 内容基本信息业务逻辑实现
 * 
 * @author xiegj
 */

@Service

public class ContentBasicinfoServiceImpl implements IContentBasicinfoService {

	@Autowired
	private ContentDaoFactory daoFacotry;

	@Override
	public CnContentBasicinfo queryByCode(String code) {
		return daoFacotry.getContentBasicinfoDao().queryByCode(code);
	}

	@Override
	public List<CnContentBasicinfo> queryAll(String shareScope) {
		return daoFacotry.getContentBasicinfoDao().queryAll(shareScope);
	}

	@Override
	public List<CnContentBasicinfo> queryByAuthor(String author) {
		return daoFacotry.getContentBasicinfoDao().queryByAuthor(author);
	}

	@Override
	public Page<CnContentBasicinfo> queryPage(int pageNum, int limit,QueryConditions conditions) {
		
		if(pageNum >= 1){
			
			pageNum--;
			
		}
		
		PageRequest page = new PageRequest(pageNum, limit);
		
		Specification<CnContentBasicinfo> spec = QueryConditionUtil.buildSpecification(conditions);
		
		Page<CnContentBasicinfo> contentInfoPage = daoFacotry.getContentBasicinfoDao().findAll(spec, page);
		
		return contentInfoPage;
	}

	@Override
	public void save(CnContentBasicinfo contentBasicinfo) {
		
		if(StringUtils.isNotBlank(contentBasicinfo.getZa())
				&& daoFacotry.getContentBasicinfoDao().exists(contentBasicinfo.getZa())){
			
			contentBasicinfo.setZu(new Date());
			
			daoFacotry.getContentBasicinfoDao().save(contentBasicinfo);
			
			
		}else{
			
			contentBasicinfo.setCode(WebHelper.upCode("CNBH"));
			
			contentBasicinfo.setPublishTime(new Date());
			
			contentBasicinfo.setZc(new Date());
			
			daoFacotry.getContentBasicinfoDao().save(contentBasicinfo);			
			
		}
		
		
	}

	@Override
	public String queryTitleByCode(String code) {
		
		return daoFacotry.getContentBasicinfoDao().queryTitleByCode(code);
		
	}

}
