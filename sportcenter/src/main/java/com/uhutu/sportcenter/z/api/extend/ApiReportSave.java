package com.uhutu.sportcenter.z.api.extend;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.extend.z.entity.ReReportField;
import com.uhutu.dcom.extend.z.entity.ReReportInfo;
import com.uhutu.dcom.extend.z.entity.ReReportJson;
import com.uhutu.dcom.extend.z.entity.ReReportLimit;
import com.uhutu.dcom.order.enumer.ETeslaExec;
import com.uhutu.dcom.order.orderResult.TeslaXOrder;
import com.uhutu.dcom.order.orderResult.TeslaXResult;
import com.uhutu.dcom.order.service.ApiConvertTeslaService;
import com.uhutu.dcom.order.z.entity.OcOrderDetail;
import com.uhutu.dcom.order.z.entity.OcOrderInfo;
import com.uhutu.dcom.user.z.tecent.helper.JsonHelper;
import com.uhutu.sportcenter.z.input.ApiReportSaveInput;
import com.uhutu.sportcenter.z.result.ApiReportSaveResult;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.helper.RegexHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.WebHelper;

/**
 * Report报表信息保存
 * 
 * @author xiegj
 */
@Service
public class ApiReportSave extends RootApiToken<ApiReportSaveInput, ApiReportSaveResult> {

	protected ApiReportSaveResult process(ApiReportSaveInput input) {
		ApiReportSaveResult result = new ApiReportSaveResult();
		if (StringUtils.isNotBlank(input.getReportCode())) {
			RootApiResult sr = saveReport(input.getReportCode(), input.getMap());
			if (sr.upFlagTrue()) {
				TeslaXResult so = saveOrder(sr.getError().split("&")[0], sr.getError().split("&")[1],
						input.getOrderSource());
				if (so.upFlagTrue()) {
					result.setOrderCode(so.getError());
				} else {
					result.setStatus(so.getStatus());
					result.setError(so.getError());
				}
			} else {
				result.setStatus(sr.getStatus());
				result.setError(sr.getError());
			}
		} else {
			result.setStatus(0);
			result.setError("编号不能为空");
		}
		return result;
	}

	/**
	 * 
	 * @param reportCode
	 *            报名活动编号
	 * @param map
	 *            参数及值
	 * @return
	 */
	private RootApiResult saveReport(String reportCode, MDataMap map) {
		RootApiResult result = new RootApiResult();
		ReReportInfo info = JdbcHelper.queryOne(ReReportInfo.class, "code", reportCode, "status", "1");
		List<ReReportField> fields = JdbcHelper.queryForList(ReReportField.class, "", " show_sort desc ", "code=:code ",
				MapHelper.initMap("code", reportCode));
		Map<String, ReReportField> fieldsMap = new HashMap<String, ReReportField>();
		if (info != null) {
			// 校验必输项不能为空的问题
			if (fields != null && fields.size() > 0) {
				for (int i = 0; i < fields.size(); i++) {
					ReReportField fd = fields.get(i);
					if (fd.getFieldId().contains("submitone")) {
						continue;
					}
					fieldsMap.put(fd.getFieldId(), fd);
					if ("1".equals(fd.getRequireAble()) && StringUtils.isBlank(map.get(fd.getFieldId()))) {
						result.setStatus(0);
						result.setError("<" + fd.getFieldLabel() + ">值不能为空");
						break;
					}

					if (StringUtils.isNotBlank(fd.getCheckVerify())
							&& !RegexHelper.checkRegexField(map.get(fd.getFieldId()), fd.getCheckVerify())) {
						result.inError(86991103, fd.getFieldLabel());
						break;
					}
				}
			}
			// 校验限制规则
			if (result.upFlagTrue()) {
				ReReportLimit limit = JdbcHelper.queryOne(ReReportLimit.class, "code", reportCode);
				if (limit != null) {
					int count = JdbcHelper.count(ReReportJson.class, "code=:code and status=:status",
							MapHelper.initMap("code", reportCode, "status", "1"));
					if (count >= Integer.valueOf(limit.getFieldLimit())) {
						result.setStatus(0);
						result.setError("已报满");
					}
				}
			}
			// 校验数据是否符合校验规则
			if (result.upFlagTrue()) {
				ReReportJson reJson = new ReReportJson();
				reJson.setCode(reportCode);
				reJson.setCreateTime(DateHelper.upNow());
				reJson.setSignCode(WebHelper.upCode("REJGBH"));
				reJson.setStatus("0");
				reJson.setJson(new JsonHelper<MDataMap>().ObjToString(map));
				result.setError(reJson.getSignCode() + "&" + info.getOrderMoney().toString());
				JdbcHelper.insert(reJson);
			}
		} else {
			result.setStatus(0);
			result.setError("活动已结束,请联系果冻体育进行了解~");
		}
		return result;
	}

	/**
	 * 
	 * @param productCode
	 *            商品编号（多个商品 以逗号隔开）
	 * @param productPrice
	 *            商品单价
	 * @return
	 */
	private TeslaXResult saveOrder(String productCode, String productPrice, String orderSource) {
		TeslaXOrder teslaXOrder = new TeslaXOrder();
		OcOrderInfo info = new OcOrderInfo();
		info.setBuyerCode(upUserCode());
		info.setOrderSource(orderSource);
		info.setOrderType("dzsd4112100110010006");
		info.setPayType("dzsd4112100110040002");
		String[] pcs = productCode.split(",");
		for (int i = 0; i < pcs.length; i++) {
			OcOrderDetail detail = new OcOrderDetail();
			detail.setNum(1);
			detail.setProductCode(pcs[i]);
			detail.setProductPrice(BigDecimal.valueOf(Double.valueOf(productPrice)));
			teslaXOrder.getDetail().add(detail);
		}
		info.setSellerCode("系统");
		teslaXOrder.setOrderInfo(info);
		teslaXOrder.getStatus().setExecStep(ETeslaExec.Create);
		TeslaXResult reTeslaXResult = new ApiConvertTeslaService().ConvertOrder(teslaXOrder);
		if (reTeslaXResult.upFlagTrue()) {
			reTeslaXResult.setError(teslaXOrder.getOrderInfo().getCode());
		}
		return reTeslaXResult;
	}

}
