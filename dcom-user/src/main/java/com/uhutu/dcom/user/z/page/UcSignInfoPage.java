package com.uhutu.dcom.user.z.page;

import com.uhutu.dcom.user.z.entity.UcSignInfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(value = "活动", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Query + "=dzoi4699100110171001",
		DefineWebPage.Page_Grid + "=dzoi4699100110190003", }, deploy = { DefineWebDeploy.Grid_Order + "= zc desc " })
public class UcSignInfoPage extends RootPageSimple<UcSignInfo> {

}
