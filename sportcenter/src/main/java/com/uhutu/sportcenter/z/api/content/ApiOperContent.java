package com.uhutu.sportcenter.z.api.content;

import org.springframework.beans.factory.annotation.Autowired;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.sportcenter.z.input.ApiOperContentInput;
import com.uhutu.sportcenter.z.result.ApiOperContentResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 
 * @author 逄小帅
 *
 */
public class ApiOperContent extends RootApiToken<ApiOperContentInput, ApiOperContentResult> {
	
	@Autowired
	private ContentServiceFactory serviceFactory;

	@Override
	protected ApiOperContentResult process(ApiOperContentInput input) {
		
		ApiOperContentResult result = new ApiOperContentResult();
		
		switch (input.getOperFlag()) {
		case "delete":
			
			delete(input.getContentCode());
			
			break;

		default:
			break;
		}
		
		return result;
	}
	
	/**
	 * 根据内容编号逻辑删除内容
	 * @param contentCode
	 */
	public int delete(String contentCode){
		
		return serviceFactory.getContentBasicinfoService().updateStatus(contentCode, ContentEnum.invalid.getCode());
		
	}

}
