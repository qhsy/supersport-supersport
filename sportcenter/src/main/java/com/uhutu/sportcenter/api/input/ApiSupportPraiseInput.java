package com.uhutu.sportcenter.api.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

		public class ApiSupportPraiseInput extends RootApiInput {
		@ApiModelProperty(value = "评价类型", notes = "评价类型01:么么哒，02:嘘嘘 现在只支持么么哒",required=true, example = "01")
		private String praiseType = "";
		
		@ApiModelProperty(value = "评价内容编号", notes = "评价内容编号",required=true, example = "MeiZi666")
		private String contentCode = "";
		
		@ApiModelProperty(value = "取消么么哒或者嘘嘘", notes = "取消么么哒或者嘘嘘",required=true, example = "true")
		private boolean cancelFlag = false;
}
