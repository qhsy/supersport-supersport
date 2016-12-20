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
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;
import com.uhutu.zooweb.user.UserCallFactory;

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

		if (StringUtils.isNotBlank(input.getContentCode())) {// 分享信息主表
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
		if (StringUtils.isNotBlank(input.getContentCode()) && input.getContentCode().startsWith("CNBH")) {// 文章的分享特殊逻辑
																											// 原因：小编推荐

			CnContentBasicinfo basicInfo = contentServiceFactory.getContentBasicinfoService()
					.queryByCode(input.getContentCode());

			CnContentRecomm recomm = contentServiceFactory.getContentRecommService()
					.queryEntityByCode(input.getContentCode());
			String authorName = "";
			if (StringUtils.isNotBlank(basicInfo.getAuthor())) {
				UcUserinfoExt ue = JdbcHelper.queryOne(UcUserinfoExt.class, "userCode", basicInfo.getAuthor());
				authorName = StringUtils.isNotBlank(ue.getNickName()) ? ue.getNickName() : "";
			}

			

			if (basicInfo != null) {

				shareResult.setTitle(basicInfo.getTitle());
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
					if (StringUtils.isNotBlank(basicInfo.getContentType())
							&& "dzsd4107100110030007".equals(basicInfo.getContentType())
							&& StringUtils.isNotBlank(authorName)) {// 直播分享信息
						if (StringUtils.isNotEmpty(input.getZoo().getToken())) {
							String userCode = new UserCallFactory().upUserCodeByAuthToken(input.getZoo().getToken(),
									DefineUser.Login_System_Default);
							UcUserinfoExt ucext = JdbcHelper.queryOne(UcUserinfoExt.class, "user_code", userCode);
							shareResult.setTitle(TopHelper.upInfo(810710022, ucext.getNickName()));
						}
 						shareResult.setContent(TopHelper.upInfo(810710023, authorName, basicInfo.getTitle()));
					} else {
						shareResult.setContent(TopHelper.upInfo(810710011, authorName));
					}
				}
			}
		}
		if (StringUtils.isNotBlank(shareResult.getContent())) {
			shareResult.setAboutDesc(shareResult.getContent());
		}
		if (StringUtils.isNotBlank(shareResult.getIconUrl())) {
			shareResult.setCover(shareResult.getIconUrl());
		}
		
		String title = StringUtils.isEmpty(shareResult.getTitle()) ? "" : EmojiUtil.emojiRecovery(shareResult.getTitle());
		
		shareResult.setTitle(title);
		
		return shareResult;
	}

}
