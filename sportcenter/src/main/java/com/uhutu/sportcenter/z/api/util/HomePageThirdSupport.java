package com.uhutu.sportcenter.z.api.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.content.z.entity.CnAdvertiseDetail;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentDetail;
import com.uhutu.dcom.content.z.entity.CnHomeItem;
import com.uhutu.dcom.content.z.entity.CnHomeItemRel;
import com.uhutu.dcom.content.z.entity.CnHomeType;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.sportcenter.z.entity.AdvertiseDetailForThirdHomePageApi;
import com.uhutu.sportcenter.z.entity.CnHomeItemForApi;
import com.uhutu.sportcenter.z.entity.HomeContent;
import com.uhutu.sportcenter.z.entity.HomePageThird;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.helper.SerializeHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 新首页数据支撑类
 * 
 * @author xiegj
 *
 */
public class HomePageThirdSupport {

	private static final String Start = "CNBH";

	public List<HomePageThird> getPageModels(int width) {
		List<HomePageThird> li = new ArrayList<HomePageThird>();
		List<CnHomeType> types = JdbcHelper.queryForList(CnHomeType.class, "", "sort desc", "", new MDataMap());
		StringBuffer str = new StringBuffer();
		if (types != null && !types.isEmpty() && types.size() > 0) {
			for (int i = 0; i < types.size(); i++) {
				if (i == types.size() - 1) {
					str.append("'" + types.get(i).getColumnCode() + "'");
				} else {
					str.append("'" + types.get(i).getColumnCode() + "',");
				}
			}
		}
		if (StringUtils.isNotBlank(str)) {
			MDataMap mDataMap = new MDataMap();
			mDataMap.put("status", "dzsd4699100110010001");
			List<CnHomeItem> items = JdbcHelper.queryForList(CnHomeItem.class, "",
					" field(code," + str.toString() + ")", " code in(" + str.toString() + ")"
							+ " and  startTime<=NOW() and endTime>=NOW() and status=:status ",
					mDataMap);
			for (int i = 0; i < items.size(); i++) {
				CnHomeItemForApi ia = new CnHomeItemForApi();
				BeanUtils.copyProperties(items.get(i), ia);
				HomePageThird pageSecond = PageModel(ia, width);
				if (pageSecond != null) {
					li.add(pageSecond);
				}
			}
		}
		return li;
	}

	private HomePageThird PageModel(CnHomeItemForApi item, int width) {
		HomePageThird hmp = new HomePageThird();
		hmp.setShowType(item.getType());
		MDataMap map = new MDataMap();
		map.put("itemType", item.getType());
		map.put("itemCode", item.getCode());
		List<CnHomeItemRel> rels = JdbcHelper.queryForList(CnHomeItemRel.class, "", "sort desc,start_time desc,zc desc",
				" itemCode=:itemCode and itemType=:itemType and endTime>=NOW() and startTime<=NOW() ", map);
		StringBuffer str = new StringBuffer();
		Map<String, CnHomeItemRel> extMap = new HashMap<String, CnHomeItemRel>();
		if (rels != null && !rels.isEmpty() && rels.size() > 0) {
			for (int i = 0; i < rels.size(); i++) {
				String contentCode = rels.get(i).getContentCode();
				String matchCode = rels.get(i).getMatchCode();
				String selectCode = StringUtils.isNotBlank(contentCode) ? contentCode : matchCode;
				extMap.put(selectCode, rels.get(i));
				if (i == rels.size() - 1) {
					str.append("'" + selectCode + "'");
				} else {
					str.append("'" + selectCode + "',");
				}
			}
		}
		if (StringUtils.isNotBlank(str)) {
			if ("dzsd4107100110110002".equals(item.getType()) || "dzsd4107100110110003".equals(item.getType())) {// 内容
				item.setJump(new JumpTypeSupport().getData(item.getPiclinkType(), item.getPiclinkContent(),
						item.getPiclinkTitle()));
				hmp.setItem(item);
				List<CnContentBasicinfo> contents = SerializeHelper.convertList(CnContentBasicinfo.class,
						JdbcHelper.dataSqlList("select a.code ,a.cover,author,a.title from "
								+ "(select code ,cover,author,title from cn_content_basicinfo where status='dzsd4699100110010001' and share_scope='dzsd4699100110010001'"
								+ " union all  SELECT code,cover,user_code as author,name as title from cn_match_info where STATUS='dzsd4107100110130002')  a"
								+ " where a.code in(" + str.toString() + ") order by field(code," + str.toString()
								+ ")", null));
				if (contents != null && !contents.isEmpty() && contents.size() > 0) {
					for (int i = 0; i < contents.size(); i++) {
						hmp.getInfos().add(getContent(contents.get(i), extMap, item, width));
					}
				} else {
					hmp = null;
				}
			} else if ("dzsd4107100110110001".equals(item.getType())) {// 推荐图

				List<CnAdvertiseDetail> details = JdbcHelper.queryForList(CnAdvertiseDetail.class, "",
						" field(code," + str.toString() + ")", " code in(" + str.toString() + ")", new MDataMap());
				if (details != null && !details.isEmpty() && details.size() > 0) {
					for (int j = 0; j < details.size(); j++) {
						CnAdvertiseDetail cad = details.get(j);
						AdvertiseDetailForThirdHomePageApi dfa = new AdvertiseDetailForThirdHomePageApi();
						BeanUtils.copyProperties(cad, dfa);
						if (StringUtils.isNotBlank(dfa.getPicUrl()) && width > 0
								&& !"gif".equals(StringUtils.substringAfterLast(dfa.getPicUrl(), "."))) {
							dfa.setPicUrl(ImageHelper.upImageThumbnail(dfa.getPicUrl(), Integer.valueOf(width)));
						}
						if (StringUtils.isNotBlank(extMap.get(cad.getCode()).getCover()) && width > 0
								&& !"gif".equals(StringUtils.substringAfterLast(extMap.get(cad.getCode()).getCover(), "."))) {
							dfa.setDefaultPicUrl(ImageHelper.upImageThumbnail(extMap.get(cad.getCode()).getCover(), Integer.valueOf(width)));
						}
						dfa.setJump(new JumpTypeSupport().getData(cad.getPiclinkType(), cad.getPiclinkContent(),
								cad.getContentTitle()));
						dfa.setLabelName(extMap.get(cad.getCode()).getLabelName());
						dfa.setTitle(extMap.get(cad.getCode()).getTitle());
						if (StringUtils.isNotBlank(extMap.get(cad.getCode()).getAuthor())) {
							dfa.setNick_name(JdbcHelper
									.queryOne(UcUserinfoExt.class, "user_code", extMap.get(cad.getCode()).getAuthor())
									.getNickName());
						}
						hmp.getRecommens().add(dfa);
					}
				}
			}
		}
		return hmp;
	}

