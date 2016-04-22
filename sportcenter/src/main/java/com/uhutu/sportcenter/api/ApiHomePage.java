package com.uhutu.sportcenter.api;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.service.ContentBasicinfoServiceFactory;
import com.uhutu.dcom.content.service.ContentDetailServiceFactory;
import com.uhutu.dcom.user.entity.UcUserinfoExt;
import com.uhutu.dcom.user.support.UserInfoSupport;
import com.uhutu.sportcenter.api.entity.AdvertiseMent;
import com.uhutu.sportcenter.api.entity.HomePageModel;
import com.uhutu.sportcenter.api.input.ApiHomePageInput;
import com.uhutu.sportcenter.api.result.ApiHomePageResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 首页
 * 
 * @author Administrator
 */
@Service
public class ApiHomePage extends RootApiBase<ApiHomePageInput, ApiHomePageResult> {

	@Autowired
	ContentBasicinfoServiceFactory basicinfoServiceFactory;

	@Autowired
	ContentDetailServiceFactory detailServiceFactory;

	@Autowired
	private UserInfoSupport userInfoSupport;

	protected ApiHomePageResult process(ApiHomePageInput input) {
		AdvertiseMent am = new AdvertiseMent();// 首页广告
		ApiHomePageResult result = new ApiHomePageResult();
		List<CnContentBasicinfo> basicinfos = basicinfoServiceFactory.getContentBasicinfoService().queryAll("1");
		if (basicinfos != null && !basicinfos.isEmpty() && basicinfos.size() > 0) {
			for (int i = 0; i < basicinfos.size(); i++) {
				HomePageModel hmp = new HomePageModel();
				CnContentBasicinfo info = basicinfos.get(i);
				UcUserinfoExt userInfo = new UcUserinfoExt();
				if (StringUtils.isNotBlank(info.getAuthor())) {
					userInfo = userInfoSupport.getUserBasicInfo(info.getAuthor()).getUcUserinfoExt();
				}
				hmp.setInfo(info);
				hmp.setUe(userInfo);
				result.getList().add(hmp);
			}
		}
		result.setAdv(am);
		return result;
	}

}
