package com.uhutu.sportcenter.z.api.live;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentDetail;
import com.uhutu.dcom.content.z.entity.CnContentWorth;
import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.dcom.content.z.entity.CnRedPackUser;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.properties.ConfigDcomContent;
import com.uhutu.dcom.content.z.properties.SettingsDcomContent;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.sportcenter.z.entity.RedPackUserForApi;
import com.uhutu.sportcenter.z.input.ApiStartLiveInput;
import com.uhutu.sportcenter.z.result.ApiStartLiveResult;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.WebHelper;

import io.swagger.annotations.ApiModel;

/**
 * 开始直播
 * 
 * @author 逄小帅
 *
 */
@ApiModel
@Component
public class ApiStartLive extends RootApiToken<ApiStartLiveInput, ApiStartLiveResult> {

	@Autowired
	private ContentServiceFactory contentServiceFactory;

	@Override
	protected ApiStartLiveResult process(ApiStartLiveInput input) {

		ApiStartLiveResult startLiveResult = new ApiStartLiveResult();

		MDataMap mWhereMap = new MDataMap();

		mWhereMap.put("code", input.getCode());

		mWhereMap.put("chatCode", input.getChatCode());

		mWhereMap.put("status", ContentEnum.LIVEING.getCode());

		int count = JdbcHelper.count(CnLiveVideoDetail.class, "", mWhereMap);
		CnLiveVideoDetail detail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "", "zc desc ",
				"code=:code and chat_code=:chatCode and status=:status", mWhereMap);
		if (count > 0) {

			startLiveResult.setError("此房间正在直播中");

			startLiveResult.setStatus(-1);
			startLiveResult.setContentCode(detail.getContentCode());
		} else {

			CnLiveVideoDetail liveVideoDetail = new CnLiveVideoDetail();

			BeanUtils.copyProperties(input, liveVideoDetail);

			liveVideoDetail.setUserCode(upUserCode());

			liveVideoDetail.setStatus(ContentEnum.LIVEING.getCode());

			liveVideoDetail.setCreateTime(DateHelper.upDate(new Date()));

			/* 根据产品需求添加 */
			String contentCode = updateContent(liveVideoDetail);

			liveVideoDetail.setContentCode(contentCode);
			startLiveResult.setContentCode(contentCode);
			SettingsDcomContent dcomContent = ConfigDcomContent.upConfig();
			liveVideoDetail.setWatchConstant(Integer.valueOf(dcomContent.getLiveAppWatchConstant()));
			liveVideoDetail.setPraiseConstant(Integer.valueOf(dcomContent.getLiveAppPraiseConstant()));
			liveVideoDetail.setBusiCode(WebHelper.upCode("LVEY"));
			JdbcHelper.insert(liveVideoDetail);
			savePackUser(liveVideoDetail.getBusiCode(), input.getUsers());
			updateContentWorth(contentCode);

		}

		return startLiveResult;
	}

	/**
	 * 接受打赏人
	 */
	private void savePackUser(String busiCode, List<RedPackUserForApi> users) {
		if (users != null && users.size() > 0) {
			for (int i = 0; i < users.size(); i++) {
				CnRedPackUser user = new CnRedPackUser();
				RedPackUserForApi packUserForApi = users.get(i);
				BeanUtils.copyProperties(packUserForApi, user);
				user.setBusiCode(busiCode);
				user.setStatus("0");
				JdbcHelper.insert(user);
			}
		}

	}

	/**
	 * 直播详情
	 * 
	 * @param liveVideoDetail
	 */
	public String updateContent(CnLiveVideoDetail liveVideoDetail) {

		CnContentBasicinfo basicinfo = new CnContentBasicinfo();

		basicinfo.setAuthor(upUserCode());

		basicinfo.setBusiType(ContentEnum.article.getCode());

		basicinfo.setContentType(ContentEnum.TYPE_LIVE.getCode());

		basicinfo.setCover(liveVideoDetail.getCover());

		if (StringUtils.isNotBlank(liveVideoDetail.getAddressName())) {

			basicinfo.setLocaltionName(liveVideoDetail.getAddressName());

		}

		if (StringUtils.isNotBlank(liveVideoDetail.getLatitude())
				&& StringUtils.isNotBlank(liveVideoDetail.getLongitude())) {

			String location = liveVideoDetail.getLatitude() + "," + liveVideoDetail.getLongitude();

			basicinfo.setLocation(location);

		}

		basicinfo.setPublishTime(new Date());

		basicinfo.setStatus(ContentEnum.normal.getCode());

		basicinfo.setTagCode(liveVideoDetail.getTagCode());

		basicinfo.setTitle(liveVideoDetail.getTitle());

		CnContentDetail cnContentDetail = new CnContentDetail();

		cnContentDetail.setContent(liveVideoDetail.getCode());

		basicinfo.setShareScope("dzsd4699100110010001");

		contentServiceFactory.getContentBasicinfoService().save(basicinfo);

		cnContentDetail.setCode(basicinfo.getCode());

		contentServiceFactory.getContentDetailService().save(cnContentDetail);

		return basicinfo.getCode();

	}

	public void updateContentWorth(String contentCode) {

		CnContentWorth contentWorth = new CnContentWorth();

		contentWorth.setContentCode(contentCode);

		contentWorth.setMark("dzsd4107100110100001");

		contentWorth.setSort(0);

		contentWorth.setType("");

		contentWorth.setZc(new Date());

		JdbcHelper.insert(contentWorth);

	}

}
