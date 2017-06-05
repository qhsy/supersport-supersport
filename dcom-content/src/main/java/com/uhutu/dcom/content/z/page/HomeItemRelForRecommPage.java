package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.ext.item.first.CnContentItemRel;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "栏目与内容", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Add + "=dzoi41071002", DefineWebPage.Page_Edit + "=dzoi41071003",
		DefineWebPage.Page_Query + "=dzoi4699100110171001" }, deploy = { DefineWebDeploy.Url_Query + "=itemCode",
				DefineWebDeploy.Grid_Where + "=content_code like 'CNBH%'",
				DefineWebDeploy.Grid_Order + "= sort desc,start_time desc,zc desc" })
public class HomeItemRelForRecommPage extends RootPageSimple<CnContentItemRel> {

}
