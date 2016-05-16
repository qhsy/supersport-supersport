package com.uhutu.sportcenter.z.api.content;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.config.enums.PrexEnum;
import com.uhutu.dcom.content.z.entity.CnSupportPraise;
import com.uhutu.dcom.content.z.service.SupportPraiseServiceFactory;
import com.uhutu.sportcenter.z.input.ApiSupportPraiseInput;
import com.uhutu.sportcenter.z.result.ApiSupportPraiseResult;
import com.uhutu.zoocom.root.RootApiToken;

/***
 * 赞与嘘嘘接口
 * 
 * @author xiegj
 *
 */
@Service
public class ApiSupportPraise extends RootApiToken<ApiSupportPraiseInput, ApiSupportPraiseResult> {

	@Autowired
	private SupportPraiseServiceFactory serviceFactory;

	protected ApiSupportPraiseResult process(ApiSupportPraiseInput input) {
		CnSupportPraise praise = new CnSupportPraise();
		praise.setCode(PrexEnum.CNE.toString() + DateFormatUtils.format(new Date(), "yyyyMMddhhmmssSSS"));
		praise.setContentCode(input.getContentCode());
		praise.setType(input.getType());
		praise.setUserCode(input.getZoo().getToken().trim());// 暂时没有
		if ("0".equals(input.getIsLike())) {// 取消点赞或者取消点嘘嘘
			serviceFactory.getSupportPraiseService().cancelbyCCAndUCAndType(input.getContentCode(), "userCode_xiegj",
					input.getType());
		} else {// 点赞或者点嘘嘘
			serviceFactory.getSupportPraiseService().save(praise);
		}

		return new ApiSupportPraiseResult();
	}

}
