package com.uhutu.sportcenter.z.api.content;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.entity.CnContentReadCount;
import com.uhutu.sportcenter.z.input.ApiContentReadCountInput;
import com.uhutu.sportcenter.z.result.ApiContentReadCountResult;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 阅读量
 * 
 * @author xiegj
 */
@Service
public class ApiContentReadCount extends RootApiBase<ApiContentReadCountInput, ApiContentReadCountResult> {

	protected ApiContentReadCountResult process(ApiContentReadCountInput input) {
		if (StringUtils.isNotBlank(input.getCode())) {
			CnContentReadCount count = JdbcHelper.queryOne(CnContentReadCount.class, "code", input.getCode());
			if (count != null) {
				count.setCount(count.getCount() + 1);
				JdbcHelper.update(count, "count", "za");
			} else {
				count = new CnContentReadCount();
				count.setCode(input.getCode());
				count.setCount(1);
				JdbcHelper.insert(count);
			}
		}
		return new ApiContentReadCountResult();
	}

}
