package com.uhutu.sportcenter.z.api.remark;

import java.util.Date;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.common.Constants;
import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.extend.baiduPush.sample.BaiduPush;
import com.uhutu.dcom.extend.baiduPush.sample.PushEnum;
import com.uhutu.dcom.extend.sensitive.SensitivewordFilter;
import com.uhutu.dcom.remark.z.entity.CnContentRemark;
import com.uhutu.dcom.remark.z.enums.RemarkEnum;
import com.uhutu.dcom.remark.z.service.ContentRemarkServiceFactory;
import com.uhutu.dcom.user.z.entity.UcClientInfo;
import com.uhutu.dcom.user.z.entity.UcMsgRemark;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.enums.MsgEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiPublishRemarkInput;
import com.uhutu.sportcenter.z.result.ApiPublishRemarkResult;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 评论发布
 * @author 逄小帅
 *
 */
@Component
public class ApiPublishRemark extends RootApiToken<ApiPublishRemarkInput, ApiPublishRemarkResult> {
	
	@Autowired
	private ContentRemarkServiceFactory servieFactory;
	
	@Autowired
	private UserServiceFactory userServiceFactory;
	
	@Autowired
	private ContentServiceFactory contentServiceFactory;

	@Override
	protected ApiPublishRemarkResult process(ApiPublishRemarkInput input) {
		
		ApiPublishRemarkResult remarkResult = new ApiPublishRemarkResult();
		
		CnContentRemark cnContentRemark = new CnContentRemark();
		
		BeanUtils.copyProperties(input, cnContentRemark);
		
		cnContentRemark.setAuthor(upUserCode());
		
		SensitivewordFilter sensitivewordFilter = new SensitivewordFilter();
		
		String remark = "";
		
		if(StringUtils.isNotBlank(cnContentRemark.getRemark())){
			
			remark = EmojiUtil.emojiFilter(cnContentRemark.getRemark());
			
		}
		
		cnContentRemark.setRemark(remark);
		
		boolean flag = sensitivewordFilter.isContaintSensitiveWord(cnContentRemark.getRemark(), 2);
		
		if(flag){
			
			cnContentRemark.setStatus(RemarkEnum.FLAG_DISENABLE.getCode());
			
		}else{
			
			cnContentRemark.setStatus(RemarkEnum.FLAG_ENABLE.getCode());
			
		}
		
		servieFactory.getContentRemarkService().save(cnContentRemark);
		
		UcMsgRemark ucMsgRemark = saveMsgRemarkInfo(cnContentRemark);
		
		sendPushMsg(ucMsgRemark.getUserCode(), ucMsgRemark.getMsgTitle());
		
		return remarkResult;
		
	}
	
	/**
	 * 初始化父级评论信息
	 * @param parentCode
	 */
	public void initParentInfo(CnContentRemark contentRemark){
		
		CnContentRemark parentContentRemark = null;
		
		String parentCode = contentRemark.getParentCode();
		
		if(StringUtils.isNotBlank(parentCode)){
			
			parentContentRemark = servieFactory.getContentRemarkService().queryByCode(parentCode);
			
			if(parentContentRemark != null){
				
				UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(parentContentRemark.getAuthor());
				
				Optional<UcUserinfoExt> userOptional = Optional.ofNullable(ucUserinfoExt);
				
				if(userOptional.isPresent()){
					
					
					
				}		
				
				
			}
			
		}
		
		
		
	}
	
	/**
	 * 保存评论消息通知
	 * @param remark
	 * 		评论信息
	 */
	public UcMsgRemark saveMsgRemarkInfo(CnContentRemark remark){
		
		UcMsgRemark ucMsgRemark = new UcMsgRemark();
		
		ucMsgRemark.setContentCode(remark.getContentCode());
		
		CnContentBasicinfo contentBasicInfo = contentServiceFactory.getContentBasicinfoService().queryByCode(remark.getContentCode());
		
		Optional<CnContentBasicinfo> contentOptional = Optional.ofNullable(contentBasicInfo);
		
		if(contentOptional.isPresent()){
			
//			ucMsgRemark.setContentAuthor(contentBasicInfo.getAuthor());
			
			ucMsgRemark.setContentTitle(contentBasicInfo.getTitle());
			
			ucMsgRemark.setMsgTime(new Date());
			
			ucMsgRemark.setRemarkCode(remark.getCode());
			
			ucMsgRemark.setRemarkParentCode(remark.getParentCode());
			
			ucMsgRemark.setStatus(MsgEnum.FLAG_UNREAD.getCode());
			
			UcUserinfoExt userinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(upUserCode());
			
			if(StringUtils.isEmpty(remark.getParentCode())){
				
//				ucMsgRemark.setUserCode(contentBasicInfo.getAuthor());
				
				if(userinfoExt != null){
					
					ucMsgRemark.setMsgTitle(userinfoExt.getNickName()+"评论了你发布的内容");
					
				}
				
				
			}else{
				
				CnContentRemark parentRemarkInfo = servieFactory.getContentRemarkService().queryByCode(remark.getParentCode());
				
				ucMsgRemark.setUserCode(parentRemarkInfo.getAuthor());
				
				if(userinfoExt != null){
					
					ucMsgRemark.setMsgTitle(userinfoExt.getNickName()+"回复了你的评论");
					
				}
				
				
			}
			
		}
		
		userServiceFactory.getMsgRemarkService().save(ucMsgRemark);
		
		return ucMsgRemark;
		
	}
	
	/**
	 * 发送push消息
	 * @param msgRemark
	 */
	public void sendPushMsg(String userCode,String content){
		
		try {
			
			UcClientInfo ucClientInfo = JdbcHelper.queryOne(UcClientInfo.class, "", "-zc", "",
					MapHelper.initMap("user_code", userCode, "os", "ios"));

			if (ucClientInfo != null && StringUtils.isNotBlank(ucClientInfo.getChannelId())) {
				new BaiduPush().push(PushEnum.ios, "果冻体育", content, ucClientInfo.getChannelId(), Constants.PUSH_JUMP_MSGCENTER,
						"");
			}

			UcClientInfo android = JdbcHelper.queryOne(UcClientInfo.class, "", "-zc", "",
					MapHelper.initMap("user_code", userCode, "os", "android"));

			if (android != null && StringUtils.isNotBlank(android.getChannelId())) {
				new BaiduPush().push(PushEnum.android, "果冻体育", content, android.getChannelId(), Constants.PUSH_JUMP_MSGCENTER,
						"");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
		
	}


}
