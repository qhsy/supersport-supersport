package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnLiveMatchInfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "球队信息", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Grid + "=dzoi469910011009,dzoi4699100110190003",
		DefineWebPage.Page_Query + "=dzoi469910011017" }, deploy = { DefineWebDeploy.Grid_Order + "=zc desc" })
public class LiveMatchInfoPage extends RootPageSimple<CnLiveMatchInfo> {

}
