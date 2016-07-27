package com.uhutu.sportcenter.z.entity;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户问题信息tab
 * @author 逄小帅
 *
 */
public class UserQuestionTabInfo {
	
	@ApiModelProperty(value="是否还有下页数据")
	private boolean nextflag = false;
	
	@ApiModelProperty(value="回答过的问题列表")
	private List<QuestionInfo> questionInfos = new ArrayList<QuestionInfo>();

	public boolean isNextflag() {
		return nextflag;
	}

	public void setNextflag(boolean nextflag) {
		this.nextflag = nextflag;
	}

	public List<QuestionInfo> getQuestionInfos() {
		return questionInfos;
	}

	public void setQuestionInfos(List<QuestionInfo> questionInfos) {
		this.questionInfos = questionInfos;
	}

}
