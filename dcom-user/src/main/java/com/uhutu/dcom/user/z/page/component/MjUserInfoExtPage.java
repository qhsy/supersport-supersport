package com.uhutu.dcom.user.z.page.component;

import com.uhutu.dcom.user.z.page.vo.UcUserinfoExt;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

/**
 * 用户信息相关操作页面
 * 
 * @author pang_jhui
 *
 */
@ZooPage(name = "用户相关操作", operates = DefineZooWeb.PAGE_DIALOG_OPERATE, deploy = { DefineWebDeploy.Grid_Where
		+ "=userCode in (select code from uc_userinfo where  mj_flag='dzsd4699100110010001' )" })
public class MjUserInfoExtPage extends RootPageSimple<UcUserinfoExt> {

}
