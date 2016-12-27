package com.uhutu.dcom.content.z.page.component;

import com.uhutu.dcom.content.z.entity.ext.ext.CnAdvertiseDetail;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "广告图", operates = DefineZooWeb.PAGE_DIALOG_OPERATE, deploy = {
		DefineWebDeploy.Grid_Where + "=piclink_type like '%dzsd410710011015%'" })
public class AdvertiseDetailThirdPage extends RootPageSimple<CnAdvertiseDetail> {

}
