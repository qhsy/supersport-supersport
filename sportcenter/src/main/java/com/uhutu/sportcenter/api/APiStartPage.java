package com.uhutu.sportcenter.api;

import com.uhutu.sportcenter.api.input.APiStartPageInput;
import com.uhutu.sportcenter.api.result.APiStartPageResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * app启动接口
 * 
 * @author xiegj
 * 
 */
public class APiStartPage extends
		RootApiBase< APiStartPageInput,APiStartPageResult> {

	public APiStartPageResult process(APiStartPageInput inputParam) {
		APiStartPageResult result = new APiStartPageResult();
		
		return result;
	}

}
