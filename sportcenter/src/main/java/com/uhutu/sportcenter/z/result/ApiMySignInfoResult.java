package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.MySignFieldInfo;
import com.uhutu.sportcenter.z.entity.MySignInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 报名信息结果
 * @author 逄小帅
 *
 */
public class ApiMySignInfoResult extends RootApiResult {
	
	@ApiModelProperty(value="报名信息")
	private MySignInfo mySignInfo = new MySignInfo();
	
	@ApiModelProperty(value="报名详情")
	private List<MySignFieldInfo> signFieldInfos = new ArrayList<MySignFieldInfo>();

	public MySignInfo getMySignInfo() {
		return mySignInfo;
	}

	public void setMySignInfo(MySignInfo mySignInfo) {
		this.mySignInfo = mySignInfo;
	}

	public List<MySignFieldInfo> getSignFieldInfos() {
		return signFieldInfos;
	}

	public void setSignFieldInfos(List<MySignFieldInfo> signFieldInfos) {
		this.signFieldInfos = signFieldInfos;
	}


}
