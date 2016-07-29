package com.uhutu.dcom.user.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.user.z.entity.UcAttentionInfo;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.enums.MsgEnum;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.model.MJobConfig;
import com.uhutu.zoocom.model.MResult;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.root.RootJob;

/**
 * 马甲账号相互关注临时定时任务
 * 
 * @author xiegj
 *
 */
public class JobForMjAttention extends RootJob {

	@Override
	public MJobConfig upConfig() {
		MJobConfig jobConfig = new MJobConfig();
		jobConfig.setMaxLockTime(1000);
		return jobConfig;
	}

	@Override
	public MResult process() {
		System.out.println("开始时间：" + DateHelper.upNow());
		List<String> accounts = getMjAccount();
		if (accounts != null && !accounts.isEmpty()) {
			for (int i = 0; i < accounts.size(); i++) {
				String cc = accounts.get(i);
				Set<String> ss = getRandomAttentions(cc, accounts);
				saveMsgAttend(cc, ss);
			}
		}
		System.out.println("完活" + DateHelper.upNow());
		return new MResult();
	}

	/**
	 * 保存关注信息
	 * 
	 * @param attentionInfo
	 */
	private void saveMsgAttend(String userCode, Set<String> fans) {

		Iterator<String> it = fans.iterator();
		while (it.hasNext()) {
			// 关注信息
			UcAttentionInfo attentionInfo = new UcAttentionInfo();
			attentionInfo.setBeAttention(userCode);
			attentionInfo.setAttention(it.next());
			attentionInfo.setStatus("1");
			attentionInfo.setZc(new Date());
			JdbcHelper.insert(attentionInfo);
			// 消息
			MDataMap mm = new MDataMap();
			mm.put("attn_userCode", attentionInfo.getBeAttention());
			mm.put("fans_userCode", attentionInfo.getAttention());
			mm.put("msg_time", DateHelper.upNow());
			mm.put("msg_title", "关注了您");
			mm.put("status", MsgEnum.FLAG_UNREAD.getCode());
			JdbcHelper.dataInsert("UcMsgAttention", mm);
		}
	}

	/**
	 * 获取所有马甲号信息
	 */
	private List<String> getMjAccount() {
		List<String> list = new ArrayList<String>();
		List<UcUserinfo> us = JdbcHelper.queryForList(UcUserinfo.class, "", "", "mj_flag='dzsd4699100110010001'",
				new MDataMap());
		if (us != null && !us.isEmpty()) {
			for (int i = 0; i < us.size(); i++) {
				if (StringUtils.isNotBlank(us.get(i).getCode())) {
					list.add(us.get(i).getCode());
				}
			}
		}
		// System.out.println("马甲账号总数:" + list.size());
		return list;
	}

	/**
	 * 针对某一马甲号进行随机关注 数量控制在200到260之间
	 */
	private Set<String> getRandomAttentions(String userCode, List<String> codes) {
		Set<String> set = new HashSet<String>();
		Random rand = new Random();
		int num = rand.nextInt(60) + 200;// 选取关注的数量
		while (set.size() < num) {
			set.add(codes.get(rand.nextInt(codes.size())));
		}
		List<UcAttentionInfo> ats = JdbcHelper.queryForList(UcAttentionInfo.class, "", "",
				"beAttention='" + userCode + "'", new MDataMap());
		for (int i = 0; i < ats.size(); i++) {
			if (set.contains(ats.get(i).getAttention())) {
				set.remove(ats.get(i).getAttention());
			}
		}
		// System.out.println("用户：" + userCode + "已有粉丝数:" + ats.size() +
		// "的随机粉丝数为:" + set.size());
		return set;
	}

}
