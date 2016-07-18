package com.uhutu.dcom.answer.z.page.component;

import com.uhutu.dcom.answer.z.page.component.vo.CnContentBasicinfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "运动时刻", operates = DefineZooWeb.PAGE_DIALOG_OPERATE, deploy = {
		DefineWebDeploy.Grid_Where + "=status!='del' and busiType='dzsd4107100110020001' " })
public class ContentBasicInfoPage extends RootPageSimple<CnContentBasicinfo> {

}
