package com.uhutu.dcom.user.z.page.func;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.uhutu.dcom.user.z.enums.UserEnum;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.helper.SecrurityHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;
import com.uhutu.zooweb.user.UserCallFactory;
import com.uhutu.zooweb.user.UserReginsterInput;
import com.uhutu.zooweb.user.UserReginsterResult;

/**
 * 马甲用户注册
 * @author 逄小帅
 *
 */
public class VestUserRegFunc extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		
		WebOperateResult operResult = new WebOperateResult();
		
		String loginName = input.getDataMap().get("login_name");
		
		String loginPwd = input.getDataMap().get("login_pwd");
		
		loginPwd = SecrurityHelper.MD5(loginPwd+UserEnum.SALT.getCode()).toLowerCase();
		
		UserCallFactory userCallFactory = new UserCallFactory();
		
		UserReginsterInput registInput = new UserReginsterInput();
		
		registInput.setLoginName(loginName);
		
		registInput.setLoginPass(loginPwd);
		
		registInput.setLoginSystem(DefineUser.Login_System_Default);
		
		UserReginsterResult registResult = userCallFactory.userReginster(registInput);
		
		if(registResult.upFlagTrue()){
			
			input.getDataMap().put("login_code", registResult.getLoginCode());
			
			input.getDataMap().put("code", registResult.getUserCode());
			
			input.getDataMap().put("flag", UserEnum.FLAG_ENABLE.getCode());
			
			input.getDataMap().put("last_time", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
			
			JdbcHelper.dataInsert(extendPageDefine.getPageSource().getTableName(), input.getDataMap());
			
			MDataMap userInfExtMap = new MDataMap();
			
			userInfExtMap.put("user_code", registResult.getUserCode());
			
			JdbcHelper.dataInsert("uc_userinfo_ext", userInfExtMap);
			
		}else{
			
			operResult.setError(registResult.getError());
			
			operResult.setStatus(registResult.getStatus());
			
		}
		
		return operResult;
	}

}
