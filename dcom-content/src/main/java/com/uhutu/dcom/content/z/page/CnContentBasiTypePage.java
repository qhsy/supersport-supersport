package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.contentType.CnContentBasiType;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "内容类型", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Add + "=dzoi41071086" }, deploy = { DefineWebDeploy.Url_Query + "=code" })
public class CnContentBasiTypePage extends RootPageSimple<CnContentBasiType> {

}
