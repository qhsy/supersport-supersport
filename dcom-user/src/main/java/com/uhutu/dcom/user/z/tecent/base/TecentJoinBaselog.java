package com.uhutu.dcom.user.z.tecent.base;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.user.z.entity.UcTecentLog;
import com.uhutu.zoocom.root.RootClass;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.WebHelper;

public class TecentJoinBaselog extends RootClass {

	public UcTecentLog saveLog(UcTecentLog log) {
		if (StringUtils.isNotBlank(log.getCode())) {
			JdbcHelper.update(log, "", "code");
		} else {
			log.setCode(WebHelper.upCode("TECENT"));
			JdbcHelper.insert(log);
		}
		return log;
	}

}
