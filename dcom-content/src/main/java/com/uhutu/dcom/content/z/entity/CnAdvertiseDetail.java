package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
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
public class CnAdvertiseDetail extends BaseEntity {
	@ZooData(name = "编号", inc = { DefineWebInc.Insert_Code + "=GGTBH", DefineWebInc.Url_Param + "=code" }, sort = {
			DefineWebPage.Page_Add + "=1", DefineWebPage.Page_Edit + "=" + DefineWebSort.Sort_Process })
	@ApiModelProperty(name = "编号", notes = "编号", example = "ADBH0001")
	private String code;

	@ZooData(name = "标题", require = "1")
	@ApiModelProperty(name = "标题", notes = "标题")
	private String title;

	@ZooData(name = "副标题", require = "1")
	@ApiModelProperty(name = "副标题", notes = "副标题")
	private String ptitle;

	@ZooData(name = "地址", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	@ApiModelProperty(name = "地址", notes = "地址", example = "http://www.ichsy.com")
	private String url;

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

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
