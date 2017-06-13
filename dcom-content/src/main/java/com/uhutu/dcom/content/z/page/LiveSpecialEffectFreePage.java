package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnLiveSpecialEffectFree;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "特效赠送规则", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Add + "=dzoi41071127", DefineWebPage.Page_Edit + "=dzoi41071128",
		DefineWebPage.Page_Query + "=dzoi4699100110171001" }, deploy = { DefineWebDeploy.Url_Query + "=seCode",
				DefineWebDeploy.Grid_Order + "= zc desc" })
public class LiveSpecialEffectFreePage extends RootPageSimple<CnLiveSpecialEffectFree> {

}
