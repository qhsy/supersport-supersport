package com.uhutu.sportcenter.z.api.answer;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.answer.z.service.AnswerServiceFactory;
import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.user.z.entity.UserBasicInfo;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.entity.QuestionInfo;
import com.uhutu.sportcenter.z.input.ApiQuestionInfoListInput;
import com.uhutu.sportcenter.z.result.ApiQuestionInfoListResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 个人中心我问信息列表
 * @author 逄小帅
 *
 */
@Component
public class ApiQuestionInfoList extends RootApiToken<ApiQuestionInfoListInput, ApiQuestionInfoListResult> {

	@Autowired
	private AnswerServiceFactory serviceFactory;
	
	@Autowired
	private UserInfoSupport userInfoSupport;
	
	@Override
	protected ApiQuestionInfoListResult process(ApiQuestionInfoListInput input) {
		
		ApiQuestionInfoListResult questionResult = new ApiQuestionInfoListResult();
		
		int total = serviceFactory.getQuestionInfoService().queryCount(upUserCode());
		
		PageInfo pageInfo = new PageInfo(total, 20, input.getPagination());
		
		questionResult.setNextFlag(pageInfo.hasNext());
		
		questionResult.setTotal(total);
		
		int iStart = (input.getPagination() - 1)*input.getPageNum();
		
		List<AwQuestionInfo> questionInfos = serviceFactory.getQuestionInfoService().queryList(upUserCode(), iStart, input.getPageNum());
		
		questionResult.setQuestionInfos(convert(questionInfos));
		
		return questionResult;
	}
	
	/**
	 * 初始问题信息
	 * @param awQuestionInfos
	 * 		问答信息集合
	 * @return
	 */
	public List<QuestionInfo> convert(List<AwQuestionInfo> awQuestionInfos){
		
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
