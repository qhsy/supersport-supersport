package com.uhutu.dcom.answer.z.support;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.common.AnswerEnum;
import com.uhutu.dcom.answer.z.common.Constants;
import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.answer.z.service.AnswerServiceFactory;
import com.uhutu.dcom.config.enums.SocialEnum;
import com.uhutu.dcom.extend.baiduPush.exception.PushClientException;
import com.uhutu.dcom.extend.baiduPush.exception.PushServerException;
import com.uhutu.dcom.extend.baiduPush.sample.BaiduPush;
import com.uhutu.dcom.extend.baiduPush.sample.PushEnum;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.request.WechatMsgAnswerRequest;
import com.uhutu.dcom.pay.z.request.WechatMsgAskRequest;
import com.uhutu.dcom.pay.z.response.WechatMsgResponse;
import com.uhutu.dcom.pay.z.util.WechatMsgComponent;
import com.uhutu.dcom.user.z.entity.UcClientInfo;
import com.uhutu.dcom.user.z.entity.UcSocialLogin;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.entity.UcUserinfoSocial;
import com.uhutu.dcom.user.z.entity.UserBasicInfo;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 问答消息工具类
 * 
 * @author 逄小帅
 *
 */
@Component
public class AnswerMsgSupport {

	@Autowired
	private UserInfoSupport userInfoSupport;

	@Autowired
	private WechatMsgComponent wechatMsgCompoent;

	@Autowired
	private AnswerServiceFactory answerServiceFactory;

	/**
	 * 发送微信消息
	 * 
	 * @param questionInfo
	 *            问题信息
	 * @return 信息响应
	 */
	public WechatMsgResponse sendAskMsg(AwQuestionInfo questionInfo, String requestUrl) {

		WechatMsgAskRequest askRequest = new WechatMsgAskRequest();

		WechatMsgResponse msgResponse = null;

		UserBasicInfo userBasicInfo = userInfoSupport.getUserBasicInfo(questionInfo.getQuestionUserCode());

		UcUserinfoSocial answerSocial = userInfoSupport.getUserInfoSocial(questionInfo.getAnswerUserCode());

		String content = TopHelper.upInfo(88880015, userBasicInfo.getUcUserinfoExt().getNickName());

		String title = "提问";

		/* 百度push */
		baiduPush(questionInfo.getAnswerUserCode(), title, content + "：" + questionInfo.getContent(),
				Constants.PUSH_JUMP_ANSWERDETAIL, questionInfo.getCode());

		/* 系统push */
		answerServiceFactory.getQuestionInfoService().saveAnswerMsg(title, content + "：" + questionInfo.getContent(),
				questionInfo.getAnswerUserCode());

		if (answerSocial != null) {

			UcSocialLogin socialLogin = JdbcHelper.queryOne(UcSocialLogin.class, "unionid", answerSocial.getAccountId(),
					"type", SocialEnum.wechat_h5.name());

			if (socialLogin != null) {

				askRequest.getFirst().setValue(content + "。");

				askRequest.getKeyword1().setValue(questionInfo.getContent());

				askRequest.getKeyword2().setValue(AnswerEnum.praseText(questionInfo.getScope()));

				askRequest.getKeyword3().setValue(questionInfo.getQuestionTime());

				askRequest.getRemark()
						.setValue(TopHelper.upInfo(88880016, questionInfo.getMoney().setScale(2).toString()));

				msgResponse = wechatMsgCompoent.sendMsg(socialLogin.getOpenid(), requestUrl,
						PayProcessEnum.WECHAT_MSG_ASK, askRequest);

			}

		}

		return msgResponse;

	}

