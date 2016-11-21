package com.uhutu.sportcenter.z.api.content;

import java.util.Date;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.answer.z.common.Constants;
import com.uhutu.dcom.config.enums.PrexEnum;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnSupportPraise;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.extend.baiduPush.sample.BaiduPush;
import com.uhutu.dcom.extend.baiduPush.sample.PushEnum;
import com.uhutu.dcom.user.z.entity.UcClientInfo;
import com.uhutu.dcom.user.z.entity.UcMsgPraise;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.enums.MsgEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiSupportPraiseInput;
import com.uhutu.sportcenter.z.result.ApiSupportPraiseResult;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.WebHelper;

/***
 * 赞与嘘嘘接口
 * 
 * @author xiegj
 *
 */
@Service
public class ApiSupportPraise extends RootApiToken<ApiSupportPraiseInput, ApiSupportPraiseResult> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;
	
	@Autowired
	private ContentServiceFactory contentServiceFactory;

	protected ApiSupportPraiseResult process(ApiSupportPraiseInput input) {
		
		ApiSupportPraiseResult result = new ApiSupportPraiseResult();
		
		CnSupportPraise praise = contentServiceFactory.getSupportPraiseService().
				query(input.getContentCode(), upUserCode(), input.getType());
		
		Optional<CnSupportPraise> praiseOptional = Optional.ofNullable(praise);
		
		if(praiseOptional.isPresent()){
			
			praise.setStatus(input.getIsLike());
			
		} else {

			praise = new CnSupportPraise();
			praise.setCode(WebHelper.upCode(PrexEnum.CNE.name()));
			praise.setContentCode(input.getContentCode());
			praise.setType(input.getType());
			praise.setUserCode(upUserCode());
			praise.setStatus(input.getIsLike());

		}
		
		contentServiceFactory.getSupportPraiseService().save(praise);
		
		if(StringUtils.equals(input.getIsLike(), ContentEnum.FAVOR_STATUS_YES.getCode())){
			
			UcMsgPraise msgPraise = saveMsgPraise(praise);
			
			sendPushMsg(msgPraise.getContentAuthor(), upUserCode());
			
		}

		return result;
	}
	
	/**
	 * 更新消息点赞
	 * @param praise
	 */
	protected UcMsgPraise saveMsgPraise(CnSupportPraise praise) {
		
		UcMsgPraise msgPraiseInfo = new UcMsgPraise();
		
		CnContentBasicinfo contentBasicinfo = contentServiceFactory.getContentBasicinfoService().queryByCode(praise.getContentCode());
		
		Optional<CnContentBasicinfo> contentOption = Optional.ofNullable(contentBasicinfo);
		
		msgPraiseInfo.setPraiseCode(praise.getCode());
		
		msgPraiseInfo.setPraiseUserCode(praise.getUserCode());
		
		msgPraiseInfo.setMsgTime(new Date());
		
		if(contentOption.isPresent()){
			
			msgPraiseInfo.setContentAuthor(contentBasicinfo.getAuthor());
			
			msgPraiseInfo.setContentCode(praise.getContentCode());
			
			msgPraiseInfo.setContentTitle(contentBasicinfo.getTitle());
			
			msgPraiseInfo.setMsgTitle("点赞了你这条内容");		
			
			msgPraiseInfo.setStatus(MsgEnum.FLAG_UNREAD.getCode());
			
		}
		
		userServiceFactory.getMsgPraiseService().save(msgPraiseInfo);
		
		return msgPraiseInfo;
		
	}
	
	/**
	 * push推送
	 * @param author
	 * 		文章作者
	 * @param userCode
	 * 		点赞人
	 */
	public void sendPushMsg(String author,String userCode){
		
		try {
			
			String content = "";
			
			UcUserinfoExt userinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(userCode);
			
			if(userinfoExt != null){
				
				content = userinfoExt.getNickName()+"喜欢了你发布的内容";
				
			}
			
			UcClientInfo ucClientInfo = JdbcHelper.queryOne(UcClientInfo.class, "", "-zc", "",
					MapHelper.initMap("user_code", author, "os", "ios"));

			if (ucClientInfo != null && StringUtils.isNotBlank(ucClientInfo.getChannelId())) {
				new BaiduPush().push(PushEnum.ios, "果冻体育", content, ucClientInfo.getChannelId(), Constants.PUSH_JUMP_MSGCENTER,
						"");
			}

			UcClientInfo android = JdbcHelper.queryOne(UcClientInfo.class, "", "-zc", "",
					MapHelper.initMap("user_code", author, "os", "android"));

			if (android != null && StringUtils.isNotBlank(android.getChannelId())) {
				new BaiduPush().push(PushEnum.android, "果冻体育", content, android.getChannelId(), Constants.PUSH_JUMP_MSGCENTER,
						"");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
		
	}

}
