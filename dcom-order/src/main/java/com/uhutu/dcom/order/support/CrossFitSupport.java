package com.uhutu.dcom.order.support;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.component.z.hole.ImageCfUtil;
import com.uhutu.dcom.order.enumer.OrderEnum;
import com.uhutu.dcom.order.z.entity.OcOrderDetail;
import com.uhutu.dcom.user.z.entity.UcSignCount;
import com.uhutu.dcom.user.z.entity.UcSignInfo;
import com.uhutu.zoocom.file.FileUploadResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;

public class CrossFitSupport {

	public void crossFitData(String orderCode) {
		if (StringUtils.isNotBlank(orderCode)) {
			OcOrderDetail detail = JdbcHelper.queryOne(OcOrderDetail.class, "code", orderCode);
			if (detail != null) {

				UcSignInfo si = JdbcHelper.queryOne(UcSignInfo.class, "code", detail.getProductCode());
				if ("dzsd4107100510020001".equals(si.getType()) || "dzsd4107100510020002".equals(si.getType())) {
					FileUploadResult ul = ImageCfUtil.makeImagePerson(si.getName(), si.getBoxName(),
							"dzsd4107100510020001".equals(si.getType()) ? "个人标准组" : "个人业余组", si.getCode());
					si.setPicUrl(ul.getFileUrl());
					si.setStatus(OrderEnum.STATUS_PAYED.getCode());
					JdbcHelper.update(si, "status,pic_url", "za");
				} else if ("dzsd4107100510020003".equals(si.getType())) {
					FileUploadResult ul = ImageCfUtil.makeImageGroup(si.getGroupName(), si.getBoxName(), "团队标准组",
							si.getGroupCode());
					MDataMap dataMap = new MDataMap();
					dataMap.put("group_code", si.getGroupCode());
					dataMap.put("status", OrderEnum.STATUS_PAYED.getCode());
					dataMap.put("pic_url", ul.getFileUrl());
					JdbcHelper.dataUpdate("uc_sign_info", dataMap, "status,pic_url", "group_code");
				}
			}
		}
	}

	public List<String> getAlSignType() {
		List<String> list = new ArrayList<String>();
		int alSingle = JdbcHelper.count(UcSignInfo.class,
				" type in ('dzsd4107100510020001','dzsd4107100510020002') and status='dzsd4112100110030002'", null);
		long alGroup = JdbcHelper.queryForList(UcSignInfo.class, "  COUNT(DISTINCT group_code) as time", "",
				" type='dzsd4107100510020003'  and status='dzsd4112100110030002' ", null).get(0).getTime();
		int single = JdbcHelper.queryOne(UcSignCount.class, "type", "dzsd4107100510030001").getCount();
		int group = JdbcHelper.queryOne(UcSignCount.class, "type", "dzsd4107100510030002").getCount();
		if (alSingle >= single) {
			list.add("single");
		}
		if (alGroup > group) {
			list.add("group");
		}
		return list;
	}
}
