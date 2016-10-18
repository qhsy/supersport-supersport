package com.uhutu.sportcenter.z.api.content;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.tag.z.entity.CnPicPaster;
import com.uhutu.sportcenter.z.entity.PicPasterInfo;
import com.uhutu.sportcenter.z.input.ApiPicPasterListInput;
import com.uhutu.sportcenter.z.result.ApiPicPasterListResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 贴纸列表
 * 
 * @author xiegj
 *
 */
@Component
public class ApiPicPasterList extends RootApiToken<ApiPicPasterListInput, ApiPicPasterListResult> {

	@Override
	protected ApiPicPasterListResult process(ApiPicPasterListInput input) {

		ApiPicPasterListResult result = new ApiPicPasterListResult();

		List<CnPicPaster> ppts = getPicPasters();

		if (ppts != null) {

			for (CnPicPaster ppt : ppts) {

				CnPicPaster cnPicPaster = JdbcHelper.queryOne(CnPicPaster.class, "code", ppt.getCode());

				PicPasterInfo info = new PicPasterInfo();

				BeanUtils.copyProperties(cnPicPaster, info);

				result.getPti().add(info);

			}

		}

		return result;
	}

	public List<CnPicPaster> getPicPasters() {

		MDataMap mWhereMap = new MDataMap();

		mWhereMap.put("status", "dzsd4699100110010001");

		return JdbcHelper.queryForList(CnPicPaster.class, "", "-sort", "", mWhereMap);

	}

}
