package com.uhutu.sportcenter.z.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.APiStartPageInput;
import com.uhutu.sportcenter.z.input.ApiAttendListInput;
import com.uhutu.sportcenter.z.input.ApiFansListInput;
import com.uhutu.sportcenter.z.input.ApiFavorContentListInput;
import com.uhutu.sportcenter.z.input.ApiForAttentionInput;
import com.uhutu.sportcenter.z.input.ApiForLoginInput;
import com.uhutu.sportcenter.z.input.ApiForTecentSigInput;
import com.uhutu.sportcenter.z.input.ApiLoginOutInput;
import com.uhutu.sportcenter.z.input.ApiMsgFocusInput;
import com.uhutu.sportcenter.z.input.ApiOwnSportMomentInput;
import com.uhutu.sportcenter.z.input.ApiRecommendExpertInput;
import com.uhutu.sportcenter.z.input.ApiSendSmsInput;
import com.uhutu.sportcenter.z.input.ApiSetUserFavoerInput;
import com.uhutu.sportcenter.z.input.ApiShareContentInput;
import com.uhutu.sportcenter.z.input.ApiSocialLoginInput;
import com.uhutu.sportcenter.z.input.ApiSocialLoginInput2;
import com.uhutu.sportcenter.z.input.ApiUpdateUserInfoInput;
import com.uhutu.sportcenter.z.input.ApiUserInfoAllInput;
import com.uhutu.sportcenter.z.input.ApiUserInfoInput;
import com.uhutu.sportcenter.z.input.ApiUserRegInput;
import com.uhutu.sportcenter.z.input.ApiUserResetPwdInput;
import com.uhutu.sportcenter.z.input.ApiVerifyNickNameInput;
import com.uhutu.sportcenter.z.input.ApiVersionInfoInput;
import com.uhutu.sportcenter.z.result.APiStartPageResult;
import com.uhutu.sportcenter.z.result.ApiAttendListResult;
import com.uhutu.sportcenter.z.result.ApiFansListResult;
import com.uhutu.sportcenter.z.result.ApiFavorContentListResult;
import com.uhutu.sportcenter.z.result.ApiForAttentionResult;
import com.uhutu.sportcenter.z.result.ApiForLoginResult;
import com.uhutu.sportcenter.z.result.ApiForTecentSigResult;
import com.uhutu.sportcenter.z.result.ApiLoginOutResult;
import com.uhutu.sportcenter.z.result.ApiMsgFocusResult;
import com.uhutu.sportcenter.z.result.ApiOwnSportMomentResult;
import com.uhutu.sportcenter.z.result.ApiRecommendExpertResult;
import com.uhutu.sportcenter.z.result.ApiSendSmsResult;
import com.uhutu.sportcenter.z.result.ApiSetUserFavorResult;
import com.uhutu.sportcenter.z.result.ApiShareContentResult;
import com.uhutu.sportcenter.z.result.ApiSocialLoginResult;
import com.uhutu.sportcenter.z.result.ApiSocialLoginResult2;
import com.uhutu.sportcenter.z.result.ApiUpdateUserInfoResult;
import com.uhutu.sportcenter.z.result.ApiUserInfoAllResult;
import com.uhutu.sportcenter.z.result.ApiUserInfoResult;
import com.uhutu.sportcenter.z.result.ApiUserRegResult;
import com.uhutu.sportcenter.z.result.ApiUserResetPwdResult;
import com.uhutu.sportcenter.z.result.ApiVerifyNickNameResult;
import com.uhutu.sportcenter.z.result.ApiVersionInfoResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户相关控制器
 * 
 * @author pang_jhui
 *
 */
@RestController
@RequestMapping(value = "/api/userController")
@Api(tags = "用户相关接口")
public class UserController {

	@Autowired
	private ApiFactory apiFactory;

	@ResponseBody
	@RequestMapping(value = "/versionInfo", method = RequestMethod.POST)
	@ApiOperation(value = "app版本升级提示接口", notes = "版本升级")
	public ApiVersionInfoResult versionInfo(@RequestBody ApiVersionInfoInput input) {
		
		return apiFactory.getApiVersionInfo().api(input);
	
	}

