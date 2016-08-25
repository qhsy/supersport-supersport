package com.uhutu.sportcenter.z.api.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.component.z.util.ApplicationSupport;
import com.uhutu.dcom.content.z.entity.CnSupportPraise;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.z.bean.TopUserFactory;

/**
 * 内容相关方法
 * 
 * @author 逄小帅
 *
 */
@Component
public class ContentComponent {

	public static boolean lightFavor(String contentCode, String token) {

		boolean flag = false;

		String userCode = TopUserFactory.upUserCallFactory().upUserCodeByAuthToken(token,
				DefineUser.Login_System_Default);

		if (StringUtils.isNotBlank(userCode)) {

			ContentServiceFactory contentServiceFactory = (ContentServiceFactory) ApplicationSupport
					.getBean("contentServiceFactory");

			/* 01点赞 */
			CnSupportPraise praise = contentServiceFactory.getSupportPraiseService().query(contentCode, userCode, "01");

			if (praise != null && StringUtils.equals(praise.getStatus(), ContentEnum.FAVOR_STATUS_YES.getCode())) {

				flag = true;

			}

		}

		return flag;

	}

	public static boolean oneLogin(String userCode, String token) {

		boolean flag = false;

		String uc = TopUserFactory.upUserCallFactory().upUserCodeByAuthToken(token, DefineUser.Login_System_Default);

		if (StringUtils.isNotBlank(uc) && StringUtils.isNotBlank(userCode) && uc.equals(userCode)) {
			flag = true;
		}
		return flag;

	}

}
