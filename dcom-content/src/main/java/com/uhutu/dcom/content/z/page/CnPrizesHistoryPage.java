package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnPrizesHistory;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "中奖记录", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Query + "=dzoi4699100110171001", DefineWebPage.Page_Grid + "=" })
public class CnPrizesHistoryPage extends RootPageSimple<CnPrizesHistory> {

}
