package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnHomeNavMenu;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "导航栏", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Add + "=dzoi41071047", DefineWebPage.Page_Edit + "=dzoi41071048" }, deploy = {
				DefineWebDeploy.Grid_Order + "= DATE_FORMAT(start_time,'%Y-%m-%d') desc,sort desc,zc desc", DefineWebDeploy.Url_Query + "=code" })
public class CnHomeNavMenuPage extends RootPageSimple<CnHomeNavMenu> {

}
