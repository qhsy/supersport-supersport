package com.uhutu.dcom.user.z.page;

import com.uhutu.dcom.user.z.entity.UcUserinfoExpert;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

/**
 * 达人信息
 * 
 * @author xiegj
 *
 */
@ZooPage(name = "达人信息", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Grid + "=dzoi4699100110091001,dzoi41101004,dzoi41101005" }, deploy = {
				DefineWebDeploy.Url_Query + "=userCode", DefineWebDeploy.Grid_Order + "=-sort" })
public class UcUserinfoExpertPage extends RootPageSimple<UcUserinfoExpert> {

}
