package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.page.vo.live.CnContentDetail;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "详情", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Grid + "=dzoi469910011009",
		DefineWebPage.Page_Query + "=dzoi4699100110171001" }, deploy = DefineWebDeploy.Url_Query + "=code")
public class ContentLiveDetailPage extends RootPageSimple<CnContentDetail> {

}
