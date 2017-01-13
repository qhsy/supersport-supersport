package com.uhutu.sportcenter.z.api.search;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.pay.z.util.BeanComponent;
import com.uhutu.dcom.search.z.entity.ResponseData;
import com.uhutu.dcom.search.z.entity.UserData;
import com.uhutu.dcom.search.z.service.SearchServiceFactory;
import com.uhutu.dcom.user.z.entity.UcAttentionInfo;
import com.uhutu.sportcenter.z.input.ApiSearchUserInput;
import com.uhutu.sportcenter.z.result.ApiSearchUserResult;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.helper.GsonHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoocom.z.bean.TopUserFactory;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 搜索用户
 * @author 逄小帅
 *
 */
@Component
public class ApiSearchUser extends RootApiBase<ApiSearchUserInput, ApiSearchUserResult> {

	@Override
	protected ApiSearchUserResult process(ApiSearchUserInput input) {
		
		ApiSearchUserResult searchUserResult = new ApiSearchUserResult();
		
		int number = 10;
		
		int start = (input.getPagination() -1) * number;
		
		start = start < 0 ? 0 : start;
		
		ResponseData responseData = SearchServiceFactory.getInstance().getSearchUserService().search(input.getNickName(), start, number);
		
		if(StringUtils.equals(responseData.getStatus(), "OK")){
			
			try {
				
				if(responseData.getResult() != null && responseData.getResult().getItems() != null){
					
					for ( MDataMap item : responseData.getResult().getItems()) {
						
						UserData userData = BeanComponent.getInstance().invoke(UserData.class, item, false);
						
						if (StringUtils.isNoneBlank(input.getZoo().getToken())) {

							String userCode = TopUserFactory.upUserCallFactory()
									.upUserCodeByAuthToken(input.getZoo().getToken(), DefineUser.Login_System_Default);
							
							boolean flag = initFlag(userCode, userData.getCode());
							
							userData.setAttendFlag(flag);

						}
						
						searchUserResult.getUserDatas().add(userData);
						
					}
					
					int total = start + number;
					
					if(total < responseData.getResult().getViewtotal()){
						
						searchUserResult.setNextPageFlag(true);
						
					}
					
				}
				
			} catch (Exception e) {
				
				searchUserResult.setStatus(-2);
				
				searchUserResult.setError("数据转换时出现问题");
				
			}
			
		}else{
			
			searchUserResult.setStatus(-1);
			
			if(responseData.getErrors()!= null && !responseData.getStatus().isEmpty()){
				
				searchUserResult.setError(GsonHelper.toJson(responseData.getErrors()));
				
			}else{
				
				searchUserResult.setError("数据查询出现问题");
				
			}
			
		}
		
		return searchUserResult;
	}
	
	public boolean initFlag(String attention,String beAttention){
		
		boolean flag = false;
		
		UcAttentionInfo attentionInfo = JdbcHelper.queryOne(UcAttentionInfo.class, "attention", attention,
				"beAttention", beAttention, "status", SystemEnum.NORMAL.getCode());
		
		if(attentionInfo != null){
			
			flag = true;
			
		}
		
		return flag;
		
	}

}
