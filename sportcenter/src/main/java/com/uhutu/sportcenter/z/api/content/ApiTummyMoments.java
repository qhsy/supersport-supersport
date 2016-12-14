package com.uhutu.sportcenter.z.api.content;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentDetail;
import com.uhutu.dcom.content.z.entity.CnContentReadCount;
import com.uhutu.dcom.content.z.entity.CnSupportPraise;
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
import com.uhutu.sportcenter.z.input.ApiTummyMomentsInput;
import com.uhutu.sportcenter.z.result.ApiTummyMomentsResult;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiForMember;
import com.uhutu.zoodata.helper.SerializeHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 运动时刻
 * 
 * @author xiegj
 * 
 */
@Service
public class ApiTummyMoments extends RootApiForMember<ApiTummyMomentsInput, ApiTummyMomentsResult> {

	@Autowired
	private ContentServiceFactory serviceFactory;

	@Autowired
	private UserInfoSupport userInfoSupport;

	@Autowired
	private ContentRemarkServiceFactory remarkServiceFactory;

	@Autowired
	private ContentLabelServiceFactory labelServiceFactory;

	protected ApiTummyMomentsResult process(ApiTummyMomentsInput input) {// 此版本屏蔽直播的运动时刻

		ApiTummyMomentsResult sportingMomentsResult = new ApiTummyMomentsResult();

		List<CnContentBasicinfo> contentBasicInfos = new ArrayList<CnContentBasicinfo>();
		int istart = (input.getPagination() - 1) * 10;
		String sql = "SELECT * from (select b.*, sum(case when a.content_code=b.code AND a.type='01' AND a.status='1' then 1 else 0 end) "
				+ " as praiseBase  from cn_content_basicinfo b left join cn_support_praise a on a.content_code=b.code group by b.code desc ) "
				+ " zz where tag_code like '%GGBH161202110002%' and tag_code is not null ORDER BY zz.praiseBase desc ";
		List<Map<String, Object>> objs = JdbcHelper.dataSqlList(sql + " LIMIT " + istart + ",10", null);
		contentBasicInfos = SerializeHelper.convertList(CnContentBasicinfo.class, objs);
		int count = JdbcHelper.dataSqlList(sql, null).size();
		PageInfo pageInfo = new PageInfo(count, input.getPagination(), 10);

		sportingMomentsResult.setNextPageFlag(pageInfo.hasNext());

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

					sportingMoment.getUserBasicInfo().setTitle(ucUserinfoExt.getTitle());

				}

				if (ucUserinfo != null) {

					sportingMoment.getUserBasicInfo().setUserCode(ucUserinfo.getCode());

					sportingMoment.getUserBasicInfo().setType(ucUserinfo.getType());

				}

				sportingMoment.setTagName(
						labelServiceFactory.getContentLabelService().initTagName(sportingMoment.getTagCode()));

				sportingMoment
						.setTags(labelServiceFactory.getContentLabelService().getLabels(sportingMoment.getTagCode()));
				sportingMoment
						.setFavorFlag(ContentComponent.lightFavor(sportingMoment.getCode(), input.getZoo().getToken()));

				sportingMoment.setCover(ImageHelper.upImageThumbnail(sportingMoment.getCover(), input.getWidth()));

				sportingMoment.setPublishTimeStr("MM-dd HH:mm");

				CnContentReadCount contentReadCount = JdbcHelper.queryOne(CnContentReadCount.class, "contentCode",
						sportingMoment.getCode());

				if (contentReadCount != null) {

					sportingMoment.setReadNum(contentReadCount.getCount());

				}
				CnContentDetail contentDetail = JdbcHelper.queryOne(CnContentDetail.class, "code",
						sportingMoment.getCode());
				if (contentDetail != null) {
					sportingMoment.setContentDetail(contentDetail);
				}
				sportingMoment = new HomePageSupport(userInfoSupport).getSingleTitle(sportingMoment);
				int remarkNum = remarkServiceFactory.getContentRemarkService().queryCount(sportingMoment.getCode(),
						RemarkEnum.FLAG_ENABLE.getCode());
				sportingMoment.setRemarkNum(remarkNum);
				int praiseNum = JdbcHelper.count(CnSupportPraise.class, "",
						MapHelper.initMap("content_code", sportingMoment.getCode(), "type", "01", "status", "1"));
				sportingMoment.setPraiseNum(praiseNum);

				String title = sportingMoment.getTitle();

				title = StringUtils.isEmpty(title) ? "" : EmojiUtil.emojiRecovery(title);

				sportingMoment.setTitle(title);

				sports.add(sportingMoment);

			}

		}

		sportingMomentsResult.setMoments(sports);

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
