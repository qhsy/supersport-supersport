package com.uhutu.dcom.user.z.page;

import com.uhutu.dcom.user.z.page.vo.UcAttentionInfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "关注信息", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Query + "=dzoi4699100110171001", DefineWebPage.Page_Add + "=dzoi41101008",
		DefineWebPage.Page_Grid + "=dzoi41101009" }, deploy = { DefineWebDeploy.Grid_Where + "=status='1'",
				DefineWebDeploy.Url_Query + "=beAttention" })
public class UcAttentionInfoPage extends RootPageSimple<UcAttentionInfo> {

}
