package com.uhutu.dcom.content.z.support;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.pay.z.util.MD5;
import com.uhutu.zoodata.z.helper.JdbcHelper;

public class LiveSupport {

	/* 实体bean处理处理实例 */
	private volatile static LiveSupport INSTANCE = null;

	/**
	 * 获取实体bean处理实例
	 * 
	 * @return RedPackComponet
	 */
	public static LiveSupport getInstance() {

		if (INSTANCE == null) {

			synchronized (RedPackComponet.class) {

				if (INSTANCE == null) {

					INSTANCE = new LiveSupport();

				}

			}

		}

		return INSTANCE;

	}

	public String getTxTime(int amount) {

		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.HOUR_OF_DAY, amount);

		long txTime = calendar.getTimeInMillis() / 1000;

		return Long.toHexString(txTime).toUpperCase();

	}

	public String getTxTime(Date startTime,int amount) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startTime);
		calendar.add(Calendar.HOUR_OF_DAY, amount);

		long txTime = calendar.getTimeInMillis() / 1000;

		return Long.toHexString(txTime).toUpperCase();

	}

	public String getTxSecret(String key, String steamId, String txTime) {

		String salt = key + steamId + txTime;

		String txSecreat = MD5.sign(salt, "UTF-8");

		return txSecreat;

	}

	public void operLiveCount(int type, int optype, String userCode, String fieldName, String groupId) {

		switch (optype) {
		case 0:
			add(type, userCode, fieldName, groupId);
			break;
		case 1:
			subtract(type, userCode, fieldName, groupId);
			break;

		default:
			break;
		}

	}

	public void add(int type, String userCode, String fieldName, String groupId) {

		CnLiveVideoDetail detail = getLiveDetail(type, userCode, groupId);

		if (detail != null) {

			if (StringUtils.equals("praise", fieldName)) {

				long praiseNum = detail.getPraise() + 1;

				detail.setPraise(praiseNum);

				JdbcHelper.update(detail, "praise", "za");

			}

			if (StringUtils.equals("watch", fieldName)) {

				long watchNum = detail.getWatch() + 1;

				detail.setWatch(watchNum);

				JdbcHelper.update(detail, "watch", "za");

			}

		}

	}

	public void subtract(int type, String userCode, String fieldName, String groupId) {

		CnLiveVideoDetail detail = getLiveDetail(type, userCode, groupId);

		if (detail != null) {

			if (StringUtils.equals("praise", fieldName)) {

				long praiseNum = detail.getPraise() - 1;

				if (praiseNum < 0) {

					praiseNum = 0;

				}

				detail.setPraise(praiseNum);

				JdbcHelper.update(detail, "praise", "za");

			}

			if (StringUtils.equals("watch", fieldName)) {

				long watchNum = detail.getWatch() - 1;

				if (watchNum < 0) {

					watchNum = 0;

				}

				detail.setWatch(watchNum);

				JdbcHelper.update(detail, "watch", "za");

			}

		}

	}

	/**
	 * 获取直播信息
	 * 
	 * @param type
	 *            0:直播 1:点播
	 * @param userCode
	 * @param groupId
	 * @return
	 */
	public CnLiveVideoDetail getLiveDetail(int type, String userCode, String groupId) {

		CnLiveVideoDetail detail = null;

		if (type == 0) {

			detail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "userCode", userCode, "status",
					ContentEnum.LIVEING.getCode(), "chatCode", groupId);

		}

		if (type == 1) {

			detail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "userCode", userCode, "videoId", groupId);

		}

		return detail;

	}

}
