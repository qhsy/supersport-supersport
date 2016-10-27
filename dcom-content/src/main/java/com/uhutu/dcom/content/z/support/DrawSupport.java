package com.uhutu.dcom.content.z.support;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.uhutu.dcom.content.z.entity.CnPrizesHistory;
import com.uhutu.dcom.content.z.entity.CnPrizesInfo;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 抽奖活动支撑类
 * 
 * @author xiegj
 *
 */
public class DrawSupport {

	/**
	 * 最多抽奖次数
	 */
	public final static int DRAW_TIME = 1;

	/**
	 * 判断可抽奖次数
	 * 
	 * @param userCode
	 *            用户编号
	 */
	private int drawTimes(String userCode) {
		int count = JdbcHelper.dataCount("CnPrizesHistory", "user_code", userCode, "draw_time",
				DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
		return DRAW_TIME - count;
	}

	/**
	 * 抽奖
	 * 
	 * @param userCode
	 *            用户编号
	 * @param contentCode
	 *            内容编号
	 */
	public void draw(String userCode, String contentCode) {
		if (drawTimes(userCode) > 0) {
			CnPrizesInfo pi = JdbcHelper.queryOne(CnPrizesInfo.class, "", " RAND() limit 1", " status=0 ",
					new MDataMap());
			if (pi != null) {
				saveHistory(pi, userCode, contentCode);// 记录数据

			}
		}
	}

	/**
	 * 抽奖数据记录
	 * 
	 * @param pi
	 *            奖品信息
	 * @param userCode
	 *            用户编号
	 * @param contentCode
	 *            内容编号
	 */
	private void saveHistory(CnPrizesInfo pi, String userCode, String contentCode) {
		CnPrizesHistory hi = new CnPrizesHistory();
		hi.setCode(pi.getCode());
		hi.setContentCode(contentCode);
		hi.setDrawTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
		hi.setUserCode(userCode);
		JdbcHelper.insert(hi);
		pi.setStatus(1);
		JdbcHelper.update(pi, "status", "za");
	}

	/**
	 * 抽奖消息推送和通知
	 * 
	 * @param pi
	 *            奖品信息
	 * @param userCode
	 *            用户编号
	 * @param contentCode
	 *            内容编号
	 */
	private void drawMessage(CnPrizesInfo pi, String userCode, String contentCode) {

	}

}
