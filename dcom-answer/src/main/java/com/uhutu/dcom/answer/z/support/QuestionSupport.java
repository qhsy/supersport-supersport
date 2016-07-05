package com.uhutu.dcom.answer.z.support;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.dcom.answer.z.entity.AwPointRecommen;
import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.answer.z.support.vo.AnswerForShow;
import com.uhutu.dcom.answer.z.support.vo.QuestionForShow;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootClass;
import com.uhutu.zoodata.z.helper.JdbcHelper;

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
		if(page>0&&num>0){
			List<AwPointRecommen> recommens = JdbcHelper.queryForList(AwPointRecommen.class, "", " sort desc ", " type='dzsd4888100110030001'", new MDataMap(),(page-1)*num,num);
			if(recommens!=null&&!recommens.isEmpty()&&recommens.size()>0){
				
			}else {
				List<AwQuestionInfo>  others = JdbcHelper.queryForList(AwQuestionInfo.class, "", "listen desc", "scope='dzsd4888100110020002' and status='dzsd4888100110010002'", new MDataMap(), 0, 0);
			}
			
			
		}
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
