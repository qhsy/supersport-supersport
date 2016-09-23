package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnAdvertiseDetail;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "图片", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE}, deploy = { DefineWebDeploy.Url_Query + "=code" })
public class AdvertiseDetailPage extends RootPageSimple<CnAdvertiseDetail> {

}
