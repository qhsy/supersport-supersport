package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnContentReadCount;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "阅读量", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Grid + "=dzoi4699100110091001", DefineWebPage.Page_Add + "=dzoi41071037",
		DefineWebPage.Page_Delete + "=dzoi41071038" })
public class CnContentReadCountPage extends RootPageSimple<CnContentReadCount> {

}
