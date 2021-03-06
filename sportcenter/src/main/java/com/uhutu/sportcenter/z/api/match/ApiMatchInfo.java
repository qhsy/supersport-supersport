package com.uhutu.sportcenter.z.api.match;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnMatchInfo;
import com.uhutu.dcom.content.z.entity.CnMatchLink;
import com.uhutu.dcom.content.z.entity.CnMatchLive;
import com.uhutu.dcom.content.z.entity.CnMatchSign;
import com.uhutu.dcom.content.z.entity.CnMatchVideo;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.user.z.entity.UcAttentionInfo;
import com.uhutu.sportcenter.z.api.util.JumpTypeSupport;
import com.uhutu.sportcenter.z.api.util.MatchComponent;
import com.uhutu.sportcenter.z.entity.JumpTypeData;
import com.uhutu.sportcenter.z.entity.MatchInfo;
import com.uhutu.sportcenter.z.entity.MatchLiveInfo;
import com.uhutu.sportcenter.z.entity.MatchVidoInfo;
import com.uhutu.sportcenter.z.entity.UserBasicInfo;
import com.uhutu.sportcenter.z.input.ApiMatchInfoInput;
import com.uhutu.sportcenter.z.result.ApiMatchInfoResult;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoocom.z.bean.TopUserFactory;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 赛事详情
 * 
 * @author 逄小帅
 *
 */
@Component
public class ApiMatchInfo extends RootApiBase<ApiMatchInfoInput, ApiMatchInfoResult> {

	@Override
	protected ApiMatchInfoResult process(ApiMatchInfoInput input) {

		ApiMatchInfoResult matchInfoResult = new ApiMatchInfoResult();

		CnMatchInfo cnMatchInfo = JdbcHelper.queryOne(CnMatchInfo.class, "code", input.getMatchCode());

		if (cnMatchInfo != null) {

			MatchInfo matchInfo = initMatchInfo(cnMatchInfo, input.getZoo().getToken(), input.getWidth(),
					input.getDetailWidth());

			List<MatchLiveInfo> matchLiveInfos = initMatchLive(cnMatchInfo.getCode());

			List<MatchVidoInfo> matchVidoInfos = initMatchVideo(cnMatchInfo.getCode());

			matchInfoResult.setMatchInfo(matchInfo);

			matchInfoResult.setMatchLiveInfos(matchLiveInfos);

			matchInfoResult.setMatchVidoInfos(matchVidoInfos);

			initMatchSign(input.getMatchCode(), matchInfoResult);

			if (StringUtils.isEmpty(matchInfoResult.getSignUrl())) {

				linkJumpData(input.getMatchCode(), matchInfoResult);

			} else {

				matchInfoResult.setButtonName("我要报名");

			}

			operBtn(matchInfoResult);

		} else {

			matchInfoResult.setError("相关赛事信息不存在");

			matchInfoResult.setStatus(-1);

		}

		return matchInfoResult;
	}

	public MatchInfo initMatchInfo(CnMatchInfo cnMatchInfo, String token, int coverWidth, int detaiWidth) {

		MatchInfo matchInfo = new MatchInfo();

		BeanUtils.copyProperties(cnMatchInfo, matchInfo);

		String flagName = MatchComponent.getInstance().initFlagName(matchInfo.getFlag());

		matchInfo.setFlagName(flagName);

		matchInfo.setUserBasicInfo(MatchComponent.getInstance().initBasicInfo(cnMatchInfo.getUserCode()));

		String coverSource = ImageHelper.upImageThumbnail(cnMatchInfo.getCover(), coverWidth);

		matchInfo.setCover(coverSource);

		matchInfo.setDetails(MatchComponent.getInstance().initDetails(cnMatchInfo.getContent(), detaiWidth));

		if (StringUtils.isNotBlank(token)) {

			String userCode = TopUserFactory.upUserCallFactory().upUserCodeByAuthToken(token,
					DefineUser.Login_System_Default);

			UcAttentionInfo attentionInfo = JdbcHelper.queryOne(UcAttentionInfo.class, "attention", userCode,
					"beAttention", cnMatchInfo.getUserCode(), "status", SystemEnum.NORMAL.getCode());

			if (attentionInfo != null) {

				matchInfo.setAttendFlag(true);

			}

		}

		return matchInfo;

	}

	public List<MatchLiveInfo> initMatchLive(String matchCode){
		
		List<MatchLiveInfo> matchLiveInfos = new ArrayList<MatchLiveInfo>();
		
		MDataMap mWhereMap = new MDataMap();
		
		mWhereMap.put("matchCode", matchCode);
		
		List<CnMatchLive> cnMatchLives = JdbcHelper.queryForList(CnMatchLive.class, "", "sort desc,zc desc", "", mWhereMap);
		
		for (CnMatchLive cnMatchLive : cnMatchLives) {
			
			MatchLiveInfo matchLiveInfo = new MatchLiveInfo();
			
			BeanUtils.copyProperties(cnMatchLive, matchLiveInfo);
			
			matchLiveInfo.setStatusName(MatchComponent.getInstance().initFlagName(cnMatchLive.getStatus()));
			
			JumpTypeData jumpTypeData = new JumpTypeSupport().getData("dzsd4107100110150001", cnMatchLive.getLiveCode(), "");
			
			matchLiveInfo.setJumpTypeData(jumpTypeData);
			
			String startTime = formatDate(matchLiveInfo.getStartTime());
			
			matchLiveInfo.setStartTime(startTime);
			
			matchLiveInfos.add(matchLiveInfo);
			
			
		}
		
		return matchLiveInfos;
		
	}

