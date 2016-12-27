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
import com.uhutu.dcom.content.z.entity.CnContentReadCount;
import com.uhutu.dcom.content.z.entity.CnHomeItem;
import com.uhutu.dcom.content.z.entity.CnHomeItemRel;
import com.uhutu.dcom.content.z.entity.CnHomeType;
import com.uhutu.dcom.content.z.entity.CnSupportPraise;
import com.uhutu.dcom.remark.z.entity.CnContentRemark;
import com.uhutu.dcom.user.z.entity.UserBasicInfo;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.entity.AdvertiseDetailForThirdHomePageApi;
import com.uhutu.sportcenter.z.entity.CnHomeItemForApi;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.entity.HomePageThird;
import com.uhutu.sportcenter.z.entity.UserinfoExtForApi;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 新首页数据支撑类
 * 
 * @author xiegj
 *
 */
public class HomePageThirdSupport {
	private UserInfoSupport userInfoSupport;

	public HomePageThirdSupport(UserInfoSupport userInfoSupport) {
		this.userInfoSupport = userInfoSupport;
	}

	public List<HomePageThird> getPageModels(int width, String token) {
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
				HomePageThird pageSecond = PageModel(ia, width, token);
				if (pageSecond != null) {
					li.add(pageSecond);
				}
			}
		}
		return li;
	}

	private HomePageThird PageModel(CnHomeItemForApi item, int width, String token) {
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
				extMap.put(rels.get(i).getContentCode(), rels.get(i));
				if (i == rels.size() - 1) {
					str.append("'" + rels.get(i).getContentCode() + "'");
				} else {
					str.append("'" + rels.get(i).getContentCode() + "',");
				}
			}
		}
		if (StringUtils.isNotBlank(str)) {
			if ("dzsd4107100110110002".equals(item.getType()) || "dzsd4107100110110003".equals(item.getType())) {// 内容
				item.setJump(new JumpTypeSupport().getData(item.getPiclinkType(), item.getPiclinkContent(),
						item.getPiclinkTitle()));
				hmp.setItem(item);
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
						hmp.getInfos().add(getSingleTitle(getBasicInfo(infos.get(i), extMap, item, width, token)));
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
						dfa.setJump(new JumpTypeSupport().getData(cad.getPiclinkType(), cad.getPiclinkContent(),
								cad.getContentTitle()));
						dfa.setLabelName(extMap.get(cad.getCode()).getLabelName());
						dfa.setTitle(extMap.get(cad.getCode()).getTitle());
						if (StringUtils.isNotBlank(extMap.get(cad.getCode()).getAuthor())) {
							dfa.setUserBasicInfo(getUserInfo(extMap.get(cad.getCode()).getAuthor()));
						}
						hmp.getRecommens().add(dfa);
					}
				}
			}
		}
		return hmp;
	}

	public UserInfoSupport getUserInfoSupport() {
		return userInfoSupport;
	}

	public void setUserInfoSupport(UserInfoSupport userInfoSupport) {
		this.userInfoSupport = userInfoSupport;
	}

	private ContentBasicinfoForApi getBasicInfo(CnContentBasicinfo info, Map<String, CnHomeItemRel> extMap,
			CnHomeItemForApi item, int width, String token) {
		ContentBasicinfoForApi infoApi = new ContentBasicinfoForApi();
		UserinfoExtForApi userInfoApi = getUserInfo(info.getAuthor());
		if (extMap.containsKey(info.getCode())) {
			info.setTitle(extMap.get(info.getCode()).getTitle());
		}
		if (extMap.containsKey(info.getCode())) {
			info.setCover(extMap.get(info.getCode()).getCover());
		}
		int wid = (int) (("dzsd4107100110060006".equals(item.getType())
				|| "dzsd4107100110060007".equals(item.getType())) ? Math.ceil(width / 2)
						: ("dzsd4107100110060008".equals(item.getType()) ? Math.ceil(width) / 3 : width));
		if (StringUtils.isNotBlank(info.getCover()) && wid > 0) {
			info.setCover(ImageHelper.upImageThumbnail(info.getCover(), Integer.valueOf(wid)));
		}
		BeanUtils.copyProperties(info, infoApi);
		CnContentDetail contentDetail = JdbcHelper.queryOne(CnContentDetail.class, "code", info.getCode());
		if (contentDetail != null) {
			infoApi.setContentDetail(contentDetail);
		}
		int praiseNum = JdbcHelper.count(CnSupportPraise.class, "",
				MapHelper.initMap("content_code", infoApi.getCode(), "type", "01", "status", "1"));
		infoApi.setPraiseNum(praiseNum);
		CnContentReadCount contentReadCount = JdbcHelper.queryOne(CnContentReadCount.class, "contentCode",
				infoApi.getCode());
		infoApi.setReadNum(contentReadCount != null ? contentReadCount.getCount() : 0);
		int remarkNum = JdbcHelper.count(CnContentRemark.class, "",
				MapHelper.initMap("content_code", infoApi.getCode(), "status", "dzsd4699100110010001"));
		infoApi.setRemarkNum(remarkNum);
		infoApi.setFavorFlag(ContentComponent.lightFavor(infoApi.getCode(), token));
		infoApi.getUserBasicInfo().setNickName(userInfoApi.getNickName());
		infoApi.getUserBasicInfo().setAboutHead(userInfoApi.getAboutHead());
		infoApi.getUserBasicInfo().setType(userInfoApi.getType());
		String title = infoApi.getTitle();
		title = StringUtils.isEmpty(title) ? "" : EmojiUtil.emojiRecovery(title);
		infoApi.setTitle(title);
		return infoApi;
	}

	/**
	 * 单图模式标题处理
	 * 
	 * @return
	 */
	private ContentBasicinfoForApi getSingleTitle(ContentBasicinfoForApi cff) {
		if ("dzsd4107100110030004".equals(cff.getContentType())) {
			CnContentDetail detail = JdbcHelper.queryOne(CnContentDetail.class, "code", cff.getCode());
			if (detail != null && StringUtils.isNotBlank(detail.getContent())) {
				cff.setTitle(detail.getContent());
			}
		}
		return cff;
	}

	private UserinfoExtForApi getUserInfo(String userCode) {
		UserinfoExtForApi userInfoApi = new UserinfoExtForApi();
		if (StringUtils.isNotBlank(userCode)) {
			UserBasicInfo info = userInfoSupport.getUserBasicInfo(userCode);
			if (info.getUcUserinfoExt() == null) {
				return null;
			}
			BeanUtils.copyProperties(info.getUcUserinfoExt(), userInfoApi);
			if (info.getUcUserinfo() != null) {
				userInfoApi.setType(info.getUcUserinfo().getType());
			}
		}
		return userInfoApi;
	}
}
