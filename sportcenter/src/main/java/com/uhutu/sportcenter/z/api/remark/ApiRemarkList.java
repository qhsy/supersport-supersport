package com.uhutu.sportcenter.z.api.remark;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.remark.z.entity.CnContentRemark;
import com.uhutu.dcom.remark.z.service.ContentRemarkServiceFactory;
import com.uhutu.sportcenter.z.entity.ContentRemarkInfo;
import com.uhutu.sportcenter.z.input.ApiRemarkListInput;
import com.uhutu.sportcenter.z.result.ApiRemarkListResult;
import com.uhutu.zoocom.root.RootApiBase;
/**
 * 评论信息列表
 * @author 逄小帅
 *
 */
@Component
public class ApiRemarkList extends RootApiBase<ApiRemarkListInput, ApiRemarkListResult> {
	
	@Autowired
	private ContentRemarkServiceFactory serviceFactory;

	@Override
	protected ApiRemarkListResult process(ApiRemarkListInput input) {
		
		ApiRemarkListResult remarkListResult = new ApiRemarkListResult();
		
		QueryConditions conditions = new QueryConditions();
		
		conditions.setConditionEqual("contentCode", input.getContentCode());
		
		Page<CnContentRemark> remarkPage = serviceFactory.getContentRemarkService().queryPage(input.getPagination(), 10, conditions);
		
		if(remarkPage.hasNext()){
			
			remarkListResult.setNextflag(true);
			
		}
		
		List<ContentRemarkInfo> remarkInfos = new ArrayList<ContentRemarkInfo>();
		
		remarkPage.getContent().forEach(remark -> {
			
			ContentRemarkInfo remarkInfo = new ContentRemarkInfo();
			
			BeanUtils.copyProperties(remark, remarkInfo);
			
			remarkInfos.add(remarkInfo);
			
		});
		
		remarkListResult.setContentRemarkInfo(remarkInfos);
		
		return remarkListResult;
		
	}

}
