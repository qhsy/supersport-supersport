package com.uhutu.sportcenter.z.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiAnswerUserInfoInput;
import com.uhutu.sportcenter.z.input.ApiForAnswerQuestionInput;
import com.uhutu.sportcenter.z.input.ApiForAskQuestionInput;
import com.uhutu.sportcenter.z.input.ApiHotQuestionsInput;
import com.uhutu.sportcenter.z.input.ApiNewQuestionsInput;
import com.uhutu.sportcenter.z.input.ApiQuestionDetailInput;
import com.uhutu.sportcenter.z.input.ApiQuestionInfoListInput;
import com.uhutu.sportcenter.z.input.ApiRichAnswersInput;
import com.uhutu.sportcenter.z.input.ApiUpdateAnswerUserInput;
import com.uhutu.sportcenter.z.result.ApiAnswerUserInfoResult;
import com.uhutu.sportcenter.z.result.ApiForAnswerQuestionResult;
import com.uhutu.sportcenter.z.result.ApiForAskQuestionResult;
import com.uhutu.sportcenter.z.result.ApiHotQuestionsResult;
import com.uhutu.sportcenter.z.result.ApiNewQuestionsResult;
import com.uhutu.sportcenter.z.result.ApiQuestionDetailResult;
import com.uhutu.sportcenter.z.result.ApiQuestionInfoListResult;
import com.uhutu.sportcenter.z.result.ApiRichAnswersResult;
import com.uhutu.sportcenter.z.result.ApiUpdateAnswerUserResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 问答相关接口
 * 
 * @author 逄小帅
 *
 */
@RestController
@RequestMapping(value = "/api/answerController")
@Api(tags = "问答相关接口")
public class AnswerController {

	@Autowired
	private ApiFactory apiFactory;

	@ResponseBody
	@RequestMapping(value = "/answerUserInfo", method = RequestMethod.POST)
	@ApiOperation(value = "问答用户信息", notes = "问答相关")
	public ApiAnswerUserInfoResult answerUserInfo(@RequestBody ApiAnswerUserInfoInput input) {

		return apiFactory.getApiAnswerUserInfo().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
	@ApiOperation(value = "更新问答用户信息", notes = "问答相关")
	public ApiUpdateAnswerUserResult updateUserInfo(@RequestBody ApiUpdateAnswerUserInput input) {

		return apiFactory.getApiUpdateAnswerUser().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/saveQuestion", method = RequestMethod.POST)
	@ApiOperation(value = "提问", notes = "保存提问的问题")
	public ApiForAskQuestionResult saveQuestion(@RequestBody ApiForAskQuestionInput input) {

		return apiFactory.getApiForAskQuestion().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/answerQuestion", method = RequestMethod.POST)
	@ApiOperation(value = "回答问题", notes = "回答提出的问题")
	public ApiForAnswerQuestionResult answerQuestion(@RequestBody ApiForAnswerQuestionInput input) {

		return apiFactory.getApiForAnswerQuestion().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/richAnswers", method = RequestMethod.POST)
	@ApiOperation(value = "才华排行", notes = "才华排行")
	public ApiRichAnswersResult richAnswers(@RequestBody ApiRichAnswersInput input) {

		return apiFactory.getApiRichAnswers().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/hotQuestions", method = RequestMethod.POST)
	@ApiOperation(value = "热门问题", notes = "热门问题")
	public ApiHotQuestionsResult hotQuestions(@RequestBody ApiHotQuestionsInput input) {

		return apiFactory.getApiHotQuestions().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/newQuestions", method = RequestMethod.POST)
	@ApiOperation(value = "最新问题", notes = "最新问题")
	public ApiNewQuestionsResult newQuestions(@RequestBody ApiNewQuestionsInput input) {

		return apiFactory.getApiNewQuestions().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/questionDetail", method = RequestMethod.POST)
	@ApiOperation(value = "问题详情", notes = "问题详情")
	public ApiQuestionDetailResult questionDetail(@RequestBody ApiQuestionDetailInput input) {

		return apiFactory.getApiQuestionDetail().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/myQuestions", method = RequestMethod.POST)
	@ApiOperation(value = "个人中心我问", notes = "问答相关")
	public ApiQuestionInfoListResult myQuestions(@RequestBody ApiQuestionInfoListInput input) {

		return apiFactory.getApiQuestionInfoList().api(input);
	}
	
}
