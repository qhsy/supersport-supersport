package com.uhutu.sportcenter.z.api.user;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentReadCount;
import com.uhutu.dcom.content.z.entity.CnSupportPraise;
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
import com.uhutu.sportcenter.z.input.ApiFavorContentListInput;
import com.uhutu.sportcenter.z.result.ApiFavorContentListResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 喜欢内容列表
 * 
 * @author 逄小帅
 *
 */
@Component
public class ApiFavorContentList extends RootApiBase<ApiFavorContentListInput, ApiFavorContentListResult> {

	@Autowired
	private ContentServiceFactory contentServiceFactory;

	@Autowired
	private UserInfoSupport userInfoSupport;

	@Autowired
	private ContentLabelServiceFactory labelServiceFactory;

	@Autowired
	private ContentRemarkServiceFactory remarkServiceFactory;

	@Override
	protected ApiFavorContentListResult process(ApiFavorContentListInput input) {

		ApiFavorContentListResult result = new ApiFavorContentListResult();

		int iNumber = 10;

		int iStart = (input.getPagination() - 1) * iNumber;

		StringBuffer sqlBuffer = new StringBuffer(" user_code='").append(input.getUserCode()).append("'");

		sqlBuffer.append(" and status='").append(ContentEnum.FAVOR_STATUS_YES.getCode()).append("'");

		sqlBuffer.append(" and type='").append(ContentEnum.FAVOR_TYPE_LIKE.getCode()).append("'");

		sqlBuffer.append(" and content_code like '").append("CNBH%").append("'");

		sqlBuffer.append(" and exists(select 1 from cn_content_basicinfo where code = content_code and status = 'dzsd4699100110010001')");

		List<CnSupportPraise> praiseList = JdbcHelper.queryForList(CnSupportPraise.class, "", "-zc",
				sqlBuffer.toString(), new MDataMap(), iStart, iNumber);

		int total = JdbcHelper.count(CnSupportPraise.class, sqlBuffer.toString(), new MDataMap());
		
		PageInfo pageInfo = new PageInfo(total, input.getPagination(), iNumber);
		
		result.setNextPageFlag(pageInfo.hasNext());

		praiseList.forEach(praise -> {

			ContentBasicinfoForApi basicinfoForApi = new ContentBasicinfoForApi();

			CnContentBasicinfo basicinfo = contentServiceFactory.getContentBasicinfoService()
					.queryByCode(praise.getContentCode());

			if (basicinfo != null) {

				BeanUtils.copyProperties(basicinfo, basicinfoForApi);

				UcUserinfoExt ucUserinfoExt = userInfoSupport.getUserInfoExt(basicinfo.getAuthor());

				UcUserinfo ucUserinfo = userInfoSupport.getUserInfo(basicinfo.getAuthor());

				if (ucUserinfoExt != null) {

					basicinfoForApi.getUserBasicInfo().setAboutHead(ucUserinfoExt.getAboutHead());

					basicinfoForApi.getUserBasicInfo().setNickName(ucUserinfoExt.getNickName());

					basicinfoForApi.getUserBasicInfo().setTitle(ucUserinfoExt.getTitle());

				}

				if (ucUserinfo != null) {

					basicinfoForApi.getUserBasicInfo().setUserCode(ucUserinfo.getCode());

					basicinfoForApi.getUserBasicInfo().setType(ucUserinfo.getType());

				}

				String tagName = labelServiceFactory.getContentLabelService().initTagName(basicinfoForApi.getTagCode());

				basicinfoForApi.setTagName(tagName);

				basicinfoForApi
						.setTags(labelServiceFactory.getContentLabelService().getLabels(basicinfoForApi.getTagCode()));
				basicinfoForApi.setFavorFlag(
						ContentComponent.lightFavor(basicinfoForApi.getCode(), input.getZoo().getToken()));

				basicinfoForApi.setPublishTimeStr("MM-dd HH:mm");
				basicinfoForApi.setPublishTimeStr("MM-dd HH:mm");
				CnContentReadCount contentReadCount = JdbcHelper.queryOne(CnContentReadCount.class, "contentCode",
						basicinfoForApi.getCode());
				basicinfoForApi.setReadNum(contentReadCount != null ? contentReadCount.getCount() : 0);
				int remarkNum = remarkServiceFactory.getContentRemarkService().queryCount(basicinfoForApi.getCode(),
						RemarkEnum.FLAG_ENABLE.getCode());
				basicinfoForApi.setRemarkNum(remarkNum);
				int praiseNum = contentServiceFactory.getSupportPraiseService()
						.queryCountByCode(basicinfoForApi.getCode(), ContentEnum.FAVOR_STATUS_YES.getCode());
				basicinfoForApi.setPraiseNum(praiseNum);
				
				basicinfoForApi = new HomePageSupport(userInfoSupport).getSingleTitle(basicinfoForApi);
				
				String title = basicinfoForApi.getTitle();
				
				title = StringUtils.isEmpty(title) ? "" : EmojiUtil.emojiRecovery(title);
				
				basicinfoForApi.setTitle(title);
				
				result.getContentInfoList().add(basicinfoForApi);

			}

		});

		return result;
	}

}
