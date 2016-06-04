package com.uhutu.dcom.user.z.page;

import com.uhutu.dcom.user.z.entity.UcDonateFlow;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

/**
 * 捐赠能量流水
 * 
 * @author xiegj
 *
 */
@ZooPage(name = "详情", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Query + "=dzoi4699100110171001", DefineWebPage.Page_Grid + "=" })
public class UcDonateFlowPage extends RootPageSimple<UcDonateFlow> {

}
