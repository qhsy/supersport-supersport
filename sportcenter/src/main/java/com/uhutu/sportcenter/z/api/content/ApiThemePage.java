package com.uhutu.sportcenter.z.api.content;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnShareInfo;
import com.uhutu.dcom.content.z.entity.CnThemeDetail;
import com.uhutu.dcom.content.z.entity.CnThemeDetailRel;
import com.uhutu.dcom.content.z.entity.CnThemeInfo;
import com.uhutu.dcom.content.z.entity.CnThemeInfoRel;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.entity.RecommExpertInfo;
import com.uhutu.sportcenter.z.entity.ThemePageModel;
import com.uhutu.sportcenter.z.input.ApiThemePageInput;
import com.uhutu.sportcenter.z.result.ApiThemePageResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 专题数据展示
 * 
 * @author xiegj
 */
@Service
public class ApiThemePage extends RootApiBase<ApiThemePageInput, ApiThemePageResult> {

	@Autowired
	private ContentServiceFactory contentServiceFactory;
	@Autowired
	private UserInfoSupport userInfoSupport;

	protected ApiThemePageResult process(ApiThemePageInput input) {
		ApiThemePageResult result = new ApiThemePageResult();
		CnThemeInfo info = JdbcHelper.queryOne(CnThemeInfo.class, "code", input.getCode());
		if (info != null) {
			result.setCode(info.getCode());
			result.setName(info.getName());
			result.setCover(info.getCover());
			if (StringUtils.isNotBlank(result.getCover()) && StringUtils.isNotBlank(input.getWidth())) {
				result.setCover(ImageHelper.upImageThumbnail(info.getCover(), Integer.valueOf(input.getWidth()) * 2));
			}
			result.setAboutDesc(info.getAboutDesc());
			result.setModels(getModels(input.getCode(), input.getWidth()));
		}
		if (result.upFlagTrue()) {
			CnShareInfo shareInfo = JdbcHelper.queryOne(CnShareInfo.class, "code", info.getCode(), "status", "1");
			if (shareInfo != null) {
				result.setShareFlag(true);
			}
		}
		return result;
	}

	private List<ThemePageModel> getModels(String themeCode, String width) {
		List<ThemePageModel> result = new ArrayList<ThemePageModel>();
		List<CnThemeInfoRel> infoRels = JdbcHelper.queryForList(CnThemeInfoRel.class, "", "sort desc",
				"code='" + themeCode + "'", new MDataMap());
		StringBuffer columnCodes = new StringBuffer();
		if (infoRels != null && !infoRels.isEmpty() && infoRels.size() > 0) {
			for (int i = 0; i < infoRels.size(); i++) {
				if (i == infoRels.size() - 1) {
					columnCodes.append("'" + infoRels.get(i).getColumnCode() + "'");
				} else {
					columnCodes.append("'" + infoRels.get(i).getColumnCode() + "',");
				}
			}
			if (StringUtils.isNotBlank(columnCodes)) {
				List<CnThemeDetail> details = JdbcHelper.queryForList(CnThemeDetail.class, "",
						" field(code," + columnCodes.toString() + ")",
						" code in(" + columnCodes.toString() + ") and status='1'", new MDataMap());
				if (details != null && !details.isEmpty()) {
					for (int i = 0; i < details.size(); i++) {
						CnThemeDetail detail = details.get(i);
						ThemePageModel model = new ThemePageModel();
						model.setTitle(detail.getTitle());
						if (StringUtils.isNotBlank(detail.getType())
								&& "dzsd4107100110070001".equals(detail.getType())) {
							model.setInfos(getContents(detail.getCode(), width));
							result.add(model);
						} else if (StringUtils.isNotBlank(detail.getType())
								&& "dzsd4107100110070002".equals(detail.getType())) {
							model.setRecomms(getRecomms(detail.getCode(), 128));
							result.add(model);
						}
					}
				}
			}
		}
		return result;
	}

