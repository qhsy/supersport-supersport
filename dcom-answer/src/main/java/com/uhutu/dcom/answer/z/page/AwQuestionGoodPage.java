package com.uhutu.dcom.answer.z.page;

import com.uhutu.dcom.answer.z.page.vo.ext.AwPointRecommen;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

/**
 * 值得一听页面
 * 
 * @author xiegj
 *
 */
@ZooPage(name = "热门问题", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Query + "=dzoi469910011017", DefineWebPage.Page_Add + "=dzoi48880011",
		DefineWebPage.Page_Edit + "=dzoi48880012" }, deploy = {
				DefineWebDeploy.Grid_Where + "=type='dzsd4888100110030005'", DefineWebDeploy.Grid_Order + "= zc desc" })
public class AwQuestionGoodPage extends RootPageSimple<AwPointRecommen> {

}
