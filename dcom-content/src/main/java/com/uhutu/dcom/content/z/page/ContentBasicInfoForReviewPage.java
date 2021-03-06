package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.page.vo.review.CnContentBasicinfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "中奖审核管理", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Query + "=dzoi4699100110171001",DefineWebPage.Page_Edit + "=dzoi41071078",
		DefineWebPage.Page_Grid + "=dzoi41071075,dzoi41071076", }, deploy = {
				DefineWebDeploy.Grid_Where
						+ "=shareScope='dzsd4699100110010001' and  status='dzsd4699100110010001' and busi_type='dzsd4107100110020001' "
						+ " and (tag_code like '%GGBH161020210003%' or tag_code like '%GGBH161020210002%'"
						+ " or tag_code like '%GGBH161020210001%' or tag_code like '%GGBH161020110001%')",
				DefineWebDeploy.Url_Query + "=code" })
public class ContentBasicInfoForReviewPage extends RootPageSimple<CnContentBasicinfo> {

}
