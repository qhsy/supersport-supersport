package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.JumpTypeData;
import com.uhutu.sportcenter.z.entity.MatchInfo;
import com.uhutu.sportcenter.z.entity.MatchLiveInfo;
import com.uhutu.sportcenter.z.entity.MatchVidoInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 赛事结果
 * @author 逄小帅
 *
 */
public class ApiMatchInfoResult extends RootApiResult {
	
	@ApiModelProperty(value="赛事信息")
	private MatchInfo matchInfo = new MatchInfo();
	
	@ApiModelProperty(value="赛事直播信息")
	private List<MatchLiveInfo> matchLiveInfos = new ArrayList<MatchLiveInfo>();
	
	@ApiModelProperty(value="赛事视频信息")
	private List<MatchVidoInfo> matchVidoInfos = new ArrayList<MatchVidoInfo>(); 
	
	@ApiModelProperty(value="报名链接")
	private String signUrl = "";
	
	@ApiModelProperty(value="按钮跳转")
	private JumpTypeData linkJumpData;
	
	@ApiModelProperty(value="按钮名称")
	private String buttonName;
	
	@ApiModelProperty(value="是否直接报名")
	private boolean redirectFlag = false;

	public MatchInfo getMatchInfo() {
		return matchInfo;
	}

	public void setMatchInfo(MatchInfo matchInfo) {
		this.matchInfo = matchInfo;
	}

	public List<MatchLiveInfo> getMatchLiveInfos() {
		return matchLiveInfos;
	}

	public void setMatchLiveInfos(List<MatchLiveInfo> matchLiveInfos) {
		this.matchLiveInfos = matchLiveInfos;
	}

	public List<MatchVidoInfo> getMatchVidoInfos() {
		return matchVidoInfos;
	}

	public void setMatchVidoInfos(List<MatchVidoInfo> matchVidoInfos) {
		this.matchVidoInfos = matchVidoInfos;
	}

	public String getSignUrl() {
		return signUrl;
	}

	public void setSignUrl(String signUrl) {
		this.signUrl = signUrl;
	}

	public boolean isRedirectFlag() {
		return redirectFlag;
	}

	public void setRedirectFlag(boolean redirectFlag) {
		this.redirectFlag = redirectFlag;
	}

	public JumpTypeData getLinkJumpData() {
		return linkJumpData;
	}

	public void setLinkJumpData(JumpTypeData linkJumpData) {
		this.linkJumpData = linkJumpData;
	}

	public String getButtonName() {
		return buttonName;
	}

	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}
	

}
