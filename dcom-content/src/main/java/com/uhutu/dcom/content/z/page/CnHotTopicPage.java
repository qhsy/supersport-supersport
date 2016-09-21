package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnHotTopic;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

/**
 * 热门话题
 * @author 逄小帅
 *
 */
@ZooPage(name = "热门话题", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Add + "=dzoi41071055", DefineWebPage.Page_Edit + "=dzoi41071056",
		DefineWebPage.Page_Query + "=dzoi469910011017" }, deploy = { DefineWebDeploy.Grid_Order + "= sort desc" })
public class CnHotTopicPage extends RootPageSimple<CnHotTopic> {

}
