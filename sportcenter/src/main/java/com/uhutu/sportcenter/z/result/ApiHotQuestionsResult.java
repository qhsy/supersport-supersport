package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.dcom.answer.z.support.vo.QuestionForShow;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 热门问题
 * 
 * @author xiegj
 *
 */
@ApiModel
public class ApiHotQuestionsResult extends RootApiResult {

	@ApiModelProperty(value = "热门问题")
	private List<QuestionForShow> questions = new ArrayList<QuestionForShow>();

	public List<QuestionForShow> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionForShow> questions) {
		this.questions = questions;
	}

}
