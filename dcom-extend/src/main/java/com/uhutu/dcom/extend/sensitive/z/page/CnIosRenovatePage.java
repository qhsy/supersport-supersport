package com.uhutu.dcom.extend.sensitive.z.page;

import com.uhutu.dcom.extend.sensitive.z.entity.CnIosRenovate;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "IOS修复功能", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Grid + "=dzoi469910011009"
		// ,
		// DefineWebPage.Page_Add + "=dzoi41091001",
		// DefineWebPage.Page_Edit + "=dzoi41091002"
}, deploy = { DefineWebDeploy.Grid_Order + "= zc desc" })
public class CnIosRenovatePage extends RootPageSimple<CnIosRenovate> {

}
