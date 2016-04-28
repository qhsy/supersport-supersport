package com.uhutu.sportcenter.api.face;

import org.springframework.beans.factory.annotation.Autowired;

import com.uhutu.dcom.user.entity.UserBasicInfo;
import com.uhutu.dcom.user.support.UserInfoSupport;
import com.uhutu.zoocom.face.IRootApi;
import com.uhutu.zoocom.root.RootApiInput;
import com.uhutu.zoocom.root.RootApiResult;

/**
 * 用户登录信息相关api接口
 * @author pang_jhui
 *
 * @param <I>
 * 		输入参数
 * @param <R>
 * 		处理结果
 */
public abstract class RootUserToken<I extends RootApiInput, R extends RootApiResult> implements IRootApi {
	
	@Autowired
	private UserInfoSupport userInfoSupport;
	
	public R api(I input) {
		return process(input);
	}

	protected abstract R process(I input);
	
	/**
	 * 根据用户编号h
	 * @param userCode
	 * @return
	 */
	public UserBasicInfo getUserBasicInfo(String userCode){
		
		return userInfoSupport.getUserBasicInfo(userCode);
		
	}

}
