package com.uhutu.sportcenter.z.api.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.entity.UcAttentionInfo;
import com.uhutu.dcom.user.z.entity.UcMsgAttention;
import com.uhutu.dcom.user.z.enums.MsgEnum;
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
			attentionInfo.setZc(new Date());
			userServiceFactory.getAttentionInfoService().save(attentionInfo);
			saveMsgAttend(attentionInfo);
		}else if(info!=null&&!info.getStatus().equals(inputParam.getFlag())) {
			info.setStatus(inputParam.getFlag());
			JdbcHelper.update(info, "status", "attention,be_attention");
		}
		return new ApiForAttentionResult();
	}
	
	/**
	 * 保存关注信息
	 * @param attentionInfo
	 */
	public void saveMsgAttend(UcAttentionInfo attentionInfo){
		
		UcMsgAttention msgAttention = new UcMsgAttention();
		
		msgAttention.setAttnUserCode(attentionInfo.getBeAttention());
		
		msgAttention.setFansUserCode(attentionInfo.getAttention());
		
		msgAttention.setMsgTime(new Date());
		
		msgAttention.setMsgTitle("关注了您");
		
		msgAttention.setStatus(MsgEnum.FLAG_UNREAD.getCode());
		
		userServiceFactory.getMsgAttentionService().save(msgAttention);
		
	}

}