	private List<ContentBasicinfoForApi> getContents(String columnCode, String width) {
		List<ContentBasicinfoForApi> result = new ArrayList<ContentBasicinfoForApi>();
		List<CnThemeDetailRel> detailRels = JdbcHelper.queryForList(CnThemeDetailRel.class, "", "sort desc",
				"code='" + columnCode + "'", new MDataMap());
		StringBuffer contentCodes = new StringBuffer();

		MDataMap coverMap = new MDataMap();

		if (detailRels != null && !detailRels.isEmpty() && detailRels.size() > 0) {
			for (int i = 0; i < detailRels.size(); i++) {

				if (StringUtils.isNotEmpty(detailRels.get(i).getThemeCover())) {

					coverMap.put(detailRels.get(i).getContentCode(), detailRels.get(i).getThemeCover());

				}

				if (i == detailRels.size() - 1) {
					contentCodes.append("'" + detailRels.get(i).getContentCode() + "'");
				} else {
					contentCodes.append("'" + detailRels.get(i).getContentCode() + "',");
				}
			}
			if (StringUtils.isNotBlank(contentCodes)) {
				List<CnContentBasicinfo> basics = JdbcHelper.queryForList(CnContentBasicinfo.class, "",
						" field(code," + contentCodes.toString() + ")",
						" code in(" + contentCodes.toString()
								+ ") and status='dzsd4699100110010001' and shareScope='dzsd4699100110010001'",
						new MDataMap());
				if (basics != null && !basics.isEmpty()) {
					for (int i = 0; i < basics.size(); i++) {
						CnContentBasicinfo basicInfo = basics.get(i);
						ContentBasicinfoForApi re = new ContentBasicinfoForApi();

						BeanUtils.copyProperties(basicInfo, re);
//						UcUserinfo userInfo = userInfoSupport.getUserInfo(re.getAuthor());
//						UcUserinfoExt ucUserinfoExt = userInfoSupport.getUserInfoExt(re.getAuthor());
//						if (ucUserinfoExt != null) {
//							if (StringUtils.isNotBlank(ucUserinfoExt.getAboutHead())) {
//								re.getUserBasicInfo()
//										.setAboutHead(ImageHelper.upImageThumbnail(ucUserinfoExt.getAboutHead(), 80));
//							}
//							re.getUserBasicInfo().setNickName(ucUserinfoExt.getNickName());
//						}
//						if (userInfo != null) {
//							re.getUserBasicInfo().setType(userInfo.getType());
//							re.getUserBasicInfo().setUserCode(userInfo.getCode());
//						}
//						re.setPraiseNum(contentServiceFactory.getSupportPraiseService().queryCountByCode(re.getCode(),
//								ContentEnum.FAVOR_STATUS_YES.getCode()));

						String themeCover = coverMap.get(basicInfo.getCode());

						int coverWidth = StringUtils.isNotEmpty(width) ? Integer.valueOf(width) : 0;

						if (StringUtils.isNotBlank(themeCover)) {

							re.setCover(ImageHelper.upImageThumbnail(themeCover, coverWidth));

						} else {

							if (StringUtils.isNotBlank(re.getCover())) {

								re.setCover(ImageHelper.upImageThumbnail(re.getCover(), coverWidth));

							}

						}
						
						String title = re.getTitle();
						
						title = StringUtils.isEmpty(title) ? "" : EmojiUtil.emojiRecovery(title);
						
						re.setTitle(title);

						result.add(re);
					}
				}
			}
		}
		return result;
	}

	private List<RecommExpertInfo> getRecomms(String columnCode, int width) {
		List<RecommExpertInfo> result = new ArrayList<RecommExpertInfo>();
		if (StringUtils.isNotBlank(columnCode)) {
			List<CnThemeDetailRel> list = JdbcHelper.queryForList(CnThemeDetailRel.class, "", "sort desc",
					"code='" + columnCode + "'", new MDataMap());
			if (list != null && !list.isEmpty() && list.size() > 0) {
				StringBuffer str = new StringBuffer();
				for (int i = 0; i < list.size(); i++) {
					if (i == list.size() - 1) {
						str.append("'" + list.get(i).getContentCode() + "'");
					} else {
						str.append("'" + list.get(i).getContentCode() + "',");
					}
				}
				List<UcUserinfoExt> us = JdbcHelper.queryForList(UcUserinfoExt.class, "",
						" field(user_code," + str.toString() + ")", " user_code in(" + str.toString() + ")",
						new MDataMap());
				if (us != null && !us.isEmpty()) {
					for (int i = 0; i < us.size(); i++) {
						RecommExpertInfo recommExpertInfo = new RecommExpertInfo();
						UcUserinfoExt uie = us.get(i);
						BeanUtils.copyProperties(uie, recommExpertInfo);
						if (StringUtils.isNoneBlank(recommExpertInfo.getAboutHead())) {
							recommExpertInfo
									.setAboutHead(ImageHelper.upImageThumbnail(recommExpertInfo.getAboutHead(), 80));
						}
						UcUserinfo uui = JdbcHelper.queryOne(UcUserinfo.class, "code", recommExpertInfo.getUserCode());
						AwAnswerExpert answerExpert = JdbcHelper.queryOne(AwAnswerExpert.class, "userCode",
								recommExpertInfo.getUserCode());
						if (uui != null) {
							recommExpertInfo.setType(uui.getType());
						}
						if (answerExpert != null) {

							recommExpertInfo.setTitle(answerExpert.getTitle());

						}
						result.add(recommExpertInfo);
					}
				}
			}
		}
		return result;
	}
}
