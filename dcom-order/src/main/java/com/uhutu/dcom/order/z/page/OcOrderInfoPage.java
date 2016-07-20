package com.uhutu.dcom.order.z.page;

import com.uhutu.dcom.order.z.entity.OcOrderInfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "订单信息", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = {
		DefineWebPage.Page_Query + "=dzoi469910021017",
		DefineWebPage.Page_Grid + "=dzoi41121001" }, deploy = { DefineWebDeploy.Url_Query + "=code" })
public class OcOrderInfoPage extends RootPageSimple<OcOrderInfo> {

}
