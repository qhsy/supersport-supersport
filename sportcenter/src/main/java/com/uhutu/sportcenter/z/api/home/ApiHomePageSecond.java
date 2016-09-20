package com.uhutu.sportcenter.z.api.home;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.entity.CnContentItem;
import com.uhutu.dcom.content.z.entity.CnHomeNavMenu;
import com.uhutu.sportcenter.z.entity.AdvertiseMent;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.entity.HomePageSecond;
import com.uhutu.sportcenter.z.input.ApiHomePageSecondInput;
import com.uhutu.sportcenter.z.result.ApiHomePageSecondResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 新首页
 * 
 * @author xiegj
 */
@Service
public class ApiHomePageSecond extends RootApiBase<ApiHomePageSecondInput, ApiHomePageSecondResult> {

//	@Autowired
//	private UserInfoSupport userInfoSupport;

	protected ApiHomePageSecondResult process(ApiHomePageSecondInput input) {
		ApiHomePageSecondResult result = new ApiHomePageSecondResult();
		
		HomePageSecond adv = new HomePageSecond();
		adv.setShowType("dzsd4107100110060001");//轮播广告
		adv.setAdv(new AdvertiseMent());
		HomePageSecond nav = new HomePageSecond();
		nav.setShowType("dzsd4107100110060009");//导航栏
		nav.setNavs(new ArrayList<CnHomeNavMenu>());
		HomePageSecond one = new HomePageSecond();
		one.setShowType("dzsd4107100110060005");//一栏内容
		one.setItem(new CnContentItem());
		one.setInfos(new ArrayList<ContentBasicinfoForApi>());
		HomePageSecond advd = new HomePageSecond();
		advd.setShowType("dzsd4107100110060002");//单图广告
		advd.setAdv(new AdvertiseMent());
		HomePageSecond twoone = new HomePageSecond();
		twoone.setShowType("dzsd4107100110060006");
		twoone.setItem(new CnContentItem());
		twoone.setInfos(new ArrayList<ContentBasicinfoForApi>());
		HomePageSecond twotwo = new HomePageSecond();
		twotwo.setShowType("dzsd4107100110060007");
		twotwo.setItem(new CnContentItem());
		twotwo.setInfos(new ArrayList<ContentBasicinfoForApi>());
		HomePageSecond three = new HomePageSecond();
		three.setShowType("dzsd4107100110060008");
		three.setItem(new CnContentItem());
		three.setInfos(new ArrayList<ContentBasicinfoForApi>());
		result.getList().add(adv);
		result.getList().add(nav);
		result.getList().add(one);
		result.getList().add(advd);
		result.getList().add(twoone);
		result.getList().add(twotwo);
		result.getList().add(three);
		
		return result;
	}
}
