package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.page.vo.CnContentBasicinfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "图集管理", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = {
		DefineWebPage.Page_Grid + "=dzoi469910011009,dzoi41071023,dzoi41071024,dzoi41071071,dzoi41071072",
		DefineWebPage.Page_Query + "=dzoi469910011017", DefineWebPage.Page_Add + "=dzoi41071001", DefineWebPage.Page_Edit + "=dzoi41071004" }, deploy = {
				DefineWebDeploy.Grid_Where + "=status!='del' and content_type='dzsd4107100110030003' ",
				DefineWebDeploy.Url_Query + "=contentCode" })
public class ContentBasicInfoForPhotoPage extends RootPageSimple<CnContentBasicinfo> {

}
