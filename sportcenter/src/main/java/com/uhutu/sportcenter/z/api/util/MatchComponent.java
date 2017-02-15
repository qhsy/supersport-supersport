package com.uhutu.sportcenter.z.api.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.sportcenter.z.entity.MatchDetailInfo;
import com.uhutu.sportcenter.z.entity.UserBasicInfo;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;
import com.uhutu.zooweb.io.ImageThumb;
import com.uhutu.zooweb.z.entity.ZwSystemDefine;

/**
 * 赛事组件
 * @author 逄小帅
 *
 */
public class MatchComponent {
	
	/*实体bean处理处理实例*/
	private volatile static MatchComponent INSTANCE = null;
	
	/**
	 * 获取实体bean处理实例
	 * @return MatchComponent
	 */
	public static MatchComponent getInstance(){
		
		if(INSTANCE == null){
			
			synchronized (MatchComponent.class) {
				
				if(INSTANCE == null){
					
					INSTANCE = new MatchComponent();
					
				}
				
			}
			
		}
		
		return INSTANCE;
		
	}

	public UserBasicInfo initBasicInfo(String userCode) {

		UserBasicInfo basicInfo = new UserBasicInfo();

		UcUserinfo userinfo = JdbcHelper.queryOne(UcUserinfo.class, "code", userCode);

		UcUserinfoExt userinfoExt = JdbcHelper.queryOne(UcUserinfoExt.class, "userCode", userCode);

		if (userinfo != null) {

			basicInfo.setUserCode(userinfo.getCode());

			basicInfo.setType(userinfo.getType());

		}

		if (userinfoExt != null) {

			basicInfo.setTitle(userinfoExt.getTitle());

			basicInfo.setNickName(userinfoExt.getNickName());

			basicInfo.setAboutHead(userinfoExt.getAboutHead());

		}

		return basicInfo;

	}

	public List<MatchDetailInfo> initDetails(String content, int iWidth) {

		List<MatchDetailInfo> thumbs = new ArrayList<MatchDetailInfo>();

		if (StringUtils.isNotEmpty(content)) {

			String[] args = StringUtils.split(content, ",");

			for (String arg : args) {

				if (StringUtils.isNotEmpty(arg)) {
					
					ImageThumb imageThumb = ImageHelper.upThumbWithHeight(arg, iWidth);
					
					MatchDetailInfo detailInfo = new MatchDetailInfo();
					
					detailInfo.setImageUrl(imageThumb.getThumbUrl());
					
					detailInfo.setImageWh(imageThumb.getThumbWidth()+"*"+imageThumb.getThumbHeight());

					thumbs.add(detailInfo);

				}

			}

		}

		return thumbs;

	}

	public String initFlagName(String code) {

		String name = "";

		if (StringUtils.isNotEmpty(code) && !StringUtils.equals("dzsd4107100110120007", code)) {

			ZwSystemDefine systemDefine = JdbcHelper.queryOne(ZwSystemDefine.class, "code", code);

			name = systemDefine != null ? systemDefine.getDefineName() : "";

		}

		return name;

	}

}
