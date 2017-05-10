package com.uhutu.dcom.content.func;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.support.DrawSupport;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class ContentBasicInfoForReviewPageFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
//		CnContentBasicinfo cn = JdbcHelper.queryOne(CnContentBasicinfo.class, "za", input.getDataMap().get("za"));
//		if (StringUtils.isNotBlank(input.getDataMap().get("review_status"))
//				&& StringUtils.isNotBlank(cn.getReviewStatus())) {
//			if ("dzsd4107100110080001".equals(input.getDataMap().get("review_status"))
//					&& ("dzsd4107100110080002".equals(cn.getReviewStatus())
//							|| "dzsd4107100110080003".equals(cn.getReviewStatus()))) {
//				result.inError(810710019);
//			}
//		}
//		if (result.upFlagTrue()) {
//			JdbcHelper.dataUpdate(extendPageDefine.getPageSource().getTableName(), input.getDataMap(), "review_status",
//					"za");
//			if (StringUtils.isNotBlank(cn.getAuthor()) && StringUtils.isNoneBlank(cn.getCode())
//					&& "dzsd4107100110080002".equals(input.getDataMap().get("review_status"))) {// 抽奖
//				DrawSupport support = new DrawSupport();
//				support.draw(cn.getAuthor(), cn.getCode());
//			}
//		}
		return result;
	}
}
