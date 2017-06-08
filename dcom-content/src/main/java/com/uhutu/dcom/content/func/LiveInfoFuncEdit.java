package com.uhutu.dcom.content.func;

import com.uhutu.dcom.content.z.properties.ConfigDcomContent;
import com.uhutu.dcom.content.z.support.LiveChatRoomSupport;
import com.uhutu.dcom.content.z.support.LiveSupport;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class LiveInfoFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		MDataMap mInsertMap = input.getDataMap();
		if (input.getDataMap().get("create_time").equals(input.getDataMap().get("end_time"))
				|| DateHelper.parseDate(input.getDataMap().get("create_time"))
						.after(DateHelper.parseDate(input.getDataMap().get("end_time")))) {
			result.inError(810710004);
		}
		if (result.upFlagTrue()) {
			String key = ConfigDcomContent.upConfig().getLiveCheckKey();
			String bizId = ConfigDcomContent.upConfig().getLivebizId();
			String txTime = LiveSupport.getInstance().getTxTime(DateHelper.parseDate(mInsertMap.get("create_time")),
					Integer.valueOf(ConfigDcomContent.upConfig().getLiveExpirationTime()));
			String txScreat = LiveSupport.getInstance().getTxSecret(key, bizId + "_" + mInsertMap.get("user_code"),
					txTime);
			String pushUrl = TopHelper.upInfo(810710031, bizId, bizId, mInsertMap.get("user_code"), bizId, txScreat,
					txTime);
			String rtmpUrl = TopHelper.upInfo(810710032, bizId, bizId, mInsertMap.get("user_code"));
			String hlsUrl = TopHelper.upInfo(810710034, bizId, bizId, mInsertMap.get("user_code"));
			String flvUrl = TopHelper.upInfo(810710035, bizId, bizId, mInsertMap.get("user_code"));
			mInsertMap.put("push_stream_url", pushUrl);
			mInsertMap.put("rtmp_play_url", rtmpUrl);
			mInsertMap.put("flv_play_url", flvUrl);
			mInsertMap.put("hls_play_url", hlsUrl);
			MDataMap info = JdbcHelper.dataOne(extendPageDefine.getPageSource().getTableName(), "za",
					mInsertMap.get("za"));
			if (info.get("status").equals("dzsd4107100110170003")
					&& !mInsertMap.get("status").equals("dzsd4107100110170003")) {
				result.setStatus(0);
				result.setError("已结束的直播不允许重新使用");
			} else if (!info.get("status").equals("dzsd4107100110170003")
					&& mInsertMap.get("status").equals("dzsd4107100110170003")) {// 直播结束
				LiveChatRoomSupport.Instance().destoryGroup(info.get("chat_code"));
			}
			if (result.upFlagTrue()) {
				JdbcHelper.dataUpdate(extendPageDefine.getPageSource().getTableName(), mInsertMap, "", "za");
			}
		}
		return result;
	}

}
