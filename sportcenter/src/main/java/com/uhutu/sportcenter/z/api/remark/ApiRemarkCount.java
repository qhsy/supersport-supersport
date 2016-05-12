package com.uhutu.sportcenter.z.api.remark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.remark.z.service.ContentRemarkServiceFactory;
import com.uhutu.sportcenter.z.entity.RemarkInfo;
import com.uhutu.sportcenter.z.input.ApiRemarkCountInput;
import com.uhutu.sportcenter.z.result.ApiRemarkCountResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 各种评论数量
 * @author 逄小帅
 *
 */
@Component
public class ApiRemarkCount extends RootApiBase<ApiRemarkCountInput, ApiRemarkCountResult> {

	@Autowired
	private ContentRemarkServiceFactory serviceFactory;
	
	@Autowired
	private ContentServiceFactory contentServiceFactory;
	
	@Override
	protected ApiRemarkCountResult process(ApiRemarkCountInput input) {

		ApiRemarkCountResult remarkCountResult = new ApiRemarkCountResult();

		switch (input.getType()) {
		case "remarkCount":
			remarkCount(input.getContentCode(),remarkCountResult);
			break;
		case "favorCount":
			favorCount(input.getContentCode(),remarkCountResult);
			break;
		default:
			break;
		}

		return remarkCountResult;

	}
	
	public void remarkCount(String contentCode,ApiRemarkCountResult remarkCountResult){
		
		int total = serviceFactory.getContentRemarkService().queryCount(contentCode);
		
		RemarkInfo remarkInfo = new RemarkInfo();
		
		remarkInfo.setType("remarkCount");
		
		remarkInfo.setTotal(total);
		
		remarkCountResult.getList().add(remarkInfo);
		
	}
	
	public void favorCount(String contentCode,ApiRemarkCountResult remarkCountResult){
		
		int total = contentServiceFactory.getSupportPraiseService().queryCountByCode(contentCode);
		
		RemarkInfo remarkInfo = new RemarkInfo();
		
		remarkInfo.setType("favorCount");
		
		remarkInfo.setTotal(total);
		
		remarkCountResult.getList().add(remarkInfo);
		
	}

}