	public List<MatchVidoInfo> initMatchVideo(String matchCode) {

		List<MatchVidoInfo> matchVidoInfos = new ArrayList<MatchVidoInfo>();

		MDataMap mWhereMap = new MDataMap();

		mWhereMap.put("matchCode", matchCode);

		List<CnMatchVideo> cnMatchVideos = JdbcHelper.queryForList(CnMatchVideo.class, "", "sort desc,zc desc", "",
				mWhereMap);

		cnMatchVideos.forEach(cnMatchVideo -> {

			MatchVidoInfo matchVideoInfo = new MatchVidoInfo();

			BeanUtils.copyProperties(cnMatchVideo, matchVideoInfo);

			String cover = matchVideoInfo.getCover();

			CnContentBasicinfo contentBasicinfo = JdbcHelper.queryOne(CnContentBasicinfo.class, "code",
					matchVideoInfo.getContentCode());

			if (contentBasicinfo != null) {

				if (StringUtils.isEmpty(cover)) {

					cover = contentBasicinfo.getCover();

				}

//				if (StringUtils.isNotEmpty(contentBasicinfo.getAuthor())) {
//
//					UserBasicInfo basicInfo = MatchComponent.getInstance().initBasicInfo(contentBasicinfo.getAuthor());
//
//					matchVideoInfo.setUserBasicInfo(basicInfo);
//
//				}

				matchVideoInfo.setTitle(contentBasicinfo.getTitle());

			}

			JumpTypeData jumpTypeData = new JumpTypeSupport().getData("dzsd4107100110150001",
					matchVideoInfo.getContentCode(), "");

			matchVideoInfo.setJumpTypeData(jumpTypeData);

			matchVideoInfo.setCover(cover);

			matchVidoInfos.add(matchVideoInfo);

		});

		return matchVidoInfos;

	}

	public void initMatchSign(String matchCode, ApiMatchInfoResult result) {

		MDataMap mWhereMap = new MDataMap();

		mWhereMap.put("matchCode", matchCode);

		mWhereMap.put("status", ContentEnum.MATCH_PUB.getCode());

		List<CnMatchSign> matchSigns = JdbcHelper.queryForList(CnMatchSign.class, "", "sort desc,zc desc", "",
				mWhereMap);

		if (matchSigns.size() == 0) {

			result.setSignUrl("");

		}

		if (matchSigns.size() == 1) {

			CnMatchSign cnMatchSign = matchSigns.get(0);

			if (cnMatchSign != null) {

				String url = TopHelper.upInfo(810710028, cnMatchSign.getSignCode());

				result.setRedirectFlag(true);

				result.setSignUrl(url);

			}

		}

		if (matchSigns.size() > 1) {

			String url = TopHelper.upInfo(810710027, matchCode);

			result.setRedirectFlag(false);

			result.setSignUrl(url);

		}

	}

	public void linkJumpData(String matchCode, ApiMatchInfoResult matchInfoResult) {

		JumpTypeData jumpTypeData = null;

		CnMatchLink matchLink = JdbcHelper.queryOne(CnMatchLink.class, "matchCode", matchCode, "status",
				ContentEnum.MATCH_PUB.getCode());

		if (matchLink != null) {

			jumpTypeData = new JumpTypeSupport().getData(matchLink.getLinkType(), matchLink.getLinkContent(),
					matchLink.getLinkTitle());

			if (StringUtils.isNotEmpty(matchLink.getTitle())) {

				matchInfoResult.setButtonName(matchLink.getTitle());

			}

		}

		matchInfoResult.setLinkJumpData(jumpTypeData);

	}

	public void operBtn(ApiMatchInfoResult matchInfoResult) {

		if (StringUtils.isNotBlank(matchInfoResult.getSignUrl())) {

			matchInfoResult.setOperBtn("sign");

		} else {

			if (matchInfoResult.getLinkJumpData() != null) {

				matchInfoResult.setOperBtn("link");

			} else {

				matchInfoResult.setOperBtn("none");

			}

		}

	}

	public String formatDate(String startTime) {

		if (StringUtils.isNotEmpty(startTime)) {

			Date startDate = DateHelper.parseDate(startTime);

			if (startDate != null) {

				startTime = DateHelper.upDate(startDate, "yyyy-MM-dd HH:mm");

			}

		}

		return startTime;

	}

}
