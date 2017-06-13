package com.uhutu.dcom.content.z.support;

import java.util.List;

import com.uhutu.dcom.content.z.entity.CnLiveSpecialEffectForApi;

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

	/**
	 * 赠送特效
	 * 
	 * @param type
	 *            赠送类型 dzsd4107100110210001:用户注册 dzsd4107100110210002:每日开启APP
	 *            dzsd4107100110210003:直播选择阵营
	 * @param code
	 *            赠送参数编号(启动startApp,注册：register,直播间编号&阵营编号)
	 * 
	 */
	public void saveSpecialEffect(String type, String code) { 

	}

	/**
	 * 查询特效
	 * 
	 * @param code
	 *            直播编号
	 * @param userCode
	 * 			  用户编号
	 * 
	 */
	public List<CnLiveSpecialEffectForApi> getSpecialEffects(String code,String userCode) {
		
		
		return null;
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
	public void useSpecialEffect(String code, String seCode) {

	}

}
