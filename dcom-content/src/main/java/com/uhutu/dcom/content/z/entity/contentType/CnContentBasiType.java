package com.uhutu.dcom.content.z.entity.contentType;

import javax.persistence.Column;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebSort;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 内容类型保存使用
 * 
 * @author xiegj
 *
 */
public class CnContentBasiType extends BaseEntity {

	@ZooData(name = "内容类型编号", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0",
			DefineWebPage.Page_Add + "=" + DefineWebSort.Sort_Process,
			DefineWebPage.Page_Edit + "=" + DefineWebSort.Sort_Process }, inc = DefineWebInc.Url_Param + "=code")
	@Column(length = 50)
	private String code;

	@ZooData(name = "文章信息", require = "1", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw410710010017" })
	@Column(length = 50)
	private String contentCode;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

}
