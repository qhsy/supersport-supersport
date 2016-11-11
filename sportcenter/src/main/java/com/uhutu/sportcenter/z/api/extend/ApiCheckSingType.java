package com.uhutu.sportcenter.z.api.extend;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.entity.UcSignPrice;
import com.uhutu.sportcenter.z.input.ApiCheckSingTypeInput;
import com.uhutu.sportcenter.z.result.ApiCheckSingTypeResult;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 校验报名类型
 * 
 * @author xiegj
 */
@Service
public class ApiCheckSingType extends RootApiToken<ApiCheckSingTypeInput, ApiCheckSingTypeResult> {

	protected ApiCheckSingTypeResult process(ApiCheckSingTypeInput input) {
		ApiCheckSingTypeResult result = new ApiCheckSingTypeResult();
		List<UcSignPrice> prices = JdbcHelper.queryForList(UcSignPrice.class, "", "",
				" type not in (select type from uc_sign_info where status=:status and userCode=:userCode ) ",
				MapHelper.initMap("userCode", upUserCode(), "status", "dzsd4112100110030002"));
		if (prices != null && prices.size() > 0) {
			result.setList(prices);
		}
		return result;
	}

}
