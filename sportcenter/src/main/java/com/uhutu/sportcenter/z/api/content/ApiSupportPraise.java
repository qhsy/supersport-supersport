package com.uhutu.sportcenter.z.api.content;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.config.enums.PrexEnum;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnSupportPraise;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.user.z.entity.UcMsgPraise;
import com.uhutu.dcom.user.z.enums.MsgEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiSupportPraiseInput;
import com.uhutu.sportcenter.z.result.ApiSupportPraiseResult;
import com.uhutu.zoocom.root.RootApiToken;
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
		
		saveMsgPraise(praise);

		return result;
	}
	
	/**
	 * 更新消息点赞
	 * @param praise
	 */
	protected void saveMsgPraise(CnSupportPraise praise) {
		
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
		
	}

}
