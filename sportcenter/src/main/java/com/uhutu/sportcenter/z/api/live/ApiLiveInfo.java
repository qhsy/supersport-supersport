package com.uhutu.sportcenter.z.api.live;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentDetail;
import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.dcom.content.z.entity.CnRedPackUser;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.properties.ConfigDcomContent;
import com.uhutu.dcom.content.z.properties.SettingsDcomContent;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.sportcenter.z.input.ApiLiveInfoInput;
import com.uhutu.sportcenter.z.result.ApiLiveInfoResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;

import io.swagger.annotations.ApiModel;

/**
 * H5旁路及app原生直播所需参数
 * 
 * @author xiegj
 *
 */
@ApiModel
@Component
public class ApiLiveInfo extends RootApiBase<ApiLiveInfoInput, ApiLiveInfoResult> {

	@Override
	protected ApiLiveInfoResult process(ApiLiveInfoInput input) {

		ApiLiveInfoResult result = new ApiLiveInfoResult();
		if (StringUtils.isNotBlank(input.getContentCode())) {
			
			CnContentBasicinfo basicinfo = JdbcHelper.queryOne(CnContentBasicinfo.class, "code",
					input.getContentCode());
			
			CnContentDetail contentDetail = JdbcHelper.queryOne(CnContentDetail.class, "code",
					input.getContentCode());
			
//			if (basicinfo != null && contentDetail != null && StringUtils.isNotEmpty(contentDetail.getContent()) ) {
//				
//				CnLiveVideoDetail detail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "busiCode",contentDetail.getContent());
//				
//				if(detail != null && StringUtils.isNotEmpty(detail.getTitle())){
//					
//					String title = EmojiUtil.emojiRecovery(detail.getTitle());
//					
//					detail.setTitle(title);
//					
//				}
				
//				result.setDetail(detail);
//				if (detail != null) {
//					SettingsDcomContent dcomContent = ConfigDcomContent.upConfig();
//					result.setAppId(dcomContent.getLiveAppId());
//				}
//				UcUserinfoExt ext = JdbcHelper.queryOne(UcUserinfoExt.class, "user_code", basicinfo.getAuthor());
//				UcUserinfo info = JdbcHelper.queryOne(UcUserinfo.class, "code", basicinfo.getAuthor());
//				if (ext != null && info != null) {
//					result.getUserBasicInfo().setAboutHead(ext.getAboutHead());
//					result.getUserBasicInfo().setNickName(ext.getNickName());
//					result.getUserBasicInfo().setTitle(ext.getTitle());
//					result.getUserBasicInfo().setType(info.getType());
//					result.getUserBasicInfo().setUserCode(ext.getUserCode());
//				}
//				
//				if(StringUtils.equals(detail.getStatus(), ContentEnum.LIVEING.getCode())){
//					
//					result.setLiveType(0);
//					
//				}
//				
//				if (StringUtils.equals(detail.getStatus(), ContentEnum.LIVEEND.getCode())) {
//
//					result.setLiveType(1);
//
//				}
//				
//				result.setRedPackFalg(initPackFlag(detail.getBusiCode()));
//				
				
//			}

		}
		return result;
	}
	
	public boolean initPackFlag(String bizCode){
		
		boolean flag = false;
		
		MDataMap mWhereMap = new MDataMap();
		
		mWhereMap.put("busiCode", bizCode);
		
		int count = JdbcHelper.count(CnRedPackUser.class, "", mWhereMap);
		
		if(count > 0){
			
			flag = true;
			
		}
		
		return flag;
		
	}

}
