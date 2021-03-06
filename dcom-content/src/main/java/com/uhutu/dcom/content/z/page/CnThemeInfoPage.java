package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnThemeInfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "专题信息", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Grid + "=dzoi469910011009,dzoi41071031,dzoi41071032,dzoi41071045,dzoi41071046,dzoi41071035",
		DefineWebPage.Page_Add + "=dzoi41071036" }, deploy = { DefineWebDeploy.Url_Query + "=code" })
public class CnThemeInfoPage extends RootPageSimple<CnThemeInfo> {

}
