package com.uhutu.dcom.user.z.page.func;

import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

/**
 * 头衔修改
 * @author 逄小帅
 *
 */
public class UserTitlePageFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		MDataMap map = new MDataMap();
		map.put("za", input.getDataMap().get("za"));
		map.put("title", input.getDataMap().get("title"));
		UcUserinfoExt ucUserinfoExt = JdbcHelper.queryOne(UcUserinfoExt.class, "za",map.get("za"));
		
		if(ucUserinfoExt != null){
			
			map.put("user_code", ucUserinfoExt.getUserCode());
			
		}
		
		JdbcHelper.dataUpdate(extendPageDefine.getPageSource().getTableName(), map, "title", "za");
		JdbcHelper.dataUpdate("aw_answer_expert", map, "title", "user_code");
		return new WebOperateResult();
	}

	@Override
	public boolean upFlagCheck() {
		return false;
	}
}
