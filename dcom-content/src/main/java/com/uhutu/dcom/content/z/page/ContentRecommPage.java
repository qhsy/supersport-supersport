package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.entity.CnContentRecomm;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

/**
 * 小编推荐相关内容页面
 * 
 * @author 逄小帅
 *
 */
@ZooPage(name = "小编推荐页面", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Add + "=dzoi41071005", DefineWebPage.Page_Edit + "=dzoi41071006" })
public class ContentRecommPage extends RootPageSimple<CnContentRecomm> {

}
