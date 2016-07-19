package com.uhutu.sportcenter.z.api.buttock;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.entity.ButtockInfo;
import com.uhutu.sportcenter.z.input.ApiButtockInfoInput;
import com.uhutu.sportcenter.z.input.ApiButtockLapListInput;
import com.uhutu.sportcenter.z.input.ApiButtockNotesInput;
import com.uhutu.sportcenter.z.input.ApiButtockPowerListInput;
import com.uhutu.sportcenter.z.result.ApiButtockInfoResult;
import com.uhutu.sportcenter.z.result.ApiButtockLapListResult;
import com.uhutu.sportcenter.z.result.ApiButtockPowerListResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 美臀大赛相关信息
 * @author 逄小帅
 *
 */
@Component
public class ApiButtockInfo extends RootApiBase<ApiButtockInfoInput, ApiButtockInfoResult> {

	@Autowired
	private ApiButtockNotes apiButtockNotes;
	
	@Autowired
	private ApiButtockLapList apiButtockLapList;
	
	@Autowired
	private ApiButtockPowerList apiButtockPowerList;
	
	@Override
	protected ApiButtockInfoResult process(ApiButtockInfoInput input) {
		
		ApiButtockInfoResult result = new ApiButtockInfoResult();
		
		result.setNotes(apiButtockNotes.process(new ApiButtockNotesInput()).getNotes());
		
		try {
			
			if(StringUtils.isNotBlank(input.getType())){
				
				ButtockType buttockType = ButtockType.valueOf(input.getType());
				
				switch (buttockType) {
				case lap:
					result.getButtockInfos().add(initLapList(input));
					break;
				case power:
					result.getButtockInfos().add(initPowerList(input));
					break;

				default:
					break;
				}
				
				
			}else{
				
				result.getButtockInfos().add(initPowerList(input));
				
				result.getButtockInfos().add(initLapList(input));
				
			}
			
		} catch (Exception e) {
			
			result.setStatus(0);
			
			result.setError("相关类型不存在");
			
		}
		
		
		return result;
	}
	
	/**
	 * 初始化实力派信息
	 * @param infoInput
	 * 		输入信息
	 * @return 实例派信息
	 */
	public ButtockInfo initPowerList(ApiButtockInfoInput infoInput){
		
		ButtockInfo buttockInfo = new ButtockInfo();
		
		ApiButtockPowerListInput input = new ApiButtockPowerListInput();
		
		input.setPagination(infoInput.getPagination());
		
		input.setWidth(infoInput.getWidth());
		
		ApiButtockPowerListResult result = apiButtockPowerList.api(input);
		
		buttockInfo.setTitle("实力派");
		
		buttockInfo.setContentInfos(result.getButtockPowerList());
		
		buttockInfo.setNextflag(result.isNextflag());
		
		return buttockInfo;
		
	}
	
	/**
	 * 初始化翘丽圈信息
	 * @param infoInput
	 * 		输入信息
	 * @return 实例派信息
	 */
	public ButtockInfo initLapList(ApiButtockInfoInput infoInput){
		
		ButtockInfo buttockInfo = new ButtockInfo();
		
		ApiButtockLapListInput input = new ApiButtockLapListInput();
		
		input.setPagination(infoInput.getPagination());
		
		input.setWidth(infoInput.getWidth());
		
		ApiButtockLapListResult result = apiButtockLapList.api(input);
		
		buttockInfo.setTitle("翘丽圈");
		
		buttockInfo.setContentInfos(result.getButtockLapList());
		
		buttockInfo.setNextflag(result.isNextflag());
		
		return buttockInfo;
		
	}

}
