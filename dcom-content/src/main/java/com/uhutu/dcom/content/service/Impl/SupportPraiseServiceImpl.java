package com.uhutu.dcom.content.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhutu.dcom.content.dao.ContentDaoFactory;
import com.uhutu.dcom.content.entity.CnSupportPraise;
import com.uhutu.dcom.content.service.ISupportPraiseService;

/**
 * 点赞业务逻辑实现
 * 
 * @author xiegj
 */

@Service
@Transactional(readOnly = true)
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
		List<CnSupportPraise> list = querybyContentCodeAndUserCodeAndType(praise.getType(), praise.getUserCode(),
				praise.getContentCode());
		if (list == null || list.isEmpty() || list.size() == 0) {
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

}
