package com.uhutu.sportcenter.z.api.extend;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.extend.z.entity.ReReportInfo;
import com.uhutu.dcom.extend.z.entity.ReReportJson;
import com.uhutu.dcom.order.z.entity.OcOrderDetail;
import com.uhutu.dcom.order.z.entity.OcOrderInfo;
import com.uhutu.sportcenter.z.input.ApiReportShowInput;
import com.uhutu.sportcenter.z.result.ApiReportShowResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * Report报表信息展示
 * 
 * @author xiegj
 */
@Service
public class ApiReportShow extends RootApiToken<ApiReportShowInput, ApiReportShowResult> {

	protected ApiReportShowResult process(ApiReportShowInput input) {
		ApiReportShowResult result = new ApiReportShowResult();
		OcOrderInfo info = JdbcHelper.queryOne(OcOrderInfo.class, "code", input.getCode(), "buyer_code", upUserCode());
		OcOrderDetail detail = JdbcHelper.queryOne(OcOrderDetail.class, "code", input.getCode());
		if (detail != null) {
			ReReportJson json = JdbcHelper.queryOne(ReReportJson.class, "sign_code", detail.getProductCode());
			if (json != null) {
				ReReportInfo reportInfo = JdbcHelper.queryOne(ReReportInfo.class, "code", json.getCode());
				if (reportInfo != null) {
					result.setTitle(reportInfo.getTitle());
					Map<String, String> map = new HashMap<String, String>();
					map.put("支付单号", detail.getCode());
					map.put("支付金额", info.getOrderMoney().toString());
					result.setMap(map);
				}
			}
		} else {
			result.setStatus(0);
			result.setError("无此信息");
		}
		return result;
	}

}
