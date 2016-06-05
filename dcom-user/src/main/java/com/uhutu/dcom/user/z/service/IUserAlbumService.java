package com.uhutu.dcom.user.z.service;

import org.springframework.data.domain.Page;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.entity.UcUserAlbum;

/**
 * 相册service
 * @author pang_jhui
 *
 */
public interface IUserAlbumService {
	
	/**
	 * 查询分页信息
	 * @param pageNum
	 * 		页码
	 * @param limit
	 * 		每页展示行数
	 * @param conditions
	 * 		查询条件
	 * @return 分页信息
	 */
	Page<UcUserAlbum> queryPageByCondition(int pageNum,int limit,QueryConditions conditions);

}
