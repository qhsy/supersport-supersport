package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.page.vo.CnContentBasicinfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "内容管理", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = {
		DefineWebPage.Page_Add + "=dzoi41071001", DefineWebPage.Page_Edit + "=dzoi41071004",
		DefineWebPage.Page_Grid + "=dzoi4699100110091001,dzoi41071012" }, deploy = DefineWebDeploy.Grid_Where
				+ "=status!='del' ")
public class ContentBasicInfoPage extends RootPageSimple<CnContentBasicinfo> {

}
