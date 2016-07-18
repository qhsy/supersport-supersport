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
		String str = "活动须知:\n1、凡参赛选手，上传的翘臀照片将在「实力派」中展示，找到自己的美臀，转发集赞吧！\n2、只要你是果冻体育用户，晒出你的翘臀照片，就有机会获得每日开出的奖品，照片将会在「翘丽圈」展示";
		ApiButtockNotesResult result = new ApiButtockNotesResult();
		result.setNotes(str);
		return result;
	}

}
