package com.uhutu.zoodata.support;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.zoocom.define.DefineZooCom;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.entity.ZdAutoCode;
import com.uhutu.zoodata.z.helper.JdbcHelper;

abstract class DataCodeSupport {

	/**
	 * 获取递增长度
	 * 
	 * @return
	 */
	public abstract int upLength();

	/**
	 * 获取每次增加数
	 * 
	 * @return
	 */
	public abstract int upStep();

	/**
	 * 获取起始编码
	 * 
	 * @return
	 */
	public abstract String upStart();

	/**
	 * 初始化时增加量
	 * 
	 * @return
	 */
	public abstract int upInit();

	public String upCode(String sCode) {

		String sReturn = "";

		synchronized (DataCodeSupport.class) {

			long lValue = 0;

			if (DefineZooCom.CONST_CODE_MAP.containsKey(sCode)) {

				lValue = DefineZooCom.CONST_CODE_MAP.get(sCode) + 1;

				// 如果位数小于 则表示已经加超 则重置
				if (Integer.valueOf(StringUtils.right(String.valueOf(lValue), upLength())) < upStep()) {
					lValue = 0;
				}
				// 如果起始编号和当前日期不一致，则重置
				else if (!StringUtils.startsWith(String.valueOf(lValue), upStart())) {
					lValue = 0;
				}

			}

			if (lValue <= 0) {
				lValue = refreshCode(sCode);
			}
			DefineZooCom.CONST_CODE_MAP.put(sCode, lValue);

			sReturn = sCode + String.valueOf(lValue);
		}
		return sReturn;

	}

	public long refreshCode(String sCode) {

		DataLockSupport dataLockSupport = new DataLockSupport();
		String sCodeStart = upStart();

		String sUq = sCode + "-" + sCodeStart;
		String sLockUid = "";
		// 强制必须锁定才能重置
		while (sLockUid.isEmpty()) {
			sLockUid = dataLockSupport.lockCode(3, sUq);
		}

		ZdAutoCode zdAutoCode = JdbcHelper.queryOne(ZdAutoCode.class, "", "", "code = '"+sUq+"'", new MDataMap());

		if (zdAutoCode == null) {

			zdAutoCode = new ZdAutoCode();
			zdAutoCode.setCode(sUq);
			zdAutoCode.setDateNow(sCodeStart);
			zdAutoCode.setDataStep(upStep());
			zdAutoCode.setCurrentValue(upInit() + upStep());
			JdbcHelper.insert(zdAutoCode);

		} else {

			int iStart = (int) (Math.ceil(zdAutoCode.getCurrentValue() / (Math.pow(10, upLength()))));

			zdAutoCode.setCurrentValue(Long.parseLong(String.valueOf(iStart) + String.valueOf(upStep())));

			JdbcHelper.update(zdAutoCode, "dateNow,currentValue", "");
		}

		dataLockSupport.unLockCode(sLockUid);

		return Long.parseLong(sCodeStart + String.valueOf(zdAutoCode.getCurrentValue()));
	}

}
