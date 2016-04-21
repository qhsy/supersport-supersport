package com.uhutu.dcom.content.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhutu.dcom.content.dao.SupportPraiseDaoFacotry;
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

	
	private SupportPraiseDaoFacotry supportPraiseDaoFacotry;

	
	public List<CnSupportPraise> querybyUserCodeAndType(String type, String userCode) {
		return supportPraiseDaoFacotry.getSupportPraiseDao().querybyUserCodeAndType(type, userCode);
	}

	
	public List<CnSupportPraise> querybyUserCode(String userCode) {
		return supportPraiseDaoFacotry.getSupportPraiseDao().querybyUserCode(userCode);
	}

	
	public List<CnSupportPraise> querybyContentCode(String contentCode) {
		return supportPraiseDaoFacotry.getSupportPraiseDao().querybyContentCode(contentCode);
	}

	
	public List<CnSupportPraise> querybyContentCodeAndtype(String type, String contentCode) {
		return supportPraiseDaoFacotry.getSupportPraiseDao().querybyContentCodeAndType(type, contentCode);
	}

	
	public void save(CnSupportPraise praise) {
		List<CnSupportPraise> list = querybyContentCodeAndUserCodeAndType(praise.getType(), praise.getUserCode(),
				praise.getContentCode());
		if (list == null || list.isEmpty() || list.size() == 0) {
			supportPraiseDaoFacotry.getSupportPraiseDao().save(praise);
		}
	}

	
	public void delete(CnSupportPraise praise) {
		supportPraiseDaoFacotry.getSupportPraiseDao().delete(praise);
	}

	
	public void deleteByContentCodeAndUserCode(String contentCode, String userCode, String type) {
		List<CnSupportPraise> list = querybyContentCodeAndUserCodeAndType(type, userCode, contentCode);
		if (list != null && !list.isEmpty() && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				supportPraiseDaoFacotry.getSupportPraiseDao().delete(list.get(i));
			}
		}
	}

	
	public List<CnSupportPraise> querybyContentCodeAndUserCodeAndType(String type, String userCode,
			String contentCode) {
		List<CnSupportPraise> list = supportPraiseDaoFacotry.getSupportPraiseDao()
				.querybyContentCodeAndUserCodeAndType(type, userCode, contentCode);
		return list;
	}

}
