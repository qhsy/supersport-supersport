package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.SpSportCategory;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "运动管理", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, deploy = {
		DefineWebDeploy.Grid_Order + "= sort desc" })
public class SportCategoryPage extends RootPageSimple<SpSportCategory> {

}
