package com.uhutu.sportcenter.z.api.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.util.ApplicationSupport;
import com.uhutu.dcom.content.z.entity.CnContentReadCount;
import com.uhutu.dcom.content.z.entity.CnSupportPraise;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.remark.z.entity.CnContentMake;
import com.uhutu.dcom.remark.z.enums.RemarkEnum;
import com.uhutu.dcom.remark.z.service.ContentRemarkServiceFactory;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.z.bean.TopUserFactory;
import com.uhutu.zoodata.z.helper.JdbcHelper;

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

	/**
	 * 根据内容编号获取点赞数量
	 * 
	 * @param contentCode
	 *            内容编号
	 * @return 点赞数量
	 */
	public static int praiseNum(String contentCode) {

		int praiseNum = 0;

		if (StringUtils.isNotEmpty(contentCode)) {

			ContentServiceFactory contentServiceFactory = (ContentServiceFactory) ApplicationSupport
					.getBean("contentServiceFactory");

			praiseNum = contentServiceFactory.getSupportPraiseService().queryCountByCode(contentCode,
					ContentEnum.FAVOR_STATUS_YES.getCode());

		}

		return praiseNum;

	}

	/**
	 * 根据内容编号查询阅读数量
	 * 
	 * @param contentCode
	 *            内容编号
	 * @return
	 */
	public static int readNum(String contentCode) {

		int readNum = 0;

		CnContentReadCount contentReadCount = JdbcHelper.queryOne(CnContentReadCount.class, "contentCode", contentCode);

		if (contentReadCount != null) {

			readNum = contentReadCount.getCount();

		}

		return readNum;

	}

	/**
	 * 根据内容编号查询评论数量
	 * 
	 * @param contentCode
	 *            内容编号
	 * @return
	 */
	public static int remarkNum(String contentCode) {

		ContentRemarkServiceFactory remarkServiceFactory = (ContentRemarkServiceFactory) ApplicationSupport
				.getBean("contentRemarkServiceFactory");

		int remarkNum = remarkServiceFactory.getContentRemarkService().queryCount(contentCode,
				RemarkEnum.FLAG_ENABLE.getCode());

		return remarkNum;

	}

	public static boolean oneLogin(String userCode, String token) {

		boolean flag = false;

		String uc = TopUserFactory.upUserCallFactory().upUserCodeByAuthToken(token, DefineUser.Login_System_Default);

		if (StringUtils.isNotBlank(uc) && StringUtils.isNotBlank(userCode) && uc.equals(userCode)) {
			flag = true;
		}
		return flag;

	}

	public static boolean makeFlag(String contentCode, String token) {
		boolean flag = false;
		if (StringUtils.isNotBlank(token) && StringUtils.isNotBlank(contentCode)) {
			CnContentMake make = JdbcHelper.queryOne(CnContentMake.class, "status", "1", "content_code", contentCode,
					"user_code",
					TopUserFactory.upUserCallFactory().upUserCodeByAuthToken(token, DefineUser.Login_System_Default));
			flag = make != null ? true : false;
		}
		return flag;
	}

}
