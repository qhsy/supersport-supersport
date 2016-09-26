package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.ext.item.sort.CnContentItem;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "首页内容排版", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Query + "=dzoi469910021017",
		DefineWebPage.Page_Grid + "=dzoi4699100110091001" }, deploy = { DefineWebDeploy.Grid_Order + "= sort desc" })
public class ContentItemForSort extends RootPageSimple<CnContentItem> {

}
