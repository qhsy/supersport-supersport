package com.uhutu.sportcenter.z.api.live2;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.support.LiveSupport;
import com.uhutu.sportcenter.z.input.ApiConvertStreamUrlInput;
import com.uhutu.sportcenter.z.result.ApiConvertStreamUrlResult;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.root.RootApiToken;

@Component
public class ApiConvertStreamUrl extends RootApiToken<ApiConvertStreamUrlInput, ApiConvertStreamUrlResult> {

	@Override
	protected ApiConvertStreamUrlResult process(ApiConvertStreamUrlInput input) {
		
		ApiConvertStreamUrlResult result = new ApiConvertStreamUrlResult();
		
		switch (input.getOperType()) {
		/*1:大主播拉流地址*/
		case 1:
			bigPlayUrl(input, result);
			break;
		/*2:小主播推拉流地址*/
		case 2:
			smallStreamUrl(input, result);
			break;

		default:
			break;
		}
		
		return result;
	}
	
	/**
	 * 初始化小主播地址
	 * @param input
	 * @param result
	 */
	public void smallStreamUrl(ApiConvertStreamUrlInput input, ApiConvertStreamUrlResult result) {

		String bzid = ContentEnum.BIZID.getCode();

		String key = ContentEnum.BIZKEY.getCode();

		String streamId = bzid + "_" + System.currentTimeMillis();

		String txTime = LiveSupport.getInstance().getTxTime(2);

		String txScreat = LiveSupport.getInstance().getTxSecret(key, streamId, txTime);

		String playtUrl = TopHelper.upInfo(810710033, bzid, streamId, bzid, txScreat, txTime);

		String pushUrl = TopHelper.upInfo(810710031, bzid, streamId, bzid, txScreat, txTime);

		result.setPlayUrl(playtUrl);

		result.setPushUrl(pushUrl);

	}
	
	/**
	 * 初始化大主播拉流地址
	 * @param input
	 * @param result
	 */
	public void bigPlayUrl(ApiConvertStreamUrlInput input, ApiConvertStreamUrlResult result) {

		if(StringUtils.isNotEmpty(input.getStreamUrl())){
			
			if(!StringUtils.contains(input.getStreamUrl(), "txSecret")){
				
				String[] heads = StringUtils.splitByWholeSeparator(input.getStreamUrl(),"?");
				
				if(heads.length > 0){
					
					String[] params = StringUtils.splitByWholeSeparator(heads[0],"liveplay.myqcloud.com/live/");
					
					if(params.length > 1){
						
						String bzid = ContentEnum.BIZID.getCode();

						String key = ContentEnum.BIZKEY.getCode();

						String streamId = params[1];

						String txTime = LiveSupport.getInstance().getTxTime(2);

						String txScreat = LiveSupport.getInstance().getTxSecret(key, streamId, txTime);
						
						String playUrl = TopHelper.upInfo(810710033, bzid, streamId, bzid, txScreat, txTime);
						
						result.setPlayUrl(playUrl);
						
					}
					
				}
				
			}
			
		}

	}

}
