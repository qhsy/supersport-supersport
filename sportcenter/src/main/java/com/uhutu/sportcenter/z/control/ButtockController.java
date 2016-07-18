package com.uhutu.sportcenter.z.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiButtockLapListInput;
import com.uhutu.sportcenter.z.input.ApiButtockNotesInput;
import com.uhutu.sportcenter.z.input.ApiButtockPowerListInput;
import com.uhutu.sportcenter.z.result.ApiButtockLapListResult;
import com.uhutu.sportcenter.z.result.ApiButtockNotesResult;
import com.uhutu.sportcenter.z.result.ApiButtockPowerListResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 翘臀大赛相关接口
 * 
 * @author 逄小帅
 *
 */
@RestController
@RequestMapping(value = "/api/buttock")
@Api(tags = "翘臀大赛相关接口")
public class ButtockController {

	@Autowired
	private ApiFactory apiFactory;

	@ResponseBody
	@RequestMapping(value = "/buttockPowerList", method = RequestMethod.POST)
	@ApiOperation(value = "实力派", notes = "翘臀大赛-实力派")
	public ApiButtockPowerListResult buttockPowerList(@RequestBody ApiButtockPowerListInput input) {

		return apiFactory.getApiButtockPowerList().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/buttockLapList", method = RequestMethod.POST)
	@ApiOperation(value = "翘丽圈", notes = "翘臀大赛-翘丽圈")
	public ApiButtockLapListResult buttockLapList(@RequestBody ApiButtockLapListInput input) {

		return apiFactory.getApiButtockLapList().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/buttockNotes", method = RequestMethod.POST)
	@ApiOperation(value = "翘丽圈-活动须知", notes = "翘丽圈-活动须知")
	public ApiButtockNotesResult buttockNotes(@RequestBody ApiButtockNotesInput input) {

		return apiFactory.getApiButtockNotes().api(input);
	}

}
