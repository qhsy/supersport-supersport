package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.ext.item.secondFour.CnContentItem;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "两栏内容4:3", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Add + "=dzoi41071061", DefineWebPage.Page_Edit + "=dzoi41071062",
		DefineWebPage.Page_Grid + "=dzoi469910011009,dzoi41071015,dzoi41071016" }, deploy = {
				DefineWebDeploy.Grid_Order + "= DATE_FORMAT(start_time,'%Y-%m-%d') desc,sort desc,zc desc",
				DefineWebDeploy.Url_Query + "=code", DefineWebDeploy.Grid_Where + "=type ='dzsd4107100110060007' " })
public class ContentItemForSecondFour extends RootPageSimple<CnContentItem> {

}
