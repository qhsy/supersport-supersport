package com.uhutu.dcom.user.z.page;

import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

/**
 * 运营账户相关
 * 
 * @author xiegj
 *
 */
@ZooPage(name = "马甲账号", pages = { DefineZooWeb.PAGE_DEFAULT_SUB }, operates = { DefineZooWeb.PAGE_DEFAULT_OPERATE,
		DefineWebPage.Page_Grid + "=dzoi41101002", DefineWebPage.Page_Add + "=dzoi41101003" }, deploy = {
				DefineWebDeploy.Url_Query + "=code", DefineWebDeploy.Grid_Where + "=mjFlag='dzsd4699100110010001' ", })
public class UserInfoMaJiaPage extends RootPageSimple<UcUserinfo> {

}
