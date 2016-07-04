package com.uhutu.dcom.answer.z.support;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.dcom.answer.z.support.vo.AnswerForShow;
import com.uhutu.dcom.answer.z.support.vo.QuestionForShow;
import com.uhutu.zoocom.root.RootClass;

public class QuestionSupport extends RootClass {

	/**
	 * 热门问题排行
	 * 
	 * @param page
	 *            第几页
	 * @param num
	 *            每页显示数量
	 * @return list
	 */
	public List<QuestionForShow> getHotQuestions(int page, int num) {
		List<QuestionForShow> result = new ArrayList<QuestionForShow>();
		
		return result;
	}

	/**
	 * 最新问题排行
	 * 
	 * @param page
	 *            第几页
	 * @param num
	 *            每页显示数量
	 * @return list
	 */
	public List<QuestionForShow> getNewQuestions(int page, int num) {
		List<QuestionForShow> result = new ArrayList<QuestionForShow>();

		return result;
	}

	/**
	 * 才华排行
	 * @param page
	 * @param num
	 * @return list
	 */
	public List<AnswerForShow> getHotAnswers(int page, int num) {
		List<AnswerForShow> result = new ArrayList<AnswerForShow>();

		return result;

	}
}
