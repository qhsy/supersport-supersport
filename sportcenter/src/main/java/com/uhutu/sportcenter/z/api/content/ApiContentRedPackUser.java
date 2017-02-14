package com.uhutu.sportcenter.z.api.content;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.content.z.entity.CnContentRedpackFlow;
import com.uhutu.dcom.user.z.entity.UcAttentionInfo;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.entity.UserBasicInfo;
import com.uhutu.sportcenter.z.input.ApiContentRedPackUserInput;
import com.uhutu.sportcenter.z.result.ApiContentRedPackUserResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

import io.swagger.annotations.ApiModel;

/**
 * 红包打赏人员列表
 * @author 逄小帅
 *
 */
@ApiModel
@Component
public class ApiContentRedPackUser extends RootApiToken<ApiContentRedPackUserInput, ApiContentRedPackUserResult> {	

	@Autowired
	private UserInfoSupport userInfoSupport;

	@Override
	protected ApiContentRedPackUserResult process(ApiContentRedPackUserInput input) {
		
		ApiContentRedPackUserResult redPackUserResult = new ApiContentRedPackUserResult();
		
		StringBuffer sqlBuffer= new StringBuffer();
		
		sqlBuffer.append(" content_code = '").append(input.getContentCode()).append("'");
		
		sqlBuffer.append(" and status = '").append(SystemEnum.NORMAL.getCode()).append("'");
		
		String totalStr = JdbcHelper.dataGet("cn_content_redpack_flow", "count(DISTINCT send_user_code)", sqlBuffer.toString(), new MDataMap());
		
		int total = Integer.parseInt(totalStr);
		
		sqlBuffer.append(" group by send_user_code order by zc desc");
		
		PageInfo pageInfo = new PageInfo(total, input.getPagination(), 10);
		
		redPackUserResult.setNextPageFlag(pageInfo.hasNext());
		
		redPackUserResult.setTotal(total);
		
		int iStart = (pageInfo.getPagination() - 1) * pageInfo.getPageNum();
		
		List<CnContentRedpackFlow> contentRedpacks = JdbcHelper.queryForList(CnContentRedpackFlow.class, "", "", sqlBuffer.toString(), new MDataMap(), iStart, pageInfo.getPageNum());
		
		for (CnContentRedpackFlow cnContentRedpack : contentRedpacks) {
			
			if (cnContentRedpack != null) {

				UcUserinfo ucUserinfo = userInfoSupport.getUserInfo(cnContentRedpack.getSendUserCode());

				UcUserinfoExt ucUserinfoExt = userInfoSupport.getUserInfoExt(cnContentRedpack.getSendUserCode());

				if (ucUserinfo != null && ucUserinfoExt != null) {

					UserBasicInfo basicInfo = new UserBasicInfo();

					basicInfo.setAboutHead(ucUserinfoExt.getAboutHead());

					basicInfo.setNickName(EmojiUtil.emojiRecovery(ucUserinfoExt.getNickName()));

					basicInfo.setTitle(ucUserinfoExt.getTitle());

					basicInfo.setType(ucUserinfo.getType());

					basicInfo.setUserCode(ucUserinfo.getCode());
					
					boolean attendFlag = initFlag(upUserCode(), basicInfo.getUserCode());
					
					basicInfo.setAttendFlag(attendFlag);

					redPackUserResult.getUserBasicInfos().add(basicInfo);

				}

			}
			
		
			
		}
		
		return redPackUserResult;
	}
	
	public boolean initFlag(String attention,String beAttention){
		
		boolean flag = false;
		
		UcAttentionInfo attentionInfo = JdbcHelper.queryOne(UcAttentionInfo.class, "attention", attention,
				"beAttention", beAttention, "status", SystemEnum.NORMAL.getCode());
		
		if(attentionInfo != null){
			
			flag = true;
			
		}
		
		return flag;
		
	}

}
