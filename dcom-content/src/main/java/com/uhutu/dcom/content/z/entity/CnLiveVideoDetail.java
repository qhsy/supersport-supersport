package com.uhutu.dcom.content.z.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 直播副表
 * 
 * @author xiegj
 *
 */
@Entity
public class CnLiveVideoDetail extends BaseEntity {

	@ZooData(name = "房间编号", sort = { DefineWebPage.Page_Edit + "=0" })
	private String code;

	@ZooData(name = "业务编号", sort = { DefineWebPage.Page_Edit + "=0" })
	private String busiCode;

	@ZooData(name = "聊天室编号", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0",
			DefineWebPage.Page_Edit + "=0" })
	private String chatCode;

	@ZooData(name = "主播昵称", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw451010010001" }, sort = { DefineWebPage.Page_Edit + "=0" })
	private String userCode;

	@ZooData(name = "直播封面", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0",
			DefineWebPage.Page_Edit + "=0" })
	private String cover;

	@ZooData(name = "标题", sort = { DefineWebPage.Page_Edit + "=0" })
	@Column(columnDefinition = "longtext")
	private String title;

	@ZooData(name = "状态  1:正在直播,0:结束 ", sort = { DefineWebPage.Page_Edit + "=0" })
	private String status;

	@ZooData(name = "经度", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0",
			DefineWebPage.Page_Edit + "=0" })
	private String longitude;

	@ZooData(name = "维度", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0",
			DefineWebPage.Page_Edit + "=0" })
	private String latitude;

	@ZooData(name = "定位位置名称", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0",
			DefineWebPage.Page_Edit + "=0" })
	private String addressName;

	@ZooData(name = "点赞数", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Edit + "=0" })
	private long praise;

	@ZooData(name = "观看人次", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Edit + "=0" })
	private long watch;

	@ZooData(name = "时长", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Edit + "=0" })
	private int length;

	@ZooData(name = "创建时间", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Edit + "=0" })
	private String createTime;

	@ZooData(name = "结束时间", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Edit + "=0" })
	private String endTime;

	@ZooData(name = "标签编码", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw412410010002" }, sort = { DefineWebPage.Page_Query + "=0",
					DefineWebPage.Page_Edit + "=0" })
	@Column(columnDefinition = "longtext")
	private String tagCode;

	@ZooData(name = "直播流标识", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0",
			DefineWebPage.Page_Edit + "=0" })
	private String streamId;

	@ZooData(name = "文章编号", sort = { DefineWebPage.Page_Edit + "=0" })
	private String contentCode;

	@ZooData(name = "直播流地址", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Edit + "=0",
			DefineWebPage.Page_Grid + "=0" })
	private String streamUrl;

	@ZooData(name = "channelId", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Edit + "=0",
			DefineWebPage.Page_Grid + "=0" })
	private String channelId;

	@ZooData(name = "直播参数常量", sort = { DefineWebPage.Page_Query + "=0" })
	private long watchConstant;

	@ZooData(name = "直播参数常量", sort = { DefineWebPage.Page_Query + "=0" })
	private long praiseConstant;
	
	@ZooData(name="本次直播的总收入")
	private BigDecimal income = BigDecimal.ZERO;
	
	@ZooData(name="点播文件Id")
	private String videoId;
	
	@ZooData(name="点播文件地址")
	private String videoUrl;
	
	@ZooData(name="web播放地址")
	private String webStreamUrl;
	
	@ZooData(name="横屏标识", element = DefineWebElement.Select, inc = {DefineWebInc.System_Define + "=dzsd469910011001" })
	private String landScapeFlag;

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public long getWatchConstant() {
		return watchConstant;
	}

	public void setWatchConstant(long watchConstant) {
		this.watchConstant = watchConstant;
	}

	public long getPraiseConstant() {
		return praiseConstant;
	}

	public void setPraiseConstant(long praiseConstant) {
		this.praiseConstant = praiseConstant;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getTitle() {
		
		return title;
	
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public long getPraise() {
		return praise;
	}

	public void setPraise(long praise) {
		this.praise = praise;
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

	public String getTagCode() {
		return tagCode;
	}

	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}

	public String getStreamId() {
		return streamId;
	}

	public void setStreamId(String streamId) {
		this.streamId = streamId;
	}

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public String getStreamUrl() {
		return streamUrl;
	}

	public void setStreamUrl(String streamUrl) {
		this.streamUrl = streamUrl;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getBusiCode() {
		return busiCode;
	}

	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public String getWebStreamUrl() {
		return webStreamUrl;
	}

	public void setWebStreamUrl(String webStreamUrl) {
		this.webStreamUrl = webStreamUrl;
	}

	public String getLandScapeFlag() {
		return landScapeFlag;
	}

	public void setLandScapeFlag(String landScapeFlag) {
		this.landScapeFlag = landScapeFlag;
	}

}
