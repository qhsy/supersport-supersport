package com.uhutu.sportcenter.z.api.user;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.answer.z.common.Constants;
import com.uhutu.dcom.extend.baiduPush.sample.BaiduPush;
import com.uhutu.dcom.extend.baiduPush.sample.PushEnum;
import com.uhutu.dcom.user.z.entity.UcAttentionInfo;
import com.uhutu.dcom.user.z.entity.UcClientInfo;
import com.uhutu.dcom.user.z.entity.UcMsgAttention;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.enums.MsgEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiForAttentionInput;
import com.uhutu.sportcenter.z.result.ApiForAttentionResult;
import com.uhutu.zoocom.helper.MapHelper;
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
			info = new UcAttentionInfo();
			info.setAttention(upUserCode());
			info.setBeAttention(inputParam.getUserCode());
			info.setStatus(inputParam.getFlag());
			info.setZc(new Date());
			userServiceFactory.getAttentionInfoService().save(info);
		}else if(info!=null&&!info.getStatus().equals(inputParam.getFlag())) {
			
			info.setStatus(inputParam.getFlag());
			
			JdbcHelper.update(info, "status", "attention,be_attention");
			
		}
		
		/*关注用户*/
		if("1".equals(inputParam.getFlag())){
			
			saveMsgAttend(info);
			
			sendPushMsg(info.getAttention(), info.getBeAttention());
			
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
	
	
	/**
	 * 发送push消息
	 * @param msgRemark
	 */
	public void sendPushMsg(String attend,String beAttend){
		
		try {
			
			String content = "";
			
			UcUserinfoExt userinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(attend);
			
			if(userinfoExt != null){
				
				content = userinfoExt.getNickName()+"关注了你";
				
			}
			
			UcClientInfo ucClientInfo = JdbcHelper.queryOne(UcClientInfo.class, "", "-zc", "",
					MapHelper.initMap("user_code", beAttend, "os", "ios"));

			if (ucClientInfo != null && StringUtils.isNotBlank(ucClientInfo.getChannelId())) {
				new BaiduPush().push(PushEnum.ios, "果冻体育", content, ucClientInfo.getChannelId(), Constants.PUSH_JUMP_MSGCENTER,
						"");
			}

			UcClientInfo android = JdbcHelper.queryOne(UcClientInfo.class, "", "-zc", "",
					MapHelper.initMap("user_code", beAttend, "os", "android"));

			if (android != null && StringUtils.isNotBlank(android.getChannelId())) {
				new BaiduPush().push(PushEnum.android, "果冻体育", content, android.getChannelId(), Constants.PUSH_JUMP_MSGCENTER,
						"");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
		
	}

}
