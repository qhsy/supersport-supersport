package com.uhutu.sportcenter.z.api.live2;

import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.sportcenter.z.input.ApiChangeCountInput;
import com.uhutu.sportcenter.z.result.ApiChangeCountResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

import io.swagger.annotations.ApiModel;

/**
 * 改变直播数量
 * @author 逄小帅
 *
 */
@ApiModel
@Component
public class ApiChangeCount extends RootApiToken<ApiChangeCountInput, ApiChangeCountResult> {

	@Override
	protected ApiChangeCountResult process(ApiChangeCountInput input) {
		
		ApiChangeCountResult result = new ApiChangeCountResult();
		
		switch (input.getType()) {
		case 1:
			operPraiseCount(input, result);
			break;

		default:
			break;
		}
		
		return result;
	}
	
	public void operPraiseCount(ApiChangeCountInput input, ApiChangeCountResult result){
		
		switch (input.getOptype()) {
		case 0:
			add(input, result);
			break;
		case 1:
			subtract(input, result);
			break;

		default:
			break;
		}
		
	}
	
	public void add(ApiChangeCountInput input, ApiChangeCountResult result){
		
		CnLiveVideoDetail detail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "userCode",input.getUserCode(),"status",ContentEnum.LIVEING.getCode());
		
		if(detail != null){
			
			long praiseNum = detail.getPraise() + 1;
			
			detail.setPraise(praiseNum);
			
			JdbcHelper.update(detail, "praise", "za");
			
		}
		
	}
	
	public void subtract(ApiChangeCountInput input, ApiChangeCountResult result){
		
		CnLiveVideoDetail detail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "userCode",input.getUserCode(),"status",ContentEnum.LIVEING.getCode());
		
		if(detail != null){
			
			long praiseNum = detail.getPraise() - 1;
			
			if(praiseNum < 0){
				
				praiseNum = 0;
				
			}
			
			detail.setPraise(praiseNum);
			
			JdbcHelper.update(detail, "praise", "za");
			
		}
		
	}

}
