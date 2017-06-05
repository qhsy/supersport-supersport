package com.uhutu.dcom.content.z.page.component.ext;

import com.uhutu.dcom.content.z.page.vo.CnContentBasicinfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "内容", operates = DefineZooWeb.PAGE_DIALOG_OPERATE, deploy = DefineWebDeploy.Grid_Where
		+ "=content_type = 'dzsd4107100110030001' ")
public class ContentBasicInfoPageTwo extends RootPageSimple<CnContentBasicinfo> {

}
