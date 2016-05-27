package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.page.vo.CnContentDetail;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "文章管理", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Add + "=dzoi41071009" }, deploy = DefineWebDeploy.Grid_Where
				+ "=code in (select code from cn_content_basicinfo where content_type='dzsd4107100110030001') ")
public class ContentDetailPage extends RootPageSimple<CnContentDetail> {

}
