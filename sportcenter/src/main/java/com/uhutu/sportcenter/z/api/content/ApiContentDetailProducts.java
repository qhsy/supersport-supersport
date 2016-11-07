package com.uhutu.sportcenter.z.api.content;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnContentDetail;
import com.uhutu.dcom.content.z.entity.CnContentProductRel;
import com.uhutu.dcom.content.z.entity.PcProductInfo;
import com.uhutu.sportcenter.z.input.ApiContentDetailProductsInput;
import com.uhutu.sportcenter.z.result.ApiContentDetailProductsResult;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 详情页推荐的商品列表
 * 
 * @author xiegj
 *
 */
@Component
public class ApiContentDetailProducts
		extends RootApiBase<ApiContentDetailProductsInput, ApiContentDetailProductsResult> {

	@Override
	protected ApiContentDetailProductsResult process(ApiContentDetailProductsInput input) {

		ApiContentDetailProductsResult result = new ApiContentDetailProductsResult();

		if (StringUtils.isNotBlank(input.getCode())) {
			List<CnContentProductRel> rels = JdbcHelper.queryForList(CnContentProductRel.class, "", " sort desc ", "",
					MapHelper.initMap("content_code", input.getCode()));
			StringBuffer str = new StringBuffer();
			if (rels != null && !rels.isEmpty() && rels.size() > 0) {
				for (int i = 0; i < rels.size(); i++) {
					if (i == rels.size() - 1) {
						str.append("'" + rels.get(i).getProductCode() + "'");
					} else {
						str.append("'" + rels.get(i).getProductCode() + "',");
					}
				}
			}
			if (StringUtils.isNotBlank(str)) {
				MDataMap mDataMap = new MDataMap();
				mDataMap.put("status", "1");
				List<PcProductInfo> pros = JdbcHelper.queryForList(PcProductInfo.class, "",
						" field(code," + str.toString() + ")",
						" code in(" + str.toString() + ")" + " and status=:status ", mDataMap);
				if (pros != null && pros.size() > 0 && input.getWidth() > 0) {
					for (int i = 0; i < pros.size(); i++) {
						pros.get(i).setPicurl(ImageHelper.upImageThumbnail(pros.get(i).getPicurl(), input.getWidth()));
					}
				}
				result.setProductInfos(pros);
			}
		} else {
			result.setStatus(0);
			result.setError("编号不能为空");
		}
		if (result.upFlagTrue() && result.getProductInfos() != null && result.getProductInfos().size() > 0) {
			CnContentDetail detail = JdbcHelper.queryOne(CnContentDetail.class, "code", input.getCode());
			if (detail != null && StringUtils.isNotBlank(detail.getTitle())) {
				result.setTitle(detail.getTitle());
			}
		}
		return result;
	}

}
