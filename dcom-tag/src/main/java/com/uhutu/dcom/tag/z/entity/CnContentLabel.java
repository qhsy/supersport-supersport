package com.uhutu.dcom.tag.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModel;

@Entity
@ApiModel
public class CnContentLabel extends BaseEntity {

	@ZooData(name = "标签编号", inc = DefineWebInc.Insert_Code + "=GGBH", sort = { DefineWebPage.Page_Add + "=1",
			DefineWebPage.Page_Edit + "=0" })
	private String code;

	@ZooData(name = "标签名称", require = "1")
	private String name;

	@ZooData(name = "创建用户", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0",
			DefineWebPage.Page_Edit + "=0", DefineWebPage.Page_Add + "=0" }, element = DefineWebElement.Model, inc = {
					DefineWebInc.Web_Component + "=dzcw451010010001" })
	private String type;

	@ZooData(name = "展示顺序(倒序)", require = "1", verify = { DefineWebVerify.Base_Number })
	private int sort;

	@ZooData(name = "标签类型", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd412410011001" })
	private String labelType;

	@ZooData(name = "状态(是否可用)", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd469910011001" })
	private String status;

	@ZooData(name = "封面图(宽1080)", element = DefineWebElement.Upload, require = "1", sort = {
			DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	private String cover;

	@ZooData(name = "推广内容", element = DefineWebElement.Textarea, require = "1", sort = {
			DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" }, verify = {
					DefineWebVerify.Max_Length + "=280", DefineWebVerify.Min_Length + "=2" })
	@Column(length = 300)
	private String content;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getLabelType() {
		return labelType;
	}

	public void setLabelType(String labelType) {
		this.labelType = labelType;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
