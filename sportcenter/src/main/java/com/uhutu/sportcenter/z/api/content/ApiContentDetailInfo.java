package com.uhutu.sportcenter.z.api.content;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentDetail;
import com.uhutu.dcom.content.z.entity.CnContentReadCount;
import com.uhutu.dcom.content.z.entity.CnContentRecomm;
import com.uhutu.dcom.content.z.entity.CnContentRedpackFlow;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.tag.z.service.ContentLabelServiceFactory;
import com.uhutu.dcom.user.z.entity.UcAttentionInfo;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.api.util.ContentComponent;
import com.uhutu.sportcenter.z.api.util.PictureUtil;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.entity.ContentDetailInfo;
import com.uhutu.sportcenter.z.entity.ContentRecommInfo;
import com.uhutu.sportcenter.z.entity.UserBasicInfo;
import com.uhutu.sportcenter.z.input.ApiContentDetailInput;
import com.uhutu.sportcenter.z.result.ApiContentDetailResult;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoocom.z.bean.TopUserFactory;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 内容详情信息
 * 
 * @author pang_jhui
 *
 */
@Service
public class ApiContentDetailInfo extends RootApiBase<ApiContentDetailInput, ApiContentDetailResult> {

	@Autowired
	private ContentServiceFactory contentServiceFactory;

	@Autowired
	private ContentLabelServiceFactory labelServiceFacotry;

	@Autowired
	private UserInfoSupport userInfoSupport;

	@Override
	protected ApiContentDetailResult process(ApiContentDetailInput input) {

		ApiContentDetailResult contentDetailResult = new ApiContentDetailResult();

		if (StringUtils.isNotBlank(input.getContent_code())) {

			CnContentDetail cnContentDetail = contentServiceFactory.getContentDetailService()
					.queryByCode(input.getContent_code());

			ContentBasicinfoForApi contentBasicinfoForApi = new ContentBasicinfoForApi();

			CnContentBasicinfo cnContentBasicinfo = contentServiceFactory.getContentBasicinfoService()
					.queryByCode(input.getContent_code());

			ContentDetailInfo contentDetailInfo = new ContentDetailInfo();

			if (cnContentDetail != null) {

				BeanUtils.copyProperties(cnContentDetail, contentDetailInfo);

				BeanUtils.copyProperties(cnContentBasicinfo, contentBasicinfoForApi);

				UcUserinfo userInfo = userInfoSupport.getUserInfo(contentBasicinfoForApi.getAuthor());

				UcUserinfoExt ucUserinfoExt = userInfoSupport.getUserInfoExt(contentBasicinfoForApi.getAuthor());

				if (ucUserinfoExt != null) {

					contentBasicinfoForApi.getUserBasicInfo().setAboutHead(ucUserinfoExt.getAboutHead());
					contentBasicinfoForApi.getUserBasicInfo().setTitle(ucUserinfoExt.getTitle());
					contentBasicinfoForApi.getUserBasicInfo().setNickName(ucUserinfoExt.getNickName());

				}

				if (userInfo != null) {

					contentBasicinfoForApi.getUserBasicInfo().setType(userInfo.getType());

					contentBasicinfoForApi.getUserBasicInfo().setUserCode(userInfo.getCode());
					if (StringUtils.isNotBlank(input.getZoo().getToken())) {
						UcAttentionInfo attentionInfo = JdbcHelper.queryOne(UcAttentionInfo.class, "attention",
								TopUserFactory.upUserCallFactory().upUserCodeByAuthToken(input.getZoo().getToken(),
										DefineUser.Login_System_Default),
								"be_attention", userInfo.getCode(), "status", "1");
						if (attentionInfo != null) {
							contentBasicinfoForApi.setAuthorBeAttentionFlag(true);
						}
					}
				}

//				contentBasicinfoForApi.setTagName(
//						labelServiceFacotry.getContentLabelService().initTagName(cnContentBasicinfo.getTagCode()));
//
//				contentBasicinfoForApi.setTags(
//						labelServiceFacotry.getContentLabelService().getLabels(cnContentBasicinfo.getTagCode()));
				contentBasicinfoForApi.setFavorFlag(
						ContentComponent.lightFavor(contentBasicinfoForApi.getCode(), input.getZoo().getToken()));
				contentBasicinfoForApi.setAuthorFlag(
						ContentComponent.oneLogin(contentBasicinfoForApi.getAuthor(), input.getZoo().getToken()));
				contentBasicinfoForApi.setPublishTimeStr("MM-dd HH:mm");
				CnContentReadCount contentReadCount = JdbcHelper.queryOne(CnContentReadCount.class, "contentCode",
						contentBasicinfoForApi.getCode());
				int praiseNum = contentServiceFactory.getSupportPraiseService()
						.queryCountByCode(contentBasicinfoForApi.getCode(), ContentEnum.FAVOR_STATUS_YES.getCode());
				contentBasicinfoForApi.setPraiseNum(praiseNum);
				contentBasicinfoForApi.setReadNum(contentReadCount != null ? contentReadCount.getCount() : 0);
				ContentRecommInfo recommInfo = new ContentRecommInfo();

				CnContentRecomm sourceRecommInfo = contentServiceFactory.getContentRecommService()
						.queryEntityByCode(input.getContent_code());

				if (sourceRecommInfo != null) {

					BeanUtils.copyProperties(sourceRecommInfo, recommInfo);

					contentDetailResult.setContentRecommInfo(recommInfo);

				}

				if (contentDetailInfo != null && StringUtils.isNotBlank(contentDetailInfo.getContent())) {
					List<String> picList = PictureUtil.getImgStr(contentDetailInfo.getContent());
					if (input.getWidth() > 0) {
						for (int j = 0; j < picList.size(); j++) {
							// 图片压缩处理
							String imgSrc = ImageHelper.upImageThumbnail(picList.get(j), input.getWidth());
							contentDetailInfo
									.setContent(contentDetailInfo.getContent().replace(picList.get(j), imgSrc));
						}
					}
				}

				/* 内容emoji表情处理 */
				String content = contentDetailInfo.getContent();

				content = StringUtils.isEmpty(content) ? "" : EmojiUtil.emojiRecovery(content);

				contentDetailInfo.setContent(content);
				if (StringUtils.isNotBlank(contentDetailInfo.getVideoCover())) {
					contentDetailInfo.setVideoCover(
							ImageHelper.upImageThumbnail(contentDetailInfo.getVideoCover(), input.getWidth()));
				}
				
				/*初始化红包相关*/
				contentDetailInfo.setRedPackNum(redPackNum(input.getContent_code()));
				
				contentDetailInfo.setRedPackUsers(redPackUsers(input.getContent_code()));
				
				contentDetailResult.setContentDetailInfo(contentDetailInfo);
				if ("dzsd4107100110030004".equals(contentBasicinfoForApi.getContentType())) {// 单图模式的时候内容做标题
					contentBasicinfoForApi.setTitle(contentDetailInfo.getContent());
				}
				if (StringUtils.isNotBlank(contentBasicinfoForApi.getCover())) {
					contentBasicinfoForApi.setCover(
							ImageHelper.upImageThumbnail(contentBasicinfoForApi.getCover(), input.getWidth()));
				}

				/* 标题emoji表情处理 */
				String title = contentBasicinfoForApi.getTitle();

				title = StringUtils.isEmpty(title) ? "" : EmojiUtil.emojiRecovery(title);

				contentBasicinfoForApi.setTitle(title);

				contentDetailResult.setSportingMoment(contentBasicinfoForApi);
				
				

			} else {

				contentDetailResult.setStatus(0);

				contentDetailResult.setError("内容详情不存在");

			}

		}

		return contentDetailResult;

	}
	
