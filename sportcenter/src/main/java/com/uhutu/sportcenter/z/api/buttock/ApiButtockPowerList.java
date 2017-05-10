package com.uhutu.sportcenter.z.api.buttock;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.entity.AwPointRecommen;
import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.tag.z.service.ContentLabelServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.api.util.ContentComponent;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.input.ApiButtockPowerListInput;
import com.uhutu.sportcenter.z.result.ApiButtockPowerListResult;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 美臀大赛-实力派
 * 
 * @author 逄小帅
 *
 */
@Component
public class ApiButtockPowerList extends RootApiBase<ApiButtockPowerListInput, ApiButtockPowerListResult> {

	@Autowired
	private ContentServiceFactory contentServiceFactory;

	@Autowired
	private UserInfoSupport userInfoSupport;

	@Autowired
	private ContentLabelServiceFactory labelServiceFactory;

	@Override
	protected ApiButtockPowerListResult process(ApiButtockPowerListInput input) {

		ApiButtockPowerListResult result = new ApiButtockPowerListResult();
//
//		int total = JdbcHelper.count(AwPointRecommen.class, "", MapHelper.initMap("type", "dzsd4888100110030006"));
//
//		PageInfo pageInfo = new PageInfo(total, input.getPagination(), 10);
//
//		result.setNextflag(pageInfo.hasNext());
//
//		int istart = (input.getPagination() - 1) * 10;
//		
//		String orderStr = "IFNULL((SELECT count(1) + (select praise_base from cn_content_basicinfo where code = answer_code) from cn_support_praise where content_code = answer_code and status = '1'),0) DESC";
//		
//		List<AwPointRecommen> recommList = JdbcHelper.queryForList(AwPointRecommen.class, "", orderStr,
//				"type='dzsd4888100110030006'", new MDataMap(), istart, 10);
//
//		if (recommList.size() > 0) {
//
//			recommList.forEach(pointRecomm -> {
//
//				CnContentBasicinfo contentBasicInfo = contentServiceFactory.getContentBasicinfoService()
//						.queryByCode(pointRecomm.getAnswerCode());
//
//				if (contentBasicInfo != null) {
//
//					ContentBasicinfoForApi sportingMoment = new ContentBasicinfoForApi();
//
//					BeanUtils.copyProperties(contentBasicInfo, sportingMoment);
//
//					UcUserinfoExt ucUserinfoExt = userInfoSupport.getUserInfoExt(contentBasicInfo.getAuthor());
//
//					UcUserinfo ucUserinfo = userInfoSupport.getUserInfo(contentBasicInfo.getAuthor());
//
//					if (ucUserinfoExt != null) {
//
//						sportingMoment.getUserBasicInfo().setAboutHead(ucUserinfoExt.getAboutHead());
//
//						sportingMoment.getUserBasicInfo().setNickName(ucUserinfoExt.getNickName());
//
//					}
//
//					if (ucUserinfo != null) {
//
//						sportingMoment.getUserBasicInfo().setUserCode(ucUserinfo.getCode());
//
//						sportingMoment.getUserBasicInfo().setType(ucUserinfo.getType());
//
//					}
//
//					sportingMoment.setTagName(
//							labelServiceFactory.getContentLabelService().initTagName(sportingMoment.getTagCode()));
//
//					sportingMoment.setTags(
//							labelServiceFactory.getContentLabelService().getLabels(sportingMoment.getTagCode()));
//					
//					boolean favorFlag = false;
//					
//					if(StringUtils.isNotEmpty(input.getZoo().getToken())){
//						
//						favorFlag = ContentComponent.lightFavor(sportingMoment.getCode(), input.getZoo().getToken());
//						
//					}
//					
//					sportingMoment.setFavorFlag(favorFlag);
//
//					sportingMoment.setCover(ImageHelper.upImageThumbnail(sportingMoment.getCover(), input.getWidth()));
//
//					sportingMoment.setPublishTimeStr("MM-dd HH:mm");
//
//					int praiseNum = contentServiceFactory.getSupportPraiseService()
//							.queryCountByCode(pointRecomm.getAnswerCode(), ContentEnum.FAVOR_STATUS_YES.getCode());
//
//					sportingMoment.setPraiseNum(praiseNum);
//
//					result.getButtockPowerList().add(sportingMoment);
//
//				}
//
//			});
//
//		} else {
//
//			result.setStatus(0);
//
//			result.setError("运营同学正在努力整理实力派的信息哟");
//
//		}

		return result;
	}

}
