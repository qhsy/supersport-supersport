package com.uhutu.dcom.activity.z.page;

import com.uhutu.dcom.activity.z.entity.AcActivityAnswerRelation;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "栏目与内容", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Add + "=dzoi48881001", DefineWebPage.Page_Edit + "=dzoi48881002",
		DefineWebPage.Page_Query + "=dzoi4699100110171001" }, deploy = { DefineWebDeploy.Url_Query + "=activityCode",
				DefineWebDeploy.Grid_Order + "= zc desc" })
public class AcActivityAnswerRelPage extends RootPageSimple<AcActivityAnswerRelation> {

}
