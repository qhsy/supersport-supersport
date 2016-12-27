package com.uhutu.sportcenter.z.api.util;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentDetail;
import com.uhutu.sportcenter.z.entity.JumpTypeData;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 新首页数据支撑类
 * 
 * @author xiegj
 *
 */
public class JumpTypeSupport {
	public final static String Type_Content = "dzsd4107100110150001";
	public final static String Type_Person = "dzsd4107100110150002";
	public final static String Type_Url = "dzsd4107100110150003";
	public final static String Type_Label = "dzsd4107100110150004";
	public final static String Type_Match = "dzsd4107100110150005";

	public final static String Content_Type_Href = "dzsd4107100110030006";

	/**
	 * 
	 * @param jumpType
	 *            跳转类型
	 * @param jumpContent
	 *            跳转参数
	 * @param jumpTitle
	 *            跳转后标题
	 * @return
	 */
	public JumpTypeData getData(String jumpType, String jumpContent, String jumpTitle) {
		JumpTypeData result = new JumpTypeData();
		if (jumpType != null && jumpType.equals(Type_Content)) {
			if (StringUtils.isNotBlank(jumpContent)) {
				CnContentBasicinfo cb = JdbcHelper.queryOne(CnContentBasicinfo.class, "code", jumpContent);
				if (cb != null) {
					result.setContentType(cb.getContentType());
					if (Content_Type_Href.equals(cb.getContentType())) {
						CnContentDetail contentDetail = JdbcHelper.queryOne(CnContentDetail.class, "code", jumpContent);
						if (contentDetail != null) {
							result.setUrl(contentDetail.getVideoUrl());
						}
					}
				}
			}
		} else {
			result.setJumpType(jumpType != null ? jumpType : "");
			result.setJumpContent(jumpContent != null ? jumpContent : "");
			result.setJumpTitle(jumpTitle != null ? jumpTitle : "");
		}

		return result;
	}

}
