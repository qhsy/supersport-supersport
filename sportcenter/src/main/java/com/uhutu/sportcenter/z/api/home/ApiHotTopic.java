package com.uhutu.sportcenter.z.api.home;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.content.z.entity.CnHotTopic;
import com.uhutu.dcom.tag.z.entity.CnContentLabel;
import com.uhutu.sportcenter.z.entity.ContentShowInfo;
import com.uhutu.sportcenter.z.entity.ContentShowModel;
import com.uhutu.sportcenter.z.input.ApiHotTopicInput;
import com.uhutu.sportcenter.z.result.ApiHotTopicResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 热门话题
 * @author 逄小帅
 *
 */
@Component
public class ApiHotTopic extends RootApiBase<ApiHotTopicInput, ApiHotTopicResult> {

	@Override
	protected ApiHotTopicResult process(ApiHotTopicInput input) {
		
		ApiHotTopicResult topicResult = new ApiHotTopicResult();
		
		int total = JdbcHelper.count(CnHotTopic.class, "", new MDataMap());
		
		PageInfo pageInfo = new PageInfo(total, input.getPagination(), 10);
		
		topicResult.setNextPageFlag(pageInfo.hasNext());
		
		int iStart = (input.getPagination() -1) * pageInfo.getPageNum();
		
		List<CnHotTopic> hotTops = JdbcHelper.queryForList(CnHotTopic.class, "", "-sort", "", new MDataMap(), iStart, pageInfo.getPageNum());

		hotTops.forEach(hotTopic -> {
			
			CnContentLabel basicInfo = JdbcHelper.queryOne(CnContentLabel.class, "code",hotTopic.getContentCode());
			
			if(basicInfo != null){
				
				String code = basicInfo.getCode();
				
				ContentShowInfo showInfo = new ContentShowInfo();
				
				ContentShowModel showModel = new ContentShowModel();
				
				showInfo.setCode(code);
				
				String cover = StringUtils.isEmpty(hotTopic.getCover())?basicInfo.getCover():hotTopic.getCover();
				
				if(StringUtils.isNotBlank(cover)){
					
					cover = ImageHelper.upImageThumbnail(cover, input.getWidth());
					
				}
				
				String title = StringUtils.isEmpty(hotTopic.getTitle())?basicInfo.getName():hotTopic.getTitle();
				
				showInfo.setCover(cover);
				
				showInfo.setTitle(title);
				
				showInfo.setType(basicInfo.getType());
				
				showModel.setContentShowInfo(showInfo);
				
				topicResult.getContentShowModels().add(showModel);
				
			}
		
			
		});
		
		return topicResult;
	}

}
