package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnRedPackFlow;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "直播间打赏流水", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineWebPage.Page_Grid + "=",
		DefineWebPage.Page_Query + "=dzoi4699100110171001" })
public class CnRedPackFlowPage extends RootPageSimple<CnRedPackFlow> {

}
