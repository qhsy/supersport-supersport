package com.uhutu.dcom.content.z.page.component;

import com.uhutu.dcom.content.z.entity.CnThemeDetail;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "专题栏目信息", operates = DefineZooWeb.PAGE_DIALOG_OPERATE, deploy = {
		DefineWebDeploy.Grid_Where + "=type='dzsd4107100110070001'" })
public class ThemeDetailComponentPage extends RootPageSimple<CnThemeDetail> {

}
