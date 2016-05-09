package com.uhutu.dcom.tag.z.page;

import com.uhutu.dcom.tag.z.entity.CnContentLabel;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "标签页面", pages = { DefineZooWeb.PAGE_DEFAULT_SUB,"-pg"})
public class ContentLabelPage extends RootPageSimple<CnContentLabel> {

}
