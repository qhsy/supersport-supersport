package com.uhutu.sportcenter.z.api.answer;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.common.AnswerEnum;
import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.answer.z.service.AnswerServiceFactory;
import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.user.z.entity.UserBasicInfo;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.entity.QuestionInfo;
import com.uhutu.sportcenter.z.input.ApiAnswerInfoListInput;
import com.uhutu.sportcenter.z.result.ApiAnswerInfoListResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 个人中心我答
 * 
 * @author 逄小帅
 *
 */
@Component
public class ApiAnswerInfoList extends RootApiToken<ApiAnswerInfoListInput, ApiAnswerInfoListResult> {

	@Autowired
	private AnswerServiceFactory answerServiceFactory;

	@Autowired
	private UserInfoSupport userInfoSupport;

	@Override
	protected ApiAnswerInfoListResult process(ApiAnswerInfoListInput input) {
		
		ApiAnswerInfoListResult result = new ApiAnswerInfoListResult();
		
		String status = "";
		
		if(StringUtils.isBlank(input.getStatus())){
			
			status = AnswerEnum.STATUS_UNANSWER.getCode();
			
		}else{
			
			status = input.getStatus();
			
		}
		
		int total = answerServiceFactory.getQuestionInfoService().queryAnswerCount(upUserCode(), status);
		
		int allTotal = answerServiceFactory.getQuestionInfoService().queryAnswerCount(upUserCode(), "");
		
		result.setAllTotal(allTotal);
		
		result.setTotal(total);
		
		PageInfo pageInfo = null;
		
		if(StringUtils.isNotBlank(input.getStatus())){
			
			pageInfo = new PageInfo(total, input.getPagination(), input.getPageNum());
			
		}else{
			
			pageInfo = new PageInfo(allTotal, input.getPagination(), input.getPageNum());
			
		}
		
		result.setNextFlag(pageInfo.hasNext());
		
		int iStart = (input.getPagination() - 1)*input.getPageNum();
		
		List<AwQuestionInfo> awQuestionInfos = answerServiceFactory.getQuestionInfoService().
				queryAnswerList(upUserCode(), "",input.getStatus(), iStart, input.getPageNum());
		
		result.setQuestionInfos(convert(awQuestionInfos));
		
		return result;
	}

	/**
	 * 初始问题信息
	 * 
	 * @param awQuestionInfos
	 *            问答信息集合
	 * @return
	 */
	public List<QuestionInfo> convert(List<AwQuestionInfo> awQuestionInfos) {

		List<QuestionInfo> questionInfos = new ArrayList<QuestionInfo>();

		awQuestionInfos.forEach(awQuestionInfo -> {

			QuestionInfo questionInfo = new QuestionInfo();

			BeanUtils.copyProperties(awQuestionInfo, questionInfo);

			questionInfo.setUserCode(awQuestionInfo.getQuestionUserCode());

			UserBasicInfo userBasicInfo = userInfoSupport.getUserBasicInfo(questionInfo.getUserCode());

			questionInfo.setAboutHead(userBasicInfo.getUcUserinfoExt().getAboutHead());

			questionInfo.setNickName(userBasicInfo.getUcUserinfoExt().getNickName());

			questionInfo.setType(userBasicInfo.getUcUserinfo().getType());

			questionInfos.add(questionInfo);

		});

		return questionInfos;

	}

}
