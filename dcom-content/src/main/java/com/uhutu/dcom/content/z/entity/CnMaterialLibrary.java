package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebSort;
import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 图片详情
 * 
 * @author xiegj
 *
 */
@Entity
public class CnMaterialLibrary extends BaseEntity {
	@ZooData(name = "编号", inc = { DefineWebInc.Insert_Code + "=SCKBH", DefineWebInc.Url_Param + "=code" }, sort = {
			DefineWebPage.Page_Add + "=1", DefineWebPage.Page_Edit + "=" + DefineWebSort.Sort_Process })
	@ApiModelProperty(name = "编号", notes = "编号", example = "ADBH0001")
	private String code;

	@ZooData(name = "标题", require = "1")
	@ApiModelProperty(name = "标题", notes = "标题")
	private String title;

	@ZooData(name = "素材", require = "1", element = DefineWebElement.UploadAli, sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" })
	@ApiModelProperty(name = "素材", notes = "素材", example = "http://www.ichsy.com")
	private String url;

	@ZooData(name = "跳转类型", require = "1", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd410710011018" }, comment = "")
	private String piclinkType;

	@ZooData(name = "跳转参数", require = "1")
	@ApiModelProperty(name = "跳转参数", notes = "跳转参数", example = "http://www.ichsy.com")
	private String piclinkContent;

	@ZooData(name = "跳转后标题", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	@ApiModelProperty(name = "跳转后标题", notes = "跳转后标题", example = "http://www.ichsy.com")
	private String contentTitle;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPiclinkType() {
		return piclinkType;
	}

	public void setPiclinkType(String piclinkType) {
		this.piclinkType = piclinkType;
	}

	public String getPiclinkContent() {
		return piclinkContent;
	}

	public void setPiclinkContent(String piclinkContent) {
		this.piclinkContent = piclinkContent;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	
	
}
