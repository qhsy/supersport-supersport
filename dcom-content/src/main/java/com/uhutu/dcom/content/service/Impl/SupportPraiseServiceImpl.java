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

	@Autowired
	private SupportPraiseDaoFacotry supportPraiseDaoFacotry;
	
	@Autowired
	public List<CnSupportPraise> querybyUserCodeAndType(String type, String userCode) {
		return supportPraiseDaoFacotry.getSupportPraiseDao().querybyUserCodeAndType(type, userCode);
	}

	@Autowired
	public List<CnSupportPraise> querybyUserCode(String userCode) {
		return supportPraiseDaoFacotry.getSupportPraiseDao().querybyUserCode(userCode);
	}

	@Autowired
	public List<CnSupportPraise> querybyContentCode(String contentCode) {
		return supportPraiseDaoFacotry.getSupportPraiseDao().querybyContentCode(contentCode);
	}

	@Autowired
	public List<CnSupportPraise> querybyContentCodeAndtype(String type, String contentCode) {
		return supportPraiseDaoFacotry.getSupportPraiseDao().querybyContentCodeAndType(type, contentCode);
	}

}
