package com.uhutu.sportcenter.z.api.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import com.uhutu.dcom.content.z.entity.CnAdvertiseDetail;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentDetail;
import com.uhutu.dcom.content.z.entity.CnContentItem;
import com.uhutu.dcom.content.z.entity.CnContentItemRel;
import com.uhutu.dcom.content.z.entity.CnContentRecomm;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.entity.UserBasicInfo;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.entity.AdvertiseDetailForApi;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.entity.HomePageModel;
import com.uhutu.sportcenter.z.entity.UserinfoExtForApi;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

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
		mDataMap.put("status", "dzsd4699100110010001");
		List<CnContentItem> list = JdbcHelper.queryForList(CnContentItem.class, "", "",
				"startTime>=:t1 and startTime<=:t2 and endTime>=NOW() and type in ('dzsd4107100110060002','dzsd4107100110060003') and status=:status",
				mDataMap);
		if (list != null && !list.isEmpty() && list.size() > 0) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 单图模式标题处理
	 * 
	 * @return
	 */
	public ContentBasicinfoForApi getSingleTitle(ContentBasicinfoForApi cff) {
		if ("dzsd4107100110030004".equals(cff.getContentType())) {
			CnContentDetail detail = JdbcHelper.queryOne(CnContentDetail.class, "code", cff.getCode());
			if (detail != null && StringUtils.isNotBlank(detail.getContent())) {
				cff.setTitle(detail.getContent());
			}
		}
		return cff;
	}

	public List<HomePageModel> getPageModels(String itemCode, String itemType, String t1, String t2, String width) {
		List<HomePageModel> li = new ArrayList<HomePageModel>();
		MDataMap map = new MDataMap();
		map.put("itemType", itemType);
		map.put("itemCode", itemCode);
		List<CnContentItemRel> rels = JdbcHelper.queryForList(CnContentItemRel.class, "contentCode",
				"sort desc,start_time desc,zc desc",
				" itemCode=:itemCode and itemType=:itemType and endTime>=NOW() and startTime<=NOW() ", map);
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
			if ("dzsd4107100110060003".equals(itemType)) {// 内容

				List<CnContentBasicinfo> basics = JdbcHelper.queryForList(CnContentBasicinfo.class, "", "",
						"status='dzsd4699100110010001' and shareScope='dzsd4699100110010001' and code in("
								+ str.toString() + ")",
						new MDataMap());
				List<CnContentBasicinfo> infos = new ArrayList<CnContentBasicinfo>();
				for (int i = 0; i < rels.size(); i++) {
					for (int j = 0; j < basics.size(); j++) {
						if (rels.get(i).getContentCode().equals(basics.get(j).getCode())) {
							infos.add(basics.get(j));
						}
					}
				}
				if (infos != null && !infos.isEmpty() && infos.size() > 0) {
					for (int i = 0; i < infos.size(); i++) {
						HomePageModel hmp = new HomePageModel();
						CnContentBasicinfo info = infos.get(i);
						ContentBasicinfoForApi infoApi = new ContentBasicinfoForApi();
						UserinfoExtForApi userInfoApi = new UserinfoExtForApi();
						if (StringUtils.isNotBlank(info.getAuthor())) {
							UcUserinfoExt ext = userInfoSupport.getUserBasicInfo(info.getAuthor()).getUcUserinfoExt();
							if (ext == null) {
								continue;
							}
							UserBasicInfo ubi = userInfoSupport.getUserBasicInfo(info.getAuthor());
							BeanUtils.copyProperties(ubi.getUcUserinfoExt(), userInfoApi);

							if (ubi.getUcUserinfo() != null) {

								userInfoApi.setType(ubi.getUcUserinfo().getType());

							}

						}
						CnContentRecomm recomm = JdbcHelper.queryOne(CnContentRecomm.class, "contentCode",
								info.getCode());
						if (recomm != null) {
							info.setCover(
									StringUtils.isNotBlank(recomm.getCover()) ? recomm.getCover() : info.getCover());
							info.setTitle(
									StringUtils.isNotBlank(recomm.getTitle()) ? recomm.getTitle() : info.getTitle());
						}
						if (StringUtils.isNotBlank(info.getCover()) && StringUtils.isNotBlank(width)) {
							info.setCover(ImageHelper.upImageThumbnail(info.getCover(), Integer.valueOf(width)));
						}
						BeanUtils.copyProperties(info, infoApi);
						infoApi.getUserBasicInfo().setNickName(userInfoApi.getNickName());
						infoApi.getUserBasicInfo().setAboutHead(userInfoApi.getAboutHead());
						infoApi.getUserBasicInfo().setType(userInfoApi.getType());
						hmp.setInfo(getSingleTitle(infoApi));
						hmp.setShowType("dzsd4107100110060003");
						li.add(hmp);
					}
				}
			} else if ("dzsd4107100110060002".equals(itemType)) {// 一栏广告

				CnAdvertiseDetail detail = JdbcHelper.queryOne(CnAdvertiseDetail.class, "", "",
						" code in(" + str.toString() + ")", new MDataMap());
				HomePageModel hmp = new HomePageModel();
				hmp.setShowType("dzsd4107100110060002");
				AdvertiseDetailForApi dfa = new AdvertiseDetailForApi();
				BeanUtils.copyProperties(detail, dfa);
				if ("dzsd4107100110050002".equals(detail.getPiclinkType())
						&& StringUtils.isNotBlank(detail.getPiclinkContent())) {
					CnContentBasicinfo cbi = JdbcHelper.queryOne(CnContentBasicinfo.class, "code",
							detail.getPiclinkContent());
					if (cbi != null) {
						dfa.setType(cbi.getContentType());
					}
				}
				if (StringUtils.isNotBlank(dfa.getPicUrl()) && StringUtils.isNotBlank(width)) {
					dfa.setPicUrl(ImageHelper.upImageThumbnail(dfa.getPicUrl(), Integer.valueOf(width)));
				}
				hmp.getAdv().getDetails().add(dfa);
				li.add(hmp);
			} else if ("dzsd4107100110060001".equals(itemType)
					&& t1.substring(0, 10).equals(DateHelper.upNow().substring(0, 10))) {// 轮播广告

				List<CnAdvertiseDetail> details = JdbcHelper.queryForList(CnAdvertiseDetail.class, "",
						" field(code," + str.toString() + ")", " code in(" + str.toString() + ")", new MDataMap());
				if (details != null && !details.isEmpty() && details.size() > 0) {
					HomePageModel hmp = new HomePageModel();
					hmp.setShowType("dzsd4107100110060001");
					for (int j = 0; j < details.size(); j++) {
						AdvertiseDetailForApi dfa = new AdvertiseDetailForApi();
						BeanUtils.copyProperties(details.get(j), dfa);
						if (StringUtils.isNotBlank(dfa.getPicUrl()) && StringUtils.isNotBlank(width)) {
							dfa.setPicUrl(ImageHelper.upImageThumbnail(dfa.getPicUrl(), Integer.valueOf(width)));
						}
						hmp.getAdv().getDetails().add(dfa);
					}
					li.add(hmp);
				}
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
