package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.page.vo.href.CnContentDetail;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "文章(含视频)管理", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Grid + "=dzoi469910011009",
		DefineWebPage.Page_Query + "=dzoi4699100110171001" }, deploy = DefineWebDeploy.Url_Query + "=code")
public class ContentHrefDetailPage extends RootPageSimple<CnContentDetail> {

}