	@ResponseBody
	@RequestMapping(value = "/userRegister", method = RequestMethod.POST)
	@ApiOperation(value = "用户注册接口", notes = "用户注册")
	public ApiUserRegResult userRegister(@RequestBody ApiUserRegInput input) {

		return apiFactory.getApiUserRegister().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/startPage", method = RequestMethod.POST)
	@ApiOperation(value = "启动页接口", notes = "app启动页")
	public APiStartPageResult startPage(@RequestBody APiStartPageInput input) {

		return apiFactory.getApiStartPage().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/socialLogin", method = RequestMethod.POST)
	@ApiOperation(value = "社交类app登录", notes = "用户登录")
	public ApiSocialLoginResult socialLogin(@RequestBody ApiSocialLoginInput input) {

		return apiFactory.getApiSocialLogin().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/socialLogin2", method = RequestMethod.POST)
	@ApiOperation(value = "社交类app登录2", notes = "用户登录2")
	public ApiSocialLoginResult2 socialLogin2(@RequestBody ApiSocialLoginInput2 input) {

		return apiFactory.getApiSocialLogin2().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/sendSms", method = RequestMethod.POST)
	@ApiOperation(value = "短信发送接口", notes = "用户登录")
	public ApiSendSmsResult sendSms(@RequestBody ApiSendSmsInput input) {

		return apiFactory.getApiSendSms().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/loginOut", method = RequestMethod.POST)
	@ApiOperation(value = "用户退出接口", notes = "用户相关")
	public ApiLoginOutResult loginOut(@RequestBody ApiLoginOutInput input) {

		return apiFactory.getApiLoginOut().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ApiOperation(value = "用户登录接口", notes = "用户相关")
	public ApiForLoginResult login(@RequestBody ApiForLoginInput input) {

		return apiFactory.getApiForLogin().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/tecentSig", method = RequestMethod.POST)
	@ApiOperation(value = "用户获取腾讯云sig信息", notes = "用户相关")
	public ApiForTecentSigResult login(@RequestBody ApiForTecentSigInput input) {

		return apiFactory.getApiForTecentSig().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/userInfo", method = RequestMethod.POST)
	@ApiOperation(value = "用户信息接口", notes = "用户相关")
	public ApiUserInfoResult userInfo(@RequestBody ApiUserInfoInput infoInput) {

		return apiFactory.getApiUserInfo().api(infoInput);
	}

	@ResponseBody
	@RequestMapping(value = "/resetPwd", method = RequestMethod.POST)
	@ApiOperation(value = "用户重置密码", notes = "用户相关")
	public ApiUserResetPwdResult resetPwd(@RequestBody ApiUserResetPwdInput input) {

		return apiFactory.getApiUserResetPwd().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/setUserFavor", method = RequestMethod.POST)
	@ApiOperation(value = "设置用户喜欢", notes = "用户相关")
	public ApiSetUserFavorResult setUserFavor(@RequestBody ApiSetUserFavoerInput input) {

		return apiFactory.getApiSetUserFavor().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/userAttention", method = RequestMethod.POST)
	@ApiOperation(value = "关注它人", notes = "关注它人信息")
	public ApiForAttentionResult contentRecomm(@RequestBody ApiForAttentionInput input) {

		return apiFactory.getApiForAttention().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
	@ApiOperation(value = "用户信息更新", notes = "用户相关")
	public ApiUpdateUserInfoResult updateUserInfo(@RequestBody ApiUpdateUserInfoInput input) {

		return apiFactory.getApiUpdateUserInfo().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/shareContent", method = RequestMethod.POST)
	@ApiOperation(value = "分享内容", notes = "用户相关")
	public ApiShareContentResult shareContent(@RequestBody ApiShareContentInput input) {

		return apiFactory.getApiShareContent().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/attendList", method = RequestMethod.POST)
	@ApiOperation(value = "关注列表", notes = "用户相关")
	public ApiAttendListResult shareContent(@RequestBody ApiAttendListInput input) {

		return apiFactory.getApiAttendList().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/fansList", method = RequestMethod.POST)
	@ApiOperation(value = "粉丝列表", notes = "用户相关")
	public ApiFansListResult shareContent(@RequestBody ApiFansListInput input) {

		return apiFactory.getApiFansList().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/favorContentList", method = RequestMethod.POST)
	@ApiOperation(value = "用户喜欢的内容列表", notes = "用户相关")
	public ApiFavorContentListResult favorContentList(@RequestBody ApiFavorContentListInput input) {

		return apiFactory.getApiFavorContentList().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/verifyNickName", method = RequestMethod.POST)
	@ApiOperation(value = "昵称校验", notes = "用户相关")
	public ApiVerifyNickNameResult verifyNickName(@RequestBody ApiVerifyNickNameInput input) {

		return apiFactory.getApiVerifyNickName().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/recommendExpert", method = RequestMethod.POST)
	@ApiOperation(value = "达人推荐", notes = "达人推荐")
	public ApiRecommendExpertResult recommendExpert(@RequestBody ApiRecommendExpertInput input) {

		return apiFactory.getApiRecommendExpert().api(input);

	}
	
	@ResponseBody
	@RequestMapping(value = "/allUserInfo", method = RequestMethod.POST)
	@ApiOperation(value = "全部用户信息", notes = "全部的用户信息")
	public ApiUserInfoAllResult allUserInfo(@RequestBody ApiUserInfoAllInput input) {

		return apiFactory.getApiUserInfoAll().api(input);

	}
	
	@ResponseBody
	@RequestMapping(value = "/ownSportMoment", method = RequestMethod.POST)
	@ApiOperation(value = "我发布的运动时刻", notes = "我发布的运动时刻")
	public ApiOwnSportMomentResult ownSportMoment(@RequestBody ApiOwnSportMomentInput input) {

		return apiFactory.getApiOwnSportMoment().api(input);

	}	
	
	@ResponseBody
	@RequestMapping(value = "/msgFocus", method = RequestMethod.POST)
	@ApiOperation(value = "不再关注", notes = "不再关注")
	public ApiMsgFocusResult msgFocus(@RequestBody ApiMsgFocusInput input) {

		return apiFactory.getApiMsgFocus().api(input);

	}


}
