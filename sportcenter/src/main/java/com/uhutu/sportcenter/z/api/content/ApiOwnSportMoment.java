package com.uhutu.sportcenter.z.api.content;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentReadCount;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.remark.z.enums.RemarkEnum;
import com.uhutu.dcom.remark.z.service.ContentRemarkServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.api.util.ContentComponent;
import com.uhutu.sportcenter.z.api.util.HomePageSupport;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.input.ApiOwnSportMomentInput;
import com.uhutu.sportcenter.z.result.ApiOwnSportMomentResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 我发布的运动时刻
 * 
 * @author 逄小帅
 *
 */
@Component
public class ApiOwnSportMoment extends RootApiToken<ApiOwnSportMomentInput, ApiOwnSportMomentResult> {

	@Autowired
	private UserInfoSupport userInfoSupport;

	@Autowired
	private UserServiceFactory userServiceFactory;

	@Autowired
	private ContentServiceFactory serviceFactory;

	@Autowired
	private ContentRemarkServiceFactory remarkServiceFactory;

	@Override
	protected ApiOwnSportMomentResult process(ApiOwnSportMomentInput input) {

		ApiOwnSportMomentResult result = new ApiOwnSportMomentResult();

		UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(upUserCode());

		UcUserinfo ucUserinfo = userServiceFactory.getUserInfoService().queryByCode(upUserCode());

		QueryConditions queryConditions = new QueryConditions();

		queryConditions.setConditionEqual("busiType", ContentEnum.sportmoment.getCode());

		queryConditions.setConditionEqual("status", "dzsd4699100110010001");

		queryConditions.setConditionEqual("author", upUserCode());

		Page<CnContentBasicinfo> page = serviceFactory.getContentBasicinfoService().queryPage(input.getPagination(), 10,
				queryConditions);

		List<CnContentBasicinfo> contentBasicInfos = page.getContent();

		List<ContentBasicinfoForApi> sports = new ArrayList<ContentBasicinfoForApi>();

		for (CnContentBasicinfo contentBasicInfo : contentBasicInfos) {

			ContentBasicinfoForApi sportingMoment = new ContentBasicinfoForApi();

			BeanUtils.copyProperties(contentBasicInfo, sportingMoment);

			if (ucUserinfoExt != null) {

				sportingMoment.getUserBasicInfo().setAboutHead(ucUserinfoExt.getAboutHead());

				sportingMoment.getUserBasicInfo().setNickName(ucUserinfoExt.getNickName());

			}

			if (ucUserinfo != null) {

				sportingMoment.getUserBasicInfo().setType(ucUserinfo.getType());

				sportingMoment.getUserBasicInfo().setUserCode(upUserCode());

			}
			sportingMoment.setPublishTimeStr("MM-dd HH:mm");
			CnContentReadCount contentReadCount = JdbcHelper.queryOne(CnContentReadCount.class, "contentCode",
					sportingMoment.getCode());
			sportingMoment.setReadNum(contentReadCount != null ? contentReadCount.getCount() : 0);
			int remarkNum = remarkServiceFactory.getContentRemarkService().queryCount(sportingMoment.getCode(),
					RemarkEnum.FLAG_ENABLE.getCode());
			sportingMoment.setRemarkNum(remarkNum);
			int praiseNum = serviceFactory.getSupportPraiseService().queryCountByCode(sportingMoment.getCode(),
					ContentEnum.FAVOR_STATUS_YES.getCode());
			sportingMoment.setPraiseNum(praiseNum);
			
			sportingMoment.setFavorFlag(ContentComponent.lightFavor(sportingMoment.getCode(), input.getZoo().getToken()));
			
			sports.add(new HomePageSupport(userInfoSupport).getSingleTitle(sportingMoment));

		}

		result.setMoments(sports);

		if (page.hasNext()) {

			result.setNextPageFlag(true);

		} else {

			result.setNextPageFlag(false);

		}

		return result;
	}

}
