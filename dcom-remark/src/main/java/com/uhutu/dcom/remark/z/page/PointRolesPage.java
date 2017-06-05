package com.uhutu.dcom.remark.z.page;

import com.uhutu.dcom.remark.z.entity.CnPointRoles;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "等级规则", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE
		 ,DefineWebPage.Page_Grid + "=dzoi4699100110091001",
		 DefineWebPage.Page_Query + "=dzoi469910011017"
}, deploy = { DefineWebDeploy.Url_Query + "=code"})
public class PointRolesPage extends RootPageSimple<CnPointRoles> {

}
