package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnLiveInfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "直播信息", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Add + "=dzoi41071112", DefineWebPage.Page_Edit + "=dzoi41071117",
		DefineWebPage.Page_Grid + "=dzoi469910011009,dzoi4699100110190003,dzoi41071113,dzoi41071114",
		DefineWebPage.Page_Query + "=dzoi469910011017" }, deploy = { DefineWebDeploy.Grid_Order + "=zc desc",
				DefineWebDeploy.Url_Query + "=code" })
public class LiveInfoPage extends RootPageSimple<CnLiveInfo> {

}
