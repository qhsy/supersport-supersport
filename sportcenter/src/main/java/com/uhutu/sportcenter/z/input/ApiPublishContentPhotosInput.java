package com.uhutu.sportcenter.z.input;

import java.util.List;

import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.entity.ContentPhotosDetail;
import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 内容图集发布输入
 * @author pang_jhui
 *
 */
public class ApiPublishContentPhotosInput extends RootApiInput {
	
	@ApiModelProperty(value = "内容基本信息")
	private ContentBasicinfoForApi contentBasicInfo;
	
	@ApiModelProperty(value="图集详情列表")
	private List<ContentPhotosDetail> contentPhotos;

	public ContentBasicinfoForApi getContentBasicInfo() {
		return contentBasicInfo;
	}

	public void setContentBasicInfo(ContentBasicinfoForApi contentBasicInfo) {
		this.contentBasicInfo = contentBasicInfo;
	}

	public List<ContentPhotosDetail> getContentPhotos() {
		return contentPhotos;
	}

	public void setContentPhotos(List<ContentPhotosDetail> contentPhotos) {
		this.contentPhotos = contentPhotos;
	}

}
