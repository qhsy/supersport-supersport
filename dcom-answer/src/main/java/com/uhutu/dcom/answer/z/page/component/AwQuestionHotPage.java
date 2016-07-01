package com.uhutu.dcom.answer.z.page.component;

import com.uhutu.dcom.answer.z.entity.AwPointRecommen;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

/**
 * 热门问题页面
 * 
 * @author Administrator
 *
 */
@ZooPage(name = "热门问题", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = {
		DefineWebPage.Page_Query + "=dzoi469910011017", DefineWebPage.Page_Grid + "=dzoi4699100110091002" })
public class AwQuestionHotPage extends RootPageSimple<AwPointRecommen> {

}
