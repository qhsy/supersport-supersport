package com.uhutu.dcom.tag.z.page;

import com.uhutu.dcom.tag.z.entity.CnContentLabel;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "标签页面", pages = { DefineZooWeb.PAGE_DEFAULT_SUB, "-pg" },operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Query + "=dzoi469910011017", DefineWebPage.Page_Add + "=dzoi41240004",
		DefineWebPage.Page_Edit + "=dzoi41240003" }, deploy = {
		DefineWebDeploy.Grid_Order + "= sort desc" })
public class ContentLabelPage extends RootPageSimple<CnContentLabel> {

}
