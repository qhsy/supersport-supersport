package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnPrizesInfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "奖品信息", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Edit + "=dzoi41071079", DefineWebPage.Page_Grid + "=dzoi4699100110091001,dzoi41071080" })
public class CnPrizesInfoPage extends RootPageSimple<CnPrizesInfo> {

}