	/**
	 * 获取红包打赏的人数
	 * @param contentCode
	 * @return
	 */
	public int redPackNum(String contentCode){
		
		StringBuffer sqlBuffer= new StringBuffer();
		
		sqlBuffer.append(" content_code = '").append(contentCode).append("'");
		
		sqlBuffer.append(" and status = '").append(SystemEnum.NORMAL.getCode()).append("'");
		
		String totalStr = JdbcHelper.dataGet("cn_content_redpack_flow", "count(DISTINCT send_user_code)", sqlBuffer.toString(), new MDataMap());
		
		int total = Integer.parseInt(totalStr);
		
		return total;
		
	}
	
	/**
	 * 内容打赏人员
	 * @param contentCode
	 * @return
	 */
	public List<UserBasicInfo> redPackUsers(String contentCode){
		
		MDataMap mWhereMap = new MDataMap();
		
		List<String> repeatCodes = new ArrayList<String>();
		
		List<UserBasicInfo> userBasicInfos = new ArrayList<UserBasicInfo>();
		
		mWhereMap.put("contentCode", contentCode);
		
		mWhereMap.put("status", SystemEnum.NORMAL.getCode());
		
		List<CnContentRedpackFlow> contentRedPacks = JdbcHelper.queryForList(CnContentRedpackFlow.class, "", "-zc", "", mWhereMap, 0, 16);
		
		for (CnContentRedpackFlow cnContentRedpack : contentRedPacks) {
			
			if(cnContentRedpack != null){
				
				if(!repeatCodes.contains(cnContentRedpack.getSendUserCode())){					
					
					UcUserinfo ucUserinfo = userInfoSupport.getUserInfo(cnContentRedpack.getSendUserCode());
					
					UcUserinfoExt ucUserinfoExt = userInfoSupport.getUserInfoExt(cnContentRedpack.getSendUserCode());
					
					if(ucUserinfo != null && ucUserinfoExt != null){
						
						repeatCodes.add(cnContentRedpack.getSendUserCode());
						
						UserBasicInfo basicInfo = new UserBasicInfo();
						
						basicInfo.setAboutHead(ucUserinfoExt.getAboutHead());
						
						basicInfo.setNickName(EmojiUtil.emojiRecovery(ucUserinfoExt.getNickName()));
						
						basicInfo.setTitle(ucUserinfoExt.getTitle());
						
						basicInfo.setType(ucUserinfo.getType());
						
						basicInfo.setUserCode(ucUserinfo.getCode());
						
						userBasicInfos.add(basicInfo);
						
					}
					
				}
				
			}
			
		}
		
		return userBasicInfos;
		
	}

}
