package com.uhutu.sportcenter.z.api.content;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentDetail;
import com.uhutu.dcom.content.z.entity.CnContentReadCount;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.remark.z.enums.RemarkEnum;
import com.uhutu.dcom.remark.z.service.ContentRemarkServiceFactory;
import com.uhutu.dcom.tag.z.service.ContentLabelServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.api.util.ContentComponent;
import com.uhutu.sportcenter.z.api.util.HomePageSupport;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.input.ApiSportingMomentsSecondInput;
import com.uhutu.sportcenter.z.result.ApiSportingMomentsSecondResult;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiForMember;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;
import com.uhutu.zooweb.user.UserCallFactory;

/**
 * 运动时刻
 * 
 * @author xiegj
 * 
 */
@Service
public class ApiSportingMomentsSecond
		extends RootApiForMember<ApiSportingMomentsSecondInput, ApiSportingMomentsSecondResult> {

	@Autowired
	private ContentServiceFactory serviceFactory;

	@Autowired
	private UserInfoSupport userInfoSupport;

	@Autowired
	private ContentRemarkServiceFactory remarkServiceFactory;

	@Autowired
	private ContentLabelServiceFactory labelServiceFactory;

	protected ApiSportingMomentsSecondResult process(ApiSportingMomentsSecondInput input) {

		ApiSportingMomentsSecondResult sportingMomentsResult = new ApiSportingMomentsSecondResult();

//		List<CnContentBasicinfo> contentBasicInfos = new ArrayList<CnContentBasicinfo>();
//
//		if ("2".equals(input.getType()) && StringUtils.isNotBlank(upUserCode())) {// 我关注的人
//
//			if (StringUtils.isNotEmpty(input.getZoo().getToken())) {
//
//				String userCode = new UserCallFactory().upUserCodeByAuthToken(input.getZoo().getToken(),
//						DefineUser.Login_System_Default);
//
//				if (StringUtils.isNotEmpty(userCode)) {
//
//					MDataMap dataMap = MapHelper.initMap("busiType", ContentEnum.sportmoment.getCode(), "status",
//							"dzsd4699100110010001", "shareScope", "dzsd4699100110010001");
//
//					String sqlWhere = initSql(dataMap);
//
//					sqlWhere = sqlWhere + "EXISTS (select 1 from uc_attention_info where attention = '" + userCode
//							+ "' and be_attention = author and status='1') and content_type!='dzsd4107100110030009'";
//
//					int istart = (input.getPagination() - 1) * 10;
//
//					contentBasicInfos = JdbcHelper.queryForList(CnContentBasicinfo.class, "", " zc desc ", sqlWhere,
//							new MDataMap(), istart, 10);
//
//					int count = JdbcHelper.count(CnContentBasicinfo.class, sqlWhere, new MDataMap());
//
//					PageInfo pageInfo = new PageInfo(count, input.getPagination(), 10);
//
//					sportingMomentsResult.setNextPageFlag(pageInfo.hasNext());
//
//				}
//
//			}
//
//		} else if ("3".equals(input.getType())) {// 达人
//
//			MDataMap dataMap = MapHelper.initMap("busiType", ContentEnum.sportmoment.getCode(), "status",
//					"dzsd4699100110010001", "shareScope", "dzsd4699100110010001");
//
//			String sqlWhere = initSql(dataMap);
//
//			sqlWhere = sqlWhere
//					+ " EXISTS (select 1 from uc_userinfo ui where code = author and type='dzsd4107100310010002') and content_type!='dzsd4107100110030009'";
//
//			int istart = (input.getPagination() - 1) * 10;
//
//			contentBasicInfos = JdbcHelper.queryForList(CnContentBasicinfo.class, "", "zc desc", sqlWhere,
//					new MDataMap(), istart, 10);
//
//			int count = JdbcHelper.count(CnContentBasicinfo.class, sqlWhere, new MDataMap());
//
//			PageInfo pageInfo = new PageInfo(count, input.getPagination(), 10);
//
//			sportingMomentsResult.setNextPageFlag(pageInfo.hasNext());
//
//		} else {
//
//			QueryConditions queryConditions = new QueryConditions();
//
//			queryConditions.setConditionEqual("busiType", ContentEnum.sportmoment.getCode());
//			queryConditions.setConditionEqual("status", "dzsd4699100110010001");
//			queryConditions.setConditionEqual("shareScope", "dzsd4699100110010001");
//			queryConditions.setConditionNotEqual("contentType", "dzsd4107100110030009");
//			Page<CnContentBasicinfo> page = serviceFactory.getContentBasicinfoService().queryPage(input.getPagination(),
//					10, queryConditions);
//
//			contentBasicInfos = page.getContent();
//
//			if (page.hasNext()) {
//
//				sportingMomentsResult.setNextPageFlag(true);
//
//			} else {
//
//				sportingMomentsResult.setNextPageFlag(false);
//
//			}
//
//		}
//
//		List<ContentBasicinfoForApi> sports = new ArrayList<ContentBasicinfoForApi>();
//
//		for (CnContentBasicinfo contentBasicInfo : contentBasicInfos) {
//
//			if (contentBasicInfo != null) {
//
//				ContentBasicinfoForApi sportingMoment = new ContentBasicinfoForApi();
//
//				BeanUtils.copyProperties(contentBasicInfo, sportingMoment);
//
//				UcUserinfoExt ucUserinfoExt = userInfoSupport.getUserInfoExt(contentBasicInfo.getAuthor());
//
//				UcUserinfo ucUserinfo = userInfoSupport.getUserInfo(contentBasicInfo.getAuthor());
//
//				if (ucUserinfoExt != null) {
//
//					sportingMoment.getUserBasicInfo().setAboutHead(ucUserinfoExt.getAboutHead());
//
//					sportingMoment.getUserBasicInfo().setNickName(ucUserinfoExt.getNickName());
//
//					sportingMoment.getUserBasicInfo().setTitle(ucUserinfoExt.getTitle());
//
//				}
//
//				if (ucUserinfo != null) {
//
//					sportingMoment.getUserBasicInfo().setUserCode(ucUserinfo.getCode());
//
//					sportingMoment.getUserBasicInfo().setType(ucUserinfo.getType());
//
//				}
//
//				sportingMoment.setTagName(
//						labelServiceFactory.getContentLabelService().initTagName(sportingMoment.getTagCode()));
//
//				sportingMoment
//						.setTags(labelServiceFactory.getContentLabelService().getLabels(sportingMoment.getTagCode()));
//				sportingMoment
//						.setFavorFlag(ContentComponent.lightFavor(sportingMoment.getCode(), input.getZoo().getToken()));
//
//				sportingMoment.setCover(ImageHelper.upImageThumbnail(sportingMoment.getCover(), input.getWidth()));
//
//				sportingMoment.setPublishTimeStr("MM-dd HH:mm");
//
//				CnContentReadCount contentReadCount = JdbcHelper.queryOne(CnContentReadCount.class, "contentCode",
//						sportingMoment.getCode());
//
//				if (contentReadCount != null) {
//
//					sportingMoment.setReadNum(contentReadCount.getCount());
//
//				}
//				CnContentDetail contentDetail = JdbcHelper.queryOne(CnContentDetail.class, "code",
//						sportingMoment.getCode());
//				if (contentDetail != null) {
//					sportingMoment.setContentDetail(contentDetail);
//				}
//				sportingMoment = new HomePageSupport(userInfoSupport).getSingleTitle(sportingMoment);
//				int remarkNum = remarkServiceFactory.getContentRemarkService().queryCount(sportingMoment.getCode(),
//						RemarkEnum.FLAG_ENABLE.getCode());
//				sportingMoment.setRemarkNum(remarkNum);
//				int praiseNum = serviceFactory.getSupportPraiseService().queryCountByCode(sportingMoment.getCode(),
//						ContentEnum.FAVOR_STATUS_YES.getCode());
//
//				sportingMoment.setPraiseNum(praiseNum);
//
//				String title = sportingMoment.getTitle();
//
//				title = StringUtils.isEmpty(title) ? "" : EmojiUtil.emojiRecovery(title);
//
//				sportingMoment.setTitle(title);
//
//				sports.add(sportingMoment);
//
//			}
//
//		}
//
//		sportingMomentsResult.setMoments(sports);

		return sportingMomentsResult;
	}

	public String initSql(MDataMap mDataMap) {

		StringBuffer buffer = new StringBuffer();

		mDataMap.keySet().forEach(key -> {

			buffer.append(key).append("='").append(mDataMap.get(key)).append("' and ");

		});

		return buffer.toString();

	}

}
