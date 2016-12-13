package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnRedPackUser;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "直播间接受打赏人员管理", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineWebPage.Page_Grid + "=",
		DefineWebPage.Page_Query + "=dzoi469910011017" }, deploy = { DefineWebDeploy.Grid_Order + "= sort asc" })
public class CnRedPackUserPage extends RootPageSimple<CnRedPackUser> {

}
