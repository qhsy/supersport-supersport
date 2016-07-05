package com.uhutu.sportcenter.z.api.answer;

import java.util.Date;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.config.enums.PrexEnum;
import com.uhutu.dcom.content.z.entity.CnSupportPraise;
import com.uhutu.sportcenter.z.input.ApiSupportPraiseInput;
import com.uhutu.sportcenter.z.result.ApiSupportPraiseResult;
import com.uhutu.zoocom.root.RootApiToken;

/***
 * 问达信息赞的接口
 * 
 * @author xiegj
 *
 */
@Component
public class ApiQuestionPraise extends RootApiToken<ApiSupportPraiseInput, ApiSupportPraiseResult> {


	protected ApiSupportPraiseResult process(ApiSupportPraiseInput input) {
		CnSupportPraise praise = new CnSupportPraise();
//		praise.setCode(PrexEnum.CNE.toString() + DateFormatUtils.format(new Date(), "yyyyMMddhhmmssSSS"));
//		praise.setContentCode(input.getContentCode());
//		praise.setType(input.getType());
//		praise.setUserCode(upUserCode());
//		if ("0".equals(input.getIsLike())) {// 取消点赞或者取消点嘘嘘
//			serviceFactory.getSupportPraiseService().cancelbyCCAndUCAndType(input.getContentCode(), upUserCode(),
//					input.getType());
//		} else {// 点赞或者点嘘嘘
//			serviceFactory.getSupportPraiseService().save(praise);
//		}

		return new ApiSupportPraiseResult();
	}

}
