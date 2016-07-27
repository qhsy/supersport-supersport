package com.uhutu.sportcenter.z.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiAnswerAttendListInput;
import com.uhutu.sportcenter.z.input.ApiAnswerInfoListInput;
import com.uhutu.sportcenter.z.input.ApiAnswerListenListInput;
import com.uhutu.sportcenter.z.input.ApiAnswerQuestionDetailInput;
import com.uhutu.sportcenter.z.input.ApiAnswerUserInfoInput;
import com.uhutu.sportcenter.z.input.ApiAppPersonHomeInput;
import com.uhutu.sportcenter.z.input.ApiAppUpdateAnswerUserInput;
import com.uhutu.sportcenter.z.input.ApiAskQuestionInput;
import com.uhutu.sportcenter.z.input.ApiAskWechatMsgInput;
import com.uhutu.sportcenter.z.input.ApiBindSettleAccountInput;
import com.uhutu.sportcenter.z.input.ApiForAnswerQuestionInput;
import com.uhutu.sportcenter.z.input.ApiForAskQuestionInput;
import com.uhutu.sportcenter.z.input.ApiHotQuestionsInput;
import com.uhutu.sportcenter.z.input.ApiNewQuestionsInput;
import com.uhutu.sportcenter.z.input.ApiOpenAskQuestionInput;
import com.uhutu.sportcenter.z.input.ApiPersonHomeInput;
import com.uhutu.sportcenter.z.input.ApiPlayAudioInput;
import com.uhutu.sportcenter.z.input.ApiQuestionDetailInput;
import com.uhutu.sportcenter.z.input.ApiQuestionInfoListInput;
import com.uhutu.sportcenter.z.input.ApiQuestionPraiseInput;
import com.uhutu.sportcenter.z.input.ApiRichAnswersInput;
import com.uhutu.sportcenter.z.input.ApiSaveWechatVoiceInput;
import com.uhutu.sportcenter.z.input.ApiUpdateAnswerUserInput;
import com.uhutu.sportcenter.z.input.ApiUpdateUserTitleInput;
import com.uhutu.sportcenter.z.result.ApiAnswerAttendListResult;
import com.uhutu.sportcenter.z.result.ApiAnswerInfoListResult;
import com.uhutu.sportcenter.z.result.ApiAnswerListenListResult;
import com.uhutu.sportcenter.z.result.ApiAnswerQuestionDetailResult;
import com.uhutu.sportcenter.z.result.ApiAnswerUserInfoResult;
import com.uhutu.sportcenter.z.result.ApiAppPersonHomeResult;
import com.uhutu.sportcenter.z.result.ApiAppUpdateAnswerUserResult;
import com.uhutu.sportcenter.z.result.ApiAskQuestionResult;
import com.uhutu.sportcenter.z.result.ApiAskWechatMsgResult;
import com.uhutu.sportcenter.z.result.ApiBindSettleAccountResult;
import com.uhutu.sportcenter.z.result.ApiForAnswerQuestionResult;
import com.uhutu.sportcenter.z.result.ApiForAskQuestionResult;
import com.uhutu.sportcenter.z.result.ApiHotQuestionsResult;
import com.uhutu.sportcenter.z.result.ApiNewQuestionsResult;
import com.uhutu.sportcenter.z.result.ApiOpenAskQuestionResult;
import com.uhutu.sportcenter.z.result.ApiPersonHomeResult;
import com.uhutu.sportcenter.z.result.ApiPlayAudioResult;
import com.uhutu.sportcenter.z.result.ApiQuestionDetailResult;
import com.uhutu.sportcenter.z.result.ApiQuestionInfoListResult;
import com.uhutu.sportcenter.z.result.ApiRichAnswersResult;
import com.uhutu.sportcenter.z.result.ApiSaveWechatVoiceResult;
import com.uhutu.sportcenter.z.result.ApiSupportPraiseResult;
import com.uhutu.sportcenter.z.result.ApiUpdateAnswerUserResult;
import com.uhutu.sportcenter.z.result.ApiUpdateUserTitleResult;

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
	@RequestMapping(value = "/updateUserInfoApp", method = RequestMethod.POST)
	@ApiOperation(value = "更新问答用户信息app", notes = "更新问答用户信息app")
	public ApiAppUpdateAnswerUserResult updateUserInfoApp(@RequestBody ApiAppUpdateAnswerUserInput input) {

		return apiFactory.getApiAppUpdateAnswerUser().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/saveQuestion", method = RequestMethod.POST)
	@ApiOperation(value = "提问", notes = "保存提问的问题")
	public ApiForAskQuestionResult saveQuestion(@RequestBody ApiForAskQuestionInput input,HttpServletRequest request) {
		String[] paths = request.getRequestURL().toString().split("/");
		String path = paths[0]+"//"+paths[2];
		input.setServeIP(path);
		input.setRomoteIP(request.getRemoteAddr());
		return apiFactory.getApiForAskQuestion().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/answerQuestion", method = RequestMethod.POST)
	@ApiOperation(value = "回答问题", notes = "回答提出的问题")
	public ApiForAnswerQuestionResult answerQuestion(@RequestBody ApiForAnswerQuestionInput input,HttpServletRequest request) {
		String[] paths = request.getRequestURL().toString().split("/");
		String path = paths[0]+"//"+paths[2];
		input.setRequestUrl(path);
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

	@ResponseBody
	@RequestMapping(value = "/myAnswers", method = RequestMethod.POST)
	@ApiOperation(value = "个人中心答", notes = "问答相关")
	public ApiAnswerInfoListResult myAnswers(@RequestBody ApiAnswerInfoListInput input) {

		return apiFactory.getApiAnswerInfoList().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/myListens", method = RequestMethod.POST)
	@ApiOperation(value = "个人中心我听", notes = "问答相关")
	public ApiAnswerListenListResult myListens(@RequestBody ApiAnswerListenListInput input) {

		return apiFactory.getApiAnswerListenList().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/saveWechatVoice", method = RequestMethod.POST)
	@ApiOperation(value = "获取微信服务器上录制的语音", notes = "获取微信服务器上录制的语音")
	public ApiSaveWechatVoiceResult saveWechatVoice(@RequestBody ApiSaveWechatVoiceInput input) {

		return apiFactory.getApiSaveWechatVoice().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/askQuestion", method = RequestMethod.POST)
	@ApiOperation(value = "提问时所需要的个人信息", notes = "提问时所需要的个人信息")
	public ApiAskQuestionResult askQuestion(@RequestBody ApiAskQuestionInput input) {

		return apiFactory.getApiAskQuestion().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/openAskQuestion", method = RequestMethod.POST)
	@ApiOperation(value = "开通问达", notes = "开通问达")
	public ApiOpenAskQuestionResult openAskQuestion(@RequestBody ApiOpenAskQuestionInput input) {

		return apiFactory.getApiOpenAskQuestion().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/answerQuestionDetail", method = RequestMethod.POST)
	@ApiOperation(value = "回答问题时所需要的展示信息", notes = "回答问题时所需要的展示信息")
	public ApiAnswerQuestionDetailResult answerQuestionDetail(@RequestBody ApiAnswerQuestionDetailInput input) {

		return apiFactory.getAnswerQuestionDetail().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/personHomePage", method = RequestMethod.POST)
	@ApiOperation(value = "个人主页信息", notes = "个人主页信息")
	public ApiPersonHomeResult personHomePage(@RequestBody ApiPersonHomeInput input) {

		return apiFactory.getApiPersonHome().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/appPersonHome", method = RequestMethod.POST)
	@ApiOperation(value = "app个人主页信息", notes = "app个人主页信息")
	public ApiAppPersonHomeResult appPersonHome(@RequestBody ApiAppPersonHomeInput input) {

		return apiFactory.getApiAppPersonHome().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/questionPraise", method = RequestMethod.POST)
	@ApiOperation(value = "问达点赞", notes = "问达点赞")
	public ApiSupportPraiseResult personHomePage(@RequestBody ApiQuestionPraiseInput input) {

		return apiFactory.getApiQuestionPraise().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/playAudio", method = RequestMethod.POST)
	@ApiOperation(value = "语音播放", notes = "语音播放")
	public ApiPlayAudioResult playAudio(@RequestBody ApiPlayAudioInput input) {

		return apiFactory.getApiPlayAudio().api(input);
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/sendAskWxMsg", method = RequestMethod.POST)
	@ApiOperation(value = "提问时微信消息", notes = "提问时微信消息提醒")
	public ApiAskWechatMsgResult sendAskWxMsg(@RequestBody ApiAskWechatMsgInput input,HttpServletRequest request) {

		String[] paths = request.getRequestURL().toString().split("/");
		String path = paths[0]+"//"+paths[2];
		input.setRequestUrl(path);
		return apiFactory.getApiAskWechatMsg().api(input);
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/attendList", method = RequestMethod.POST)
	@ApiOperation(value = "关注列表", notes = "关注列表")
	public ApiAnswerAttendListResult attendList(@RequestBody ApiAnswerAttendListInput input) {

		return apiFactory.getApiAnswerAttendList().api(input);
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateUserTile", method = RequestMethod.POST)
	@ApiOperation(value = "更新用户头衔", notes = "更新用户头衔")
	public ApiUpdateUserTitleResult updateUserTile(@RequestBody ApiUpdateUserTitleInput input) {

		return apiFactory.getApiUpdateUserTitle().api(input);
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/bindSettleAccount", method = RequestMethod.POST)
	@ApiOperation(value = "绑定结算账户", notes = "绑定结算账户")
	public ApiBindSettleAccountResult bindSettleAccount(@RequestBody ApiBindSettleAccountInput input) {

		return apiFactory.getApiBindSettleAccount().api(input);
		
	}
	
	
}
