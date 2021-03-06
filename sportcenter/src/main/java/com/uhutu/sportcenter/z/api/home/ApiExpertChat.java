package com.uhutu.sportcenter.z.api.home;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnExpertChat;
import com.uhutu.sportcenter.z.entity.ContentShowInfo;
import com.uhutu.sportcenter.z.entity.ContentShowModel;
import com.uhutu.sportcenter.z.entity.UserBasicInfo;
import com.uhutu.sportcenter.z.input.ApiExpertChatInput;
import com.uhutu.sportcenter.z.result.ApiExpertChatResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 达人专访
 * @author 逄小帅
 *
 */
@Component
public class ApiExpertChat extends RootApiBase<ApiExpertChatInput, ApiExpertChatResult> {

	@Override
	protected ApiExpertChatResult process(ApiExpertChatInput input) {
		
		ApiExpertChatResult chatResult = new ApiExpertChatResult();
		
		int total = JdbcHelper.count(CnExpertChat.class, "", new MDataMap());
		
		PageInfo pageInfo = new PageInfo(total, input.getPagination(), 10);
		
		chatResult.setNextPageFlag(pageInfo.hasNext());
		
		int iStart = (input.getPagination() -1) * pageInfo.getPageNum();
		
		List<CnExpertChat> expertChats = JdbcHelper.queryForList(CnExpertChat.class, "", "-sort", "", new MDataMap(), iStart, pageInfo.getPageNum());
		
		expertChats.forEach(expertChat -> {
			
			CnContentBasicinfo basicInfo = JdbcHelper.queryOne(CnContentBasicinfo.class, "code",expertChat.getContentCode());
			
			if(basicInfo != null){
				
				String code = basicInfo.getCode();
				
				ContentShowInfo showInfo = new ContentShowInfo();
				
				ContentShowModel showModel = new ContentShowModel();
				
				showInfo.setCode(code);
				
				String cover = StringUtils.isEmpty(expertChat.getCover())?basicInfo.getCover():expertChat.getCover();
				
				if(StringUtils.isNotBlank(cover)){
					
					cover = ImageHelper.upImageThumbnail(cover, input.getWidth());
					
				}
				
				String title = StringUtils.isEmpty(expertChat.getTitle())?basicInfo.getTitle():expertChat.getTitle();
				
				title = StringUtils.isEmpty(title) ? "" : EmojiUtil.emojiRecovery(title);
				
				showInfo.setCover(cover);
				
				showInfo.setTitle(title);
				
				showInfo.setType(basicInfo.getContentType());
				
				UserBasicInfo userBasicInfo = new UserBasicInfo();
				
				userBasicInfo.setNickName(expertChat.getAbout());
				
				showModel.setContentShowInfo(showInfo);
				
				showModel.setUserBasicInfo(userBasicInfo);
				
				chatResult.getContentShowModels().add(showModel);
				
			}
			
		});
		
		return chatResult;
	}
	

}
