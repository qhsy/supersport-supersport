package com.uhutu.dcom.activity.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 活动基本信息数据模型
 * 
 * @author xiegj
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "code" }), indexes = { @Index(columnList = "code") })
public class AcActivityInfo extends BaseEntity {

	@ZooData(name = "活动编号")
	@Column(length = 50)
	private String code;

	@ZooData(name = "活动类型", sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" }, element = DefineWebElement.Model, inc = {
					DefineWebInc.Web_Component + "=dzcw410710010004" })
	@Column(length = 50)
	private String type;

	@ZooData(name = "开始时间", element = DefineWebElement.Datehms, require = "1")
	@Column(length = 20)
	private String startTime;

	@ZooData(name = "结束时间", element = DefineWebElement.Datehms, require = "1")
	@Column(length = 20)
	private String endTime;

	@ZooData(name = "定位经纬度")
	@Column(length = 30)
	private String placeLal;

	@ZooData(name = "定位位置名称")
	@Column(length = 255)
	private String placeName;

	@ZooData(name = "活动所在城市")
	@Column(length = 20)
	private String cityCode;

	@ZooData(name = "费用")
	private long price;

	@ZooData(name = "报名截止时间", element = DefineWebElement.Datehms, require = "1")
	private String closeTime;

	@ZooData(name = "人数")
	private long num;

	@ZooData(name = "是否官方推荐", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd469910011001" })
	@Column(length = 30)
	private String recommenFlag;

	@ZooData(name = "活动状态", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd411310011001" }, sort = { DefineWebPage.Page_Add + "=0",
					DefineWebPage.Page_Edit + "=0" })
	@Column(length = 30)
	private String status;

	@ZooData(name = "推荐语", verify = {
			DefineWebVerify.Max_Length + "=12" }, element = DefineWebElement.Textarea, sort = {
					DefineWebPage.Page_Query + "=0" })
	@Column(length = 50)
	private String recommendation;

	@ZooData(name = "活动发起人", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Add + "=0",
			DefineWebPage.Page_Edit + "=0" })
	@Column(length = 50)
	private String author;

	@ZooData(name = "备注", element = DefineWebElement.Textarea, sort = { DefineWebPage.Page_Query + "=0" })
	@Column(length = 255)
	private String remark;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRecommenFlag() {
		return recommenFlag;
	}

	public void setRecommenFlag(String recommenFlag) {
		this.recommenFlag = recommenFlag;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getPlaceLal() {
		return placeLal;
	}

	public void setPlaceLal(String placeLal) {
		this.placeLal = placeLal;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
