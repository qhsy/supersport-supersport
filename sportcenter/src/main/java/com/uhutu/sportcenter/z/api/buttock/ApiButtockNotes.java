package com.uhutu.sportcenter.z.api.buttock;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiButtockNotesInput;
import com.uhutu.sportcenter.z.result.ApiButtockNotesResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 美臀大赛-活动须知
 * 
 * @author jack
 *
 */
@Component
public class ApiButtockNotes extends RootApiBase<ApiButtockNotesInput, ApiButtockNotesResult> {

	@Override
	protected ApiButtockNotesResult process(ApiButtockNotesInput input) {
		String str = "为翘而生美臀大赛海选Top30人气学员集结「人气榜」，快为你最喜欢的选手点赞！最佳人气奖由你们来决定！\n【8月27号北京朝阳公园海沙节线下决赛，敬请关注！】";
		ApiButtockNotesResult result = new ApiButtockNotesResult();
		result.setNotes(str);
		return result;
	}

}
