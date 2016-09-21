package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnWonderfulVideo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

/**
 * 精彩视频
 * @author 逄小帅
 *
 */
@ZooPage(name = "精彩视频", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Add + "=dzoi41071051", DefineWebPage.Page_Edit + "=dzoi41071052",
		DefineWebPage.Page_Query + "=dzoi469910011017" }, deploy = { DefineWebDeploy.Grid_Order + "= sort desc" })
public class CnWonderfulVideoPage extends RootPageSimple<CnWonderfulVideo> {

}
