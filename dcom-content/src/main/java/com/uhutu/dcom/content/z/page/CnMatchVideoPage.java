package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnMatchVideo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "相关视频", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE}, deploy = {
		DefineWebDeploy.Url_Query + "=matchCode",DefineWebDeploy.Grid_Order + "= sort desc,zc desc"})
public class CnMatchVideoPage extends RootPageSimple<CnMatchVideo> {

}
