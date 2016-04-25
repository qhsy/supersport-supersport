package com.uhutu.sportcenter.api;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.service.ContentBasicinfoServiceFactory;
import com.uhutu.dcom.content.service.ContentDetailServiceFactory;
import com.uhutu.dcom.user.support.UserInfoSupport;
import com.uhutu.sportcenter.api.entity.AdvertiseMent;
import com.uhutu.sportcenter.api.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.api.entity.HomePageModel;
import com.uhutu.sportcenter.api.entity.UserinfoExtForApi;
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

		int firstIndex = (input.getPageNum() - 1) * 10;
		int toIndex = input.getPageNum() * 10;
		if (toIndex > basicinfos.size()) {
			toIndex = basicinfos.size();
		}
		result.setNextflag(basicinfos.size() > toIndex);
		if(firstIndex>toIndex){firstIndex=0;toIndex=0;}
		basicinfos = basicinfos.subList(firstIndex, toIndex);
		if (basicinfos != null && !basicinfos.isEmpty() && basicinfos.size() > 0) {
			for (int i = 0; i < basicinfos.size(); i++) {
				HomePageModel hmp = new HomePageModel();
				CnContentBasicinfo info = basicinfos.get(i);
				ContentBasicinfoForApi infoApi = new ContentBasicinfoForApi();
				UserinfoExtForApi userInfoApi = new UserinfoExtForApi();
				if (StringUtils.isNotBlank(info.getAuthor())) {
					BeanUtils.copyProperties(userInfoSupport.getUserBasicInfo(info.getAuthor()).getUcUserinfoExt(),
							userInfoApi);
				}
				BeanUtils.copyProperties(info, infoApi);
				hmp.setInfo(infoApi);
				hmp.setUe(userInfoApi);
				result.getList().add(hmp);
			}
		}
		result.setAdv(am);
		return result;
	}
}
