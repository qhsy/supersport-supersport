package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.dcom.answer.z.support.vo.QuestionDetailForshow;
import com.uhutu.dcom.answer.z.support.vo.QuestionForShow;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 问题详情
 *
 */
public class ApiQuestionDetailResult extends RootApiResult {

	@ApiModelProperty(value = "问题详情")
	private QuestionDetailForshow detail = new QuestionDetailForshow();

	@ApiModelProperty(value = "值得一听")
	private List<QuestionForShow> recommons = new ArrayList<QuestionForShow>();

	public QuestionDetailForshow getDetail() {
		return detail;
	}

	public void setDetail(QuestionDetailForshow detail) {
		this.detail = detail;
	}

	public List<QuestionForShow> getRecommons() {
		return recommons;
	}

	public void setRecommons(List<QuestionForShow> recommons) {
		this.recommons = recommons;
	}

}
