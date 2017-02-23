package com.uhutu.sportcenter.z.api.live2;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.support.RedPackComponet;
import com.uhutu.sportcenter.z.input.ApiChangeStatusInput;
import com.uhutu.sportcenter.z.result.ApiChangeStatusResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 修改线上线下状态
 * 
 * @author 逄小帅
 *
 */
@Component
public class ApiChangeStatus extends RootApiToken<ApiChangeStatusInput, ApiChangeStatusResult> {

	@Override
	protected ApiChangeStatusResult process(ApiChangeStatusInput input) {

		ApiChangeStatusResult statusResult = new ApiChangeStatusResult();

		switch (input.getStatus()) {
		case 0:
			// 上线
			online(input.getUserCode());
			break;

		case 1:
			// 离线
			unline(input.getUserCode());
			break;

		default:
			break;
		}

		return statusResult;
	}

	/**
	 * 主播上线
	 * 
	 * @param userCode
	 */
	public void online(String userCode) {

		MDataMap mWhereMap = new MDataMap();

		mWhereMap.put("userCode", userCode);

		mWhereMap.put("status", ContentEnum.LIVEREADY.getCode());

		CnLiveVideoDetail detail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "", "-zc", "", mWhereMap);

		if (detail != null) {

			detail.setStatus(ContentEnum.LIVEING.getCode());

			JdbcHelper.update(detail, "status", "za");

			CnContentBasicinfo basicinfo = JdbcHelper.queryOne(CnContentBasicinfo.class, "code",
					detail.getContentCode());

			if (basicinfo != null) {

				basicinfo.setStatus(ContentEnum.normal.getCode());

				JdbcHelper.update(basicinfo, "status", "za");

			}

		}

	}

	/**
	 * 下线相关操作
	 * 
	 * @param userCode
	 */
	public void unline(String userCode) {

		MDataMap mWhereMap = new MDataMap();

		mWhereMap.put("userCode", userCode);

		mWhereMap.put("status", ContentEnum.LIVEING.getCode());

		CnLiveVideoDetail videoDetail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "", "-zc", "", mWhereMap);

		if (videoDetail != null) {
			videoDetail.setStatus(ContentEnum.LIVEEND.getCode());
			JdbcHelper.update(videoDetail, "status", "za");
			if (StringUtils.isNotBlank(videoDetail.getContentCode())) {
				CnContentBasicinfo cn = JdbcHelper.queryOne(CnContentBasicinfo.class, "code",
						videoDetail.getContentCode());
				cn.setContentType("dzsd4107100110030009");
				JdbcHelper.update(cn, "contentType", "za");
			}
			/* 直播打赏分成 */
			if (StringUtils.isNotEmpty(videoDetail.getBusiCode())) {

				RedPackComponet.getInstance().doLiveProfit(videoDetail.getBusiCode());

			}

		}

	}

}
