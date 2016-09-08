package com.uhutu.dcom.tag.z.page;

import com.uhutu.dcom.tag.z.entity.CnLabelRecomm;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

/**
 * 推荐标签
 * 
 * @author pangjh
 *
 */
@ZooPage(name = "推荐标签", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Query + "=dzoi469910011017", DefineWebPage.Page_Add + "=dzoi41240002",
		DefineWebPage.Page_Edit + "=dzoi41240001" }, deploy = {
				DefineWebDeploy.Grid_Where + "=type='dzsd4124100110020001'",
				DefineWebDeploy.Grid_Order + "= sort desc" })
public class CnLabelRecommPage extends RootPageSimple<CnLabelRecomm> {

}
