package com.uhutu.dcom.remark.z.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.config.enums.PrexEnum;
import com.uhutu.dcom.remark.z.dao.ContentRemarkDaoFactory;
import com.uhutu.dcom.remark.z.entity.CnContentRemark;
import com.uhutu.dcom.remark.z.enums.RemarkEnum;
import com.uhutu.dcom.remark.z.service.IContentRemarkService;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
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
	public List<CnContentRemark> queryPage(String contentCode, PageInfo pageInfo) {
		
		StringBuffer statusBuffer = new StringBuffer("status in (");
		
		statusBuffer.append("'").append(RemarkEnum.FLAG_DEL.getCode()).append("',");
		
		statusBuffer.append("'").append(RemarkEnum.FLAG_ENABLE.getCode()).append("') and ");
		
		statusBuffer.append("content_code = '").append(contentCode).append("'");
		
		int iStart = (pageInfo.getPagination() -1) * pageInfo.getPageNum();
		
		int count = JdbcHelper.count(CnContentRemark.class, statusBuffer.toString(), new MDataMap());
		
		pageInfo.setTotal(count);
		
		List<CnContentRemark> cnContentRemarks = JdbcHelper.queryForList(CnContentRemark.class, "", "-zc", statusBuffer.toString(), new MDataMap(), iStart, pageInfo.getPageNum());
		
		return cnContentRemarks;
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
	public int queryCount(String contentCode, String status) {
		
		return daoFactory.getContentRemarkDao().queryCount(contentCode, status);
		
	}

}
