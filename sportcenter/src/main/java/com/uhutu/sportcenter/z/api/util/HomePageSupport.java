package com.uhutu.sportcenter.z.api.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnAdvertiseDetail;
import com.uhutu.dcom.content.z.entity.CnAdvertiseInfo;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentItem;
import com.uhutu.dcom.content.z.entity.CnContentItemRel;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.entity.AdvertiseDetailForApi;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.entity.HomePageModel;
import com.uhutu.sportcenter.z.entity.UserinfoExtForApi;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 首页数据支撑类
 * 
 * @author xiegj
 *
 */
public class HomePageSupport {
	private UserInfoSupport userInfoSupport;

	public HomePageSupport(UserInfoSupport userInfoSupport) {
		this.userInfoSupport = userInfoSupport;
	}

	public String getTime(int num) {
		SimpleDateFormat df0 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (num <= 1) {
			return df0.format(new Date()) + "&" + df.format(new Date());
		} else {
			Calendar start = Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			start.add(Calendar.DAY_OF_MONTH, 1 - num);
			end.add(Calendar.DAY_OF_MONTH, 2 - num);
			return df0.format(start.getTime()) + "#" + df0.format(end.getTime());

		}
	}

	public boolean nextDaydata(int num) {
		boolean flag = false;
		if (num <= 1) {
			num = 2;
		} else {
			num = num + 1;
		}
		String str = getTime(num);
		String t1 = str.split("#")[0];
		String t2 = str.split("#")[1];
		MDataMap mDataMap = new MDataMap();
		mDataMap.put("t1", t1);
		mDataMap.put("t2", t2);
		List<CnContentItem> list = JdbcHelper.queryForList(CnContentItem.class, "", "",
				"startTime>:t1 and startTime<:t2 and endTime>=NOW()", mDataMap);
		if (list != null && !list.isEmpty() && list.size() > 0) {
			flag = true;
		}
		return flag;
	}

	public List<HomePageModel> getPageModels(String itemType) {
		List<HomePageModel> li = new ArrayList<HomePageModel>();
		MDataMap map = new MDataMap();
		map.put("itemType", itemType);
		List<CnContentItemRel> rels = JdbcHelper.queryForList(CnContentItemRel.class, "contentCode",
				"-sort,-start_time", "itemType=:itemType and endTime>=NOW()", map);
		StringBuffer str = new StringBuffer();
		if (rels != null && !rels.isEmpty() && rels.size() > 0) {
			for (int i = 0; i < rels.size(); i++) {
				if (i == rels.size() - 1) {
					str.append("'" + rels.get(i).getContentCode() + "'");
				} else {
					str.append("'" + rels.get(i).getContentCode() + "',");
				}
			}
		}
		if (StringUtils.isNotBlank(str)) {
			switch (itemType) {
			case "dzsd4699100110060003":// 内容

				List<CnContentBasicinfo> basics = JdbcHelper.queryForList(CnContentBasicinfo.class, "", "-publish_time",
						"status='dzsd4699100110010001' and shareScope='dzsd4699100110010001' and code in("
								+ str.toString() + ")",
						new MDataMap());
				if (basics != null && !basics.isEmpty() && basics.size() > 0) {
					for (int i = 0; i < basics.size(); i++) {
						HomePageModel hmp = new HomePageModel();
						CnContentBasicinfo info = basics.get(i);
						ContentBasicinfoForApi infoApi = new ContentBasicinfoForApi();
						UserinfoExtForApi userInfoApi = new UserinfoExtForApi();
						if (StringUtils.isNotBlank(info.getAuthor())) {
							UcUserinfoExt ext = userInfoSupport.getUserBasicInfo(info.getAuthor()).getUcUserinfoExt();
							if (ext == null) {
								continue;
							}
							BeanUtils.copyProperties(
									userInfoSupport.getUserBasicInfo(info.getAuthor()).getUcUserinfoExt(), userInfoApi);
						}
						BeanUtils.copyProperties(info, infoApi);
						infoApi.setNickName(userInfoApi.getNickName());
						infoApi.setAboutHead(userInfoApi.getAboutHead());
						hmp.setInfo(infoApi);
						hmp.setUe(userInfoApi);
						hmp.setShowType("dzsd4699100110060003");
						li.add(hmp);
					}
				}
				;
			case "dzsd4699100110060002":// 一栏广告
				List<CnAdvertiseInfo> dtAdv = JdbcHelper.queryForList(CnAdvertiseInfo.class, "", "-zc",
						"status='dzsd4699100110010001' and type='dzsd4699100110040001' and code in(" + str.toString()
								+ ")",
						new MDataMap());
				if (dtAdv != null && !dtAdv.isEmpty() && dtAdv.size() > 0) {
					for (int i = 0; i < dtAdv.size(); i++) {
						CnAdvertiseInfo advertiseInfo = dtAdv.get(i);
						CnAdvertiseDetail detail = JdbcHelper.queryOne(CnAdvertiseDetail.class, "code",
								advertiseInfo.getCode());
						HomePageModel hmp = new HomePageModel();
						hmp.setShowType("dzsd4699100110060002");
						hmp.getAdv().setCode(advertiseInfo.getCode());
						hmp.getAdv().setType(advertiseInfo.getType());
						AdvertiseDetailForApi dfa = new AdvertiseDetailForApi();
						BeanUtils.copyProperties(detail, dfa);
						hmp.getAdv().getDetails().add(dfa);
						li.add(hmp);
					}
				}
				;
			case "dzsd4699100110060001":// 轮播广告
				List<CnAdvertiseInfo> lbAdv = JdbcHelper.queryForList(CnAdvertiseInfo.class, "", "-zc",
						"status='dzsd4699100110010001' and type='dzsd4699100110040002' and code in(" + str.toString()
								+ ")",
						new MDataMap());
				if (lbAdv != null && !lbAdv.isEmpty() && lbAdv.size() > 0) {
					for (int i = 0; i < lbAdv.size(); i++) {
						CnAdvertiseInfo advertiseInfo = lbAdv.get(i);
						List<CnAdvertiseDetail> details = JdbcHelper.queryForList(CnAdvertiseDetail.class, "",
								"-zu,-zc", "code=:code", MapHelper.initMap("code", advertiseInfo.getCode()));
						HomePageModel hmp = new HomePageModel();
						hmp.setShowType("dzsd4699100110060001");
						hmp.getAdv().setCode(advertiseInfo.getCode());
						hmp.getAdv().setType(advertiseInfo.getType());
						for (int j = 0; j < details.size(); j++) {
							AdvertiseDetailForApi dfa = new AdvertiseDetailForApi();
							BeanUtils.copyProperties(details.get(j), dfa);
							hmp.getAdv().getDetails().add(dfa);
						}
						li.add(hmp);
					}
				}
				;
			}
		}
		return li;
	}

	public UserInfoSupport getUserInfoSupport() {
		return userInfoSupport;
	}

	public void setUserInfoSupport(UserInfoSupport userInfoSupport) {
		this.userInfoSupport = userInfoSupport;
	}

}
