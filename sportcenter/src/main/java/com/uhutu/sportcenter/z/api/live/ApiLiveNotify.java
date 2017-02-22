package com.uhutu.sportcenter.z.api.live;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.extend.z.entity.ReReportLimit;
import com.uhutu.dcom.pay.z.entity.PaInclogInfo;
import com.uhutu.dcom.pay.z.util.MD5;
import com.uhutu.dcom.user.z.properties.SettingsDcomUser;
import com.uhutu.sportcenter.z.input.ApiLiveNotifyInput;
import com.uhutu.sportcenter.z.result.ApiLiveNotifyResult;
import com.uhutu.zoocom.helper.GsonHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 直播消息通知
 * 
 * @author 逄小帅
 *
 */
@Component
public class ApiLiveNotify extends RootApiBase<ApiLiveNotifyInput, ApiLiveNotifyResult> {

	@Autowired
	private SettingsDcomUser settingsDcomUser;

	@Override
	protected ApiLiveNotifyResult process(ApiLiveNotifyInput input) {

		ApiLiveNotifyResult result = new ApiLiveNotifyResult();
		ReReportLimit limit = new ReReportLimit();
		synchronized (ApiLiveNotify.class) {

			if (checkSign(input.getT(), input.getSign())) {
				switch (input.getEvent_type()) {
				case 0:// 断流
					updateLiveStatus(input.getStream_id());
					limit.setCode(input.getStream_id() + "已断流");
					JdbcHelper.insert(limit);
					break;
				case 1:// 推流
					limit.setCode(input.getStream_id() + "开始推流");
					JdbcHelper.insert(limit);
					break;
				case 100:// 新录制文件
					updateLiveVideo(input.getStream_id(), input.getVideo_id(), input.getVideo_url());
					limit.setCode(input.getStream_id() + "录制文件生成vId:" + input.getVideo_id() + " vUrl:"
							+ input.getVideo_url());
					JdbcHelper.insert(limit);
					break;
				case 200:// 新截图文件
					limit.setCode(input.getStream_id() + "截图文件生成" + input.getPic_full_url() + input.getStream_id());
					JdbcHelper.insert(limit);
					break;
				default:
					break;
				}
			} else {
				result.setError("签名不一致");
				result.setStatus(-1);
			}
			logInfo(input);
		}
		return result;
	}

	public void updateLiveStatus(String streamId) {
		MDataMap mWhereMap = new MDataMap();
		mWhereMap.put("streamId", streamId);
		CnLiveVideoDetail videoDetail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "", "", "", mWhereMap);
		if (videoDetail != null) {
			videoDetail.setStatus(ContentEnum.LIVEEND.getCode());
			JdbcHelper.update(videoDetail, "status", "za");
		}
	}

	public void updateLiveVideo(String streamId, String videoId, String videoUrl) {
		MDataMap mWhereMap = new MDataMap();
		mWhereMap.put("streamId", streamId);
		mWhereMap.put("videoId", videoId);
		mWhereMap.put("videoUrl", videoUrl);
		CnLiveVideoDetail videoDetail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "", "", "stream_id=:streamId",
				mWhereMap);
		if (videoDetail != null) {
			videoDetail.setStatus(ContentEnum.LIVEEND.getCode());
			JdbcHelper.update(videoDetail, "status,videoId,videoUrl", "za");
		}
	}

	public boolean checkSign(String timestamp, String sign) {
		boolean flag = false;
		String checkSign = MD5.sign(settingsDcomUser.getLiveKey() + timestamp, "UTF-8");
		if (StringUtils.equals(sign, checkSign)) {
			flag = true;
		}
		return flag;
	}

	public void logInfo(ApiLiveNotifyInput input) {

		PaInclogInfo paInclogInfo = new PaInclogInfo();

		paInclogInfo.setBusiCode(input.getStream_id());

		paInclogInfo.setIncType("LIVE_NOTIFY");

		String jsonStr = GsonHelper.toJson(input);

		paInclogInfo.setRequestData(jsonStr);

		paInclogInfo.setZc(new Date());

		JdbcHelper.insert(paInclogInfo);

	}

}
