package com.uhutu.sportcenter.z.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.entity.UcAttentionInfo;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiForAttentionInput;
import com.uhutu.sportcenter.z.result.ApiForAttentionResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 关注信息接口
 * 
 * @author xiegj
 *
 */
@Service
public class ApiForAttention extends RootApiToken<ApiForAttentionInput, ApiForAttentionResult> {

	@Autowired
	private UserServiceFactory userServiceFactory;

	public ApiForAttentionResult process(ApiForAttentionInput inputParam) {
		UcAttentionInfo info = userServiceFactory.getAttentionInfoService()
				.queryByBothCode(upUserCode(), inputParam.getUserCode());
		if(info==null&&"1".equals(inputParam.getFlag())){
			UcAttentionInfo attentionInfo = new UcAttentionInfo();
			attentionInfo.setAttention(inputParam.getZoo().getToken().trim());
			attentionInfo.setBeAttention(inputParam.getUserCode());
			attentionInfo.setStatus(inputParam.getFlag());
			userServiceFactory.getAttentionInfoService().save(attentionInfo);
		}else if(info!=null&&!info.getStatus().equals(inputParam.getFlag())) {
			info.setStatus(inputParam.getFlag());
			JdbcHelper.update(info, "status", "attention,be_attention");
		}
		return new ApiForAttentionResult();
	}

}
