package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.ext.CnShareInfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "分享设置", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE })
public class ShareInfoPage extends RootPageSimple<CnShareInfo> {

}
