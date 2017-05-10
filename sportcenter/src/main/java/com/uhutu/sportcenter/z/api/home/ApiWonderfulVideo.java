package com.uhutu.sportcenter.z.api.home;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnWonderfulVideo;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.api.util.ContentComponent;
import com.uhutu.sportcenter.z.entity.ContentShowInfo;
import com.uhutu.sportcenter.z.entity.ContentShowModel;
import com.uhutu.sportcenter.z.entity.UserBasicInfo;
import com.uhutu.sportcenter.z.input.ApiWonderfulVideoInput;
import com.uhutu.sportcenter.z.result.ApiWonderfulVideoResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 精彩视频
 * @author 逄小帅
 *
 */
@Component
public class ApiWonderfulVideo extends RootApiBase<ApiWonderfulVideoInput, ApiWonderfulVideoResult> {
	
	@Autowired
	private UserInfoSupport userInfoSupport;

	@Override
	protected ApiWonderfulVideoResult process(ApiWonderfulVideoInput input) {
		
		ApiWonderfulVideoResult videoResult = new ApiWonderfulVideoResult();
		
		int total = JdbcHelper.count(CnWonderfulVideo.class, "", new MDataMap());
		
		PageInfo pageInfo = new PageInfo(total, input.getPagination(), 10);
		
		videoResult.setNextPageFlag(pageInfo.hasNext());
		
		int iStart = (input.getPagination() -1) * pageInfo.getPageNum();
		
		List<CnWonderfulVideo> expertChats = JdbcHelper.queryForList(CnWonderfulVideo.class, "", "-sort", "", new MDataMap(), iStart, pageInfo.getPageNum());
		
		expertChats.forEach(video -> {
			
			CnContentBasicinfo basicInfo = JdbcHelper.queryOne(CnContentBasicinfo.class, "code",video.getContentCode());
			
			if(basicInfo != null){
				
				String code = basicInfo.getCode();
				
				ContentShowInfo showInfo = new ContentShowInfo();
				
				ContentShowModel showModel = new ContentShowModel();
				
				showInfo.setCode(code);
				
				String cover = StringUtils.isEmpty(video.getCover())?basicInfo.getCover():video.getCover();
				
				if(StringUtils.isNotBlank(cover)){
					
					cover = ImageHelper.upImageThumbnail(cover, input.getWidth());
					
				}
				
				String title = StringUtils.isEmpty(video.getTitle())?basicInfo.getTitle():video.getTitle();
				
				title = StringUtils.isEmpty(title) ? "" : EmojiUtil.emojiRecovery(title);
				
				showInfo.setCover(cover);
				
				showInfo.setTitle(title);
				
				showInfo.setType(basicInfo.getContentType());
				
				showInfo.setReadNum(ContentComponent.readNum(code));
				
				UserBasicInfo userBasicInfo = new UserBasicInfo();
				
//				UcUserinfo userinfo = userInfoSupport.getUserInfo(basicInfo.getAuthor());
//				
//				UcUserinfoExt userinfoExt = userInfoSupport.getUserInfoExt(basicInfo.getAuthor());
//				
//				if(userinfo != null){
//					
//					userBasicInfo.setType(userinfo.getType());
//					
//				}
//				
//				if(userinfoExt != null){
//					
//					userBasicInfo.setAboutHead(userinfoExt.getAboutHead());
//					
//					userBasicInfo.setNickName(userinfoExt.getNickName());
//					
//					userBasicInfo.setTitle(userinfoExt.getTitle());
//					
//					userBasicInfo.setUserCode(userinfoExt.getUserCode());
//					
//				}
				
				showModel.setContentShowInfo(showInfo);
				
				showModel.setUserBasicInfo(userBasicInfo);
				
				videoResult.getContentShowModels().add(showModel);
				
			}
			
		});
		
		return videoResult;
	}

}
