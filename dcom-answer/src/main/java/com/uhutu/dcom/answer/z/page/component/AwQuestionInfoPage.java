package com.uhutu.dcom.answer.z.page.component;

import com.uhutu.dcom.answer.z.page.component.vo.AwQuestionInfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "问达信息", operates = DefineZooWeb.PAGE_DIALOG_OPERATE, deploy = {
		DefineWebDeploy.Grid_Where + "=scope='dzsd4888100110020002' and status='dzsd4888100110010002' ",
		DefineWebDeploy.Grid_Order + "= zc desc" })
public class AwQuestionInfoPage extends RootPageSimple<AwQuestionInfo> {

}
