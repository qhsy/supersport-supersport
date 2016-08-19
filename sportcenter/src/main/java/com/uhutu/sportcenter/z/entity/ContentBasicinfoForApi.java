package com.uhutu.sportcenter.z.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.uhutu.dcom.component.z.util.CalendarUtil;
import com.uhutu.dcom.tag.z.entity.CnContentLabel;

import io.swagger.annotations.ApiModelProperty;

/**
 * 内容基本信息数据模型
 * 
 * @author xiegj
 *
 */
public class ContentBasicinfoForApi {

	@ApiModelProperty(name = "内容编号")
	private String code;

	@ApiModelProperty(name = "内容封面图片链接", notes = "内容封面图片链接", example = "http://www.ichsy.com")
	private String cover;

	@ApiModelProperty(name = "内容封面图片宽高(此参数不用输入，只作为展示使用)", notes = "内容封面图片宽高", example = "800*600")
	private String coverWH;

	@ApiModelProperty(name = "标题", notes = "标题", example = "新体优家，您运动的首选~")
	private String title;

	@ApiModelProperty(name = "日期展示", notes = "日期展示", example = "2016-4-19")
	private Date publishTime;

	@ApiModelProperty(name = "日期格式化", notes = "日期格式化字符串", example = "MM-dd HH:mm")
	private String publishTimeStr;

	@ApiModelProperty(name = "内容简介")
	private String aboutDesc;

	@ApiModelProperty(name = "内容来源")
	private String souce;

	@ApiModelProperty(name = "内容状态", notes = " dzsd4699100110010001:正常，dzsd4699100110010002：失效")
	private String status;

	@ApiModelProperty(name = "内容分类编号")
	private String categoryCode;

	@ApiModelProperty(name = "标签编码")
	private String tagCode;

	@ApiModelProperty(name = "标签名称", notes = "多个以英文逗号分割")
	private String tagName;

	@ApiModelProperty(name = "标签", notes = "标签实体")
	private List<CnContentLabel> tags = new ArrayList<CnContentLabel>();

	@ApiModelProperty(name = "内容作者")
	private String author;

	@ApiModelProperty(name = "内容分享范围 ", notes = "dzsd4699100110010002:不公开  dzsd4699100110010001：公开")
	private String shareScope;

	@ApiModelProperty(name = "地理位置", notes = "位置经纬度(顺序：latitude,longitude)", example = "116.404, 39.915")
	private String location;

	@ApiModelProperty(name = "地理位置名称", notes = "位置名称", example = "金域国际大厦")
	private String localtionName;

	@ApiModelProperty(name = "业务类型编号：运动时刻 文章", notes = "运动时刻:dzsd4107100110020001,文章:dzsd4107100110020002")
	private String busiType;

	@ApiModelProperty(name = "展示类型", notes = " dzsd4107100110030001:文章 ,dzsd4107100110030002:文章(含视频),dzsd4107100110030003:图集,dzsd4107100110030004:单图,dzsd4107100110030005:单视频", example = "dzsd4107100110030002")
	private String contentType;

	@ApiModelProperty(value = "点赞数量")
	private int praiseNum;

	@ApiModelProperty(value = "阅读数量")
	private long readNum;

	@ApiModelProperty(value = "评论数量")
	private long remarkNum;

	@ApiModelProperty(value = "喜欢标识")
	private boolean favorFlag;

	@ApiModelProperty(value = "用户基本信息")
	private UserBasicInfo userBasicInfo = new UserBasicInfo();

	public List<CnContentLabel> getTags() {
		return tags;
	}

	public void setTags(List<CnContentLabel> tags) {
		this.tags = tags;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getAboutDesc() {
		return aboutDesc;
	}

	public void setAboutDesc(String aboutDesc) {
		this.aboutDesc = aboutDesc;
	}

	public String getSouce() {
		return souce;
	}

	public void setSouce(String souce) {
		this.souce = souce;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getTagCode() {
		return tagCode;
	}

	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getShareScope() {
		return shareScope;
	}

	public void setShareScope(String shareScope) {
		this.shareScope = shareScope;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocaltionName() {
		return localtionName;
	}

	public void setLocaltionName(String localtionName) {
		this.localtionName = localtionName;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getPublishTimeStr() {
		return publishTimeStr;
	}

	public void setPublishTimeStr(String pattern) {

		if (getPublishTime() != null) {

			this.publishTimeStr = CalendarUtil.formateTip(getPublishTime());

		}

	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public UserBasicInfo getUserBasicInfo() {
		return userBasicInfo;
	}

	public void setUserBasicInfo(UserBasicInfo userBasicInfo) {
		this.userBasicInfo = userBasicInfo;
	}

	public int getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(int praiseNum) {
		this.praiseNum = praiseNum;
	}

	public String getCoverWH() {
		return coverWH;
	}

	public void setCoverWH(String coverWH) {
		this.coverWH = coverWH;
	}

	public long getReadNum() {
		return readNum;
	}

	public void setReadNum(long readNum) {
		this.readNum = readNum;
	}

	public boolean isFavorFlag() {
		return favorFlag;
	}

	public void setFavorFlag(boolean favorFlag) {
		this.favorFlag = favorFlag;
	}

	public long getRemarkNum() {
		return remarkNum;
	}

	public void setRemarkNum(long remarkNum) {
		this.remarkNum = remarkNum;
	}

}
