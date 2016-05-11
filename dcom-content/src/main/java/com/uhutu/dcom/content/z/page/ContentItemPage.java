package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnContentItem;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "栏目管理", pages = { DefineZooWeb.PAGE_DEFAULT_SUB})
public class ContentItemPage extends RootPageSimple<CnContentItem> {

}
