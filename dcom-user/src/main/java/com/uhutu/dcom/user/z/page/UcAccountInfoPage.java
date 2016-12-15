package com.uhutu.dcom.user.z.page;

import com.uhutu.dcom.user.z.entity.UcAccountInfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(value = "主播收益管理", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Query + "=dzoi4699100110171001",
		DefineWebPage.Page_Grid + "=dzoi4699100110190003","dzoi41101017" }, deploy = {
				DefineWebDeploy.Grid_Order + "= total_profit desc " })
public class UcAccountInfoPage extends RootPageSimple<UcAccountInfo> {

}
