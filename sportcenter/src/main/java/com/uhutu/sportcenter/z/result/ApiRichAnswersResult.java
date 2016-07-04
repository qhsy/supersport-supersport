package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.dcom.answer.z.support.vo.AnswerForShow;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 才华排行
 * 
 * @author xiegj
 *
 */
@ApiModel
public class ApiRichAnswersResult extends RootApiResult {

	@ApiModelProperty(value = "热门问题")
	private List<AnswerForShow> answers = new ArrayList<AnswerForShow>();

	public List<AnswerForShow> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerForShow> answers) {
		this.answers = answers;
	}

}
