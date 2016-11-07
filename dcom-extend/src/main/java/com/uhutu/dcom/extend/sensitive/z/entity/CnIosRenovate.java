package com.uhutu.dcom.extend.sensitive.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * IOS热修复
 * 
 * @author xiegj
 *
 */
@Entity
public class CnIosRenovate extends BaseEntity {

	@ApiModelProperty(name = "启动图编号", notes = "启动图编号")
	@ZooData(name = "启动图编号", inc = DefineWebInc.Insert_Code + "=IOSBH", sort = { DefineWebPage.Page_Add + "=1",
			DefineWebPage.Page_Edit + "=0" })
	private String code;

	@ApiModelProperty(name = "版本号v1.0.0", notes = "版本号v1.0.0")
	@ZooData(name = "版本号",require="1")
	private String version;

	@ApiModelProperty(name = "下载链接", notes = "下载链接")
	@ZooData(name = "下载链接", sort = { DefineWebPage.Page_Query + "=0" })
	private String url;

	@ZooData(name = "备注", element = DefineWebElement.Textarea, sort = { DefineWebPage.Page_Query + "=0" })
	private String remark;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
