package com.uhutu.dcom.user.z.page;

import com.uhutu.dcom.user.z.entity.UcSignCount;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(value = "活动人数", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Add + "=dzoi41101015",
		DefineWebPage.Page_Edit + "=dzoi41101016" }, deploy = { DefineWebDeploy.Grid_Order + "= zc desc " })
public class UcSignCountPage extends RootPageSimple<UcSignCount> {

}
