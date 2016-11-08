package com.uhutu.dcom.user.z.page.func;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.extend.baiduPush.exception.PushClientException;
import com.uhutu.dcom.extend.baiduPush.exception.PushServerException;
import com.uhutu.dcom.extend.baiduPush.sample.BaiduPush;
import com.uhutu.dcom.extend.baiduPush.sample.PushEnum;
import com.uhutu.dcom.user.z.entity.UcClientInfo;
import com.uhutu.dcom.user.z.entity.UcMsgNoticePush;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

/**
 * baidu push
 * 
 * @author xiegj
 *
 */
public class UcMsgPushFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		try {
			UcMsgNoticePush push = JdbcHelper.queryOne(UcMsgNoticePush.class, "za", input.getDataMap().get("za"));
			if (push != null && StringUtils.isNotBlank(push.getIosContent())
					&& StringUtils.isNotBlank(push.getAndroidContent())) {
				String[] ucs = push.getUserCode().split(",");
				for (int i = 0; i < ucs.length; i++) {
					UcClientInfo ucClientInfo = JdbcHelper.queryOne(UcClientInfo.class, "", "-zc", "",
							MapHelper.initMap("user_code", ucs[i], "os", "ios"));

					if (ucClientInfo != null && StringUtils.isNotBlank(ucClientInfo.getChannelId())) {
						new BaiduPush().push(PushEnum.ios, "果冻体育", push.getIosContent(), ucClientInfo.getChannelId(),
								"7", "");
					}

					UcClientInfo android = JdbcHelper.queryOne(UcClientInfo.class, "", "-zc", "",
							MapHelper.initMap("user_code", ucs[i], "os", "android"));

					if (android != null && StringUtils.isNotBlank(android.getChannelId())) {
						new BaiduPush().push(PushEnum.android, "果冻体育", push.getAndroidContent(), android.getChannelId(),
								"7", "");
					}
				}
				push.setPushNum(push.getPushNum()+1);
				JdbcHelper.update(push, "pushNum", "za");
			} else {
				result.inError(81100019);
			}
		} catch (PushServerException e) {
			e.printStackTrace();
		} catch (PushClientException e) {
			e.printStackTrace();
		}

		return result;
	}

}
