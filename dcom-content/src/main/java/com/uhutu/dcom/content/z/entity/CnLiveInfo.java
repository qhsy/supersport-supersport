package com.uhutu.dcom.content.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 直播主表
 * 
 * @author xiegj
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "code" }))
public class CnLiveInfo extends BaseEntity {

	@ZooData(name = "编号", inc = DefineWebInc.Insert_Code + "=ZBFJBH", sort = { DefineWebPage.Page_Add + "=1",
			DefineWebPage.Page_Edit + "=0" })
	private String code;

	@ZooData(name = "聊天室编号", sort = { DefineWebPage.Page_Add + "=1", DefineWebPage.Page_Edit + "=0" })
	private String chatCode;

	@ZooData(name = "聊天室名称", sort = { DefineWebPage.Page_Add + "=1", DefineWebPage.Page_Edit + "=0",
			DefineWebPage.Page_Grid + "=0" })
	private String chatName;

	@ZooData(name = "主播", require = "1", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw451010010001" })
	private String userCode;

	@ZooData(name = "标题", require = "1")
	@Column(columnDefinition = "longtext")
	private String title;

	@ZooData(name = "开始时间", require = "1", element = DefineWebElement.Datehms, sort = {
			DefineWebPage.Page_Query + "=0" })
	private String createTime;

	@ZooData(name = "结束时间", require = "1", element = DefineWebElement.Datehms, sort = {
			DefineWebPage.Page_Query + "=0" })
	private String endTime;

	@ZooData(name = "状态 ", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd410710011017" })
	private String status;

	@ZooData(name = "横屏标识", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd469910011001" })
	private String landScapeFlag;

	@ZooData(name = "观看人次", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Edit + "=0",
			DefineWebPage.Page_Add + "=0" })
	private long watch;

	@ZooData(name = "时长", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Edit + "=0",
			DefineWebPage.Page_Add + "=0" })
	private int length;

	@ZooData(name = "推流地址", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Edit + "=0",
			DefineWebPage.Page_Grid + "=0", DefineWebPage.Page_Add + "=0" })
	private String pushStreamUrl;

	@ZooData(name = "RTMP播放地址", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Edit + "=0",
			DefineWebPage.Page_Grid + "=0", DefineWebPage.Page_Add + "=0" })
	private String rtmpPlayUrl;

	@ZooData(name = "FLV播放地址", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Edit + "=0",
			DefineWebPage.Page_Grid + "=0", DefineWebPage.Page_Add + "=0" })
	private String flvPlayUrl;

	@ZooData(name = "HLS播放地址", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Edit + "=0",
			DefineWebPage.Page_Grid + "=0", DefineWebPage.Page_Add + "=0" })
	private String hlsPlayUrl;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getChatName() {
		return chatName;
	}

	public void setChatName(String chatName) {
		this.chatName = chatName;
	}

	public String getChatCode() {
		return chatCode;
	}

	public void setChatCode(String chatCode) {
		this.chatCode = chatCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLandScapeFlag() {
		return landScapeFlag;
	}

	public void setLandScapeFlag(String landScapeFlag) {
		this.landScapeFlag = landScapeFlag;
	}

	public long getWatch() {
		return watch;
	}

	public void setWatch(long watch) {
		this.watch = watch;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getPushStreamUrl() {
		return pushStreamUrl;
	}

	public void setPushStreamUrl(String pushStreamUrl) {
		this.pushStreamUrl = pushStreamUrl;
	}

	public String getRtmpPlayUrl() {
		return rtmpPlayUrl;
	}

	public void setRtmpPlayUrl(String rtmpPlayUrl) {
		this.rtmpPlayUrl = rtmpPlayUrl;
	}

	public String getFlvPlayUrl() {
		return flvPlayUrl;
	}

	public void setFlvPlayUrl(String flvPlayUrl) {
		this.flvPlayUrl = flvPlayUrl;
	}

	public String getHlsPlayUrl() {
		return hlsPlayUrl;
	}

	public void setHlsPlayUrl(String hlsPlayUrl) {
		this.hlsPlayUrl = hlsPlayUrl;
	}

}
