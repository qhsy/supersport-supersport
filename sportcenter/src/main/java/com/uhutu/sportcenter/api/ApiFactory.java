package com.uhutu.sportcenter.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * api工厂
 * @author pang_jhui
 *
 */
@Component
public class ApiFactory {
	
	@Autowired
	private ApiContentDetailInfo contentDetailInfo;
	
	@Autowired
	private ApiContentPhotosDetailInfo contentPhotosDetailInfo;
	
	public ApiContentDetailInfo getContentDetailInfo() {
		return contentDetailInfo;
	}

	public ApiContentPhotosDetailInfo getContentPhotosDetailInfo() {
		return contentPhotosDetailInfo;
	}
	

}
