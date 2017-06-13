package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnLiveSpecialEffect;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "弹幕特效管理", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Grid + "=dzoi4699100110091001,dzoi41071125,dzoi41071126",
		DefineWebPage.Page_Query + "=dzoi4699100110171001" }, deploy = { DefineWebDeploy.Grid_Order + "=sort desc",
				DefineWebDeploy.Url_Query + "=code" })
public class LiveSpecialEffectPage extends RootPageSimple<CnLiveSpecialEffect> {

}
