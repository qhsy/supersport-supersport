package com.uhutu.sportcenter.z.api.user;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.page.vo.UcUserinfoExtData;
import com.uhutu.sportcenter.z.input.ApiUserDataExpertInput;
import com.uhutu.sportcenter.z.result.ApiUserDataExpertResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 抽奖用户数据
 * 
 * @author xiegj
 *
 */
@Component
public class ApiUserDataExpert extends RootApiBase<ApiUserDataExpertInput, ApiUserDataExpertResult> {

	@Override
	protected ApiUserDataExpertResult process(ApiUserDataExpertInput input) {

		ApiUserDataExpertResult result = new ApiUserDataExpertResult();
		List<UcUserinfoExt> mjList = JdbcHelper.queryForList(UcUserinfoExt.class, "", "",
				" user_code in (select code from uc_userinfo where mj_flag='dzsd4699100110010001') ", new MDataMap());
		for (int i = 0; i < mjList.size(); i++) {
			UcUserinfoExtData data = new UcUserinfoExtData();
			BeanUtils.copyProperties(mjList.get(i), data);
			if (StringUtils.isNotBlank(data.getAboutHead())) {
				data.setAboutHead(ImageHelper.upImageThumbnail(data.getAboutHead(), 160));
			}
			result.getMjUsers().add(data);
		}

		List<UcUserinfoExt> li = JdbcHelper.queryForList(UcUserinfoExt.class, "", "",
				" user_code in (select code from uc_userinfo where mj_flag='dzsd4699100110010002') ", new MDataMap());
		for (int i = 0; i < li.size(); i++) {
			UcUserinfoExtData data = new UcUserinfoExtData();
			BeanUtils.copyProperties(li.get(i), data);
			if (StringUtils.isNotBlank(data.getAboutHead())) {
				data.setAboutHead(ImageHelper.upImageThumbnail(data.getAboutHead(), 160));
			}
			result.getUsers().add(data);
		}
		return result;

	}

}
