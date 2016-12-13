package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnRedPackInfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "直播红包管理", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Query + "=dzoi469910011017" }, deploy = { DefineWebDeploy.Grid_Order + "=sort desc" })
public class CnRedPackInfoPage extends RootPageSimple<CnRedPackInfo> {

}
