package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.page.vo.type.CnContentBasicinfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "内容管理", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Grid + "=dzoi41071084", DefineWebPage.Page_Delete + "=dzoi41071084",
		DefineWebPage.Page_Query + "=dzoi4699100110171001" }, deploy = DefineWebDeploy.Url_Query + "=type")
public class contentBasicTypePage extends RootPageSimple<CnContentBasicinfo> {

}
