package com.uhutu.sportcenter.z.api.redpack;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.content.z.entity.CnRedPackInfo;
import com.uhutu.dcom.content.z.entity.CnRedPackUser;
import com.uhutu.dcom.user.z.entity.UserBasicInfo;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.entity.RedPackInfo;
import com.uhutu.sportcenter.z.entity.RedPackUserInfo;
import com.uhutu.sportcenter.z.input.ApiRedPackInfoListInput;
import com.uhutu.sportcenter.z.result.ApiRedPackInfoListResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 红包信息列表
 * @author 逄小帅
 *
 */
@Component
public class ApiRedPackInfoList extends RootApiToken<ApiRedPackInfoListInput, ApiRedPackInfoListResult>{
	
	@Autowired
	private UserInfoSupport userInfoSupport;

	@Override
	protected ApiRedPackInfoListResult process(ApiRedPackInfoListInput input) {
		
		ApiRedPackInfoListResult redPackInfoListResult = new ApiRedPackInfoListResult();
		
		initRedPackInfos(redPackInfoListResult);
		
		initRedPackUsers(redPackInfoListResult,input.getLiveCode());
		
		return redPackInfoListResult;
	}
	
	public void initRedPackInfos(ApiRedPackInfoListResult redPackInfoListResult){
		
		MDataMap mWhereMap = new MDataMap();
		
		mWhereMap.put("status", SystemEnum.NORMAL.getCode());
		
		List<CnRedPackInfo> redPackInfos = JdbcHelper.queryForList(CnRedPackInfo.class, "", "-sort", "", mWhereMap);
		
		redPackInfos.forEach(redPackInfo -> {
			
			RedPackInfo redPack = new RedPackInfo();
			
			BeanUtils.copyProperties(redPackInfo, redPack);
			
			redPackInfoListResult.getRedPackInfos().add(redPack);
			
			
		});
		
	}
	
	public void initRedPackUsers(ApiRedPackInfoListResult redPackInfoListResult,String liveCode){
		
		MDataMap mWhereMap = new MDataMap();
		
		mWhereMap.put("busiCode", liveCode);
		
		List<CnRedPackUser> redPackUsers = JdbcHelper.queryForList(CnRedPackUser.class, "", "-sort", "", mWhereMap);
		
		redPackUsers.forEach(redPackUser -> {
			
			RedPackUserInfo redPackUserInfo = new RedPackUserInfo();
			
			BeanUtils.copyProperties(redPackUser, redPackUserInfo);
			
			UserBasicInfo basicInfo = userInfoSupport.getUserBasicInfo(redPackUser.getUserCode());
			
			if(basicInfo.getUcUserinfo() != null){
				
				redPackUserInfo.setType(basicInfo.getUcUserinfo().getType());
				
			}
			
			if(basicInfo.getUcUserinfoExt() != null){
				
				redPackUserInfo.setAboutHead(basicInfo.getUcUserinfoExt().getAboutHead());
				
				redPackUserInfo.setNickName(basicInfo.getUcUserinfoExt().getNickName());
				
			}
			
			redPackInfoListResult.getRedPackUsers().add(redPackUserInfo);
			
			
		});
		
		
	}

}
