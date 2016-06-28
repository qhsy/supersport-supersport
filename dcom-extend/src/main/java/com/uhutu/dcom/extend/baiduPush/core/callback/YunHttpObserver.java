package com.uhutu.dcom.extend.baiduPush.core.callback;

import com.uhutu.dcom.extend.baiduPush.core.event.YunHttpEvent;

public interface YunHttpObserver {
	
	public void onHandle(YunHttpEvent event);
	
}
