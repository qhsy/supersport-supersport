package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnThemeDetail;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "专题栏目信息", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Grid + "=dzoi469910011009,dzoi41071027,dzoi41071028" }, deploy = {
				DefineWebDeploy.Url_Query + "=code" })
public class CnThemeDetailPage extends RootPageSimple<CnThemeDetail> {

}