package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.ext.CnContentItemRel;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "栏目内容关联管理", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Add + "=dzoi41071002",
		DefineWebPage.Page_Edit + "=dzoi41071003" }, deploy = DefineWebDeploy.Grid_Where
				+ "=itemType!='dzsd4699100110060003' ")
public class ContentItemRelForAdvPage extends RootPageSimple<CnContentItemRel> {

}
