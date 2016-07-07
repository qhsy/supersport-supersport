package com.uhutu.sportcenter.z.api.answer;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.sportcenter.z.input.ApiAnswerQuestionDetailInput;
import com.uhutu.sportcenter.z.result.ApiAnswerQuestionDetailResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 回答时需要的个人信息及问题信息
 * 
 * @author xiegj
 *
 */
@Component
public class ApiAnswerQuestionDetail extends RootApiToken<ApiAnswerQuestionDetailInput, ApiAnswerQuestionDetailResult> {

	@Override
	protected ApiAnswerQuestionDetailResult process(ApiAnswerQuestionDetailInput input) {

		ApiAnswerQuestionDetailResult result = new ApiAnswerQuestionDetailResult();
		if (StringUtils.isNotBlank(input.getCode())) {
			AwQuestionInfo questionInfo = JdbcHelper.queryOne(AwQuestionInfo.class, "code", input.getCode());
			if (questionInfo != null) {
				UcUserinfoExt ext = JdbcHelper.queryOne(UcUserinfoExt.class, "user_code",
						questionInfo.getQuestionUserCode());
				UcUserinfo info = JdbcHelper.queryOne(UcUserinfo.class, "code", questionInfo.getQuestionUserCode());
				result.getShow().setAnswerCode(questionInfo.getCode());
				result.getShow().setAskMoney(questionInfo.getMoney());
				result.getShow().setContent(questionInfo.getContent());
				result.getShow().setHeadUrl(ext.getAboutHead());
				result.getShow().setNickName(ext.getNickName());
				result.getShow().setScope(questionInfo.getScope());
				result.getShow().setType(info.getType());
				result.getShow().setUserCode(questionInfo.getQuestionUserCode());
				result.getShow().setTimeShow(getDistanceTime(questionInfo.getZc(), 48));
			} else {
				result.inError(88880008);
			}
		}
		return result;
	}

	public static String getDistanceTime(Date one, int hours) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(one);
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		Date two = calendar.getTime();
		long day = 0;
		long hour = 0;
		long min = 0;
		long time1 = one.getTime();
		long time2 = two.getTime();
		long diff;
		if (time1 < time2) {
			diff = time2 - time1;
		} else {
			diff = time1 - time2;
		}
		day = diff / (24 * 60 * 60 * 1000);
		hour = (diff / (60 * 60 * 1000) - day * 24);
		min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
		return "还有" + hour + "小时" + min + "分过期";
	}
}
