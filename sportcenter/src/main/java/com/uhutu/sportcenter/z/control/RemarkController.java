package com.uhutu.sportcenter.z.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiPublishRemarkInput;
import com.uhutu.sportcenter.z.result.ApiPublishRemarkResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 评论相关控制器
 * @author 逄小帅
 *
 */
@RestController
@RequestMapping(value = "/api/remarkController")
@Api(tags = "评论相关接口")
public class RemarkController {
	
	@Autowired
	private ApiFactory apiFactory;

	@ResponseBody
	@RequestMapping(value = "/publicRemark", method = RequestMethod.POST)
	@ApiOperation(value = "发布评论", notes = "发布评论")
	public ApiPublishRemarkResult publicRemark(@RequestBody ApiPublishRemarkInput input) {

		return apiFactory.getApiPublishRemark().api(input);
	}

}
