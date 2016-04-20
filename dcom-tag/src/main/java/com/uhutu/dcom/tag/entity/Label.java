package com.uhutu.dcom.tag.entity;

import javax.persistence.Entity;
import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel
public class Label extends BaseEntity{

	@ZooData(name = "标签编号")
	@ApiModelProperty(name="标签编号" ,notes="标签编号",example="lb001")
	private String labelCode="";
	
	@ZooData(name = "标签名称")
	@ApiModelProperty(name="标签" ,notes="标签",example="极限运动")
	private String labelName="";

	public String getLabelCode() {
		return labelCode;
	}

	public void setLabelCode(String labelCode) {
		this.labelCode = labelCode;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	
}
