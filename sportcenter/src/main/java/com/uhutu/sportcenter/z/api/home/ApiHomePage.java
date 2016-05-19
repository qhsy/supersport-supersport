package com.uhutu.sportcenter.z.api.home;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.service.ContentBasicinfoServiceFactory;
import com.uhutu.dcom.content.z.service.ContentDetailServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.entity.AdvertiseMent;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.entity.HomePageModel;
import com.uhutu.sportcenter.z.entity.UserinfoExtForApi;
import com.uhutu.sportcenter.z.input.ApiHomePageInput;
import com.uhutu.sportcenter.z.result.ApiHomePageResult;
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

		int firstIndex = (input.getPagination() - 1) * 10;
		int toIndex = input.getPagination() * 10;
		if (toIndex > basicinfos.size()) {
			toIndex = basicinfos.size();
		}
		result.setNextflag(basicinfos.size() > toIndex);
		if (firstIndex > toIndex) {
			firstIndex = 0;
			toIndex = 0;
		}
		basicinfos = basicinfos.subList(firstIndex, toIndex);
		if (basicinfos != null && !basicinfos.isEmpty() && basicinfos.size() > 0) {
			for (int i = 0; i < basicinfos.size(); i++) {
				HomePageModel hmp = new HomePageModel();
				CnContentBasicinfo info = basicinfos.get(i);
				ContentBasicinfoForApi infoApi = new ContentBasicinfoForApi();
				UserinfoExtForApi userInfoApi = new UserinfoExtForApi();
				if (StringUtils.isNotBlank(info.getAuthor())) {
					UcUserinfoExt ext = userInfoSupport.getUserBasicInfo(info.getAuthor()).getUcUserinfoExt();
					if (ext == null) {
						continue;
					}
					BeanUtils.copyProperties(userInfoSupport.getUserBasicInfo(info.getAuthor()).getUcUserinfoExt(),
							userInfoApi);
				}
				BeanUtils.copyProperties(info, infoApi);
				infoApi.setNickName(userInfoApi.getNickName());
				infoApi.setAboutHead(userInfoApi.getAboutHead());
				hmp.setInfo(infoApi);
				hmp.setUe(userInfoApi);
				result.getList().add(hmp);
			}
		}
		result.setAdv(am);
		return result;
	}
}
