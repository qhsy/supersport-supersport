package com.uhutu.dcom.user.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 报名信息表
 * 
 * @author xiegj
 *
 */
@Entity
public class UcSignInfo extends BaseEntity {

	@ApiModelProperty(name = "参赛编号", notes = "参赛编号")
	@ZooData(name = "参赛编号", sort = { DefineWebPage.Page_Add + "=0", DefineWebPage.Page_Edit + "=0" })
	@Column(length = 50)
	private String code;

	@ApiModelProperty(name = "参赛类型", notes = "参赛类型")
	@ZooData(name = "参赛类型", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd410710051002" })
	@Column(length = 50)
	private String type;

	@ZooData(name = "状态", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd411210011003" }, sort = { DefineWebPage.Page_Add + "=0",
					DefineWebPage.Page_Edit + "=0" })
	@Column(length = 30)
	private String status;

	@ApiModelProperty(name = "姓名", notes = "姓名")
	@ZooData(name = "姓名", require = "1")
	@Column(length = 255)
	private String name;

	@ApiModelProperty(name = "性别", notes = "性别")
	@ZooData(name = "性别", require = "1", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd410710051001" })
	@Column(length = 255)
	private String sex;

	@ApiModelProperty(name = "照片", notes = "照片")
	@ZooData(name = "照片", require = "1", sort = { DefineWebPage.Page_Add + "=0", DefineWebPage.Page_Edit + "=0",
			DefineWebPage.Page_Grid + "=0", DefineWebPage.Page_Query + "=0" })
	@Column(length = 255)
	private String photo;

	@ApiModelProperty(name = "年龄", notes = "年龄")
	@ZooData(name = "年龄", require = "1", sort = { DefineWebPage.Page_Add + "=0", DefineWebPage.Page_Edit + "=0",
			DefineWebPage.Page_Query + "=0" })
	@Column(length = 255)
	private int age;

	@ApiModelProperty(name = "身高", notes = "身高")
	@ZooData(name = "身高", require = "1", sort = { DefineWebPage.Page_Add + "=0", DefineWebPage.Page_Edit + "=0",
			DefineWebPage.Page_Query + "=0" })
	@Column(length = 255)
	private int height;

	@ApiModelProperty(name = "体重(KG)", notes = "体重(KG)")
	@ZooData(name = "体重(KG)", require = "1", sort = { DefineWebPage.Page_Add + "=0", DefineWebPage.Page_Edit + "=0",
			DefineWebPage.Page_Query + "=0" })
	@Column(length = 255)
	private int weight;

	@ApiModelProperty(name = "电话", notes = "电话")
	@ZooData(name = "电话", require = "1", sort = { DefineWebPage.Page_Add + "=0", DefineWebPage.Page_Edit + "=0",
			DefineWebPage.Page_Query + "=0" })
	@Column(length = 255)
	private String phone;

	@ApiModelProperty(name = "邮箱", notes = "邮箱")
	@ZooData(name = "邮箱", require = "1", sort = { DefineWebPage.Page_Add + "=0", DefineWebPage.Page_Edit + "=0",
			DefineWebPage.Page_Query + "=0" })
	private String mail;

	@ApiModelProperty(name = "训练CF时间(月)", notes = "训练CF时间(月)")
	@ZooData(name = "训练CF时间(月)", require = "1", sort = { DefineWebPage.Page_Add + "=0", DefineWebPage.Page_Edit + "=0",
			DefineWebPage.Page_Query + "=0" })
	private int time;

	@ApiModelProperty(name = "所属Box", notes = "所属Box")
	@ZooData(name = "所属Box", require = "1", sort = { DefineWebPage.Page_Add + "=0", DefineWebPage.Page_Edit + "=0",
			DefineWebPage.Page_Grid + "=0", DefineWebPage.Page_Query + "=0" })
	private String boxName;

	@ZooData(name = "用户昵称", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw451010010001" }, sort = { DefineWebPage.Page_Add + "=0",
					DefineWebPage.Page_Edit + "=0", DefineWebPage.Page_Query + "=0" })
	@Column(length = 50)
	private String userCode;

	@ZooData(name = "活动名称", require = "1", sort = { DefineWebPage.Page_Add + "=0", DefineWebPage.Page_Edit + "=0",
			DefineWebPage.Page_Grid + "=0" })
	private String activityName;

	@ZooData(name = "运营备注", element = DefineWebElement.Textarea, sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" })
	@Column(length = 255)
	private String remark;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getBoxName() {
		return boxName;
	}

	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
