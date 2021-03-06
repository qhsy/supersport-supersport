package com.uhutu.sportcenter.z.api.content;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.content.z.entity.CnRedPackInfo;
import com.uhutu.sportcenter.z.entity.RedPackInfo;
import com.uhutu.sportcenter.z.input.ApiContentRedPackInfoInput;
import com.uhutu.sportcenter.z.result.ApiContentRedPackInfoResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 内容打赏红包信息
 * @author 逄小帅
 *
 */
@Component
public class ApiContentRedPackInfo extends RootApiToken<ApiContentRedPackInfoInput, ApiContentRedPackInfoResult> {

	@Override
	protected ApiContentRedPackInfoResult process(ApiContentRedPackInfoInput input) {
		
		ApiContentRedPackInfoResult redPackInfoResult = new ApiContentRedPackInfoResult();
		
		initRedPackInfo(redPackInfoResult);
		
		return redPackInfoResult;
	}
	
	/**
	 * 获取直播红包
	 * @param redPackInfoListResult
	 */
	public void initRedPackInfo(ApiContentRedPackInfoResult redPackInfoResult){
		
		MDataMap mWhereMap = new MDataMap();
		
		mWhereMap.put("status", SystemEnum.NORMAL.getCode());
		
		mWhereMap.put("type", "dzsd4107100110160002");

		List<CnRedPackInfo> redPackInfos = JdbcHelper.queryForList(CnRedPackInfo.class, "", "-sort", "", mWhereMap);
		
		redPackInfos.forEach(redPackInfo -> {
			
			RedPackInfo redPack = new RedPackInfo();
			
			BeanUtils.copyProperties(redPackInfo, redPack);
			
			redPackInfoResult.getRedPackInfos().add(redPack);
			
			
		});
		
	}

}
