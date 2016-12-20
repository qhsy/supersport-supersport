package com.uhutu.dcom.content.z.support;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.util.ApplicationSupport;
import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.dcom.content.z.entity.CnRedPackUser;
import com.uhutu.dcom.content.z.service.IRedPackInfoService;
import com.uhutu.dcom.extend.baiduPush.exception.PushClientException;
import com.uhutu.dcom.extend.baiduPush.exception.PushServerException;
import com.uhutu.dcom.extend.baiduPush.sample.BaiduPush;
import com.uhutu.dcom.extend.baiduPush.sample.PushEnum;
import com.uhutu.dcom.pay.z.common.OperType;
import com.uhutu.dcom.pay.z.common.TradeType;
import com.uhutu.dcom.user.z.entity.UcClientInfo;
import com.uhutu.dcom.user.z.entity.UcMsgNotice;
import com.uhutu.dcom.user.z.entity.UcMsgNoticeUser;
import com.uhutu.dcom.user.z.entity.UcTradeFlow;
import com.uhutu.dcom.user.z.enums.MsgEnum;
import com.uhutu.dcom.user.z.support.AccountComponet;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.WebHelper;

/**
 * 打赏相关操作support
 * @author 逄小帅
 *
 */
@Component
public class RedPackComponet {
	
	/*实体bean处理处理实例*/
	private volatile static RedPackComponet INSTANCE = null;
	
	@Autowired
	private IRedPackInfoService redPackInfoService;
	
	/**
	 * 获取实体bean处理实例
	 * @return RedPackComponet
	 */
	public static RedPackComponet getInstance(){
		
		if(INSTANCE == null){
			
			synchronized (RedPackComponet.class) {
				
				if(INSTANCE == null){
					
					INSTANCE = (RedPackComponet) ApplicationSupport.getBean("redPackComponet");
					
				}
				
			}
			
		}
		
		return INSTANCE;
		
	}
	
