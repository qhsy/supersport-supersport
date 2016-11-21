package com.uhutu.dcom.content.z.page.component;

import com.uhutu.dcom.content.z.entity.CnContentType;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "内容分类", operates = DefineZooWeb.PAGE_DIALOG_OPERATE, deploy = {
		DefineWebDeploy.Grid_Order + "=sort desc, zc desc" })
public class ContentTypeSelectPage extends RootPageSimple<CnContentType> {

}
