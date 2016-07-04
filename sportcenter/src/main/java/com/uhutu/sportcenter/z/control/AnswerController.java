package com.uhutu.sportcenter.z.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiAnswerUserInfoInput;
import com.uhutu.sportcenter.z.input.ApiForAskQuestionInput;
import com.uhutu.sportcenter.z.input.ApiUpdateAnswerUserInput;
import com.uhutu.sportcenter.z.result.ApiAnswerUserInfoResult;
import com.uhutu.sportcenter.z.result.ApiForAskQuestionResult;
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

}
