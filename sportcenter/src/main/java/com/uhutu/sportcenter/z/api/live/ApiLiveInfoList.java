package com.uhutu.sportcenter.z.api.live;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.tag.z.service.ContentLabelServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.entity.LiveDetailInfo;
import com.uhutu.sportcenter.z.entity.UserBasicInfo;
import com.uhutu.sportcenter.z.input.ApiLiveInfoListInput;
import com.uhutu.sportcenter.z.result.ApiLiveInfoListResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;

import io.swagger.annotations.ApiModel;

/**
 * 直播信息列表
 * @author 逄小帅
 *
 */
@ApiModel
@Component
public class ApiLiveInfoList extends RootApiBase<ApiLiveInfoListInput, ApiLiveInfoListResult> {
	
	@Autowired
	private UserInfoSupport userInfoSupport;
	
	@Autowired
	private ContentLabelServiceFactory labelServiceFactory;

	@Override
	protected ApiLiveInfoListResult process(ApiLiveInfoListInput input) {
		
		ApiLiveInfoListResult result = new ApiLiveInfoListResult();

		MDataMap whereDataMap = new MDataMap();
		
		whereDataMap.put("status", ContentEnum.LIVEING.getCode());
		
		int count = JdbcHelper.count(CnLiveVideoDetail.class, "", whereDataMap);
		
		int iNumber = 20;
		
		int iStart = (input.getPagination() -1) * iNumber;
		
		PageInfo pageInfo = new PageInfo(count, input.getPagination(), iNumber);
		
		result.setNextPageFlag(pageInfo.hasNext());
		
		List<CnLiveVideoDetail> liveVideos = JdbcHelper.queryForList(CnLiveVideoDetail.class, "", "-zc", "", whereDataMap, iStart, iNumber);
		
		liveVideos.forEach(videoDetail -> {
			
			LiveDetailInfo liveDetailInfo = new LiveDetailInfo();
			
			BeanUtils.copyProperties(videoDetail,liveDetailInfo);
			
			if(StringUtils.isNotBlank(videoDetail.getUserCode())){
				
				liveDetailInfo.setUserBasicInfo(initUserInfo(videoDetail.getUserCode()));
				
			}
			
			liveDetailInfo.setTagName(labelServiceFactory.getContentLabelService().initTagName(videoDetail.getTagCode()));
			
			result.getLiveDetailInfos().add(liveDetailInfo);
			
			
		});
		
		return result;
	}
	
	public UserBasicInfo initUserInfo(String userCode){
		
		UserBasicInfo userBasicInfo = new UserBasicInfo();
		
		UcUserinfo userinfo = userInfoSupport.getUserInfo(userCode);
		
		UcUserinfoExt userinfoExt = userInfoSupport.getUserInfoExt(userCode);
		
		if(userinfo != null){
			
			userBasicInfo.setType(userinfo.getType());
			
		}
		
		if(userinfoExt != null){
			
			userBasicInfo.setAboutHead(userinfoExt.getAboutHead());
			
			userBasicInfo.setNickName(userinfoExt.getNickName());
			
			userBasicInfo.setTitle(userinfoExt.getTitle());
			
			userBasicInfo.setUserCode(userinfoExt.getUserCode());
			
		}
		
		return userBasicInfo;
		
	}

}
