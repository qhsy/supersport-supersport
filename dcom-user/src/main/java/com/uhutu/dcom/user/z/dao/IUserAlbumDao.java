package com.uhutu.dcom.user.z.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.uhutu.dcom.user.z.entity.UcUserAlbum;

/**
 * 用户相册
 * @author pang_jhui
 *
 */
public interface IUserAlbumDao extends JpaRepository<UcUserAlbum, String>,JpaSpecificationExecutor<UcUserAlbum> {
	
	

}
