package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnContentItem;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "栏目", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Add + "=dzoi41071007", DefineWebPage.Page_Edit + "=dzoi41071008",
		DefineWebPage.Page_Grid + "=dzoi469910011009,dzoi41071017,dzoi41071018" }, deploy = {
				DefineWebDeploy.Grid_Order + "= DATE_FORMAT(start_time,'%Y-%m-%d') desc,sort desc,zc desc",
				DefineWebDeploy.Url_Query + "=code",
				DefineWebDeploy.Grid_Where + "=type in ('dzsd4107100110060001','dzsd4107100110060002') " })
public class ContentItemForAdvPage extends RootPageSimple<CnContentItem> {

}
