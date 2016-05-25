package com.uhutu.dcom.content.z.page.component;

import com.uhutu.dcom.content.z.entity.CnContentItem;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "栏目管理", operates = DefineZooWeb.PAGE_DIALOG_OPERATE, deploy = DefineWebDeploy.Grid_Where
		+ "=type!='dzsd4699100110060003' ")
public class ContentItemPage extends RootPageSimple<CnContentItem> {

}
