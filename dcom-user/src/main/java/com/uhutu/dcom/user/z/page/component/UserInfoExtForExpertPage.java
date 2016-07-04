package com.uhutu.dcom.user.z.page.component;

import com.uhutu.dcom.user.z.page.vo.UcUserinfoExt;
import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.root.RootPageSimple;
import com.uhutu.zooweb.define.DefineZooWeb;

/**
 * 达人用户信息相关操作页面
 * 
 * @author xigj
 *
 */
@ZooPage(name = "达人选择", operates = DefineZooWeb.PAGE_DIALOG_OPERATE, deploy = {
		DefineWebDeploy.Grid_Where + "=user_code in (select code from uc_userinfo where type='dzsd4107100310010002')" })
public class UserInfoExtForExpertPage extends RootPageSimple<UcUserinfoExt> {

}
