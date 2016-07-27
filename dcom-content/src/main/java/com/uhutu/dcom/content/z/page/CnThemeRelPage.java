package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnThemeDetailRel;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "文章信息", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Add + "=dzoi41071029", DefineWebPage.Page_Edit + "=dzoi41071030",
		DefineWebPage.Page_Query + "=dzoi4699100110171001" }, deploy = { DefineWebDeploy.Url_Query + "=code",
				DefineWebDeploy.Grid_Order + "= sort desc" })
public class CnThemeRelPage extends RootPageSimple<CnThemeDetailRel> {

}
