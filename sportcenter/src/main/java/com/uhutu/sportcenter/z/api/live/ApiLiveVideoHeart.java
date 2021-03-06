package com.uhutu.sportcenter.z.api.live;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.dcom.content.z.entity.CnRedPackUser;
import com.uhutu.sportcenter.z.input.ApiLiveVideoHeartInput;
import com.uhutu.sportcenter.z.result.ApiLiveVideoHeartResult;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 直播心跳
 * 
 * @author xiegj
 *
 */
@Component
public class ApiLiveVideoHeart extends RootApiToken<ApiLiveVideoHeartInput, ApiLiveVideoHeartResult> {

	@Override
	protected ApiLiveVideoHeartResult process(ApiLiveVideoHeartInput input) {

		ApiLiveVideoHeartResult result = new ApiLiveVideoHeartResult();
		CnLiveVideoDetail detail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "", "zc desc limit 0,1",
				"user_code=:user_code", MapHelper.initMap("user_code", upUserCode()));
		if (detail != null) {
			detail.setChannelId(input.getChannelId());
			detail.setStreamUrl(input.getStreamUrl());
			detail.setLength(input.getLength());
			detail.setWatch(input.getWatch());
			detail.setPraise(input.getPraise());
			detail.setStatus("1");
			
			CnRedPackUser packUser = JdbcHelper.queryOne(CnRedPackUser.class, "sum(money) as money ", "",
					"busi_code=:busiCode", MapHelper.initMap("busiCode", detail.getBusiCode()));
			if (packUser != null&&packUser.getMoney()!=null) {
				result.setMoney(packUser.getMoney().setScale(2));
			}
			
			/*设置总收入*/
			detail.setIncome(result.getMoney());
			
			if (StringUtils.isNotBlank(detail.getContentCode())) {
				CnContentBasicinfo basicinfo = JdbcHelper.queryOne(CnContentBasicinfo.class, "code",
						detail.getContentCode());
				if (basicinfo != null && "dzsd4699100110010002".equals(basicinfo.getStatus())) {
					basicinfo.setStatus("dzsd4699100110010001");
					JdbcHelper.update(basicinfo, "status", "za");
				}
			}
			
			if(StringUtils.isNotEmpty(detail.getStreamUrl())){
				
				JdbcHelper.update(detail, "length,watch,praise,status,channelId,streamUrl,income", "za");
				
			}else{
				
				JdbcHelper.update(detail, "length,watch,praise,status,channelId,income", "za");
				
			}
			
		}
		return result;

	}

}
