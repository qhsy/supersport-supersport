package com.uhutu.dcom.user.z.page.func;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.user.z.entity.UcMsgNotice;
import com.uhutu.dcom.user.z.entity.UcMsgNoticePush;
import com.uhutu.dcom.user.z.entity.UcMsgNoticeUser;
import com.uhutu.dcom.user.z.enums.MsgEnum;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.helper.WebHelper;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

/**
 * 站内信发送
 * 
 * @author xiegj
 *
 */
public class UcMsgNoticeFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		UcMsgNoticePush push = JdbcHelper.queryOne(UcMsgNoticePush.class, "za", input.getDataMap().get("za"));
		if (push != null && StringUtils.isNotBlank(push.getContent())) {
			String[] ucs = push.getUserCode().split(",");
			for (int i = 0; i < ucs.length; i++) {
				UcMsgNotice notice = new UcMsgNotice();
				notice.setCode(WebHelper.upCode("MNTCBH"));
				notice.setContent(push.getContent());
				notice.setNotifyTime(DateHelper.upDate(new Date()));
				notice.setStatus("0");
				notice.setTitle("系统消息");
				notice.setType(MsgEnum.TYPE_SYSTEM.getCode());
				notice.setSendType(MsgEnum.TO_ONE.getCode());
				JdbcHelper.insert(notice);
				UcMsgNoticeUser ucMsgNoticeUser = new UcMsgNoticeUser();
				ucMsgNoticeUser.setNoticeCode(notice.getCode());
				ucMsgNoticeUser.setUserCode(ucs[i]);
				ucMsgNoticeUser.setStatus(MsgEnum.FLAG_UNREAD.getCode());
				ucMsgNoticeUser.setZc(new Date());
				JdbcHelper.insert(ucMsgNoticeUser);
			}
		} else {
			result.inError(81100018);
		}
		return result;
	}

}
