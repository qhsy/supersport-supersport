package com.uhutu.sportcenter.z.api.content;

import java.util.Date;
import java.util.Optional;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.config.enums.PrexEnum;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnSupportPraise;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.content.z.service.SupportPraiseServiceFactory;
import com.uhutu.dcom.user.z.entity.UcMsgPraise;
import com.uhutu.dcom.user.z.enums.MsgEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiSupportPraiseInput;
import com.uhutu.sportcenter.z.result.ApiSupportPraiseResult;
import com.uhutu.zoocom.root.RootApiToken;

/***
 * 赞与嘘嘘接口
 * 
 * @author xiegj
 *
 */
@Service
public class ApiSupportPraise extends RootApiToken<ApiSupportPraiseInput, ApiSupportPraiseResult> {

	@Autowired
	private SupportPraiseServiceFactory serviceFactory;
	
	@Autowired
	private UserServiceFactory userServiceFactory;
	
	@Autowired
	private ContentServiceFactory contentServiceFactory;

	protected ApiSupportPraiseResult process(ApiSupportPraiseInput input) {
		CnSupportPraise praise = new CnSupportPraise();
		praise.setCode(PrexEnum.CNE.toString() + DateFormatUtils.format(new Date(), "yyyyMMddhhmmssSSS"));
		praise.setContentCode(input.getContentCode());
		praise.setType(input.getType());
		praise.setUserCode(input.getZoo().getToken().trim());// 暂时没有
		if ("0".equals(input.getIsLike())) {// 取消点赞或者取消点嘘嘘
			serviceFactory.getSupportPraiseService().cancelbyCCAndUCAndType(input.getContentCode(), input.getZoo().getToken(),
					input.getType());
		} else {// 点赞或者点嘘嘘
			
			serviceFactory.getSupportPraiseService().save(praise);
			
			saveMsgPraise(praise);
			
		}

		return new ApiSupportPraiseResult();
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
