package com.uhutu.dcom.user.z.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用户业务处理
 * 
 * @author pang_jhui
 *
 */
@Component
public class UserServiceFactory {

	@Autowired
	private IUserInfoService userInfoService;

	@Autowired
	private IUserInfoExtService userInfoExtService;

	@Autowired
	private IUserInfoSocialService userInfoSocialService;

	@Autowired
	private IClientInfoService clientInfoService;

	@Autowired
	private IAttentionInfoService attentionInfoService;
	
	@Autowired
	private IMsgPraiseService msgPraiseService;
	
	@Autowired
	private IMsgAttentionService msgAttentionService;
	
	@Autowired
	private IMsgNoticeService msgNoticeService;
	
	@Autowired
	private IMsgRemarkService msgRemarkService;
	
	@Autowired
	private IMsgNoticeUserService msgNoticeUserService;
	
	@Autowired
	private IMsgAdviceService msgAdviceService;
	
	@Autowired
	private IAppVersionService appVersionService;
	
	@Autowired
	private IUserInfoExpertService userInfoExpertService;
	
	@Autowired
	private IUserInfoDonateService userInfoDonateService;
	
	@Autowired
	private IUserAlbumService userAlbumService;
	
	@Autowired
	private IUserDonateInfoService userDonateInfoService;
	
	@Autowired
	private IUserDonateFlowService userDonateFlowService;
	
	/**
	 * 获取用户业务实现
	 * 
	 * @return IUserInfoService
	 */
	public IUserInfoService getUserInfoService() {
		return userInfoService;
	}

	/**
	 * 用户扩展信息业务实现
	 * 
	 * @return IUserInfoExtService
	 */
	public IUserInfoExtService getUserInfoExtService() {
		return userInfoExtService;
	}

	/**
	 * 社交类用户信息业务处理
	 * 
	 * @return IUserInfoSocialService
	 */
	public IUserInfoSocialService getUserInfoSocialService() {
		return userInfoSocialService;
	}

	/**
	 * 用户终端信息业务处理
	 * 
	 * @return clientInfoService
	 */
	public IClientInfoService getClientInfoService() {
		return clientInfoService;
	}

	/**
	 * 关注信息业务处理
	 * @return attentionInfoService
	 */
	public IAttentionInfoService getAttentionInfoService() {
		return attentionInfoService;
	}

	public IMsgPraiseService getMsgPraiseService() {
		return msgPraiseService;
	}

	public IMsgAttentionService getMsgAttentionService() {
		return msgAttentionService;
	}

	public IMsgNoticeService getMsgNoticeService() {
		return msgNoticeService;
	}

	public IMsgRemarkService getMsgRemarkService() {
		return msgRemarkService;
	}

	public IMsgNoticeUserService getMsgNoticeUserService() {
		return msgNoticeUserService;
	}

	public void setMsgNoticeUserService(IMsgNoticeUserService msgNoticeUserService) {
		this.msgNoticeUserService = msgNoticeUserService;
	}

	public IMsgAdviceService getMsgAdviceService() {
		return msgAdviceService;
	}

	public IAppVersionService getAppVersionService() {
		return appVersionService;
	}

	public IUserInfoExpertService getUserInfoExpertService() {
		return userInfoExpertService;
	}

	public IUserInfoDonateService getUserInfoDonateService() {
		return userInfoDonateService;
	}

	public IUserAlbumService getUserAlbumService() {
		return userAlbumService;
	}

	public IUserDonateInfoService getUserDonateInfoService() {
		return userDonateInfoService;
	}

	public IUserDonateFlowService getUserDonateFlowService() {
		return userDonateFlowService;
	}
}
