package com.uhutu.dcom.user.z.page.func;

import com.uhutu.dcom.user.z.entity.UcAttentionInfo;
import com.uhutu.dcom.user.z.enums.MsgEnum;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class UcAttentionInfoPageFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		UcAttentionInfo info = JdbcHelper.queryOne(UcAttentionInfo.class, "attention",
				input.getDataMap().get("attention"), "be_attention", input.getDataMap().get("be_attention"));
		if (info != null && "1".equals(info.getStatus())) {
			result.setStatus(81100012);
			result.setError(TopHelper.upInfo(81100012));
		} else if (info != null && "0".equals(info.getStatus())) {
			info.setStatus("1");
			JdbcHelper.update(info, "status", "za");
			saveMsgAttention(info);
		}
		if (info == null && result.upFlagTrue()) {
			info = new UcAttentionInfo();
			info.setAttention(input.getDataMap().get("attention"));
			info.setBeAttention(input.getDataMap().get("be_attention"));
			info.setStatus("1");
			JdbcHelper.insert(info);
			saveMsgAttention(info);
		}
		return result;
	}

	private void saveMsgAttention(UcAttentionInfo attentionInfo) {
		MDataMap mm = new MDataMap();
		mm.put("attn_userCode", attentionInfo.getBeAttention());
		mm.put("fans_userCode", attentionInfo.getAttention());
		mm.put("msg_time", DateHelper.upNow());
		mm.put("msg_title", "关注了您");
		mm.put("status", MsgEnum.FLAG_UNREAD.getCode());
		JdbcHelper.dataInsert("UcMsgAttention", mm);
	}
}
