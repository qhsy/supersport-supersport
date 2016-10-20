package com.uhutu.dcom.content.z.entity.ext;

import javax.persistence.Column;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 分享信息
 * 
 * @author xiegj
 *
 */
public class CnShareInfo extends BaseEntity {

	@ZooData(name = "分享的标签编号")
	@Column(length = 50)
	private String code;

	@ZooData(name = "分享标题")
	@Column(length = 50)
	private String title;

	@ZooData(name = "分享图片", element = DefineWebElement.Upload, require = "1", sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" })
	@Column(length = 255)
	private String cover;

	@ZooData(name = "分享链接", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	@Column(length = 255)
	private String url;

	@ZooData(name = "分享内容", require = "1", element = DefineWebElement.Textarea, sort = {
			DefineWebPage.Page_Query + "=0" })
	@Column(length = 255)
	private String aboutDesc;

	@ZooData(name = "是否分享 ", element = DefineWebElement.Select, inc = { DefineWebInc.System_Define + "=10" })
	@Column(length = 20)
	private String status;

	@ZooData(name = "备注", element = DefineWebElement.Textarea, sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" })
	@Column(length = 255)
	private String remark;

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

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAboutDesc() {
		return aboutDesc;
	}

	public void setAboutDesc(String aboutDesc) {
		this.aboutDesc = aboutDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
