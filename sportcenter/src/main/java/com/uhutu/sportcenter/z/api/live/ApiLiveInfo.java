package com.uhutu.sportcenter.z.api.live;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.dcom.content.z.properties.ConfigDcomContent;
import com.uhutu.dcom.content.z.properties.SettingsDcomContent;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.sportcenter.z.input.ApiLiveInfoInput;
import com.uhutu.sportcenter.z.result.ApiLiveInfoResult;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;

import io.swagger.annotations.ApiModel;

/**
 * H5旁路及app原生直播所需参数
 * 
 * @author xiegj
 *
 */
@ApiModel
@Component
public class ApiLiveInfo extends RootApiBase<ApiLiveInfoInput, ApiLiveInfoResult> {

	@Override
	protected ApiLiveInfoResult process(ApiLiveInfoInput input) {

		ApiLiveInfoResult result = new ApiLiveInfoResult();
		if (StringUtils.isNotBlank(input.getContentCode())) {
			CnContentBasicinfo basicinfo = JdbcHelper.queryOne(CnContentBasicinfo.class, "code",
					input.getContentCode());
			if (basicinfo != null && StringUtils.isNotBlank(basicinfo.getAuthor())) {
				CnLiveVideoDetail detail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "", "zc desc",
						" user_code=:userCode", MapHelper.initMap("userCode", basicinfo.getAuthor()));
				result.setDetail(detail);
				if (detail != null) {
					SettingsDcomContent dcomContent = ConfigDcomContent.upConfig();
					result.setAppId(dcomContent.getLiveAppId());
				}
				UcUserinfoExt ext = JdbcHelper.queryOne(UcUserinfoExt.class, "user_code", basicinfo.getAuthor());
				UcUserinfo info = JdbcHelper.queryOne(UcUserinfo.class, "code", basicinfo.getAuthor());
				if (ext != null && info != null) {
					result.getUserBasicInfo().setAboutHead(ext.getAboutHead());
					result.getUserBasicInfo().setNickName(ext.getNickName());
					result.getUserBasicInfo().setTitle(ext.getTitle());
					result.getUserBasicInfo().setType(info.getType());
					result.getUserBasicInfo().setUserCode(ext.getUserCode());
				}
			}

		}
		return result;
	}

}
