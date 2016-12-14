package com.uhutu.sportcenter.z.result;

import com.uhutu.sportcenter.z.entity.WalletInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 钱包信息结果
 * @author 逄小帅
 *
 */
public class ApiWalletInfoResult extends RootApiResult {
	
	@ApiModelProperty(value = "钱包信息")
	private WalletInfo walletInfo = new WalletInfo();

	public WalletInfo getWalletInfo() {
		return walletInfo;
	}

	public void setWalletInfo(WalletInfo walletInfo) {
		this.walletInfo = walletInfo;
	}

}
