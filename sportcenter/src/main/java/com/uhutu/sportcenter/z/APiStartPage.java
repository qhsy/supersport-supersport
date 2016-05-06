package com.uhutu.sportcenter.z;

import org.springframework.stereotype.Service;

import com.uhutu.sportcenter.z.input.APiStartPageInput;
import com.uhutu.sportcenter.z.result.APiStartPageResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * app启动接口
 * 
 * @author xiegj
 * 
 */
@Service
public class APiStartPage extends RootApiBase<APiStartPageInput, APiStartPageResult> {

	public APiStartPageResult process(APiStartPageInput inputParam) {
		APiStartPageResult result = new APiStartPageResult();

		return result;
	}

}
