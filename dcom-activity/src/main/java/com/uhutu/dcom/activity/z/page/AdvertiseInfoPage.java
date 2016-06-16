package com.uhutu.dcom.activity.z.page;

import com.uhutu.dcom.activity.z.entity.AcActivityInfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "广告基本信息", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE })
public class AdvertiseInfoPage extends RootPageSimple<AcActivityInfo> {

}
