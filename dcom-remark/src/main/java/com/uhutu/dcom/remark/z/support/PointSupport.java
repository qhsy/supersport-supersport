package com.uhutu.dcom.remark.z.support;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.remark.z.entity.CnPointFlow;
import com.uhutu.dcom.remark.z.entity.CnPointLevel;
import com.uhutu.dcom.remark.z.entity.CnPointRoles;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.model.MResult;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.WebHelper;

public class PointSupport {

	/**
	 * 每个只记一次
	 */
	public static final String RolesFrist = "dzsd4801100110010001";
	/**
	 * 上限自然天
	 */
	public static final String RolesSecond = "dzsd4801100110010001";

	/**
	 * 获取等级头衔
	 * 
	 * @return
	 */
	public static String getLevelTitle(String userCode) {
		String restlt = "";
		List<MDataMap> li = JdbcHelper.dataQuery("cn_point_flow", " sum(num) as num ", "", "",
				MapHelper.initMap("userCode", userCode), 0, 0);
		List<CnPointLevel> levels = JdbcHelper.queryForList(CnPointLevel.class, "", " point asc  ", "", null);
		if (li != null && li.size() > 0) {
			if (StringUtils.isNotBlank(li.get(0).get("num"))) {
				double num = new BigDecimal(li.get(0).get("num")).doubleValue();
				if (levels != null && levels.size() > 0) {
					for (int i = 0; i < levels.size(); i++) {
						if (i == levels.size() - 1) {
							restlt = levels.get(i).getName();
						} else if (num >= levels.get(i).getPoint() && num < levels.get(i + 1).getPoint()) {
							restlt = levels.get(i).getName();
							break;
						}
					}
				}
			} else {
				restlt = levels.get(0).getName();
			}
		}
		return restlt;
	}

	/**
	 * 记录积分流水
	 * 
	 * @param type
	 *            记录类型
	 * 
	 * @param code
	 *            内容编号
	 */
	public static MResult savePointFlow(String type, String contentCode, String userCode) {
		MResult result = new MResult();
		CnPointRoles role = JdbcHelper.queryOne(CnPointRoles.class, "code", type);
		if (role != null && StringUtils.isNotBlank(role.getRoles())) {
			boolean flag = true;
			if (flag && role.getRoles().contains(RolesFrist)) {
				flag = checkTypeFrist(type, contentCode, userCode);
			}
			if (flag && role.getRoles().contains(RolesSecond)) {
				flag = checkTypeSecond(type, contentCode, userCode);
			}
			if (flag && role != null && role.getPoint() > 0) {
				CnPointFlow flow = new CnPointFlow();
				flow.setCode(WebHelper.upCode("JFLSBH"));
				flow.setContentCode(contentCode);
				flow.setType(type);
				flow.setUserCode(userCode);
				flow.setNum(role.getPoint());
				JdbcHelper.insert(flow);
			} else {
				result.setStatus(0);
			}
		}
		return result;
	}

	/**
	 * 校验积分规则一
	 * 
	 * @return
	 */
	private static boolean checkTypeFrist(String type, String contentCode, String userCode) {
		boolean result = false;
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(contentCode) && StringUtils.isNotBlank(userCode)) {
			String startTime = DateHelper.upDate(new Date(), "yyyy-MM-dd 00:00:00");
			String endTime = DateHelper.upNow();
			List<CnPointFlow> li = JdbcHelper.queryForList(CnPointFlow.class, "", "",
					" user_code=:userCode and zc>=:ST and zc<=:ET and content_code=:contentCode",
					MapHelper.initMap("userCode", userCode, "ST", startTime, "ET", endTime, "contentCode", contentCode),
					0, 0);
			if (li == null || li.isEmpty()) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * 校验积分规则二
	 * 
	 * @return
	 */
	private static boolean checkTypeSecond(String type, String contentCode, String userCode) {
		boolean result = false;
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(contentCode) && StringUtils.isNotBlank(userCode)) {
			String startTime = DateHelper.upDate(new Date(), "yyyy-MM-dd 00:00:00");
			String endTime = DateHelper.upNow();
			CnPointRoles role = JdbcHelper.queryOne(CnPointRoles.class, "code", type);
			if (role != null) {
				List<MDataMap> li = JdbcHelper.dataQuery("cn_point_flow", " sum(num) as num ", "",
						" user_code=:userCode and zc>=:ST and zc<=:ET ",
						MapHelper.initMap("userCode", userCode, "ST", startTime, "ET", endTime), 0, 0);
				if ((role.getLimitPoint() > 0 && StringUtils.isBlank(li.get(0).get("num")))
						|| (StringUtils.isNoneBlank(li.get(0).get("num"))
								&& role.getLimitPoint() > new BigDecimal(li.get(0).get("num")).doubleValue())) {
					result = true;
				}
			}
		}
		return result;
	}

}
