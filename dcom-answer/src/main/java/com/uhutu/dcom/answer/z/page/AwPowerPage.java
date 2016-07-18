package com.uhutu.dcom.answer.z.page;

import com.uhutu.dcom.answer.z.page.vo.power.AwPointRecommen;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

/**
 * 实力派
 * 
 * @author Administrator
 *
 */
@ZooPage(name = "实力派", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Query + "=dzoi469910011017", DefineWebPage.Page_Add + "=dzoi48880013",
		DefineWebPage.Page_Edit + "=dzoi48880014" }, deploy = {
				DefineWebDeploy.Grid_Where + "=type='dzsd4888100110030006'",
				DefineWebDeploy.Grid_Order + "= sort desc" })
public class AwPowerPage extends RootPageSimple<AwPointRecommen> {

}
