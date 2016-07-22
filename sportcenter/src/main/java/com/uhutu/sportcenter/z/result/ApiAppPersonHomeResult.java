package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.AnswerUserInfo;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.entity.QuestionInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 个人首页展示
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiAppPersonHomeResult extends RootApiResult {
	
	@ApiModelProperty(value="问答用户信息")
	private AnswerUserInfo answerUserInfo;
	
	@ApiModelProperty(value="回答过的问题列表")
	private List<QuestionInfo> questionInfos = new ArrayList<QuestionInfo>();
	
	@ApiModelProperty(value="运动时刻")
	private List<ContentBasicinfoForApi> contentInfos = new ArrayList<ContentBasicinfoForApi>();
	
	@ApiModelProperty(value="是否本人")
	private boolean ownFlag = false;

	public AnswerUserInfo getAnswerUserInfo() {
		return answerUserInfo;
	}

	public void setAnswerUserInfo(AnswerUserInfo answerUserInfo) {
		this.answerUserInfo = answerUserInfo;
	}

	public List<QuestionInfo> getQuestionInfos() {
		return questionInfos;
	}

	public void setQuestionInfos(List<QuestionInfo> questionInfos) {
		this.questionInfos = questionInfos;
	}

	public boolean isOwnFlag() {
		return ownFlag;
	}

	public void setOwnFlag(boolean ownFlag) {
		this.ownFlag = ownFlag;
	}

	public List<ContentBasicinfoForApi> getContentInfos() {
		return contentInfos;
	}

	public void setContentInfos(List<ContentBasicinfoForApi> contentInfos) {
		this.contentInfos = contentInfos;
	}


	
	

}
