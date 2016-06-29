package com.uhutu.dcom.answer.z.page;

import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebOperate;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "问达信息", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = {
		DefineWebPage.Page_Query + "=dzoi469910021017",
		DefineWebPage.Page_Grid + "=dzoi4699100110190003" }, deploy = { DefineWebDeploy.Url_Query + "=code" })
public class AwQuestionInfoPage extends RootPageSimple<AwQuestionInfo> {

}
