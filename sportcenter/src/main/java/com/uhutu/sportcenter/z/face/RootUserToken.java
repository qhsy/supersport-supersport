package com.uhutu.sportcenter.z.face;

import org.springframework.beans.factory.annotation.Autowired;

import com.uhutu.dcom.user.z.entity.UserBasicInfo;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.zoocom.root.RootApiInput;
import com.uhutu.zoocom.root.RootApiResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 用户登录信息相关api接口
 * @author pang_jhui
 *
 * @param <I>
 * 		输入参数
 * @param <R>
 * 		处理结果
 */
public abstract class RootUserToken<I extends RootApiInput, R extends RootApiResult> extends RootApiToken<I, R> {
	
	@Autowired
	private UserInfoSupport userInfoSupport;
	
	/**
	 * 根据用户编号h
	 * @param userCode
	 * @return
	 */
	public UserBasicInfo getUserBasicInfo(){
		
		return userInfoSupport.getUserBasicInfo(upUserCode());
		
	}

}
