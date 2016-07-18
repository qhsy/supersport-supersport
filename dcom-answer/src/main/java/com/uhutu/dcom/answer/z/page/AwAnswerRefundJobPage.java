package com.uhutu.dcom.answer.z.page;

import com.uhutu.dcom.answer.z.entity.AwAnswerRefundJob;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "退款单", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = {DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Query + "=dzoi469910021017",
		DefineWebPage.Page_Grid + "=dzoi4699100110190003,dzoi4699100110091001" }, deploy = { DefineWebDeploy.Url_Query + "=code" })
public class AwAnswerRefundJobPage extends RootPageSimple<AwAnswerRefundJob> {

}
