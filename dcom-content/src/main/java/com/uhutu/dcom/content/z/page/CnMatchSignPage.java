package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnMatchSign;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "报名设置", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { 
		DefineWebPage.Page_Add+"=dzoi4699100110010001",
		DefineWebPage.Page_Grid+"=dzoi4699100110091001,dzoi4699100110091002" }, deploy = {
		DefineWebDeploy.Url_Query + "=matchCode",DefineWebDeploy.Grid_Order + "= sort desc,zc desc"})
public class CnMatchSignPage extends RootPageSimple<CnMatchSign> {

}
