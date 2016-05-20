package com.uhutu.sportcenter.z.api.user;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiMsgNoticeListInput;
import com.uhutu.sportcenter.z.result.ApiMsgNoticeListResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 消息通知列表
 * @author 逄小帅
 *
 */
@Component
public class ApiMsgNoticeList extends RootApiToken<ApiMsgNoticeListInput, ApiMsgNoticeListResult> {

	@Override
	protected ApiMsgNoticeListResult process(ApiMsgNoticeListInput input) {
		
		return new ApiMsgNoticeListResult();
	}

}
