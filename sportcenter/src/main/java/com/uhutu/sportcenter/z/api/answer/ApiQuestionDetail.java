package com.uhutu.sportcenter.z.api.answer;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.activity.z.entity.AcActivityAnswerInfo;
import com.uhutu.dcom.activity.z.support.AnswerActivitySupport;
import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.dcom.answer.z.entity.AwPointRecommen;
import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.answer.z.properties.ConfigDcomAnswer;
import com.uhutu.dcom.answer.z.support.QuestionSupport;
import com.uhutu.dcom.answer.z.support.vo.QuestionForShow;
import com.uhutu.dcom.component.z.util.CalendarUtil;
import com.uhutu.dcom.content.z.entity.CnSupportPraise;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.enums.UserEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiQuestionDetailInput;
import com.uhutu.sportcenter.z.result.ApiQuestionDetailResult;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiForMember;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 问达详情信息
 *
 */
@Component
public class ApiQuestionDetail extends RootApiForMember<ApiQuestionDetailInput, ApiQuestionDetailResult> {

	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiQuestionDetailResult process(ApiQuestionDetailInput input) {
		ApiQuestionDetailResult result = new ApiQuestionDetailResult();
		AwQuestionInfo questionInfo = JdbcHelper.queryOne(AwQuestionInfo.class, "code", input.getCode());
		UcUserinfo askUserInfo = JdbcHelper.queryOne(UcUserinfo.class, "code", questionInfo.getQuestionUserCode());
		UcUserinfoExt askUserExt = JdbcHelper.queryOne(UcUserinfoExt.class, "user_code",
				questionInfo.getQuestionUserCode());
		UcUserinfo answerUserInfo = JdbcHelper.queryOne(UcUserinfo.class, "code", questionInfo.getAnswerUserCode());
		UcUserinfoExt answerUserExt = JdbcHelper.queryOne(UcUserinfoExt.class, "user_code",
				questionInfo.getAnswerUserCode());
		AwAnswerExpert answerUserExpert = JdbcHelper.queryOne(AwAnswerExpert.class, "user_code",
				questionInfo.getAnswerUserCode());
		result.getDetail().setAnswerUserCode(answerUserInfo.getCode());
		result.getDetail().setAnswerUserFans(userServiceFactory.getAttentionInfoService()
				.queryFansCount(questionInfo.getAnswerUserCode(), UserEnum.ATTEND.getCode()));
		result.getDetail().setAnswerUserHeadUrl(answerUserExt.getAboutHead());
		result.getDetail().setAnswerUserNickName(answerUserExt.getNickName());
		result.getDetail().setAnswerUserTitle(answerUserExpert.getTitle());
		result.getDetail().setAnswerUserType(answerUserInfo.getType());
		result.getDetail().setCode(questionInfo.getCode());
		result.getDetail().setContent(questionInfo.getContent());
		result.getDetail().setListen(questionInfo.getListen());
		if (isFlagLogin()) {
			result.getDetail().setListenFlag(
					new QuestionSupport().checkUserLitenTheQuestion(upUserCode(), questionInfo.getCode()));
			CnSupportPraise praise = JdbcHelper.queryOne(CnSupportPraise.class, "content_code", questionInfo.getCode(),
					"user_code", upUserCode());
			result.getDetail().setLoveFlag(praise != null ? true : false);
		}
		result.getDetail().setLove(questionInfo.getLove());
		result.getDetail().setMoney(questionInfo.getMoney());
		result.getDetail().setQuestionUserCode(askUserInfo.getCode());
		result.getDetail().setQuestionUserHeadUrl(askUserExt.getAboutHead());
		result.getDetail().setQuestionUserNickName(askUserExt.getNickName());
		result.getDetail().setQuestionUserType(askUserInfo.getType());
		result.getDetail().setSellMoney(questionInfo.getSellMoney());
		result.getDetail().setStatus(questionInfo.getStatus());
		result.getDetail().setTimeShow(CalendarUtil.formateTip(DateHelper.parseDate(questionInfo.getQuestionTime())));
		result.getDetail().setVideoLengh(questionInfo.getLengh());
		result.getDetail().setVideoShow(ConfigDcomAnswer.upConfig().getAnswerVideoShow());
		AcActivityAnswerInfo activityInfo = new AnswerActivitySupport()
				.getActivityInfoByAnswerCode(questionInfo.getCode());
		if (activityInfo != null) {
			result.getDetail().setVideoShow(activityInfo.getName());
		}

		result.getDetail().setVideoUrl(questionInfo.getUrl());
		result.getDetail().setScope(questionInfo.getScope());
		
		if(randomSomthing() != null){
			
			result.getRecommons().add(randomSomthing());
			
		}
		
		return result;
	}
	

	private QuestionForShow randomSomthing() {
		
		QuestionForShow show = null;
		
		List<AwPointRecommen> list = JdbcHelper.queryForList(AwPointRecommen.class, "", "",
				"type='dzsd4888100110030005'", new MDataMap());
		
		if(list.size() > 0){
			
			show = new QuestionForShow();
				
			
			Random rand = new Random();
			String code = list.get(rand.nextInt(list.size())).getAnswerCode();
			AwQuestionInfo info = JdbcHelper.queryOne(AwQuestionInfo.class, "code", code);
			UcUserinfoExt userinfoExt = JdbcHelper.queryOne(UcUserinfoExt.class, "user_code", info.getAnswerUserCode());
			AwAnswerExpert expert = JdbcHelper.queryOne(AwAnswerExpert.class, "user_code", info.getAnswerUserCode());
			UcUserinfo userinfo = JdbcHelper.queryOne(UcUserinfo.class, "code", info.getAnswerUserCode());
			show.setCode(info.getCode());
			show.setContent(info.getContent());
			show.setHeadUrl(userinfoExt.getAboutHead());
			show.setLength(info.getLengh());
			show.setListen(info.getListen());
			show.setNickName(userinfoExt.getNickName());
			show.setSoundContent(QuestionSupport.soundContent(info.getCode()));
			show.setTimeShow(CalendarUtil.formateTip(DateHelper.parseDate(info.getQuestionTime())));
			show.setTitle(expert.getTitle());
			show.setUserCode(info.getAnswerUserCode());
			show.setUserType(userinfo.getType());
			
		}
		
		return show;
	}
}
