package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnContentType;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "内容类型", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Query + "=dzoi469910011017",
		DefineWebPage.Page_Grid + "=dzoi41071083,dzoi41071085,dzoi469910011009" }, deploy = { DefineWebDeploy.Url_Query + "=code",
				DefineWebDeploy.Grid_Order + "= sort desc,zc desc" })
public class CnContentTypePage extends RootPageSimple<CnContentType> {

}
