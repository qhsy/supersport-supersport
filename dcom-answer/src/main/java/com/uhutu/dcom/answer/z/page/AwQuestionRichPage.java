package com.uhutu.dcom.answer.z.page;

import com.uhutu.dcom.answer.z.page.vo.AwPointRecommen;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

/**
 * 才华榜
 * 
 * @author Administrator
 *
 */
@ZooPage(name = "才华榜", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Query + "=dzoi469910011017", DefineWebPage.Page_Add + "=dzoi48880007",
		DefineWebPage.Page_Edit + "=dzoi48880008" }, deploy = {
				DefineWebDeploy.Grid_Where + "=type='dzsd4888100110030003'",
				DefineWebDeploy.Grid_Order + "= sort desc" })
public class AwQuestionRichPage extends RootPageSimple<AwPointRecommen> {

}
