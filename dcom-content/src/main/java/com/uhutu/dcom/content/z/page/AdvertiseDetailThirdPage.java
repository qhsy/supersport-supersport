package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.ext.CnAdvertiseDetail;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "图片", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Add + "=dzoi41071011", DefineWebPage.Page_Edit + "=dzoi41071010",
		DefineWebPage.Page_Grid + "=dzoi469910011009,dzoi41071035" }, deploy = { DefineWebDeploy.Url_Query + "=code",DefineWebDeploy.Grid_Where+"=piclink_type like '%dzsd410710011015%'" })
public class AdvertiseDetailThirdPage extends RootPageSimple<CnAdvertiseDetail> {

}
