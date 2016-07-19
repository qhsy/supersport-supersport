package com.uhutu.sportcenter.z.api.buttock;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.tag.z.service.ContentLabelServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.input.ApiButtockLapListInput;
import com.uhutu.sportcenter.z.result.ApiButtockLapListResult;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 美臀大赛-翘丽圈
 * @author 逄小帅
 *
 */
@Component
public class ApiButtockLapList extends RootApiBase<ApiButtockLapListInput, ApiButtockLapListResult> {
	
	@Autowired
	private ContentServiceFactory contentServiceFactory;
	
	@Autowired
	private UserInfoSupport userInfoSupport;
	
	@Autowired
	private ContentLabelServiceFactory labelServiceFactory;

	@Override
	protected ApiButtockLapListResult process(ApiButtockLapListInput input) {
		
		ApiButtockLapListResult result = new ApiButtockLapListResult();
		
		int total = JdbcHelper.count(CnContentBasicinfo.class, "", MapHelper.initMap("tagCode","GGBH160719110001","status",ContentEnum.normal.getCode(),"shareScope","dzsd4699100110010001"));
		
		PageInfo pageInfo = new PageInfo(total, input.getPagination(), 10);
		
		result.setNextflag(pageInfo.hasNext());
		
		int istart = (input.getPagination() - 1)*10;
		
		String whereStr = "tagCode='GGBH160719110001' and status='"+ContentEnum.normal.getCode()+"' and shareScope='dzsd4699100110010001'";
		
		List<CnContentBasicinfo> contentList = JdbcHelper.queryForList(CnContentBasicinfo.class, "", "-publish_time", whereStr, new MDataMap(), istart, 10);
		
		if(contentList.size() > 0){
			
			contentList.forEach(pointRecomm -> {
				
				CnContentBasicinfo contentBasicInfo = contentServiceFactory.getContentBasicinfoService().queryByCode(pointRecomm.getCode());

				if (contentBasicInfo != null) {

					ContentBasicinfoForApi sportingMoment = new ContentBasicinfoForApi();

					BeanUtils.copyProperties(contentBasicInfo, sportingMoment);

					UcUserinfoExt ucUserinfoExt = userInfoSupport.getUserInfoExt(contentBasicInfo.getAuthor());

					UcUserinfo ucUserinfo = userInfoSupport.getUserInfo(contentBasicInfo.getAuthor());

					if (ucUserinfoExt != null) {

						sportingMoment.getUserBasicInfo().setAboutHead(ucUserinfoExt.getAboutHead());

						sportingMoment.getUserBasicInfo().setNickName(ucUserinfoExt.getNickName());

					}

					if (ucUserinfo != null) {

						sportingMoment.getUserBasicInfo().setUserCode(ucUserinfo.getCode());

						sportingMoment.getUserBasicInfo().setType(ucUserinfo.getType());

					}

					sportingMoment.setTagName(
							labelServiceFactory.getContentLabelService().initTagName(sportingMoment.getTagCode()));

					sportingMoment.setCover(ImageHelper.upImageThumbnail(sportingMoment.getCover(), input.getWidth()));

					sportingMoment.setPublishTimeStr("MM-dd HH:mm");
					
					int praiseNum = contentServiceFactory.getSupportPraiseService().queryCountByCode(pointRecomm.getCode(),ContentEnum.FAVOR_STATUS_YES.getCode());
					
					sportingMoment.setPraiseNum(praiseNum);

					result.getButtockLapList().add(sportingMoment);

				}

			
				
				
			});
			
		}else{
			
			result.setStatus(0);
			
			result.setError("运营同学正在努力整理翘丽圈的信息哟");
			
		}
		
		return result;
	
		
		
	}

}
