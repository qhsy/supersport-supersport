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
		DefineWebDeploy.Grid_Where + "=user_code in (select user_code from aw_answer_expert where status='dzsd4699100110010001')" })
public class UserInfoExtForExpertPage extends RootPageSimple<UcUserinfoExt> {

}
