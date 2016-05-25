package com.uhutu.sportcenter.z.api.remark;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnSupportPraise;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.remark.z.enums.RemarkEnum;
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
			remarkCount(input,remarkCountResult);
			break;
		case "favorCount":
			favorCount(input,remarkCountResult);
			break;
		default:
			remarkCount(input,remarkCountResult);
			favorCount(input,remarkCountResult);
			break;
		}

		return remarkCountResult;

	}
	
	public void remarkCount(ApiRemarkCountInput input,ApiRemarkCountResult remarkCountResult){
		
		int total = serviceFactory.getContentRemarkService().queryCount(input.getContentCode());
		
		RemarkInfo remarkInfo = new RemarkInfo();
		
		remarkInfo.setType("remarkCount");
		
		remarkInfo.setTotal(total);
		
		remarkInfo.setFavor(lightFavor(input));
		
		remarkCountResult.getList().add(remarkInfo);
		
	}
	
	public void favorCount(ApiRemarkCountInput input,ApiRemarkCountResult remarkCountResult){
		
		int total = contentServiceFactory.getSupportPraiseService().queryCountByCode(input.getContentCode());
		
		RemarkInfo remarkInfo = new RemarkInfo();
		
		remarkInfo.setType("favorCount");
		
		remarkInfo.setTotal(total);
		
		remarkInfo.setFavor(lightFavor(input));
		
		remarkCountResult.getList().add(remarkInfo);
		
	}
	
	public String lightFavor(ApiRemarkCountInput input){
		
		String iffavor = RemarkEnum.ICON_DARK.getCode();
		
		/*01点赞*/
		CnSupportPraise praise = contentServiceFactory.getSupportPraiseService().query(input.getContentCode(),input.getZoo().getToken(), "01");
		
		if(praise != null && StringUtils.equals(praise.getStatus(), "1")){
			
			iffavor = RemarkEnum.ICON_LIGHT.getCode();
			
		}
		
		return iffavor;
		
	}

}
