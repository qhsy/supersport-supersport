package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 消息通知
 * @author 逄小帅
 *
 */
public class ApiMsgNoticeInfo {
	
	@ApiModelProperty(value="图标信息")
	private String iconUrl;
	
	@ApiModelProperty(value="标题信息")
	private String title;
	
	@ApiModelProperty(value="消息内容")
	private MsgNoticeInfo msgNoticeInfo;

}
