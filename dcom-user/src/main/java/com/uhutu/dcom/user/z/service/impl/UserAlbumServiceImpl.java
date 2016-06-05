package com.uhutu.dcom.user.z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.page.QueryConditionUtil;
import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.dao.UserDaoFacotry;
import com.uhutu.dcom.user.z.entity.UcUserAlbum;
import com.uhutu.dcom.user.z.service.IUserAlbumService;

/**
 * 查询分页信息根据查询条件
 * @author pang_jhui
 *
 */
@Service
public class UserAlbumServiceImpl implements IUserAlbumService {
	
	@Autowired
	private UserDaoFacotry userDaoFactory;

	@Override
	public Page<UcUserAlbum> queryPageByCondition(int pageNum, int limit, QueryConditions conditions) {
		
		if(pageNum >= 1){
			
			pageNum--;
			
		}
		
		Sort sort = new Sort(Direction.ASC,"sort");
		
		PageRequest page = new PageRequest(pageNum, limit,sort);
		
		Specification<UcUserAlbum> spec = QueryConditionUtil.buildSpecification(conditions);
		
		Page<UcUserAlbum> albumPage = userDaoFactory.getUserAlbumDao().findAll(spec, page);
		
		return albumPage;
	}

}
