package com.uhutu.sportcenter.z.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 直播用户body
 * @author 逄小帅
 *
 */
public class SyncLiveUserBody {
	
	private String From_Account;
	
	private List<SyncLiveProfileItem> ProfileItem = new ArrayList<SyncLiveProfileItem>();

	public String getFrom_Account() {
		return From_Account;
	}

	public void setFrom_Account(String from_Account) {
		From_Account = from_Account;
	}

	public List<SyncLiveProfileItem> getProfileItem() {
		return ProfileItem;
	}

	public void setProfileItem(List<SyncLiveProfileItem> profileItem) {
		ProfileItem = profileItem;
	}

}
