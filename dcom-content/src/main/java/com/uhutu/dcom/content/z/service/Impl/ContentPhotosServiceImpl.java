package com.uhutu.dcom.content.z.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.dao.ContentDaoFactory;
import com.uhutu.dcom.content.z.entity.CnContentPhotos;
import com.uhutu.dcom.content.z.service.IContentPhotosService;

/**
 * 图集业务实现
 * @author pang_jhui
 *
 */
@Service
public class ContentPhotosServiceImpl implements IContentPhotosService {
	
	@Autowired
	private ContentDaoFactory daoFactory;

	@Override
	public void save(List<CnContentPhotos> cnContentPhotos) {
		
		daoFactory.getContentPhotosDao().save(cnContentPhotos);
		
	}

	@Override
	public List<CnContentPhotos> queryByContentCode(String code) {
		
		return daoFactory.getContentPhotosDao().queryByCode(code);
		
	}

	@Override
	public void save(CnContentPhotos cnContentPhotos) {
	
		daoFactory.getContentPhotosDao().save(cnContentPhotos);
		
	}

}