	/**
	 * 处理直播分成
	 * @param liveNO
	 */
	public void doLiveProfit(String liveNO){
		
		synchronized (RedPackComponet.class) {
			
			List<CnRedPackUser> redPackUsers = redPackInfoService.getRedPackUsers(liveNO, SystemEnum.INVALID.getCode());
			
			//获取直播信息
			CnLiveVideoDetail cnLiveVideoDetail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "busiCode",liveNO);
			
			if(cnLiveVideoDetail != null){
				
				BigDecimal totalProfit = BigDecimal.ZERO;
				
				for (CnRedPackUser redPackUser : redPackUsers) {

					if (redPackUser != null) {
						
						BigDecimal packUserProfit = BigDecimal.ZERO;

						if (redPackUser.getMoney().compareTo(BigDecimal.ZERO) > 0) {

							BigDecimal profitRate = redPackUser.getScale().divide(BigDecimal.valueOf(100)).setScale(2);

							BigDecimal liveRate = BigDecimal.ONE.subtract(profitRate).setScale(2);

							packUserProfit = redPackUser.getMoney().multiply(profitRate).setScale(2,
									BigDecimal.ROUND_DOWN);

							BigDecimal liveProfit = redPackUser.getMoney().multiply(liveRate).setScale(2,
									BigDecimal.ROUND_DOWN);

							totalProfit = totalProfit.add(liveProfit).setScale(2);

							/* 记录打赏人员流水 */
							liveProfitFlow(StringUtils.join(liveNO, "-", redPackUser.getUserCode()), packUserProfit,
									"");
							/* 更新打赏人员收益 */
							AccountComponet.getInstance().updateProfit(redPackUser.getUserCode(), packUserProfit);

							/* 记录主播人员流水 */
							liveProfitFlow(StringUtils.join(liveNO, "-", cnLiveVideoDetail.getUserCode()), liveProfit,
									"");
							/* 更新主播收益 */
							AccountComponet.getInstance().updateProfit(cnLiveVideoDetail.getUserCode(), liveProfit);

						}

						/* 更新主播分成状态 */
						redPackUser.setStatus(SystemEnum.NORMAL.getCode());

						JdbcHelper.update(redPackUser, "status", "za");

						/* 跟分成人员发送消息通知 */

						String content = TopHelper.upInfo(810710024, cnLiveVideoDetail.getTitle(),
								packUserProfit.toString());

						msgNotice(content, redPackUser.getUserCode());

						baiduPush(redPackUser.getUserCode(), "直播结算", content, "7", "");

					}

				}
				
				/*跟直播人员发送消息通知*/
				
				String content = TopHelper.upInfo(810710025, cnLiveVideoDetail.getTitle(),cnLiveVideoDetail.getIncome().setScale(2).toString(), totalProfit.toString());
				
				msgNotice(content, cnLiveVideoDetail.getUserCode());
				
				baiduPush(cnLiveVideoDetail.getUserCode(), "直播结算", content, "7", "");
				
			}
			
			
		}
		
	}
	
	/**
	 * 保存红包交易流水
	 * @param outCode
	 * 		外部编号
	 * @param tradeMoney
	 * 		交易金额
	 * @param remark
	 * 		备注信息
	 */
	public void liveProfitFlow(String outCode,BigDecimal tradeMoney,String remark){
		
		UcTradeFlow ucTradeFlow = new UcTradeFlow();
		
		ucTradeFlow.setOperType(OperType.RED_PACK.name());
		
		ucTradeFlow.setOutCode(outCode);
		
		remark = StringUtils.isEmpty(remark)?OperType.RED_PACK.getRemark() : remark;
		
		ucTradeFlow.setRemark(remark);
		
		ucTradeFlow.setTradeMoney(tradeMoney);
		
		ucTradeFlow.setTradeType(TradeType.REDPACK_PROFIT.name());
		
		AccountComponet.getInstance().saveTradeFlow(ucTradeFlow);
		
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
	 *            推送跳转类型 0个人中心 1运动时刻详情页 2首页 3问达详情页 7消息中心
	 * @param jumpJson
	 *            推送跳转内容
	 */
	public void baiduPush(String userCode, String title, String content, String jumpType, String jumpContent) {

		try {

			UcClientInfo ucClientInfo = JdbcHelper.queryOne(UcClientInfo.class, "", "-zc", "",
					MapHelper.initMap("user_code", userCode, "os", "ios"));

			if (ucClientInfo != null && StringUtils.isNotBlank(ucClientInfo.getChannelId())) {
				new BaiduPush().push(PushEnum.ios, "果冻体育", content, ucClientInfo.getChannelId(), jumpType, jumpContent);
			}

			UcClientInfo android = JdbcHelper.queryOne(UcClientInfo.class, "", "-zc", "",
					MapHelper.initMap("user_code", userCode, "os", "android"));

			if (android != null && StringUtils.isNotBlank(android.getChannelId())) {
				new BaiduPush().push(PushEnum.android, "果冻体育", content, android.getChannelId(), jumpType, jumpContent);
			}

		} catch (PushServerException e) {

			e.printStackTrace();

		} catch (PushClientException e) {

			e.printStackTrace();

		}

	}
	
	public void msgNotice(String content, String userCode) {

		UcMsgNotice notice = new UcMsgNotice();
		notice.setCode(WebHelper.upCode("MNTCBH"));
		notice.setContent(content);
		notice.setNotifyTime(DateHelper.upDate(new Date()));
		notice.setStatus("0");
		notice.setTitle("系统消息");
		notice.setType(MsgEnum.TYPE_SYSTEM.getCode());
		notice.setSendType(MsgEnum.TO_ONE.getCode());
		JdbcHelper.insert(notice);
		UcMsgNoticeUser ucMsgNoticeUser = new UcMsgNoticeUser();
		ucMsgNoticeUser.setNoticeCode(notice.getCode());
		ucMsgNoticeUser.setUserCode(userCode);
		ucMsgNoticeUser.setStatus(MsgEnum.FLAG_UNREAD.getCode());
		ucMsgNoticeUser.setZc(new Date());
		JdbcHelper.insert(ucMsgNoticeUser);
		
	}

}
