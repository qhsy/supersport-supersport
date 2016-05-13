package com.uhutu.dcom.content.z.page;

import com.uhutu.dcom.content.z.page.vo.CnContentBasicinfoForAdd;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

@ZooPage(name = "内容管理", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		"pa=dzoi41071001" })
public class ContentBasicInfoForAddPage extends RootPageSimple<CnContentBasicinfoForAdd> {

}
