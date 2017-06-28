package com.uhutu.sportcenter.z.api.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentItem;
import com.uhutu.dcom.content.z.entity.CnContentItemRel;
import com.uhutu.dcom.content.z.entity.CnHomeStyle;
import com.uhutu.dcom.content.z.entity.CnLiveInfo;
import com.uhutu.dcom.content.z.entity.CnMaterialLibrary;
import com.uhutu.dcom.content.z.support.DurationSupport;
import com.uhutu.dcom.remark.z.entity.CnContentRemark;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.entity.HomePageModel;
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

	public List<HomePageModel> getPageModels(String width, String token) {
		List<HomePageModel> result = new ArrayList<HomePageModel>();

		List<CnHomeStyle> styles = JdbcHelper.queryForList(CnHomeStyle.class, "", "sort desc", "", new MDataMap());
		StringBuffer str = new StringBuffer();
		if (styles != null && !styles.isEmpty() && styles.size() > 0) {
			for (int i = 0; i < styles.size(); i++) {
				if (i == styles.size() - 1) {
					str.append("'" + styles.get(i).getColumnCode() + "'");
				} else {
					str.append("'" + styles.get(i).getColumnCode() + "',");
				}
			}
		}
		if (StringUtils.isNotBlank(str)) {
			MDataMap mDataMap = new MDataMap();
			mDataMap.put("status", "dzsd4699100110010001");
			List<CnContentItem> items = JdbcHelper.queryForList(CnContentItem.class, "",
					" field(code," + str.toString() + ")", " code in(" + str.toString() + ")"
							+ " and  startTime<=NOW() and endTime>=NOW() and status=:status ",
					mDataMap);
			for (int i = 0; i < items.size(); i++) {
				HomePageModel model = getModel(items.get(i).getCode(), items.get(i).getType(), width, token);
				if (model != null) {
					result.add(model);
				}
			}
		}
		return result;
	}

	public HomePageModel getModel(String itemCode, String itemType, String width, String token) {
		HomePageModel model = new HomePageModel();
		MDataMap map = new MDataMap();
		map.put("itemCode", itemCode);
		List<CnContentItemRel> rels = JdbcHelper.queryForList(CnContentItemRel.class, "contentCode",
				"sort desc,start_time desc,zc desc", " itemCode=:itemCode and endTime>=NOW() and startTime<=NOW() ",
				map);
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
			basicInfos(itemType, token, model, str.toString(), width);
		}
		return model;
	}

	private void basicInfos(String itemType, String token, HomePageModel model, String str, String width) {
		List<CnContentBasicinfo> basics = JdbcHelper.queryForList(CnContentBasicinfo.class, "",
				" field(code," + str.toString() + ")",
				"status='dzsd4699100110010001' and code in(" + str.toString() + ")", new MDataMap());
		List<CnMaterialLibrary> mls = JdbcHelper.queryForList(CnMaterialLibrary.class, "",
				" field(code," + str.toString() + ")", " code in(" + str.toString() + ")", new MDataMap());
		model.setShowType(itemType);
		if (mls != null && !mls.isEmpty()) {//推荐
			for (int i = 0; i < mls.size(); i++) {
				CnMaterialLibrary ml = mls.get(i);
				if (StringUtils.isNotBlank(ml.getUrl()) && StringUtils.isNotBlank(width)) {
					if (Integer.valueOf(width) >= 750) {
						ml.setUrl(ml.getUrl() + "-w1242.jpg");
					} else {
						ml.setUrl(ml.getUrl() + "-w750.jpg");
					}
				}
				model.getTopics().add(ml);
			}
		}
		if (basics != null && !basics.isEmpty()) {
			for (int i = 0; i < basics.size(); i++) {
				CnContentBasicinfo info = basics.get(i);
				ContentBasicinfoForApi infoApi = new ContentBasicinfoForApi();
				if (StringUtils.isNotBlank(info.getCover()) && StringUtils.isNotBlank(width)) {
					if (Integer.valueOf(width) >= 750) {
						info.setCover(info.getCover() + "-w1242.jpg");
					} else {
						info.setCover(info.getCover() + "-w750.jpg");
					}
				}
				BeanUtils.copyProperties(info, infoApi);
				int remarkNum = JdbcHelper.count(CnContentRemark.class, "",
						MapHelper.initMap("content_code", infoApi.getCode(), "status", "dzsd4699100110010001"));
				infoApi.setRemarkNum(remarkNum);
				infoApi.setFavorFlag(ContentComponent.lightFavor(infoApi.getCode(), token));
				infoApi.setMakeFlag(ContentComponent.makeFlag(infoApi.getCode(), token));
				if ("dzsd4107100110030001".equals(infoApi.getContentType())) {// 视频
					if(infoApi.getDuration()==0){
						infoApi.setDuration(new DurationSupport().getDuration(info.getZa(), info.getVideoUrl()));
					}
					model.getVideos().add(infoApi);
				} else if ("dzsd4107100110030002".equals(infoApi.getContentType())) {// 直播
					infoApi.setMakeAble(false);
					if (StringUtils.isNotBlank(infoApi.getVideoUrl())) {
						CnLiveInfo liveInfo = JdbcHelper.queryOne(CnLiveInfo.class, "code", infoApi.getVideoUrl());
						if (liveInfo != null && StringUtils.isNotBlank(liveInfo.getStatus())) {
							infoApi.setMakeAble("dzsd4107100110170001".equals(liveInfo.getStatus()));
						}
					}
					model.getLives().add(infoApi);
				}
			}
		}
	}

}
