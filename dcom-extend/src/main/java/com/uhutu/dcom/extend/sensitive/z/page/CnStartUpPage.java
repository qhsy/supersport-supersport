package com.uhutu.dcom.extend.sensitive.z.page;

import com.uhutu.dcom.extend.sensitive.z.entity.CnStartUp;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "启动页信息", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Grid + "=dzoi469910011009", DefineWebPage.Page_Add + "=dzoi41091001",
		DefineWebPage.Page_Edit + "=dzoi41091002" }, deploy = { DefineWebDeploy.Url_Query + "=code",
				DefineWebDeploy.Grid_Order + "= start_time desc" })
public class CnStartUpPage extends RootPageSimple<CnStartUp> {

}
