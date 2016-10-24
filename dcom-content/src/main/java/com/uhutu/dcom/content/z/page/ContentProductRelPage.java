package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnContentProductRel;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "商品列表", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Query + "=dzoi4699100110171001", DefineWebPage.Page_Add + "=dzoi41071073",
		DefineWebPage.Page_Edit + "=dzoi41071074" }, deploy = { DefineWebDeploy.Url_Query + "=contentCode",
				DefineWebDeploy.Grid_Order + "=sort desc" })
public class ContentProductRelPage extends RootPageSimple<CnContentProductRel> {

}
