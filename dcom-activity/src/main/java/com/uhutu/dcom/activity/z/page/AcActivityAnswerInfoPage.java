package com.uhutu.dcom.activity.z.page;

import com.uhutu.dcom.activity.z.entity.AcActivityAnswerInfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "活动基本信息", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Grid + "=dzoi469910011009,dzoi48880001,dzoi48880002" }, deploy = {
				DefineWebDeploy.Url_Query + "=code", DefineWebDeploy.Grid_Order + "= zc desc" })
public class AcActivityAnswerInfoPage extends RootPageSimple<AcActivityAnswerInfo> {

}
