package com.uhutu.sportcenter.z.api.user;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.remark.z.entity.CnContentRemark;
import com.uhutu.dcom.remark.z.service.ContentRemarkServiceFactory;
import com.uhutu.dcom.user.z.entity.UcMsgRemark;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.ContentRemarkInfo;
import com.uhutu.sportcenter.z.entity.ContentReplyInfo;
import com.uhutu.sportcenter.z.input.ApiMsgRemarkListInput;
import com.uhutu.sportcenter.z.result.ApiMsgRemarkResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 用户消息中心评论列表
 * 
 * @author 逄小帅
 *
 */
@Component
public class ApiMsgRemarkList extends RootApiToken<ApiMsgRemarkListInput, ApiMsgRemarkResult> {

	@Autowired
	private ContentRemarkServiceFactory serviceFactory;

	@Autowired
	private UserServiceFactory userSerivceFactory;

	@Override
	protected ApiMsgRemarkResult process(ApiMsgRemarkListInput input) {

		ApiMsgRemarkResult msgRemarkResult = new ApiMsgRemarkResult();

		String userCode = upUserCode();
		
		int iNumber = 10;
		
		int iStart = (input.getPagination() - 1) * iNumber;
		
		String sqlWhere = "EXISTS (select 1 from cn_content_remark where remark_code = code and status ='dzsd4699100110010001') and user_code='"+userCode+"'";
		
		List<UcMsgRemark> msgRemarkList = JdbcHelper.queryForList(UcMsgRemark.class, "", "msg_time desc", sqlWhere, new MDataMap(), iStart, iNumber);
		
		int count = JdbcHelper.count(UcMsgRemark.class, sqlWhere, new MDataMap());
		
		PageInfo pageInfo = new PageInfo(count, input.getPagination(), iNumber);
		
		msgRemarkResult.setNextflag(pageInfo.hasNext());
		
		msgRemarkList.forEach(msgRemark -> {

			ContentReplyInfo contentReplyInfo = new ContentReplyInfo();
			
			String title = msgRemark.getContentTitle();
			
			title = StringUtils.isEmpty(title) ? "" : EmojiUtil.emojiRecovery(title);

			contentReplyInfo.setContentTitle(title);

			CnContentBasicinfo contentBasicinfo = JdbcHelper.queryOne(CnContentBasicinfo.class, "code",
					msgRemark.getContentCode());
			if (StringUtils.isNoneBlank(contentBasicinfo.getCover())) {
				contentReplyInfo.setContentCover(ImageHelper.upImageThumbnail(contentBasicinfo.getCover(), 100));
			}
			if (contentBasicinfo != null) {

				contentReplyInfo.setContentType(contentBasicinfo.getContentType());

			}

			if (StringUtils.isNotBlank(msgRemark.getContentAuthor())) {

				UcUserinfoExt ucUserinfoExt = userSerivceFactory.getUserInfoExtService()
						.queryByUserCode(msgRemark.getContentAuthor());

				if (ucUserinfoExt != null) {

					contentReplyInfo.setAuthorName(ucUserinfoExt.getNickName());

				}

			}

			CnContentRemark contentRemarkInfo = serviceFactory.getContentRemarkService()
					.queryByCode(msgRemark.getRemarkCode());

			contentReplyInfo.setReplyInfo(initRemarkInfo(contentRemarkInfo));

			if (StringUtils.isNotBlank(msgRemark.getRemarkParentCode()) && contentReplyInfo.getReplyInfo() != null) {

				CnContentRemark parentRemarkInfo = serviceFactory.getContentRemarkService()
						.queryByCode(msgRemark.getRemarkParentCode());

				contentReplyInfo.setRefReplyInfo(initRemarkInfo(parentRemarkInfo));

			}
			
			if(contentReplyInfo.getRefReplyInfo() == null){
				
				if(contentReplyInfo.getReplyInfo() != null && StringUtils.isNotEmpty(contentReplyInfo.getReplyInfo().getParentCode())){
					
					contentReplyInfo.setParentFlag(true);
					
				}
				
			}

			msgRemarkResult.getContentRemarkInfo().add(contentReplyInfo);

		});

		return msgRemarkResult;

	}

	public ContentRemarkInfo initRemarkInfo(CnContentRemark remark) {

		ContentRemarkInfo remarkInfo = null;

		if (remark != null) {

			remarkInfo = new ContentRemarkInfo();

			BeanUtils.copyProperties(remark, remarkInfo);

			String remarkContent = "";

			if (StringUtils.isNotBlank(remarkInfo.getRemark())) {

				remarkContent = EmojiUtil.emojiRecovery(remarkInfo.getRemark());

			}

			remarkInfo.setRemark(remarkContent);

			UcUserinfoExt ucUserinfoExt = userSerivceFactory.getUserInfoExtService()
					.queryByUserCode(remark.getAuthor());

			UcUserinfo ucUserinfo = userSerivceFactory.getUserInfoService().queryByCode(remark.getAuthor());

			if (ucUserinfoExt != null && ucUserinfo != null) {

				remarkInfo.setNickName(ucUserinfoExt.getNickName());

				remarkInfo.setAboutHead(ucUserinfoExt.getAboutHead());

				remarkInfo.setType(ucUserinfo.getType());

			}

			String publishDate = DateFormatUtils.format(remark.getZc(), "yyyy-MM-dd HH:mm:ss");

			remarkInfo.setPublishTime(publishDate);

		}

		return remarkInfo;

	}

}
