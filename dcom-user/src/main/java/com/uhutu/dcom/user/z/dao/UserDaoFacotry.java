package com.uhutu.dcom.user.z.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用户数据访问
 * 
 * @author pang_jhui
 *
 */
@Component
public class UserDaoFacotry {

	@Autowired
	private IUserInfoDao userInfoDao;

	@Autowired
	private IUserInfoExtDao userInfoExtDao;

	@Autowired
	private IUserInfoSocialDao userInfoSocialDao;

	@Autowired
	private IClientInfoDao clientInfoDao;

	@Autowired
	private IAttentionInfoDao attentionInfoDao;
	
	@Autowired
	private IMsgAttentionDao msgAttentionDao;
	
	@Autowired
	private IMsgNoticeDao msgNoticeDao;
	
	@Autowired
	private IMsgPraiseDao msgPraiseDao;
	
	@Autowired
	private IMsgRemarkDao msgRemarkDao;
	
	@Autowired
	private IMsgNoticeUserDao msgNoticeUserDao;
	
	@Autowired
	private IMsgAdviceDao msgAdviceDao;
	
	@Autowired
	private IAppVersionDao appVersionDao;
	
	@Autowired
	private IUserInfoExpertDao userInfoExpertDao;
	
	@Autowired
	private IUserInfoDonateDao userInfoDonateDao;
	
	@Autowired
	private IUserAlbumDao userAlbumDao;
	
	@Autowired
	private IUserDonateInfoDao userDonateInfoDao;
	
	@Autowired
	private IUserDonateFlowDao userDonateFlowDao;
	
	@Autowired
	private IUserDonateDeviceDao userDonateDeviceDao;
	
	@Autowired
	private IUserSocialLoginDao userSocialLoginDao;
	
	@Autowired
	private IMsgAnswerDao msgAnswerDao;

	/**
	 * 用户信息数据访问
	 * 
	 * @return
	 */
	public IUserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	/**
	 * 用户扩展信息数据访问
	 * 
	 * @return
	 */
	public IUserInfoExtDao getUserInfoExtDao() {
		return userInfoExtDao;
	}

	/**
	 * 社交类账户数据访问
	 * 
	 * @return
	 */
	public IUserInfoSocialDao getUserInfoSocialDao() {
		return userInfoSocialDao;
	}

	/**
	 * 启动终端信息数据访问
	 */
	public IClientInfoDao getClientInfoDao() {
		return clientInfoDao;
	}

	/**
	 * 关注信息数据访问
	 */
	public IAttentionInfoDao getAttentionInfoDao() {
		return attentionInfoDao;
	}

	/**
	 * 关注消息通知
	 * @return
	 */
	public IMsgAttentionDao getMsgAttentionDao() {
		return msgAttentionDao;
	}

	/**
	 * 消息通知
	 * @return
	 */
	public IMsgNoticeDao getMsgNoticeDao() {
		return msgNoticeDao;
	}

	/**
	 * 点赞消息通知
	 * @return
	 */
	public IMsgPraiseDao getMsgPraiseDao() {
		return msgPraiseDao;
	}

	/**
	 * 评论消息
	 * @return
	 */
	public IMsgRemarkDao getMsgRemarkDao() {
		return msgRemarkDao;
	}

	public IMsgNoticeUserDao getMsgNoticeUserDao() {
		return msgNoticeUserDao;
	}

	public IMsgAdviceDao getMsgAdviceDao() {
		return msgAdviceDao;
	}

	public IAppVersionDao getAppVersionDao() {
		return appVersionDao;
	}

	public IUserInfoExpertDao getUserInfoExpertDao() {
		return userInfoExpertDao;
	}

	public IUserInfoDonateDao getUserInfoDonateDao() {
		return userInfoDonateDao;
	}

	public IUserAlbumDao getUserAlbumDao() {
		return userAlbumDao;
	}

	public IUserDonateInfoDao getUserDonateInfoDao() {
		return userDonateInfoDao;
	}

	public IUserDonateFlowDao getUserDonateFlowDao() {
		return userDonateFlowDao;
	}

	public IUserDonateDeviceDao getUserDonateDeviceDao() {
		return userDonateDeviceDao;
	}

	public IUserSocialLoginDao getUserSocialLoginDao() {
		return userSocialLoginDao;
	}

	public IMsgAnswerDao getMsgAnswerDao() {
		return msgAnswerDao;
	}

}
