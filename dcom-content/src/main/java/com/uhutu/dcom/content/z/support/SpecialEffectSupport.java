package com.uhutu.dcom.content.z.support;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.content.z.entity.CnLiveInfo;
import com.uhutu.dcom.content.z.entity.CnLiveSpecialEffectForApi;
import com.uhutu.dcom.content.z.entity.CnLiveSpecialEffectFree;
import com.uhutu.dcom.content.z.entity.CnLiveSpecialEffectFreeLog;
import com.uhutu.dcom.content.z.entity.CnLiveSpecialEffectRel;
import com.uhutu.dcom.content.z.entity.CnLiveUserSpecialEffect;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 特效信息support
 * 
 * @author xiegj
 *
 */
public class SpecialEffectSupport {

	private static SpecialEffectSupport support = null;

	public static SpecialEffectSupport Instance() {
		if (support == null) {
			support = new SpecialEffectSupport();
		}
		return support;
	}

	private static final String TypeRegister = "dzsd4107100110210001";// 用户注册
	private static final String TypeStartApp = "dzsd4107100110210002";// 每日启动app
	private static final String TypeChooseCamp = "dzsd4107100110210003";// 直播选择阵营

	/**
	 * 赠送特效
	 * 
	 * @param type
	 *            赠送类型 dzsd4107100110210001:用户注册 dzsd4107100110210002:每日开启APP
	 *            dzsd4107100110210003:直播选择阵营
	 * @param code
	 *            赠送参数编号(启动startApp,注册：register,直播间编号)
	 * 
	 */
	public void saveSpecialEffect(String type, String code, String userCode) {
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(code)) {
			List<CnLiveSpecialEffectFree> frees = JdbcHelper.queryForList(CnLiveSpecialEffectFree.class, "", "",
					"num>0 and zs_type=:zsType and se_code in (select code from cn_live_special_effect where status=:status)",
					MapHelper.initMap("zsType", type, "status", "dzsd4107100110200001"));// 是否有可送的启用状态的特效
			if (frees != null && !frees.isEmpty()) {
				List<CnLiveSpecialEffectFreeLog> logs = null;
				if (TypeRegister.equals(type) || TypeChooseCamp.equals(type)) {// 注册和直播选择阵营
					logs = JdbcHelper.queryForList(CnLiveSpecialEffectFreeLog.class, "", "",
							"zs_type=:zsType and user_code=:userCode and param=:param",
							MapHelper.initMap("zsType", type, "userCode", userCode, "param", code));
				} else if (TypeStartApp.equals(type)) {
					logs = JdbcHelper.queryForList(CnLiveSpecialEffectFreeLog.class, "", "",
							"zs_type=:zsType and user_code=:userCode and param=:param and zc like '"
									+ DateHelper.upDate(new Date(), "yyyy-MM-dd") + "%'",
							MapHelper.initMap("zsType", type, "userCode", userCode, "param", code));
				}
				if (logs == null || logs.isEmpty()) {
					insertSpecialEffect(frees, code, userCode);
				}
			}
		} else if (StringUtils.isBlank(type) && StringUtils.isNotBlank(code)) {// 直播间内临时送的特效
			CnLiveInfo info = JdbcHelper.queryOne(CnLiveInfo.class, "code", code);
			if (info != null) {
				List<CnLiveSpecialEffectRel> rels = JdbcHelper.queryForList(CnLiveSpecialEffectRel.class, "", "",
						"code=:code and game_code in (select code from cn_live_special_effect where status=:status)",
						MapHelper.initMap("code", code, "status", "dzsd4107100110200001"));
				insertTemporarySpecialEffect(rels, code, userCode);
			}
		}
	}

	/**
	 * 直播间绑定临时赠送特效
	 * 
	 * @param rels
	 *            临时赠送特效
	 * @param code
	 *            直播编号
	 * @param userCode
	 *            用户编号
	 */
	private void insertTemporarySpecialEffect(List<CnLiveSpecialEffectRel> rels, String code, String userCode) {
		List<CnLiveUserSpecialEffect> effects = JdbcHelper.queryForList(CnLiveUserSpecialEffect.class, "", "", "",
				MapHelper.initMap("userCode", userCode, "param", code));
		if ((effects == null || effects.isEmpty()) && rels != null && !rels.isEmpty()) {
			for (int j = 0; j < rels.size(); j++) {
				CnLiveUserSpecialEffect specialEffect = new CnLiveUserSpecialEffect();
				specialEffect.setNum(rels.get(j).getNum());
				specialEffect.setSeCode(rels.get(j).getGameCode());
				specialEffect.setUserCode(userCode);
				specialEffect.setParam(code);
				JdbcHelper.insert(specialEffect);
			}
		}
	}

	/**
	 * 特效保存
	 * 
	 * @param frees
	 *            可以赠送的特效列表
	 * 
	 * @param code
	 *            赠送参数编号(启动startApp,注册：register,直播间编号)
	 * 
	 */
	private void insertSpecialEffect(List<CnLiveSpecialEffectFree> frees, String code, String userCode) {
		List<CnLiveUserSpecialEffect> ses = JdbcHelper.queryForList(CnLiveUserSpecialEffect.class, "", "",
				"user_code=:userCode and (param='' or param is NULL) ", MapHelper.initMap("userCode", userCode));// 用户已存在的特效
		for (int i = 0; i < frees.size(); i++) {
			CnLiveSpecialEffectFree free = frees.get(i);
			boolean flag = false;
			CnLiveUserSpecialEffect specialEffect = null;
			for (int j = 0; j < ses.size(); j++) {// 已存在此种特效
				if (ses.get(j).getSeCode().equals(free.getSeCode())) {
					specialEffect = ses.get(j);
					specialEffect.setNum(specialEffect.getNum() + free.getNum());
					JdbcHelper.update(specialEffect, "num", "za");
					flag = true;
				}
			}
			if (!flag) {// 未存在的特效
				specialEffect = new CnLiveUserSpecialEffect();
				specialEffect.setNum(free.getNum());
				specialEffect.setSeCode(free.getSeCode());
				specialEffect.setUserCode(userCode);
				JdbcHelper.insert(specialEffect);
				flag = true;
			}
			if (flag) {// 记录日志
				insertSpecialEffectLog(free, userCode, code);
			}
		}
	}

	/**
	 * 记录赠送特效日志
	 */
	private void insertSpecialEffectLog(CnLiveSpecialEffectFree free, String userCode, String param) {
		CnLiveSpecialEffectFreeLog log = new CnLiveSpecialEffectFreeLog();
		log.setUserCode(userCode);
		log.setSeCode(free.getSeCode());
		log.setNum(free.getNum());
		log.setZsType(free.getZsType());
		log.setParam(param);
		JdbcHelper.insert(log);
	}

	/**
	 * 查询特效
	 * 
	 * @param code
	 *            直播编号
	 * @param userCode
	 *            用户编号
	 * 
	 */
	public List<CnLiveSpecialEffectForApi> getSpecialEffects(String code, String userCode) {
		List<CnLiveSpecialEffectForApi> result = null;
		if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(userCode)) {
			String sql = "select a.se_code,SUM(a.num) as num,b.name,b.type "
					+ " from cn_live_user_special_effect a,cn_live_special_effect b,cn_live_special_effect_rel c "
					+ " where a.se_code=b.code and a.se_code=c.game_code and c.code=:code "
					+ "and a.user_code=:userCode and b.status=:status " + "GROUP BY a.se_code  ORDER BY c.sort desc";
			List<Map<String, Object>> list = JdbcHelper.dataSqlList(sql,
					MapHelper.initMap("userCode", userCode, "status", "dzsd4107100110200001", "code", code));
			if (list != null && !list.isEmpty()) {
				result = new ArrayList<CnLiveSpecialEffectForApi>();
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> map = list.get(i);
					CnLiveSpecialEffectForApi effectForApi = new CnLiveSpecialEffectForApi();
					effectForApi.setCode(map.get("se_code").toString());
					effectForApi.setName(map.get("name").toString());
					effectForApi.setNum(Integer.valueOf(map.get("num").toString()));
					effectForApi.setType(map.get("type").toString());
					result.add(effectForApi);
				}
			}
		}
		return result;
	}

	/**
	 * 使用特效
	 * 
	 * @param code
	 *            直播间编号
	 * @param seCode
	 *            特效编号
	 * 
	 */
	public void useSpecialEffect(String code, String seCode, String userCode, long num) {
		List<CnLiveUserSpecialEffect> effects = JdbcHelper.queryForList(CnLiveUserSpecialEffect.class, "", "", "",
				MapHelper.initMap("seCode", seCode, "userCode", userCode));
		if (effects != null && !effects.isEmpty() && num > 0) {
			List<CnLiveUserSpecialEffect> update = new ArrayList<CnLiveUserSpecialEffect>();
			for (int i = 0; i < effects.size(); i++) {// 扣减临时赠送特效
				CnLiveUserSpecialEffect effect = effects.get(i);
				if (StringUtils.isNotBlank(effect.getParam()) && effect.getNum() > 0) {
					if (num > effect.getNum()) {
						num = num - effect.getNum();
						effect.setNum(0);
					} else if (num <= effect.getNum()) {
						effect.setNum(effect.getNum() - num);
						num = 0;
					}
					update.add(effect);
				}
			}
			if (num > 0) {
				for (int j = 0; j < effects.size(); j++) {// 扣减长期赠送特效
					if (StringUtils.isBlank(effects.get(j).getParam()) && effects.get(j).getNum() > 0) {
						CnLiveUserSpecialEffect effect = effects.get(j);
						if (num > effect.getNum()) {
							num = num - effect.getNum();
							effect.setNum(0);
						} else if (num <= effect.getNum()) {
							effect.setNum(effect.getNum() - num);
							num = 0;
						}
						update.add(effect);
					}
				}
			}
			for (int i = 0; i < update.size(); i++) {
				JdbcHelper.update(update.get(i), "num", "za");
			}
		}

	}

}
