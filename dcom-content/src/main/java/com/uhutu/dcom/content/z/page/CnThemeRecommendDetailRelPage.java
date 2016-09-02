package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.ext.CnThemeInfoRel;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "专题达人栏目信息", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Query + "=dzoi4699100110171001", DefineWebPage.Page_Add + "=dzoi41071033",
		DefineWebPage.Page_Edit + "=dzoi41071034" }, deploy = { DefineWebDeploy.Url_Query + "=code"
				,DefineWebDeploy.Grid_Where+"=column_code in (select code from cn_theme_detail where type='dzsd4107100110070002')"
				,DefineWebDeploy.Grid_Order + "= sort desc" })
public class CnThemeRecommendDetailRelPage extends RootPageSimple<CnThemeInfoRel> {

}
