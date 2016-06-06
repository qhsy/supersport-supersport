package com.uhutu.dcom.user.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 达人信息
 * 
 * @author xiegj
 *
 */
@Entity
public class UcUserinfoExpert extends BaseEntity {

	@ZooData(name = "达人昵称", require = "1", sort = {
			DefineWebPage.Page_Query + "=0" }, element = DefineWebElement.Model, inc = {
					DefineWebInc.Web_Component + "=dzcw451010010001" })
	private String code;

	@ZooData(name = "达人真实姓名", require = "1")
	private String realName;

	@ZooData(name = "达人签名图片", element = DefineWebElement.Upload, require = "1", sort = {
			DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	private String signPic;

	@ZooData(name = "缺省排名(倒序)", require = "1", verify = { DefineWebVerify.Base_Number }, sort = {
			DefineWebPage.Page_Query + "=0" })
	private int sort;

	@ZooData(name = "封面图(564*790)", element = DefineWebElement.Upload, require = "1", sort = {
			DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	private String coverPic;

	@ZooData(name = "宣传图(750*750)", element = DefineWebElement.Upload, require = "1", sort = {
			DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	private String advPic;

	@ZooData(name = "运动经历", require = "1", element = DefineWebElement.Editor, sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" })
	private String experience;

	@ZooData(name = "分享标题", require = "1", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	private String shareTitle;

	@ZooData(name = "分享简介", require = "1", element = DefineWebElement.Textarea, sort = {
			DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	private String shareDesc;

	@ZooData(name = "分享缩略图", element = DefineWebElement.Upload, require = "1", sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" })
	private String shareIcon;

	@ZooData(name = "是否有效", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd469910011001" })
	private String status;

	@ZooData(name = "能量值", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Edit + "=0",
			DefineWebPage.Page_Add + "=0" })
	private long power;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSignPic() {
		return signPic;
	}

	public void setSignPic(String signPic) {
		this.signPic = signPic;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getPower() {
		return power;
	}

	public void setPower(long power) {
		this.power = power;
	}

	public String getCoverPic() {
		return coverPic;
	}

	public void setCoverPic(String coverPic) {
		this.coverPic = coverPic;
	}

	public String getAdvPic() {
		return advPic;
	}

	public void setAdvPic(String advPic) {
		this.advPic = advPic;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getShareTitle() {
		return shareTitle;
	}

	public void setShareTitle(String shareTitle) {
		this.shareTitle = shareTitle;
	}

	public String getShareDesc() {
		return shareDesc;
	}

	public void setShareDesc(String shareDesc) {
		this.shareDesc = shareDesc;
	}

	public String getShareIcon() {
		return shareIcon;
	}

	public void setShareIcon(String shareIcon) {
		this.shareIcon = shareIcon;
	}

}
