package com.uhutu.dcom.user.z.page;

import com.uhutu.dcom.user.z.entity.UcSignPrice;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(value = "活动", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Add + "=dzoi41101013",
		DefineWebPage.Page_Edit + "=dzoi41101014" }, deploy = { DefineWebDeploy.Grid_Order + "= zc desc " })
public class UcSignPricePage extends RootPageSimple<UcSignPrice> {

}
