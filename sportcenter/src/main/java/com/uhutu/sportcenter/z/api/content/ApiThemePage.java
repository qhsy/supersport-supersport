package com.uhutu.sportcenter.z.api.content;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
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
import com.uhutu.sportcenter.z.entity.ThemePageModel;
import com.uhutu.sportcenter.z.input.ApiThemePageInput;
import com.uhutu.sportcenter.z.result.ApiThemePageResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;

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
			result.setAboutDesc(info.getAboutDesc());
			result.setModels(getModels(input.getCode()));
		}
		return result;
	}

	private List<ThemePageModel> getModels(String themeCode) {
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
						model.setInfos(getContents(detail.getCode()));
						result.add(model);
					}
				}
			}
		}
		return result;
	}

	private List<ContentBasicinfoForApi> getContents(String columnCode) {
		List<ContentBasicinfoForApi> result = new ArrayList<ContentBasicinfoForApi>();
		List<CnThemeDetailRel> detailRels = JdbcHelper.queryForList(CnThemeDetailRel.class, "", "sort desc",
				"code='" + columnCode + "'", new MDataMap());
		StringBuffer contentCodes = new StringBuffer();
		if (detailRels != null && !detailRels.isEmpty() && detailRels.size() > 0) {
			for (int i = 0; i < detailRels.size(); i++) {
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
						UcUserinfo userInfo = userInfoSupport.getUserInfo(re.getAuthor());
						UcUserinfoExt ucUserinfoExt = userInfoSupport.getUserInfoExt(re.getAuthor());
						if (ucUserinfoExt != null) {
							re.getUserBasicInfo().setAboutHead(ucUserinfoExt.getAboutHead());
							re.getUserBasicInfo().setNickName(ucUserinfoExt.getNickName());
						}
						if (userInfo != null) {
							re.getUserBasicInfo().setType(userInfo.getType());
							re.getUserBasicInfo().setUserCode(userInfo.getCode());
						}
						re.setPraiseNum(contentServiceFactory.getSupportPraiseService().queryCountByCode(re.getCode(),
								ContentEnum.FAVOR_STATUS_YES.getCode()));
						result.add(re);
					}
				}
			}
		}
		return result;
	}
}