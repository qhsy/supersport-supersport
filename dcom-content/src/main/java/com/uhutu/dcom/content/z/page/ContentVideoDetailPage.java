package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.page.vo.ext.CnContentDetail;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "文章(含视频)管理", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, deploy = DefineWebDeploy.Grid_Where
		+ "=code in (select code from cn_content_basicinfo where content_type='dzsd4107100110030002') ")
public class ContentVideoDetailPage extends RootPageSimple<CnContentDetail> {

}
