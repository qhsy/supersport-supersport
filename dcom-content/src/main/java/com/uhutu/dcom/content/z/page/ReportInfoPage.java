package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.extend.z.entity.ReReportInfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "报名信息", operates = DefineZooWeb.PAGE_DIALOG_OPERATE,
		deploy = {DefineWebDeploy.Grid_Where + "=status='1'"})
public class ReportInfoPage extends RootPageSimple<ReReportInfo> {

}
