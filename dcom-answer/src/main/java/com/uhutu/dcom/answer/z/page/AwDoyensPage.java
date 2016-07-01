package com.uhutu.dcom.answer.z.page;

import com.uhutu.dcom.answer.z.page.vo.AwPointRecommen;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

/**
 * 推荐达人
 * 
 * @author Administrator
 *
 */
@ZooPage(name = "推荐达人", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Query + "=dzoi469910011017", DefineWebPage.Page_Add + "=dzoi48880009",
		DefineWebPage.Page_Edit + "=dzoi48880010" }, deploy = {
				DefineWebDeploy.Grid_Where + "=type='dzsd4888100110030004'",
				DefineWebDeploy.Grid_Order + "= sort desc" })
public class AwDoyensPage extends RootPageSimple<AwPointRecommen> {

}
