package com.uhutu.dcom.user.z.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.entity.UcMsgFocus;
import com.uhutu.dcom.user.z.service.IMsgFoucService;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 消息关注业务实现
 * @author 逄小帅
 *
 */
@Service
public class MsgFocusServiceImpl implements IMsgFoucService {

	@Override
	public void save(UcMsgFocus ucMsgFocus) {
		
		int count = JdbcHelper.count(UcMsgFocus.class, "", MapHelper.initMap("userCode",ucMsgFocus.getUserCode(),"msgType",ucMsgFocus.getMsgType()));
		
		if(count > 0){
			
			ucMsgFocus.setZu(new Date());
			
			JdbcHelper.update(ucMsgFocus, "status,zu", "userCode,msgType");
			
		}else{
			
			ucMsgFocus.setZc(new Date());
			
			JdbcHelper.insert(ucMsgFocus);
			
		}

	}

	@Override
	public UcMsgFocus query(String userCode, String msgType) {
		
		return JdbcHelper.queryOne(UcMsgFocus.class, "userCode",userCode,"msgType",msgType);
		
	}

}
