package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.PcProductInfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "商品管理", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE })
public class ProductInfoPage extends RootPageSimple<PcProductInfo> {

}
