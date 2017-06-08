package com.uhutu.dcom.content.func;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.content.z.properties.ConfigDcomContent;
import com.uhutu.dcom.content.z.support.LiveChatRoomSupport;
import com.uhutu.dcom.content.z.support.LiveSupport;
import com.uhutu.dcom.content.z.support.compent.TecentChatRoomRootApiResult;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.model.MParamReplace;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageField;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.helper.ReplaceHelper;
import com.uhutu.zooweb.helper.WebHelper;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class LiveInfoFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		MDataMap mInsertMap = new MDataMap();

		// 只有存在于预定义列中的值才进行操作
		if (StringUtils.isNotBlank(extendPageDefine.getPageSource().getColumnNames())) {

			for (String sKey : StringUtils.split(extendPageDefine.getPageSource().getColumnNames(), ",")) {
				String sFieldData = sKey.trim();
				if (input.getDataMap().containsKey(sFieldData)) {
					mInsertMap.put(sFieldData, input.getDataMap().get(sFieldData));
				}
			}

		}

		// 注意，这里面的方法可能会随时变更，请勿复制粘贴，直接调用方法才对
		if (!extendPageDefine.getFieldInc().isEmpty()) {

			for (String sKey : extendPageDefine.getFieldInc().keySet()) {

				MDataMap mIncMap = extendPageDefine.getFieldInc().get(sKey);

				// 如果是插入时的自动生成key
				if (mIncMap.containsKey(DefineWebInc.Insert_Code)) {

					WebPageField webPageField = webPageModel.getFields().stream()
							.filter(w -> w.getFieldId().equals(sKey)).findFirst().get();
					mInsertMap.put(webPageField.getFieldData(),
							WebHelper.upCode(mIncMap.get(DefineWebInc.Insert_Code)));
				}

				// 如果是插入时的自动生成key
				if (mIncMap.containsKey(DefineWebInc.Insert_Value)) {

					WebPageField webPageField = webPageModel.getFields().stream()
							.filter(w -> w.getFieldId().equals(sKey)).findFirst().get();
					String sValue = mIncMap.get(DefineWebInc.Insert_Value);

					MParamReplace mParamReplace = new MParamReplace();
					mParamReplace.setUserCode(upUserCode());

					mInsertMap.put(webPageField.getFieldData(), ReplaceHelper.replaceBySet(sValue, mParamReplace));

				}

			}

		}
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
			mInsertMap.put("watch", "0");
			mInsertMap.put("length", "0");
			mInsertMap.put("chat_name", WebHelper.upCode("LTSMC"));
			if (mInsertMap.get("status").equals("dzsd4107100110170003")) {
				result.setStatus(0);
				result.setError("禁止添加已结束的直播间!");
			} else {

				TecentChatRoomRootApiResult re = LiveChatRoomSupport.Instance().createRoom(mInsertMap.get("chat_name"),
						mInsertMap.get("user_code"));
				if (!re.upFlagTrue()) {
					result.setError(re.getError());
					result.setStatus(re.getStatus());
				} else {
					mInsertMap.put("chat_code", re.getGroupId());
					JdbcHelper.dataInsert(extendPageDefine.getPageSource().getTableName(), mInsertMap);
				}
			}
		}
		return result;
	}

}
