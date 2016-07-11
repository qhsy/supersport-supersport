package com.uhutu.sportcenter.z.api.content;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentBasicinfoServiceFactory;
import com.uhutu.dcom.tag.z.service.ContentLabelServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.input.ApiSportingMomentsInput;
import com.uhutu.sportcenter.z.result.ApiSportingMomentsResult;
import com.uhutu.zoocom.root.RootApiForMember;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 运动时刻
 * 
 * @author xiegj
 * 
 */
@Service
public class ApiSportingMoments extends RootApiForMember<ApiSportingMomentsInput, ApiSportingMomentsResult> {

	@Autowired
	private ContentBasicinfoServiceFactory serviceFactory;

	@Autowired
	private UserInfoSupport userInfoSupport;

	@Autowired
	private ContentLabelServiceFactory labelServiceFactory;

	protected ApiSportingMomentsResult process(ApiSportingMomentsInput input) {

		QueryConditions queryConditions = new QueryConditions();

		ApiSportingMomentsResult sportingMomentsResult = new ApiSportingMomentsResult();

		queryConditions.setConditionEqual("busiType", ContentEnum.sportmoment.getCode());
		queryConditions.setConditionEqual("status", "dzsd4699100110010001");
		queryConditions.setConditionEqual("shareScope", "dzsd4699100110010001");
		if ("2".equals(input.getType()) && StringUtils.isNotBlank(upUserCode())) {// 我关注的人
			queryConditions.setCondition("author", QueryConditions.IN,
					"select be_attention from uc_attention_info where attention='" + upUserCode()
							+ "' and status='1'");
		} else if ("3".equals(input.getType())) {// 达人
			queryConditions.setCondition("author", QueryConditions.IN,
					"select code from uc_userinfo where type='dzsd4107100310010002'");
		}
		Page<CnContentBasicinfo> page = serviceFactory.getContentBasicinfoService().queryPage(input.getPagination(), 10,
				queryConditions);

		List<CnContentBasicinfo> contentBasicInfos = page.getContent();

		List<ContentBasicinfoForApi> sports = new ArrayList<ContentBasicinfoForApi>();

		for (CnContentBasicinfo contentBasicInfo : contentBasicInfos) {

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

				sports.add(sportingMoment);

			}

		}

		sportingMomentsResult.setMoments(sports);

		if (page.hasNext()) {

			sportingMomentsResult.setNextPageFlag(true);

		} else {

			sportingMomentsResult.setNextPageFlag(false);

		}

		return sportingMomentsResult;
	}

}
