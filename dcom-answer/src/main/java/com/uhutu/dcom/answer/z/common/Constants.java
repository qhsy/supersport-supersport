package com.uhutu.dcom.answer.z.common;

/**
 * 问答常量类
 * 
 * @author 逄小帅
 *
 */
public class Constants {

	/** 问题状态：待回答 */
	public static final String STATUS_UNANSWER = "dzsd4888100110010001";

	/** 问题状态：已回答 */
	public static final String STATUS_ANSWERED = "dzsd4888100110010002";

	/** 问题状态：拒绝回答 */
	public static final String STATUS_REANSWER = "dzsd4888100110010003";

	/** 问题状态：到期未答 */
	public static final String STATUS_OVERTIME = "dzsd4888100110010004";

	/** 问题状态：已撤回 */
	public static final String STATUS_RECALL = "dzsd4888100110010005";

	/** 问题状态：待付款 */
	public static final String STATUS_UNPAY = "dzsd4888100110010006";
	// 0个人中心 1文章 2图集 3单图 4 单视频 5首页 6问达详情页
	/** 推送跳转类型： 个人中心 */
	public static final String PUSH_JUMP_PERSONCENTER = "0";

	/** 推送跳转类型：运动时刻详情页 文章 */
	public static final String PUSH_JUMP_SPORTTIME = "1";

	/** 推送跳转类型：运动时刻详情页 图集 */
	public static final String PUSH_JUMP_SPORTTIMETJ = "2";

	/** 推送跳转类型：运动时刻详情页 文章 */
	public static final String PUSH_JUMP_SPORTTIMESP = "3";

	/** 推送跳转类型：运动时刻详情页 文章 */
	public static final String PUSH_JUMP_SPORTTIMESV = "4";

	/** 推送跳转类型：首页 */
	public static final String PUSH_JUMP_HOMEPAGE = "5";

	/** 推送跳转类型：问达详情页 */
	public static final String PUSH_JUMP_ANSWERDETAIL = "6";
	
	/** 推送跳转类型：消息中心 */
	public static final String PUSH_JUMP_MSGCENTER = "7";
	
	/** 推送跳转类型：超链接 */
	public static final String PUSH_JUMP_URL = "8";
}