	private HomeContent getContent(CnContentBasicinfo info, Map<String, CnHomeItemRel> extMap, CnHomeItemForApi item,
			int width) {
		HomeContent content = new HomeContent();
		info = getSingleTitle(info);
		if (extMap.containsKey(info.getCode()) && StringUtils.isNotBlank(extMap.get(info.getCode()).getTitle())) {
			info.setTitle(extMap.get(info.getCode()).getTitle());
		}
		if (extMap.containsKey(info.getCode()) && StringUtils.isNotBlank(extMap.get(info.getCode()).getCover())) {
			info.setCover(extMap.get(info.getCode()).getCover());
		}
		if (extMap.containsKey(info.getCode()) && StringUtils.isNotBlank(extMap.get(info.getCode()).getAuthor())) {
			info.setAuthor(extMap.get(info.getCode()).getAuthor());
		}
		int wid = (int) ("dzsd4107100110110002".equals(item.getType()) ? Math.ceil(width / 2) : width);
		if (StringUtils.isNotBlank(info.getCover()) && wid > 0
				&& !"gif".equals(StringUtils.substringAfterLast(info.getCover(), "."))) {
			info.setCover(ImageHelper.upImageThumbnail(info.getCover(), Integer.valueOf(wid)));
		}
		content.setTitle(StringUtils.isEmpty(info.getTitle()) ? "" : EmojiUtil.emojiRecovery(info.getTitle()));
		content.setCover(info.getCover());
		if (StringUtils.isNotBlank(info.getAuthor())) {
			String nickName = JdbcHelper.queryOne(UcUserinfoExt.class, "user_code", info.getAuthor()).getNickName();
			content.setNickName(StringUtils.isEmpty(nickName) ? "" : EmojiUtil.emojiRecovery(nickName));
		}
		if (info.getCode().contains(Start)) {
			content.setJump(new JumpTypeSupport().getData("dzsd4107100110150001", info.getCode(), info.getTitle()));
		} else {
			content.setJump(new JumpTypeSupport().getData("dzsd4107100110150005", info.getCode(), info.getTitle()));
		}
		return content;
	}

	/**
	 * 单图模式标题处理
	 * 
	 * @return
	 */
	private CnContentBasicinfo getSingleTitle(CnContentBasicinfo ci) {
		if (ci.getCode().contains(Start) && "dzsd4107100110030004".equals(ci.getContentType())) {
			CnContentDetail detail = JdbcHelper.queryOne(CnContentDetail.class, "code", ci.getCode());
			if (detail != null && StringUtils.isNotBlank(detail.getContent())) {
				ci.setTitle(detail.getContent());
			}
		}
		return ci;
	}

}
