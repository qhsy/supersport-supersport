package com.uhutu.dcom.answer.z.support;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.activity.z.entity.AcActivityAnswerInfo;
import com.uhutu.dcom.activity.z.support.AnswerActivitySupport;
import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.dcom.answer.z.entity.AwPointRecommen;
import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.answer.z.properties.ConfigDcomAnswer;
import com.uhutu.dcom.answer.z.support.vo.AnswerForShow;
import com.uhutu.dcom.answer.z.support.vo.QuestionForShow;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
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
		List<AwQuestionInfo> questions = new ArrayList<AwQuestionInfo>();
		if (page > 0 && num > 0) {

			List<AwPointRecommen> res = JdbcHelper.queryForList(AwPointRecommen.class, "", " sort desc ",
					" type='dzsd4888100110030001'", new MDataMap());
			if (res != null && !res.isEmpty() && res.size() > 0 && res.size() > (page - 1) * num) {
				List<AwPointRecommen> pres = new ArrayList<AwPointRecommen>();
				if (res.size() < page * num) {
					pres = res.subList((page - 1) * num, res.size());
				} else if (res.size() >= page * num) {
					pres = res.subList((page - 1) * num, page * num);
				}
				StringBuffer relCodes = new StringBuffer();
				if (pres != null && !pres.isEmpty() && pres.size() > 0) {
					for (int i = 0; i < pres.size(); i++) {
						if (i == pres.size() - 1) {
							relCodes.append("'" + pres.get(i).getAnswerCode() + "'");
						} else {
							relCodes.append("'" + pres.get(i).getAnswerCode() + "',");
						}
					}
					if(StringUtils.isNotBlank(relCodes.toString())){
						questions = JdbcHelper.queryForList(AwQuestionInfo.class, ""," field(code," + relCodes.toString() + ")", " code in(" + relCodes.toString() + ")", new MDataMap());
					}
				}
			}
			if(questions==null){
				questions=new ArrayList<AwQuestionInfo>();
			}
			List<AwQuestionInfo> others = JdbcHelper.queryForList(AwQuestionInfo.class, "", "listen desc",
					"scope='dzsd4888100110020002' and status='dzsd4888100110010002' and code not in (select answer_code from aw_point_recommen where type='dzsd4888100110030001')",
					new MDataMap(), (page - 1) * num-questions.size(), num-questions.size());
			questions.addAll(others);
			if(questions!=null&&!questions.isEmpty()&&questions.size()>0){
				for (int i = 0; i < questions.size(); i++) {
					AwQuestionInfo info = questions.get(i);
					QuestionForShow show = new QuestionForShow();
					show.setCode(info.getCode());
					show.setContent(info.getContent());
					show.setListen(info.getListen());
					show.setLength(info.getLengh());
					show.setSoundContent(ConfigDcomAnswer.upConfig().getAnswerVideoShow());
					AcActivityAnswerInfo activityInfo = new AnswerActivitySupport().getActivityInfoByAnswerCode(info.getCode());
					if(activityInfo!=null){
						show.setSoundContent(activityInfo.getName());
					}
					UcUserinfoExt ext = JdbcHelper.queryOne(UcUserinfoExt.class, "user_code",info.getAnswerUserCode());
					AwAnswerExpert expert = JdbcHelper.queryOne(AwAnswerExpert.class, "user_code",info.getAnswerUserCode());
					show.setHeadUrl(ext.getAboutHead());
					show.setNickName(ext.getNickName());
					show.setTitle(expert.getTitle());
					show.setUserCode(info.getAnswerUserCode());
					result.add(show);
				}
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
		List<AwQuestionInfo> questions = new ArrayList<AwQuestionInfo>();
		if (page > 0 && num > 0) {

			List<AwPointRecommen> res = JdbcHelper.queryForList(AwPointRecommen.class, "", " sort desc ",
					" type='dzsd4888100110030002'", new MDataMap());
			if (res != null && !res.isEmpty() && res.size() > 0 && res.size() > (page - 1) * num) {
				List<AwPointRecommen> pres = new ArrayList<AwPointRecommen>();
				if (res.size() < page * num) {
					pres = res.subList((page - 1) * num, res.size());
				} else if (res.size() >= page * num) {
					pres = res.subList((page - 1) * num, page * num);
				}
				StringBuffer relCodes = new StringBuffer();
				if (pres != null && !pres.isEmpty() && pres.size() > 0) {
					for (int i = 0; i < pres.size(); i++) {
						if (i == pres.size() - 1) {
							relCodes.append("'" + pres.get(i).getAnswerCode() + "'");
						} else {
							relCodes.append("'" + pres.get(i).getAnswerCode() + "',");
						}
					}
					if(StringUtils.isNotBlank(relCodes.toString())){
						questions = JdbcHelper.queryForList(AwQuestionInfo.class, ""," field(code," + relCodes.toString() + ")", " code in(" + relCodes.toString() + ")", new MDataMap());
					}
				}
			}
			if(questions==null){
				questions=new ArrayList<AwQuestionInfo>();
			}
			List<AwQuestionInfo> others = JdbcHelper.queryForList(AwQuestionInfo.class, "", "listen desc",
					"scope='dzsd4888100110020002' and status='dzsd4888100110010002' and code not in (select answer_code from aw_point_recommen where type='dzsd4888100110030002')",
					new MDataMap(), (page - 1) * num-questions.size(), num-questions.size());
			questions.addAll(others);
			if(questions!=null&&!questions.isEmpty()&&questions.size()>0){
				for (int i = 0; i < questions.size(); i++) {
					AwQuestionInfo info = questions.get(i);
					QuestionForShow show = new QuestionForShow();
					show.setCode(info.getCode());
					show.setContent(info.getContent());
					show.setListen(info.getListen());
					show.setLength(info.getLengh());
					show.setSoundContent(ConfigDcomAnswer.upConfig().getAnswerVideoShow());
					AcActivityAnswerInfo activityInfo = new AnswerActivitySupport().getActivityInfoByAnswerCode(info.getCode());
					if(activityInfo!=null){
						show.setSoundContent(activityInfo.getName());
					}
					UcUserinfoExt ext = JdbcHelper.queryOne(UcUserinfoExt.class, "user_code",info.getAnswerUserCode());
					AwAnswerExpert expert = JdbcHelper.queryOne(AwAnswerExpert.class, "user_code",info.getAnswerUserCode());
					show.setHeadUrl(ext.getAboutHead());
					show.setNickName(ext.getNickName());
					show.setTitle(expert.getTitle());
					show.setUserCode(info.getAnswerUserCode());
					result.add(show);
				}
			}
		}
		return result;
	}

	/**
	 * 才华排行
	 * 
	 * @param page
	 * @param num
	 * @return list
	 */
	public List<AnswerForShow> getHotAnswers(int page, int num) {
		List<AnswerForShow> result = new ArrayList<AnswerForShow>();
		return result;
	}

}
