package com.uhutu.sportcenter.z.api.content;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.sportcenter.z.input.ApiOperContentInput;
import com.uhutu.sportcenter.z.result.ApiOperContentResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 
 * @author 逄小帅
 *
 */
@Component
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
		case "redpack":
			
			operRedPack(input.getContentCode());
			
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
	
	/**
	 * 打赏开关
	 * @param contentCode
	 */
	public void operRedPack(String contentCode){
		
		if(StringUtils.isNotEmpty(contentCode)){
			
			CnContentBasicinfo basicinfo = JdbcHelper.queryOne(CnContentBasicinfo.class, "code", contentCode);
			
			if(basicinfo != null){
				
				String redPackFlag = basicinfo.getRedPackFlag();
					
				redPackFlag = StringUtils.equals(SystemEnum.YES.getCode(), redPackFlag) ? SystemEnum.NO.getCode() : SystemEnum.YES.getCode();
					
				basicinfo.setRedPackFlag(redPackFlag);
				
				JdbcHelper.update(basicinfo, "redPackFlag", "code");
				
			}
			
		}
		
	}

}
