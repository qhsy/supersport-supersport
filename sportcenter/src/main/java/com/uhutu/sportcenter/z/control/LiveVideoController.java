package com.uhutu.sportcenter.z.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiChooseMatchInput;
import com.uhutu.sportcenter.z.input.ApiFriendsNearbyInput;
import com.uhutu.sportcenter.z.input.ApiLiveInfoInput;
import com.uhutu.sportcenter.z.input.ApiLiveSpecialEffectsInput;
import com.uhutu.sportcenter.z.result.ApiChooseMatchResult;
import com.uhutu.sportcenter.z.result.ApiFriendsNearbyResult;
import com.uhutu.sportcenter.z.result.ApiLiveInfoResult;
import com.uhutu.sportcenter.z.result.ApiLiveSpecialEffectsResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 直播相关接口
 * 
 * @author xiegj
 *
 */
@RestController
@RequestMapping(value = "/api/liveVideoController")
@Api(tags = "直播相关")
public class LiveVideoController {

	@Autowired
	private ApiFactory apiFactory;

	// @ResponseBody
	// @RequestMapping(value = "/liveCreateRoom", method = RequestMethod.POST)
	// @ApiOperation(value = "创建房间", notes = "创建房间")
	// public ApiLiveCreateRoomResult liveCreateRoom(@RequestBody
	// ApiLiveCreateRoomInput input,
	// HttpServletRequest request) {
	//
	// return apiFactory.getApiLiveCreateRoom().api(input);
	//
	// }
	//
	// @ResponseBody
	// @RequestMapping(value = "/liveVideoHeart", method = RequestMethod.POST)
	// @ApiOperation(value = "直播心跳", notes = "直播心跳")
	// public ApiLiveVideoHeartResult liveVideoHeart(@RequestBody
	// ApiLiveVideoHeartInput input,
	// HttpServletRequest request) {
	//
	// return apiFactory.getApiLiveVideoHeart().api(input);
	//
	// }
	//
	// @ResponseBody
	// @RequestMapping(value = "/finishLiveVideo", method = RequestMethod.POST)
	// @ApiOperation(value = "结束直播", notes = "结束直播")
	// public ApiFinishLiveVideoResult finishLiveVideo(@RequestBody
	// ApiFinishLiveVideoInput input,
	// HttpServletRequest request) {
	//
	// return apiFactory.getApiFinishLiveVideo().api(input);
	//
	// }
	//
	// @ResponseBody
	// @RequestMapping(value = "/liveViedos", method = RequestMethod.POST)
	// @ApiOperation(value = "直播视频列表", notes = "直播视频列表")
	// public ApiLiveInfoListResult liveViedos(@RequestBody ApiLiveInfoListInput
	// input, HttpServletRequest request) {
	//
	// return apiFactory.getApiLiveInfoList().api(input);
	//
	// }
	//
	// @ResponseBody
	// @RequestMapping(value = "/startLive", method = RequestMethod.POST)
	// @ApiOperation(value = "开始直播", notes = "开始直播")
	// public ApiStartLiveResult startLive(@RequestBody ApiStartLiveInput input,
	// HttpServletRequest request) {
	//
	// return apiFactory.getApiStartLive().api(input);
	//
	// }
	//
	// @ResponseBody
	// @RequestMapping(value = "/syncLiveUserInfo", method = RequestMethod.POST)
	// @ApiOperation(value = "同步直播用户信息", notes = "同步直播用户信息")
	// public ApiSyncLiveUserInfoResult syncLiveUserInfo(@RequestBody
	// ApiSyncLiveUserInfoInput input,
	// HttpServletRequest request) {
	//
	// return apiFactory.getApiSyncLiveUserInfo().api(input);
	//
	// }
	//
	// @ResponseBody
	// @RequestMapping(value = "/updateLiveStatus", method = RequestMethod.POST)
	// @ApiOperation(value = "更新直播状态", notes = "更新直播状态")
	// public ApiLiveNotifyResult updateLiveStatus(@RequestBody
	// ApiLiveNotifyInput input, HttpServletRequest request) {
	//
	// return apiFactory.getApiLiveNotify().api(input);
	//
	// }
	//
	// @ResponseBody
	// @RequestMapping(value = "/operLiveInfo", method = RequestMethod.POST)
	// @ApiOperation(value = "更新直播信息", notes = "更新直播信息")
	// public ApiOperLiveInfoResult operLiveInfo(@RequestBody
	// ApiOperLiveInfoInput input, HttpServletRequest request) {
	//
	// return apiFactory.getApiOperLiveInfo().api(input);
	//
	// }

	@ResponseBody
	@RequestMapping(value = "/liveInfo", method = RequestMethod.POST)
	@ApiOperation(value = "直播详细信息", notes = "直播详细信息")
	public ApiLiveInfoResult liveInfo(@RequestBody ApiLiveInfoInput input, HttpServletRequest request) {

		return apiFactory.getApiLiveInfo().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/chooseMatch", method = RequestMethod.POST)
	@ApiOperation(value = "选择队伍", notes = "直播选择比赛队伍信息")
	public ApiChooseMatchResult chooseMatch(@RequestBody ApiChooseMatchInput input, HttpServletRequest request) {
		return apiFactory.getApiChooseMatch().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/friendsNearby", method = RequestMethod.POST)
	@ApiOperation(value = "附近的人", notes = "附近的人")
	public ApiFriendsNearbyResult friendsNearby(@RequestBody ApiFriendsNearbyInput input, HttpServletRequest request) {
		return apiFactory.getApiFriendsNearby().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/liveSpecialEffects", method = RequestMethod.POST)
	@ApiOperation(value = "直播特效", notes = "直播特效")
	private ApiLiveSpecialEffectsResult liveSpecialEffects(@RequestBody ApiLiveSpecialEffectsInput input,
			HttpServletRequest request) {
		return apiFactory.getApiLiveSpecialEffects().api(input);
	}

	// @ResponseBody
	// @RequestMapping(value = "/liveMsg", method = RequestMethod.POST)
	// @ApiOperation(value = "直播所需信息", notes = "直播所需信息")
	// public ApiLiveMsgResult liveMsg(@RequestBody ApiLiveMsgInput input,
	// HttpServletRequest request) {
	//
	// return apiFactory.getApiLiveMsg().api(input);
	//
	// }
	//
	// @ResponseBody
	// @RequestMapping(value = "/liveGift", method = RequestMethod.POST)
	// @ApiOperation(value = "直播打赏", notes = "直播所需信息")
	// public ApiLiveGiftResult liveGift(@RequestBody ApiLiveGiftInput input,
	// HttpServletRequest request) {
	// String[] paths = request.getRequestURL().toString().split("/");
	// String path = paths[0] + "//" + paths[2];
	// input.setServeIP(path);
	// input.setRomoteIP(request.getRemoteAddr());
	// return apiFactory.getApiLiveGift().api(input);
	//
	// }

}
