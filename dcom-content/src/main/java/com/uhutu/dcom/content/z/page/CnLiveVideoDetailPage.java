package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "直播间管理", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = {
		DefineWebPage.Page_Grid + "=dzoi4699100110091001,dzoi4699100110190003",
		DefineWebPage.Page_Query + "=dzoi4699100110171001" }, deploy = { DefineWebDeploy.Grid_Where + "=status='1' " })
public class CnLiveVideoDetailPage extends RootPageSimple<CnLiveVideoDetail> {

}
