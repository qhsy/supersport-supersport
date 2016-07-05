package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.QuestionInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 问答偷听结果
 * @author 逄小帅
 *
 */
public class ApiAnswerListenListResult extends RootApiResult {
	
	@ApiModelProperty(value="问答信息列表")
	private List<QuestionInfo> questionInfos = new ArrayList<QuestionInfo>();	
	
	@ApiModelProperty(value="提问的问题总数")
	private int total;
	
	@ApiModelProperty(value="是否还有下页数据")
	private boolean nextFlag;

	public List<QuestionInfo> getQuestionInfos() {
		return questionInfos;
	}

	public void setQuestionInfos(List<QuestionInfo> questionInfos) {
		this.questionInfos = questionInfos;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean isNextFlag() {
		return nextFlag;
	}

	public void setNextFlag(boolean nextFlag) {
		this.nextFlag = nextFlag;
	}
	

}