	/**
	 * 发送回答消息
	 * 
	 * @param questionInfo
	 *            问题信息
	 * @param answerUserCode
	 *            回答人用户编号
	 * @return 信息响应
	 */
	public WechatMsgResponse sendAnswerMsg(AwQuestionInfo questionInfo, String answerUserCode, String requestUrl) {

		WechatMsgAnswerRequest answerRequest = new WechatMsgAnswerRequest();

		WechatMsgResponse wechatMsgResponse = null;

		requestUrl = requestUrl + "/webjars/answer/details.html?id=" + questionInfo.getCode();

		requestUrl = TopHelper.upInfo(81110010, requestUrl);

		UcUserinfoExt ucUserinfoExt = userInfoSupport.getUserInfoExt(answerUserCode);

		UcUserinfoSocial ucUserinfoSocial = userInfoSupport.getUserInfoSocial(questionInfo.getQuestionUserCode());

		String content = TopHelper.upInfo(88880019, ucUserinfoExt.getNickName());

		String title = "拒绝回答";

		baiduPush(questionInfo.getQuestionUserCode(), title, content, Constants.PUSH_JUMP_ANSWERDETAIL,
				questionInfo.getCode());

		answerServiceFactory.getQuestionInfoService().saveAnswerMsg(title, content, questionInfo.getQuestionUserCode());

		UcSocialLogin socialLogin = null;

		if (ucUserinfoSocial != null) {

			socialLogin = JdbcHelper.queryOne(UcSocialLogin.class, "unionid", ucUserinfoSocial.getAccountId(), "type",
					SocialEnum.wechat_h5.name());

		}

		if (socialLogin != null) {

			answerRequest.getFirst().setValue(content);

			answerRequest.getKeyword1().setValue(ucUserinfoExt.getNickName());

			answerRequest.getKeyword2().setValue(questionInfo.getAnswerTime());

			answerRequest.getKeyword3().setValue(TopHelper.upInfo(88880020, questionInfo.getLengh()));

			answerRequest.getRemark().setValue(TopHelper.upInfo(88880021));

			wechatMsgResponse = wechatMsgCompoent.sendMsg(socialLogin.getOpenid(), requestUrl,
					PayProcessEnum.WECHAT_MSG_ANSWER, answerRequest);

		}

		return wechatMsgResponse;

	}

	/**
	 * 发送拒绝信息
	 * 
	 * @param questionInfo
	 *            问题信息
	 * @param answerUserCode
	 *            回答用户编号
	 * @param requestUrl
	 *            请求信息
	 * @return
	 */
	public WechatMsgResponse sendRefuseMsg(AwQuestionInfo questionInfo, String answerUserCode, String requestUrl) {

		WechatMsgAnswerRequest answerRequest = new WechatMsgAnswerRequest();

		WechatMsgResponse wechatMsgResponse = null;

		requestUrl = requestUrl + "/webjars/answer/details.html?id=" + questionInfo.getCode();

		requestUrl = TopHelper.upInfo(81110010, requestUrl);

		UcUserinfoExt ucUserinfoExt = userInfoSupport.getUserInfoExt(answerUserCode);

		UcUserinfoSocial ucUserinfoSocial = userInfoSupport.getUserInfoSocial(questionInfo.getQuestionUserCode());

		String title = "拒绝回答";

		String content = TopHelper.upInfo(88880025, ucUserinfoExt.getNickName());

		baiduPush(questionInfo.getQuestionUserCode(), title, content, Constants.PUSH_JUMP_ANSWERDETAIL,
				questionInfo.getCode());

		answerServiceFactory.getQuestionInfoService().saveAnswerMsg(title, content, questionInfo.getQuestionUserCode());

		UcSocialLogin socialLogin = null;

		if (ucUserinfoSocial != null) {

			socialLogin = JdbcHelper.queryOne(UcSocialLogin.class, "unionid", ucUserinfoSocial.getAccountId(), "type",
					SocialEnum.wechat_h5.name());

		}

		if (socialLogin != null) {

			answerRequest.getFirst().setValue(title);

			answerRequest.getKeyword1().setValue(ucUserinfoExt.getNickName());

			answerRequest.getKeyword2().setValue(questionInfo.getAnswerTime());

			answerRequest.getKeyword3().setValue(content);

			answerRequest.getRemark().setValue(TopHelper.upInfo(88880021));

			wechatMsgResponse = wechatMsgCompoent.sendMsg(socialLogin.getOpenid(), requestUrl,
					PayProcessEnum.WECHAT_MSG_ANSWER, answerRequest);

		}

		return wechatMsgResponse;

	}

