package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.dcom.search.z.entity.VideoData;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 搜索视频结果
 * @author 逄小帅
 *
 */
public class ApiSearchVideoResult extends RootApiResult {
	
	@ApiModelProperty(name="是否存在下一页数据",value="是否存在下一页数据",example="true")
	private boolean  nextPageFlag= false;
	
	@ApiModelProperty(value="查询数据")
	private List<VideoData> videoDatas = new ArrayList<VideoData>();

	public boolean isNextPageFlag() {
		return nextPageFlag;
	}

	public void setNextPageFlag(boolean nextPageFlag) {
		this.nextPageFlag = nextPageFlag;
	}

	public List<VideoData> getVideoDatas() {
		return videoDatas;
	}

	public void setVideoDatas(List<VideoData> videoDatas) {
		this.videoDatas = videoDatas;
	}

	
}
