package com.uhutu.sportcenter.z.api.live2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentDetail;
import com.uhutu.dcom.content.z.entity.CnContentWorth;
import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.dcom.content.z.entity.CnLiveVideoInfo;
import com.uhutu.dcom.content.z.entity.CnRedPackUser;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.properties.ConfigDcomContent;
import com.uhutu.dcom.content.z.properties.SettingsDcomContent;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.content.z.support.LiveSupport;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.sportcenter.z.entity.RedPackUserForApi;
import com.uhutu.sportcenter.z.input.ApiBeginLiveInput;
import com.uhutu.sportcenter.z.result.ApiBeginLiveResult;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.helper.TopHelper;
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
public class ApiBeginLive extends RootApiToken<ApiBeginLiveInput, ApiBeginLiveResult> {

	@Autowired
	private ContentServiceFactory contentServiceFactory;

	@Override
	protected ApiBeginLiveResult process(ApiBeginLiveInput input) {

		ApiBeginLiveResult startLiveResult = new ApiBeginLiveResult();
		
		String roomId  = createRoomId(input.getGroupId());

		MDataMap mWhereMap = new MDataMap();

		mWhereMap.put("code", roomId);

		mWhereMap.put("status", ContentEnum.LIVEING.getCode());

		int count = JdbcHelper.count(CnLiveVideoDetail.class, "", mWhereMap);
		CnLiveVideoDetail detail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "", "zc desc ",
				"code=:code and status=:status", mWhereMap);
		if (count > 0) {

			startLiveResult.setError("此房间正在直播中");

			startLiveResult.setStatus(-1);
			
			startLiveResult.setContentCode(detail.getContentCode());
			
		} else {

			CnLiveVideoDetail liveVideoDetail = new CnLiveVideoDetail();
			
			String title = "";
			
			if(StringUtils.isNotEmpty(input.getTitle())){
				
				title = EmojiUtil.emojiFilter(input.getTitle());
				
			}	
			
			input.setTitle(title);

			BeanUtils.copyProperties(input, liveVideoDetail);

			liveVideoDetail.setUserCode(upUserCode());		

			liveVideoDetail.setStatus(ContentEnum.LIVEREADY.getCode());

			liveVideoDetail.setCreateTime(DateHelper.upDate(new Date()));
			
			liveVideoDetail.setCode(roomId);
			
			liveVideoDetail.setChatCode(input.getGroupId());
			
			liveVideoDetail.setBusiCode(WebHelper.upCode("LVEY"));
			
			liveVideoDetail.setLandScapeFlag(input.getLandScapeFlag());

			/* 根据产品需求添加 */
			String contentCode = updateContent(liveVideoDetail);

			liveVideoDetail.setContentCode(contentCode);
			startLiveResult.setContentCode(contentCode);
			SettingsDcomContent dcomContent = ConfigDcomContent.upConfig();
			liveVideoDetail.setWatchConstant(Integer.valueOf(dcomContent.getLiveAppWatchConstant()));
			liveVideoDetail.setPraiseConstant(Integer.valueOf(dcomContent.getLiveAppPraiseConstant()));
			
			
			String streamId = ContentEnum.BIZID.getCode()+"_"+liveVideoDetail.getBusiCode();
			
			String pushUrl = getLivePushUrl(liveVideoDetail.getBusiCode());
			
			startLiveResult.setPushUrl(pushUrl);
			
			liveVideoDetail.setStreamId(streamId);
			
			String playUrl = "";
		
			String webStreamUrl = "";
			
			if(mjFlag(upUserCode())){
				
				playUrl = input.getStreamUrl();
				
				webStreamUrl = input.getWebStreamUrl();
				
			}else{
				
				playUrl = TopHelper.upInfo(810710032, ContentEnum.BIZID.getCode(),streamId);
				
				webStreamUrl = TopHelper.upInfo(810710034, ContentEnum.BIZID.getCode(),streamId);
				
			}
			
			
			liveVideoDetail.setStreamUrl(playUrl);
			
			liveVideoDetail.setWebStreamUrl(webStreamUrl);
			
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

//		CnContentBasicinfo basicinfo = new CnContentBasicinfo();
//
//		basicinfo.setAuthor(upUserCode());
//
//		basicinfo.setBusiType(ContentEnum.sportmoment.getCode());
//
//		basicinfo.setContentType(ContentEnum.TYPE_LIVE.getCode());
//
//		basicinfo.setCover(liveVideoDetail.getCover());
//
//		if (StringUtils.isNotBlank(liveVideoDetail.getAddressName())) {
//
//			basicinfo.setLocaltionName(liveVideoDetail.getAddressName());
//
//		}
//
//		if (StringUtils.isNotBlank(liveVideoDetail.getLatitude())
//				&& StringUtils.isNotBlank(liveVideoDetail.getLongitude())) {
//
//			String location = liveVideoDetail.getLatitude() + "," + liveVideoDetail.getLongitude();
//
//			basicinfo.setLocation(location);
//
//		}
//
//		basicinfo.setPublishTime(new Date());
//
//		basicinfo.setStatus(ContentEnum.invalid.getCode());
//
//		basicinfo.setTagCode(liveVideoDetail.getTagCode());
//
//		basicinfo.setTitle(liveVideoDetail.getTitle());
//
//		CnContentDetail cnContentDetail = new CnContentDetail();
//
//		cnContentDetail.setContent(liveVideoDetail.getBusiCode());
//
//		basicinfo.setShareScope("dzsd4699100110010001");
//
//		contentServiceFactory.getContentBasicinfoService().save(basicinfo);
//
//		cnContentDetail.setCode(basicinfo.getCode());
//
//		contentServiceFactory.getContentDetailService().save(cnContentDetail);

//		return basicinfo.getCode();
		return null;
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
	
	/**
	 * 创建房间
	 * @return
	 */
	public String createRoomId(String chatCode){
		
		String roomId = "";
		
		CnLiveVideoInfo info = JdbcHelper.queryOne(CnLiveVideoInfo.class, "chatCode", chatCode);
		
		if (info != null) {
			
			roomId = info.getCode();
			
		} else {
			
			info = JdbcHelper.queryOne(CnLiveVideoInfo.class, "userCode",upUserCode());
			
			if(info == null){
				
				int simpleNum = JdbcHelper.count(CnLiveVideoInfo.class, "", new MDataMap()) + 1;
				CnLiveVideoInfo videoInfo = new CnLiveVideoInfo();
				videoInfo.setCode(new DecimalFormat("10000000").format(simpleNum));
				videoInfo.setChatCode(chatCode);
				videoInfo.setStatus("1");
				videoInfo.setCreateTime(DateHelper.upNow());
				videoInfo.setUserCode(upUserCode());
				JdbcHelper.insert(videoInfo);
				roomId = videoInfo.getCode();
				
			}else{
				
				roomId = info.getCode();
				
				info.setChatCode(chatCode);
				
				JdbcHelper.update(info, "chatCode", "za");
				
			}
			
		}	
		
		return roomId;
		
	}
	
	/**
	 * 获取直播推流地址
	 * @param roomId
	 * @return
	 */
	public String getLivePushUrl(String roomId){
		
		String bzid = ContentEnum.BIZID.getCode();
		
		String key = ContentEnum.BIZKEY.getCode();
		
		String streamId = bzid+"_"+roomId;
		
		String txTime = LiveSupport.getInstance().getTxTime(2);
		
		String txScreat = LiveSupport.getInstance().getTxSecret(key, streamId, txTime);
		
		return TopHelper.upInfo(810710031, bzid,streamId,bzid,txScreat,txTime);
		
	}
	
	public String encodeUrl(String url) {

		try {
			url = URLEncoder.encode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}

		return url;

	}
	
	/**
	 * 判断是否为马甲用户
	 * @param userCode
	 * 		用户编号
	 * @return boolean
	 */
	public boolean mjFlag(String userCode){
		
		boolean mjFlag = false;
		
		MDataMap mWhereMap = new MDataMap();
		
		mWhereMap.put("code", userCode);
		
		mWhereMap.put("mjFlag", SystemEnum.YES.getCode());
		
		int count = JdbcHelper.count(UcUserinfo.class, "", mWhereMap);
		
		if(count > 0){
			
			mjFlag = true;
			
		}
		
		return mjFlag;
		
	}

}
