package com.uhutu.sportcenter.z.api.label;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentReadCount;
import com.uhutu.dcom.tag.z.entity.CnContentLabel;
import com.uhutu.dcom.tag.z.service.ContentLabelServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.entity.LabelContentInfo;
import com.uhutu.sportcenter.z.input.ApiLabelRelListInput;
import com.uhutu.sportcenter.z.result.ApiLabelRelListResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;
import com.uhutu.zooweb.io.ImageThumb;

/**
 * 标签关联内容列表
 * @author 逄小帅
 *
 */
@Component
public class ApiLabelRelList extends RootApiBase<ApiLabelRelListInput, ApiLabelRelListResult> {

	@Autowired
	private UserInfoSupport userInfoSupport;

	@Autowired
	private ContentLabelServiceFactory labelServiceFactory;

	@Override
	protected ApiLabelRelListResult process(ApiLabelRelListInput input) {

		ApiLabelRelListResult result = new ApiLabelRelListResult();	
		
		CnContentLabel contentLabel = labelServiceFactory.getContentLabelService().queryByCode(input.getTagCode());
		
		if(contentLabel != null){
			
			result.setContent(contentLabel.getContent());
			
			if(StringUtils.isNotEmpty(contentLabel.getCover())){
				
				ImageThumb imageThumb = ImageHelper.upThumbWithHeight(contentLabel.getCover(), input.getwCover());
				
				result.setCover(imageThumb);
				
			}
			
		}
		
		String sWhere = initWhere(input.getTagCode()) + " and status='dzsd4699100110010001'";

		switch (input.getType()) {
		case "newTab":
			result.setNewContent(initNewTab(sWhere, input.getPagination(), input.getwContent()));
			break;

		case "hotTab":
			result.setHotContent(initHotTab(sWhere, input.getPagination(), input.getwContent()));
			break;

		default:
			result.setNewContent(initNewTab(sWhere, input.getPagination(), input.getwContent()));
			result.setHotContent(initHotTab(sWhere, input.getPagination(), input.getwContent()));
			break;
		}

		return result;
	}

	/**
	 * 初始化最新tab
	 * 
	 * @param sWhere
	 *            查询条件
	 * @return 标签内容信息
	 */
	public LabelContentInfo initNewTab(String sWhere, int index, int width) {

		LabelContentInfo labelContentInfo = new LabelContentInfo();

		int iNumber = 10;

		int iStart = (index - 1) * iNumber;

		int count = JdbcHelper.count(CnContentBasicinfo.class, sWhere, new MDataMap());

		PageInfo pageInfo = new PageInfo(count, index, iNumber);

		labelContentInfo.setNextflag(pageInfo.hasNext());

		List<CnContentBasicinfo> contentBasicinfos = JdbcHelper.queryForList(CnContentBasicinfo.class, "", "-zc",
				sWhere, new MDataMap(), iStart, iNumber);

		labelContentInfo.setContentBasicInfos(initBasicInfos(contentBasicinfos, width));

		return labelContentInfo;

	}
	
	/**
	 * 初始化最热tab
	 * 
	 * @param sWhere
	 *            查询条件
	 * @return 标签内容信息
	 */
	public LabelContentInfo initHotTab(String sWhere, int index, int width) {

		LabelContentInfo labelContentInfo = new LabelContentInfo();

		int iNumber = 10;

		int iStart = (index - 1) * iNumber;

		int count = JdbcHelper.count(CnContentBasicinfo.class, sWhere, new MDataMap());

		PageInfo pageInfo = new PageInfo(count, index, iNumber);

		labelContentInfo.setNextflag(pageInfo.hasNext());
		
		String orderStr = "IFNULL((SELECT count from cn_content_read_count where content_code = code),0) DESC";

		List<CnContentBasicinfo> contentBasicinfos = JdbcHelper.queryForList(CnContentBasicinfo.class, "", orderStr,
				sWhere, new MDataMap(), iStart, iNumber);

		labelContentInfo.setContentBasicInfos(initBasicInfos(contentBasicinfos, width));

		return labelContentInfo;

	}

	/**
	 * 初始化where
	 * 
	 * @param tagCode
	 * @return
	 */
	public String initWhere(String tagCode) {

		StringBuffer codeBuffer = new StringBuffer();

		String codeStr = "";

		String[] tagCodes = StringUtils.split(tagCode, ",");

		for (int i = 0; i < tagCodes.length; i++) {

			String tempCode = tagCodes[i];

			if (StringUtils.isNotBlank(tempCode)) {

				codeBuffer.append(" tag_code like '%").append(tempCode).append("%' or");

			}

		}

		if (codeBuffer.length() > 0) {

			int index = codeBuffer.lastIndexOf("or");

			codeStr = codeBuffer.substring(0, index);

		}

		return codeStr;

	}

	/**
	 * 初始化基本信息
	 * @param contentBasicinfos
	 * 		内容基本信息列表
	 * @param width
	 * 		内容宽度
	 * @return
	 */
	public List<ContentBasicinfoForApi> initBasicInfos(List<CnContentBasicinfo> contentBasicinfos, int width) {

		List<ContentBasicinfoForApi> basicInfoApis = new ArrayList<ContentBasicinfoForApi>();

		contentBasicinfos.forEach(basicInfo -> {

			if (basicInfo != null) {

				ContentBasicinfoForApi sportingMoment = new ContentBasicinfoForApi();

				BeanUtils.copyProperties(basicInfo, sportingMoment);

				UcUserinfoExt ucUserinfoExt = userInfoSupport.getUserInfoExt(sportingMoment.getAuthor());

				UcUserinfo ucUserinfo = userInfoSupport.getUserInfo(sportingMoment.getAuthor());

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

				sportingMoment.setTags(
						labelServiceFactory.getContentLabelService().getLabels(sportingMoment.getTagCode()));
				
				ImageThumb coverThum = ImageHelper.upThumbWithHeight(sportingMoment.getCover(), width);

				sportingMoment.setCover(coverThum.getThumbUrl());

				sportingMoment.setCoverWH(coverThum.getThumbWidth() + "*" + coverThum.getThumbHeight());

				CnContentReadCount contentReadCount = JdbcHelper.queryOne(CnContentReadCount.class, "contentCode",
						sportingMoment.getCode());

				if (contentReadCount != null) {

					sportingMoment.setReadNum(contentReadCount.getCount());

				}

				basicInfoApis.add(sportingMoment);

			}
		});

		return basicInfoApis;

	}

}
