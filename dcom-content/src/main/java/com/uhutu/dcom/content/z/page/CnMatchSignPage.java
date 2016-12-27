package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnMatchSign;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "报名设置", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE}, deploy = {
				DefineWebDeploy.Grid_Order + "= sort desc,zc desc"})
public class CnMatchSignPage extends RootPageSimple<CnMatchSign> {

}
