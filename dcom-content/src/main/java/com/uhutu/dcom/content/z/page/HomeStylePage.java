package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnHomeStyle;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "首页排版", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Add + "=dzoi41071067",
		DefineWebPage.Page_Edit + "=dzoi41071068" }, deploy = { DefineWebDeploy.Grid_Order + "= sort desc" })
public class HomeStylePage extends RootPageSimple<CnHomeStyle> {

}
