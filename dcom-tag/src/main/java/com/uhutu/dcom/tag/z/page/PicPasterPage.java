package com.uhutu.dcom.tag.z.page;

import com.uhutu.dcom.tag.z.entity.CnPicPaster;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "贴纸管理", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = {
		DefineZooWeb.PAGE_DEFAULT_OPERATE }, deploy = { DefineWebDeploy.Grid_Order + "= sort desc" })
public class PicPasterPage extends RootPageSimple<CnPicPaster> {

}
