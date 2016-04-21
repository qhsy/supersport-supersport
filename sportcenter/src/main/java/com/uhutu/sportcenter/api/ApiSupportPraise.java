package com.uhutu.sportcenter.api;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.config.enums.PrexEnum;
import com.uhutu.dcom.content.entity.CnSupportPraise;
import com.uhutu.dcom.content.service.SupportPraiseServiceFactory;
import com.uhutu.sportcenter.api.input.ApiSupportPraiseInput;
import com.uhutu.sportcenter.api.result.ApiSupportPraiseResult;
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
		praise.setCode(DateFormatUtils.format(new Date(), PrexEnum.CNE.toString()));
		praise.setContentCode(input.getContentCode());
		praise.setType(input.getType());
		praise.setUserCode("userCode_xiegj");// 暂时没有
		if (input.isCancelFlag()) {// 取消点赞或者取消点嘘嘘
			serviceFactory.getSupportPraiseService().deleteByContentCodeAndUserCode(input.getContentCode(),
					"userCode_xiegj", input.getType());
		} else {// 点赞或者点嘘嘘
			serviceFactory.getSupportPraiseService().save(praise);
		}

		return new ApiSupportPraiseResult();
	}

}
