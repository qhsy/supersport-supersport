package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

		public class ApiSupportPraiseInput extends RootApiInput {
		@ApiModelProperty(value = "评价类型", notes = "评价类型01:么么哒，02:嘘嘘 现在只支持么么哒",required=true, example = "01")
		private String type = "";
		
		@ApiModelProperty(value = "评价内容编号", notes = "评价内容编号",required=true, example = "MeiZi666")
		private String contentCode = "";
		
		@ApiModelProperty(value = "是否喜欢", notes = "不喜欢:0,喜欢：1",required=true, example = "1")
		private String isLike = "0";

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getContentCode() {
			return contentCode;
		}

		public void setContentCode(String contentCode) {
			this.contentCode = contentCode;
		}

		public String getIsLike() {
			return isLike;
		}

		public void setIsLike(String isLike) {
			this.isLike = isLike;
		}

}
