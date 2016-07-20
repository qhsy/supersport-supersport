package com.uhutu.dcom.order.z.page;

import com.uhutu.dcom.order.z.entity.OcOrderDetail;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(value = "订单明细", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = {
		DefineWebPage.Page_Grid + "=" }, deploy = { DefineWebDeploy.Url_Query + "=code" })
public class OcOrderDetailPage extends RootPageSimple<OcOrderDetail> {

}
