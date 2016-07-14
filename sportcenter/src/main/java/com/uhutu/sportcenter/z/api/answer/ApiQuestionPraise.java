package com.uhutu.sportcenter.z.api.answer;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.activity.z.entity.AcActivityAnswerInfo;
import com.uhutu.dcom.activity.z.support.AnswerActivitySupport;
import com.uhutu.dcom.answer.z.entity.AwAnswerListen;
import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.config.enums.PrexEnum;
import com.uhutu.dcom.content.z.entity.CnSupportPraise;
import com.uhutu.sportcenter.z.input.ApiQuestionPraiseInput;
import com.uhutu.sportcenter.z.result.ApiSupportPraiseResult;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/***
 * 问达信息赞的接口
 * 
 * @author xiegj
 *
 */
@Component
public class ApiQuestionPraise extends RootApiToken<ApiQuestionPraiseInput, ApiSupportPraiseResult> {

	protected ApiSupportPraiseResult process(ApiQuestionPraiseInput input) {
		ApiSupportPraiseResult result = new ApiSupportPraiseResult();
		if (StringUtils.isNotBlank(input.getCode())) {
			AwQuestionInfo questionInfo = JdbcHelper.queryOne(AwQuestionInfo.class, "code", input.getCode());
			if ("dzsd4888100110020001".equals(questionInfo.getScope())) {// 私密和未回答问题不能赞
				result.inError(88880011);
				result.setError(TopHelper.upInfo(88880011));
			} else if (!"dzsd4888100110010002".equals(questionInfo.getStatus())) {
				result.inError(88880012);
				result.setError(TopHelper.upInfo(88880012));
			}
			if (result.upFlagTrue()) {// 已赞过的不能赞
				CnSupportPraise cnSupportPraise = JdbcHelper.queryOne(CnSupportPraise.class, "user_code", upUserCode(),
						"content_code", input.getCode());
				if (cnSupportPraise != null) {
					result.inError(88880013);
					result.setError(TopHelper.upInfo(88880013));
				}
				if (result.upFlagTrue()) {// 提问人和回答人或者已支付的偷听人才能赞
					AcActivityAnswerInfo activity = new AnswerActivitySupport().getActivityInfoByAnswerCode(questionInfo.getCode());
					AwAnswerListen listen = JdbcHelper.queryOne(AwAnswerListen.class, "question_code",
							questionInfo.getCode(), "user_code", upUserCode());
					if (listen != null || upUserCode().equals(questionInfo.getQuestionUserCode())
							|| upUserCode().equals(questionInfo.getAnswerUserCode())||(activity!=null&&BigDecimal.ZERO.compareTo(activity.getPrice())==0)) {
						CnSupportPraise praise = new CnSupportPraise();
						praise.setCode(
								PrexEnum.CNE.toString() + DateFormatUtils.format(new Date(), "yyyyMMddhhmmssSSS"));
						praise.setContentCode(input.getCode());
						praise.setType("01");
						praise.setUserCode(upUserCode());
						praise.setStatus("1");
						JdbcHelper.insert(praise);
						questionInfo.setLove(questionInfo.getLove() + 1);
						JdbcHelper.update(questionInfo, "love", "za");
					} else {
						result.inError(88880014);
						result.setError(TopHelper.upInfo(88880014));
					}
				}
			}
		}
		return result;
	}

}
