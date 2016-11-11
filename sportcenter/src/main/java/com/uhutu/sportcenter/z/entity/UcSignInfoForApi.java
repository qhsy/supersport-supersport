package com.uhutu.sportcenter.z.entity;

import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 报名信息表
 * 
 * @author xiegj
 *
 */
public class UcSignInfoForApi extends BaseEntity {

	@ApiModelProperty(name = "参赛编号", value = "参赛编号")
	private String code;

	@ApiModelProperty(name = "参赛类型", value = "参赛类型 dzsd4107100510020001:个人标准,dzsd4107100510020002:个人业余,dzsd4107100510020003:团体标准")
	private String type;

	@ApiModelProperty(name = "姓名", value = "姓名dzsd4107100510010001:女,dzsd4107100510010002:男")
	private String name;

	@ApiModelProperty(name = "性别", notes = "性别")
	private String sex;

	@ApiModelProperty(name = "照片", notes = "照片")
	private String photo;

	@ApiModelProperty(name = "年龄", notes = "年龄")
	private int age;

	@ApiModelProperty(name = "身高", notes = "身高")
	private int height;

	@ApiModelProperty(name = "体重(KG)", notes = "体重(KG)")
	private int weight;

	@ApiModelProperty(name = "电话", notes = "电话")
	private String phone;

	@ApiModelProperty(name = "邮箱", notes = "邮箱")
	private String mail;

	@ApiModelProperty(name = "训练CF时间(月)", notes = "训练CF时间(月)")
	private int time;

	@ApiModelProperty(name = "所属Box", notes = "所属Box")
	private String boxName;

	@ApiModelProperty(name = "团体名称")
	private String groupName;

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

}
