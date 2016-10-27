package com.uhutu.dcom.content.z.support;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import com.uhutu.dcom.answer.z.common.Constants;
import com.uhutu.dcom.content.z.entity.CnPrizesHistory;
import com.uhutu.dcom.content.z.entity.CnPrizesInfo;
import com.uhutu.dcom.extend.baiduPush.exception.PushClientException;
import com.uhutu.dcom.extend.baiduPush.exception.PushServerException;
import com.uhutu.dcom.extend.baiduPush.sample.BaiduPush;
import com.uhutu.dcom.extend.baiduPush.sample.PushEnum;
import com.uhutu.dcom.user.z.entity.UcClientInfo;
import com.uhutu.dcom.user.z.entity.UcMsgNotice;
import com.uhutu.dcom.user.z.entity.UcMsgNoticeUser;
import com.uhutu.dcom.user.z.enums.MsgEnum;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.WebHelper;

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
				drawMessage(pi, userCode, contentCode);// 推送消息和站内信
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
		baiduPush(userCode, "果冻体育", "恭喜！您已成功参加GODO GAMES线上挑战赛，获得幸运奖以及iPhone7抽奖机会！猛戳领奖！",
				"恭喜！获得果冻体育幸运奖以及iPhone7抽奖机会！猛戳领奖！", Constants.PUSH_JUMP_MSGCENTER, "");// 百度推送
		saveMsgNotice(pi, userCode, contentCode);// 站内信
	}

	/**
	 * 百度push
	 * 
	 * @param answerUserCode
	 *            用户编号
	 * @param title
	 *            标题
	 * @param content
	 *            内容
	 * @param jumpType
	 *            推送跳转类型 0个人中心 1运动时刻详情页 2首页 3问达详情页
	 * @param jumpJson
	 *            推送跳转内容
	 */
	public void baiduPush(String userCode, String title, String iosContent, String AndroidContent, String jumpType,
			String jumpContent) {

		try {

			UcClientInfo ucClientInfo = JdbcHelper.queryOne(UcClientInfo.class, "", "-zc", "",
					MapHelper.initMap("user_code", userCode, "os", "ios"));

			if (ucClientInfo != null && StringUtils.isNotBlank(ucClientInfo.getChannelId())) {
				new BaiduPush().push(PushEnum.ios, "果冻体育", iosContent, ucClientInfo.getChannelId(), jumpType,
						jumpContent);
			}

			UcClientInfo android = JdbcHelper.queryOne(UcClientInfo.class, "", "-zc", "",
					MapHelper.initMap("user_code", userCode, "os", "android"));

			if (android != null && StringUtils.isNotBlank(android.getChannelId())) {
				new BaiduPush().push(PushEnum.android, "果冻体育", AndroidContent, android.getChannelId(), jumpType,
						jumpContent);
			}

		} catch (PushServerException e) {

			e.printStackTrace();

		} catch (PushClientException e) {

			e.printStackTrace();

		}

	}

	public void saveMsgNotice(CnPrizesInfo pi, String userCode, String contentCode) {

		UcMsgNotice notice = new UcMsgNotice();
		notice.setCode(WebHelper.upCode("MNTCBH"));
		notice.setContent("恭喜！您已成功参加GODO GAMES线上挑战赛，并获得幸运奖" + pi.getAboutDesc() + "！活动期内每天上传参赛视频，赢取百万礼包，更有iPhone7等你拿！");
		notice.setNotifyTime(DateHelper.upDate(new Date()));
		notice.setStatus("0");
		notice.setTitle("系统消息");
		notice.setType(MsgEnum.TYPE_SYSTEM.getCode());
		JdbcHelper.insert(notice);
		UcMsgNoticeUser ucMsgNoticeUser = new UcMsgNoticeUser();

		ucMsgNoticeUser.setNoticeCode(notice.getCode());

		ucMsgNoticeUser.setUserCode(userCode);

		ucMsgNoticeUser.setStatus(MsgEnum.FLAG_UNREAD.getCode());

		ucMsgNoticeUser.setZc(new Date());
		JdbcHelper.insert(ucMsgNoticeUser);

	}
}
