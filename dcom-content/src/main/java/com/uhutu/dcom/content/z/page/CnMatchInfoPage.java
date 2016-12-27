package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnMatchInfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "赛事列表", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Add + "=dzoi41071098" }, deploy = {
				DefineWebDeploy.Grid_Order + "= sort desc,zc desc"})
public class CnMatchInfoPage extends RootPageSimple<CnMatchInfo> {

}
