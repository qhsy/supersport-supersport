package com.uhutu.sportcenter.z.api.redpack;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.sportcenter.z.entity.PackSeachUserInfo;
import com.uhutu.sportcenter.z.input.ApiPackUserSearchInput;
import com.uhutu.sportcenter.z.result.ApiPackUserSearchResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 打赏人员搜索
 * @author 逄小帅
 *
 */
@Component
public class ApiPackUserSearch extends RootApiToken<ApiPackUserSearchInput, ApiPackUserSearchResult> {

	@Override
	protected ApiPackUserSearchResult process(ApiPackUserSearchInput input) {

		ApiPackUserSearchResult userSearchResult = new ApiPackUserSearchResult();

		StringBuffer sqlBuffer = new StringBuffer();

		sqlBuffer.append("nick_name like '%").append(input.getKeyName()).append("%'");

		int total = JdbcHelper.count(UcUserinfoExt.class, sqlBuffer.toString(), new MDataMap());

		PageInfo pageInfo = new PageInfo(total, input.getPagination(), 10);
		
		userSearchResult.setNextPageFlag(pageInfo.hasNext());

		int iStart = (pageInfo.getPagination() - 1) * pageInfo.getPageNum();

		List<UcUserinfoExt> userinfoExts = JdbcHelper.queryForList(UcUserinfoExt.class, "", "-zc", sqlBuffer.toString(),
				new MDataMap(), iStart, pageInfo.getPageNum());
		
		userinfoExts.forEach(userInfoExt -> {
			
			PackSeachUserInfo seachUserInfo = new PackSeachUserInfo();
			
			seachUserInfo.setAboutHead(userInfoExt.getAboutHead());
			
			String nickName = "";
			
			if(StringUtils.isNotBlank(userInfoExt.getNickName())){
				
				nickName = EmojiUtil.emojiRecovery(userInfoExt.getNickName());
				
			}
			
			seachUserInfo.setNickName(nickName);
			
			seachUserInfo.setTitle(userInfoExt.getTitle());
			
			seachUserInfo.setUserCode(userInfoExt.getUserCode());
			
			seachUserInfo.setType(getType(userInfoExt.getUserCode()));
			
			userSearchResult.getSeachUserInfos().add(seachUserInfo);
			
			
		});

		return userSearchResult;
	}
	
	public String getType(String userCode){
		
		UcUserinfo userinfo = JdbcHelper.queryOne(UcUserinfo.class, "code",userCode);

		String type = "";
		
		if(userinfo != null){
			
			type = userinfo.getType();
			
		}
		return type;
		
	}

}
