package com.uhutu.dcom.content.job;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.dcom.content.z.support.RedPackComponet;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.model.MJobConfig;
import com.uhutu.zoocom.model.MResult;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.root.RootJob;

/**
 * 直播规定时间内没有心跳就更新状态为直播结束
 * 
 * @author Administrator
 *
 */

public class JobForLiveHeart extends RootJob {

	@Override
	public MJobConfig upConfig() {
		MJobConfig jobConfig = new MJobConfig();
		jobConfig.setMaxLockTime(60);
		return jobConfig;
	}

	@Override
	public MResult process() {

		List<CnLiveVideoDetail> ds = JdbcHelper.queryForList(CnLiveVideoDetail.class, "", "zc desc",
				"status='1' and ((zu is null and zc<DATE_SUB(NOW(),INTERVAL 90 SECOND)) or ( zu is not null and zu<DATE_SUB(NOW(),INTERVAL 90 SECOND) ))  ",
				new MDataMap());
		if (ds != null && !ds.isEmpty()) {
			for (int i = 0; i < ds.size(); i++) {
				CnLiveVideoDetail cd = ds.get(i);
				cd.setStatus("0");
				JdbcHelper.update(cd, "status", "za");
				RedPackComponet.getInstance().doLiveProfit(cd.getBusiCode());
				if (StringUtils.isNotBlank(cd.getContentCode())) {
					CnContentBasicinfo cn = JdbcHelper.queryOne(CnContentBasicinfo.class, "code", cd.getContentCode());
					cn.setStatus("dzsd4699100110010002");
					JdbcHelper.update(cn, "status", "za");
				}
			}
		}
		return new MResult();
	}

}
