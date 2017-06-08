package com.uhutu.dcom.content.z.support;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.component.z.util.WebClientComponent;
import com.uhutu.dcom.content.z.support.compent.TecentChatRoomAddMemberresponse;
import com.uhutu.dcom.content.z.support.compent.TecentChatRoomInfo;
import com.uhutu.dcom.content.z.support.compent.TecentChatRoomResponse;
import com.uhutu.dcom.content.z.support.compent.TecentChatRoomRootApiResult;
import com.uhutu.dcom.pay.z.entity.PaInclogInfo;
import com.uhutu.dcom.user.z.properties.ConfigDcomUser;
import com.uhutu.dcom.user.z.properties.SettingsDcomUser;
import com.uhutu.dcom.user.z.support.TecentSigSupport;
import com.uhutu.zoocom.helper.GsonHelper;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 
 * @author Administrator
 * 
 *         聊天室
 *
 */
public class LiveChatRoomSupport {

	private static LiveChatRoomSupport support = null;

	public static LiveChatRoomSupport Instance() {
		if (support == null) {
			support = new LiveChatRoomSupport();
		}
		return support;
	}

	/**
	 * 创建聊天室
	 * 
	 * @param chatName
	 * @param userCode
	 * @return
	 */
	public TecentChatRoomRootApiResult createRoom(String chatName, String userCode) {
		TecentChatRoomRootApiResult result = new TecentChatRoomRootApiResult();
		SettingsDcomUser settingsDcomUser = ConfigDcomUser.upConfig();
		String userSig = new TecentSigSupport().upSigCodeByUserCode(settingsDcomUser.getTlsTecentAdmin());

		String url = settingsDcomUser.getLoginSdkUrl() + "/v4/group_open_http_svc/create_group?usersig=" + userSig
				+ "&identifier=" + settingsDcomUser.getTlsTecentAdmin() + "&sdkappid="
				+ settingsDcomUser.getTlsSkdAppid() + "&random=99999999&contenttype=json";
		TecentChatRoomInfo tecentUserInfo = new TecentChatRoomInfo();
		tecentUserInfo.setName(chatName);
		tecentUserInfo.setOwner_Account(userCode);
		tecentUserInfo.setType("AVChatRoom");
		String jsonStr = GsonHelper.toJson(tecentUserInfo);
		PaInclogInfo paInclogInfo = new PaInclogInfo();
		try {
			String returnStr = WebClientComponent.upRequest(url, jsonStr);
			paInclogInfo.setResponseData(returnStr);
			String temp = EmojiUtil.emojiFilter(jsonStr);
			paInclogInfo.setRequestData(temp);
			TecentChatRoomResponse response = new TecentChatRoomResponse();
			response = GsonHelper.fromJson(returnStr, response);
			if (!"OK".equals(response.getActionStatus())) {
				result.setError(chatName + returnStr);
				result.setStatus(0);
			} else {
				result.setGroupId(response.getGroupId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		paInclogInfo.setBusiCode(chatName);
		paInclogInfo.setIncType("create_group");
		paInclogInfo.setZc(new Date());
		JdbcHelper.insert(paInclogInfo);

		return result;
	}

	/**
	 * 增加聊天室成员
	 * 
	 * @param groupId
	 * @param userCode多个用逗号隔开
	 * @return
	 */
	public TecentChatRoomRootApiResult addMember(String groupId, String userCode) {
		TecentChatRoomRootApiResult result = new TecentChatRoomRootApiResult();
		SettingsDcomUser settingsDcomUser = ConfigDcomUser.upConfig();
		String userSig = new TecentSigSupport().upSigCodeByUserCode(settingsDcomUser.getTlsTecentAdmin());

		String url = settingsDcomUser.getLoginSdkUrl() + "/v4/group_open_http_svc/add_group_member?usersig=" + userSig
				+ "&identifier=" + settingsDcomUser.getTlsTecentAdmin() + "&sdkappid="
				+ settingsDcomUser.getTlsSkdAppid() + "&random=99999999&contenttype=json";
		List<MDataMap> memberList = new ArrayList<MDataMap>();
		for (int i = 0; i < userCode.split(",").length; i++) {
			memberList.add(MapHelper.initMap("Member_Account", userCode.split(",")[i]));
		}
		String jsonStr = GsonHelper.toJson(
				MapHelper.initMap("GroupId", groupId, "Silence", "1", "MemberList", GsonHelper.toJson(memberList)));
		PaInclogInfo paInclogInfo = new PaInclogInfo();
		try {
			String returnStr = WebClientComponent.upRequest(url, jsonStr);
			paInclogInfo.setResponseData(returnStr);
			String temp = EmojiUtil.emojiFilter(jsonStr);
			paInclogInfo.setRequestData(temp);
			TecentChatRoomResponse response = new TecentChatRoomResponse();
			response = GsonHelper.fromJson(returnStr, response);
			if (!"OK".equals(response.getActionStatus())) {
				for (int i = 0; i < response.getMemberList().size(); i++) {
					TecentChatRoomAddMemberresponse addMemberresponse = response.getMemberList().get(i);
					if ("0".equals(addMemberresponse.getResult())) {
						result.setError(result.getError() + ":" + addMemberresponse.getMember_Account());
					}
				}
				result.setStatus(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		paInclogInfo.setBusiCode(groupId);
		paInclogInfo.setIncType("create_group");
		paInclogInfo.setZc(new Date());
		JdbcHelper.insert(paInclogInfo);
		return result;
	}

	/**
	 * 解散群组
	 * 
	 * @param groupId
	 * @return
	 */
	public TecentChatRoomRootApiResult destoryGroup(String groupId) {
		TecentChatRoomRootApiResult result = new TecentChatRoomRootApiResult();
		SettingsDcomUser settingsDcomUser = ConfigDcomUser.upConfig();
		String userSig = new TecentSigSupport().upSigCodeByUserCode(settingsDcomUser.getTlsTecentAdmin());

		String url = settingsDcomUser.getLoginSdkUrl() + "/v4/group_open_http_svc/destroy_group?usersig=" + userSig
				+ "&identifier=" + settingsDcomUser.getTlsTecentAdmin() + "&sdkappid="
				+ settingsDcomUser.getTlsSkdAppid() + "&random=99999999&contenttype=json";
		String jsonStr = GsonHelper.toJson(MapHelper.initMap("GroupId", groupId));
		PaInclogInfo paInclogInfo = new PaInclogInfo();
		try {
			String returnStr = WebClientComponent.upRequest(url, jsonStr);
			paInclogInfo.setResponseData(returnStr);
			String temp = EmojiUtil.emojiFilter(jsonStr);
			paInclogInfo.setRequestData(temp);
			TecentChatRoomResponse response = new TecentChatRoomResponse();
			response = GsonHelper.fromJson(returnStr, response);
			if (!"OK".equals(response.getActionStatus())) {
				result.setError(groupId + ":" + response);
				result.setStatus(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		paInclogInfo.setBusiCode(groupId);
		paInclogInfo.setIncType("create_group");
		paInclogInfo.setZc(new Date());
		JdbcHelper.insert(paInclogInfo);
		return result;
	}

}
