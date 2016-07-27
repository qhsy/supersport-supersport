package com.uhutu.dcom.content.z.page.component.ext;

import com.uhutu.dcom.content.z.page.vo.CnContentBasicinfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "内容管理", operates = DefineZooWeb.PAGE_DIALOG_OPERATE, deploy = {
		DefineWebDeploy.Grid_Where + "=status='dzsd4699100110010001' and  share_scope='dzsd4699100110010001'" })
public class ContentBasicInfoPageForTheme extends RootPageSimple<CnContentBasicinfo> {

}
