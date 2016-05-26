package com.uhutu.dcom.remark.z.page;

import com.uhutu.dcom.remark.z.entity.CnContentRemark;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "评论信息", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = {
		"pe=dzoi469910011005&pg=dzoi4699100110091001,dzoi480110011001&pq=dzoi469910021017" }, deploy = DefineWebDeploy.Grid_Where
				+ "=status!='del' ")
public class ContentRemarkPage extends RootPageSimple<CnContentRemark> {

}
