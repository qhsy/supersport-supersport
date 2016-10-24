package com.uhutu.dcom.content.z.page.component;

import com.uhutu.dcom.content.z.entity.PcProductInfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "商品列表", operates = DefineZooWeb.PAGE_DIALOG_OPERATE, deploy = {
		DefineWebDeploy.Grid_Order + "= zc desc" })
public class ProductInfoSelectPage extends RootPageSimple<PcProductInfo> {

}
