package com.uhutu.sportcenter.z.api.extend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.extend.z.entity.ReFieldType;
import com.uhutu.dcom.extend.z.entity.ReReportField;
import com.uhutu.dcom.extend.z.entity.ReReportInfo;
import com.uhutu.sportcenter.z.entity.ReReportFieldForApi;
import com.uhutu.sportcenter.z.input.ApiReportFieldsInput;
import com.uhutu.sportcenter.z.result.ApiReportFieldsResult;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * Report报表详情接口
 * 
 * @author xiegj
 */
@Service
public class ApiReportFields extends RootApiBase<ApiReportFieldsInput, ApiReportFieldsResult> {

	public static final String FORMOUT = "input,date,select,upload,checkbox";

	protected ApiReportFieldsResult process(ApiReportFieldsInput input) {
		ApiReportFieldsResult result = new ApiReportFieldsResult();
		Map<String, ReFieldType> typeMap = getType();
		if (StringUtils.isNotBlank(input.getCode())) {
			ReReportInfo info = JdbcHelper.queryOne(ReReportInfo.class, "code", input.getCode(), "status", "1");
			if (info != null) {
				result.setFs(info);
				List<ReReportField> fields = JdbcHelper.queryForList(ReReportField.class, "", " show_sort desc ",
						" code=:code ", MapHelper.initMap("code", info.getCode()));
				if (fields != null && fields.size() > 0) {
					for (int i = 0; i < fields.size(); i++) {
						ReReportFieldForApi fieldForApi = new ReReportFieldForApi();
						ReReportField field = fields.get(i);
						BeanUtils.copyProperties(field, fieldForApi);
						if (FORMOUT.contains(typeMap.get(fieldForApi.getFieldType()).getName())) {
							fieldForApi.setType(typeMap.get(fieldForApi.getFieldType()));
							result.getFields().add(fieldForApi);
						} else {
							fieldForApi.setType(typeMap.get(fieldForApi.getFieldType()));
							result.getButtons().add(fieldForApi);
						}
					}
				}
			}
		}

		return result;
	}

	private Map<String, ReFieldType> getType() {
		Map<String, ReFieldType> result = new HashMap<String, ReFieldType>();
		List<ReFieldType> li = JdbcHelper.queryForList(ReFieldType.class, "", "", "", null);
		if (li != null && li.size() > 0) {
			for (int i = 0; i < li.size(); i++) {
				ReFieldType type = li.get(i);
				result.put(type.getCode(), type);
			}
		}
		return result;
	}
}
