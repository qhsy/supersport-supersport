package com.uhutu.sportcenter.z.input;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Base64Utils;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 发布评论输入参数
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiPublishRemarkInput extends RootApiInput {
	
	@ApiModelProperty(value="内容编号",notes="内容编号",required=true)
	private String contentCode;
	
	@ApiModelProperty(value="评论内容",notes="评论内容",required=true)
	private String remark;
	
	@ApiModelProperty(value="父级评论编号",notes="针对评论的评论",required=true)
	private String parentCode;

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public String getRemark() {
		
		if(StringUtils.isNotEmpty(remark)){
			
			byte[] decodeByte = Base64Utils.decode(remark.getBytes());
			
			remark = new String(decodeByte);
			
		}
		
		return remark;
	}

	public void setRemark(String remark) {
		
		String encodeStr = "";
		
		if(StringUtils.isNotEmpty(remark)){
			
			byte[] encodeByte = Base64Utils.encode(remark.getBytes());
			
			encodeStr = new String(encodeByte);
			
		}
		
		this.remark = encodeStr;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	
	

}
