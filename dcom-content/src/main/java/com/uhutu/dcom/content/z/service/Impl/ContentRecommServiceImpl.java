package com.uhutu.dcom.content.z.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uhutu.dcom.content.z.dao.ContentDaoFactory;
import com.uhutu.dcom.content.z.entity.CnContentRecomm;
import com.uhutu.dcom.content.z.service.IContentRecommService;

/**
 * 内容推荐信息业务实现
 * @author 逄小帅
 *
 */
@Service
public class ContentRecommServiceImpl implements IContentRecommService {
	
	@Autowired
	private ContentDaoFactory contentDaoFactory;

	@Override
	public void save(CnContentRecomm contentRecomm) {
		
		

	}

	@Override
	public List<CnContentRecomm> queryByContentCode(String contentCode) {
		
		return contentDaoFactory.getContentRecommDao().queryByCode(contentCode);
		
	}

	@Override
	public CnContentRecomm queryEntityByCode(String contentCode) {
		
		return contentDaoFactory.getContentRecommDao().queryEntityByCode(contentCode);
		
	}

}