	/**
	 * 发送拒绝信息
	 * 
	 * @param questionInfo
	 *            问题信息
	 * @param answerUserCode
	 *            回答用户编号
	 * @param requestUrl
	 *            请求信息
	 * @return
	 */
	public WechatMsgResponse sendJobRefuseMsg(AwQuestionInfo questionInfo, String answerUserCode, String requestUrl) {

		WechatMsgAnswerRequest answerRequest = new WechatMsgAnswerRequest();

		WechatMsgResponse wechatMsgResponse = null;

		requestUrl = requestUrl + "/webjars/answer/details.html?id=" + questionInfo.getCode();

		requestUrl = TopHelper.upInfo(81110010, requestUrl);

		UcUserinfoExt ucUserinfoExt = userInfoSupport.getUserInfoExt(answerUserCode);

		UcUserinfoSocial ucUserinfoSocial = userInfoSupport.getUserInfoSocial(questionInfo.getQuestionUserCode());

		String title = "超时未回答";

		String content = TopHelper.upInfo(88880026, ucUserinfoExt.getNickName());

		baiduPush(questionInfo.getQuestionUserCode(), title, content, Constants.PUSH_JUMP_ANSWERDETAIL,
				questionInfo.getCode());

		answerServiceFactory.getQuestionInfoService().saveAnswerMsg(title, content, questionInfo.getQuestionUserCode());

		UcSocialLogin socialLogin = null;

		if (ucUserinfoSocial != null) {

			socialLogin = JdbcHelper.queryOne(UcSocialLogin.class, "unionid", ucUserinfoSocial.getAccountId(), "type",
					SocialEnum.wechat_h5.name());

		}

		if (socialLogin != null) {

			answerRequest.getFirst().setValue(title);

			answerRequest.getKeyword1().setValue(ucUserinfoExt.getNickName());

			answerRequest.getKeyword2().setValue(questionInfo.getAnswerTime());

			answerRequest.getKeyword3().setValue(content);

			answerRequest.getRemark().setValue(TopHelper.upInfo(88880021));

			wechatMsgResponse = wechatMsgCompoent.sendMsg(socialLogin.getOpenid(), requestUrl,
					PayProcessEnum.WECHAT_MSG_ANSWER, answerRequest);

		}

		return wechatMsgResponse;

	}

	/**
	 * 百度push
	 * 
	 * @param answerUserCode
	 *            用户编号
	 * @param title
	 *            标题
	 * @param content
	 *            内容
	 * @param jumpType
	 *            推送跳转类型 0个人中心 1运动时刻详情页 2首页 3问达详情页
	 * @param jumpJson
	 *            推送跳转内容
	 */
	public void baiduPush(String userCode, String title, String content, String jumpType, String jumpContent) {

		try {

			UcClientInfo ucClientInfo = JdbcHelper.queryOne(UcClientInfo.class, "", "-zc", "",
					MapHelper.initMap("user_code", userCode, "os", "ios"));

			if (ucClientInfo != null && StringUtils.isNotBlank(ucClientInfo.getChannelId())) {
				new BaiduPush().push(PushEnum.ios, title, content, ucClientInfo.getChannelId(), jumpType, jumpContent);
			}

			UcClientInfo android = JdbcHelper.queryOne(UcClientInfo.class, "", "-zc", "",
					MapHelper.initMap("user_code", userCode, "os", "android"));

			if (android != null && StringUtils.isNotBlank(android.getChannelId())) {
				new BaiduPush().push(PushEnum.android, title, content, android.getChannelId(), jumpType, jumpContent);
			}

		} catch (PushServerException e) {

			e.printStackTrace();

		} catch (PushClientException e) {

			e.printStackTrace();

		}

	}

}
