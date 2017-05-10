package com.uhutu.sportcenter.z.api.util;

/**
 * 新首页数据支撑类
 * 
 * @author xiegj
 *
 */
public class HomePageSecondSupport {
//	private UserInfoSupport userInfoSupport;
//
//	public HomePageSecondSupport(UserInfoSupport userInfoSupport) {
//		this.userInfoSupport = userInfoSupport;
//	}
//
//	/**
//	 * 单图模式标题处理
//	 * 
//	 * @return
//	 */
//	private ContentBasicinfoForApi getSingleTitle(ContentBasicinfoForApi cff) {
//		if ("dzsd4107100110030004".equals(cff.getContentType())) {
//			CnContentDetail detail = JdbcHelper.queryOne(CnContentDetail.class, "code", cff.getCode());
//			if (detail != null && StringUtils.isNotBlank(detail.getContent())) {
//				cff.setTitle(detail.getContent());
//			}
//		}
//		return cff;
//	}
//
//	public List<HomePageSecond> getPageModels(int width, String token) {
//		List<HomePageSecond> li = new ArrayList<HomePageSecond>();
//		List<CnHomeStyle> styles = JdbcHelper.queryForList(CnHomeStyle.class, "", "sort desc", "", new MDataMap());
//		StringBuffer str = new StringBuffer();
//		if (styles != null && !styles.isEmpty() && styles.size() > 0) {
//			for (int i = 0; i < styles.size(); i++) {
//				if (i == styles.size() - 1) {
//					str.append("'" + styles.get(i).getColumnCode() + "'");
//				} else {
//					str.append("'" + styles.get(i).getColumnCode() + "',");
//				}
//			}
//		}
//		if (StringUtils.isNotBlank(str)) {
//			MDataMap mDataMap = new MDataMap();
//			mDataMap.put("status", "dzsd4699100110010001");
//			List<CnContentItem> items = JdbcHelper.queryForList(CnContentItem.class, "",
//					" field(code," + str.toString() + ")",
//					" code in(" + str.toString() + ")" + " and  startTime<=NOW() and endTime>=NOW() and status=:status "
//							+ "and type in ('dzsd4107100110060001','dzsd4107100110060002','dzsd4107100110060005',"
//							+ "'dzsd4107100110060006','dzsd4107100110060007','dzsd4107100110060008','dzsd4107100110060009') ",
//					mDataMap);
//			for (int i = 0; i < items.size(); i++) {
//				CnContentItemForApi forApi = new CnContentItemForApi();
//				BeanUtils.copyProperties(items.get(i), forApi);
//				HomePageSecond pageSecond = PageModel(forApi, width, token);
//				if (pageSecond != null) {
//					li.add(pageSecond);
//				}
//			}
//		}
//		return li;
//	}
//
//	private HomePageSecond PageModel(CnContentItemForApi item, int width, String token) {
//		HomePageSecond hmp = new HomePageSecond();
//		hmp.setShowType(item.getType());
//		MDataMap map = new MDataMap();
//		map.put("itemType", item.getType());
//		map.put("itemCode", item.getCode());
//		List<CnContentItemRel> rels = JdbcHelper.queryForList(CnContentItemRel.class, "",
//				"sort desc,start_time desc,zc desc",
//				" itemCode=:itemCode and itemType=:itemType and endTime>=NOW() and startTime<=NOW() ", map);
//		StringBuffer str = new StringBuffer();
//		Map<String, String> titleMap = new HashMap<String, String>();
//		Map<String, String> coverMap = new HashMap<String, String>();
//		if (rels != null && !rels.isEmpty() && rels.size() > 0) {
//			for (int i = 0; i < rels.size(); i++) {
//				if (StringUtils.isNotBlank(rels.get(i).getTitle())) {
//					titleMap.put(rels.get(i).getContentCode(), rels.get(i).getTitle());
//				}
//				if (StringUtils.isNotBlank(rels.get(i).getCover())) {
//					coverMap.put(rels.get(i).getContentCode(), rels.get(i).getCover());
//				}
//				if (i == rels.size() - 1) {
//					str.append("'" + rels.get(i).getContentCode() + "'");
//				} else {
//					str.append("'" + rels.get(i).getContentCode() + "',");
//				}
//			}
//		}
//		if (StringUtils.isNotBlank(str)) {
//			if ("dzsd4107100110060006".equals(item.getType()) || "dzsd4107100110060007".equals(item.getType())
//					|| "dzsd4107100110060008".equals(item.getType())) {// 内容
//				if ("dzsd4107100110050002".equals(item.getPiclinkType())
//						&& StringUtils.isNotBlank(item.getPiclinkContent())) {
//					CnContentBasicinfo cbi = JdbcHelper.queryOne(CnContentBasicinfo.class, "code",
//							item.getPiclinkContent());
//					if (cbi != null) {
//						hmp.getItem().setType(cbi.getContentType());
//					}
//					if ("dzsd4107100110030006".equals(cbi.getContentType())||"dzsd4107100110030008".equals(cbi.getContentType())) {
//						CnContentDetail contentDetail = JdbcHelper.queryOne(CnContentDetail.class, "code",
//								item.getPiclinkContent());
//						if (contentDetail != null) {
//							item.setPiclinkContent(contentDetail.getVideoUrl());
//						}
//					}
//				}
//				hmp.setItem(item);
//				List<CnContentBasicinfo> basics = JdbcHelper.queryForList(CnContentBasicinfo.class, "", "",
//						"status='dzsd4699100110010001' and shareScope='dzsd4699100110010001' and code in("
//								+ str.toString() + ")",
//						new MDataMap());
//				List<CnContentBasicinfo> infos = new ArrayList<CnContentBasicinfo>();
//				for (int i = 0; i < rels.size(); i++) {
//					for (int j = 0; j < basics.size(); j++) {
//						if (rels.get(i).getContentCode().equals(basics.get(j).getCode())) {
//							infos.add(basics.get(j));
//						}
//					}
//				}
//				if (infos != null && !infos.isEmpty() && infos.size() > 0) {
//					for (int i = 0; i < infos.size(); i++) {
//						CnContentBasicinfo info = infos.get(i);
//						ContentBasicinfoForApi infoApi = new ContentBasicinfoForApi();
//						UserinfoExtForApi userInfoApi = new UserinfoExtForApi();
//						if (StringUtils.isNotBlank(info.getAuthor())) {
//							UcUserinfoExt ext = userInfoSupport.getUserBasicInfo(info.getAuthor()).getUcUserinfoExt();
//							if (ext == null) {
//								continue;
//							}
//							UserBasicInfo ubi = userInfoSupport.getUserBasicInfo(info.getAuthor());
//							BeanUtils.copyProperties(ubi.getUcUserinfoExt(), userInfoApi);
//							if (ubi.getUcUserinfo() != null) {
//								userInfoApi.setType(ubi.getUcUserinfo().getType());
//							}
//						}
//						if (titleMap.containsKey(info.getCode())) {
//							info.setTitle(titleMap.get(info.getCode()));
//						}
//						if (coverMap.containsKey(info.getCode())) {
//							info.setCover(coverMap.get(info.getCode()));
//						}
//						int wid = (int) (("dzsd4107100110060006".equals(item.getType())
//								|| "dzsd4107100110060007".equals(item.getType())) ? Math.ceil(width / 2)
//										: ("dzsd4107100110060008".equals(item.getType()) ? Math.ceil(width) / 3
//												: width));
//						if (StringUtils.isNotBlank(info.getCover()) && wid > 0) {
//							info.setCover(ImageHelper.upImageThumbnail(info.getCover(), Integer.valueOf(wid)));
//						}
//						BeanUtils.copyProperties(info, infoApi);
//						CnContentDetail contentDetail = JdbcHelper.queryOne(CnContentDetail.class, "code",
//								info.getCode());
//						if (contentDetail != null) {
//							infoApi.setContentDetail(contentDetail);
//						}
//						int praiseNum = JdbcHelper.count(CnSupportPraise.class, "",
//								MapHelper.initMap("content_code", infoApi.getCode(), "type", "01", "status", "1"));
//						infoApi.setPraiseNum(praiseNum);
//						CnContentReadCount contentReadCount = JdbcHelper.queryOne(CnContentReadCount.class,
//								"contentCode", infoApi.getCode());
//						infoApi.setReadNum(contentReadCount != null ? contentReadCount.getCount() : 0);
//						int remarkNum = JdbcHelper.count(CnContentRemark.class, "",
//								MapHelper.initMap("content_code", infoApi.getCode(), "status", "dzsd4699100110010001"));
//						infoApi.setRemarkNum(remarkNum);
//						infoApi.setFavorFlag(ContentComponent.lightFavor(infoApi.getCode(), token));
//						infoApi.getUserBasicInfo().setNickName(userInfoApi.getNickName());
//						infoApi.getUserBasicInfo().setAboutHead(userInfoApi.getAboutHead());
//						infoApi.getUserBasicInfo().setType(userInfoApi.getType());
//
//						String title = infoApi.getTitle();
//
//						title = StringUtils.isEmpty(title) ? "" : EmojiUtil.emojiRecovery(title);
//
//						infoApi.setTitle(title);
//
//						hmp.getInfos().add(getSingleTitle(infoApi));
//					}
//				} else {
//					hmp = null;
//				}
//			} else if ("dzsd4107100110060002".equals(item.getType()) || "dzsd4107100110060005".equals(item.getType())) {// 单图广告&一栏内容
//				hmp.setItem("dzsd4107100110060005".equals(item.getType()) ? item : null);
//				List<CnAdvertiseDetail> details = JdbcHelper.queryForList(CnAdvertiseDetail.class, "",
//						" field(code," + str.toString() + ")", " code in(" + str.toString() + ")", new MDataMap());
//				if (details != null && !details.isEmpty() && details.size() > 0) {
//					for (int i = 0; i < details.size(); i++) {
//						AdvertiseDetailForApi dfa = new AdvertiseDetailForApi();
//						BeanUtils.copyProperties(details.get(i), dfa);
////						if ("dzsd4107100110050002".equals(details.get(i).getPiclinkType())
////								&& StringUtils.isNotBlank(details.get(i).getPiclinkContent())) {
////							CnContentBasicinfo cbi = JdbcHelper.queryOne(CnContentBasicinfo.class, "code",
////									details.get(i).getPiclinkContent());
////							if (cbi != null) {
////								dfa.setType(cbi.getContentType());
////							}
////						}
//						if (titleMap.containsKey(dfa.getCode())) {
//							dfa.setName(titleMap.get(dfa.getCode()));
//						}
//						if (StringUtils.isNotBlank(dfa.getPicUrl()) && width > 0) {
//							dfa.setPicUrl(ImageHelper.upImageThumbnail(dfa.getPicUrl(), Integer.valueOf(width)));
//						}
//						hmp.getAdv().getDetails().add(dfa);
//					}
//				}
//			} else if ("dzsd4107100110060001".equals(item.getType())) {// 轮播广告
//
//				List<CnAdvertiseDetail> details = JdbcHelper.queryForList(CnAdvertiseDetail.class, "",
//						" field(code," + str.toString() + ")", " code in(" + str.toString() + ")", new MDataMap());
//				if (details != null && !details.isEmpty() && details.size() > 0) {
//					for (int j = 0; j < details.size(); j++) {
//						AdvertiseDetailForApi dfa = new AdvertiseDetailForApi();
//						BeanUtils.copyProperties(details.get(j), dfa);
//						if (StringUtils.isNotBlank(dfa.getPicUrl()) && width > 0) {
//							dfa.setPicUrl(ImageHelper.upImageThumbnail(dfa.getPicUrl(), Integer.valueOf(width)));
//						}
////						if ("dzsd4107100110050002".equals(details.get(j).getPiclinkType())
////								&& StringUtils.isNotBlank(details.get(j).getPiclinkContent())) {
////							CnContentBasicinfo cbi = JdbcHelper.queryOne(CnContentBasicinfo.class, "code",
////									details.get(j).getPiclinkContent());
////							if (cbi != null) {
////								dfa.setType(cbi.getContentType());
////							}
////							if ("dzsd4107100110030006".equals(cbi.getContentType())||"dzsd4107100110030008".equals(cbi.getContentType())) {
////								CnContentDetail contentDetail = JdbcHelper.queryOne(CnContentDetail.class, "code",
////										details.get(j).getPiclinkContent());
////								if (contentDetail != null) {
////									dfa.setPiclinkContent(contentDetail.getVideoUrl());
////								}
////							}
////						}
//						hmp.getAdv().getDetails().add(dfa);
//					}
//				}
//			} else if ("dzsd4107100110060009".equals(item.getType())) {// 导航栏
//				List<CnHomeNavMenu> navMenus = JdbcHelper.queryForList(CnHomeNavMenu.class, "",
//						" field(code," + str.toString() + ")", " code in(" + str.toString() + ")", new MDataMap());
//				if (navMenus != null && !navMenus.isEmpty() && navMenus.size() > 0) {
//					for (int i = 0; i < navMenus.size(); i++) {
//						CnHomeNavMenuForApi navMenuForApi = new CnHomeNavMenuForApi();
//						BeanUtils.copyProperties(navMenus.get(i), navMenuForApi);
//						if ("dzsd4107100110050002".equals(navMenuForApi.getPiclinkType())
//								&& StringUtils.isNotBlank(navMenuForApi.getPiclinkContent())) {
//							CnContentBasicinfo cbi = JdbcHelper.queryOne(CnContentBasicinfo.class, "code",
//									navMenuForApi.getPiclinkContent());
//							if (cbi != null) {
//								navMenuForApi.setType(cbi.getContentType());
//							}
//							if ("dzsd4107100110030006".equals(cbi.getContentType())||"dzsd4107100110030008".equals(cbi.getContentType())) {
//								CnContentDetail contentDetail = JdbcHelper.queryOne(CnContentDetail.class, "code",
//										navMenuForApi.getPiclinkContent());
//								if (contentDetail != null) {
//									navMenuForApi.setPiclinkContent(contentDetail.getVideoUrl());
//								}
//							}
//						}
//						hmp.getNavs().add(navMenuForApi);
//					}
//				}
//			}
//		}
//		return hmp;
//	}
//
//	public UserInfoSupport getUserInfoSupport() {
//		return userInfoSupport;
//	}
//
//	public void setUserInfoSupport(UserInfoSupport userInfoSupport) {
//		this.userInfoSupport = userInfoSupport;
//	}
//
}
