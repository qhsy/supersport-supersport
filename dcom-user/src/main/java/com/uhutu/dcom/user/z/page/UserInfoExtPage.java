package com.uhutu.dcom.user.z.page;

import com.uhutu.dcom.user.z.page.vo.UcUserinfoExt;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

/**
 * 用户信息相关操作页面
 * 
 * @author pang_jhui
 *
 */
@ZooPage(name = "详情", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Query + "=dzoi4699100110171001",
		DefineWebPage.Page_Grid + "=dzoi4699100110091001",DefineWebPage.Page_Edit + "=dzoi41101010"}, deploy = { DefineWebDeploy.Url_Query + "=userCode" })
public class UserInfoExtPage extends RootPageSimple<UcUserinfoExt> {

}
