package com.uhutu.sportcenter.z.api.content;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentRecomm;
import com.uhutu.dcom.content.z.entity.CnShareInfo;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.sportcenter.z.input.ApiShareContentInput;
import com.uhutu.sportcenter.z.result.ApiShareContentResult;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 分享内容
 * 
 * @author 逄小帅
 *
 */
@Component
public class ApiShareContent extends RootApiBase<ApiShareContentInput, ApiShareContentResult> {

	@Autowired
	private ContentServiceFactory contentServiceFactory;

	@Override
	protected ApiShareContentResult process(ApiShareContentInput input) {

		ApiShareContentResult shareResult = new ApiShareContentResult();

		if (StringUtils.isNotBlank(input.getContentCode())) {
			CnShareInfo shareInfo = JdbcHelper.queryOne(CnShareInfo.class, "code", input.getContentCode(), "status",
					"1");
			if (shareInfo != null) {
				shareResult.setContent(shareInfo.getAboutDesc());
				shareResult.setCode(shareInfo.getCode());
				shareResult.setIconUrl(shareInfo.getCover());
				shareResult.setTitle(shareInfo.getTitle());
				shareResult.setUrl(shareInfo.getUrl());
			}
		}
		if (StringUtils.isNotBlank(input.getContentCode()) && input.getContentCode().startsWith("CNBH")) {

			CnContentBasicinfo basicInfo = contentServiceFactory.getContentBasicinfoService()
					.queryByCode(input.getContentCode());

			CnContentRecomm recomm = contentServiceFactory.getContentRecommService()
					.queryEntityByCode(input.getContentCode());
			String authorName = "";
			if (StringUtils.isNotBlank(basicInfo.getAuthor())) {
				UcUserinfoExt ue = JdbcHelper.queryOne(UcUserinfoExt.class, "userCode", basicInfo.getAuthor());
				authorName = StringUtils.isNotBlank(ue.getNickName()) ? ue.getNickName() : "";
			}
			
			String title = basicInfo.getTitle();
			
			title = StringUtils.isEmpty(title) ? "" : EmojiUtil.emojiRecovery(title);
			
			if (basicInfo != null) {

				shareResult.setTitle(title);
				if (StringUtils.isNotBlank(basicInfo.getCover())) {
					shareResult.setIconUrl(ImageHelper.upImageThumbnail(basicInfo.getCover(), 120));
				}
				if (StringUtils.isNotBlank(basicInfo.getTagCode())
						&& (basicInfo.getTagCode().contains("GGBH161020110001")
								|| basicInfo.getTagCode().contains("GGBH161020210001")
								|| basicInfo.getTagCode().contains("GGBH161020210002")
								|| basicInfo.getTagCode().contains("GGBH161020210003"))) {
					shareResult.setContent(TopHelper.upInfo(810710021));
				} else if (recomm != null && StringUtils.isNotBlank(recomm.getContent())) {
					shareResult.setContent(recomm.getContent());
				} else {
					shareResult.setContent(TopHelper.upInfo(810710011, authorName));
				}
			} 
		}

		return shareResult;
	}

}
