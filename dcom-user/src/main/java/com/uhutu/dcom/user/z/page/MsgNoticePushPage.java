package com.uhutu.dcom.user.z.page;

import com.uhutu.dcom.user.z.entity.UcMsgNoticePush;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(value = "推送和站内信", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Query + "=dzoi469910011017",
		DefineWebPage.Page_Grid + "=dzoi469910011009,dzoi41101011,dzoi41101012", }, deploy = {
				DefineWebDeploy.Grid_Order + "= zc desc " })
public class MsgNoticePushPage extends RootPageSimple<UcMsgNoticePush> {

}
