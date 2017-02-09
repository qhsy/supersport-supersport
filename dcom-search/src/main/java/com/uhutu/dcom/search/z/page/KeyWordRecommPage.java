package com.uhutu.dcom.search.z.page;

import com.uhutu.dcom.search.z.entity.SeKeyWordRecomm;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

/**
 * 推荐标签
 * 
 * @author xiegj
 *
 */
@ZooPage(name = "推荐标签", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Query + "=dzoi469910011017",
		DefineWebDeploy.Grid_Order + "= sort desc" }, deploy = { DefineWebDeploy.Grid_Order + "= sort desc " })
public class KeyWordRecommPage extends RootPageSimple<SeKeyWordRecomm> {

}
